package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
*  导游风采
* */
public class GuideStyleActivity extends BaseActivity {

    @BindView(R.id.iv_back_all)
    ImageView ivBackAll;
    @BindView(R.id.tv_title_all)
    TextView tvTitleAll;
    @BindView(R.id.iv_message_all)
    ImageView ivMessageAll;
    @BindView(R.id.lv_guide_style)
    RecyclerView rvGuideStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_style);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        ivMessageAll.setVisibility(View.GONE);
        tvTitleAll.setText("导游");
        ivBackAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomeActivity.class);
            }
        });
    }
}
