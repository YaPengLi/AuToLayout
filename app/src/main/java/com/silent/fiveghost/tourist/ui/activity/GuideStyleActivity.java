package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
*  导游风采
* */
public class GuideStyleActivity extends BaseActivity {

    @BindView(R.id.iv_back_all)
    ImageView ivBackAll;
    @BindView(R.id.tv_title_all)
    TextView tvTitleAll;
    @BindView(R.id.iv_message_all)
    ImageView ivMessageAll;
    @BindView(R.id.lv_guide_style)
    ListView lvGuideStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_style);
        ButterKnife.bind(this);
        ivMessageAll.setVisibility(View.GONE);
        tvTitleAll.setText("导游");
        ivBackAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomeActivity.class);
            }
        });
        lvGuideStyle.setAdapter(new LvGuideAdapter());
        lvGuideStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(GuideDetailActivity.class);
            }
        });
    }

    class LvGuideAdapter extends BaseAdapter {

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
            convertView = LayoutInflater.from(GuideStyleActivity.this).inflate(R.layout.guidestyleitem, parent, false);
            return convertView;
        }
    }
}
