package com.wll.examplemvvm.fragment.top;

import android.os.Bundle;
import android.view.View;

import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.databinding.FragmentTopListBinding;
import com.wll.examplemvvm.fragment.top.vm.TopListViewmodel;

/**
 * @author wanglili
 * @description: 置顶文章--最新博文
 * @date : 2020-01-10 11:24
 */
public class TopListFragment extends BaseFragment<TopListViewmodel, FragmentTopListBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_top_list;
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
