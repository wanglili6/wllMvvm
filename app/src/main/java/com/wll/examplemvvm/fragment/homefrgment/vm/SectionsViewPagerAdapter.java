package com.wll.examplemvvm.fragment.homefrgment.vm;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author wll
 * @description: viewPage  的适配器
 */
public class SectionsViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mfragment;

    public SectionsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SectionsViewPagerAdapter(FragmentManager fm, List<Fragment> mfragment) {
        super(fm);
        this.mfragment = mfragment;
    }

    @Override
    public Fragment getItem(int position) {
        if (null != mfragment) {
            return mfragment.get(position);
        } else {
            return null;
        }

    }

    @Override
    public int getCount() {
        return mfragment.size();
    }
}
