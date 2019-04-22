package com.manggeek.learndemo.Util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

import com.manggeek.android.geek.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/19 9:53 AM
 */
public class ApplicationUtils {
    private static PackageManager pm;
    static Context context;

    private ApplicationUtils(Context context) {

        ApplicationUtils.context = context;
        pm = context.getPackageManager();
    }

    public static ApplicationUtils newInstance(Context context) {

        return new ApplicationUtils(context);
    }
    /**
     * 看这里，获取并按名称排序
     **/
    public List<Application> loadAllApplication() {
        List<Application> apps = new ArrayList<Application>();
        Intent main = new Intent(Intent.ACTION_MAIN, null);
        main.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolves = pm.queryIntentActivities(main, 0);
        Collections.sort(resolves, new ResolveInfo.DisplayNameComparator(pm));
        for (int i = 0; i < resolves.size(); i++) {
            Application app = new Application();
            ResolveInfo info = resolves.get(i);
            String label = info.loadLabel(pm).toString().trim();
            Drawable icon = info.activityInfo.loadIcon(pm);
            String pkgName = info.activityInfo.applicationInfo.packageName;
            String activityName = info.activityInfo.name;
            Intent intent = new Intent();
            intent.setClassName(pkgName, activityName);
//            app.setLabel(label);
//            app.setIcon(icon);
//            app.setClassName(activityName);
//            app.setPackageName(pkgName);
//            app.setIntent(intent);
//            app.setChecked(false);
            apps.add(app);
            PrintUtil.log("-----><><>/" + pkgName + "/" + activityName);
        }
        return apps;
    }
    /**
     *Application 跳转
     **/
    public void startApp(Application app) {
        String pkgName = app.getPackageName();
        Intent intent = pm.getLaunchIntentForPackage(pkgName);
        if (intent != null) {
            context.startActivity(intent);
        }
    }
    /**
     *包名直接跳转
     **/
    public void startApp(String pkgName) {
        Intent intent = pm.getLaunchIntentForPackage(pkgName);
        if (intent != null) {
            context.startActivity(intent);
        }
    }

}
