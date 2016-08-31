package com.example.administrator.day8_8jobdemo.fragment.contentfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.MyGridViewAdapter;
import com.example.administrator.day8_8jobdemo.adapter.MyViewPagerAdapter;
import com.example.administrator.day8_8jobdemo.bean.DataBean;
import com.example.administrator.day8_8jobdemo.bean.GridDataBean;
import com.example.administrator.day8_8jobdemo.bean.GridViewBean;
import com.example.administrator.day8_8jobdemo.bean.LastCharpterBean;
import com.example.administrator.day8_8jobdemo.ui.DetailActivity;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class HotFragment extends Fragment {

    private static final int HOT_GRIDVIEW = 2;
    private static final int HOT_VIEWAPGER = 1;
    private PullToRefreshScrollView pullToRefresh;
    private ViewPager firstHotViewpager;
    private GridView firstHotGridView;

    private List<String> titleList;
    private TextView tvTitle;
    private MyViewPagerAdapter adapter;
    private List<ImageView> images;
    private int page = 1;
    String msg;

    List<GridDataBean> gridDatas = new ArrayList<>();
    private MyGridViewAdapter gridAdapter;
    private GridViewBean gridViewBean;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){

                case HOT_VIEWAPGER:
                    //viewpager的数据
                    getViewPagerDatas(msg);
                    break;
                case HOT_GRIDVIEW:
                    //gridview的数据
                    List<GridDataBean> data = (List<GridDataBean>) msg.obj;

                    if (page == 1){
                        //page=1时为第一次加载 gridDatas为空
                        gridDatas.addAll(data);
                        gridAdapter = new MyGridViewAdapter(gridDatas);
                        firstHotGridView.setAdapter(gridAdapter);
                    }else {

                        gridDatas.addAll(0,data);
                        gridAdapter.notifyDataSetChanged();
                    }
                    break;
            }
            pullToRefresh.onRefreshComplete();
        }
    };

    private void getViewPagerDatas(Message msg) {
        List<DataBean> dataBeen = (List<DataBean>) msg.obj;

        //遍历集合
        titleList = new ArrayList<>();
        images = new ArrayList<>();
        for (int i = 0; i < dataBeen.size(); i++){
            DataBean dataBean = dataBeen.get(i);
            //获取标题 并添加到集合中
            String title = dataBean.getTitle();
            titleList.add(title);
            String thumb = dataBean.getThumb();
            Log.i("TAG","thumb---------->"+thumb);
            //创建imageview控件
            ImageView ivLogo = new ImageView(getContext());
            Glide.with(getContext()).load(thumb).into(ivLogo);
            images.add(ivLogo);
        }
        //初始化
        titleList.get(0);
        //设置适配器
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(images);
        firstHotViewpager.setAdapter(adapter);
//        firstHotViewpager.setCurrentItem(1000*images.size());

        //设置viewpager的监听事件
        setPagerListener();

        //添加定时器

    }
    //viewpager的监听事件
    private void setPagerListener() {
        firstHotViewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tvTitle.setText(titleList.get(position%titleList.size()));
            }
        });

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_hot_fragment, container, false);
        //初始化布局
        initView(view);
        //初始化viewpager数据
        initViewPagerData();
        //设置gridview的监听事件
        setListener();
        return view;
    }

    //设置监听事件
    private void setListener() {
        firstHotGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到详情的页面
                GridDataBean gridDataBean = gridDatas.get(i);
                String comicId = gridDataBean.getComicId();
                //获取最新章节
                LastCharpterBean lastCharpter = gridDataBean.getLastCharpter();
                String subTitle = lastCharpter.getTitle();

                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.setAction("detail");
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
        gridViewBean = new GridViewBean();
        pullToRefresh = (PullToRefreshScrollView) view.findViewById(R.id.first_pulltorefresh);
        firstHotViewpager = (ViewPager) view.findViewById(R.id.first_hot_viewpager);
        tvTitle = (TextView) view.findViewById(R.id.viewpager_hot_title);
        firstHotGridView = (GridView) view.findViewById(R.id.first_hot_gridview);

        //设置pulltorefresh的刷新事件
        initPullToRefresh();
    }
    //获取viewpager得数据
    private void initViewPagerData() {
        //viewpager里添加的是图片的资源
        GetUpdataDao.getHotInfomationDownData(UrlConfig.HOT_VIEWPAGER_PATH,handler,0,HOT_VIEWAPGER);
        //初始化gridview数据
        initGridViewData();
    }

    //获取gridview得数据
    private void initGridViewData() {
        //开启线程下载数据
        GetUpdataDao.getInfomationDownData(UrlConfig.HOT_GRIDVIEW_PATH,handler,page,HOT_GRIDVIEW,gridViewBean);
    }
    private void initPullToRefresh() {
        //设置刷新的模式
        pullToRefresh.setMode(PullToRefreshBase.Mode.BOTH);
        //刷新时可以滑动
        pullToRefresh.setPullToRefreshOverScrollEnabled(true);
        //设置pullToRefresh的点击事件
        pullToRefresh.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //下拉刷新
                GetUpdataDao.getInfomationDownData(UrlConfig.HOT_GRIDVIEW_PATH,handler,page++,HOT_GRIDVIEW,gridViewBean);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //下拉加载
            }
        });
    }
}