package com.silent.fiveghost.tourist.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.RvSuggestAdapter;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.activity.MessageActivity;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 韩学文 on 2018/1/28.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */
/*
*   推荐
* */
public class RecommendFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rv_suggest)
    RecyclerView rvSuggest;
    Unbinder unbinder;
    @BindView(R.id.iv_message_recommend)
    ImageView ivMessageRecommend;
    @BindView(R.id.srl_recommend)
    SwipeRefreshLayout swiper;
    private List<HomeBean.DataBean.AdvertBean> advert;
    private List<HomeBean.DataBean.RouteBean> route;
    private List<HomeBean.DataBean.GuideBean> guide;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend, container, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvSuggest.setLayoutManager(manager);
        LoadData();
        ivMessageRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MessageActivity.class));
            }
        });
        //为SwipeRefreshLayout设置监听事件
        swiper.setOnRefreshListener(this);
        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        swiper.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        return view;
    }
    private void LoadData() {
        IPresenter presenter = new IPresenter(new IView<HomeBean>() {

            @Override
            public void success(HomeBean homeBean) {
                List<String> strings = new ArrayList<>();
                strings.add("one");
                strings.add("two");
                strings.add("three");
                strings.add("for");
                advert = homeBean.getData().getAdvert();
                route = homeBean.getData().getRoute();
                guide = homeBean.getData().getGuide();
                RvSuggestAdapter adapter = new RvSuggestAdapter(getActivity(), strings, advert, route,guide);
                rvSuggest.setAdapter(adapter);
            }

            @Override
            public void defeat(String s) {
                Log.e("HomeActivity", s);
            }
        });
        //http://120.79.137.110:83/api/v1/home/tourist-index
        presenter.DoGet(UrlUtils.HOME_URL);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        //刷新
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //结束后停止刷新
                swiper.setRefreshing(false);
            }
        }, 3000);

    }
}
