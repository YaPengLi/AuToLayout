package com.silent.fiveghost.tourist.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.activity.CollectActivity;
import com.silent.fiveghost.tourist.ui.activity.HelpCenterActivity;
import com.silent.fiveghost.tourist.ui.activity.SettingActivity;

/*
* 个人中心-----
* */
public class PersonalFragment extends Fragment {
    private LinearLayout isme_settings_six;//设置
    private LinearLayout isme_help_seven;//帮助
    private LinearLayout isme_collect;//收藏
    private ImageView img_title;//头像

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.isme, container, false);
        initView(view);
        Glide.with(getContext()).load(R.drawable.isme_imgtitle).into(img_title);
        initonClike();
        return view;
    }

    private void initonClike() {
        //收藏
        isme_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CollectActivity.class));
            }
        });
        //设置
        isme_settings_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SettingActivity.class));
            }
        });
        //帮助中心
        isme_help_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HelpCenterActivity.class));
            }
        });

        img_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//头像
    }




    private void initView(View view) {
        isme_settings_six = (LinearLayout) view.findViewById(R.id.isme_settings_six);
        isme_help_seven = (LinearLayout) view.findViewById(R.id.isme_helpzx_seven);
        isme_collect = (LinearLayout) view.findViewById(R.id.isme_collect);
        img_title = (ImageView) view.findViewById(R.id.img_title);
    }


}
