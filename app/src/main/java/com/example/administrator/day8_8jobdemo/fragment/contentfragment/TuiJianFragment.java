package com.example.administrator.day8_8jobdemo.fragment.contentfragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.MyGridViewAdapter;
import com.example.administrator.day8_8jobdemo.bean.GridDataBean;
import com.example.administrator.day8_8jobdemo.bean.GridViewBean;
import com.example.administrator.day8_8jobdemo.bean.LastCharpterBean;
import com.example.administrator.day8_8jobdemo.ui.DetailActivity;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;
import com.example.administrator.day8_8jobdemo.utils.OkhttpUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class TuiJianFragment extends Fragment{

    private PullToRefreshGridView tuiJianGridview;
    private Gson gson;
    private MyGridViewAdapter adapter;
    List<GridDataBean> data = new ArrayList<>();
    public static final int TUIJIAN = 3;
    int page = 1;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TUIJIAN:
                    List<GridDataBean> datas = (List<GridDataBean>) msg.obj;
                    if(page == 1){
                        data.addAll(datas);
                        adapter = new MyGridViewAdapter(data);
                        tuiJianGridview.setAdapter(adapter);
                    }else {
                        data.addAll(0,datas);
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
            tuiJianGridview.onRefreshComplete();
        }
    };
    private GridViewBean gridViewBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijian_gridview_layout, container, false);
        //初始化视图
        initView(view);
        //加载数据
        initData();
        //设置gridview的监听事件
        setListener();
        return view;
    }

    private void setListener() {
        tuiJianGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到详情的页面
                GridDataBean gridDataBean = data.get(i);
                String comicId = gridDataBean.getComicId();
                //获取最新章节
                LastCharpterBean lastCharpter = gridDataBean.getLastCharpter();
                String subTitle = lastCharpter.getTitle();

                Intent intent = new Intent(getContext(), DetailActivity.class);
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

    //加载数据
    private void initData() {
        GetUpdataDao.getInfomationDownData(UrlConfig.RECOMMEND_GRIDVIEW_PATH,handler,page,TUIJIAN,gridViewBean);
    }

    private void initView(View view) {
        gridViewBean = new GridViewBean();
        tuiJianGridview = (PullToRefreshGridView) view.findViewById(R.id.tuijian_gridview);
        //设置下拉刷新和下拉加载
        tuiJianGridview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                //下拉刷新数据
                GetUpdataDao.getInfomationDownData(UrlConfig.RECOMMEND_GRIDVIEW_PATH,handler,page++,TUIJIAN,gridViewBean);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                //上拉加载数据

            }
        });
    }

}
