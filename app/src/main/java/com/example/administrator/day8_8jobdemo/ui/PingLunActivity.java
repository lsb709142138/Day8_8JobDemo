package com.example.administrator.day8_8jobdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;

import com.example.administrator.day8_8jobdemo.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by Administrator on 2016/8/10.
 */
public class PingLunActivity extends BaseActivity{

    private Toolbar mToolbar;
    private PullToRefreshListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pinglun_activity_layout);
        //初始化控件
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.pinglun_toolbar);
        mListView = (PullToRefreshListView) findViewById(R.id.pinglun_activity_pullto_listview);
        
        //设置toolbar的点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
