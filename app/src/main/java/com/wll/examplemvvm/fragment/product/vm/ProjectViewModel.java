package com.wll.examplemvvm.fragment.product.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;

/**
 * @author wanglili
 * @description: 项目
 * @date : 2020-01-10 11:49
 */
public class ProjectViewModel extends BaseViewModel<RepositoryImpl> {
    public ProjectViewModel(@NonNull Application application) {
        super(application);
    }
}
