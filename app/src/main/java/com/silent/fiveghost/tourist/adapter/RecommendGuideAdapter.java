package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.HomeBean;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(首页导游风采列表)
 * @date 2018/3/7 19:32
 * <p>
 * ${TAGS}
 */
public class RecommendGuideAdapter extends BaseQuickAdapter<HomeBean.DataBean.GuideBean, BaseViewHolder> {
	private Context mContext;

	public RecommendGuideAdapter(Context context, List<HomeBean.DataBean.GuideBean> data) {
		super(R.layout.guideitem, data);
		this.mContext = context;
	}

	@Override
	protected void convert(BaseViewHolder helper, HomeBean.DataBean.GuideBean item) {
		Glide.with(mContext).load(item.getAvatar()).into((ImageView) helper.getView(R.id.iv_recommend_guide_item_img));

		helper.setText(R.id.tv_recommend_guide_item_title, item.getUsername());
		helper.setText(R.id.tv_recommend_guide_item_preference, item.getGood_line_desc());
		Log.e("convert", "----" + helper.getLayoutPosition());
//		helper.setText(R.id.tv_recommend_guide_item_title, item.getUsername());
	}
}
