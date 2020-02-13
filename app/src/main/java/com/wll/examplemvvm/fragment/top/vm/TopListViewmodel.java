package com.wll.examplemvvm.fragment.top.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;

/**
 * @author wanglili
 * @description: 置顶文章
 * @date : 2020-01-10 11:30
 */
public class TopListViewmodel extends BaseViewModel<RepositoryImpl> {
    public TopListViewmodel(@NonNull Application application) {
        super(application);
    }
}
