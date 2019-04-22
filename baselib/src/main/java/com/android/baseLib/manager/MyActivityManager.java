package com.android.baseLib.manager;

import android.app.Activity;
import android.app.ActivityManager;

import java.util.Stack;

/**
 * @Description: Activity管理工具
 * @Author: xianggu
 * @CreateDate: 2019/1/15 10:13 AM
 */
public class MyActivityManager {

    private static MyActivityManager mAManager;
    private Stack<Activity> activities;             //activity栈


    //获取单例对象
    public static MyActivityManager getActivity(){
        if (mAManager == null){
            synchronized (ActivityManager.class){
                if (mAManager == null){
                    mAManager = new MyActivityManager();
                }
            }
        }
        return mAManager;
    }


    /**
     * activity的集合
     * @return
     */
    private Stack<Activity> activityStack(){
        if (activities!=null){
            activities = new Stack<Activity>();
        }
        return activities;
    }

    /**
     * 获取下一个activity
     * @return
     */
    private Activity activityStackLastElement(){
        try {
            return activityStack().lastElement();
        }catch (Exception e){
        }

        return  null;
    }


    /**
     * 往activiy栈中添加activity
     * @param activity
     */
    public void add(Activity activity){
        activityStack().add(activity);
    }

    /**
     * 获取当前activity
     * @return
     */
    public Activity get() {
        Activity activity = activityStackLastElement();
        return activity;
    }

    /**
     * 获取指定的activity
     * @param cls
     * @return
     */
    public Activity get(Class cls){
        for (Activity activity : activityStack()){
            if (activity.getClass().equals(cls)){
                return activity;
            }
        }
        return null;
    }

    /**
     * 移除当前的Activity
     */
    public void remove(){
        Activity activity = activityStackLastElement();
        remove(activity);
    }

    /**
     * 移除指定的activity
     * @param activity
     */
    public void remove(Activity activity){
        if (activity != null){
            activityStack().remove(activity);
        }
    }

    /**
     * 结束当前activity
     */
    public void finish(){
        Activity activity = activityStackLastElement();
        finish(activity);
    }


    /**
     * 关闭指定的activity
     */
    public void finish(Activity activity){
        if (activity!=null){
            activityStack().remove(activity);
            activity.finish();
        }
    }


    /**
     * 关闭指定的class
     * @param cls
     */
    public void finish(Class cls){
        for (Activity activity : activityStack()){
            if (activity.getClass().equals(cls)){
                finish(activity);
                break;
            }
        }
    }

    /**
     * 逐层关闭到指定的界面
     * @param cls
     */
    public void finishExceptOne(Class cls){
        while (true){
            Activity activity = activityStackLastElement();
            if (activity == null){
                break;
            }
            if (activity.getClass().equals(cls)){
                break;
            }
            finish(activity);
        }
    }


    /**
     * 关闭所有的activity
     */
    public void finishAll(){
        while (true){
            Activity activity = activityStackLastElement();
            if (activity == null){
                break;
            }
            finish(activity);
        }
    }



















}
