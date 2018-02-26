package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

//帮助中心
public class HelpCenterActivity extends BaseActivity {

    private ImageView back_settings;//返回
    private LinearLayout helpCenter_abouts;//关于我们
    private LinearLayout helpCenter_x;//XXXX

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        initView();
        initdaLister();
    }

    private void initdaLister() {
        helpCenter_abouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        helpCenter_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        back_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        back_settings = (ImageView) findViewById(R.id.back_settings);
        helpCenter_abouts = (LinearLayout) findViewById(R.id.helpCenter_abouts);
        helpCenter_x = (LinearLayout) findViewById(R.id.helpCenter_x);
    }
}
