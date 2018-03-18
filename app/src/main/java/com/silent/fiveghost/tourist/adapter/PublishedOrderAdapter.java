package com.silent.fiveghost.tourist.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.PublishedOrderBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/16.
 */

public class PublishedOrderAdapter extends BaseQuickAdapter<PublishedOrderBean.DataBean.ItemsBean,BaseViewHolder> {
    public PublishedOrderAdapter(Context context, List<PublishedOrderBean.DataBean.ItemsBean> data) {
        super(R.layout.guide_detail_like_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PublishedOrderBean.DataBean.ItemsBean s) {
        helper.setText(R.id.text, s.getName());
        helper.setText(R.id.mInfo,s.getComment_num()+"人付款，"+s.getRecommend_num()+"条评论，"+s.getComment_num()+"收藏");
        helper.setText(R.id.mPrice,"价格");

    }
}
