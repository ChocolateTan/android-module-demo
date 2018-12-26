package com.demo.sdk.module_login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.sdk.common_base.mvvm.BaseActivity;

public class MainActivity extends BaseActivity {

  private MainViewModel mModel;

//  LinearLayout ly = new LinearLayout(this);
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    init();
  }

  private void init(){
    VMainView v = new VMainView(this);
    setContentView(v.getView());
//    mModel = ViewModelProviders.of(this).get(MainViewModel.class);
//    LinearLayout ly = new LinearLayout(this);
//    ly.setOrientation(LinearLayout.VERTICAL);
//    setContentView(ly);
//
//    TextView tv = new TextView(this);
//    tv.setText("login:" + getPackageName());
//    ly.addView(tv);
//
//    TextView tvType = new TextView(this);
//    tvType.setText("普通用户");
//    ly.addView(tvType);
//
//    EditText edtAc = new EditText(this);
//    ly.addView(edtAc);
//
//    EditText edtPws = new EditText(this);
//    ly.addView(edtPws);
//
//    final CheckBox ckType = new CheckBox(this);
//    ckType.setText("是否店主");
//    ly.addView(ckType);
//
//    Button btnLogin = new Button(this);
//    btnLogin.setText("login");
//    ly.addView(btnLogin);
//
//    btnLogin.setOnClickListener(v -> {
//      Class clazz = null;
//      try {
//        if (mModel.getIsSale().getValue()) {
//          clazz = Class.forName("com.demo.sdk.module_sale.MainActivity");
//          MainActivity.this.startActivity(new Intent(MainActivity.this, clazz));
//        } else {
//          clazz = Class.forName("com.demo.sdk.module_member.MainActivity");
//          MainActivity.this.startActivity(new Intent(MainActivity.this, clazz));
//        }
//      } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//      }
//    });
//
//    ckType.setOnCheckedChangeListener((buttonView, isChecked) -> {
//      mModel.getIsSale().setValue(isChecked);
//    });
//
//    // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//    mModel.getIsSale().observe(this, isSale -> {
//      if(isSale){
//        tvType.setText("欢迎店主");
//      }else{
//        tvType.setText("欢迎普通用户");
//      }
//    });
//
//
//    getLifecycle().addObserver(mModel);
  }

  public class VMainView {
    private Context mCtx;
    TextView test = new TextView(MainActivity.this);

    VMainView(Context ctx){
      this.mCtx = ctx;
    }

    public View getView(){
      test.setText("ssss");
      return test;
    }
  }

}
