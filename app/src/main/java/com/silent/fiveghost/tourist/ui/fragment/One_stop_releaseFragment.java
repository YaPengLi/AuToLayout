package com.silent.fiveghost.tourist.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.silent.fiveghost.tourist.ui.activity.One_stop_releaseActivity;
import com.silent.fiveghost.tourist.R;

/**
 * A simple {@link Fragment} subclass.
 * 一站式发布
 */
public class One_stop_releaseFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button releaseitinerary_btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.one_stop_release, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        releaseitinerary_btn1 = (Button) view.findViewById(R.id.releaseitinerary_btn1);

        releaseitinerary_btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.releaseitinerary_btn1:
                Intent intent = new Intent(getActivity(), One_stop_releaseActivity.class);
                startActivity(intent);
                break;
        }
    }
}
