package com.wll.examplemvvm.fragment.publichao.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wll.examplemvvm.BR;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseRecyclerlAdapter;
import com.wll.examplemvvm.base.BaseViewHolder;
import com.wll.examplemvvm.databinding.ItemPublicTypeBinding;
import com.wll.examplemvvm.fragment.publichao.model.PublicHaoBean;

/**
 * @author wanglili
 * @description: 公众号分类
 * @date : 2020-01-10 15:37
 */
public class PublicTypeAdapter extends BaseRecyclerlAdapter<PublicHaoBean> {

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int viewType) {
        ItemPublicTypeBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_public_type, viewGroup, false);
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
        ItemPublicTypeBinding binding = (ItemPublicTypeBinding) baseViewHolder.binding;
        PublicHaoBean publicHaoBean = dataList.get(position);
        binding.setVariable(BR.publicHaobean, publicHaoBean);
        binding.executePendingBindings();

    }


}
