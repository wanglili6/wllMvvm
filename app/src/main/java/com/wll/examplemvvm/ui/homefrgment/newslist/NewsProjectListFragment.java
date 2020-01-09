package com.wll.examplemvvm.ui.homefrgment.newslist;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.bean.basebean.ParamsBuilder;
import com.wll.examplemvvm.bean.basebean.Resource;
import com.wll.examplemvvm.databinding.FragmentNewsListBinding;
import com.wll.examplemvvm.ui.homefrgment.newslist.adapter.NewsListAdapter;
import com.wll.examplemvvm.ui.homefrgment.newslist.model.HomeNewsBean;
import com.wll.examplemvvm.ui.homefrgment.newslist.vm.NewsViewModel;
import com.wll.examplemvvm.ui.homefrgment.projectlist.adapter.ProjectListAdapter;
import com.wll.examplemvvm.ui.homefrgment.projectlist.model.HomeProjectBean;
import com.wll.examplemvvm.ui.homefrgment.projectlist.vm.ProjectViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 最新文章
 */
public class NewsProjectListFragment extends BaseFragment<ProjectViewModel, FragmentNewsListBinding> {
    private int curpage = 0;
    private ArrayList<HomeProjectBean.DatasBean> mList = new ArrayList<>();
    private ProjectListAdapter newsListAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        getNewsList(curpage, null);
        initReclyViewAdapter();
    }


    @Override
    protected void setListener() {
        binding.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                curpage = 0;
                mList.clear();
                getNewsList(curpage, ParamsBuilder.build().isShowDialog(false));
            }
        });
        binding.smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                curpage++;
                getNewsList(curpage, ParamsBuilder.build().isShowDialog(false));
            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 获取最新文章
     *
     * @param curpage
     * @param paramsBuilder
     */
    private void getNewsList(int curpage, ParamsBuilder paramsBuilder) {
        mViewModel.getProjectLists(curpage, paramsBuilder).observe(this, new Observer<Resource<HomeProjectBean>>() {
            @Override
            public void onChanged(Resource<HomeProjectBean> homeNewsBeanResource) {
                homeNewsBeanResource.handler(new OnCallback<HomeProjectBean>() {
                    @Override
                    public void onSuccess(HomeProjectBean data) {
                        updateData(data);
                    }
                }, binding.smartRefreshLayout);
            }
        });
    }

    /**
     * 更新数据
     *
     * @param data
     */
    private void updateData(HomeProjectBean data) {
        List<HomeProjectBean.DatasBean> datas = data.getDatas();
        if (null == data) {
            return;
        }
        if (null == datas || datas.size() <= 0) {
            return;
        }
        if (curpage == 0) {
            mList.clear();
        }
        mList.addAll(datas);
        newsListAdapter.notifyItemRangeChanged(mList.size() - data.getDatas().size(), data.getDatas().size());

    }

    /**
     * 初始化initReclyView--Adapter
     */
    private void initReclyViewAdapter() {
        newsListAdapter = new ProjectListAdapter(this);
        newsListAdapter.setDataList(mList);
        binding.newsListView.setAdapter(newsListAdapter);
    }

}
