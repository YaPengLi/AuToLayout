
package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.RoadAdapter;
import com.silent.fiveghost.tourist.bean.RoadBean;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.view.RoundImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
*  路线详情——定单内容
* */
public class RoadDetailsActivity extends BaseActivity implements View.OnClickListener {

    //大图
    @BindView(R.id.mRoad_Image)
    ImageView mRoadImage;

    //风景简介
    @BindView(R.id.mRoad_Landscape_Introduction)
    TextView mRoadLandscapeIntroduction;

    //成人价格
    @BindView(R.id.mRoad_Adult_price)
    TextView mRoadAdultPrice;

    //儿童价格
    @BindView(R.id.mRoad_Child_Price)
    TextView mRoadChildPrice;

    //旅游偏好
    @BindView(R.id.mRoad_Tourism_Preference)
    TextView mRoadTourismPreference;

    //优惠
    @BindView(R.id.mRoad_Discount)
    TextView mRoadDiscount;

    //优惠详情
    @BindView(R.id.mRoad_Discount_Details)
    ImageView mRoadDiscountDetails;
    //评论容器
    @BindView(R.id.mRoad_comment)
    LinearLayout mRoadComment;

    //时间RecyclerView
    @BindView(R.id.mRoad_Time_Rv)
    RecyclerView mRoadTimeRv;
    //更多日期
    @BindView(R.id.mRoad_More_Dates)
    TextView mRoadMoreDates;
    //Map
    @BindView(R.id.mRoad_Map)
    ImageView mRoadMap;

    //用户头像
    @BindView(R.id.mRoad_PersonIcon_one)
    RoundImageView mRoadPersonIconOne;
    @BindView(R.id.mRoad_PersonIcon_two)
    RoundImageView mRoadPersonIconTwo;
    @BindView(R.id.mRoad_PersonIcon_three)
    RoundImageView mRoadPersonIconThree;
    @BindView(R.id.mRoad_PersonIcon_four)
    RoundImageView mRoadPersonIconFour;

    //报名人数
    @BindView(R.id.mRoad_Enrolment)
    TextView mRoadEnrolment;

    //评分
    @BindView(R.id.mRoad_Score)
    TextView mRoadScore;
    //返回
    @BindView(R.id.mRoad_back)
    ImageView mRoadBack;

    //在线客服
    @BindView(R.id.mRoad_Online_Service)
    TextView mRoadOnlineService;
    //电话客服
    @BindView(R.id.mRoad_Chinese_Mainland_Only)
    TextView mRoadChineseMainlandOnly;
    //收藏
    @BindView(R.id.mRoad_Collection)
    TextView mRoadCollection;
    //立即报名
    @BindView(R.id.mRoad_Immediately_sign_up)
    TextView mRoadImmediatelySignUp;

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_details_version_two);
        bind = ButterKnife.bind(this);
        initData();
        initClick();
    }

    private void initClick() {
        mRoadBack.setOnClickListener(this);
        mRoadOnlineService.setOnClickListener(this);
        mRoadChineseMainlandOnly.setOnClickListener(this);
        mRoadCollection.setOnClickListener(this);
        mRoadImmediatelySignUp.setOnClickListener(this);
    }

    private void initData() {
        Glide.with(this).load("https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=f6b5e55ed3160924c828aa49b56e5e9f/f636afc379310a55f3515cfcb44543a982261044.jpg").into(mRoadImage);
        Glide.with(this).load("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=16e64bdd81d6277ffd1f3a6a49517455/b90e7bec54e736d1bec9536e9d504fc2d46269fa.jpg").into(mRoadMap);
        Glide.with(this).load("http://img5.imgtn.bdimg.com/it/u=3143513844,3462060495&fm=27&gp=0.jpg").into(mRoadPersonIconOne);
        Glide.with(this).load("http://img2.woyaogexing.com/2018/03/16/5028f1a3c9d5ac79!400x400_big.jpg").into(mRoadPersonIconTwo);
        Glide.with(this).load("http://img2.woyaogexing.com/2018/03/16/964f93b10b03cb10!400x400_big.jpg").into(mRoadPersonIconThree);
        Glide.with(this).load("http://img2.woyaogexing.com/2018/03/16/0af204d973f8fa97!400x400_big.jpg").into(mRoadPersonIconFour);
        ArrayList<String> images = new ArrayList<>();
        images.add("http://img2.woyaogexing.com/2018/03/16/c10fe7a7a063eabf!400x400_big.jpg");
        images.add("http://img2.woyaogexing.com/2018/03/16/9b7277ef36fac3cd!400x400_big.jpg");
        images.add("http://img2.woyaogexing.com/2018/03/16/5ed9bc0e6ba038e5!340x340_big.jpg");


        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.road_comment_item, mRoadComment, false);
            ImageView mRoad_comment_persion_icon = view.findViewById(R.id.mRoad_comment_persion_icon);
            TextView mRoad_user_name = view.findViewById(R.id.mRoad_user_name);
            TextView mRoad_Travel_Time = view.findViewById(R.id.mRoad_Travel_Time);
            TextView mRoad_comment_describe = view.findViewById(R.id.mRoad_comment_describe);
            Glide.with(this).load(images.get(i)).into(mRoad_comment_persion_icon);
            mRoadComment.addView(view);
        }


        mRoadTimeRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<RoadBean> roadBeans = new ArrayList<>();
        roadBeans.add(new RoadBean("01/26周五", "￥3960"));
        roadBeans.add(new RoadBean("01/27周六", "￥4020"));
        roadBeans.add(new RoadBean("01/28周一", "￥3960"));
        roadBeans.add(new RoadBean("01/29周二", "￥3860"));
        mRoadTimeRv.setAdapter(new RoadAdapter(R.layout.road_rv_item, roadBeans));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mRoad_back:
                finish();
                break;
            case R.id.mRoad_Online_Service:
                Toast.makeText(this, "在线客服", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRoad_Chinese_Mainland_Only:
                Toast.makeText(this, "电话客服", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRoad_Collection:
                Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRoad_Immediately_sign_up:
//                TODO 立即报名
//                startActivity();
                break;
        }
    }
}