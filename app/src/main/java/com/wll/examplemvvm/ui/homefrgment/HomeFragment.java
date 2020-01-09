package com.wll.examplemvvm.ui.homefrgment;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.bean.BannerBean;
import com.wll.examplemvvm.bean.basebean.Resource;
import com.wll.examplemvvm.databinding.FragmentHomeBinding;
import com.wll.examplemvvm.ui.homefrgment.newslist.NewsListFragment;
import com.wll.examplemvvm.utils.GlideImageLoader;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomeViewModel, FragmentHomeBinding> {
    private String[] mTitles = {"最新文章", "最新项目"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initBanner();
        getBanner();
        initTab();
        initViewPager();
    }


    @Override
    protected void setListener() {
        binding.homeViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.segmentTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                binding.homeViewPage.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

    }

    @Override
    public void onClick(View view) {


    }

    /**
     * 初始化banner
     */
    private void initBanner() {
        //设置显示模式
        binding.homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //加载图片
        binding.homeBanner.setImageLoader(new GlideImageLoader());
    }

    /**
     * 获取轮播图的
     */
    private void getBanner() {
        mViewModel.getBanner().observe(this, new Observer<Resource<List<BannerBean>>>() {
            @Override
            public void onChanged(Resource<List<BannerBean>> listResource) {
                listResource.handler(new OnCallback<List<BannerBean>>() {
                    @Override
                    public void onSuccess(List<BannerBean> data) {
                        //数据发生改变
                        updataBanner(data);
                    }
                });


            }
        });
    }

    /**
     * 更新数据
     *
     * @param bannerBeanList
     */
    private void updataBanner(List<BannerBean> bannerBeanList) {
        if (null == bannerBeanList || bannerBeanList.size() <= 0) {
            return;
        }
        List<String> urls = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < bannerBeanList.size(); i++) {
            urls.add(bannerBeanList.get(i).getImagePath());
            titles.add(bannerBeanList.get(i).getTitle());
        }
        binding.homeBanner.setBannerTitles(titles);
        binding.homeBanner.setImages(urls);
        binding.homeBanner.start();
    }

    /**
     * 获取tab
     */
    private void initTab() {
        binding.segmentTabLayout.setTabData(mTitles);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        mFragments.add(new NewsListFragment());
        mFragments.add(new NewsListFragment());
        binding.homeViewPage.setAdapter(new SectionsViewPagerAdapter(getFragmentManager(), mFragments));
        binding.homeViewPage.setCurrentItem(0);

    }

}
