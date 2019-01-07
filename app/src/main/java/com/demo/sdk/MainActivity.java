package com.demo.sdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.sdk.common_base.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ly = new LinearLayout(this);
        ly.setOrientation(LinearLayout.VERTICAL);

        Button btnLogin = new Button(this);
        btnLogin.setText("go to login");
        ly.addView(btnLogin);

        btnLogin.setOnClickListener(v -> {
            Class clazz = null;
            String className = "com.demo.sdk.module_login.MainActivity";
            try {
                clazz = Class.forName(className);
                MainActivity.this.startActivity(new Intent(MainActivity.this, clazz));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                ToastUtils.showShortToast("can not find class " + className);
            }
        });

        setContentView(ly);
    }
}
