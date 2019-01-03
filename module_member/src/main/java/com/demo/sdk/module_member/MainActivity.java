package com.demo.sdk.module_member;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.sdk.common_base.mvvm.BaseActivity;

public class MainActivity extends BaseActivity<MainViewModel> {

    @Override
    public View initView() {
        LinearLayout ly = new LinearLayout(this);
        ly.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("member:"+getPackageName());
        ly.addView(tv);
        return ly;
    }

    @Override
    public MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void dataObserver() {

    }
}
