package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.bean.OrderEntity;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(订单列表)
 * @date 2018/3/7 19:32
 * <p>
 * ${TAGS}
 */
public class OrderListEntityAdapter extends BaseQuickAdapter<OrderEntity.DataBean.ItemsBean, BaseViewHolder> {
	private Context mContext;

	public OrderListEntityAdapter(Context context, List<OrderEntity.DataBean.ItemsBean> data) {
		super(R.layout.guideitem, data);
		this.mContext = context;
	}
	@Override
	protected void convert(BaseViewHolder helper, OrderEntity.DataBean.ItemsBean item) {

	}
}
