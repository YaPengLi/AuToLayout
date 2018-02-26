package com.silent.fiveghost.tourist.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
*  特色
* */
public class FeaturesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.rv_shtick)
    ListView rvShtick;
    Unbinder unbinder;
    @BindView(R.id.spl_features)
    SwipeRefreshLayout swiper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.features, container, false);
        unbinder = ButterKnife.bind(this, view);
        rvShtick.setAdapter(new LvShtickAdapter());
        //为SwipeRefreshLayout设置监听事件
        swiper.setOnRefreshListener(this);
        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        swiper.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        //刷新
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //结束后停止刷新
                swiper.setRefreshing(false);
            }
        }, 3000);

    }

    private class LvShtickAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lvshtickitem, parent, false);

            return convertView;
        }


    }
}
