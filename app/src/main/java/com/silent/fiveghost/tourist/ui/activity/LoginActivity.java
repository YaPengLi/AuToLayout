package com.silent.fiveghost.tourist.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.ForgetBean;
import com.silent.fiveghost.tourist.bean.LoginBean;
import com.silent.fiveghost.tourist.bean.VerificationCodeBean;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.utils.Constant;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.Map;

/*
*  登录界面
* */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText login_edit_yhm;//用户名
    private EditText login_edit_mm;//密码
    private Button login_btn;//登录
    private TextView login_wangji;//忘记密码
    private TextView login_zhuce;//注册
    private EditText pop_phone;
    private EditText pop_password;
    private EditText pop_code;
    private Button pop_btn;
    private int errcode;
    private boolean a = true;
    private PopupWindow popupWindow;
    private ImageView pop_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initdata() {
        //账号密码存储
        SharedPreferences preferences = getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("username", login_edit_yhm.getText().toString());
        edit.putString("password", login_edit_mm.getText().toString());
        edit.commit();

    }

    private void initView() {
        login_edit_yhm = (EditText) findViewById(R.id.login_edit_yhm);
        login_edit_mm = (EditText) findViewById(R.id.login_edit_mm);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_wangji = (TextView) findViewById(R.id.login_wangji);
        login_zhuce = (TextView) findViewById(R.id.login_zhuce);
        login_zhuce.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        login_zhuce.getPaint().setAntiAlias(true);//抗锯齿
        login_zhuce.setText(Html.fromHtml("" + "新用户？立即注册" + ""));
        login_edit_yhm.setOnClickListener(this);
        login_edit_mm.setOnClickListener(this);
        login_btn.setOnClickListener(this);
        login_wangji.setOnClickListener(this);
        login_zhuce.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //登录
            case R.id.login_btn:
                startActivity(HomeActivity.class);

                loginSubmit();
                break;
            //忘记密码
            case R.id.login_wangji:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //自动弹出键盘
                        InputMethodManager inputManager = (InputMethodManager) LoginActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                        //制隐藏Android输入法窗口
                        // inputManager.hideSoftInputFromWindow(edit.getWindowToken(),0);
                    }
                }, 100);

                //创建一个pop 必须传递的三个字段view  宽，高  三个少了一个出不来
                View view = View.inflate(LoginActivity.this, R.layout.popupview, null);

                pop_img = (ImageView) view.findViewById(R.id.pop_img);
                pop_phone = (EditText) view.findViewById(R.id.pop_phone);
                pop_password = (EditText) view.findViewById(R.id.pop_password);
                pop_code = (EditText) view.findViewById(R.id.pop_code);
                pop_code.setOnClickListener(this);
                pop_btn = (Button) view.findViewById(R.id.pop_btn);
                pop_btn.setOnClickListener(this);
                popupWindow = new PopupWindow(view, 900, 1400);
                //获取焦点
                popupWindow.setFocusable(true);
                //window设置背景，如果不设置背景
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                //设置pop在btn的下面x方向偏移，y方向偏移，这里的show方法一定要放在所有的设置之后，否则消失会不起作用
                popupWindow.showAtLocation(login_wangji, Gravity.CENTER, 0, 0);
                //设置popwindow的消失的监听
//                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//                    @Override
//                    public void onDismiss() {
//                        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                });
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
//                //给popWindow设置动画
//                ObjectAnimator//
//                        .ofFloat(view, "rotationX", 0.0F, 360.0F)//
//                        .setDuration(500)//
//                        .start();
                break;
            //注册
            case R.id.login_zhuce:
                startActivity(RegisterActivity.class);

                break;
            //pop获取验证码点击事件
            case R.id.pop_btn:
                if (pop_code.getText().toString() == null || pop_code.getText().toString().equals("")) {
                    a = true;
                } else {
                    a = false;
                }

                if (a) {
                    String phone = pop_phone.getText().toString().trim();
                    String password = pop_password.getText().toString().trim();
                    if (phone == null) {
                        showToast("手机号不能为空");
                        return;
                    }
                    if (password == null) {
                        showToast("密码不能为空");
                        return;
                    }
                    if (phone == null || password == null || phone.equals("") || password.equals("")) {
                        a = true;
                        return;
                    }
                    Map<String, String> map = Constant.getMap();
                    map.put("mobile", phone);
                    map.put("module", "1");
                    map.put("imei", Constant.getPhoneIMEI(LoginActivity.this));
                    IPresenter presenter = new IPresenter(new IView<VerificationCodeBean>() {

                        @Override
                        public void success(VerificationCodeBean verificationCodeBean) {
                            if (verificationCodeBean.getErrcode() == 1) {
                                pop_btn.setText("确认修改");
                            } else {
                                showToast(verificationCodeBean.getErrmsg());
                            }
                        }

                        @Override
                        public void defeat(String s) {

                        }
                    });
                    presenter.DoRequest(UrlUtils.YZM_URL, map);
                    a = false;
                } else {
                    popSubmit();
                }

                break;
        }
    }

    private void loginSubmit() {
        String yhm = login_edit_yhm.getText().toString().trim();
        String mm = login_edit_mm.getText().toString().trim();
        if (yhm == null || yhm.equals("")) {//帐号为空时
            showToast("请输入帐号");
            return;
        } else if (mm == null || mm.equals("")) {//密码为空时
            showToast("请输入密码");
            return;
        }

        IPresenter presenter = new IPresenter(new IView<LoginBean>() {

            @Override
            public void success(LoginBean loginBean) {
                errcode = loginBean.getErrcode();
                if (errcode == 1) {
                    initdata();
                    startActivity(HomeActivity.class);
                } else {
                    showToast("登录失败");
                }
            }

            @Override
            public void defeat(String s) {

            }
        });
        Map<String, String> map = Constant.getMap();
        map.put("tel", yhm);
        map.put("password", mm);
        presenter.DoRequest(UrlUtils.LOGIN_URL, map);


    }

    private void popSubmit() {
        // validate
        String phone = pop_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            showToast("注册所用手机号");
            return;
        }

        String password = pop_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            showToast("请输入密码");
            return;
        }

        String code = pop_code.getText().toString().trim();
        if (TextUtils.isEmpty(code)) {
            showToast("请输入验证码");
            return;
        }
        IPresenter presenter = new IPresenter(new IView<ForgetBean>() {


            @Override
            public void success(ForgetBean forgetBean) {
                if (forgetBean.getErrcode() == 1) {
                    showToast("修改成功");
                    popupWindow.dismiss();
                } else {
                    showToast(forgetBean.getErrmsg());
                }
            }

            @Override
            public void defeat(String s) {

            }
        });
        Map<String, String> map = Constant.getMap();
        map.put("tel", phone);
        map.put("password", password);
        map.put("code", code);
        presenter.DoRequest(UrlUtils.FORGET_URL, map);


    }
}
