package com.demo.sdk.common_base.mvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class BaseFragment<M extends BaseViewModel> extends Fragment {
    private M module;

    public abstract M createViewModel();

    public M getViewModel() {
        return module;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.module = createViewModel();
        getLifecycle().addObserver(this.module);
    }
}
