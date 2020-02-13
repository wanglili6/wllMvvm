package com.wll.examplemvvm.fragment.product;

import android.os.Bundle;
import android.view.View;

import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.databinding.FragmentProductBinding;
import com.wll.examplemvvm.fragment.product.vm.ProjectViewModel;

/**
 * @author wanglili
 * @description: 项目
 * @date : 2020-01-10 11:47
 */
public class ProductFragment extends BaseFragment<ProjectViewModel, FragmentProductBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_product;
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
