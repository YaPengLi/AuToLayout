package com.silent.fiveghost.tourist.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.Documents;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.bean.TravelInfo;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.utils.Constant;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(一站)
 * @date 2018/3/14 19:59
 * <p>
 * ${TAGS}
 */
public class IssueOneStepActivity extends BaseActivity implements View.OnClickListener {
	@BindView(R.id.iv_back_all)
	ImageView ivBackAll;
	@BindView(R.id.tv_title_all)
	TextView tvTitleAll;
	@BindView(R.id.iv_message_all)
	ImageView ivMessageAll;
	@BindView(R.id.img1)
	ImageView img1;
	@BindView(R.id.img2)
	ImageView img2;
	@BindView(R.id.img3)
	ImageView img3;
	@BindView(R.id.img4)
	ImageView img4;
	@BindView(R.id.tv_issue_text_go)
	TextView tvIssueTextGo;
	@BindView(R.id.img_issue_icon_go)
	ImageView imgIssueIconGo;
	@BindView(R.id.rl_issue_go)
	RelativeLayout rlIssueGo;
	@BindView(R.id.tv_issue_text_end_time)
	TextView tvIssueTextEndTime;
	@BindView(R.id.img_issue_icon_end_time)
	ImageView imgIssueIconEndTime;
	@BindView(R.id.rl_issue_end)
	RelativeLayout rlIssueEnd;
	@BindView(R.id.img_issue_one_step_man_add)
	RelativeLayout imgIssueOneStepManAdd;
	@BindView(R.id.tv_issue_one_step_man_count_text)
	TextView tvIssueOneStepManCountText;
	@BindView(R.id.img_issue_one_step_man_subtract)
	RelativeLayout imgIssueOneStepManSubtract;
	@BindView(R.id.img_issue_one_step_day_add)
	RelativeLayout imgIssueOneStepDayAdd;
	@BindView(R.id.tv_issue_one_step_day_count_text)
	TextView tvIssueOneStepDayCountText;
	@BindView(R.id.img_issue_one_step_day_subtract)
	RelativeLayout imgIssueOneStepDaySubtract;
	@BindView(R.id.rv_issue_one_step_info_card)
	ListView rvIssueOneStepInfoCard;
	@BindView(R.id.img_issue_one_step_add_people)
	ImageView imgIssueOneStepAddPeople;
	@BindView(R.id.btn_issue_one_step_submit)
	Button submit;
	@BindView(R.id.et_info_name)
	EditText etInfoName;
	@BindView(R.id.et_info_id_num)
	EditText etInfoIdNum;
	@BindView(R.id.et_info_phone)
	EditText etInfoPhone;
	@BindView(R.id.et_info_remarks)
	EditText etInfoRemarks;
	@BindView(R.id.et_info_preference)
	EditText etInfoPreference;
	@BindView(R.id.et_issue_one_step_contacts)
	EditText etIssueOneStepContacts;
	@BindView(R.id.et_issue_one_step_contacts_phone)
	EditText etIssueOneStepContactsPhone;
	@BindView(R.id.tv_info_birthday)
	TextView tvInfoBirthday;
	@BindView(R.id.rl_info_birthday)
	RelativeLayout rlInfoBirthday;

	private SharedPreferences preferences;
	private IPresenter presenter;
	private DatePicker picker;

