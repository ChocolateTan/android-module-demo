package com.demo.sdk.module_sale;

import android.arch.lifecycle.MutableLiveData;

import com.demo.sdk.common_base.mvvm.BaseViewModel;
import com.demo.sdk.common_base.utils.LogUtil;
import com.example.data_repository.entities.ArticleEntity;
import com.example.data_repository.rep.ArticleRep;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<List<ArticleEntity>> jokeArticleList;
    private MutableLiveData<String> tvString;

    public MutableLiveData<List<ArticleEntity>> getJokeArticleList() {
        if (jokeArticleList == null) {
            jokeArticleList = new MutableLiveData<>();
            List<ArticleEntity> list = new ArrayList<>();
//            ArticleBean a = new ArticleBean();
//            ArticleBean.IdBean id = new ArticleBean.IdBean();
//
//            a.set_id(id);
//            a.setTitle("gggggg");
//            list.add(a);
            jokeArticleList.postValue(list);
        }
        return jokeArticleList;
    }

    public MutableLiveData<String> getTvString() {
        if (null == tvString) {
            tvString = new MutableLiveData<>();
            tvString.setValue("loading");
        }
        return tvString;
    }

    void onClickRemote(){
        ArticleRep repository = new ArticleRep();
        repository.getRemoteArticleList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d("don test", "onSubscribe");
                    }

                    @Override
                    public void onNext(List<ArticleEntity> articleBeans) {
                        LogUtil.d("don test", "articleBeans" + articleBeans.size());
//                        List<ArticleEntity> list = jokeArticleList.getValue();
//                        list.addAll(articleBeans);
                        repository.saveArticleList(articleBeans);
//                        jokeArticleList.postValue(list);
                        tvString.postValue("remote finish");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.d("don test", "Throwable");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d("don test", "onComplete");
                    }
                });
    }

    void onClickLocal(){
        ArticleRep repository = new ArticleRep();
        repository.getLocalArticleList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d("don test", "onSubscribe");
                    }

                    @Override
                    public void onNext(List<ArticleEntity> articleBeans) {
                        LogUtil.d("don test", "articleBeans" + articleBeans.size());
//                        List<ArticleEntity> list = jokeArticleList.getValue();
//                        list.addAll(articleBeans);
                        jokeArticleList.postValue(articleBeans);
                        tvString.postValue("finish");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.d("don test", "Throwable");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d("don test", "onComplete");
                    }
                });
    }
}
