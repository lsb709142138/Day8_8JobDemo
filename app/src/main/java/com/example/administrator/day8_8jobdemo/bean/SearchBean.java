package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class SearchBean {

    /**
     * status : 0
     * data : [{"title":"古惑仔","thumb":"http://csimg.dm300.com/images/spider/20150326/14273531109524.jpg","comicId":"14877","authorName":"牛佬","comicType":"武侠格斗","lastCharpter":{"id":"1745785","title":"第1972-1973回"}},{"title":"砵兰街(古惑仔砵蘭街)高清版","thumb":"http://csimg.dm300.com/images/spider/20150326/14273533438847.jpg","comicId":"16502","authorName":"牛佬","comicType":"武侠格斗","lastCharpter":{"id":"232629","title":"第156卷"}},{"title":"山鸡传奇(古惑仔外传)高清晰版","thumb":"http://csimg.dm300.com/images/spider/20150326/14273533983875.jpg","comicId":"16914","authorName":"赖兆波","comicType":"武侠格斗","lastCharpter":{"id":"242772","title":"卷5-3"}},{"title":"陈兆希传(古惑仔外传)高清版","thumb":"http://csimg.dm300.com/images/spider/20150326/14273534185063.jpg","comicId":"17108","authorName":"牛佬","comicType":"热血","lastCharpter":{"id":"247533","title":"第5卷"}},{"title":"麻辣大哥(古惑仔外传:打仔浩南)高清晰版","thumb":"http://csimg.dm300.com/images/spider/20150326/14273534181792.jpg","comicId":"17111","authorName":"邱瑞新","comicType":"武侠格斗","lastCharpter":{"id":"247661","title":"卷7-3"}},{"title":"立花正仁(古惑仔外传)","thumb":"http://csimg.dm300.com/images/spider/20150326/14273534501306.jpg","comicId":"17523","authorName":"牛佬","comicType":"武侠格斗","lastCharpter":{"id":"254840","title":"卷30"}},{"title":"古惑仔漫画2007新春特刊","thumb":"http://csimg.dm300.com/images/spider/20150326/14273534986968.jpg","comicId":"18227","authorName":"牛佬","comicType":"武侠格斗","lastCharpter":{"id":"262301","title":"全一册"}},{"title":"古惑仔外传-陈浩南故事清晰版","thumb":"http://csimg.dm300.com/images/spider/20150326/14273535293663.jpg","comicId":"18497","authorName":"牛佬","comicType":"武侠格斗","lastCharpter":{"id":"264779","title":"全一册"}},{"title":"人在江湖（古惑仔漫画高清晰版）","thumb":"http://csimg.dm300.com/images/spider/20150506/14308863198593.jpg","comicId":"30366","authorName":"牛佬","comicType":"武侠格斗","lastCharpter":{"id":"611211","title":"第296话"}},{"title":"人在江湖","thumb":"http://csimg.dm300.com/images/spider/20150617/14345471614062.jpg","comicId":"45383","authorName":"杰仔","comicType":"武侠格斗","lastCharpter":{"id":"1286421","title":"第二十话：封龙"}},{"title":"古惑仔系列","thumb":"http://csimg.dm300.com/images/spider/20160425/14615545449216.jpg","comicId":"50972","authorName":"未知","comicType":"魔幻","lastCharpter":{"id":"1971500","title":"古惑仔 1933集"}}]
     */

    @SerializedName("status")
    private int status;
    /**
     * title : 古惑仔
     * thumb : http://csimg.dm300.com/images/spider/20150326/14273531109524.jpg
     * comicId : 14877
     * authorName : 牛佬
     * comicType : 武侠格斗
     * lastCharpter : {"id":"1745785","title":"第1972-1973回"}
     */

    @SerializedName("data")
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

    public static class DataBean {
        @SerializedName("title")
        private String title;
        @SerializedName("thumb")
        private String thumb;
        @SerializedName("comicId")
        private String comicId;
        @SerializedName("authorName")
        private String authorName;
        @SerializedName("comicType")
        private String comicType;
        /**
         * id : 1745785
         * title : 第1972-1973回
         */

        @SerializedName("lastCharpter")
        private LastCharpterBean lastCharpter;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getComicId() {
            return comicId;
        }

        public void setComicId(String comicId) {
            this.comicId = comicId;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getComicType() {
            return comicType;
        }

        public void setComicType(String comicType) {
            this.comicType = comicType;
        }

        public LastCharpterBean getLastCharpter() {
            return lastCharpter;
        }

        public void setLastCharpter(LastCharpterBean lastCharpter) {
            this.lastCharpter = lastCharpter;
        }

        public static class LastCharpterBean {
            @SerializedName("id")
            private String id;
            @SerializedName("title")
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
