package com.example.administrator.day8_8jobdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.MyPlListViewAdapter;
import com.example.administrator.day8_8jobdemo.bean.PingLunBean;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class TalkActivity extends BaseActivity{

    private static final int PINGLUN = 7;
    private Toolbar mToolbar;
    private PullToRefreshListView mListView;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case PINGLUN:
                    PingLunBean.DataBean data = (PingLunBean.DataBean) msg.obj;
                    List<PingLunBean.DataBean.CommentListBean> commentList = data.getCommentList();
                    //设置适配器
                    MyPlListViewAdapter adapter = new MyPlListViewAdapter(commentList);
                    mListView.setAdapter(adapter);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pinglun_activity_layout);

        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String comicId = intent.getStringExtra("comicId");
        GetUpdataDao.getPingLunInfomationData(UrlConfig.PINGLUN_PATH,handler,comicId,PINGLUN);
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.pinglun_toolbar);
        mListView = (PullToRefreshListView) findViewById(R.id.pinglun_activity_pullto_listview);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
