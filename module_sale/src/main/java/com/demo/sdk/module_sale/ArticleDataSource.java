package com.demo.sdk.module_sale;

import com.demo.sdk.common_base.mvvm.BaseDataSource;

public class ArticleDataSource extends BaseDataSource<ArticleRemoteDataSource, ArticleLocalDataSource> {

    @Override
    public ArticleRemoteDataSource createRemoteDataSource() {
        return new ArticleRemoteDataSource();
    }

    @Override
    public ArticleLocalDataSource createLocalDataSource() {
        return new ArticleLocalDataSource();
    }
}
