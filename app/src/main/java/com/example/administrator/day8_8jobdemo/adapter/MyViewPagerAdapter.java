package com.example.administrator.day8_8jobdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MyViewPagerAdapter extends PagerAdapter{

    private List<ImageView> mList;
    public MyViewPagerAdapter(List<ImageView> images){
        this.mList = images;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = mList.get(position%mList.size());
        container.addView(imageView);
        Log.i("TAG","iiiiiiiiiiiii----position------>"+position);
        return imageView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position%mList.size()));
        Log.i("TAG","ddddddddd--position---->"+position);
    }
}
