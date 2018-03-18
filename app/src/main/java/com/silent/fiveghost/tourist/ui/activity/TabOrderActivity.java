package com.silent.fiveghost.tourist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.manager.FullyLinearLayoutManager;
import com.silent.fiveghost.tourist.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TabOrderActivity extends BaseActivity  {
    @BindView(R.id.mTabLayout)
    public TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    public ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_order);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }

}
