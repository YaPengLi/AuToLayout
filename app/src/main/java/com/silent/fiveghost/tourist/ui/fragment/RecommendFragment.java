package com.silent.fiveghost.tourist.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.recker.flybanner.FlyBanner;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.RecommendGuideAdapter;
import com.silent.fiveghost.tourist.adapter.RecommendHotPathAdapter;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.manager.FullyLinearLayoutManager;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseFragment;
import com.silent.fiveghost.tourist.ui.activity.GuideDetailActivity;
import com.silent.fiveghost.tourist.ui.activity.HomeActivity;
import com.silent.fiveghost.tourist.ui.activity.LoginActivity;
import com.silent.fiveghost.tourist.ui.activity.RoadDetailsActivity;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(首页推荐页面)
 * @date 2018/3/7 15:24
 * <p>
 * ${TAGS}
 */
public class RecommendFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener{


	@BindView(R.id.iv_message_recommend)
	ImageView ivMessageRecommend;
	@BindView(R.id.search_view)
	SearchView searchView;
	@BindView(R.id.fb_recommend_banner)
	FlyBanner fbRecommendBanner;
	@BindView(R.id.iv_recommend_hot_path_line)
	ImageView ivRecommendHotPathLine;
	@BindView(R.id.tv_recommend_hot_path_title)
	TextView tvRecommendHotPathTitle;
	@BindView(R.id.rl_hot_path_layout)
	RelativeLayout rlHotPathLayout;
	@BindView(R.id.HotLine)
	RecyclerView HotLine;
	@BindView(R.id.iv_recommend_guide_line)
	ImageView ivRecommendGuideLine;
	@BindView(R.id.tv_recommend_guide_title)
	TextView tvRecommendGuideTitle;
	@BindView(R.id.rl_recommend_guide)
	RelativeLayout rlRecommendGuide;
	@BindView(R.id.lv_recommend_guide)
	RecyclerView lvRecommendGuide;
	@BindView(R.id.swipe)
	SwipeRefreshLayout swipe;
	private List<HomeBean.DataBean.AdvertBean> advert;
	private List<HomeBean.DataBean.RouteBean> route;
	private List<HomeBean.DataBean.GuideBean> guide;

	private RecommendHotPathAdapter adapter;

	private IPresenter presenter;

	private Unbinder unbinder;
	private String mToken;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recommend, container, false);
		unbinder = ButterKnife.bind(this, view);

		initView(view);
		initData();

		return view;
	}

	private void initView(View view) {
		swipe.setOnRefreshListener(this);
		FullyLinearLayoutManager manager = new FullyLinearLayoutManager(getActivity());
		lvRecommendGuide.setLayoutManager(manager);
		lvRecommendGuide.addOnItemTouchListener(new OnItemClickListener() {
			@Override
			public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
				Intent intent = new Intent(getActivity(), GuideDetailActivity.class);
				intent.putExtra("gid", guide.get(position).getGid() + "");
				getActivity().startActivity(intent);
			}
		});
	}

	private void initData() {
		getData();
	}

	@Override
	public void onClick(View v) {

	}

	private void getData() {
		SharedPreferences preferences = getActivity().getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
		mToken = preferences.getString("accessToken", "");
		presenter = new IPresenter(new IView<HomeBean>() {

			@Override
			public void success(HomeBean homeBean) {
				if (swipe != null) {
					swipe.setRefreshing(false);
					swipe.setEnabled(true);
				}
				onSuccess(homeBean);
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

	//请求成功后数据渲染
	private void onSuccess(HomeBean homeBean) {
		Log.e("TAG", homeBean.toString());
		if (homeBean.getData() != null) {
			if (homeBean.getData().getAdvert() != null) {
				List<String> url = new ArrayList<>();
				for (HomeBean.DataBean.AdvertBean abv : homeBean.getData().getAdvert()) {
					url.add(abv.getImg());
				}
				fbRecommendBanner.setImagesUrl(url);
			}
			//印象管家
//            adapter = new RecommendHotPathAdapter(getActivity(), homeBean.getData().getRoute());

//			rvHotPath.setFocusableInTouchMode(false);

			DisplayMetrics dm = new DisplayMetrics();
			getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
			int size = homeBean.getData().getRoute().size();
			float density = dm.density;
			int allWidth = (int) (140 * size * density);
			int itemWidth = (int) (130 * density);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					allWidth, LinearLayout.LayoutParams.FILL_PARENT);

			//热门线路
			List<HomeBean.DataBean.RouteBean> route = homeBean.getData().getRoute();
			HotLine.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
			adapter = new RecommendHotPathAdapter(R.layout.recommend_hot_path_item, route, RecommendFragment.this.getActivity());
			adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
				@Override
				public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
					Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
					((HomeActivity) getActivity()).startActivity(RoadDetailsActivity.class);
				}
			});
			HotLine.setAdapter(adapter);
//			导游风采
			if (homeBean.getData().getGuide() != null) {
				guide = homeBean.getData().getGuide();
				Log.e("-----", "=====" + guide.size());
				RecommendGuideAdapter GuideAdapter = new RecommendGuideAdapter(getActivity(), guide);
				lvRecommendGuide.setAdapter(GuideAdapter);

				GuideAdapter.notifyDataSetChanged();
			}
		} else {
			showToast("数据加载失败！");
		}
	}


	@Override
	public void onRefresh() {
		pageCurrent = 1;
		getData();
	}

	@Override
	public void onResume() {
		super.onResume();
		onRefresh();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}


}
