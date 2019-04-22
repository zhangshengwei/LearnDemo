package com.manggeek.learndemo.Util;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangshengwei
 * Time: 2018/12/3 10:46
 * describe: 数组字符串转换
 */
public class ArrayUtil {


    /**
     * list转string   将字符串的集合转成用逗号（,）隔开的字符串
     *
     * @param list
     * @return         添加“,”
     */
    public static String listToString(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        for (String string : list) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    /**
     * 将字符串的集合转成用分号隔开的字符串
     *
     * @param list
     * @return
     */
    public static String listToStringBySemicolon(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        for (String string : list) {
            if (flag) {
                result.append(";");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    /**
     * 将String字符串根据，进行切割
     * @param str
     * @return
     */
    public static List<String> strToList(String str) {
        List<String> list = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        String[] strings = str.split(",");
        Collections.addAll(list, strings);
        return list;
    }

    public static List<String> strToListBySemicolon(String str) {
        List<String> list = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        String[] strings = str.split(";");
        Collections.addAll(list, strings);
        return list;
    }

    /**
     * 取出字符串最前面的 数字
     *
     * @param content
     * @return
     */
    public static String getNumStr(String content) {
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(content);

        while (m.find()) {
            if (!"".equals(m.group()))
                return m.group();
        }
        return "";
    }


    public static List<String> getDatas(String[] strings) {
        List<String> list = new java.util.ArrayList<>();
        if (strings == null || strings.length < 1) {
            return list;
        }
        Collections.addAll(list, strings);
        return list;
    }


    public static List<Integer> getDatas(int[] datas) {
        List<Integer> list = new java.util.ArrayList<>();
        if (datas == null || datas.length < 1) {
            return list;
        }
        for (int i = 0; i < datas.length; i++) {
            list.add(datas[i]);
        }
        return list;
    }

    public static List<String> getDatas(String data) {
        List<String> list = new java.util.ArrayList<>();
        if (TextUtils.isEmpty(data)) {
            return list;
        }
        String[] strings = data.split("\\|");
        Collections.addAll(list, strings);
        return list;
    }
}
