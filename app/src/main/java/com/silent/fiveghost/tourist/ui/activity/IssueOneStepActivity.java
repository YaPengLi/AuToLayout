package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseActivity;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(一站)
 * @date 2018/3/14 19:59
 * <p>
 * ${TAGS}
 */
public class IssueOneStepActivity extends BaseActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_issue_one_step);
		findViewById(R.id.iv_message_all).setVisibility(View.INVISIBLE);
		TextView title = findViewById(R.id.tv_title_all);
		title.setText("一站式行程");
	}
}
