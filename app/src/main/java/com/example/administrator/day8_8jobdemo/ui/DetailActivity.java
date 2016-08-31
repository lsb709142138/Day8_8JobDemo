package com.example.administrator.day8_8jobdemo.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.MyDetailGridAdapter;
import com.example.administrator.day8_8jobdemo.adapter.PopupWindowAdapter;
import com.example.administrator.day8_8jobdemo.bean.ComicSrcBean;
import com.example.administrator.day8_8jobdemo.bean.DetailDataBean;
import com.example.administrator.day8_8jobdemo.bean.GridViewBean;
import com.example.administrator.day8_8jobdemo.bean.MyLoveBean;
import com.example.administrator.day8_8jobdemo.bean.PopupWindowBean;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;
import com.lidroid.xutils.exception.DbException;

import org.xutils.view.annotation.ContentView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/8/10.
 */
public class DetailActivity extends BaseActivity{

    private static final int POPUP = 12;
    private ImageView imageLogo;
    private FloatingActionButton mCollection;
    private CollapsingToolbarLayout mCollapse;
    private ListView mListView;
    private Toolbar mToolbar;
    private DetailDataBean data;
    private String title;
    private String thumb;
    private String updateTime;
    private PopupWindow popup;
    private GridView pGridView;
    public static final int DETAIL = 6;
    String comicId = "";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case DETAIL:
                    //获取详情的数据
                    data = (DetailDataBean) msg.obj;
                    //设置名称
                    title = data.getTitle();
                    mCollapse.setTitle(title);
                    //加载图片
                    thumb = data.getThumb();
                    Glide.with(DetailActivity.this).load(thumb).into(imageLogo);
                    //最近更新的时间
                    updateTime = data.getUpdateTime();
                    List<ComicSrcBean> comicSrc = data.getComicSrc();
                    //设置适配器 传递数据
                    MyDetailGridAdapter adapter = new MyDetailGridAdapter(comicSrc);
                    mListView.setAdapter(adapter);
                    break;
                case POPUP:
                    popupData = (List<PopupWindowBean.DataBean>) msg.obj;
                    //设置适配器
                    //绑定数据
                    PopupWindowAdapter popupAdapter = new PopupWindowAdapter(popupData);
                    pGridView.setAdapter(popupAdapter);
                    break;

            }
        }
    };
    private List<PopupWindowBean.DataBean> popupData;
    private String subtitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消系统自带的标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detail_activity_main_layout);

        //初始化控件
        initView();
        //关联数据
        initData();
    }

    private void initData() {
        //获取传递过来的信息
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("detail".equals(action)){
            //获取数据
            Bundle bundle = intent.getBundleExtra("bundle");
            subtitle = bundle.getString("subtitle");
            comicId = bundle.getString("comicId");
            String url = bundle.getString("url");
            //开始下载数据
            GetUpdataDao.getDetailInfomationData(url,handler,comicId,DETAIL);
        }
    }

    private void initView() {
        //初始化控件
        imageLogo = (ImageView) findViewById(R.id.detail_collapse_imageview);
        mCollapse = (CollapsingToolbarLayout) findViewById(R.id.detail_collapse_layout);

        mCollection = (FloatingActionButton) findViewById(R.id.detail_floating_button);
        mToolbar = (Toolbar) findViewById(R.id.detail_activity_layout_toolbar);
        mListView = (ListView) findViewById(R.id.detail_listview);


        //填充菜单
        mToolbar.inflateMenu(R.menu.detail_menu);
        //设置溢出菜单的图片
        mToolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_menu_more_overflow));
        //设置toolbar的返回事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //设置菜单的点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pinglun:
                        //跳转到评论的activity
                        Intent intent = new Intent(DetailActivity.this,TalkActivity.class);
                        intent.putExtra("comicId",comicId);
                        startActivity(intent);
                        break;
                    case R.id.jianjie:
                        //弹出简介的对话框
                        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                        //获取并设置漫画的标题
                        String title = data.getTitle();
                        builder.setTitle(title);
                        //获取并设置漫画的简介
                        String intro = data.getIntro();
                        builder.setMessage(intro);
                        builder.show();
                        break;
                }
                return true;
            }
        });

        //listview条目的点击 弹出popupwindow显示漫画列表
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int comicId = data.getComicId();
                String id = data.getComicSrc().get(i).getId();
                //点击条目弹出popupwindow
                showPopupWindow(comicId,id);
            }
        });

        //设置按钮的点击事件  当点击时将数据添加到数据库
        mCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //将漫画的id存到bean中
                    List<MyLoveBean> all = MainActivity.dbUtils.findAll(MyLoveBean.class);
                    List<String> mList = new ArrayList<String>();
                    //要添加的对象
                    MyLoveBean myLoveBean = new MyLoveBean(comicId,title,updateTime,thumb,subtitle);
                    if (all == null){
                        //存入数据库
                        MainActivity.dbUtils.save(myLoveBean);
                        Toast.makeText(DetailActivity.this, "收藏成功1111", Toast.LENGTH_SHORT).show();
                    }else {
                        for (int i = 0; i < all.size(); i++) {
                            MyLoveBean bean = all.get(i);
                            String comicId = bean.getComicId();
                            mList.add(comicId);
                        }
                        //判断是否已经存在
                        if (mList.contains(comicId)) {
                            Toast.makeText(DetailActivity.this, "已添加成功，不需要添加", Toast.LENGTH_SHORT).show();
                        } else {
                            //存入数据库
                            MainActivity.dbUtils.save(myLoveBean);
                            Toast.makeText(DetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //显示popupwindow
    private void showPopupWindow(int comicId, String id) {
        //http://csapi.dm300.com:21889/android/comic/charpterlist?comicsrcid= %id &comicid= %comicId
        //漫画列表
        //填充popupwindow的布局
        View contentView =  LayoutInflater.from(DetailActivity.this).inflate(R.layout.popup_window_layout, null);
        popup = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //获取焦点
        popup.setFocusable(true);
        popup.setOutsideTouchable(true);
        //设置在父窗体中显示的位置
        View rootView = LayoutInflater.from(DetailActivity.this).inflate(R.layout.detail_activity_main_layout, null);
        popup.showAtLocation(rootView, Gravity.CENTER,0,0);
        //设置其透明度
        WindowManager.LayoutParams alpha = getWindow().getAttributes();
        //设置透明度
        alpha.alpha = 0.5f;
        getWindow().setAttributes(alpha);
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popup.isShowing()){
                    popup.dismiss();
                }
            }
        });
        popup.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE){
                    finish();
                }
                return true;
            }
        });
        //下载数据显示在gridview中
        initPopupData(comicId,id,contentView);

    }

    private void initPopupData(int comicId, String id,View contentView) {
        pGridView = (GridView) contentView.findViewById(R.id.popup_window_gridview);

        //下载数据
        GetUpdataDao.getPopupWindowData(UrlConfig.POPUPWINDOW_PATH,handler,id,comicId,POPUP);

        //设置gridview的点击事件
        pGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PopupWindowBean.DataBean dataBean = popupData.get(i);
                int mId = dataBean.getId();
                //启动浏览activity观看漫画
                Intent intent = new Intent(DetailActivity.this,MHActivity.class);
                intent.putExtra("mid",mId);
                startActivity(intent);
            }
        });
    }

}
