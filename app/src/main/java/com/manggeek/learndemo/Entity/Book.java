package com.manggeek.learndemo.Entity;

/**
 * Created by zhangshengwei
 * Time: 2018/12/12 14:25
 * describe:
 */
public class Book {
    private String title;
    private String picture;
    private String name;

    public Book(String title, String picture, String name) {
        this.title = title;
        this.picture = picture;
        this.name = name;
    }


    public Book(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }


}
