package com.android.baseLib.http;

import android.text.TextUtils;

import com.android.baseLib.util.JSONUtil;
import com.android.baseLib.util.PrintLogUtil;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/15 4:00 PM
 */
public abstract class ResultCallBack implements OnResponseListener<String> {

    @Override public void onStart(int what) {

    }

    @Override public void onSucceed(int what, Response<String> response) {
        String resultStr = response.get();
        PrintLogUtil.log("HTTP>>onSucceed:" + what + "\n" + resultStr);
        Result result = null;
        if (!TextUtils.isEmpty(resultStr)) {
            result = JSONUtil.getObj(resultStr, Result.class);
        }
        if (result == null) {
            result = new Result();
            result.setCode(-1);
            result.setMsg("暂无数据");
        } else {
            result.setJson(resultStr);
        }
//        onSuccess(what, result, response);
        onSuccess(what, result);
    }


    @Override public void onFailed(int what, Response<String> response) {
        PrintLogUtil.log("HTTP>>onFailed:" + what + "\nurl:" + response.get() + "\ntag:" + response.getTag() + "\nexception:" + response.getException() + "\nresponseCode:" + response.responseCode() + "\nnetworkMillis:" + response.getNetworkMillis());
        Result result = new Result();
        result.setCode(-1);
        result.setException(response.getException());
        result.setMsg("网络异常");
        onSuccess(what, result);
    }

    @Override public void onFinish(int what) {
    }

//    public abstract void onSuccess(int what, Result result, Response<String> response);

    public abstract void onSuccess(int what, Result result);
}
