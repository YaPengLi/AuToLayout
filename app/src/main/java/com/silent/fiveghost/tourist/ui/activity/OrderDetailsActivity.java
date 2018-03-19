package com.silent.fiveghost.tourist.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.tourist.bean.GuideOrder;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 订单详情
* */
public class OrderDetailsActivity extends BaseActivity implements IView<GuideOrder>,View.OnClickListener{
    private IPresenter mPresenter;
    @BindView(R.id.mLeftIcon)
    public ImageView mLeftIcon;
    @BindView(R.id.mTitle)
    public TextView mTitle;
    @BindView(R.id.mCancel)
    public Button mCancel;
    @BindView(R.id.mUpdate)
    public Button mUpdate;
    @BindView(R.id.mImageView)
    public ImageView mImageView;
    @BindView(R.id.mContent)
    public TextView mContent;
    @BindView(R.id.mTime)
    public TextView mTime;
    @BindView(R.id.mPersonCount)
    public TextView mPersonCount;
    @BindView(R.id.mCity)
    public TextView mCity;
    @BindView(R.id.mPrice)
    public TextView mPrice;
    @BindView(R.id.mName)
    public TextView mName;
    @BindView(R.id.mPhone)
    public TextView mPhone;
    @BindView(R.id.mOrderId)
    public TextView mOrderId;
    @BindView(R.id.mBMTime)
    public TextView mBMTime;
    @BindView(R.id.mContacts)
    public LinearLayout mContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        mLeftIcon.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        mUpdate.setOnClickListener(this);
    }

    public void initData(){
        mPresenter = new IPresenter(this);
        Map<String,String> mMap = new HashMap<>();
        SharedPreferences preferences = getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
        String mToken = preferences.getString("accessToken", "");
        mMap.put("access_token",mToken);
        mMap.put("order_id",getIntent().getStringExtra("order_id"));
        mPresenter.DoRequest(UrlUtils.GUIDE_ORDER_URL+mToken,mMap);
    }
    @Override
    public void success(GuideOrder guideOrder) {
        GuideOrder.DataBean data = guideOrder.getData();
        Glide.with(this).load(data.getImg()).into(mImageView);
        mContent.setText(data.getName());
        mTime.setText(data.getTravel_time());
        mPersonCount.setText(data.getTourist_num()+"");
        mCity.setText(data.getTourist_num()+"天");
        mPrice.setText(data.getPrice());
        mName.setText("张三");
        mPhone.setText("15116547825");
        mOrderId.setText(data.getOrder_id());
        mBMTime.setText(data.getTravel_time());
        GuideOrder.DataBean.CommentBean comment = data.getComment();
        List<GuideOrder.DataBean.CommentBean.ItemsBean> items = comment.getItems();
        for(GuideOrder.DataBean.CommentBean.ItemsBean itemsBean:items){
            View view = LayoutInflater.from(this).inflate(R.layout.layout_item_lxr, null);
            TextView mName = view.findViewById(R.id.mName);
            TextView mPhone = view.findViewById(R.id.mPhone);
            mName.setText(itemsBean.getUsername());
            mPhone.setText(itemsBean.getTime());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            mContacts.addView(view,params);
        }
    }

    @Override
    public void defeat(String s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mLeftIcon:
                finish();
                break;
        }
    }
}
