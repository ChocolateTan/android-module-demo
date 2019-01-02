package com.demo.sdk.module_sale;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SaleApi {

    //https://chocolatetan.github.io/Collector/api/json_articles_2018_12_20.json
//    @GET("https://chocolatetan.github.io/Collector/api/json_articles_{date}.json")
    @GET("/Collector/api/json_articles_{date}.json")
    Observable<List<ArticleBean>> getArticles(@Path("date") String date);
//    https://api.apiopen.top/getJoke?page=2&count=20&type=video
}
