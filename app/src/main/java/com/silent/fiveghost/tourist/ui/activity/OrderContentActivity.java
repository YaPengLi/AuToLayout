package com.silent.fiveghost.tourist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.Ordercontent;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.view.IView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.DateTimePicker;
import cn.qqtheme.framework.util.ConvertUtils;

/*
* 订单内容——订单详情
* */
public class OrderContentActivity extends BaseActivity implements View.OnClickListener, IView<Ordercontent>{


//    private RelativeLayout rl_top_order_content;
    private ImageView rl_show_big_banner;
    private ImageView iv_one_order_content;
    private ImageView iv_two_order_content;
    private ImageView iv_three_order_content;
    private ImageView iv_four_order_content;
    private TextView tv_title;
    private ImageView image_icon;
    private TextView tv_smalltitle;
    private TextView bt_starttime;
    private TextView endtime;
    private TextView tv_sum_order_one;
    private TextView tv_votenumber;
    private TextView tv_price_order;
    private TextView tv_countprice;
    private ImageView image_less;
    private TextView peoplenumber;
    private ImageView image_add;
    private ImageView image_childless;
    private TextView tv_numberchild;
    private ImageView image_childadd;
    private TextView tv_group;
    private ImageView image_addpeople;
    private EditText et_name;
    private EditText et_phonenumber;
    private TextView tv_checkrestrictions;
    private Button bt_birthday;
    private EditText et_addcontent;
    private ImageView iv_add_order;
    private TextView tv_adultnumber;
    private TextView tv_childnumber;
    private TextView tv_money;
    private Button submit_orders_order;
    private DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_content);
        initView();
        IPresenter iPresenter = new IPresenter(this);
        HashMap<String, String> params = new HashMap<>();
        params.put("access_token","_za8e8fMg-ueDPbvVeZCBDWrFCrabPa-");
        params.put("rid","");
        int peopleNumber = getPeopleNumber();
        params.put("number",peopleNumber+"");
        params.put("age_group","2");
        params.put("documents",getDocuments());
        params.put("contacts",et_name.getText().toString());
        params.put("contacts_tel",et_phonenumber.getText().toString());
        iPresenter.DoRequest("http://120.79.137.110:83/api/v1/order/sign-up",params);
    }
    private String getDocuments() {
        String result = "";
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();
        try {
            object.put("type",2);
            object.put("username",et_name.getText().toString());
            object.put("birthday",bt_birthday.getText().toString());
            object.put("number",et_phonenumber.getText().toString());
            object.put("remarks",et_addcontent.getText().toString());
            array.put(object);
            result = array.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int getPeopleNumber() {
        String adultnumberstring= tv_adultnumber.getText().toString();
        String childnumberstring= tv_childnumber.getText().toString();
        int adultnumber = Integer.parseInt(adultnumberstring);
        int childnumber= Integer.parseInt(childnumberstring);
        int number= childnumber+adultnumber;
        return number;
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
        endtime = (TextView) findViewById(R.id.endtime);
        tv_sum_order_one = (TextView) findViewById(R.id.tv_sum_order_one);
        tv_votenumber = (TextView) findViewById(R.id.tv_votenumber);
        tv_price_order = (TextView) findViewById(R.id.tv_price_order);
        tv_countprice = (TextView) findViewById(R.id.tv_countprice);
        image_less = (ImageView) findViewById(R.id.image_less);
        peoplenumber = (TextView) findViewById(R.id.peoplenumber);
        image_add = (ImageView) findViewById(R.id.image_add);
        image_childless = (ImageView) findViewById(R.id.image_childless);
        tv_numberchild = (TextView) findViewById(R.id.tv_numberchild);
        image_childadd = (ImageView) findViewById(R.id.image_childadd);
        tv_group = (TextView) findViewById(R.id.tv_group);
        image_addpeople = (ImageView) findViewById(R.id.image_addpeople);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phonenumber = (EditText) findViewById(R.id.et_phonenumber);
        tv_checkrestrictions = (TextView) findViewById(R.id.tv_checkrestrictions);
        bt_birthday = (Button) findViewById(R.id.bt_birthday);
        et_addcontent = (EditText) findViewById(R.id.et_addcontent);
        iv_add_order = (ImageView) findViewById(R.id.iv_add_order);
        tv_adultnumber = (TextView) findViewById(R.id.tv_adultnumber);
        tv_childnumber = (TextView) findViewById(R.id.tv_childnumber);
        tv_money = (TextView) findViewById(R.id.tv_money);
        submit_orders_order = (Button) findViewById(R.id.submit_orders_order);
        bt_birthday.setOnClickListener(this);
        submit_orders_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_birthday:
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
                        bt_birthday.setText(year+"-"+month+"-"+day);
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
                Intent intent = new Intent();
                String money = tv_money.getText().toString();

                String starttime = bt_starttime.getText().toString();
                String endtimes = endtime.getText().toString();
                String title = tv_title.getText().toString();
                String childnumber = tv_childnumber.getText().toString();
                String adultnumber = tv_adultnumber.getText().toString();
                intent.putExtra("money",money);
                intent.putExtra("starttime",starttime);
                intent.putExtra("endtime",endtimes);
                intent.putExtra("title",title);
                intent.putExtra("childnumber",childnumber);
                intent.putExtra("adultnumber",adultnumber);
                startActivity(intent);
                break;
        }
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

        String addcontent = et_addcontent.getText().toString().trim();
        if (TextUtils.isEmpty(addcontent)) {
            Toast.makeText(this, "(内容补充。XX字以内)", Toast.LENGTH_SHORT).show();
            return;
        }
    }



    @Override
    public void success(Ordercontent ordercontent) {
        String data = ordercontent.getData().getData();




    }

    @Override
    public void defeat(String s) {

    }
}
