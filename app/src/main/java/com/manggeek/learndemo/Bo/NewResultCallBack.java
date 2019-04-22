package com.manggeek.learndemo.Bo;

import android.content.Intent;

import com.manggeek.android.geek.http.Result;
import com.manggeek.android.geek.http.ResultCallBack;
import com.manggeek.android.geek.http.RetCode;
import com.manggeek.android.geek.manager.ActivityManager;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.learndemo.control.BaseActivity;

/**
 * @Description:
 * @Author: zsw
 * @CreateDate: 2018/12/29 12:06 PM
 */
public abstract class NewResultCallBack extends ResultCallBack {

    private static final String KEY = "ISRETURN";

    @Override
    public void onSuccess(int what, Result result) {
        if (RetCode.NO_PERMITTION.equals(result.getRetCode())) {
//            UserCache.clean();
//            BaseActivity mActivity = (BaseActivity) ActivityManager.getActivity().get();
//            Intent intent = new Intent(mActivity, LoginActivity.class);
//            intent.putExtra("INDEX",1);
//            intent.putExtra("TYPE", "EXPIRED");
//            mActivity.startActivity(intent);
//            PrintUtil.toastMakeText("请重新登录");
        }
        onResultSuccess(what,result);
    }


    public abstract void onResultSuccess(int what,Result result);
}