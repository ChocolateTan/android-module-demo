package com.demo.sdk.module_login;

import android.arch.lifecycle.MutableLiveData;

import com.demo.sdk.common_base.mvvm.BaseViewModel;

public class LoginViewModel extends BaseViewModel {
  private String TAG = "MainViewModel";
  private MutableLiveData<String> mAc;
  public MutableLiveData<String> getAc() {
    if (mAc == null) {
      mAc = new MutableLiveData<>();
    }
    return mAc;
  }

  private MutableLiveData<String> mPwd;
  public MutableLiveData<String> getPwd() {
    if (mPwd == null) {
      mPwd = new MutableLiveData<>();
    }
    return mPwd;
  }

//  public static class ViewStyle{
    private MutableLiveData<Boolean> isSale;
    public MutableLiveData<Boolean> getIsSale() {
      if (isSale == null) {
        isSale = new MutableLiveData<>();
//        isSale.setValue(false);
      }
      return isSale;
    }
//  }
}
