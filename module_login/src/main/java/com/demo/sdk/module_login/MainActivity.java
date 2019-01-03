package com.demo.sdk.module_login;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.demo.sdk.common_base.mvvm.BaseActivity;

public class MainActivity extends BaseActivity<MainViewModel> {

    @Override
    public View initView() {
        FrameLayout fl = new FrameLayout(this);
        fl.setId(View.generateViewId());
//        fl.setBackgroundColor(Color.BLUE);
//        FrameLayout.LayoutParams ll = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        fl.setLayoutParams(ll);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(fl.getId(), LoginFragment.newInstance(), LoginFragment.class.getSimpleName());
        transaction.commit();
        return fl;
    }

    @Override
    public MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void dataObserver() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
