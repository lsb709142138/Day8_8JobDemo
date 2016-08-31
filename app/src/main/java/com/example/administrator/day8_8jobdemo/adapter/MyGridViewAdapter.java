package com.example.administrator.day8_8jobdemo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.bean.GridDataBean;
import com.example.administrator.day8_8jobdemo.bean.LastCharpterBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MyGridViewAdapter extends BaseAdapter{

    private List<GridDataBean> mList;
    private ViewHolder holder;

    public MyGridViewAdapter(List<GridDataBean> list){
        this.mList = list;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_hot_gridview_item,parent,false);
        }
        holder = getViewHolder(view);
        //解析数据源
        GridDataBean gridDataBean = mList.get(i);
        String title = gridDataBean.getTitle();
        String thumb = gridDataBean.getThumb();


        String subTitle = gridDataBean.getLastCharpter().getTitle();
        //设置数据
        holder.tvTitle.setText(title);
        holder.tvSubTitle.setText(subTitle);
        Glide.with(parent.getContext()).load(thumb).into(holder.ivLogo);
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
        TextView tvTitle,tvSubTitle;
        public ViewHolder(View view){
            ivLogo = (ImageView) view.findViewById(R.id.first_gridview_logo);
            tvTitle = (TextView) view.findViewById(R.id.gridview_title);
            tvSubTitle = (TextView) view.findViewById(R.id.gridview_subtitle);
        }
    }
}
