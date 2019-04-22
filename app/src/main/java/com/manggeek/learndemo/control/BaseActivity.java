package com.manggeek.learndemo.control;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.manggeek.android.geek.GeekFragmentActivity;
//import com.manggeek.android.geek.utils.screen.DecorViewUtil;

/**
 * Created by zhangshengwei
 * Time: 2018/11/20 13:45
 */
public class BaseActivity extends GeekFragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DecorViewUtil.setWindowStatusBarColor(mActivity, R.color.colorPrimary);
//        MobclickAgent.setScenarioType(mActivity, MobclickAgent.EScenarioType.E_UM_NORMAL);
//        MobclickAgent.setDebugMode(false);
//        MobclickAgent.openActivityDurationTrack(false);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();

//        MobclickAgent.onPause(mActivity);
    }
}
