package com.wll.examplemvvm.ui.thepublic.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wll.examplemvvm.BR;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseRecyclerlAdapter;
import com.wll.examplemvvm.base.BaseViewHolder;
import com.wll.examplemvvm.databinding.ItemPublicHistoryBinding;
import com.wll.examplemvvm.ui.thepublic.model.PublicHistoryFaterBean;

/**
 * @author wanglili
 * @description: 公众号历史信息adapter
 * @date : 2020-01-10 17:02
 */
public class PublicHistoryListAdapter extends BaseRecyclerlAdapter<PublicHistoryFaterBean.DatasBean> {
    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int viewType) {
        ItemPublicHistoryBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_public_history, viewGroup, false);
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
        ItemPublicHistoryBinding binding = (ItemPublicHistoryBinding) baseViewHolder.binding;
        PublicHistoryFaterBean.DatasBean datasBean = dataList.get(position);
        binding.setVariable(BR.historyDataBean, datasBean);
        binding.executePendingBindings();
    }
}
