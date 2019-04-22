package com.android.baseLib.util;

import android.app.Activity;
import android.widget.Toast;

import com.android.baseLib.manager.MyActivityManager;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/15 3:29 PM
 */
public class PrintToastUtil {

    /**
     * 取ActivityManager中当前Activity显示message
     *
     * @param message
     */
    public static void toastMakeText(String message) {
        Activity activity = MyActivityManager.getActivity().get();
        if (activity != null) {
            toastMakeText(activity, message);
        }
    }

    /**
     * ToastMake 显示message
     *
     * @param activity
     * @param message
     */
    public static void toastMakeText(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
