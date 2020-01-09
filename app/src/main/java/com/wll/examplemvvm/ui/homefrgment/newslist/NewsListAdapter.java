package com.wll.examplemvvm.ui.homefrgment.newslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wll.examplemvvm.BR;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseRecyclerlAdapter;
import com.wll.examplemvvm.base.BaseViewHolder;
import com.wll.examplemvvm.bean.HomeNewsBean;
import com.wll.examplemvvm.databinding.ItemNewsListBinding;

/**
 * 最新文章的适配器
 */
public class NewsListAdapter extends BaseRecyclerlAdapter<HomeNewsBean.DatasBean> {
    private View.OnClickListener onClickListener;

    public NewsListAdapter(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int viewType) {

        ItemNewsListBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_news_list, viewGroup, false);
        return new BaseViewHolder(dataBinding);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
        ItemNewsListBinding binding = (ItemNewsListBinding) baseViewHolder.binding;
        HomeNewsBean.DatasBean datasBean = dataList.get(i);
        //绑定数据
        binding.setVariable(BR.dataBean, datasBean);
        //防止闪烁
        binding.executePendingBindings();
//        String author = datasBean.getShareUser();
//        if (!TextUtils.isEmpty(author)) {
//            binding.txtAurtor.setText(author);
//        } else {
//            binding.txtAurtor.setText("");
//        }
//        String title = datasBean.getTitle();
//        if (!TextUtils.isEmpty(title)) {
//            binding.txtTitle.setText(title);
//        } else {
//            binding.txtTitle.setText("");
//        }
//        String niceDate = datasBean.getNiceDate();
//        if (!TextUtils.isEmpty(niceDate)) {
//            binding.txtBlogFrom.setText(niceDate);
//        } else {
//            binding.txtBlogFrom.setText("");
//        }


    }
}
