package com.wll.examplemvvm.fragment.publichao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.base.BaseRecyclerlAdapter;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.databinding.FragmentPublicHaoListBinding;
import com.wll.examplemvvm.fragment.publichao.adapter.PublicTypeAdapter;
import com.wll.examplemvvm.fragment.publichao.model.PublicHaoBean;
import com.wll.examplemvvm.fragment.publichao.vm.PublicHaoViewModel;
import com.wll.examplemvvm.ui.thepublic.PublicHistoryActivity;
import com.wll.examplemvvm.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglili
 * @description: 公众号列表
 * @date : 2020-01-10 11:08
 */
public class PublicHaoFragment extends BaseFragment<PublicHaoViewModel, FragmentPublicHaoListBinding> implements BaseRecyclerlAdapter.OnItemClickListener<PublicHaoBean> {
    private ArrayList<PublicHaoBean> mList = new ArrayList<>();
    private PublicTypeAdapter publicTypeAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_public_hao_list;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        publicData();
        initAdapter();
    }


    @Override
    protected void setListener() {
        binding.smartRefreshLayout.setEnableLoadMore(false);
        binding.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                publicData();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        binding.publicRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        publicTypeAdapter = new PublicTypeAdapter();
        publicTypeAdapter.setDataList(mList);
        publicTypeAdapter.setOnItemClickListener(this);
        binding.publicRecyclerView.setAdapter(publicTypeAdapter);

    }

    /**
     * 获取数据
     */
    private void publicData() {
        mViewModel.getPublicList().observe(this, new Observer<Resource<List<PublicHaoBean>>>() {
            @Override
            public void onChanged(Resource<List<PublicHaoBean>> listResource) {
                listResource.handler(new OnCallback<List<PublicHaoBean>>() {
                    @Override
                    public void onSuccess(List<PublicHaoBean> data) {
                        updataData(data);
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
    private void updataData(List<PublicHaoBean> data) {
        if (null == data || data.size() <= 0) {
            return;
        }
        mList.clear();
        mList.addAll(data);
        publicTypeAdapter.notifyItemRangeChanged(mList.size() - data.size(), data.size());

    }

    /**
     * 条目点击时间
     *
     * @param item
     * @param position
     */
    @Override
    public void onItemClick(PublicHaoBean item, int position) {

        Intent build = ActivityUtils.build(getContext(), PublicHistoryActivity.class);
        build.putExtra("id", item.getId());
        build.putExtra("title", item.getName());
        startActivity(build);
    }
}
