package com.silent.fiveghost.tourist.ui.activity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.presenter.ObservableScrollView;
import com.silent.fiveghost.tourist.presenter.ObservableScrollView.ScrollViewListener;
import com.silent.fiveghost.tourist.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  路线详情——定单内容
* */
public class RoadDetailsActivity extends BaseActivity implements ScrollViewListener, View.OnClickListener {

    @BindView(R.id.sign_up_immediately_road)
    Button signUpImmediatelyRoad;
    @BindView(R.id.bu_time_start)
    Button buTimeStart;
    @BindView(R.id.bu_time_end)
    Button buTimeEnd;
    private RelativeLayout observable_color;
    private RelativeLayout background_color;
    private ObservableScrollView scrollView;
    private int imageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_details);
        initView();
        initListeners();
        ButterKnife.bind(this);
        signUpImmediatelyRoad.setOnClickListener(this);
        buTimeStart.setOnClickListener(this);
        buTimeEnd.setOnClickListener(this);
    }

    private void initListeners() {
        // 获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = background_color.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                background_color.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                imageHeight = background_color.getHeight();

                scrollView.setScrollViewListener(RoadDetailsActivity.this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up_immediately_road:
                startActivity(OrderContentActivity.class);
                break;
            case R.id.bu_time_start:
                AlertDialog dialog = new AlertDialog.Builder(RoadDetailsActivity.this).create();
                dialog.show();
                DatePicker picker = new DatePicker(RoadDetailsActivity.this);

                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setContentView(picker, params);
                dialog.getWindow().setGravity(Gravity.CENTER);
                break;
            case R.id.bu_time_end:
                break;
        }
    }

    //设置滚动换背景色
    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y,
                                int oldx, int oldy) {
        if (y <= 0) {
            observable_color.setBackgroundColor(Color.argb((int) 0, 52, 57, 63));//AGB由相关工具获得，或者美工提供
        } else if (y > 0 && y <= imageHeight) {
            float scale = (float) y / imageHeight;
            float alpha = (255 * scale);
            // 只是layout背景透明(仿知乎滑动效果)
            observable_color.setBackgroundColor(Color.argb((int) alpha, 52, 57, 63));
        } else {
            observable_color.setBackgroundColor(Color.argb((int) 255, 52, 57, 63));
        }
    }



    private void initView() {
        observable_color = (RelativeLayout) findViewById(R.id.observable_color);
        background_color = (RelativeLayout) findViewById(R.id.background_color);
        scrollView = (ObservableScrollView) findViewById(R.id.color_scrollview);
    }
}
