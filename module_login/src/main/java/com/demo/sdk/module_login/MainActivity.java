package com.demo.sdk.module_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.sdk.common_base.mvvm.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LinearLayout ly = new LinearLayout(this);
    ly.setOrientation(LinearLayout.VERTICAL);

    TextView tv = new TextView(this);
    tv.setText("login:" + getPackageName());
    ly.addView(tv);

    EditText edtAc = new EditText(this);
    ly.addView(edtAc);

    EditText edtPws = new EditText(this);
    ly.addView(edtPws);

    final CheckBox ckType = new CheckBox(this);
    ckType.setText("是否店主");
    ly.addView(ckType);

    Button btnLogin = new Button(this);
    btnLogin.setText("login");
    ly.addView(btnLogin);

    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Class clazz = null;
        try {
          if (ckType.isChecked()) {
            clazz = Class.forName("com.demo.sdk.module_sale.MainActivity");
            MainActivity.this.startActivity(new Intent(MainActivity.this, clazz));
          } else {
            clazz = Class.forName("com.demo.sdk.module_member.MainActivity");
            MainActivity.this.startActivity(new Intent(MainActivity.this, clazz));
          }
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
    });

    setContentView(ly);
  }
}
