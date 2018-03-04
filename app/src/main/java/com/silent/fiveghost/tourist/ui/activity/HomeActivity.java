package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.silent.fiveghost.tourist.adapter.HomeVpAdapter;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.ui.fragment.FeaturesFragment;
import com.silent.fiveghost.tourist.ui.fragment.OrderFragment;
import com.silent.fiveghost.tourist.ui.fragment.PersonalFragment;
import com.silent.fiveghost.tourist.ui.fragment.RecommendFragment;
import com.silent.fiveghost.tourist.ui.fragment.ReleaseItineraryFragment;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.utils.StatusBarUtil;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  主页
* */
public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.mRadioGroup)
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StatusBarUtil.StatusBarLightMode(HomeActivity.this, 1);
        ButterKnife.bind(this);
        List<Fragment> fragmentList = new ArrayList<>();
        RecommendFragment recommendFragment = new RecommendFragment();
        FeaturesFragment featuresFragment = new FeaturesFragment();
        ReleaseItineraryFragment releaseItineraryFragment = new ReleaseItineraryFragment();
        OrderFragment orderFragment = new OrderFragment();
        PersonalFragment personalFragment = new PersonalFragment();
        fragmentList.add(recommendFragment);
        fragmentList.add(featuresFragment);
        fragmentList.add(releaseItineraryFragment);
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
                        mRadioGroup.check(R.id.mRadio_home);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.mRadio_route);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.mRadio_GrabaSingle);
                        break;
                    case 3:
                        mRadioGroup.check(R.id.mRadio_order);
                        break;
                    case 4:
                        mRadioGroup.check(R.id.mRadio_persional);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mRadioGroup.setOnCheckedChangeListener(this);
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //获取当前容器内部有多少个子控件
        int count = group.getChildCount();
        int checkedPos = 0;
        //遍历RadioGroup中的每一个RadioButton，看看第一个选中了
        //因为ViewPager 设置显示页面，需要指定的是索引

        for (int i = 0; i < count; i++) {
            View v = group.getChildAt(i);
            if (v instanceof RadioButton) {
                RadioButton rb = (RadioButton) v;
                boolean checked = rb.isChecked();
                if (checked) {
                    checkedPos = i;
                    //因为每次只能显示一页，所以只有一个按钮处于选中状态
                    //直接跳出循环就可以
                    break;
                }
            }
        }

        //第二个参数的意思是是否有平滑滚动
        vpHome.setCurrentItem(checkedPos, false);
    }
}
