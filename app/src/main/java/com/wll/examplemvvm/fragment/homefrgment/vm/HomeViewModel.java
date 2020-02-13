package com.wll.examplemvvm.fragment.homefrgment.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.fragment.homefrgment.models.BannerBean;

import java.util.List;

public class HomeViewModel extends BaseViewModel<RepositoryImpl> {
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 获取轮播图
     * @return
     */
    public LiveData<Resource<List<BannerBean>>> getBanner(){
        return getRepository().getBannerList();
    }
}
