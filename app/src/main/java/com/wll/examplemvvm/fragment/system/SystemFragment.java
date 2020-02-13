package com.wll.examplemvvm.fragment.system;

import android.os.Bundle;
import android.view.View;

import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.databinding.FragmentSystemBinding;
import com.wll.examplemvvm.fragment.system.vm.SystemViewMoel;

/**
 * @author wanglili
 * @description: 体系分类
 * @date : 2020-01-10 11:34
 */
public class SystemFragment extends BaseFragment<SystemViewMoel, FragmentSystemBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_system;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
