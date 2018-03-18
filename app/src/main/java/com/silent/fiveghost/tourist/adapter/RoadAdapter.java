package com.silent.fiveghost.tourist.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.RoadBean;

import java.util.List;

/**
 * Created by 农民伯伯 on 2018/3/18.
 */

public class RoadAdapter extends BaseQuickAdapter<RoadBean,BaseViewHolder> {


    public RoadAdapter(int layoutResId, @Nullable List<RoadBean> data) {
        super(R.layout.road_rv_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RoadBean item) {

        helper.setText(R.id.Road_time_tv,item.getTime());
        helper.setText(R.id.Road_price_tv,item.getPrice());
    }
}
