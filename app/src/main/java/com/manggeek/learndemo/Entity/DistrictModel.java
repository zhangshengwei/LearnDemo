package com.manggeek.learndemo.Entity;

/**
 * Created by zhangshengwei
 * Time: 2018/12/12 14:08
 * describe: 地区
 */
public class DistrictModel {

    private String name;
    private String zipcode;

    public DistrictModel() {
        super();
    }

    public DistrictModel(String name, String zipcode) {
        super();
        this.name = name;
        this.zipcode = zipcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "DistrictModel{" +
                "name='" + name + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
