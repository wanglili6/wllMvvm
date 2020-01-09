package com.wll.examplemvvm.ui.homefrgment.projectlist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;

/**
 * 最新项目
 */
public class ProjectViewModel extends BaseViewModel<RepositoryImpl> {
    public ProjectViewModel(@NonNull Application application) {
        super(application);
    }
    

}
