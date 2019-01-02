package com.demo.sdk.common_base.mvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//持有 vm
//observe data 绑定
public abstract class BaseActivity<M extends BaseViewModel> extends AppCompatActivity {

    private M mViewModel;

    //init view
    public abstract View initView();

    //init view model
    public abstract M initViewModel();

    //add data observer with controller
    public abstract void dataObserver();

    public M provideViewModel() {
        return mViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewModel = initViewModel();
        setContentView(initView());
        if(null != this.mViewModel){
            getLifecycle().addObserver(this.mViewModel);
            dataObserver();
        }
    }
}
