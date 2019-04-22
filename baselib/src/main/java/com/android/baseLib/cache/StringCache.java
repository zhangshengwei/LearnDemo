package com.android.baseLib.cache;

import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * @Description: 字符串类型缓存
 * @Author: xianggu
 * @CreateDate: 2019/1/15 2:36 PM
 */
public class StringCache extends BaseCache{


    /**
     * 插入本地缓存
     * @param key
     * @param value
     * @return
     */
    public static boolean put(String key,String value){
        return cache().edit().putString(key,value).commit();
    }

    /**
     * 获取缓存
     */
    public static String get(String key, String defValue) {
        return cache().getString(key, defValue);
    }

    /**
     * 获取缓存
     */
    public static String get(String key) {
        return get(key, "");
    }

    /**
     * 判断缓存是否存在
     *
     * @return true is null
     */
    public static boolean isValue(String key) {
        return TextUtils.isEmpty(get(key));

    }

    /**
     * 删除缓存
     *
     * @return true is success
     */
    public static boolean remove(String key) {
        if (!isValue(key)) {
            cache().edit().remove(key).commit();
            return true;
        }
        return false;
    }

}
