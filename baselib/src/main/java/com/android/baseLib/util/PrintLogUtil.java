package com.android.baseLib.util;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.baseLib.manager.MyActivityManager;

/**
 * @Description:打印工具类
 * @Author: xianggu
 * @CreateDate: 2019/1/15 3:10 PM
 */
public class PrintLogUtil {

    /**
     * 打印log
     *
     * @param msg
     */
    public static void log(Object msg) {
        log("--->", String.valueOf(msg));
    }

    /**
     * 打印log
     *
     * @param msg
     */
    public static void log(String tag, String msg) {
        msg = msg.trim();
        int index = 0;
        int maxLength = 4000;
        String singleLog;
        while (index < msg.length()) {
            if (msg.length() <= index + maxLength) {
                singleLog = msg.substring(index);
            } else {
                singleLog = msg.substring(index, maxLength + index);
            }
            index += maxLength;
            Log.d(tag, singleLog.trim());
        }
    }

}
