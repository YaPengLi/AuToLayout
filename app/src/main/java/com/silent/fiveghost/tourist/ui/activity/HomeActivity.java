package com.silent.fiveghost.tourist.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.HomeVpAdapter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.ui.fragment.FeaturesFragment;
import com.silent.fiveghost.tourist.ui.fragment.OrderFragment;
import com.silent.fiveghost.tourist.ui.fragment.PersonalFragment;
import com.silent.fiveghost.tourist.ui.fragment.RecommendFragment;
import com.silent.fiveghost.tourist.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  主页
* */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.vp_home)
    ViewPager vpHome;
    //	@BindView(R.id.mRadioGroup)
//	RadioGroup mRadioGroup;
	@BindView(R.id.img_home_issue)
	ImageView mImageIssue;
	@BindView(R.id.img_home_icon)
	ImageView imgHomeIcon;
	@BindView(R.id.tv_home_text)
	TextView tvHomeText;
	@BindView(R.id.rl_home)
	RelativeLayout rlHome;
	@BindView(R.id.img_feature_icon)
	ImageView imgFeatureIcon;
	@BindView(R.id.tv_feature_text)
	TextView tvFeatureText;
	@BindView(R.id.rl_feature)
	RelativeLayout rlFeature;
	@BindView(R.id.img_order_icon)
	ImageView imgOrderIcon;
	@BindView(R.id.tv_order_text)
	TextView tvOrderText;
	@BindView(R.id.rl_order)
	RelativeLayout rlOrder;
	@BindView(R.id.img_mine_icon)
	ImageView imgMineIcon;
	@BindView(R.id.tv_mine_text)
	TextView tvMineText;
	@BindView(R.id.rl_mine)
	RelativeLayout rlMine;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		StatusBarUtil.StatusBarLightMode(HomeActivity.this, 1);
		ButterKnife.bind(this);
		List<Fragment> fragmentList = new ArrayList<>();
		RecommendFragment recommendFragment = new RecommendFragment();
		FeaturesFragment featuresFragment = new FeaturesFragment();
//        ReleaseItineraryFragment releaseItineraryFragment = new ReleaseItineraryFragment();
		OrderFragment orderFragment = new OrderFragment();
		PersonalFragment personalFragment = new PersonalFragment();
		fragmentList.add(recommendFragment);
		fragmentList.add(featuresFragment);
//        fragmentList.add(releaseItineraryFragment);
		fragmentList.add(orderFragment);
		fragmentList.add(personalFragment);
		vpHome.setAdapter(new HomeVpAdapter(getSupportFragmentManager(), fragmentList));
		//ViewPager页面切换监听
		vpHome.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				switch (position) {
					case 0:
						onHomeCheck();
						break;
					case 1:
						onFeatureCheck();
						break;
					case 2:
						onOrderCheck();
						break;
					case 3:
						onMineCheck();
						break;
					default:
						break;
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		mImageIssue.setOnClickListener(this);
		rlHome.setOnClickListener(this);
		rlFeature.setOnClickListener(this);
		rlOrder.setOnClickListener(this);
		rlMine.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.img_home_issue:
				startActivity(new Intent(HomeActivity.this, IssueActivity.class));
				break;
			case R.id.rl_home:
				vpHome.setCurrentItem(0);
				onHomeCheck();
				break;
			case R.id.rl_feature:
				vpHome.setCurrentItem(1);
				onFeatureCheck();
				break;
			case R.id.rl_order:
				vpHome.setCurrentItem(2);
				onOrderCheck();
				break;
			case R.id.rl_mine:
				vpHome.setCurrentItem(3);
				onMineCheck();
				break;
			default:
				break;
		}
	}

	private void onHomeCheck() {
		imgHomeIcon.setBackgroundResource(R.mipmap.icon_home_select);
		imgFeatureIcon.setBackgroundResource(R.mipmap.icon_fav_normal);
		imgOrderIcon.setBackgroundResource(R.mipmap.icon_order_normal);
		imgMineIcon.setBackgroundResource(R.mipmap.icon_mine_normal);
		tvHomeText.setTextColor(getResources().getColor(R.color.color_button_bg));
		tvFeatureText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvOrderText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvMineText.setTextColor(getResources().getColor(R.color.color_text_default));
	}

	private void onFeatureCheck() {
		imgHomeIcon.setBackgroundResource(R.mipmap.icon_home_normal);
		imgFeatureIcon.setBackgroundResource(R.mipmap.icon_fav_select);
		imgOrderIcon.setBackgroundResource(R.mipmap.icon_order_normal);
		imgMineIcon.setBackgroundResource(R.mipmap.icon_mine_normal);
		tvHomeText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvFeatureText.setTextColor(getResources().getColor(R.color.color_button_bg));
		tvOrderText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvMineText.setTextColor(getResources().getColor(R.color.color_text_default));
	}

	private void onOrderCheck() {
		imgHomeIcon.setBackgroundResource(R.mipmap.icon_home_normal);
		imgFeatureIcon.setBackgroundResource(R.mipmap.icon_fav_normal);
		imgOrderIcon.setBackgroundResource(R.mipmap.icon_order_select);
		imgMineIcon.setBackgroundResource(R.mipmap.icon_mine_normal);
		tvHomeText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvFeatureText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvOrderText.setTextColor(getResources().getColor(R.color.color_button_bg));
		tvMineText.setTextColor(getResources().getColor(R.color.color_text_default));
	}

	private void onMineCheck() {
		imgHomeIcon.setBackgroundResource(R.mipmap.icon_home_normal);
		imgFeatureIcon.setBackgroundResource(R.mipmap.icon_fav_normal);
		imgOrderIcon.setBackgroundResource(R.mipmap.icon_order_normal);
		imgMineIcon.setBackgroundResource(R.mipmap.icon_mine_select);
		tvHomeText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvFeatureText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvOrderText.setTextColor(getResources().getColor(R.color.color_text_default));
		tvMineText.setTextColor(getResources().getColor(R.color.color_button_bg));
	}
}
