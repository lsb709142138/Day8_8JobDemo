package com.example.administrator.day8_8jobdemo;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.xutils.x;

/**
 * Created by Administrator on 2016/8/8.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        x.Ext.init(this);
        x.Ext.setDebug(true);

    }
}