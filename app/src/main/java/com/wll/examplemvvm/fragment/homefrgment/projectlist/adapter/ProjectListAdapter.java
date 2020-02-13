package com.wll.examplemvvm.fragment.homefrgment.projectlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wll.examplemvvm.BR;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseRecyclerlAdapter;
import com.wll.examplemvvm.base.BaseViewHolder;
import com.wll.examplemvvm.databinding.IteamProjectListBinding;
import com.wll.examplemvvm.fragment.homefrgment.projectlist.model.ProjectListBean;

/**
 * @author wanglili
 * @description: 最新项目的适配器
 * @date : 2020-01-09 14:37
 */
public class ProjectListAdapter extends BaseRecyclerlAdapter<ProjectListBean> {
    //设置点击事件
    private View.OnClickListener clickListener;

    public ProjectListAdapter(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int viewType) {
        IteamProjectListBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.iteam_project_list, viewGroup, false);
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        //获取viewHolder
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
        //获取banding对象
        IteamProjectListBinding binding = (IteamProjectListBinding) baseViewHolder.binding;
        ProjectListBean datasBean = dataList.get(position);//获取数据
        //绑定数据
        binding.setVariable(BR.projectBean, datasBean);
        //防止闪烁
        binding.executePendingBindings();
        binding.imgShoucan.setOnClickListener(clickListener);
//        String author = datasBean.getAuthor();
//        if (!TextUtils.isEmpty(author)) {
//            binding.tvAuthor.setText(author);
//        } else {
//            binding.tvAuthor.setText("");
//        }
//        String title = datasBean.getTitle();
//        if (!TextUtils.isEmpty(title)) {
//            binding.tvTitle.setText(title);
//        } else {
//            binding.tvTitle.setText("");
//        }
//        String niceDate = datasBean.getNiceDate();
//        if (!TextUtils.isEmpty(niceDate)) {
//            binding.tvTime.setText(niceDate);
//        } else {
//            binding.tvTime.setText("");
//        }
//        String desc = datasBean.getDesc();
//        if (!TextUtils.isEmpty(desc)) {
//            binding.tvDesc.setText(desc);
//        } else {
//            binding.tvDesc.setText("");
//        }
    }
}
