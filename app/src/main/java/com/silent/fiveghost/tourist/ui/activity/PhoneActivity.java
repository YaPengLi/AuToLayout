package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

public class PhoneActivity extends BaseActivity {
    //绑定手机
    private ImageView back_settings;
    private EditText phone_id;
    private EditText verification_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
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
        phone_id = (EditText) findViewById(R.id.phone_id);
        verification_id = (EditText) findViewById(R.id.verification_id);
    }

    private void submit() {
        String phone = phone_id.getText().toString().trim();
        String verification = verification_id.getText().toString().trim();

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "您的输入有误,请仔细核对", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}
