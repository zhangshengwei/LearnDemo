package com.android.baseLib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/15 1:44 PM
 */
public class BaseFragmentActivity extends BaseActivity {

    public FragmentManager mFManager;
    private Fragment flagFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFManager = getSupportFragmentManager();
    }


    /**
     * 添加Fragment
     * @param contentId
     * @param fragment
     * @param tag
     * @param isAddBackStack  是否添加退回栈
     * @return
     */
    public FragmentTransaction addFragment(int contentId, Fragment fragment, String tag, boolean isAddBackStack) {
        FragmentTransaction transaction = mFManager.beginTransaction();
        transaction.add(contentId,fragment,tag);
        if (isAddBackStack){
            transaction.addToBackStack(tag);
        }
        return transaction;
    }



    protected void setDefaultFragment(Fragment fm, int layoutId) {
        FragmentTransaction mFragmentTrans = mFManager.beginTransaction();
        mFragmentTrans.add(layoutId, fm).commitAllowingStateLoss();
        flagFragment = fm;
    }

    protected void switchFragment(Fragment to, int layoutId) {
        if (flagFragment != to) {
            FragmentTransaction transaction = mFManager.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(flagFragment).add(layoutId, to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(flagFragment).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
            flagFragment = to;
        }
    }
}
