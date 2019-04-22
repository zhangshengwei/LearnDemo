package com.android.baseLib.cache;

/**
 * @Description: 保存布尔类型
 * @Author: xianggu
 * @CreateDate: 2019/1/15 2:40 PM
 */
public class BooleanCache extends BaseCache {

    public static boolean put(String key, boolean value) {
        return cache().edit().putBoolean(key, value).commit();
    }

    /**
     * 获取缓存
     */
    public static boolean get(String key, boolean defValue) {
        return cache().getBoolean(key, defValue);
    }

    /**
     * 获取缓存
     *
     * @param key
     * @param defValue
     * @return
     */
    public static boolean is(String key, boolean defValue) {
        return cache().getBoolean(key, defValue);
    }
}
