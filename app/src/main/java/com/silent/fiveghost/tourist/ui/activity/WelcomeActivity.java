package com.silent.fiveghost.tourist.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.WelcomeAdapter;
import com.silent.fiveghost.tourist.bean.LoginBean;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.utils.Constant;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
*  欢迎界面   轮播图
* */
public class WelcomeActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {


	private ViewPager vp;
	private WelcomeAdapter vpAdapter;
	private List<View> views;

	//引导图片资源
	private static final int[] pics = {R.mipmap.start_one,
			R.mipmap.start_two,
			R.mipmap.start_one,
			R.mipmap.start_two};
	//底部小店图片
	private ImageView[] dots;
	//记录当前选中位置
	private int currentIndex;
	private LinearLayout ll;
	private Button bu_next;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		views = new ArrayList<View>();
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

		//初始化引导图片列表
		for (int i = 0; i < pics.length; i++) {
			ImageView iv = new ImageView(this);
			iv.setLayoutParams(mParams);
			iv.setImageResource(pics[i]);
			views.add(iv);
		}

		bu_next = findViewById(R.id.bu_next);
		vp = (ViewPager) findViewById(R.id.viewpager);
		vpAdapter = new WelcomeAdapter(views);  //初始化Adapter
		vp.setAdapter(vpAdapter);
		vp.setOnPageChangeListener(this);        //绑定回调
		initDots();        //初始化底部小点
		bu_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				initshapec();
			}
		});

	}

	//存储
	private void initshapec() {
		SharedPreferences preferences = getSharedPreferences("the_username_and_password", WelcomeActivity.MODE_PRIVATE);
		String username = preferences.getString("username", "");
		String password = preferences.getString("password", "");
		final SharedPreferences.Editor editor = preferences.edit();
		if (username.equals("") || password.equals("")) {
			startActivity(LoginActivity.class);
			finish();
		} else {
			IPresenter presenter = new IPresenter(new IView<LoginBean>() {

				@Override
				public void success(LoginBean loginBean) {
					if (loginBean.getErrcode() == 1) {
						String access_token = loginBean.getData().getUser().getAccess_token();
						if (access_token != null && !access_token.equals("")) {
							editor.putString("accessToken", access_token);
							editor.commit();
						}
						startActivity(HomeActivity.class);
						finish();
					} else {
						showToast("登录失败");
						startActivity(LoginActivity.class);
						finish();
					}
				}

				@Override
				public void defeat(String s) {
					showToast("登录失败");
					startActivity(LoginActivity.class);
					finish();
				}
			});
			Map<String, String> map = Constant.getMap();
			map.put("tel", username);
			map.put("password", password);
			map.put("category", "2");
			presenter.DoRequest(UrlUtils.LOGIN_URL, map);
		}
	}

	private void initDots() {
		ll = (LinearLayout) findViewById(R.id.ll);
		dots = new ImageView[pics.length];
		//循环取得小点图片
		for (int i = 0; i < pics.length; i++) {
			dots[i] = (ImageView) ll.getChildAt(i);
			dots[i].setEnabled(true);//都设为灰色
			dots[i].setOnClickListener(this);
			dots[i].setTag(i);//设置位置tag，方便取出与当前位置对应
		}

		currentIndex = 0;
		dots[currentIndex].setEnabled(false);//设置为白色，即选中状态
	}

	/**
	 * 设置当前的引导页
	 */
	private void setCurView(int position) {
		if (position < 0 || position >= pics.length) {
			return;
		}
		vp.setCurrentItem(position);
	}

	/**
	 * 这只当前引导小点的选中
	 */
	private void setCurDot(int positon) {
		if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
			return;
		}

		dots[positon].setEnabled(false);
		dots[currentIndex].setEnabled(true);

		currentIndex = positon;
	}

	//当滑动状态改变时调用
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	//当当前页面被滑动时调用
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		if (arg0 == 3) {
			ll.setVisibility(View.GONE);
			bu_next.setVisibility(View.VISIBLE);
		} else {
			ll.setVisibility(View.VISIBLE);
			bu_next.setVisibility(View.GONE);
		}

	}

	//当新的页面被选中时调用
	@Override
	public void onPageSelected(int arg0) {
		//设置底部小点选中状态
		setCurDot(arg0);
	}

	@Override
	public void onClick(View v) {
		int position = (Integer) v.getTag();
		setCurView(position);
		setCurDot(position);

	}

}
