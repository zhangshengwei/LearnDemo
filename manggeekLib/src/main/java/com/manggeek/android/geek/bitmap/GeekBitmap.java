package com.manggeek.android.geek.bitmap;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import com.manggeek.android.geek.R;
import com.manggeek.android.geek.utils.PrintUtil;

/**
 * 提供图片相关处理
 * Created by huangwenfei on 17/5/4.
 */
public class GeekBitmap {

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
//            Glide.with(activity).load(path).placeholder(R.mipmap.ic_nohead).dontAnimate().into(imageView);
        }
    }

    /**
     * 显示网络/本地图片
     *
     * @param context
     * @param imageView
     * @param path
     */
    public static void display(Context context, ImageView imageView, String path) {
        if (Util.isOnMainThread()) {
            Glide.with(context).load(path).into(imageView);
//            Glide.with(context).load(path).placeholder(R.mipmap.ic_isloading).dontAnimate().into(imageView);
        }
    }

    public static void display(Context context, ImageView imageView, String path,String type) {
        if (Util.isOnMainThread()) {
            Glide.with(context).load(path).into(imageView);
//            Glide.with(context).load(path).placeholder(R.mipmap.ic_isloading).dontAnimate().into(imageView);
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

    public static void display(Activity activity, ImageView imageView, Object object) {
        if (Util.isOnMainThread()) {
            Glide.with(activity).load(object).into(imageView);
        }
    }

    /**
     * 显示图片
     *
     * @param activity
     * @param imageView
     * @param path
     */
    public static void displayNeedSave(Activity activity, ImageView imageView, String path) {
//        if (Util.isOnMainThread()) {
//            Glide.with(activity).load(path)
////                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .listener(new RequestListener() {
//                        @Override
//                        public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
//                            return false;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
//                            PrintUtil.log("TAG___" + "onResourceReady: mode： " + model);
//                            return false;
//                        }
//                    })
//                    .into(imageView);
//        }
    }
}
