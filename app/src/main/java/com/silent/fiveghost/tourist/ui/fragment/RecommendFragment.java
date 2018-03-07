package com.silent.fiveghost.tourist.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.recker.flybanner.FlyBanner;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.RecommendGuideAdapter;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.manager.FullyLinearLayoutManager;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseFragment;
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
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/7 15:24
 * <p>
 * ${TAGS}
 */
public class RecommendFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

	@BindView(R.id.iv_message_recommend)
	ImageView ivMessageRecommend;
	@BindView(R.id.search_view)
	SearchView searchView;
	@BindView(R.id.ll_recommend_around_tag)
	LinearLayout llRecommendAroundTag;
	@BindView(R.id.ll_recommend_photography_tag)
	LinearLayout llRecommendPhotographyTag;
	@BindView(R.id.ll_recommend_photography_tag_three)
	LinearLayout llRecommendPhotographyTagThree;
	@BindView(R.id.ll_recommend_photography_tag_four)
	LinearLayout llRecommendPhotographyTagFour;
	@BindView(R.id.ll_recommend_photography_tag_five)
	LinearLayout llRecommendPhotographyTagFive;
	@BindView(R.id.rl_hot_path_layout)
	RelativeLayout rlHotPathLayout;
	@BindView(R.id.iv_recommend_hot_path_img_one)
	ImageView ivRecommendHotPathImgOne;
	@BindView(R.id.tv_recommend_hot_path_one)
	TextView tvRecommendHotPathOne;
	@BindView(R.id.iv_recommend_hot_path_img_two)
	ImageView ivRecommendHotPathImgTwo;
	@BindView(R.id.tv_recommend_hot_path_two)
	TextView tvRecommendHotPathTwo;
	@BindView(R.id.iv_recommend_hot_path_img_three)
	ImageView ivRecommendHotPathImgThree;
	@BindView(R.id.tv_recommend_hot_path_three)
	TextView tvRecommendHotPathThree;
	@BindView(R.id.iv_recommend_hot_path_img_four)
	ImageView ivRecommendHotPathImgFour;
	@BindView(R.id.tv_recommend_hot_path_four)
	TextView tvRecommendHotPathFour;
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
	@BindView(R.id.fb_recommend_banner)
	FlyBanner fbRecommendBanner;
	@BindView(R.id.cv)
	CardView cv;

	private List<HomeBean.DataBean.AdvertBean> advert;
	private List<HomeBean.DataBean.RouteBean> route;
	private List<HomeBean.DataBean.GuideBean> guide;

	private Unbinder unbinder;

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

	}

	private void initData() {
		getData();
	}

	@Override
	public void onClick(View v) {

	}

	private void getData() {
		IPresenter presenter = new IPresenter(new IView<HomeBean>() {

			@Override
			public void success(HomeBean homeBean) {
				swipe.setRefreshing(false);
				swipe.setEnabled(true);

				onSuccess(homeBean);
			}

			@Override
			public void defeat(String s) {
				swipe.setRefreshing(false);
				swipe.setEnabled(true);
				Log.e("HomeActivity", s);
			}
		});
		//http://120.79.137.110:83/api/v1/home/tourist-index
		presenter.DoGet(UrlUtils.HOME_URL);
	}

	//请求成功后数据渲染
	private void onSuccess(HomeBean homeBean) {
		if (homeBean.getData() != null) {
			if (homeBean.getData().getAdvert() != null) {
				List<String> url = new ArrayList<>();
				for (HomeBean.DataBean.AdvertBean abv : homeBean.getData().getAdvert()) {
					url.add(abv.getImg());
				}
				fbRecommendBanner.setImagesUrl(url);
			}
			//热门线路
			if (homeBean.getData().getRoute() != null) {
				homeBean.getData().getRoute().size();
				Glide.with(getActivity()).load(homeBean.getData().getRoute().get(0) == null ? "" : homeBean.getData().getRoute().get(0).getImg()).into(ivRecommendHotPathImgOne);
				Glide.with(getActivity()).load(homeBean.getData().getRoute().get(1) == null ? "" : homeBean.getData().getRoute().get(1).getImg()).into(ivRecommendHotPathImgTwo);
				Glide.with(getActivity()).load(homeBean.getData().getRoute().get(2) == null ? "" : homeBean.getData().getRoute().get(2).getImg()).into(ivRecommendHotPathImgThree);
				Glide.with(getActivity()).load(homeBean.getData().getRoute().get(3) == null ? "" : homeBean.getData().getRoute().get(3).getImg()).into(ivRecommendHotPathImgFour);
			}
//			导游风采
			if (homeBean.getData().getGuide() != null) {
				Log.e("-----" , "=====" + homeBean.getData().getGuide().size());
				RecommendGuideAdapter GuideAdapter = new RecommendGuideAdapter(getActivity(), homeBean.getData().getGuide());
				lvRecommendGuide.setAdapter(GuideAdapter);
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
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}
