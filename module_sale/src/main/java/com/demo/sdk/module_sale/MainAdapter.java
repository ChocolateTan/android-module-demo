package com.demo.sdk.module_sale;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.data_repository.entities.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.VH> {
    List<ArticleEntity> list = new ArrayList<>();

//    MainAdapter(List<ArticleBean> list) {
//        this.list = list;
//    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LinearLayout ly = new LinearLayout(viewGroup.getContext());
//        ly.setBackgroundColor(Color.YELLOW);
//        ly.setOrientation(LinearLayout.VERTICAL);
//        ly.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
//        return new VH(ly);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        ArticleEntity article = list.get(i);
        vh.tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vh.tv.setText(article.getTitle());
//        vh.tv.setTextColor(Color.RED);
//        vh.tv.setBackgroundColor(Color.BLUE);
//
//
//        vh.tv2.setText("sssssss");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void setPosts(List<ArticleEntity> postList) {
//        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
//            @Override
//            public int getOldListSize() {
//                return list.size();
//            }
//
//            @Override
//            public int getNewListSize() {
//                return postList.size();
//            }
//
//            @Override
//            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//                return list.get(oldItemPosition).get_id() ==
//                        postList.get(newItemPosition).get_id();
//            }
//
//            @Override
//            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//                return list.get(oldItemPosition).get_id() ==
//                        postList.get(newItemPosition).get_id();
//            }
//        });
        list.addAll(postList);
    }

    public static class VH extends RecyclerView.ViewHolder {
        private final TextView tv;
        public VH(View v) {
            super(v);
            tv = v.findViewById(R.id.tv);
        }
    }

//    public static class VH extends RecyclerView.ViewHolder {
//        private final TextView tv;
//        private final TextView tv2;
//
//        public VH(View v) {
//            super(v);
//            tv = new TextView(v.getContext());
//            tv2 = new TextView(v.getContext());
//        }
//    }
}
