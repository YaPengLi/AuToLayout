package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silent.fiveghost.tourist.R;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/14 00:00
 * <p>
 * ${TAGS}
 */
public class GuideDetailsLikeAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
	public GuideDetailsLikeAdapter(Context context, List<String> data) {
		super(R.layout.guide_detail_like_item, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, String s) {
		helper.setText(R.id.text, s);
	}
}
