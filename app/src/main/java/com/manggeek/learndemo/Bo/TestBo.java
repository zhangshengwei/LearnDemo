package com.manggeek.learndemo.Bo;

import com.manggeek.android.geek.http.GeekHttp;
import com.yanzhenjie.nohttp.rest.OnResponseListener;

/**
 * @Description:
 * @Author: zsw
 * @CreateDate: 2018/12/29 12:01 PM
 */
public class TestBo {
    /**
     * 获取服务器的最新版本号
     *
     * @param listener
     */
    public static void gainVersion(OnResponseListener listener) {

        GeekHttp.getHttp().get(0, URL.URL_GAIN_VERSION, listener);
    }


    public static void pythonTest(OnResponseListener listener){
        GeekHttp.getHttp().get(0, URL.URL_PYTHON, listener);
    }


    public static void RSAData(String content,OnResponseListener listener){
        BaseParams baseParams = new BaseParams();
        baseParams.put("content",content);
        GeekHttp.getHttp().get(0, URL.URL_PYTHON, baseParams,listener);
    }

}
