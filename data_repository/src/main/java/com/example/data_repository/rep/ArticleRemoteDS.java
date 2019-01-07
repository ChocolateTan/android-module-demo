package com.example.data_repository.rep;

import com.demo.sdk.common_base.mvvm.BaseRemoteDataSource;
import com.demo.sdk.common_base.utils.OkhttpUtil;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleRemoteDS extends BaseRemoteDataSource {

    public ArticleRemoteDS() {
        super(new Retrofit.Builder()
                .baseUrl("https://chocolatetan.github.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkhttpUtil.getHttpClient.build()).build());
    }


}
