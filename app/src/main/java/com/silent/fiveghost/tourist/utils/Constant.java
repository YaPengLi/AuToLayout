package com.silent.fiveghost.tourist.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.silent.fiveghost.tourist.http.ApiService;
import com.silent.fiveghost.tourist.http.MyRetrofit;
import com.silent.fiveghost.tourist.ui.activity.MainActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 韩学文 on 2018/1/29.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class Constant {
    public static Map<String, String> getMap() {
        return new HashMap<>();
    }

    //get请求
    public static void getRequest(String url) {
        ApiService apiservice = MyRetrofit.getInstance().create(ApiService.class);
        Observable<ResponseBody> observable = apiservice.postOne(url);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", e.toString());

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("TAG", "-----" + string);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    //请求没有Map  post
    public static void requestNoMap(String url) {
        ApiService apiservice = MyRetrofit.getInstance().create(ApiService.class);
        Observable<ResponseBody> responseBodyObservable = apiservice.postOne(url);
        responseBodyObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", e.toString());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("TAG", "-----" + string);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    //请求有Map post
    public static void request(String url, Map<String, String> map) {
        ApiService apiservice = MyRetrofit.getInstance().create(ApiService.class);
        Observable<ResponseBody> post = apiservice.post(url, map);
        post
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", e.toString());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("TAG", "-----" + string);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    //获取IMEI
    public static String getPhoneIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "";
            }
            return telephonyManager.getDeviceId();
        } else {
            return "";
        }
    }
}
