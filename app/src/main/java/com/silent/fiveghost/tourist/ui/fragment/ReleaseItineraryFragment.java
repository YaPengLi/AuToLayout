package com.silent.fiveghost.tourist.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;


import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
* 发布行程
* */
public class ReleaseItineraryFragment extends Fragment implements View.OnClickListener {
	@BindView(R.id.release_return)
	RelativeLayout releaseReturn;
	@BindView(R.id.releaseitinerary_radio1)
	RadioButton releaseitineraryRadio1;
	@BindView(R.id.releaseitinerary_radio2)
	RadioButton releaseitineraryRadio2;
	@BindView(R.id.releaseitinerary_fragment)
	FrameLayout releaseitineraryFragment;
	Unbinder unbinder;

	private FragmentManager msg;
	private FragmentTransaction transaction;
	private OneStopReleaseFragment oneStopReleaseFragment;
	private SubStationReleaseFragment subStationReleaseFragment;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_release_itinerary, container, false);

		unbinder = ButterKnife.bind(this, view);
		//判断home_pager是否为null
		if (oneStopReleaseFragment == null) {
			oneStopReleaseFragment = new OneStopReleaseFragment();
//            //设置首页默认被选中
			releaseitineraryRadio1.setChecked(true);
		}
		releaseReturn.setOnClickListener(this);
		releaseitineraryRadio1.setOnClickListener(this);
		releaseitineraryRadio2.setOnClickListener(this);
		initData();
		return view;
	}

	private void initData() {
		//动态添加Fragment ,获取Fragment 管理器
		msg = getActivity().getSupportFragmentManager();
		//开启Fragment事物
		transaction = msg.beginTransaction();

		oneStopReleaseFragment = new OneStopReleaseFragment();
		transaction.add(R.id.releaseitinerary_fragment, oneStopReleaseFragment);
		transaction.commit();
	}


	@Override
	public void onClick(View v) {
		//动态添加Fragment ,获取Fragment 管理器
		msg = getActivity().getSupportFragmentManager();
		//开启Fragment事物
		transaction = msg.beginTransaction();
		//方法2隐藏所有的Fragment。
		hideAll(transaction);
		switch (v.getId()) {
			case R.id.release_return:

				break;
			case R.id.releaseitinerary_radio1:
				if (oneStopReleaseFragment == null) {
					oneStopReleaseFragment = new OneStopReleaseFragment();
					transaction.add(R.id.releaseitinerary_fragment, this.oneStopReleaseFragment);
				} else {
					transaction.show(oneStopReleaseFragment);
				}
				break;
			case R.id.releaseitinerary_radio2:
				if (subStationReleaseFragment == null) {

					subStationReleaseFragment = new SubStationReleaseFragment();
					transaction.add(R.id.releaseitinerary_fragment, this.subStationReleaseFragment);
				} else {

					transaction.show(subStationReleaseFragment);
				}
				break;

		}
		transaction.commit();
	}

	private void hideAll(FragmentTransaction transaction) {
		if (oneStopReleaseFragment != null) {
			transaction.hide(oneStopReleaseFragment);
		}
		if (subStationReleaseFragment != null) {
			transaction.hide(subStationReleaseFragment);
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}
