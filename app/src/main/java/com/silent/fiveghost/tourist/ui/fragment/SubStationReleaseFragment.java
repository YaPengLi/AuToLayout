package com.silent.fiveghost.tourist.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.silent.fiveghost.tourist.ui.activity.SubStationReleaseActivity;
import com.silent.fiveghost.tourist.R;

/**
 * A simple {@link Fragment} subclass.
 * 分站式发布
 */
public class SubStationReleaseFragment extends Fragment implements View.OnClickListener {

    private Button releaseitinerary_btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.sub_station_release, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        releaseitinerary_btn2 = (Button) view.findViewById(R.id.releaseitinerary_btn2);

        releaseitinerary_btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.releaseitinerary_btn2:
                Intent intent = new Intent(getActivity(), SubStationReleaseActivity.class);
                startActivity(intent);
                break;
        }
    }
}
