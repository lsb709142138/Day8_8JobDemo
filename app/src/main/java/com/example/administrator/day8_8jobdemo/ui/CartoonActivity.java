package com.example.administrator.day8_8jobdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.MyListViewAdapter;
import com.example.administrator.day8_8jobdemo.bean.GridDataBean;
import com.example.administrator.day8_8jobdemo.bean.GridViewBean;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class CartoonActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private PullToRefreshListView mListview;
    private GridViewBean gg;
    public static final int CARTOON= 10;
    int page = 1;
    private MyListViewAdapter adapter;
    List<GridDataBean> mList = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case CARTOON:
                    data = (List<GridDataBean>) msg.obj;
                    if (page == 1){
                        mList.addAll(data);
                        adapter = new MyListViewAdapter(mList);
                        mListview.setAdapter(adapter);
                    }else{
                        mList.addAll(0, data);
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
            mListview.onRefreshComplete();
        }
    };
    private Toolbar cToolbar;
    private List<GridDataBean> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cartoon_activity_layout);
        //布局初始化
        initView();
        //数据初始化
        initData();
    }
    //初始化布局
    private void initView() {
        gg = new GridViewBean();
        //初始化控件
        cToolbar = (Toolbar) findViewById(R.id.cartoon_toolbar);
        mListview = (PullToRefreshListView) findViewById(R.id.updata_fragment_listview);
        mListview.setOnItemClickListener(CartoonActivity.this);
        //toolbar的点击事件
        cToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //加载数据
    private void initData() {
        //获取传递过来的信息
        Intent intent = getIntent();
        String cateid = intent.getStringExtra("cateid");
        String title = intent.getStringExtra("title");
        cToolbar.setTitle(title);
        //下载数据
        GetUpdataDao.getCartoonData(UrlConfig.CATEGARYTYPE_TWO_PATH,handler,cateid,CARTOON,gg);
    }

    //listview的点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //跳转到详情的activity
        GridDataBean gridDataBean = data.get(i);
        String comicId = gridDataBean.getComicId();
        //跳转到显示动漫详情的页面
        Intent intent = new Intent(CartoonActivity.this, DetailActivity.class);
        intent.setAction("detail");
        Bundle bundle = new Bundle();
        //绑定要传递的数据
        bundle.putString("comicId",comicId);
        bundle.putString("url",UrlConfig.DETAIL_PATH);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }
}
