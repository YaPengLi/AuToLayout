package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseActivity;

//设置
public class SettingActivity extends BaseActivity {


    private ImageView back_settings_finsh;//返回键
    private LinearLayout setting_safety;// <!--<账号安全>-->

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initonLister();
    }

    private void initonLister() {
        back_settings_finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setting_safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SafetyActivity.class);
            }
        });
    }


    private void initView() {
        back_settings_finsh = (ImageView) findViewById(R.id.back_settings_finsh);
        setting_safety = (LinearLayout) findViewById(R.id.setting_safety);
    }
}
