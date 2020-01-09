package com.wll.examplemvvm.ui.mymain.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;
import com.wll.examplemvvm.ui.mymain.model.MainBean;
import com.wll.examplemvvm.bean.basebean.TabEntity;

import java.util.ArrayList;

/**
 * main activity  的viewModel
 */
public class MainViewModel extends BaseViewModel<RepositoryImpl> {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 获取tab
     *
     * @return
     */
    public  ArrayList<CustomTabEntity> getTabs() {
        ArrayList<CustomTabEntity> mTabs = new ArrayList<>();
        int[] mIconSelectIds = MainBean.mIconSelectIds;
        String[] mTitles = MainBean.mTitles;
        int[] mIconUnselectIds = MainBean.mIconUnselectIds;
        for (int i = 0; i < mIconSelectIds.length; i++) {
            mTabs.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        return mTabs;
    }

}
