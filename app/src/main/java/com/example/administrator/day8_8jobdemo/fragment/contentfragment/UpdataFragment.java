package com.example.administrator.day8_8jobdemo.fragment.contentfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.MyListViewAdapter;
import com.example.administrator.day8_8jobdemo.bean.GridDataBean;
import com.example.administrator.day8_8jobdemo.bean.GridViewBean;
import com.example.administrator.day8_8jobdemo.bean.LastCharpterBean;
import com.example.administrator.day8_8jobdemo.ui.DetailActivity;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;
import com.example.administrator.day8_8jobdemo.utils.OkhttpUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class UpdataFragment extends Fragment{


    private PullToRefreshListView mListview;
    private Gson gson;

    public static final int UPDATA= 5;
    int page = 1;
    private MyListViewAdapter adapter;
    List<GridDataBean> mList = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATA:
                    List<GridDataBean> data = (List<GridDataBean>) msg.obj;
                    //判断加载的页码是否是第一页
                    if (page == 1){
                        mList.addAll(data);
                        adapter = new MyListViewAdapter(mList);
                        mListview.setAdapter(adapter);
                    }else{
                        mList.addAll(0,data);
                        //向适配器发出通知
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
            mListview.onRefreshComplete();
        }
    };
    private GridViewBean gg;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.updata_fragment_layout, container, false);
        //初始化布局
        initView(view);
        //加载数据
        initData();
        //设置listview的监听
        setListener();
        return view;
    }

    private void setListener() {
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到详情的页面
                GridDataBean gridDataBean = mList.get(i);
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

    private void initView(View view) {
        gg = new GridViewBean();
        mListview = (PullToRefreshListView) view.findViewById(R.id.updata_fragment_listview);

        //监听刷新事件
        mListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新
                GetUpdataDao.getInfomationDownData(UrlConfig.UPDATA_LIST_PATH,handler,page++,UPDATA, gg);
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载
            }
        });
    }
    //加载数据
    private void initData() {
        GetUpdataDao.getInfomationDownData(UrlConfig.UPDATA_LIST_PATH,handler,page,UPDATA,gg);
    }

}
