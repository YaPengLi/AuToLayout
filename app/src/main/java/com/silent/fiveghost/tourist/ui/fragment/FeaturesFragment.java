package com.silent.fiveghost.tourist.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.FeatureAdapter;
import com.silent.fiveghost.tourist.bean.FeaturesBean;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.activity.HomeActivity;
import com.silent.fiveghost.tourist.ui.activity.LoginActivity;
import com.silent.fiveghost.tourist.ui.activity.RoadDetailsActivity;
import com.silent.fiveghost.tourist.utils.Constant;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 特色
 */
public class FeaturesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
	Unbinder unbinder;
	@BindView(R.id.spl_features)
	SwipeRefreshLayout swipe;
	@BindView(R.id.sv_shtick)
	SearchView svShtick;
	@BindView(R.id.iv_message_shtick)
	ImageView ivMessageShtick;
	@BindView(R.id.tv_feature_sales_title)
	TextView tvFeatureSalesTitle;
	@BindView(R.id.img_feature_title_icon)
	ImageView imgFeatureTitleIcon;
	@BindView(R.id.rl_feature_sales_layout)
	RelativeLayout rlFeatureSalesLayout;
	@BindView(R.id.rl_feature_collect_layout)
	RelativeLayout rlFeatureCollectLayout;
	@BindView(R.id.rl_feature_last_layout)
	RelativeLayout rlFeatureLastLayout;
	@BindView(R.id.tv_feature_screen_title)
	TextView tvFeatureScreenTitle;
	@BindView(R.id.img_feature_screen_icon)
	ImageView imgFeatureScreenIcon;
	@BindView(R.id.rl_feature_screen_layout)
	RelativeLayout rlFeatureScreenLayout;
	@BindView(R.id.tab_shtick)
	LinearLayout tabShtick;
	@BindView(R.id.rv_shtick)
	RecyclerView rvShtick;
	@BindView(R.id.tv_feature_collect_title)
	TextView tvFeatureCollectTitle;
	@BindView(R.id.tv_feature_last_title)
	TextView tvFeatureLastTitle;

	private String mToken;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.features, container, false);
		unbinder = ButterKnife.bind(this, view);

		initView();
		return view;
	}

	private void initView() {
		swipe.setOnRefreshListener(this);
		LinearLayoutManager manager = new LinearLayoutManager(getActivity());
		rvShtick.setLayoutManager(manager);
		getData();
	}

	private void getData() {
//		Map<String, String> map = Constant.getMap();
		SharedPreferences preferences = getActivity().getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
		mToken = preferences.getString("accessToken", "");
//		map.put("access_token", mToken);

		IPresenter presenter = new IPresenter(new IView<FeaturesBean>() {

			@Override
			public void success(FeaturesBean bean) {
				if (swipe != null) {
					swipe.setRefreshing(false);
					swipe.setEnabled(true);
				}
				onSuccess(bean);
			}

			@Override
			public void defeat(String s) {
				swipe.setRefreshing(false);
				swipe.setEnabled(true);
			}
		});

		presenter.DoGet(UrlUtils.ROUTE_URL + mToken);
	}

	private void onSuccess(final FeaturesBean bean) {
        FeatureAdapter featureAdapter = new FeatureAdapter(getActivity(), bean.getData().getItems());
        featureAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ((HomeActivity) getActivity()).startActivity(RoadDetailsActivity.class);
            }
        });
        rvShtick.setAdapter(featureAdapter);
	}


	@Override
	public void onRefresh() {

	}


	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}
