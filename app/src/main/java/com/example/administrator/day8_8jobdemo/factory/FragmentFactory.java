package com.example.administrator.day8_8jobdemo.factory;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;

import com.example.administrator.day8_8jobdemo.fragment.contentfragment.HotFragment;
import com.example.administrator.day8_8jobdemo.fragment.contentfragment.TuiJianFragment;
import com.example.administrator.day8_8jobdemo.fragment.contentfragment.UpdataFragment;
import com.example.administrator.day8_8jobdemo.fragment.contentfragment.WondelfulFragment;

/**
 * Created by Administrator on 2016/8/8.
 */
public class FragmentFactory {

    private static SparseArray<Fragment> fragments = new SparseArray<>();

    private static final int FIRST_HOT = 0;
    private static final int FIRST_RECOMMEND = 1;
    private static final int FIRST_SPLENDID = 2;
    private static final int FIRST_UPDATA = 3;
    public static Fragment getFragment(int position,String msg){
        Fragment fragment = fragments.get(position);
        if (fragment == null){
            switch (position){
                case FIRST_HOT:
                    fragment = new HotFragment();
                    break;
                case FIRST_RECOMMEND:
                    fragment = new TuiJianFragment();
                    break;
                case FIRST_SPLENDID:
                    fragment = new WondelfulFragment();
                    break;
                case FIRST_UPDATA:
                    fragment = new UpdataFragment();
                    break;
            }
            fragments.put(position,fragment);
        }
        return fragment;
    }
}
