package com.example.administrator.day8_8jobdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;

import com.example.administrator.day8_8jobdemo.R;

/**
 * Created by Administrator on 2016/8/11.
 */
public class WelcomeActivity extends BaseActivity{
    private Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcom_layout);
        handler.postDelayed(new Welcome(),3000);
    }
    class Welcome implements Runnable{

        @Override
        public void run() {
            startActivity(new Intent(getApplication(),MainActivity.class));
            WelcomeActivity.this.finish();
        }
    }
}
