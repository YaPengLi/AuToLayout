package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

public class PasswordActivity extends BaseActivity {
    //修改密码
    private ImageView back_settings;
    private EditText mFormer_password;
    private EditText mNew_password;
    private EditText makesNew_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        initView();
        inonLister();
    }

    private void inonLister() {
        back_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initView() {
        back_settings = (ImageView) findViewById(R.id.back_settings);
        mFormer_password = (EditText) findViewById(R.id.mFormer_password);
        mNew_password = (EditText) findViewById(R.id.mNew_password);
        makesNew_password = (EditText) findViewById(R.id.makesNew_password);
    }

    private void submit() {
        // validate
        String former = mFormer_password.getText().toString().trim();
        if (TextUtils.isEmpty(former)) {
            Toast.makeText(this, "请输入原密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String newpass = mNew_password.getText().toString().trim();
        if (TextUtils.isEmpty(newpass)) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String makenew = makesNew_password.getText().toString().trim();
        if (TextUtils.isEmpty(makenew)) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }


    }
}
