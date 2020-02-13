package com.wll.examplemvvm.base;

import androidx.lifecycle.MutableLiveData;


import com.wll.examplemvvm.fragment.homefrgment.models.BannerBean;
import com.wll.examplemvvm.fragment.homefrgment.newslist.model.HomeNewsBean;
import com.wll.examplemvvm.fragment.homefrgment.projectlist.model.HomeProjectBean;
import com.wll.examplemvvm.bean.ParamsBuilder;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.fragment.publichao.model.PublicHaoBean;
import com.wll.examplemvvm.ui.thepublic.model.PublicHistoryFaterBean;

import java.util.List;

/**
 * Created by leo
 * on 2019/10/15.
 * 这是所有的网络请求所在的位置
 */
public class RepositoryImpl extends BaseModel {

    //获取 banner列表
    public MutableLiveData<Resource<List<BannerBean>>> getBannerList() {
        MutableLiveData<Resource<List<BannerBean>>> liveData = new MutableLiveData<>();
        return observeGo(getApiService().getBanner(), liveData);
    }

    //获取首页文章
    public MutableLiveData<Resource<HomeNewsBean>> getHomeArticles(int curPage, ParamsBuilder paramsBuilder) {

        MutableLiveData<Resource<HomeNewsBean>> liveData = new MutableLiveData<>();
        return observeGo(getApiService().getNewsArticles(curPage), liveData, paramsBuilder);
    }

    //获取首页--最新项目
    public MutableLiveData<Resource<HomeProjectBean>> getHomePreject(int page, ParamsBuilder paramsBuilder) {
        MutableLiveData<Resource<HomeProjectBean>> liveData = new MutableLiveData<>();
        return observeGo(getApiService().getPeojectList(page), liveData, paramsBuilder);
    }

    /**
     * 获取公众号分类列表
     */
    public MutableLiveData<Resource<List<PublicHaoBean>>> getPublictypeList() {
        MutableLiveData<Resource<List<PublicHaoBean>>> liveData = new MutableLiveData<>();
        return observeGo(getApiService().getPublictList(), liveData);
    }

    /**
     * 获取公众号分类列表
     */
    public MutableLiveData<Resource<PublicHistoryFaterBean>> getPublicHistoryList(int id, int page) {
        MutableLiveData<Resource<PublicHistoryFaterBean>> liveData = new MutableLiveData<>();
        return observeGo(getApiService().getPublictHistoryList(id, page), liveData);
    }
//
//    //获取收藏列表
//    public MutableLiveData<Resource<HomeFatherBean>> getCollectArticles(int curPage, ParamsBuilder paramsBuilder) {
//        MutableLiveData<Resource<HomeFatherBean>> liveData = new MutableLiveData<>();
//        return observeGo(getApiService().getCollectArticles(curPage), liveData, paramsBuilder);
//    }
//
//    //站内收藏文章
//    public MutableLiveData<Resource<String>> collectArticle(int id) {
//        MutableLiveData<Resource<String>> liveData = new MutableLiveData<>();
//        return observeGo(getApiService().collectArticle(id), liveData, ParamsBuilder.build().isShowDialog(false));//不显示加载logo
//    }
//
//    //站外收藏文章
//    public MutableLiveData<Resource<String>> collectOutArticle(String title, String author, String link) {
//        MutableLiveData<Resource<String>> liveData = new MutableLiveData<>();
//        return observeGo(getApiService().collectOutArticle(title, author, link), liveData, ParamsBuilder.build().isShowDialog(false));
//    }
//
//    //取消收藏 -- 首页列表
//    public MutableLiveData<Resource<String>> unCollectByHome(int id) {
//        MutableLiveData<Resource<String>> liveData = new MutableLiveData<>();
//        return observeGo(getApiService().unCollectByHome(id), liveData, ParamsBuilder.build().isShowDialog(false));
//    }
//
//
//    public MutableLiveData<Resource<String>> unCollectByMe(int id, int originId) {
//        MutableLiveData<Resource<String>> liveData = new MutableLiveData<>();
//        return observeGo(getApiService().unCollectByMe(id, originId), liveData, null);
//    }
//
//
//    //退出登录
//    public MutableLiveData<Resource<String>> LoginOut() {
//        MutableLiveData<Resource<String>> liveData = new MutableLiveData<>();
//        return observeGo(getApiService().loginOut(), liveData);
//    }
//
//
//    //登录
//    public MutableLiveData<Resource<User>> login(HashMap<String, Object> map, ParamsBuilder paramsBuilder) {
//        MutableLiveData<Resource<User>> liveData = new MutableLiveData<>();
//        return observeGo(getApiService().login(map), liveData, paramsBuilder);
//    }
//
//
//    //正常下载，
//    public MutableLiveData<Resource<File>> downFile(String destDir, String fileName) {
//        MutableLiveData<Resource<File>> liveData = new MutableLiveData<>();
//        return downLoadFile(getApiService().downloadFile(SystemConst.QQ_APK), liveData, destDir, fileName);
//    }
//
//    //断点下载
//    public MutableLiveData<Resource<File>> downFile(String destDir, String fileName, long currentLength) {
//        String range = "bytes=" + currentLength + "-";
//        MutableLiveData<Resource<File>> liveData = new MutableLiveData<>();
//        return downLoadFile(getApiService().downloadFile(SystemConst.QQ_APK, range), liveData, destDir, fileName, currentLength);
//    }
//
//    //上传文件
//    public MutableLiveData<Resource<String>> upLoad(HashMap<String, String> map, Map<String, File> files) {
//        MutableLiveData<Resource<String>> liveData = new MutableLiveData<>();
//        return upLoadFile(getApiService().uploadPic(map, MultipartBodyUtils.getBody(liveData, files)), liveData);
//    }


}
