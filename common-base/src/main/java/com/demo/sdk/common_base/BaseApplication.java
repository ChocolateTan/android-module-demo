package com.demo.sdk.common_base;

import android.app.Application;

import org.greenrobot.greendao.AbstractDaoSession;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

    }

//    public Retrofit getRetrofit(){
//        Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Constant.BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient);
//        return builder.build();
//    }
}
