package com.wll.examplemvvm.base;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.wll.examplemvvm.bean.basebean.ParamsBuilder;
import com.wll.examplemvvm.bean.basebean.Resource;
import com.wll.examplemvvm.bean.basebean.ResponModel;
import com.wll.examplemvvm.retrofitrxjava.Interceptor.NetCacheInterceptor;
import com.wll.examplemvvm.retrofitrxjava.Interceptor.OfflineCacheInterceptor;
import com.wll.examplemvvm.retrofitrxjava.RetrofitApiService;
import com.wll.examplemvvm.retrofitrxjava.RetrofitManager;
import com.wll.examplemvvm.retrofitrxjava.downloadutils.DownFileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 这是model层的基类，封装这层的原因是，减少大量重复性工作
 */
public abstract class BaseModel {
    //防止rxjava
    public LifecycleTransformer objectLifecycleTransformer;
    //记录有没有联网
    public ArrayList<String> onNetTags;

    /**
     * 获取retrofit的service实例
     * @return
     */
    public RetrofitApiService getApiService() {
        return RetrofitManager.getRetrofitManager().getApiService();
    }

    /**
     * 获取防止rxjava 的objectLifecycleTransformer的实例
     * @param objectLifecycleTransformer
     */
    public void setObjectLifecycleTransformer(LifecycleTransformer objectLifecycleTransformer) {
        this.objectLifecycleTransformer = objectLifecycleTransformer;
    }

    /**
     * 设置联网tag
     * @param onNetTags
     */
    public void setOnNetTags(ArrayList<String> onNetTags) {
        this.onNetTags = onNetTags;
    }

    /**
     * 把统一操作全部放在这，不会重连
     * @param observable
     * @param liveData
     * @param <T>
     * @return
     */
    public <T> MutableLiveData<T> observeGo(Observable observable, final MutableLiveData<T> liveData) {
        return observe(observable, liveData, null);
    }

    /**
     * 判断需不需要重连
     * @param observable 请求返回的观察者
     * @param liveData 是一个有生命周期感知 & 可观察的数据持有者类
     * @param paramsBuilder 参数帮助类  ui 显示
     * @param <T>
     * @return
     */
    public <T> MutableLiveData<T> observeGo(Observable observable, final MutableLiveData<T> liveData, ParamsBuilder paramsBuilder) {

        if (paramsBuilder == null) {
            paramsBuilder = ParamsBuilder.build();
        }
        int retryCount = paramsBuilder.getRetryCount();
        if (retryCount > 0) {
            return observeWithRetry(observable, liveData, paramsBuilder);
        } else {
            return observe(observable, liveData, paramsBuilder);
        }
    }


    //把统一操作全部放在这，不会重连
    public <T> MutableLiveData<T> observe(Observable observable, final MutableLiveData<T> liveData, ParamsBuilder paramsBuilder) {
        if (paramsBuilder == null) {
            paramsBuilder = paramsBuilder.build();
        }
        final boolean showDialog = paramsBuilder.isShowDialog();//是否显示加载loading
        final String loadingMessage = paramsBuilder.getLoadingMessage();//进度条显示文字
        int onlineCacheTime = paramsBuilder.getOnlineCacheTime();//在线缓存时间
        int offlineCacheTime = paramsBuilder.getOfflineCacheTime();//离线缓存时间

        if (onlineCacheTime > 0) {
            setOnlineCacheTime(onlineCacheTime);
        }
        if (offlineCacheTime > 0) {
            setOfflineCacheTime(offlineCacheTime);
        }
        final String oneTag = paramsBuilder.getOneTag();
        if (!TextUtils.isEmpty(oneTag)) {
            if (onNetTags.contains(oneTag)) {
                return liveData;
            }
        }
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (!TextUtils.isEmpty(oneTag)) {
                            onNetTags.add(oneTag);
                        }
                        if (showDialog) {
                            liveData.postValue((T) Resource.loading(loadingMessage));
                        }
                    }
                }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                if (!TextUtils.isEmpty(oneTag)) {
                    onNetTags.remove(oneTag);
                }
            }
        }).observeOn(AndroidSchedulers.mainThread())
                //防止rxJava 内存溢出
                .compose(objectLifecycleTransformer)
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        liveData.postValue((T) Resource.response((ResponModel<Object>) o));
                        if (!TextUtils.isEmpty(oneTag)) {
                            onNetTags.remove(oneTag);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        liveData.postValue((T) Resource.error(throwable));
                        if (!TextUtils.isEmpty(oneTag)) {
                            onNetTags.remove(oneTag);
                        }
                    }
                });

