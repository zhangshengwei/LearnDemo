package com.manggeek.android.geek;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.support.multidex.MultiDex;


import com.yanzhenjie.nohttp.NoHttp;


public class GeekApplication extends Application {

    private static Context context;
    private static String packageName;

    /**
     * 每次app开启会调用
     */
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

    @Override protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /**
     * 全局上下文对象
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 项目包名
     */
    public static String getPackage() {
        return packageName;
    }

    public static PackageInfo getPackageInfo() throws PackageManager.NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        PackageInfo info = manager.getPackageInfo(packageName, 0);
        return info;
    }
}
