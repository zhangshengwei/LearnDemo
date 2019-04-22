package com.manggeek.android.geek.http;

import com.manggeek.android.geek.utils.PrintUtil;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;

/**
 * 提供访问网络快捷功能
 * Created by wanglei on 16/3/28.
 */
public class GeekHttp {

    public static final String TAG = "GeekHttp";

    private static GeekHttp geekHttp;
    private RequestQueue queue;


    public static GeekHttp getHttp() {
        if (geekHttp == null) {
            synchronized (GeekHttp.class) {
                if (geekHttp == null) {
                    geekHttp = new GeekHttp();
                }
            }
        }
        return geekHttp;
    }

    public GeekHttp() {
        this.queue = NoHttp.newRequestQueue();
    }

    /**
     * GET请求
     * @param what
     * @param URL
     * @param responseListener
     */
    public void get(int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" GET", URL);
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        queue.add(what, request, responseListener);
    }

    /**
     * GET请求
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void get(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" GET", URL + "?" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        params.handle(request);
        queue.add(what, request, responseListener);
    }


    /**
     * POST请求
     * @param what
     * @param URL
     * @param responseListener
     */
    public void post(int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" POST", URL);
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        queue.add(what, request, responseListener);
    }

    /**
     * POST请求
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void post(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" POST", URL + "?" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        params.handle(request);
        queue.add(what, request, responseListener);
    }


    /**
     * 获取请求队列
     * @return
     */
    public RequestQueue getQueue() {
        return queue;
    }

}
