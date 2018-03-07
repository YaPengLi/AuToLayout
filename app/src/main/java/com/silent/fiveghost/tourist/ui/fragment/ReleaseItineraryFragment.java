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


import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 韩学文 on 2018/1/29.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */
/*
* 发布行程
* */
public class ReleaseItineraryFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.releaseitinerary_return)
    ImageView releaseitineraryReturn;
    @BindView(R.id.releaseitinerary_img)
    ImageView releaseitineraryImg;
    @BindView(R.id.releaseitinerary_radio1)
    RadioButton releaseitineraryRadio1;
    @BindView(R.id.releaseitinerary_radio2)
    RadioButton releaseitineraryRadio2;
    @BindView(R.id.releaseitinerary_fragment)
    FrameLayout releaseitineraryFragment;
    Unbinder unbinder;

    private FragmentManager msg;
    private FragmentTransaction transaction;
    private OneStopReleaseFragment one_stop_releaseFragment;
    private SubStationReleaseFragment sub_station_releaseFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_release_itinerary, container, false);

        unbinder = ButterKnife.bind(this, view);
        //判断home_pager是否为null
        if (one_stop_releaseFragment == null) {
            one_stop_releaseFragment = new OneStopReleaseFragment();
//            //设置首页默认被选中
            releaseitineraryRadio1.setChecked(true);
        }
        releaseitineraryImg.setOnClickListener(this);
        releaseitineraryReturn.setOnClickListener(this);
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

        one_stop_releaseFragment = new OneStopReleaseFragment();
        transaction.add(R.id.releaseitinerary_fragment, one_stop_releaseFragment);
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
            case R.id.releaseitinerary_return:

                break;
            case R.id.releaseitinerary_img:

                break;
            case R.id.releaseitinerary_radio1:
                if (one_stop_releaseFragment == null) {
                    one_stop_releaseFragment = new OneStopReleaseFragment();
                    transaction.add(R.id.releaseitinerary_fragment, this.one_stop_releaseFragment);
                } else {
                    transaction.show(one_stop_releaseFragment);
                }
                break;
            case R.id.releaseitinerary_radio2:
                if (sub_station_releaseFragment == null) {

                    sub_station_releaseFragment = new SubStationReleaseFragment();
                    transaction.add(R.id.releaseitinerary_fragment, this.sub_station_releaseFragment);
                } else {

                    transaction.show(sub_station_releaseFragment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (one_stop_releaseFragment != null) {
            transaction.hide(one_stop_releaseFragment);
        }
        if (sub_station_releaseFragment != null) {
            transaction.hide(sub_station_releaseFragment);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
