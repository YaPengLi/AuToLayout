package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.GuideDetailBean;
import com.silent.fiveghost.tourist.bean.HomeBean;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(热门路线适配器)
 * @date 2018/3/12 16:33
 * <p>
 * ${TAGS}
 */
public class GuideDetailsPathAdapter extends BaseAdapter implements View.OnClickListener {

	private Context mContext;
	private List<GuideDetailBean.DataBean.RouteBean> mList;

	public GuideDetailsPathAdapter(Context context, List<GuideDetailBean.DataBean.RouteBean> list) {
		this.mContext = context;
		this.mList = list;
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public int getCount() {
		return mList == null ? 0 : mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {

			viewHolder = new ViewHolder();
			// 获得容器
			convertView = LayoutInflater.from(mContext).inflate(R.layout.guild_detail_hot_path_item, null);
			// 初始化组件
			viewHolder.ivLogo = convertView.findViewById(R.id.img_guild_detail_item_image);
			viewHolder.tvTitle = convertView.findViewById(R.id.tv_guild_detail_item_text);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		Glide.with(mContext).load(mList.get(position).getImg() == null ? "" : mList.get(position).getImg().get(0)).into(viewHolder.ivLogo);
		viewHolder.tvTitle.setText(mList.get(position).getName());
		return convertView;
	}


	private class ViewHolder {
		private ImageView ivLogo;
		private TextView tvTitle;
	}
}

