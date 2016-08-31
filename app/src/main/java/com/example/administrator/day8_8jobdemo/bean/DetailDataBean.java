package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class DetailDataBean {

    @SerializedName("title")
    private String title;
    @SerializedName("comicId")
    private int comicId;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("authorName")
    private String authorName;
    @SerializedName("comicType")
    private String comicType;
    @SerializedName("areaName")
    private String areaName;
    @SerializedName("updateTime")
    private String updateTime;
    @SerializedName("tucaos")
    private String tucaos;
    @SerializedName("intro")
    private String intro;
    /**
     * title : 733dm
     * id : 10
     * lastCharpterTitle : 第5话
     * lastCharpterId : 1316392
     * lastCharpterUpdateTime : 1435568104
     */

    @SerializedName("comicSrc")
    private List<ComicSrcBean> comicSrc;
    /**
     * title : 第5话
     * sid : 5
     * id : 1316392
     * size : 0.8
     * counts : 5
     * iszm : 0
     */

    @SerializedName("charpters")
    private List<CharptersBean> charpters;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTucaos() {
        return tucaos;
    }

    public void setTucaos(String tucaos) {
        this.tucaos = tucaos;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<ComicSrcBean> getComicSrc() {
        return comicSrc;
    }

    public void setComicSrc(List<ComicSrcBean> comicSrc) {
        this.comicSrc = comicSrc;
    }

    public List<CharptersBean> getCharpters() {
        return charpters;
    }

    public void setCharpters(List<CharptersBean> charpters) {
        this.charpters = charpters;
    }

}
