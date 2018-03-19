package com.silent.fiveghost.tourist.ui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.MyTabVpAdapter;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.bean.PublishedOrderBean;
import com.silent.fiveghost.tourist.bean.TabEntity;
import com.silent.fiveghost.tourist.manager.FullyLinearLayoutManager;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.ui.activity.GuideDetailActivity;
import com.silent.fiveghost.tourist.ui.activity.LoginActivity;
import com.silent.fiveghost.tourist.ui.fragment.OrderListFragment.OnFragmentInteractionListener;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class PublishedOrderFragment extends BaseActivity implements View.OnClickListener,OnFragmentInteractionListener {
    @BindView(R.id.mLeftIcon)
    public ImageView mLeftIcon;
    @BindView(R.id.mTitle)
    public TextView mTitle;
    @BindView(R.id.mTabLayout)
    public TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    public ViewPager mViewPager;
    private List<TabEntity> tabs;
    private List<Fragment> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_publishedorder);
        Intent intent = getIntent();
        tabs = (List<TabEntity>) intent.getSerializableExtra("tabs");
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        mLeftIcon.setOnClickListener(this);
        mTitle.setText(getIntent().getStringExtra("title"));
    }

    private void initData() {
        for (int i= 0;i<tabs.size();i++){
            TabEntity tabEntity = tabs.get(i);
            OrderListFragment orderListFragment = OrderListFragment.newInstance(tabEntity);
            mList.add(orderListFragment);
        }
        mViewPager.setAdapter(new MyTabVpAdapter(getSupportFragmentManager(),mList,tabs));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mLeftIcon:
                finish();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
