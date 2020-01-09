package com.wll.examplemvvm.ui.homefrgment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;
import com.wll.examplemvvm.bean.BannerBean;
import com.wll.examplemvvm.bean.basebean.Resource;

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
