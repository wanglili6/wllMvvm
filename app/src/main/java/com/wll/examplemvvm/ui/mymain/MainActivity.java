package com.wll.examplemvvm.ui.mymain;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseActivity;
import com.wll.examplemvvm.bean.basebean.TabEntity;
import com.wll.examplemvvm.databinding.ActivityMainBinding;
import com.wll.examplemvvm.ui.homefrgment.HomeFragment;

import java.util.ArrayList;

/**
 * @author wll
 * @description: 主页面
 */
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    //存放fragment的列表
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    //存放tabicon的列表
    private ArrayList<CustomTabEntity> mTabs = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void processLogic() {
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //添加fragment
        mFragments.add(new HomeFragment());
        mFragments.add(new HomeFragment());
        mFragments.add(new HomeFragment());
        mFragments.add(new HomeFragment());
        //添加tab
        ArrayList<CustomTabEntity> tabs = mViewModel.getTabs();
        if (null != tabs) {
            mTabs.addAll(tabs);
        }
        binding.commonTabLayout.setTabData(mTabs, this, R.id.main_view_page, mFragments);


    }


    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
