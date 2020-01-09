package com.wll.examplemvvm.ui.homefrgment.projectlist;

import android.os.Bundle;
import android.view.View;

import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.databinding.FragmentProjectListBinding;
import com.wll.examplemvvm.ui.homefrgment.projectlist.vm.ProjectViewModel;

public class ProjectListFragment extends BaseFragment<ProjectViewModel, FragmentProjectListBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_project_list;
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
