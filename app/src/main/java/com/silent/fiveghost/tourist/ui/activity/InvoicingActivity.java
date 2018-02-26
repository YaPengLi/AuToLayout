package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.silent.fiveghost.tourist.ui.fragment.Electronic_invoiceFragment;
import com.silent.fiveghost.tourist.ui.fragment.Paper_invoiceFragment;
import com.silent.fiveghost.tourist.R;

//发票开取
public class InvoicingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView invoicing_return;
    private RadioButton invoicing_radio1;
    private RadioButton invoicing_radio2;
    private FrameLayout invoicing_fragment;
    private FragmentManager msg;
    private FragmentTransaction transaction;
    private Electronic_invoiceFragment electronic_invoiceFragment;
    private Paper_invoiceFragment paper_invoiceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoicing);
        initView();
        initData();
    }

    private void initData() {
        //动态添加Fragment ,获取Fragment 管理器
        msg = getSupportFragmentManager();
        //开启Fragment事物
        transaction = msg.beginTransaction();

        electronic_invoiceFragment = new Electronic_invoiceFragment();
        transaction.add(R.id.invoicing_fragment, electronic_invoiceFragment);
        transaction.commit();
    }

    private void initView() {
        invoicing_return = (ImageView) findViewById(R.id.invoicing_return);
        invoicing_radio1 = (RadioButton) findViewById(R.id.invoicing_radio1);
        invoicing_radio2 = (RadioButton) findViewById(R.id.invoicing_radio2);
        invoicing_fragment = (FrameLayout) findViewById(R.id.invoicing_fragment);
        //        //判断home_pager是否为null
        if (electronic_invoiceFragment == null) {
            electronic_invoiceFragment = new Electronic_invoiceFragment();
//            //设置首页默认被选中
            invoicing_radio1.setChecked(true);
        }
        invoicing_return.setOnClickListener(this);
        invoicing_radio1.setOnClickListener(this);
        invoicing_radio2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //动态添加Fragment ,获取Fragment 管理器
        msg = getSupportFragmentManager();
        //开启Fragment事物
        transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        switch (v.getId()) {
            case R.id.invoicing_radio1:
                if ( electronic_invoiceFragment== null) {
                    electronic_invoiceFragment = new Electronic_invoiceFragment();
                    transaction.add(R.id.invoicing_fragment, this.electronic_invoiceFragment);
                } else {
                    transaction.show(electronic_invoiceFragment);
                }
                break;
            case R.id.invoicing_radio2:
                if ( paper_invoiceFragment== null) {
                    paper_invoiceFragment = new Paper_invoiceFragment();
                    transaction.add(R.id.invoicing_fragment, this.paper_invoiceFragment);
                } else {
                    transaction.show(paper_invoiceFragment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (electronic_invoiceFragment != null) {
            transaction.hide(electronic_invoiceFragment);
        }
        if (paper_invoiceFragment != null) {
            transaction.hide(paper_invoiceFragment);
        }
    }
}
