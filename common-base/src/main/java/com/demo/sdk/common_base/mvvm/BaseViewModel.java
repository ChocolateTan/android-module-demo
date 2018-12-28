package com.demo.sdk.common_base.mvvm;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class BaseViewModel extends ViewModel implements LifecycleObserver {
  protected static final String TAG = "BaseViewModel";
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
}
