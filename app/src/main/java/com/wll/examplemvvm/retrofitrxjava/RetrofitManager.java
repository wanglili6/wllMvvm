package com.wll.examplemvvm.retrofitrxjava;

import android.os.Environment;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.wll.examplemvvm.common.SystemConst;
import com.wll.examplemvvm.retrofitrxjava.Interceptor.HttpLogInterceptor;
import com.wll.examplemvvm.retrofitrxjava.Interceptor.NetCacheInterceptor;
import com.wll.examplemvvm.retrofitrxjava.Interceptor.OfflineCacheInterceptor;
import com.wll.examplemvvm.utils.Utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leo
 * on 2019/8/16.
 */
public class RetrofitManager {
    private static RetrofitManager retrofitManager;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private PersistentCookieJar cookieJar;


    private RetrofitApiService retrofitApiService;

    private RetrofitManager() {
        cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(Utils.getApp()));
        //如果后端没有提供退出登录接口，还可以通过以下主动清理
//        cookieJar.clear();
//        cookieJar.clearSession();
        initOkHttpClient();
        initRetrofit();
    }


    public static RetrofitManager getRetrofitManager() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }


    public static RetrofitApiService getApiService() {
        if (retrofitManager == null) {
            retrofitManager = getRetrofitManager();
        }
        return retrofitManager.retrofitApiService;
    }

    /**
     * 初始化 retrofit
     */
    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(SystemConst.DEFAULT_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);
    }

    /**
     * 初始化 okHttpClient
     */
    private void initOkHttpClient() {
        okHttpClient = new OkHttpClient.Builder()
                //设置缓存文件路径，和文件大小
                .cache(new Cache(new File(Environment.getExternalStorageDirectory() + "/okhttp_cache/"), 50 * 1024 * 1024))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLogInterceptor())
                //设置在线和离线缓存
                .addInterceptor(OfflineCacheInterceptor.getInstance())
                .addNetworkInterceptor(NetCacheInterceptor.getInstance())
                .cookieJar(cookieJar)
                .build();
    }

}
