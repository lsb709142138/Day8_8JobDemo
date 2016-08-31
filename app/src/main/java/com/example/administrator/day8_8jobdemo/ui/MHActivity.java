package com.example.administrator.day8_8jobdemo.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.MyRecycleAdapter;
import com.example.administrator.day8_8jobdemo.bean.MHBean;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MHActivity extends BaseActivity{

    private RecyclerView mRecycle;
    private static final int MH = 14;
    private TextView mTime;
    private TextView charpter;
    private TextView size;
    private int percent;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MH:
                    MHBean.DataBean data = (MHBean.DataBean) msg.obj;
                    //设置当前时间
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    String time = format.format(date);
                    mTime.setText("时间："+time);
                    //每个章节的总页数
                    final int counts = data.getCounts();
                    //设置章节的名字
                    String title = data.getTitle();
                    charpter.setText(title);
                    //获取该章节内的资源
                    List<String> addrs = data.getAddrs();
                    //设置适配器
                    MyRecycleAdapter adapter = new MyRecycleAdapter(MHActivity.this,addrs);
                    mRecycle.setAdapter(adapter);
                    //监听页面的位置
                    adapter.setOnItemPosition(new MyRecycleAdapter.OnRecycleViewItemPosition() {
                        @Override
                        public void onItemPosition(int position) {
                            //设置当前的进度 以及手机电量
                            size.setText(position+"/"+counts+"电量："+percent + "%");
                        }
                    });
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mh_activity_layout);
        //初始化布局
        initView();
        //加载数据
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        int mid = intent.getIntExtra("mid", 0);
        //下载数据
        //http://csapi.dm300.com:21889/android/comic/charpterinfo?charpterid=%id
        GetUpdataDao.getMHData(UrlConfig.MH_PATH,handler,mid,MH);
    }

    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int current = intent.getExtras().getInt("level");// 获得当前电量
            int total = intent.getExtras().getInt("scale");// 获得总电量
            percent = current * 100 / total;
        }
    }

    private void initView() {
        //初始化电量监听器
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        BatteryReceiver  receiver = new BatteryReceiver();
        //注册广播接收器
        registerReceiver(receiver, filter);

        mRecycle = (RecyclerView) findViewById(R.id.mh_recycleview);
        //设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(MHActivity.this);
        //设置排列方式
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycle.setLayoutManager(manager);

        mTime = (TextView) findViewById(R.id.mh_time);
        charpter = (TextView) findViewById(R.id.mh_charpter);
        size = (TextView) findViewById(R.id.mh_size);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
