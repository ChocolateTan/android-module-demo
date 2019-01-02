package com.demo.sdk.module_sale;

import android.arch.lifecycle.MutableLiveData;
import android.support.v7.util.DiffUtil;

import com.demo.sdk.common_base.mvvm.BaseViewModel;
import com.demo.sdk.common_base.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<List<ArticleBean>> jokeArticleList;
    private MutableLiveData<String> tvString;

    public MutableLiveData<List<ArticleBean>> getJokeArticleList() {
        if (jokeArticleList == null) {
            jokeArticleList = new MutableLiveData<>();
            List<ArticleBean> list = new ArrayList<>();
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

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.d("don test", "onCreate");
        MainRepository repository = new MainRepository();
        repository.getArticleList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d("don test", "onSubscribe");
                    }

                    @Override
                    public void onNext(List<ArticleBean> articleBeans) {
                        LogUtil.d("don test", "articleBeans" + articleBeans.size());
                        List<ArticleBean> list = jokeArticleList.getValue();
                        list.addAll(articleBeans);
                        jokeArticleList.postValue(list);
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
