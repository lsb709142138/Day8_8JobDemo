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
import com.example.administrator.day8_8jobdemo.bean.LastCharpterBean;
import com.example.administrator.day8_8jobdemo.bean.SearchBean;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class SeatchActivity extends BaseActivity{

    private Toolbar searchBar;
    private ListView searchListView;
    private static final int SEARCH = 16;
    private List<GridDataBean> data;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SEARCH:
                    data = (List<GridDataBean>) msg.obj;
                    //设置适配器
                    MyListViewAdapter adapter = new MyListViewAdapter(data);
                    searchListView.setAdapter(adapter);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.search_activity);
        //初始化布局
        initView();
        //设置监听事件
        setListener();
        //加载数据
        initData();

    }

    private void initData() {
        //
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        //下载数据
        GetUpdataDao.getSearchData(UrlConfig.SEARCH_PATH,handler,content,SEARCH);
    }

    private void setListener() {
        //设置toolbar的点击事件
        searchBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView() {
        searchBar = (Toolbar) findViewById(R.id.search_toolbar);
        searchListView = (ListView) findViewById(R.id.search_listview);

        //设置点击事件
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到详情的页面
                GridDataBean gridDataBean = data.get(i);
                String comicId = gridDataBean.getComicId();
                //获取最新章节
                LastCharpterBean lastCharpter = gridDataBean.getLastCharpter();
                String subTitle = lastCharpter.getTitle();

                Intent intent = new Intent(SeatchActivity.this, DetailActivity.class);
                intent.setAction("detail");
                //传递数据
                Bundle bundle = new Bundle();
                bundle.putString("comicId",comicId);
                bundle.putString("url",UrlConfig.DETAIL_PATH);
                bundle.putString("subtitle",subTitle);

                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
    }
}
