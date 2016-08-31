package com.example.administrator.day8_8jobdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ViewPagerBean {

    /**
     * status : 0
     * data : [{"title":"妖精的尾巴：第444话<皇帝斯普利玵>","recom_type":"0","recom_return":"39","thumb":"http://csimg.dm300.com/images/upload/20150714/14368443711916.jpg","recom_index":"5"},{"title":"一击男最新章节：第75话<别放回去！>","recom_type":"0","recom_return":"8115","thumb":"http://csimg.dm300.com/images/upload/20150714/14368422982708.jpg","recom_index":"4"},{"title":"《食戟之灵》一起羞耻地做美食吧~","recom_type":"0","recom_return":"7069","thumb":"http://csimg.dm300.com/images/upload/20150702/14358092989840.jpg","recom_index":"2"}]
     */

    @com.google.gson.annotations.SerializedName("status")
    private int status;
    /**
     * title : 妖精的尾巴：第444话<皇帝斯普利玵>
     * recom_type : 0
     * recom_return : 39
     * thumb : http://csimg.dm300.com/images/upload/20150714/14368443711916.jpg
     * recom_index : 5
     */

    @com.google.gson.annotations.SerializedName("data")
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


}
