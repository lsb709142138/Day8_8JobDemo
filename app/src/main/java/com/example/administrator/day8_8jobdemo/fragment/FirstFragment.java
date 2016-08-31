package com.example.administrator.day8_8jobdemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.factory.FragmentFactory;

/**
 * Created by Administrator on 2016/8/8.
 */
public class FirstFragment extends Fragment {

    private TabLayout mTablayout;
    private ViewPager mFirstViewPager;
    private String[] tabs;
    private MyFirstViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //填充一个布局到fragment
        View view = inflater.inflate(R.layout.first_fragment_layout, container, false);

        initViwe(view);
        initData();
        return view;
    }

    private void initViwe(View view) {

        //添加viewpager
        mTablayout = (TabLayout) view.findViewById(R.id.first_fragment_tablayout);
        mFirstViewPager = (ViewPager) view.findViewById(R.id.first_fragment_viewpager);
        //设置viewpager的缓存页面的数量 默认缓存两个
        mFirstViewPager.setOffscreenPageLimit(4);
    }

    private void initData() {
        tabs = getResources().getStringArray(R.array.tablayout_content);
        //处理tablayout与viewpager
        adapter = new MyFirstViewPagerAdapter(getFragmentManager());
        mFirstViewPager.setAdapter(adapter);
        //设置选中与没选中的字体颜色
        mTablayout.setTabTextColors(Color.GREEN,Color.RED);
        //设置指示器的颜色
        mTablayout.setSelectedTabIndicatorColor(Color.BLUE);
        //设置指示器的高度
        mTablayout.setSelectedTabIndicatorHeight(4);
        //tablayout与viewpager连接
        mTablayout.setupWithViewPager(mFirstViewPager);
    }

    private class MyFirstViewPagerAdapter extends FragmentPagerAdapter {

        public MyFirstViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //创建四个fragment
        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.getFragment(position,tabs[position]);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}