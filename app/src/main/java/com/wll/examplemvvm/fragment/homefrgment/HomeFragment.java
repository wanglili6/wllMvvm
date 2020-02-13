package com.wll.examplemvvm.fragment.homefrgment;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.base.BaseFragment;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.databinding.FragmentHomeBinding;
import com.wll.examplemvvm.fragment.homefrgment.models.BannerBean;
import com.wll.examplemvvm.fragment.homefrgment.newslist.NewsListFragment;
import com.wll.examplemvvm.fragment.homefrgment.newslist.model.TestBean;
import com.wll.examplemvvm.fragment.homefrgment.projectlist.ProjectListFragment;
import com.wll.examplemvvm.fragment.homefrgment.vm.HomeViewModel;
import com.wll.examplemvvm.fragment.homefrgment.vm.SectionsViewPagerAdapter;
import com.wll.examplemvvm.utils.GlideImageLoader;
import com.wll.examplemvvm.utils.LogUtils;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        initViewPager();
        initTab();
        testData();


    }

    private void testData() {
        String json = "{\"data\":[{\"exchange_record_id\":\"9\",\"erp_prize_id\":\"326\",\"exchange_prize_num\":\"1\",\"from_point_id\":\"1\",\"to_point_id\":\"2\",\"to_point_by\":\"0\",\"to_point_name\":\"\",\"to_point_at\":\"2020-02-12 10:21:46\",\"create_by\":\"3394\",\"create_by_name\":\"李朝煌\",\"create_at\":\"2020-02-12 10:21:46\",\"exchange_record_status\":\"0\"},{\"exchange_record_id\":\"8\",\"erp_prize_id\":\"326\",\"exchange_prize_num\":\"1\",\"from_point_id\":\"1\",\"to_point_id\":\"2\",\"to_point_by\":\"0\",\"to_point_name\":\"\",\"to_point_at\":\"2020-02-12 10:21:12\",\"create_by\":\"3394\",\"create_by_name\":\"李朝煌\",\"create_at\":\"2020-02-12 10:21:12\",\"exchange_record_status\":\"0\"},{\"exchange_record_id\":\"6\",\"erp_prize_id\":\"326\",\"exchange_prize_num\":\"3\",\"from_point_id\":\"1\",\"to_point_id\":\"2\",\"to_point_by\":\"3394\",\"to_point_name\":\"李朝煌\",\"to_point_at\":\"2020-02-12 10:20:28\",\"create_by\":\"1\",\"create_by_name\":\"超级管理员\",\"create_at\":\"2020-02-12 10:20:28\",\"exchange_record_status\":\"1\"},{\"exchange_record_id\":\"5\",\"erp_prize_id\":\"326\",\"exchange_prize_num\":\"2\",\"from_point_id\":\"2\",\"to_point_id\":\"1\",\"to_point_by\":\"1\",\"to_point_name\":\"超级管理员\",\"to_point_at\":\"2020-02-12 10:19:55\",\"create_by\":\"1\",\"create_by_name\":\"超级管理员\",\"create_at\":\"2020-02-12 10:19:55\",\"exchange_record_status\":\"1\"},{\"exchange_record_id\":\"4\",\"erp_prize_id\":\"326\",\"exchange_prize_num\":\"5\",\"from_point_id\":\"1\",\"to_point_id\":\"2\",\"to_point_by\":\"1\",\"to_point_name\":\"超级管理员\",\"to_point_at\":\"2020-02-11 23:40:49\",\"create_by\":\"1\",\"create_by_name\":\"超级管理员\",\"create_at\":\"2020-02-11 23:40:49\",\"exchange_record_status\":\"1\"},{\"exchange_record_id\":\"3\",\"erp_prize_id\":\"326\",\"exchange_prize_num\":\"5\",\"from_point_id\":\"2\",\"to_point_id\":\"1\",\"to_point_by\":\"1\",\"to_point_name\":\"超级管理员\",\"to_point_at\":\"2020-02-11 23:39:54\",\"create_by\":\"1\",\"create_by_name\":\"超级管理员\",\"create_at\":\"2020-02-11 23:39:54\",\"exchange_record_status\":\"1\"},{\"exchange_record_id\":\"1\",\"erp_prize_id\":\"326\",\"exchange_prize_num\":\"1\",\"from_point_id\":\"2\",\"to_point_id\":\"1\",\"to_point_by\":\"1\",\"to_point_name\":\"超级管理员\",\"to_point_at\":\"2020-02-11 15:18:47\",\"create_by\":\"1\",\"create_by_name\":\"超级管理员\",\"create_at\":\"2020-02-11 15:18:47\",\"exchange_record_status\":\"1\"}]}";
        Gson gson = new Gson();
        TestBean testBean = gson.fromJson(json, TestBean.class);
        List<TestBean.DataBean> data = testBean.getData();
        int size = data.size();
        Map<String, Integer> sunmap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int exchange_prize_num = data.get(i).getExchange_prize_num();
            String id = data.get(i).getFrom_point_id();
            if (sunmap.containsKey(id)) {
                Integer integer = sunmap.get(id);
                sunmap.put(id, exchange_prize_num + integer);
            } else {
                sunmap.put(id, exchange_prize_num);
            }
        }
        LogUtils.d("map====" + sunmap.toString());
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
        binding.segmentTabLayout.setViewPager(binding.homeViewPage, mTitles);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        mFragments.add(new NewsListFragment());//私藏文章
        mFragments.add(new ProjectListFragment());//最新文章
        SectionsViewPagerAdapter adapter = new SectionsViewPagerAdapter(getFragmentManager(), mFragments);
        binding.homeViewPage.setAdapter(adapter);
        binding.homeViewPage.setCurrentItem(0);
        adapter.notifyDataSetChanged();

    }

}
