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
public class MyListViewAdapter extends BaseAdapter{

    private List<GridDataBean> mList;
    private ViewHolder holder;

    public MyListViewAdapter(List<GridDataBean> list){

        this.mList = list;
        Log.i("TAG","listview--------->"+mList);
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.updata_fragment_listview_item,parent,false);
        }
        holder = getViewHolder(view);
        //解析数据源
        GridDataBean gridDataBean = mList.get(i);
        String title = gridDataBean.getTitle();
        String thumb = gridDataBean.getThumb();

        String authorName = gridDataBean.getAuthorName();
        String comicType = gridDataBean.getComicType();

        LastCharpterBean lastCharpter = gridDataBean.getLastCharpter();
//        String subTitle = lastCharpter.getTitle();
//        Log.i("TAG","title1----->"+subTitle);
        holder.tvTitle.setText(title);
        holder.tvAuther.setText("作者："+authorName);
        holder.tvType.setText("类型："+comicType);
//        holder.tvSubTitle.setText("最新："+subTitle);

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
        TextView tvTitle,tvSubTitle,tvAuther,tvType;
        public ViewHolder(View view){
            ivLogo = (ImageView) view.findViewById(R.id.listview_logo);
            
            tvTitle = (TextView) view.findViewById(R.id.listview_title);
            tvAuther = (TextView) view.findViewById(R.id.listview_auther);
            tvType = (TextView) view.findViewById(R.id.listview_type);
            tvSubTitle = (TextView) view.findViewById(R.id.listview_subtitle);
        }
    }
}
