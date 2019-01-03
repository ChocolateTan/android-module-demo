package com.demo.sdk.common_base.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtil {
    private final static int DEFAULT_TIME_OUT = 15;

    public static HttpLoggingInterceptor getLogginInterceptor() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
            //打印retrofit日志
            LogUtil.e("RetrofitLog", "retrofitBack = " + message);
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    public static OkHttpClient.Builder getHttpClient = new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//连接 超时时间
            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//写操作 超时时间
            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//读操作 超时时间
            .retryOnConnectionFailure(true)//错误重连
            .addInterceptor(getLogginInterceptor());
}
