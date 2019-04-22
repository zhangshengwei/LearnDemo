package com.manggeek.android.geek.utils;


import com.manggeek.android.geek.GeekApplication;

/**
 * 手机窗口工具类
 * @author wanglei 2015年8月1日 上午6:10:15
 */
public class Window {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int toPx(float dpValue) {
        float scale = GeekApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int toDp(float pxValue) {
        float scale = GeekApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获得手机屏幕宽度得到像素px
     */
    public static int getWidth() {
        return GeekApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获得手机屏幕高度得到像素px
     */
    public static int getHeight() {
        return GeekApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }
}
