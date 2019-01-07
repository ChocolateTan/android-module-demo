package com.example.data_repository;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.demo.sdk.common_base.utils.LogUtil;
import com.example.data_repository.entities.ArticleEntity;
import com.example.data_repository.rep.ArticleRep;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rvRemote = findViewById(R.id.rv_remote);
//        Log.i(TAG, )
        findViewById(R.id.btn_remote).setOnClickListener(v -> {

            ArticleRep rep = new ArticleRep();
            rep.getRemoteArticleList()
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
                            rep.saveArticleList(articleBeans);
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
        });
        findViewById(R.id.btn_local).setOnClickListener(v -> {
            ArticleRep rep = new ArticleRep();
//            List<ArticleEntity> list = rep.getLocalArticleList();
//            if (list != null && list.size() > 0) {
//                for (ArticleEntity item : list) {
//                    LogUtil.d("don test", item.getTitle());
//                }
//            }
        });
    }
}
