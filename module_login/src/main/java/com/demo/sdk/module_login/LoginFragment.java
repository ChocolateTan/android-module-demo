package com.demo.sdk.module_login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.sdk.common_base.mvvm.BaseFragment;
import com.demo.sdk.common_base.utils.ToastUtils;

public class LoginFragment extends BaseFragment<LoginViewModel> {

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public LoginViewModel createViewModel() {
        return ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout ly = new LinearLayout(getActivity());
        ly.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(getActivity());
        tv.setText("login:" + getActivity().getPackageName());
        ly.addView(tv);

        TextView tvType = new TextView(getActivity());
        tvType.setText("普通用户");
        ly.addView(tvType);

        EditText edtAc = new EditText(getActivity());
        ly.addView(edtAc);

        EditText edtPws = new EditText(getActivity());
        ly.addView(edtPws);

        final CheckBox ckType = new CheckBox(getActivity());
        ckType.setText("是否店主");
        ly.addView(ckType);

        Button btnLogin = new Button(getActivity());
        btnLogin.setText("login");
        ly.addView(btnLogin);

        btnLogin.setOnClickListener(v -> {
            Class clazz = null;
            String className = null;
            try {
                if (getViewModel().getIsSale().getValue()) {
                    className = "com.demo.sdk.module_sale.MainActivity";
                } else {
                    className = "com.demo.sdk.module_member.MainActivity";
                }
                clazz = Class.forName(className);
                getActivity().startActivity(new Intent(getActivity(), clazz));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getActivity(),"can not find class " + className, Toast.LENGTH_LONG).show();
            }
        });

        ckType.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            getViewModel().getIsSale().setValue(isChecked);
            if (isChecked) {
                tvType.setText("欢迎店主");
            } else {
                tvType.setText("欢迎普通用户");
            }
        });

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        getViewModel().getIsSale().observe(this, isSale -> {
            if (isSale) {
                tvType.setText("欢迎店主");
            } else {
                tvType.setText("欢迎普通用户");
            }
        });
        return ly;
    }

}
