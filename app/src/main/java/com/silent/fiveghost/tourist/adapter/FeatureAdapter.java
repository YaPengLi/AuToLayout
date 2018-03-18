package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.FeaturesBean;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/13 03:25
 * <p>
 * ${TAGS}
 */
public class FeatureAdapter extends BaseQuickAdapter<FeaturesBean.DataBean.ItemsBean, BaseViewHolder> {

	private Context mContext;

	public FeatureAdapter(Context context, List<FeaturesBean.DataBean.ItemsBean> data) {
		super(R.layout.feature_item, data);
		this.mContext = context;
	}

	@Override
	protected void convert(BaseViewHolder helper, FeaturesBean.DataBean.ItemsBean item) {
		helper.setText(R.id.tv_feature_item_title, item.getName());
		helper.setText(R.id.tv_feature_item_price, item.getPrice());
		helper.setText(R.id.tv_feature_item_pay, item.getPayment_num() + "人付款");
		helper.setText(R.id.tv_feature_item_comment, item.getComment_num() + "人评论");
		helper.setText(R.id.tv_feature_item_collect, item.getRecommend_num() + "人收藏");

		Glide.with(mContext).load(item.getImg()).into((ImageView) helper.getView(R.id.img_feature_item_icon));
	}
}
