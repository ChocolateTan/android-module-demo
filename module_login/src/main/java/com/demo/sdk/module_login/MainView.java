package com.demo.sdk.module_login;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class MainView {
  private Context mCtx;
  TextView test = new TextView(this.mCtx);

  MainView(Context ctx){
    this.mCtx = ctx;
  }

  public View getView(){
    test.setText("ssss");
    return test;
  }
}
