package com.wll.examplemvvm.ui.thepublic;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseActivity;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.databinding.ActivityPublicHistoryBinding;
import com.wll.examplemvvm.ui.thepublic.adapter.PublicHistoryListAdapter;
import com.wll.examplemvvm.ui.thepublic.model.PublicHistoryFaterBean;
import com.wll.examplemvvm.ui.thepublic.vm.PublicHistoryViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglili
 * @description: 历史公众号文章
 * @date : 2020-01-10 16:16
 */
public class PublicHistoryActivity extends BaseActivity<PublicHistoryViewModel, ActivityPublicHistoryBinding> {
    //标题
    private String title;
    private int id;
    private int page = 0;
    private ArrayList<PublicHistoryFaterBean.DatasBean> mList = new ArrayList<>();
    private PublicHistoryListAdapter historyListAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_public_history;
    }

    @Override
    protected void processLogic() {
        initData();
        getData(id, page);
    }

    @Override
    protected void setListener() {
        binding.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 0;
                mList.clear();
                getData(id, page);
            }
        });
        binding.smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getData(id, page);
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bar_left_btn:
                finish();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    /**
     * 初始化数据
     */
    private void initData() {
        id = getIntent().getIntExtra("id", 0);
        title = getIntent().getStringExtra("title");
        binding.titleBar.txt_title.setText(title);

        historyListAdapter = new PublicHistoryListAdapter();
        historyListAdapter.setDataList(mList);
        binding.publicRecyclerView.setAdapter(historyListAdapter);


    }

    /**
     * 获取数据
     */
    private void getData(int id, int page) {
        mViewModel.getPublicHistoryList(id, page).observe(this, new Observer<Resource<PublicHistoryFaterBean>>() {
            @Override
            public void onChanged(Resource<PublicHistoryFaterBean> publicHistoryFaterBeanResource) {
                publicHistoryFaterBeanResource.handler(new OnCallback<PublicHistoryFaterBean>() {
                    @Override
                    public void onSuccess(PublicHistoryFaterBean data) {
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
    private void updataData(PublicHistoryFaterBean data) {
        if (null == data) {
            return;
        }
        List<PublicHistoryFaterBean.DatasBean> datas = data.getDatas();
        if (null == datas || datas.size() <= 0) {
            return;
        }
        if (page == 0) {
            mList.clear();
        }
        mList.addAll(datas);
        historyListAdapter.notifyItemRangeChanged(mList.size() - datas.size(), datas.size());

    }


}
