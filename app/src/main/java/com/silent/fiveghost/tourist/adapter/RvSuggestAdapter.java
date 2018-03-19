package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.ui.activity.GuideStyleActivity;
import com.recker.flybanner.FlyBanner;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.activity.RoadDetailsActivity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 韩学文 on 2018/1/28.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class
RvSuggestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> strings;
    private List<HomeBean.DataBean.AdvertBean> advert;
    private List<HomeBean.DataBean.RouteBean> route;
    private List<HomeBean.DataBean.GuideBean> guide;

    public RvSuggestAdapter(Context context, List<String> strings, List<HomeBean.DataBean.AdvertBean> advert, List<HomeBean.DataBean.RouteBean> route, List<HomeBean.DataBean.GuideBean> guide) {
        this.context = context;
        this.strings = strings;
        this.advert = advert;
        this.route = route;
        this.guide = guide;

    }

    @Override
    public int getItemViewType(int position) {
        if (strings.get(position).equals("one")) {
            return 0;
        } else if (strings.get(position).equals("two")) {
            return 1;
        } else if (strings.get(position).equals("three")) {
            return 2;
        } else if (strings.get(position).equals("for")) {
            return 3;
        } else {
            return 0;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(context);
        RecyclerView.ViewHolder view1 = null;
        switch (viewType) {
            case 0:
                View v1 = from.inflate(R.layout.rvitemone, parent, false);
                view1 = new OneViewHolder(v1);
                break;
            case 1:
                View v2 = from.inflate(R.layout.rvitemtwo, parent, false);
                view1 = new TwoViewHolder(v2);
                break;
            case 2:
                View v3 = from.inflate(R.layout.rvitemthree, parent, false);
                view1 = new ThreeViewHolder(v3);
                break;
            case 3:
                View v4 = from.inflate(R.layout.rvitemfor, parent, false);
                view1 = new ForViewHolder(v4);
                break;

        }

        return view1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder) {
            List<String> bannerList = new ArrayList<String>();
            for (int a = 0; a < advert.size(); a++) {
                String img = advert.get(a).getImg();
                bannerList.add(img);
            }
            ((OneViewHolder) holder).fl_banner_one.setImagesUrl(bannerList);
        } else if (holder instanceof TwoViewHolder) {

        } else if (holder instanceof ThreeViewHolder) {
            ((ThreeViewHolder) holder).tv_content.setText(route.get(0).getName());
            Glide.with(context).load(route.get(0).getImg()).into(((ThreeViewHolder) holder).iv_rvitemthree_one);
            ((ThreeViewHolder) holder).tv_content_two.setText(route.get(1).getName());
            ((ThreeViewHolder) holder).tv_content_three.setText(route.get(2).getName());
            ((ThreeViewHolder) holder).tv_content_for.setText(route.get(3).getName());

            ((ThreeViewHolder) holder).cv_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, RoadDetailsActivity.class));
                }
            });
        } else if (holder instanceof ForViewHolder) {
            ScrollDisabledListViewAdapter adapter = new ScrollDisabledListViewAdapter(guide);
            ((ForViewHolder) holder).viewById.setAdapter(adapter);
            ((ForViewHolder) holder).guidestyle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, GuideStyleActivity.class));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }


    private class OneViewHolder extends RecyclerView.ViewHolder {

        private FlyBanner fl_banner_one;

        public OneViewHolder(View v1) {
            super(v1);
            AutoUtils.autoSize(v1);
            fl_banner_one = v1.findViewById(R.id.fl_banner_one);
        }
    }

    private class TwoViewHolder extends RecyclerView.ViewHolder {


        private LinearLayout ll_one_item_two;
        private LinearLayout ll_two_item_two;
        private LinearLayout ll_three_item_two;
        private LinearLayout ll_for_item_two;
        private LinearLayout ll_five_item_two;

        public TwoViewHolder(View v2) {
            super(v2);
            AutoUtils.autoSize(v2);
            ll_one_item_two = v2.findViewById(R.id.ll_one_item_two);
            ll_two_item_two = v2.findViewById(R.id.ll_two_item_two);
            ll_three_item_two = v2.findViewById(R.id.ll_three_item_two);
            ll_for_item_two = v2.findViewById(R.id.ll_for_item_two);
            ll_five_item_two = v2.findViewById(R.id.ll_five_item_two);
        }
    }

    private class ThreeViewHolder extends RecyclerView.ViewHolder {


        private TextView tv_content;
        private TextView tv_content_two;
        private TextView tv_content_three;
        private TextView tv_content_for;
        private CardView cv_one;
        private  ImageView iv_rvitemthree_one;

        public ThreeViewHolder(View v3) {
            super(v3);
            AutoUtils.autoSize(v3);
            tv_content = v3.findViewById(R.id.tv_content_card);
            tv_content_two = v3.findViewById(R.id.tv_content_two);
            tv_content_three = v3.findViewById(R.id.tv_content_three);
            tv_content_for = v3.findViewById(R.id.tv_content_for);
            iv_rvitemthree_one = v3.findViewById(R.id.iv_rvitemthree_one);
            cv_one = v3.findViewById(R.id.cv_one);

        }
    }

    private class ForViewHolder extends RecyclerView.ViewHolder {


        private ListView viewById;
        private RelativeLayout guidestyle;

        public ForViewHolder(View v4) {
            super(v4);
            AutoUtils.autoSize(v4);
            viewById = v4.findViewById(R.id.lv_suggect);
            guidestyle = v4.findViewById(R.id.rl_guidestyle_for);

        }
    }


    private class ScrollDisabledListViewAdapter extends BaseAdapter {
        private List<HomeBean.DataBean.GuideBean> stringList2;

        public ScrollDisabledListViewAdapter(List<HomeBean.DataBean.GuideBean> stringList2) {
            this.stringList2 = stringList2;
        }

        @Override
        public int getCount() {
            return stringList2.size();
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
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.guideitem, parent, false);
//                holder.tv_daoyou = convertView.findViewById(R.id.tv_content_card_for);
//                holder.iv_item_card = convertView.findViewById(R.id.iv_item_card);
//                holder.tv_content=convertView.findViewById(R.id.tv_guide_like);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_daoyou.setText(stringList2.get(position).getUsername());
            Glide.with(context).load(stringList2.get(position).getAvatar()).into(holder.iv_item_card);
            holder.tv_content.setText(stringList2.get(position).getGood_line_desc());
            return convertView;
        }

        class ViewHolder {
            TextView tv_daoyou;
            ImageView iv_item_card;
            TextView tv_content;
        }
    }
}

