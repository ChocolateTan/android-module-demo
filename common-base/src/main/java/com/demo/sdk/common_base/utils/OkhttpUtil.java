package com.demo.sdk.common_base.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkhttpUtil {
    private final static int DEFAULT_TIME_OUT = 15;
    public static OkHttpClient.Builder getHttpClient = new OkHttpClient.Builder()
        .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//连接 超时时间
        .writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)//写操作 超时时间
        .readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)//读操作 超时时间
        .retryOnConnectionFailure(true);//错误重连
}