	private String startTime = "";
	private String birthDay = "";
	private int number = 1;
	private int days = 1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_issue_one_step);
		ButterKnife.bind(this);
		findViewById(R.id.iv_message_all).setVisibility(View.INVISIBLE);
		TextView title = findViewById(R.id.tv_title_all);
		title.setText("一站式行程");

		preferences = getSharedPreferences("the_username_and_password", MODE_PRIVATE);
		rlIssueGo.setOnClickListener(this);
		submit.setOnClickListener(this);
		imgIssueOneStepManAdd.setOnClickListener(this);
		imgIssueOneStepManSubtract.setOnClickListener(this);
		imgIssueOneStepDaySubtract.setOnClickListener(this);
		imgIssueOneStepDayAdd.setOnClickListener(this);

		rlInfoBirthday.setOnClickListener(this);
		rlIssueEnd.setOnClickListener(this);


	}

	private void sendData() {

		if (etIssueOneStepContacts.getText().equals("")) {
			showToast("联系人姓名不能为空！");
			return;
		}

		if (etIssueOneStepContactsPhone.getText().equals("")) {
			showToast("联系电话不能为空！");
			return;
		}

		if (startTime.equals("")) {
			showToast("请填写出行时间！");
		}

		if (etInfoPreference.getText().equals("")) {
			showToast("请填写偏好！");
		}

		if (etInfoName.getText().equals("")) {
			showToast("请填写出行人姓名！");
		}

		if (birthDay.equals("")) {
			showToast("请选择出行人生日！");
		}

		if (etInfoIdNum.getText().equals("")) {
			showToast("请填写出行人身份证号！");
		}

		if (etInfoPhone.getText().equals("")) {
			showToast("请填写出行人手机号！");
		}

//		etInfoIdNum

		Map<String, String> map = Constant.getMap();
		map.put("number", String.valueOf(number));
		map.put("age_group", "1");
		map.put("travel_time", startTime);
		map.put("travel_info", JSON.toJSONString(buildInfoParam()));
		map.put("documents", JSON.toJSONString(buildDocParam()));
		map.put("contacts", etIssueOneStepContacts.getText().toString().trim());
		map.put("contacts_tel", etIssueOneStepContactsPhone.getText().toString().trim());

		presenter = new IPresenter(new IView<HomeBean>() {

			@Override
			public void success(HomeBean homeBean) {

			}

			@Override
			public void defeat(String s) {
				Log.e("IssueOneStepActivity", s);
			}
		});
		presenter.DoRequest(UrlUtils.ONE_STEP_URL + preferences.getString("accessToken", ""), map);
	}

	private List<TravelInfo> buildInfoParam() {
		List<TravelInfo> list = new ArrayList<>();
		TravelInfo infoBean = new TravelInfo();

		infoBean.setCityId(1);
		infoBean.setGuide_type(1);
		infoBean.setPlay_days(days);
		infoBean.setTravel_preference(etInfoPreference.getText().toString().trim());
		infoBean.setRemarks(etInfoRemarks.getText().toString().trim());
		list.add(infoBean);
		return list;
	}

	private List<Documents> buildDocParam() {
		List<Documents> list = new ArrayList<>();
		Documents documentsBean = new Documents();
		documentsBean.setType(2);
		documentsBean.setUsername(etInfoName.getText().toString().trim());
		documentsBean.setBirthday(birthDay);
		documentsBean.setNumber(etInfoIdNum.getText().toString().trim());
		documentsBean.setRemarks(etInfoPhone.getText().toString().trim());
		list.add(documentsBean);
		return list;
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.rl_issue_go:
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
						tvIssueTextGo.setText(year + "-" + month + "-" + day);
						startTime = year + "-" + month + "-" + day;
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
			case R.id.rl_issue_end:
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
						tvIssueTextEndTime.setText(year + "-" + month + "-" + day);
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
			case R.id.rl_info_birthday:
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
						tvInfoBirthday.setText(year + "-" + month + "-" + day);
						birthDay = year + "-" + month + "-" + day;
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
			case R.id.img_issue_one_step_man_add:
				number++;
				if (number > 1) {
					imgIssueOneStepManSubtract.setClickable(true);
				} else {
					imgIssueOneStepManSubtract.setClickable(false);
				}
				tvIssueOneStepManCountText.setText(String.valueOf(number));
				break;
			case R.id.img_issue_one_step_man_subtract:
				number--;
				if (number > 1) {
					imgIssueOneStepManSubtract.setClickable(true);
				} else {
					imgIssueOneStepManSubtract.setClickable(false);
				}
				tvIssueOneStepManCountText.setText(String.valueOf(number));
				break;
			case R.id.img_issue_one_step_day_add:
				days++;
				if (days > 1) {
					imgIssueOneStepDaySubtract.setClickable(true);
				} else {
					imgIssueOneStepDaySubtract.setClickable(false);
				}
				tvIssueOneStepDayCountText.setText(String.valueOf(days));
				break;
			case R.id.img_issue_one_step_day_subtract:
				days--;
				if (days > 1) {
					imgIssueOneStepDaySubtract.setClickable(true);
				} else {
					imgIssueOneStepDaySubtract.setClickable(false);
				}
				tvIssueOneStepDayCountText.setText(String.valueOf(days));
				break;
			case R.id.btn_issue_one_step_submit:
				sendData();
				break;
			default:
				break;
		}
	}

}
