package com.demo.sdk.module_sale;

import com.demo.sdk.common_base.mvvm.BaseRemoteDataSource;
import com.demo.sdk.common_base.utils.OkhttpUtil;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ArticleRemoteDataSource extends BaseRemoteDataSource {

    public ArticleRemoteDataSource() {
        super(new Retrofit.Builder()
                .baseUrl("https://chocolatetan.github.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkhttpUtil.getHttpClient.build()).build());
    }
    //    public Retrofit getRetrofit(){
//        Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Constant.BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient);
//        return builder.build();
//    }
}
