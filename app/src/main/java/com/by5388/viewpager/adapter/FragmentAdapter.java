package com.by5388.viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.by5388.viewpager.CustomFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器
 *
 * @author by5388  on 2018/12/16.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private final List<String> titles;
    private final List<Fragment> mFragmentList;

    public FragmentAdapter(FragmentManager fragmentManager, List<String> titles) {
        super(fragmentManager);
        this.titles = titles;
        mFragmentList = new ArrayList<>(titles.size());
        for (String title : titles) {
            mFragmentList.add(CustomFragment.newInstance(title));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }
}
