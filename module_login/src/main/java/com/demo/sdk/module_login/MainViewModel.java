package com.demo.sdk.module_login;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class MainViewModel extends ViewModel implements LifecycleObserver {
  private static final String TAG = "MainViewModel";
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public void onCreate() {
    Log.d(TAG, "onCreate: ");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onStart() {
    Log.d(TAG, "onStart: ");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onResume() {
    Log.d(TAG, "onResume: ");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onPause() {
    Log.d(TAG, "onPause: ");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onStop() {
    Log.d(TAG, "onStop: ");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy() {
    Log.d(TAG, "onDestroy: ");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
  public void onAny() {
    Log.d(TAG, "onAny: ");
  }
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
