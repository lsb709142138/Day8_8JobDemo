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
import com.example.administrator.day8_8jobdemo.bean.PingLunBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class MyPlListViewAdapter extends BaseAdapter{

    private List<PingLunBean.DataBean.CommentListBean> mList;
    public MyPlListViewAdapter(List<PingLunBean.DataBean.CommentListBean> commentList){
        this.mList = commentList;
        Log.i("TAG","mlist----pinglun---->"+mList);
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pinglun_listview_item,parent,false);
        }
        ViewHolder holder = getViewHolder(view);
        //绑定数据
        PingLunBean.DataBean.CommentListBean commentListBean = mList.get(i);
        String nickname = commentListBean.getNickname();
        String content = commentListBean.getContent();
        String postTime = commentListBean.getPostTime();
        String userThumb = commentListBean.getUserThumb();
        holder.tvAuther.setText(nickname);
        holder.tvDes.setText(content);
        if (userThumb != null){
            Glide.with(parent.getContext()).load(userThumb).into(holder.ivLogo);
        }else {
            holder.ivLogo.setImageResource(R.drawable.app_icon);
        }

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
        TextView tvAuther,tvTime,tvDes;
        public ViewHolder(View view){
            ivLogo = (ImageView) view.findViewById(R.id.pinglun_image_logo);
            tvAuther = (TextView) view.findViewById(R.id.pinglun_auther);
            tvTime = (TextView) view.findViewById(R.id.pinglun_time);
            tvDes = (TextView) view.findViewById(R.id.pinglun_description);

        }
    }
}
