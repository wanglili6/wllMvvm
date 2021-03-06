package com.wll.examplemvvm.fragment.homefrgment.projectlist.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;
import com.wll.examplemvvm.bean.ParamsBuilder;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.fragment.homefrgment.projectlist.model.HomeProjectBean;

/**
 * 最新项目
 */
public class ProjectViewModel extends BaseViewModel<RepositoryImpl> {
    public ProjectViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 获取最新项目的数据
     *
     * @param page          页码
     * @param paramsBuilder 显示加载的longing
     * @return
     */
    public LiveData<Resource<HomeProjectBean>> getProjectLists(int page, ParamsBuilder paramsBuilder) {
        return getRepository().getHomePreject(page, paramsBuilder);
    }

    public void onImgClick() {

    }
}
