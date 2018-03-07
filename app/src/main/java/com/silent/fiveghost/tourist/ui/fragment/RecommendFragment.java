package com.silent.fiveghost.tourist.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.recker.flybanner.FlyBanner;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/7 15:24
 * <p>
 * ${TAGS}
 */
public class RecommendFragment extends BaseFragment implements View.OnClickListener {

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

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recommend, container, false);
		ButterKnife.bind(getActivity());

		initView(view);
		initData();


		ButterKnife.bind(this, view);
		return view;
	}

	private void initView(View view) {


	}

	private void initData() {

	}

	@Override
	public void onClick(View v) {

	}

}
