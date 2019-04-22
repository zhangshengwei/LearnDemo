package com.manggeek.learndemo.Bo;

/**
 * @Description:网络请求地址
 * @Author: zsw
 * @CreateDate: 2018/12/29 11:59 AM
 */
public class URL {

    private static final String HOST = "http://api.fs5u.com/";

    //获取服务器的最新版本号
    public static final String URL_GAIN_VERSION = HOST + "android.json";

    //python接口请求
    public static final String URL_PYTHON = "http://127.0.0.1:8000/index";



    //RSA加密地址
    public static final String URL_RSA = "http://192.168.199.151:8761/sign/check";

}
