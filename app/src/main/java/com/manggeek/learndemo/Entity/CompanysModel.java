package com.manggeek.learndemo.Entity;

import com.manggeek.learndemo.Util.PinYinStyle;
import com.manggeek.learndemo.Util.PinYinUtil;

/**
 * @Description: 公司列表
 * @Author: xianggu
 * @CreateDate: 2019/1/4 4:33 PM
 */
public class CompanysModel {

    private String name;
    private String pinyin;
    private String logo;
    private String phoneNum;



    public PinYinStyle pinYinStyle = new PinYinStyle();

    public CompanysModel() {

    }

    public CompanysModel(String name, String pinyin,String logo,String phoneNum) {
        this.name = name;
        this.pinyin = pinyin;
        this.logo = logo;
        this.phoneNum = phoneNum;
        setPinyin(PinYinUtil.getPinyin(name));
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public PinYinStyle getPinYinStyle() {
        return pinYinStyle;
    }

    public void setPinYinStyle(PinYinStyle pinYinStyle) {
        this.pinYinStyle = pinYinStyle;
    }
}
