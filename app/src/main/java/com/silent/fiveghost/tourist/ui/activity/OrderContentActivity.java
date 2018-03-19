package com.silent.fiveghost.tourist.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.Ordercontent;
import com.silent.fiveghost.tourist.bean.PersonBean;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.view.IView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;
import info.hoang8f.android.segmented.SegmentedGroup;

/*
* 订单内容——订单详情
* */
public class OrderContentActivity extends BaseActivity implements View.OnClickListener, IView<Ordercontent> {


    //    private RelativeLayout rl_top_order_content;
    /**
     * 主图
     * */
    private ImageView rl_show_big_banner;
    /**
     * 次图
     * */
    private ImageView iv_one_order_content;
    private ImageView iv_two_order_content;
    private ImageView iv_three_order_content;
    private ImageView iv_four_order_content;
    /**
     * 路线名称
     * */
    private TextView tv_title;
    //地址icon
    private ImageView image_icon;
    //地址
    private TextView tv_smalltitle;
    //开始时间
    private TextView bt_starttime;
    //结束时间
    private TextView endtime;
    //总票张数
    private TextView tv_votenumber;
    //总价
    private TextView tv_countprice;
    //成人票减
    private ImageView image_less;
    //成人票数量
    private TextView peoplenumber;
    //成人票添加
    private ImageView image_add;
    private EditText et_name;
    private EditText et_phonenumber;
    //查看预订限制
    private TextView tv_checkrestrictions;
    //添加订单
    private ImageView iv_add_order;
    //底部总价
    private TextView tv_money;
    //提交订单
    private Button submit_orders_order;
    private DatePicker picker;
    //返回按钮
    private ImageView mLeftIcon;
    //标题
    private TextView mTitle;
    private RelativeLayout mFootLayout;
    //儿童票减按钮
    private ImageView mChildSubtract;
    //儿童票数
    private TextView mChildNum;
    //儿童票添加按钮
    private ImageView mChildAdd;
    //团票价格
    private TextView mGroupPrice;
    //开启团票
    private ImageView mGroupOpen;
    private RadioButton radioButtonOne;
    private RadioButton radioButtonTwo;
    private SegmentedGroup mSegmentedGroup;
    //添加联系人组
    private LinearLayout mContactsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_content);
        initView();
    }






    private void initView() {
//        rl_top_order_content = (RelativeLayout) findViewById(R.id.rl_top_order_content);
        rl_show_big_banner = (ImageView) findViewById(R.id.rl_show_big_banner);
        iv_one_order_content = (ImageView) findViewById(R.id.iv_one_order_content);
        iv_two_order_content = (ImageView) findViewById(R.id.iv_two_order_content);
        iv_three_order_content = (ImageView) findViewById(R.id.iv_three_order_content);
        iv_four_order_content = (ImageView) findViewById(R.id.iv_four_order_content);
        tv_title = (TextView) findViewById(R.id.tv_title);
        image_icon = (ImageView) findViewById(R.id.image_icon);
        tv_smalltitle = (TextView) findViewById(R.id.tv_smalltitle);
        bt_starttime = (TextView) findViewById(R.id.bt_starttime);
        bt_starttime.setOnClickListener(this);
        endtime = (TextView) findViewById(R.id.endtime);
        endtime.setOnClickListener(this);
        tv_votenumber = (TextView) findViewById(R.id.tv_votenumber);
        tv_countprice = (TextView) findViewById(R.id.tv_countprice);
        image_less = (ImageView) findViewById(R.id.image_less);
        peoplenumber = (TextView) findViewById(R.id.peoplenumber);
        image_add = (ImageView) findViewById(R.id.image_add);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phonenumber = (EditText) findViewById(R.id.et_phonenumber);
        tv_checkrestrictions = (TextView) findViewById(R.id.tv_checkrestrictions);

        iv_add_order = (ImageView) findViewById(R.id.iv_add_order);
        iv_add_order.setOnClickListener(this);
        tv_money = (TextView) findViewById(R.id.tv_money);
        submit_orders_order = (Button) findViewById(R.id.submit_orders_order);
//        bt_birthday.setOnClickListener(this);
//        submit_orders_order.setOnClickListener(this);
        mLeftIcon = (ImageView) findViewById(R.id.mLeftIcon);
        mLeftIcon.setOnClickListener(this);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mTitle.setOnClickListener(this);
        mFootLayout = (RelativeLayout) findViewById(R.id.mFootLayout);
        mFootLayout.setOnClickListener(this);
        mChildSubtract = (ImageView) findViewById(R.id.mChildSubtract);
        mChildSubtract.setOnClickListener(this);
        mChildNum = (TextView) findViewById(R.id.mChildNum);
        mChildNum.setOnClickListener(this);
        mChildAdd = (ImageView) findViewById(R.id.mChildAdd);
        mChildAdd.setOnClickListener(this);
        mGroupPrice = (TextView) findViewById(R.id.mGroupPrice);
        mGroupPrice.setOnClickListener(this);
        mGroupOpen = (ImageView) findViewById(R.id.mGroupOpen);
        mGroupOpen.setOnClickListener(this);
        radioButtonOne = (RadioButton) findViewById(R.id.radioButtonOne);
        radioButtonOne.setOnClickListener(this);
        radioButtonTwo = (RadioButton) findViewById(R.id.radioButtonTwo);
        radioButtonTwo.setOnClickListener(this);
        mSegmentedGroup = (SegmentedGroup) findViewById(R.id.mSegmentedGroup);
//        mSegmentedGroup.setTintColor(Color.parseColor("#FFFFFF"),Color.parseColor("#000000"));
        mContactsLayout = (LinearLayout) findViewById(R.id.mContactsLayout);
        mContactsLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_starttime:
                picker = new DatePicker(this);
                picker.setCanceledOnTouchOutside(true);
                picker.setUseWeight(true);
                picker.setTopPadding(ConvertUtils.toPx(this, 10));
                picker.setRangeEnd(2111, 1, 1);
                picker.setRangeStart(1900, 1, 1);
                picker.setSelectedItem(2018, 6, 15);
                picker.setResetWhileWheel(false);
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        bt_starttime.setText(year + "-" + month + "-" + day);
                    }
                });
                picker.setOnWheelListener(new DatePicker.OnWheelListener() {
                    @Override
                    public void onYearWheeled(int index, String year) {
                        picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onMonthWheeled(int index, String month) {
                        picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onDayWheeled(int index, String day) {
                        picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
                    }
                });
                picker.show();
                break;
            case R.id.endtime:
                picker = new DatePicker(this);
                picker.setCanceledOnTouchOutside(true);
                picker.setUseWeight(true);
                picker.setTopPadding(ConvertUtils.toPx(this, 10));
                picker.setRangeEnd(2111, 1, 1);
                picker.setRangeStart(1900, 1, 1);
                picker.setSelectedItem(2018, 6, 15);
                picker.setResetWhileWheel(false);
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        endtime.setText(year + "-" + month + "-" + day);
                    }
                });
                picker.setOnWheelListener(new DatePicker.OnWheelListener() {
                    @Override
                    public void onYearWheeled(int index, String year) {
                        picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onMonthWheeled(int index, String month) {
                        picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onDayWheeled(int index, String day) {
                        picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
                    }
                });
                picker.show();

                break;
            case R.id.submit_orders_order:
                submit();
                //TODO

                break;
            case R.id.iv_add_order:
                addContact();
                break;
        }
    }
    private void addContact(){
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_contact, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mContactsLayout.addView(inflate,params);
    }
    private void submit() {
        // validate
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入您的姓名", Toast.LENGTH_SHORT).show();
            return;
        }

        String phonenumber = et_phonenumber.getText().toString().trim();
        if (TextUtils.isEmpty(phonenumber)) {
            Toast.makeText(this, "请输入您的电话", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        String money = tv_money.getText().toString();
        String starttime = bt_starttime.getText().toString();
        String endtimes = endtime.getText().toString();
        String title = tv_title.getText().toString();
        String childnumber = peoplenumber.getText().toString();
        String adultnumber = mChildNum.getText().toString();
        intent.putExtra("money", money);
        intent.putExtra("starttime", starttime);
        intent.putExtra("endtime", endtimes);
        intent.putExtra("title", title);
        intent.putExtra("childnumber", childnumber);
        intent.putExtra("adultnumber", adultnumber);
        intent.putExtra("contact", (Serializable) getPerson());
        startActivity(intent);
    }
    public List<PersonBean> getPerson(){
        int childCount = mContactsLayout.getChildCount();
        List<PersonBean> mList = new ArrayList<>();
        for (int i = 0 ; i< childCount;i++){
            View childAt = mContactsLayout.getChildAt(i);
            SegmentedGroup group = childAt.findViewById(R.id.mSegmentedGroup);
            EditText mName =  childAt.findViewById(R.id.mName);
            EditText mBirthday =  childAt.findViewById(R.id.mBirthday);
            EditText mID =  childAt.findViewById(R.id.mID);
            EditText mPhone =  childAt.findViewById(R.id.mPhone);
            EditText mRemarks =  childAt.findViewById(R.id.mRemarks);
            if(null==mName||mName.equals("")||null==mBirthday||mBirthday.equals("")||null==mID||mID.equals("")){
                continue;
            }
            int checkedRadioButtonId = group.getCheckedRadioButtonId();
            int type = 1;
            if (checkedRadioButtonId==R.id.radioButtonOne){
                type = 1;
            }else{
                type = 2;
            }
            PersonBean bean = new PersonBean(type,mName.getText().toString(),mBirthday.getText().toString()
                    ,Integer.valueOf(mID.getText().toString()),mRemarks.getText().toString());
            mList.add(bean);
        }
        return mList;
    }

    @Override
    public void success(Ordercontent ordercontent) {
        String data = ordercontent.getData().getData();
    }

    @Override
    public void defeat(String s) {

    }
}
