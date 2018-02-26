package com.silent.fiveghost.tourist.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silent.fiveghost.tourist.R;


/**
 * A simple {@link Fragment} subclass.
 * 电子发票
 */
public class Electronic_invoiceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.electronic_invoice, container,false);
        return view;
    }

}
