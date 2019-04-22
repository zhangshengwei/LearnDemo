package com.manggeek.android.geek.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author wanglei 2015年8月1日 上午7:03:28
 */
public class TimeUtil {

    /**
     * yyyy-MM-dd HH:mm:ss
    */
    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static String DEFAULT_HOUR_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    /**
     * dd/MM/yyyy
     */
    public static final String DEFAULT_HOUR_MINUTE_FORMAT_TWO = "yyyy/MM/dd HH:mm";
    /**
     * MM月dd日 HH:mm
     */
    public static String HOUR_MINUTE_FORMAT = "MM月dd日  HH:mm";
    /**
     * HH:mm
     */
    public static String HOUR = "HH:mm";
    /**
     * yyyy-MM-dd
     */
    public static String DEFAULT_DAY_FORMAT = "yyyy-MM-dd";
    /**
     * yyyyMMddHHmmss
     */
    public static String DEFAULT_DATE_NO_SEPRATOR_FORMAT = "yyyyMMddHHmmss";
    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_DAY_NO_SEPRATOR_FORMAT = "yyyyMMdd";
    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_DAY_NO_SEPRATOR = "yyyy.MM.dd";
    /**
     * dd/MM/yyyy
     */
    public static final String DEFAULT_SLASH_FORMAT = "dd/MM/yyyy";
    /**
     * dd/MM/yyyy
     */
    public static final String DEFAULT_FORMAT = "yyyy/MM/dd";



    /**
     * 指定日期格式，转化时间字符串为Date对象
     *
     * @param pattern
     * @param dateString
     * @return
     */
    public static Date parseDate(String pattern, String dateString) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(dateString);
        } catch (Exception e) {
            return new Date();
        }
    }

    /**
     * 指定日期格式，转化时间字符串为Date对象
     *
     * @return
     */
    public static Date parseDate(String dateString) {
        return parseDate(DEFAULT_DATE_FORMAT, dateString);
    }

    /**
     * 指定日期格式，转化Date对象为时间字符串
     *
     * @param pattern
     * @param date
     * @return
     */
    public static String parseString(String pattern, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 指定日期格式，转化Date对象为时间字符串  yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String parseString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * 指定日期格式，转化Date对象为时间字符串  yyyy-MM-dd HH:mm:ss
     * @param date
     * @param DateType
     * @return
     */
    public static String parseString(Date date,String DateType) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateType);
        return sdf.format(date);
    }

    /**
     * 时间格式转换
     *
     * @return
     */
    public static String parseString(String dateStr) {
        Date date = parseDate(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
        return sdf.format(date);
    }

    /**
     * Date转化为时间戳
     *
     * @return
     */
    public static Long dayToLong(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * Date转化为时间戳
     *
     * @return
     */
    public static Long dateToLong(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /** 时间戳转换成字符窜 */
    public static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(HOUR_MINUTE_FORMAT);
        return sf.format(d);
    }

    /* 时间戳转换成字符窜 */
    public static String getDateToStringss(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sf.format(d);
    }


    /**
     * 时间戳转换成字符窜
     *
     * @param time
     * @param pattern
     * @return
     */
    public static String getDateToString(long time, String pattern) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(d);
    }


    /** 时间戳转换成字符窜 */
    public static String getDateToStringOrder(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
        return sf.format(d);
    }

    /** 时间戳转换成字符窜 */
    public static String getDateToStringday(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_DAY_NO_SEPRATOR);
        return sf.format(d);
    }

    /** 时间戳转换成字符窜 */
    public static String getDateToStringHour(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(HOUR);
        return sf.format(d);
    }



    /**
     * 选择的时间 与当前时间对比年月日 对比   2018-09-03
     * 如果大于等于今天  返回true 否则返回false
     * @param startTime
     * @return
     */
    public static boolean compareFutrueTime(String startTime) {
        long time = System.currentTimeMillis();
        String newTimeStr = TimeUtil.getDateToString(time, TimeUtil.DEFAULT_DAY_FORMAT);
        PrintUtil.log("compareTime: startTime:"+startTime+"  newTime:"+newTimeStr);
        int startYear = Integer.parseInt(startTime.substring(0, 4));
        int newYear = Integer.parseInt(newTimeStr.substring(0, 4));
        PrintUtil.log("compareTime: startYear:" + startYear + " newYear:" + newYear);
        if (startYear > newYear) {
            return true;
        }else if (startYear < newYear){          //到岗时间年份小于  当前年份 直接false
            return false;
        }
        int startMonth = Integer.parseInt(startTime.substring(5, 7));
        int newMonth = Integer.parseInt(newTimeStr.substring(5, 7));
        PrintUtil.log("compareTime: startMonth:" + startMonth + " newMonth:" + newMonth);
        if (startMonth < newMonth) {       //到岗时间月份小于  当前月份 直接false
            return false;
        }else if (startMonth>newMonth){
            return  true;
        }
        int startDay = Integer.parseInt(startTime.substring(startTime.length() - 2, startTime.length()));
        int newDay = Integer.parseInt(newTimeStr.substring(newTimeStr.length() - 2, newTimeStr.length()));
        PrintUtil.log("compareTime: startDay:" + startDay + " newDay:" + newDay);
        if (startDay < newDay) {            //到岗时间日期小于  当前日期 直接false
            return false;
        }
        return true;
    }

    /**
     * 选择的时间 与当前时间对比年月日 对比   2018-09-03
     *  如果小于等于今天  返回true 否则返回false
     * @param startTime
     * @return
     */
    public static boolean compareBegoneTime(String startTime) {
        long time = System.currentTimeMillis();
        String newTimeStr = TimeUtil.getDateToString(time, TimeUtil.DEFAULT_DAY_FORMAT);
        PrintUtil.log("compareTime: startTime:"+startTime+"  newTime:"+newTimeStr);
        int startYear = Integer.parseInt(startTime.substring(0, 4));
        int newYear = Integer.parseInt(newTimeStr.substring(0, 4));
        PrintUtil.log("compareTime: startYear:" + startYear + " newYear:" + newYear);
        if (startYear < newYear) {
            return true;
        }else if (startYear > newYear){          //到岗时间年份大于  当前年份 直接false
            return false;
        }
        int startMonth = Integer.parseInt(startTime.substring(5, 7));
        int newMonth = Integer.parseInt(newTimeStr.substring(5, 7));
        PrintUtil.log("compareTime: startMonth:" + startMonth + " newMonth:" + newMonth);
        if (startMonth < newMonth){
            return  true;
        }else if (startMonth > newMonth) {       //到岗时间月份大于  当前月份 直接false
            return false;
        }
        int startDay = Integer.parseInt(startTime.substring(startTime.length() - 2, startTime.length()));
        int newDay = Integer.parseInt(newTimeStr.substring(newTimeStr.length() - 2, newTimeStr.length()));
        PrintUtil.log("compareTime: startDay:" + startDay + " newDay:" + newDay);
        if (startDay > newDay) {            //到岗时间日期大于  当前日期 直接false
            return false;
        }
        return true;
    }


}
