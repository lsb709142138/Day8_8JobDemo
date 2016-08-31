package com.example.administrator.day8_8jobdemo.ui;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.fragment.FirstFragment;
import com.example.administrator.day8_8jobdemo.fragment.FourFragment;
import com.example.administrator.day8_8jobdemo.fragment.SecondFragment;
import com.example.administrator.day8_8jobdemo.fragment.ThirdFragment;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lidroid.xutils.DbUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourFragment fourFragment;

    public static DbUtils dbUtils;
    private RadioGroup rgBtns;
    private FragmentTransaction transaction;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initMianview();
        initMainData();

    }

    private void initMianview() {
        //初始化数据
        //创建数据库

        dbUtils = dbUtils.create(this,"manhua.db");
        rgBtns = (RadioGroup) findViewById(R.id.main_activity_radiogroup);
        rgBtns.setOnCheckedChangeListener(this);
        manager = getSupportFragmentManager();
    }

    private void initMainData() {
        selection(0);
    }

    //选择的按钮
    private void selection(int i) {
        //选中的显示 其他的隐藏

        transaction = manager.beginTransaction();
        hideFragment(transaction);
        //加载fragment
        switch (i){
            case 0:
                if (firstFragment == null){
                    firstFragment = new FirstFragment();
                    transaction.add(R.id.framelayout_main_container,firstFragment);
                }else {
                    transaction.show(firstFragment);
                }

                break;
            case 1:
                if (secondFragment == null){
                    secondFragment = new SecondFragment();
                    transaction.add(R.id.framelayout_main_container,secondFragment);
                }else {
                    transaction.show(secondFragment);
                }
                break;
            case 2:
                if (thirdFragment == null){
                    thirdFragment = new ThirdFragment();
                    transaction.add(R.id.framelayout_main_container,thirdFragment);
                }else {
                    transaction.show(thirdFragment);
                }
                break;
            case 3:
                if (fourFragment == null){
                    fourFragment = new FourFragment();
                    transaction.add(R.id.framelayout_main_container,fourFragment);
                }else {
                    transaction.show(fourFragment);
                }
                break;
        }
        //提交
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (firstFragment != null){
            ft.hide(firstFragment);
        }
        if (secondFragment != null){
            ft.hide(secondFragment);
        }
        if (thirdFragment != null){
            ft.hide(thirdFragment);
        }
        if (fourFragment != null){
            ft.hide(fourFragment);
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.main_first:
                selection(0);
                break;
            case R.id.main_second:
                selection(1);
                break;
            case R.id.main_third:
                selection(2);
                break;
            case R.id.main_four:
                selection(3);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("确定退出？");
            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            dialog.setNegativeButton("取消",null);
            dialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
