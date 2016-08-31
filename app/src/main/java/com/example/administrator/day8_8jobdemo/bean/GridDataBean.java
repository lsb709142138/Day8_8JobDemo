package com.example.administrator.day8_8jobdemo.bean;

import com.example.administrator.day8_8jobdemo.bean.LastCharpterBean;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/9.
 */

public class GridDataBean {
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
     * id : 2007555
     * title : 普通的恋子酱 009集
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
}