//        observable.subscribeOn(Schedulers.io())
//                .doOnSubscribe(disposable1 -> {
//                    if (!TextUtils.isEmpty(oneTag)) {
//                        onNetTags.add(oneTag);
//                    }
//                    if (showDialog) {
//                        liveData.postValue((T) Resource.loading(loadingMessage));
//                    }
//                })
//                .doFinally(() -> {
//                    if (!TextUtils.isEmpty(oneTag)) {
//                        onNetTags.remove(oneTag);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(objectLifecycleTransformer)
//                .subscribe(o -> {
//                    liveData.postValue((T) Resource.response((ResponModel<Object>) o));
//                }, throwable -> {
//                    liveData.postValue((T) Resource.error((Throwable) throwable));
//                });

        return liveData;
    }


    //把统一操作全部放在这，这是带重连的
    @SuppressLint("CheckResult")
    public <T> MutableLiveData<T> observeWithRetry(Observable observable, final MutableLiveData<T> liveData, ParamsBuilder paramsBuilder) {
        if (paramsBuilder == null) {
            paramsBuilder = paramsBuilder.build();
        }
        final boolean showDialog = paramsBuilder.isShowDialog();
        final String loadingMessage = paramsBuilder.getLoadingMessage();
        int onlineCacheTime = paramsBuilder.getOnlineCacheTime();
        int offlineCacheTime = paramsBuilder.getOfflineCacheTime();

        if (onlineCacheTime > 0) {
            setOnlineCacheTime(onlineCacheTime);
        }
        if (offlineCacheTime > 0) {
            setOfflineCacheTime(offlineCacheTime);
        }

        final String oneTag = paramsBuilder.getOneTag();
        if (!TextUtils.isEmpty(oneTag)) {
            if (onNetTags.contains(oneTag)) {
                return liveData;
            }
        }

        final int maxCount = paramsBuilder.getRetryCount();
        final int[] currentCount = {0};

//        Disposable disposable = observable.subscribeOn(Schedulers.io())
//                .retryWhen(throwable -> {
//                    //如果还没到次数，就延迟5秒发起重连
//                    if (currentCount[0] <= maxCount) {
//                        currentCount[0]++;
//                        return Observable.just(1).delay(5000, TimeUnit.MILLISECONDS);
//                    } else {
//                        //到次数了跑出异常
//                        return Observable.error(new Throwable("重连次数已达最高,请求超时"));
//                    }
//                })
//                .doOnSubscribe(disposable1 -> {
//                    if (!TextUtils.isEmpty(oneTag)) {
//                        onNetTags.add(oneTag);
//                    }
//                    if (showDialog) {
//                        liveData.postValue((T) Resource.loading(loadingMessage));
//                    }
//                })
//                .doFinally(() -> {
//                    if (!TextUtils.isEmpty(oneTag)) {
//                        onNetTags.remove(oneTag);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(objectLifecycleTransformer)
//                .subscribe(o -> {
//                    liveData.postValue((T) Resource.response((ResponModel<Object>) o));
//                }, throwable -> {
//                    liveData.postValue((T) Resource.error((Throwable) throwable));
//                });

        observable.subscribeOn(Schedulers.io())
                //重连
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                        // 如果还没到次数，就延迟5秒发起重连
                        if (currentCount[0] <= maxCount) {
                            currentCount[0]++;
                            return Observable.just(1).delay(5000, TimeUnit.MILLISECONDS);
                        } else {
                            //到次数了跑出异常
                            return Observable.error(new Throwable("重连次数已达最高,请求超时"));
                        }
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                if (!TextUtils.isEmpty(oneTag)) {
                    onNetTags.add(oneTag);
                }
                if (showDialog) {
                    liveData.postValue((T) Resource.loading(loadingMessage));
                }
            }
        })
                //失败的时候访问
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (!TextUtils.isEmpty(oneTag)) {
                            onNetTags.remove(oneTag);
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(objectLifecycleTransformer)
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        liveData.postValue((T) Resource.response((ResponModel<Object>) o));
                        if (!TextUtils.isEmpty(oneTag)) {
                            onNetTags.remove(oneTag);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        liveData.postValue((T) Resource.error(throwable));
                        if (!TextUtils.isEmpty(oneTag)) {
                            onNetTags.remove(oneTag);
                        }
                    }
                });

        return liveData;
    }


    //设置在线网络缓存
    public void setOnlineCacheTime(int time) {
        NetCacheInterceptor.getInstance().setOnlineTime(time);
    }

    //设置离线网络缓存
    public void setOfflineCacheTime(int time) {
        OfflineCacheInterceptor.getInstance().setOfflineCacheTime(time);
    }

    //正常下载(重新从0开始下载)
    public <T> MutableLiveData<T> downLoadFile(Observable observable, final MutableLiveData<T> liveData, final String destDir, final String fileName) {
        return downLoadFile(observable, liveData, destDir, fileName, 0);
    }


    //断点下载，如果下载到一半，可从一半开始下载
    @SuppressLint("CheckResult")
    public <T> MutableLiveData<T> downLoadFile(Observable observable, final MutableLiveData<T> liveData, final String destDir, final String fileName, final long currentLength) {
//        observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .map(requestBody -> {
//                    if (currentLength == 0) {
//                        return DownFileUtils.saveFile((ResponseBody) requestBody, destDir, fileName, liveData);
//                    } else {
//                        return DownFileUtils.saveFile((ResponseBody) requestBody, destDir, fileName, currentLength, liveData);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(file -> {
//                    liveData.postValue((T) Resource.success(file));
//                }, throwable -> {
//                    liveData.postValue((T) Resource.error((Throwable) throwable));
//                });
        observable.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Function<ResponseBody, File>() {
                    @Override
                    public File apply(ResponseBody requestBody) throws Exception {
                        if (currentLength == 0) {
                            return DownFileUtils.saveFile((ResponseBody) requestBody, destDir, fileName, liveData);
                        } else {
                            return DownFileUtils.saveFile((ResponseBody) requestBody, destDir, fileName, currentLength, liveData);
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(objectLifecycleTransformer)
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(File file) throws Exception {
                        liveData.postValue((T) Resource.success(file));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        liveData.postValue((T) Resource.error((Throwable) throwable));
                    }
                });

        return liveData;
    }


    /**
     *上传文件只有2个参数，showDialog：是否显示dialog；loadmessage：showDialog显示的文字
     */
    public <T> MutableLiveData<T> upLoadFile(Observable observable, MutableLiveData<T> liveData) {
        return upLoadFile(observable, liveData, null);
    }

    //上传文件
    public <T> MutableLiveData<T> upLoadFile(Observable observable, final MutableLiveData<T> liveData, ParamsBuilder paramsBuilder) {

        if (paramsBuilder == null) {
            paramsBuilder = paramsBuilder.build();
        }
        final boolean showDialog = paramsBuilder.isShowDialog();
        final String loadingMessage = paramsBuilder.getLoadingMessage();

//        observable.subscribeOn(Schedulers.io())
//                .doOnSubscribe(disposable -> {
//                    if (showDialog) {
//                        liveData.postValue((T) Resource.loading(loadingMessage));
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                //防止RxJava内存泄漏
//                .subscribe(o -> {
//                    liveData.postValue((T) Resource.success("成功了"));
//                }, throwable -> {
//                    liveData.postValue((T) Resource.error((Throwable) throwable));
//                });
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (showDialog) {
                            liveData.postValue((T) Resource.loading(loadingMessage));
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(objectLifecycleTransformer)
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        liveData.postValue((T) Resource.success("成功了"));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        liveData.postValue((T) Resource.error((Throwable) throwable));
                    }
                });

        return liveData;
    }

}
