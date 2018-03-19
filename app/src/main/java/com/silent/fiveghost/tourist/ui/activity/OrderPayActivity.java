package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.PersonBean;
import com.silent.fiveghost.tourist.ui.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(订单支付)
 * @date 2018/3/20 02:16
 * <p>
 * ${TAGS}
 */
public class OrderPayActivity extends BaseActivity {

	@BindView(R.id.iv_back_all)
	ImageView ivBackAll;
	@BindView(R.id.tv_title_all)
	TextView tvTitleAll;
	@BindView(R.id.iv_message_all)
	ImageView ivMessageAll;
	@BindView(R.id.img_order_pay_img)
	ImageView imgOrderPayImg;
	@BindView(R.id.tv_order_pay_price)
	TextView tvOrderPayPrice;
	@BindView(R.id.tv_order_pay_man_count)
	TextView tvOrderPayManCount;
	@BindView(R.id.tv_order_pay_child_count)
	TextView tvOrderPayChildCount;
	@BindView(R.id.tv_order_pay_info)
	TextView tvOrderPayInfo;
	@BindView(R.id.tv_order_pay_info_price)
	TextView tvOrderPayInfoPrice;
	@BindView(R.id.tv_order_pay_info_contact_name)
	TextView tvOrderPayInfoContactName;
	@BindView(R.id.tv_order_pay_info_contact_phone)
	TextView tvOrderPayInfoContactPhone;
	@BindView(R.id.tv_order_pay_info_contact_num)
	TextView tvOrderPayInfoContactNum;
	@BindView(R.id.tv_order_pay_info_contact_time)
	TextView tvOrderPayInfoContactTime;
	@BindView(R.id.tv_order_pay_info_trip_name)
	TextView tvOrderPayInfoTripName;
	@BindView(R.id.tv_order_pay_info_trip_card_id)
	TextView tvOrderPayInfoTripCardId;
	@BindView(R.id.tv_order_pay_info_trip_name2)
	TextView tvOrderPayInfoTripName2;
	@BindView(R.id.tv_order_pay_info_trip_card_id2)
	TextView tvOrderPayInfoTripCardId2;
	@BindView(R.id.tv_order_pay_info_trip_remark)
	TextView tvOrderPayInfoTripRemark;
	@BindView(R.id.btn_order_pay_submit)
	Button btnOrderPaySubmit;
	@BindView(R.id.tv_order_pay_trip_time)
	TextView tvOrderPayTripTime;

	private String money;
	private String starttime;
	private String endtimes;
	private String title;
	private String childnumber;
	private String adultnumber;
	private List<PersonBean> mlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_pay);
		ButterKnife.bind(this);

		initData();
		initView();

	}

	private void initView() {
		tvTitleAll.setText("订单支付");
		ivMessageAll.setVisibility(View.GONE);

		tvOrderPayPrice.setText(money);
		tvOrderPayInfoPrice.setText(money);
		btnOrderPaySubmit.setText("确认支付:" + money);
		tvOrderPayTripTime.setText(starttime + " 至 " + endtimes);
		tvOrderPayInfo.setText(title);
		tvOrderPayManCount.setText("成人:" + adultnumber);
		tvOrderPayChildCount.setText("儿童:" + childnumber);
//		Log.e("---", "===" + mlist.size());

	}

	private void initData() {
		money = getIntent().getStringExtra("money");
		starttime = getIntent().getStringExtra("starttime");
		endtimes = getIntent().getStringExtra("endtime");
		title = getIntent().getStringExtra("title");
		childnumber = getIntent().getStringExtra("childnumber");
		adultnumber = getIntent().getStringExtra("adultnumber");
		mlist = (List<PersonBean>) getIntent().getParcelableExtra("contact");


	}
}
