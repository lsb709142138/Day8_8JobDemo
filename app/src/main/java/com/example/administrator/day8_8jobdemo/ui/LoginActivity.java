package com.example.administrator.day8_8jobdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.administrator.day8_8jobdemo.R;

/**
 * Created by Administrator on 2016/8/12.
 */
public class LoginActivity extends BaseActivity{

    private Toolbar lToolbar;
    private TextInputEditText name;
    private TextInputEditText password;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.load_layout);
        //初始化布局
        initView();
    }

    private void initView() {
        lToolbar = (Toolbar) findViewById(R.id.login_toolbar);
        name = (TextInputEditText) findViewById(R.id.textinput_username);
        password = (TextInputEditText) findViewById(R.id.textinput_passward);
        login = (Button) findViewById(R.id.loading_login);
    }
}
