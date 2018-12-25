package com.demo.sdk.module_member;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.sdk.common_base.mvvm.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ly = new LinearLayout(this);
        ly.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("member:"+getPackageName());
        ly.addView(tv);

        setContentView(ly);
  }
}
