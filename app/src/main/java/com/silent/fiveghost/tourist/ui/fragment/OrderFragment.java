package com.silent.fiveghost.tourist.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.TabEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 韩学文 on 2018/1/28.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */
/*
*  订单
* */
public class OrderFragment extends Fragment implements View.OnClickListener{
    Unbinder unbinder;
    @BindView(R.id.rl_one_order)
    public RelativeLayout rl_one_order;
    @BindView(R.id.rl_two_order)
    public RelativeLayout rl_two_order;
    @BindView(R.id.rl_three_order)
    public RelativeLayout rl_three_order;
    @BindView(R.id.rl_for_order)
    public RelativeLayout rl_for_order;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rl_one_order.setOnClickListener(this);
        rl_two_order.setOnClickListener(this);
        rl_three_order.setOnClickListener(this);
        rl_for_order.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_one_order:
                gotoPublished("1","已发布订单");
                break;
            case R.id.rl_two_order:
                gotoPublished("2","已报名订单");
                break;
            case R.id.rl_three_order:
                gotoPublished("3","抢单订单");
                break;
            case R.id.rl_for_order:
                gotoPublished("4","我的订单");
                break;
        }
    }
    public void gotoPublished(String type,String title){
        List<TabEntity> mList = new ArrayList<>();
        mList.add(new TabEntity("未开始",type,"1"));
        mList.add(new TabEntity("进行中",type,"2"));
        mList.add(new TabEntity("未开始",type,"3"));
        Intent intent = new Intent(getContext(), PublishedOrderFragment.class);
        intent.putExtra("tabs", (Serializable) mList);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
