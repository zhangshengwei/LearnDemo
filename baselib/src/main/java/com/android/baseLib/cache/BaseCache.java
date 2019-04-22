package com.android.baseLib.cache;

import android.content.SharedPreferences;

import com.android.baseLib.BaseApplication;

/**
 * @Description: 基础缓存 基于SharedPreferences封装
 * @Author: xianggu
 * @CreateDate: 2019/1/15 2:33 PM
 */
public class BaseCache {

    private static SharedPreferences sharedPreferences;

    protected static SharedPreferences cache(){
        if (sharedPreferences == null){
            sharedPreferences = BaseApplication.getContext().
                    getSharedPreferences(BaseApplication.getPackage(), BaseApplication.MODE_PRIVATE);
        }

        return sharedPreferences;
    }
}
