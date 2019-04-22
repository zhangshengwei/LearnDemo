package com.android.baseLib.util;

import com.android.baseLib.BaseApplication;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/15 12:02 PM
 */
public class WindowUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int toPx(float dpValue) {
        float scale = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int toDp(float pxValue) {
        float scale = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获得手机屏幕宽度得到像素px
     */
    public static int getWidth() {
        return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获得手机屏幕高度得到像素px
     */
    public static int getHeight() {
        return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }
}
