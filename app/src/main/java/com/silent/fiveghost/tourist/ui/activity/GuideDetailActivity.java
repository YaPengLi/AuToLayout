package com.silent.fiveghost.tourist.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.GuideDetailsCommentAdapter;
import com.silent.fiveghost.tourist.adapter.GuideDetailsLikeAdapter;
import com.silent.fiveghost.tourist.adapter.GuideDetailsPathAdapter;
import com.silent.fiveghost.tourist.bean.GuideDetailBean;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;
import com.silent.fiveghost.tourist.view.ScrollviewForGridview;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * 导游详情
 **/
public class GuideDetailActivity extends BaseActivity {

	@BindView(R.id.img_guide_detail_head)
	ImageView imgGuideDetailHead;
	@BindView(R.id.tv_guide_detail_name)
	TextView tvGuideDetailName;
	@BindView(R.id.tv_guide_detail_age)
	TextView tvGuideDetailAge;
	@BindView(R.id.tv_guide_detail_context)
	TextView tvGuideDetailContext;
	@BindView(R.id.img_guide_detail_image1)
	ImageView imgGuideDetailImage1;
	@BindView(R.id.img_guide_detail_image2)
	ImageView imgGuideDetailImage2;
	@BindView(R.id.img_guide_detail_image3)
	ImageView imgGuideDetailImage3;
	@BindView(R.id.tv_guide_detail_car)
	TextView tvGuideDetailCar;
	@BindView(R.id.tv_guide_detail_star)
	TextView tvGuideDetailStar;
	@BindView(R.id.tv_guide_detail_city)
	TextView tvGuideDetailCity;
	@BindView(R.id.tv_guide_detail_path_context)
	TextView tvGuideDetailPathContext;
	@BindView(R.id.rv_guide_detail_path)
	ScrollviewForGridview rvGuideDetailPath;
	@BindView(R.id.tv_guide_detail_grade)
	TextView tvGuideDetailGrade;
	@BindView(R.id.tv_guide_detail_path_title)
	TextView tvGuideDetailPathTitle;
	@BindView(R.id.tv_guide_detail_path_count)
	TextView tvGuideDetailPathCount;
	@BindView(R.id.rv_guide_detail_comment)
	RecyclerView rvGuideDetailComment;
	@BindView(R.id.rv_guide_detail_like)
	RecyclerView rvGuideDetailLike;
	@BindView(R.id.iv_back_all)
	ImageView ivBackAll;
	@BindView(R.id.tv_title_all)
	TextView tvTitleAll;
	@BindView(R.id.iv_message_all)
	ImageView ivMessageAll;

	private String mToken;
	private GuideDetailsPathAdapter mPathAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_details);
		ButterKnife.bind(this);

		initView();
	}

	private void initView() {
		ivMessageAll.setVisibility(View.INVISIBLE);
		tvTitleAll.setText("导游详情");
		ivBackAll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
		rvGuideDetailLike.setLayoutManager(gridLayoutManager);

		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		rvGuideDetailComment.setLayoutManager(linearLayoutManager);

		getData();
	}

	private void getData() {
		SharedPreferences preferences = getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
		mToken = preferences.getString("accessToken", "");

		IPresenter presenter = new IPresenter(new IView<GuideDetailBean>() {

			@Override
			public void success(GuideDetailBean bean) {

				onSuccess(bean.getData());
			}

			@Override
			public void defeat(String s) {
				Log.e("GuideDetailActivity", s);
			}

		});

		presenter.DoGet(UrlUtils.GUIDE_URL + mToken + "&uid=" + getIntent().getStringExtra("gid"));
	}

	private void onSuccess(GuideDetailBean.DataBean bean) {

		mPathAdapter = new GuideDetailsPathAdapter(this, bean.getRoute());
		rvGuideDetailPath.setAdapter(mPathAdapter);
		rvGuideDetailPath.setHorizontalSpacing(10);
		rvGuideDetailPath.setStretchMode(GridView.NO_STRETCH);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int size = bean.getRoute().size();
		float density = dm.density;
		int allWidth = (int) (160 * size * density);
		int itemWidth = (int) (150 * density);
		Log.e("allWidth", "allWidth====" + allWidth + "itemWidth====" + itemWidth);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				allWidth, LinearLayout.LayoutParams.FILL_PARENT);
		rvGuideDetailPath.setLayoutParams(params);
		rvGuideDetailPath.setColumnWidth(itemWidth);
		rvGuideDetailPath.setNumColumns(size);

		GuideDetailsLikeAdapter adapter = new GuideDetailsLikeAdapter(this, bean.getTour_preference());
		rvGuideDetailLike.setAdapter(adapter);

		GuideDetailsCommentAdapter guideDetailsCommentAdapter = new GuideDetailsCommentAdapter(this, bean.getComment().getItems());
		rvGuideDetailComment.setAdapter(guideDetailsCommentAdapter);

		Glide.with(this).load(bean.getAvatar()).into(imgGuideDetailHead);
		Glide.with(this).load(bean.getImg().size() > 0 ? bean.getImg().get(0) : "").into(imgGuideDetailImage1);
		Glide.with(this).load(bean.getImg().size() > 1 ? bean.getImg().get(1) : "").into(imgGuideDetailImage2);
		Glide.with(this).load(bean.getImg().size() > 2 ? bean.getImg().get(2) : "").into(imgGuideDetailImage3);

		tvGuideDetailName.setText(bean.getName() == null ? "" : bean.getName());
		tvGuideDetailContext.setText(bean.getDesc() == null ? "" : bean.getDesc());
		tvGuideDetailCar.setText(bean.getCar_type() == null ? "" : bean.getCar_type());
		tvGuideDetailStar.setText(bean.getStar_text() == null ? "" : bean.getStar_text());
		tvGuideDetailCity.setText(bean.getOrder_city() == null ? "" : bean.getOrder_city());

		tvGuideDetailPathContext.setText(bean.getGood_line_desc() == null ? "" : bean.getGood_line_desc());
		tvGuideDetailGrade.setText(String.valueOf(bean.getComment_star()));
		if (bean.getComment().getItems() != null) {
			tvGuideDetailPathCount.setText(bean.getComment().getItems().size());
		}



	}
}
