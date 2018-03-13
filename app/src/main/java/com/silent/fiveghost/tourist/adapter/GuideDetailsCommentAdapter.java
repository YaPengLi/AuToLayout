package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.GuideDetailBean;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/14 00:00
 * <p>
 * ${TAGS}
 */
public class GuideDetailsCommentAdapter extends BaseQuickAdapter<GuideDetailBean.DataBean.CommentBean.ItemsBean,BaseViewHolder> {
	private Context mContext;
	public GuideDetailsCommentAdapter(Context context, List<GuideDetailBean.DataBean.CommentBean.ItemsBean> data) {
		super(R.layout.guide_detail_comment_item, data);
		this.mContext = context;
	}

	@Override
	protected void convert(BaseViewHolder helper, GuideDetailBean.DataBean.CommentBean.ItemsBean bean) {
		Glide.with(mContext).load(bean.getAvatar()).into((ImageView) helper.getView(R.id.avatar));
		helper.setText(R.id.tv_guide_detail_comment_name, bean.getUsername());
		helper.setText(R.id.tv_guide_detail_comment_time, bean.getTime());
//		helper.setText(R.id.tv_guide_detail_comment_content, bean.get());
	}
}
