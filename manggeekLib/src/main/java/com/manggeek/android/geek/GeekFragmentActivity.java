package com.manggeek.android.geek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Fragment基础Activity
 * 提供FragmentActivity快捷功能
 * Created by wanglei on 16/3/25.
 */
public class GeekFragmentActivity extends GeekActivity {

    public FragmentManager mFManager;
    private Fragment tempFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFManager = getSupportFragmentManager();
    }

    /**
     * 添加Fragment
     *
     * @param isAddBackStack 是否添加回退栈
     */
    public FragmentTransaction addFragment(int contentId, Fragment fragment, String tag, boolean isAddBackStack) {
        FragmentTransaction transaction = mFManager.beginTransaction();
        transaction.add(contentId, fragment, tag);
        if (isAddBackStack) {
            transaction.addToBackStack(tag);
        }
        return transaction;
    }

    /**
     * 覆盖Fragment
     *
     * @param isAddBackStack 是否添加回退栈
     */
    public FragmentTransaction replaceFragment(int contentId, Fragment fragment, String tag, boolean isAddBackStack) {
        FragmentTransaction transaction = mFManager.beginTransaction();
        transaction.replace(contentId, fragment, tag);
        if (isAddBackStack) {
            transaction.addToBackStack(tag);
        }
        return transaction;
    }

    protected void setDefaultFragment(Fragment fm, int layoutId) {
        FragmentTransaction mFragmentTrans = mFManager.beginTransaction();
        mFragmentTrans.add(layoutId, fm).commitAllowingStateLoss();
        tempFragment = fm;
    }

    protected void switchFragment(Fragment to, int layoutId) {
        if (tempFragment != to) {
            FragmentTransaction transaction = mFManager.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(tempFragment).add(layoutId, to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(tempFragment).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
            tempFragment = to;
        }
    }
}
