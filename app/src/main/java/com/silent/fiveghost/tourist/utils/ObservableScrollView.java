package com.silent.fiveghost.tourist.utils;

/**
 * Created by 韩学文 on 2018/2/24.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 带滚动监听的scrollview
 */
public class ObservableScrollView extends ScrollView {


    private ScrollViewListener scrollViewListener = null;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {

            if (oldy < y ) {// 手指向上滑动，屏幕内容下滑
                scrollViewListener.onScroll(oldy,y,false);

            } else if (oldy > y ) {// 手指向下滑动，屏幕内容上滑
                scrollViewListener.onScroll(oldy,y,true);
            }

        }
    }

    public  interface ScrollViewListener{//dy Y轴滑动距离，isUp 是否返回顶部
        void onScroll(int oldy,int dy,boolean isUp);
    }
}