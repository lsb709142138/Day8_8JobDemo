package com.example.administrator.day8_8jobdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.bean.CategaryBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class ThirdGridAdapter extends BaseAdapter{
    private List<CategaryBean.DataBean> mList;
    private ViewHolder holder;

    public ThirdGridAdapter(List<CategaryBean.DataBean> list){

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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.third_fragment_gridview_item,parent,false);
        }
        holder = getViewHolder(view);
        //解析数据源
        CategaryBean.DataBean bean = mList.get(i);
        String title = bean.getTitle();
        String thumb = bean.getThumb();
        //设置动漫的类型名称
        holder.tvTitle.setText(title);

        //设置圆形图片
        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(parent.getResources())
                .setRoundingParams(RoundingParams.asCircle())
                .build();
        holder.ivLogo.setHierarchy(hierarchy);
        //加载图片
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(thumb).build();
        holder.ivLogo.setController(controller);

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
        SimpleDraweeView ivLogo;
        TextView tvTitle;
        public ViewHolder(View view){
            ivLogo = (SimpleDraweeView) view.findViewById(R.id.third_fragment_gridview_item_image);
            tvTitle = (TextView) view.findViewById(R.id.third_fragment_gridview_item_title);
        }
    }
}
