package com.silent.fiveghost.tourist.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 韩学文 on 2018/1/27.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class MyRetrofit {
    private static MyRetrofit retrofitSettings;
    private Retrofit retrofit;

    private MyRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()
                ).build();


    }

    public static MyRetrofit getInstance() {
        if (retrofitSettings == null) {
            synchronized (MyRetrofit.class) {
                if (retrofitSettings == null) {
                    retrofitSettings = new MyRetrofit();
                }
            }

        }
        return retrofitSettings;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

}
