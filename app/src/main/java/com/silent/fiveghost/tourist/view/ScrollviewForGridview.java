package com.silent.fiveghost.tourist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by haowl on 2017-11-11.
 */

public class ScrollviewForGridview extends GridView {
    public ScrollviewForGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollviewForGridview(Context context) {
        super(context);
    }

    public ScrollviewForGridview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
