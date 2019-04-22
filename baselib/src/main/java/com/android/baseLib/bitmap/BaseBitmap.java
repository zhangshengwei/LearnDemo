package com.android.baseLib.bitmap;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

/**
 * @Description: 图片处理显示
 * @Author: xianggu
 * @CreateDate: 2019/1/15 2:19 PM
 */
public class BaseBitmap {

    /**
     * 显示网络/本地图片
     *
     * @param activity
     * @param imageView
     * @param path
     */
    public static void display(Activity activity, ImageView imageView, String path) {
        if (Util.isOnMainThread()) {
            Glide.with(activity).load(path).into(imageView);
        }
    }


    /**
     * 显示网络/本地图片，图片未加载完成时，预显示本地资源图片
     * @param activity
     * @param imageView
     * @param path
     * @param resource
     */
    public static void displayLoad(Activity activity, ImageView imageView, String path,int resource) {
        if (Util.isOnMainThread()) {
            Glide.with(activity).load(path).placeholder(resource).dontAnimate().into(imageView);
        }
    }

    /**
     * 显示资源图片
     *
     * @param activity
     * @param imageView
     * @param resId
     */
    public static void display(Activity activity, ImageView imageView, int resId) {
        if (Util.isOnMainThread()) {
            Glide.with(activity).load(resId).into(imageView);
        }
    }

    /**
     * 显示图片
     *
     * @param activity
     * @param imageView
     * @param object
     */
    public static void display(Activity activity, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            Glide.with(activity).load(object).into(imageView);
        }
    }

    /**
     * 显示网络/本地图片
     *
     * @param context
     * @param imageView
     * @param object
     */
    public static void display(Context context, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            Glide.with(context).load(object).into(imageView);
        }
    }

    //显示圆形图片
    public static void displayCirclePicture(Context context, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            Glide.with(context).load(object).transform(new GlideCircleTransform(context)).into(imageView);
        }
    }

    //显示圆角图片
    public static void displayRoundPicture(Context context, int dp, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            Glide.with(context).load(object).transform(new GlideRoundTransform(context, dp)).into(imageView);
        }
    }

}
