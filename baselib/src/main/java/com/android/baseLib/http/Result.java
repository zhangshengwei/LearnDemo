package com.android.baseLib.http;

import android.text.TextUtils;

import com.android.baseLib.util.JSONUtil;
import com.android.baseLib.util.PrintToastUtil;

import java.util.List;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/15 3:44 PM
 */
public class Result {

    private int code;
    private String data;
    private String msg;
    private String json;

    private Exception exception;

    public boolean isSuccess() {
        return ResultCode.SUCCESS==code;
    }

    public boolean isNoBind() {
        return ResultCode.ACCOUNT_NO_BIND==code;
    }

    public boolean isNoData() {
        return ResultCode.NO_DATA==code;
    }


    /**
     * 土司错误信息
     */
    public void printErrorMsg() {
        if (!TextUtils.isEmpty(msg)) {
//            errorMsg = TextUtilCN_TW.TwToCNchange(errorMsg);
            PrintToastUtil.toastMakeText(msg);
        }
    }

    /**
     * <T> T
     */
    public <T> T getObj(Class<T> cls) { return JSONUtil.getObj(data, cls);
    }

    /**
     * <T> List<T>
     */
    public <T> List<T> getListObj(Class<T> cls) {
        return JSONUtil.getListObj(data, cls);
    }



    /***********************SET/GET方法*************************/

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
