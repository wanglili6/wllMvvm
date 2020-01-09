package com.wll.examplemvvm.ui.homefrgment.newslist;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.room.Update;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.bean.HomeNewsBean;
import com.wll.examplemvvm.bean.basebean.ParamsBuilder;
import com.wll.examplemvvm.bean.basebean.Resource;
import com.wll.examplemvvm.databinding.FragmentHomeBinding;
import com.wll.examplemvvm.databinding.FragmentNewsListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 最新文章
 */
public class NewsListFragment extends BaseFragment<NewsViewModel, FragmentNewsListBinding> {
    private int curpage = 0;
    private ArrayList<HomeNewsBean.DatasBean> mList = new ArrayList<>();
    private NewsListAdapter newsListAdapter;

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
        mViewModel.getNewsList(curpage, paramsBuilder).observe(this, new Observer<Resource<HomeNewsBean>>() {
            @Override
            public void onChanged(Resource<HomeNewsBean> homeNewsBeanResource) {
                homeNewsBeanResource.handler(new OnCallback<HomeNewsBean>() {
                    @Override
                    public void onSuccess(HomeNewsBean data) {
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
    private void updateData(HomeNewsBean data) {
        List<HomeNewsBean.DatasBean> datas = data.getDatas();
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
        newsListAdapter = new NewsListAdapter(this);
        newsListAdapter.setDataList(mList);
        binding.newsListView.setAdapter(newsListAdapter);
    }

}
