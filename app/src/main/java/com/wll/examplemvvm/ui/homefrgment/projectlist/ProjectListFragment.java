package com.wll.examplemvvm.ui.homefrgment.projectlist;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Update;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.bean.basebean.ParamsBuilder;
import com.wll.examplemvvm.bean.basebean.Resource;
import com.wll.examplemvvm.databinding.FragmentProjectListBinding;
import com.wll.examplemvvm.ui.homefrgment.projectlist.adapter.ProjectListAdapter;
import com.wll.examplemvvm.ui.homefrgment.projectlist.model.HomeProjectBean;
import com.wll.examplemvvm.ui.homefrgment.projectlist.model.ProjectListBean;
import com.wll.examplemvvm.ui.homefrgment.projectlist.vm.ProjectViewModel;
import com.wll.examplemvvm.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class ProjectListFragment extends BaseFragment<ProjectViewModel, FragmentProjectListBinding> {
    //加载页码
    private int page = 0;
    //数据集合
    private ArrayList<ProjectListBean> mList = new ArrayList<>();
    private ProjectListAdapter projectListAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_project_list;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        getProjectListData(page, ParamsBuilder.build().isShowDialog(false));
        initAdapter();
    }

    private void initAdapter() {
        projectListAdapter = new ProjectListAdapter(this);
        projectListAdapter.setDataList(mList);
        binding.projectListView.setAdapter(projectListAdapter);
    }


    @Override
    protected void setListener() {

        binding.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 0;
                mList.clear();
                getProjectListData(page, ParamsBuilder.build().isShowDialog(false));
            }
        });
        binding.smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getProjectListData(page, ParamsBuilder.build().isShowDialog(false));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_shoucan:
                ToastUtils.showToast("收藏");
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    /**
     * 获取liveData  进行数据更新
     *
     * @param page
     * @param paramsBuilder
     */
    private void getProjectListData(int page, ParamsBuilder paramsBuilder) {
        mViewModel.getProjectLists(page, paramsBuilder).observe(this, new Observer<Resource<HomeProjectBean>>() {
            @Override
            public void onChanged(Resource<HomeProjectBean> homeProjectBeanResource) {
                homeProjectBeanResource.handler(new OnCallback<HomeProjectBean>() {
                    @Override
                    public void onSuccess(HomeProjectBean data) {
                        //访问成功
                        UpdataData(data);
                    }
                }, binding.smartRefreshLayout);
            }
        });
    }

    /**
     * 更新数据
     *
     * @param data 数据元
     */
    private void UpdataData(HomeProjectBean data) {
        if (null == data) {
            return;
        }
        List<ProjectListBean> datas = data.getDatas();
        if (null == datas || datas.size() <= 0) {
            return;
        }
        if (page == 0) {
            mList.clear();
        }
        mList.addAll(datas);
        //记载数据
        projectListAdapter.notifyItemRangeChanged(mList.size() - data.getDatas().size(), data.getDatas().size());
    }
}
