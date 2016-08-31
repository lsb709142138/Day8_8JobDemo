package com.example.administrator.day8_8jobdemo.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/8/10.
 */
@DatabaseTable(tableName = "manhua")
public class MyLoveBean {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String comicId;
    @DatabaseField
    private String title;
    @DatabaseField
    private String updataTime;
    @DatabaseField
    private String thumb;
    @DatabaseField
    private String subTitle;



    public MyLoveBean() {
    }

    public MyLoveBean(String comicId, String title, String updataTime, String thumb,String subTitle) {
        this.comicId = comicId;
        this.title = title;
        this.updataTime = updataTime;
        this.thumb = thumb;
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComicId() {
        return comicId;
    }

    public void setComicId(String comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(String updataTime) {
        this.updataTime = updataTime;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "MyLoveBean{" +
                "id=" + id +
                ", comicId='" + comicId + '\'' +
                ", title='" + title + '\'' +
                ", updataTime='" + updataTime + '\'' +
                ", thumb='" + thumb + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}
