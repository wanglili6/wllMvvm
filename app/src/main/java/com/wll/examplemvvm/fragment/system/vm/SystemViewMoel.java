package com.wll.examplemvvm.fragment.system.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;

/**
 * @author wanglili
 * @description: 体系vm
 * @date : 2020-01-10 11:35
 */
public class SystemViewMoel extends BaseViewModel<RepositoryImpl> {
    public SystemViewMoel(@NonNull Application application) {
        super(application);
    }
}
