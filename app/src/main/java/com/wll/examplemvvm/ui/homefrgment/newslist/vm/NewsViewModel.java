package com.wll.examplemvvm.ui.homefrgment.newslist.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;
import com.wll.examplemvvm.ui.homefrgment.newslist.model.HomeNewsBean;
import com.wll.examplemvvm.bean.basebean.ParamsBuilder;
import com.wll.examplemvvm.bean.basebean.Resource;

/**
 * 最新文章的的viewmodel
 */
public class NewsViewModel extends BaseViewModel<RepositoryImpl> {
    public NewsViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 获取最新的文章列表
     *
     * @return
     */
    public LiveData<Resource<HomeNewsBean>> getNewsList(int curPage, ParamsBuilder paramsBuilder) {
        return getRepository().getHomeArticles(curPage, paramsBuilder);
    }
}
