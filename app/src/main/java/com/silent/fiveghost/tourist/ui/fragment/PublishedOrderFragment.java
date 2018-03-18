package com.silent.fiveghost.tourist.ui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.bean.PublishedOrderBean;
import com.silent.fiveghost.tourist.manager.FullyLinearLayoutManager;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseFragment;
import com.silent.fiveghost.tourist.ui.activity.GuideDetailActivity;
import com.silent.fiveghost.tourist.ui.activity.LoginActivity;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/16.
 */

public class PublishedOrderFragment extends BaseFragment implements View.OnClickListener,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.swipe)
    public SwipeRefreshLayout swipe;
    @BindView(R.id.mRecyclerView)
    public RecyclerView mRecyclerView;
    private IPresenter presenter;
    private Unbinder unbinder;
    private String mToken;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_publishedorder, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void initView(View view) {
        swipe.setOnRefreshListener(this);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addOnItemTouchListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), GuideDetailActivity.class);
//                intent.putExtra("gid", guide.get(position).getGid() + "");
                getActivity().startActivity(intent);
            }
        });
    }

    private void initData() {
        getData();
    }


    private void getData() {
        SharedPreferences preferences = getActivity().getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
        mToken = preferences.getString("accessToken", "");
        presenter = new IPresenter(new IView<PublishedOrderBean>() {
            @Override
            public void success(PublishedOrderBean homeBean) {
                if (swipe != null) {
                    swipe.setRefreshing(false);
                    swipe.setEnabled(true);
                }
            }

            @Override
            public void defeat(String s) {
                swipe.setRefreshing(false);
                swipe.setEnabled(true);
                Log.e("HomeActivity", s);
            }
        });
        presenter.DoGet(UrlUtils.HOME_URL + mToken);
    }
    @Override
    public void onClick(View v) {

    }
    //请求成功后数据渲染
    private void onSuccess(HomeBean homeBean) {
        if (homeBean.getData() != null) {
            if (homeBean.getData().getAdvert() != null) {
                List<String> url = new ArrayList<>();
                for (HomeBean.DataBean.AdvertBean abv : homeBean.getData().getAdvert()) {
                    url.add(abv.getImg());
                }
            }


        } else {
            showToast("数据加载失败！");
        }
    }

    @Override
    public void onRefresh() {

    }
}
