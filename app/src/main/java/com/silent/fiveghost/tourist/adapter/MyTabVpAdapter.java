package com.silent.fiveghost.tourist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.silent.fiveghost.tourist.bean.TabEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/18.
 */

public class MyTabVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    private List<TabEntity> mTabList;

    public MyTabVpAdapter(FragmentManager fm, List<Fragment> mList, List<TabEntity> mTabList) {
        super(fm);
        this.mList = mList;
        this.mTabList = mTabList;
    }

    public MyTabVpAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) mTabList.get(position).getName();
    }
}
