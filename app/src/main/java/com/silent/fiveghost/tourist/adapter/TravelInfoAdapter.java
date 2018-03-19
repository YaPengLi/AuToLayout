package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.OneStepBean;
import com.silent.fiveghost.tourist.bean.TravelInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/19 16:26
 * <p>
 * ${TAGS}
 */
public class TravelInfoAdapter extends BaseAdapter {
	private TravelInfo travelInfo;

	private int mCount = 0;
	private Context mContext;
	private List<Integer> mList;

	public TravelInfoAdapter(int itemCount, Context context) {
		this.mContext = context;
		this.mCount = itemCount;
		mList = new ArrayList<>();
	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public Object getItem(int position) {
		return getItem(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.travel_info_item, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i) != position) {
				getTravelInfo();
			}
		}
		return convertView;
	}

	private TravelInfo getTravelInfo() {
		travelInfo = new TravelInfo();


		return travelInfo;
	}

	public List<TravelInfo> getTravelInfoList() {
		List<TravelInfo> list = new ArrayList<>();
		travelInfo = new TravelInfo();


		return list;
	}


	class ViewHolder {
		@BindView(R.id.et_info_name)
		EditText etInfoName;
		@BindView(R.id.tv_issue_text_end_time)
		TextView tvIssueTextEndTime;
		@BindView(R.id.img_issue_icon_end_time)
		ImageView imgIssueIconEndTime;
		@BindView(R.id.rl_issue_end)
		RelativeLayout rlIssueEnd;
		@BindView(R.id.et_info_id_num)
		EditText etInfoIdNum;
		@BindView(R.id.et_info_phone)
		EditText etInfoPhone;
		@BindView(R.id.et_info_remarks)
		EditText etInfoRemarks;

		ViewHolder(View view) {
			ButterKnife.bind(mContext, view);
		}
	}
}
