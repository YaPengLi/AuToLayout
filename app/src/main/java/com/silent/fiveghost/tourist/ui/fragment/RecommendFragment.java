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

/*
 * 推荐
 **/
public class RecommendFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
	@BindView(R.id.rv_suggest)
	RecyclerView rvSuggest;
	Unbinder unbinder;
	@BindView(R.id.iv_message_recommend)
	ImageView ivMessageRecommend;
	@BindView(R.id.srl_recommend)
	SwipeRefreshLayout swipe;
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
//        swipe.setOnRefreshListener(this);
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
				RvSuggestAdapter adapter = new RvSuggestAdapter(getActivity(), strings, advert, route, guide);
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

	}
}
