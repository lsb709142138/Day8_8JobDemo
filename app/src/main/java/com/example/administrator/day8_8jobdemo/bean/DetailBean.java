package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class DetailBean {

    /**
     * status : 0
     * data : {"title":"潜龙勿用","comicId":34846,"thumb":"http://csimg.dm300.com/images/spider/20150615/14343650723831.jpg","authorName":"気啦啦-kirara","comicType":"耽美BL","areaName":"国产","updateTime":"2015-06-29","comicSrc":[{"title":"733dm","id":"10","lastCharpterTitle":"第5话","lastCharpterId":"1316392","lastCharpterUpdateTime":1435568104}],"tucaos":"63","intro":"剑网三丐毒耽美同人，腹黑忠犬*狡猾惹事精","charpters":[{"title":"第5话","sid":5,"id":1316392,"size":0.8,"counts":5,"iszm":0},{"title":"第4话","sid":4,"id":901028,"size":0.9,"counts":6,"iszm":0},{"title":"第3话","sid":3,"id":901027,"size":1.21,"counts":11,"iszm":0},{"title":"第2话","sid":2,"id":901026,"size":1.28,"counts":8,"iszm":0},{"title":"第1话","sid":1,"id":901025,"size":1.17,"counts":9,"iszm":0}]}
     */

    @SerializedName("status")
    private int status;
    /**
     * title : 潜龙勿用
     * comicId : 34846
     * thumb : http://csimg.dm300.com/images/spider/20150615/14343650723831.jpg
     * authorName : 気啦啦-kirara
     * comicType : 耽美BL
     * areaName : 国产
     * updateTime : 2015-06-29
     * comicSrc : [{"title":"733dm","id":"10","lastCharpterTitle":"第5话","lastCharpterId":"1316392","lastCharpterUpdateTime":1435568104}]
     * tucaos : 63
     * intro : 剑网三丐毒耽美同人，腹黑忠犬*狡猾惹事精
     * charpters : [{"title":"第5话","sid":5,"id":1316392,"size":0.8,"counts":5,"iszm":0},{"title":"第4话","sid":4,"id":901028,"size":0.9,"counts":6,"iszm":0},{"title":"第3话","sid":3,"id":901027,"size":1.21,"counts":11,"iszm":0},{"title":"第2话","sid":2,"id":901026,"size":1.28,"counts":8,"iszm":0},{"title":"第1话","sid":1,"id":901025,"size":1.17,"counts":9,"iszm":0}]
     */

    @SerializedName("data")
    private DetailDataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DetailDataBean getData() {
        return data;
    }

    public void setData(DetailDataBean data) {
        this.data = data;
    }


}
