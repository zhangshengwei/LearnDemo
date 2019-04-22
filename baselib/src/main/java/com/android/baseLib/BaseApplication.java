package com.android.baseLib;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;

import com.yanzhenjie.nohttp.NoHttp;

/**
 * @Description: 基础Application
 * @Author: xianggu
 * @CreateDate: 2019/1/15 11:25 AM
 */
public class BaseApplication extends Application {

    private static Context context;
    private static String packageName;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        packageName = getPackageName();

        NoHttp.initialize(this);
        //设置app使用手机默认尺寸，不受用户在手机设置的改变而变化
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.scaledDensity = displayMetrics.density;
    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }

    public static Context getContext() {
        return context;
    }

    public static String getPackage() {
        return packageName;
    }
}
