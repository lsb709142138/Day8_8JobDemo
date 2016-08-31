package com.example.administrator.day8_8jobdemo.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.bean.MyLoveBean;
import com.example.administrator.day8_8jobdemo.ui.DetailActivity;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class SecondListViewAdapter extends BaseAdapter{

    private List<MyLoveBean> mList;
    public SecondListViewAdapter(List<MyLoveBean> myLoveBeen){
        this.mList = myLoveBeen;
    }
    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mList != null ? mList.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, final ViewGroup parent) {
        if (view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_fragment_listview_item,parent,false);
        }
        ViewHolder holder = getViewHolder(view);
        //绑定数据
        MyLoveBean bean = mList.get(i);
        //设置漫画标题
        String title = bean.getTitle();
        holder.tvTitle.setText(title);
        //设置漫画更新的时间
        String updataTime = bean.getUpdataTime();
        holder.tvTime.setText(updataTime);
        //设置漫画的最新章节
        String subTitle = bean.getSubTitle();
        holder.tvSubTitle.setText(subTitle);
        //加载漫画的图片
        String thunb = bean.getThumb();
        Glide.with(parent.getContext()).load(thunb).into(holder.ivLogo);


        return view;
    }
    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null){
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    class ViewHolder{
        ImageView ivLogo;
        TextView tvTitle,tvSubTitle,tvTime;
        public ViewHolder(View view){
            ivLogo = (ImageView) view.findViewById(R.id.second_fragment_listview_item_image);
            tvTitle = (TextView) view.findViewById(R.id.second_fragment_listview_item_title);
            tvTime = (TextView) view.findViewById(R.id.second_fragment_listview_item_time);
            tvSubTitle = (TextView) view.findViewById(R.id.second_fragment_listview_item_subtitle);
        }
    }
}
