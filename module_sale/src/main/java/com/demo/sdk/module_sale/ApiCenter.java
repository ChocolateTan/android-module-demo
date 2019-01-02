package com.demo.sdk.module_sale;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCenter {
    private final static int DEFAULT_TIME_OUT = 15;

    public Retrofit getServerA() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接 超时时间
        okHttpClient.writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
        okHttpClient.readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS);//读操作 超时时间
        okHttpClient.retryOnConnectionFailure(true);//错误重连

// 添加公共参数拦截器
//        BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder()
//                .addHeaderParam("userName","")//添加公共参数
//                .addHeaderParam("device","")
//                .build();

//        builder.addInterceptor(basicParamsInterceptor);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://chocolatetan.github.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build());
        return builder.build();
    }


}
