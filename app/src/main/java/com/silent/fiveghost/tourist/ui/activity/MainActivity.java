package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.os.Handler;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseActivity;


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
                startActivity(WelcomeActivity.class);

                finish();
            }
        }, 1000);
    }
}
