package com.silent.fiveghost.tourist.model;

import com.silent.fiveghost.tourist.http.ApiService;
import com.silent.fiveghost.tourist.http.MyRetrofit;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 韩学文 on 2018/1/27.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class IModelSon implements IModel {
    @Override
   public  void request(String url, Map<String, String> map, final CallBack callBack) {
        ApiService apiService = MyRetrofit.getInstance().create(ApiService.class);
        Observable<ResponseBody> post = apiService.post(url, map);
        post
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.defeat(e.toString());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type actualTypeArgument = actualTypeArguments[0];
                            Gson gson = new Gson();
                            Object o = gson.fromJson(string, actualTypeArgument);
                            callBack.success(o);
                        } catch (IOException e) {
                            callBack.defeat(e.toString());
                        }
                    }
                });
    }

    @Override
    public void GetRequst(String url, final CallBack callBack) {
        ApiService apiService = MyRetrofit.getInstance().create(ApiService.class);
        Observable<ResponseBody> responseBodyObservable = apiService.postOne(url);
        responseBodyObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.defeat(e.toString());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type actualTypeArgument = actualTypeArguments[0];
                            Gson gson = new Gson();
                            Object o = gson.fromJson(string, actualTypeArgument);
                            callBack.success(o);
                        } catch (IOException e) {
                            callBack.defeat(e.toString());
                        }
                    }
                });
    }

}
