package testdemo.com.newsapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.manggeek.android.geek.GeekFragmentActivity;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/30 3:18 PM
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
