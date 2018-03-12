package com.silent.fiveghost.tourist.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.LoginBean;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.utils.Constant;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.Map;


/*
*  启动界面
* */
public class MainActivity extends BaseActivity {


    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                startActivity(WelcomeActivity.class);

//                finish();
                initshapec();
            }
        }, 1000);


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
}