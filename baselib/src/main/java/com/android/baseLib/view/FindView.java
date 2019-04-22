package com.android.baseLib.view;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * @Description:  通过注解生成View
 * @Author: xianggu
 * @CreateDate: 2019/1/15 11:00 AM
 */
public class FindView {

    public static void init(Activity activity){
        init(activity,activity.getWindow().getDecorView());
    }


    public static void init(Object injectedSource, View sourceView) {
        Field[] fields = injectedSource.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.get(injectedSource) != null)
                        continue;
                    FindViewId viewInject = field.getAnnotation(FindViewId.class);
                    if (viewInject != null) {
                        int viewId = viewInject.id();
                        field.set(injectedSource, sourceView.findViewById(viewId));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
