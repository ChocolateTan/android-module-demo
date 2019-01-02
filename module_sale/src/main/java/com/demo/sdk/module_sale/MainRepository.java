package com.demo.sdk.module_sale;

import com.demo.sdk.common_base.mvvm.BaseRepository;

import java.util.List;

import io.reactivex.Observable;

public class MainRepository extends BaseRepository {
    public Observable<List<ArticleBean>> getArticleList(){
        ArticleDataSource ds = new ArticleDataSource();
        return ds.remoteDataSource.getApi(SaleApi.class).getArticles("2018_12_20");
    }
}
