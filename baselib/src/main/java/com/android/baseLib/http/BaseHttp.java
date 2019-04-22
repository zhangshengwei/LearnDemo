package com.android.baseLib.http;

import com.android.baseLib.util.PrintLogUtil;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;


/**
 * @Description: 网络请求
 * @Author: xianggu
 * @CreateDate: 2019/1/15 3:01 PM
 */
public class BaseHttp {


    private static BaseHttp baseHttp;
    private RequestQueue queue;


    public static BaseHttp getBaseHttp(){
        if (baseHttp==null){
            synchronized (BaseHttp.class){
                if (baseHttp == null){
                    baseHttp = new BaseHttp();
                }
            }
        }
        return baseHttp;
    }

    public BaseHttp(){
        this.queue = NoHttp.newRequestQueue();
    }
    /**
     * 获取请求队列
     * @return
     */
    public RequestQueue getQueue() {
        return queue;
    }


    /**
     * GET请求 不带参数
     * @param what
     * @param URL
     * @param responseListener
     */
    public void get(int what, String URL, OnResponseListener responseListener){
        PrintLogUtil.log("HTTP>>>>>>>>>>(GET)URL:"+URL);
        Request<String> request = NoHttp.createStringRequest(URL,RequestMethod.GET);
        queue.add(what,request,responseListener);
    }

    /**
     * GET请求 带参
     * @param what
     * @param URL
     * @param httpParams
     * @param responseListener
     */
    public void get(int what, String URL,HttpParams httpParams ,OnResponseListener responseListener){
        PrintLogUtil.log("HTTP>>>>>>>>>>(GET)URL:"+URL);
        Request<String> request = NoHttp.createStringRequest(URL,RequestMethod.GET);
        httpParams.addParams(request);
        queue.add(what,request,responseListener);
    }

    /**
     * GET请求 带参  带头部数据
     * @param what
     * @param URL
     * @param httpParams
     * @param headValue
     * @param responseListener
     */
    public void get(int what, String URL,HttpParams httpParams,String headValue ,OnResponseListener responseListener){
        PrintLogUtil.log("HTTP>>>>>>>>>>(GET)URL:"+URL);
        Request<String> request = NoHttp.createStringRequest(URL,RequestMethod.GET);
        request.addHeader("Head_Key",headValue);
        httpParams.addParams(request);
        queue.add(what,request,responseListener);
    }


    /**
     * POST请求 不带参
     * @param what
     * @param URL
     * @param responseListener
     */
    public void post(int what,String URL,OnResponseListener responseListener){
        PrintLogUtil.log("HTTP>>>>>>>>>>(POST)URL:"+URL);
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        queue.add(what, request, responseListener);
    }


    /**
     * POST 请求 带参数
     * @param what
     * @param URL
     * @param httpParams
     * @param responseListener
     */
    public void post(int what,String URL,HttpParams httpParams,OnResponseListener responseListener){
        PrintLogUtil.log("HTTP>>>>>>>>>>(POST)URL:"+URL);
        PrintLogUtil.log("HTTP>>>>>>>>>>(POST)params:"+httpParams.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        httpParams.addParams(request);
        queue.add(what, request, responseListener);
    }


    /**
     * POST 请求带头部参数
     * @param what
     * @param URL
     * @param httpParams
     * @param headValue
     * @param responseListener
     */
    public void post(int what,String URL,HttpParams httpParams,String headValue,OnResponseListener responseListener){
        PrintLogUtil.log("HTTP>>>>>>>>>>(POST)URL:"+URL+"  head:"+headValue);
        PrintLogUtil.log("HTTP>>>>>>>>>>(POST)params:"+httpParams.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        request.addHeader("Head_Key",headValue);
        httpParams.addParams(request);
        queue.add(what, request, responseListener);
    }

}
