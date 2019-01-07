package com.demo.sdk.module_sale;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.sdk.common_base.mvvm.BaseActivity;
import com.demo.sdk.common_base.utils.LogUtil;
import com.example.data_repository.entities.ArticleEntity;

public class MainActivity extends BaseActivity<MainViewModel> {
    RecyclerView rv;
    Button btnLoadRemote;
    Button btnLoadLocal;
    TextView tv;
//    MainAdapter adapter ;

    @Override
    public View initView() {
        LinearLayout ly = new LinearLayout(this);
        ly.setOrientation(LinearLayout.VERTICAL);
        ly.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        btnLoadRemote= new Button(this);
        btnLoadRemote.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnLoadRemote.setText("remote");

        btnLoadLocal= new Button(this);
        btnLoadLocal.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnLoadLocal.setText("local");

        tv = new TextView(this);
        tv.setText("start");

//        adapter = new MainAdapter();

        rv = new RecyclerView(this);
        rv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        rv.setAdapter(adapter);
        rv.setAdapter(new RecyclerView.Adapter<MVH>() {
            @NonNull
            @Override
            public MVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LinearLayout ly = new LinearLayout(viewGroup.getContext());
//        ly.setBackgroundColor(Color.YELLOW);
//        ly.setOrientation(LinearLayout.VERTICAL);
//        ly.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
//        return new VH(ly);
                return new MVH(view);
            }

            @Override
            public void onBindViewHolder(@NonNull MVH mvh, int i) {

                ArticleEntity article = provideViewModel().getJokeArticleList().getValue().get(i);
                mvh.tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                mvh.tv.setText(article.getTitle());
            }

            @Override
            public int getItemCount() {
                if(null == provideViewModel().getJokeArticleList()
                        || null == provideViewModel().getJokeArticleList().getValue()){
                    return 0;
                }
                return provideViewModel().getJokeArticleList().getValue().size();
            }
        });
        rv.setBackgroundColor(Color.GREEN);
        ly.addView(tv);
        ly.addView(btnLoadRemote);
        ly.addView(btnLoadLocal);
        ly.addView(rv);

        btnLoadRemote.setOnClickListener(view->{
            provideViewModel().onClickRemote();
        });
        btnLoadLocal.setOnClickListener(view->{
            provideViewModel().onClickLocal();
        });
//        adapter.setPosts(list);
//        adapter.notifyDataSetChanged();
        return ly;
    }

    @Override
    public MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void dataObserver() {
        provideViewModel().getJokeArticleList().observe(this, list -> {
            LogUtil.d("don test", "list=" + list.size());
//            adapter.setPosts(list);
//            adapter.notifyDataSetChanged();
            rv.getAdapter().notifyDataSetChanged();
        });
        provideViewModel().getTvString().observe(this, s -> {
            LogUtil.d("don test", "s=" + s);
            tv.setText(s);
        });
//        adapter.notifyDataSetChanged();
    }

    public static class MVH extends RecyclerView.ViewHolder {
        private final TextView tv;

        public MVH(View v) {
            super(v);
            tv = v.findViewById(R.id.tv);
        }
    }
}
