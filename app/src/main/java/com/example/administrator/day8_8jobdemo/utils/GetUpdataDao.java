package com.example.administrator.day8_8jobdemo.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.administrator.day8_8jobdemo.bean.CategaryBean;
import com.example.administrator.day8_8jobdemo.bean.DataBean;
import com.example.administrator.day8_8jobdemo.bean.DetailBean;
import com.example.administrator.day8_8jobdemo.bean.DetailDataBean;
import com.example.administrator.day8_8jobdemo.bean.GridDataBean;
import com.example.administrator.day8_8jobdemo.bean.GridViewBean;
import com.example.administrator.day8_8jobdemo.bean.MHBean;
import com.example.administrator.day8_8jobdemo.bean.PingLunBean;
import com.example.administrator.day8_8jobdemo.bean.PopupWindowBean;
import com.example.administrator.day8_8jobdemo.bean.SearchBean;
import com.example.administrator.day8_8jobdemo.bean.ViewPagerBean;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class GetUpdataDao {

    //加载gridview的方法 主页面
    public static void getInfomationDownData(String url, final Handler handler, int page, final int type, final GridViewBean clazz) {
        final Gson gson = new GsonBuilder().create();
        final String path = url + page;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                GridViewBean gridViewBean = gson.fromJson(json, clazz.getClass());
                List<GridDataBean> data = gridViewBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();

    }
    //下载分类的详情
    public static void getCartoonData(String url, final Handler handler, String careid, final int type, final GridViewBean clazz) {
        final Gson gson = new GsonBuilder().create();
        final String path = url + careid+ UrlConfig.CATE_TWO_PATH;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                GridViewBean gridViewBean = gson.fromJson(json, clazz.getClass());
                List<GridDataBean> data = gridViewBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();

    }
    //下载popupwindow内的数据
    public static void getPopupWindowData(String url, final Handler handler, String id, int comicId, final int type) {
        final Gson gson = new GsonBuilder().create();
        final String path = url + id+ "&comicid="+comicId;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                PopupWindowBean popupWindowBean = gson.fromJson(json, PopupWindowBean.class);
                List<PopupWindowBean.DataBean> data = popupWindowBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();

    }

    //加载viewpager的方法
    public static void getHotInfomationDownData(String url, final Handler handler, int page, final int type) {
        final Gson gson = new GsonBuilder().create();
        final String path = url + page;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                ViewPagerBean dataBean = gson.fromJson(json, ViewPagerBean.class);
                List<DataBean> data = dataBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();

    }
    //加载漫画的方法
    public static void getMHData(String url, final Handler handler, int mid, final int type) {
        final Gson gson = new GsonBuilder().create();
        final String path = url + mid;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                MHBean mhBean = gson.fromJson(json, MHBean.class);
                MHBean.DataBean data = mhBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();
    }
    public static void getSearchData(String url, final Handler handler, String content, final int type) {
        final Gson gson = new GsonBuilder().create();
        final String path = url + content;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                GridViewBean gridViewBean = gson.fromJson(json, GridViewBean.class);
                List<GridDataBean> data = gridViewBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();
    }
    //加载详情页面数据的方法
    public static void getDetailInfomationData(String url, final Handler handler, String comicId, final int type){
        final Gson gson = new GsonBuilder().create();
        final String path = url + comicId;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                Log.i("TAG","getJosn-------detail------->"+json);
                DetailBean detailBean = gson.fromJson(json, DetailBean.class);
                DetailDataBean data = detailBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();

    }

    public static void getPingLunInfomationData(String url, final Handler handler, String comicId, final int type){
        final Gson gson = new GsonBuilder().create();
        final String path = url + comicId;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(path);
                Log.i("TAG","getJosn-------detail------->"+json);
                PingLunBean pingLunBean = gson.fromJson(json, PingLunBean.class);
                PingLunBean.DataBean data = pingLunBean.getData();
                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();

    }
    public static void getCatageryData(final String url, final Handler handler, final int type){
        final Gson gson = new GsonBuilder().create();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = OkhttpUtils.getJson(url);
                CategaryBean bean = gson.fromJson(json, CategaryBean.class);
                List<CategaryBean.DataBean> data = bean.getData();

                Message msg = handler.obtainMessage(type, data);
                handler.sendMessage(msg);
            }
        }).start();

    }
}
