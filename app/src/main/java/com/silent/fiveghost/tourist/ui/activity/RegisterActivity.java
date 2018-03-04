package com.silent.fiveghost.tourist.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.bean.RegistBean;
import com.silent.fiveghost.tourist.bean.VerificationCodeBean;
import com.silent.fiveghost.tourist.listener.OnBooleanListener;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.utils.Constant;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.HashMap;
import java.util.Map;

//注册页面
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView register_mReturn;//返回
    private EditText register_phone;//手机号
    private EditText register_code;//验证码
    private EditText register_password_one;//密码
    private EditText register_password_two;//再次确认密码
    private Button register_btn;//获取验证码
    private Button submit_btn;//获取验证码
    private Map<String, String> map;
    int a = 1;
    String imei = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

    }

    private void initView() {
        register_mReturn = (ImageView) findViewById(R.id.register_mReturn);
        register_phone = (EditText) findViewById(R.id.register_phone);
        register_code = (EditText) findViewById(R.id.register_code);
        register_password_one = (EditText) findViewById(R.id.register_password_one);
        register_password_two = (EditText) findViewById(R.id.register_password_two);
        //更换软键盘
        register_password_two.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                EditText editText = new EditText(RegisterActivity.this);
                editText.setImeOptions(EditorInfo.IME_ACTION_GO);
                editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
                submit();


               /* if (actionId == EditorInfo.IME_ACTION_GO) {
                    showToast("cao");
                }*/
                return false;
            }
        });
        submit_btn = findViewById(R.id.submit_btn);
        register_btn = (Button) findViewById(R.id.register_btn);
        register_mReturn.setOnClickListener(this);
        submit_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);
        map = new HashMap<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回
            case R.id.register_mReturn:
                finish();
                break;
            //验证码(获取完验证码变更登录)
            case R.id.register_btn:
                String trim = register_phone.getText().toString().trim();
                if ("".equals(trim)) {
                    showToast("手机号为空");
                    return;
                }

                permissionRequests(Manifest.permission.READ_PHONE_STATE, new OnBooleanListener() {
                    @Override
                    public void onClick(boolean bln) {
                        if(bln){
                            showToast("权限通过");

                        }else{
                            showToast("权限拒绝");
                        }
                    }
                });

                    map.put("mobile", trim);
                    map.put("module", "1");
                    map.put("imei", Constant.getPhoneIMEI(this));
                    IPresenter presenter = new IPresenter(new IView<VerificationCodeBean>() {

                        @Override
                        public void success(VerificationCodeBean verificationCodeBean) {

                            Log.e("TAG", "获取验证码:" + verificationCodeBean.getErrcode());
                            if (verificationCodeBean.getErrcode() == 1) {
                                ;
//                                register_btn.setText("注册");
                            } else {
                                Toast.makeText(RegisterActivity.this, verificationCodeBean.getErrmsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void defeat(String s) {
                            Log.e("defeat", "" + s);
                        }
                    });
                    presenter.DoRequest(UrlUtils.YZM_URL, map);
//                  else {
//
//                    submit();
//                }


                break;
        case R.id.submit_btn:
            submit();

            break;
        }

    }

    private void submit() {
        // validate
        String phone = register_phone.getText().toString().trim();
        String yzm = register_code.getText().toString().trim();
        String one = register_password_one.getText().toString().trim();
        String two = register_password_two.getText().toString().trim();
        if ( phone.equals("")) {
            Toast.makeText(this, "电话不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else if ( yzm.equals("")) {
            Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else if ( one.equals("")) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else if ( two.equals("")) {
            Toast.makeText(this, "再次密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }


        IPresenter presenter = new IPresenter(new IView<RegistBean>() {

            @Override
            public void success(RegistBean registBean) {

                Log.e("TAG", registBean.getErrcode() + "注册返回值");
                if (registBean.getErrcode() == 1) {
                    Toast.makeText(RegisterActivity.this, "注册成功，老韩是智障", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, registBean.getErrmsg(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void defeat(String s) {

            }
        });
        map.put("tel", phone);
        map.put("password", one);
        map.put("category", "2");
        map.put("code", yzm);
        presenter.DoRequest(UrlUtils.REGISTER_URL, map);


    }
}
