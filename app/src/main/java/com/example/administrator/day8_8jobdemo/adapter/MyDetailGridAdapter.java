package com.example.administrator.day8_8jobdemo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.bean.ComicSrcBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class MyDetailGridAdapter extends BaseAdapter{

    private List<ComicSrcBean> mList;
    private ViewHolder holder;

    public MyDetailGridAdapter(List<ComicSrcBean> comicSrc){
        this.mList = comicSrc;
        Log.i("TAG","mlist-------,.,...."+mList);
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
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_activity_gridview_item,parent,false);
        }
        holder = getViewHolder(view);
        ComicSrcBean comicSrcBean = mList.get(i);
        String title = comicSrcBean.getTitle();
        String subTitle = comicSrcBean.getLastCharpterTitle();
        int time = comicSrcBean.getLastCharpterUpdateTime();
        Log.i("TAG","time---ttttttttttttt-------->"+time);
        //添加数据
        holder.tvTitle.setText(title);
        holder.tvSubTitle.setText(subTitle);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);

        String times = format.format(date);
        Log.i("TAG","times------------>"+times);
        holder.tvTime.setText(times);
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

        TextView tvTitle,tvSubTitle,tvTime;
        public ViewHolder(View view){
            tvTitle = (TextView) view.findViewById(R.id.detail_gridview_item_title);
            tvTime = (TextView) view.findViewById(R.id.detail_gridview_item_time);
            tvSubTitle = (TextView) view.findViewById(R.id.detail_gridview_item_subtitle);
        }
    }
}
