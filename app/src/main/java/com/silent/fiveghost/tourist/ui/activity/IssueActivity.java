package com.silent.fiveghost.tourist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(发布页面)
 * @date 2018/3/14 01:05
 * <p>
 * ${TAGS}
 */
public class IssueActivity extends BaseActivity implements View.OnClickListener {

	@BindView(R.id.iv_back_all)
	ImageView ivBackAll;
	@BindView(R.id.tv_title_all)
	TextView tvTitleAll;
	@BindView(R.id.iv_message_all)
	ImageView ivMessageAll;
	@BindView(R.id.tv_issue_one_state)
	TextView tvIssueOneState;
	@BindView(R.id.tv_issue_sub_state)
	TextView tvIssueSubState;
	@BindView(R.id.ll_issue_tab)
	LinearLayout llIssueTab;
	@BindView(R.id.tv_issue_text_go)
	TextView tvIssueTextGo;
	@BindView(R.id.img_issue_icon_go)
	ImageView imgIssueIconGo;
	@BindView(R.id.rl_issue_go)
	RelativeLayout rlIssueGo;
	@BindView(R.id.rv_issue_go_city_list)
	RecyclerView rvIssueGoCityList;
	@BindView(R.id.tv_issue_text_to)
	TextView tvIssueTextTo;
	@BindView(R.id.img_issue_icon_to)
	ImageView imgIssueIconTo;
	@BindView(R.id.rl_issue_to)
	RelativeLayout rlIssueTo;
	@BindView(R.id.rv_issue_to_city_list)
	RecyclerView rvIssueToCityList;
	@BindView(R.id.btn_issue_submit)
	Button btnIssueSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_issue);
		ButterKnife.bind(this);

		initView();

	}

	private void initView() {
		btnIssueSubmit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_issue_submit:
				startActivity(new Intent(IssueActivity.this, IssueOneStepActivity.class));
				finish();
				break;


			default:
				break;
		}
	}
}
