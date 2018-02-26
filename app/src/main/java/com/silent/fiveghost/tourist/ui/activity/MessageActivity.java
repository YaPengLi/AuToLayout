package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  信息界面
* */
public class MessageActivity extends BaseActivity {

    @BindView(R.id.iv_back_all)
    ImageView ivBackAll;
    @BindView(R.id.tv_title_all)
    TextView tvTitleAll;
    @BindView(R.id.iv_message_all)
    ImageView ivMessageAll;
    @BindView(R.id.lv_message)
    ListView lvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        ivMessageAll.setVisibility(View.GONE);
        tvTitleAll.setText("信息");
        ivBackAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomeActivity.class);
                finish();
            }
        });
    }
}
