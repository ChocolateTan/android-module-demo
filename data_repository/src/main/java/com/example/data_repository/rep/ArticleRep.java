package com.example.data_repository.rep;

import com.demo.sdk.common_base.mvvm.BaseRepository;
import com.demo.sdk.common_base.utils.LogUtil;
import com.example.data_repository.SaleApi;
import com.example.data_repository.entities.ArticleEntity;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ArticleRep extends BaseRepository {

    private static final String TAG = "ArticleRep";

    public Observable<List<ArticleEntity>> getRemoteArticleList() {
        ArticleRemoteDS ds = new ArticleRemoteDS();
        return ds.getApi(SaleApi.class).getArticles("2018_12_20");
    }

    public void saveArticleList(List<ArticleEntity> list) {
        ArticleLocalDS ds = new ArticleLocalDS();
        for (ArticleEntity item : list) {
            long rs = ds.getDaoSession().getArticleEntityDao().insert(item);

            LogUtil.d(TAG, rs + "||" + item.getTitle());
        }
    }

    public Observable<List<ArticleEntity>> getLocalArticleList() {
        ArticleLocalDS ds = new ArticleLocalDS();
        List<ArticleEntity> list = ds.getDaoSession().getArticleEntityDao().loadAll();

        if(null != list && list.size() > 0) {
            Collections.reverse(list);
        }
        return Observable.create(e -> {
            e.onNext(list);
            e.onComplete();
        });
//        return list;
    }

}
