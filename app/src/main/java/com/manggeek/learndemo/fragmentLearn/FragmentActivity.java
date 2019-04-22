package com.manggeek.learndemo.fragmentLearn;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.manggeek.android.geek.manager.ActivityManager;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.control.BaseActivity;
import com.manggeek.learndemo.fragmentLearn.fragment.HomeFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.MineFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.SecondFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.ThirdFragment;

/**
 * Created by zhangshengwei
 * Time: 2018/11/21 9:36
 * describe: Fragment 模块测试
 */
public class FragmentActivity extends BaseActivity {
    private @FindViewById(id = R.id.option) RadioGroup optionRg;

    private HomeFragment homeFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initView();
    }

    private void initView() {
        homeFragment = new HomeFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        mineFragment = new MineFragment();
        setDefaultFragment(homeFragment, R.id.content);
        optionRg.setOnCheckedChangeListener(onCheckedChangeListener);
        RadioButton radioButton = (RadioButton) optionRg.getChildAt(0);
        radioButton.setChecked(true);
    }


    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (radioGroup.getChildAt(0).getId() == i) {                                //首页
                switchFragment(homeFragment, R.id.content);
            } else if (radioGroup.getChildAt(1).getId() == i) {                         //第二页
                switchFragment(secondFragment, R.id.content);
            } else if (radioGroup.getChildAt(2).getId() == i) {                        //第三页
                switchFragment(thirdFragment, R.id.content);
            }else if (radioGroup.getChildAt(3).getId() == i) {                         //个人中心
                switchFragment(mineFragment, R.id.content);
            }
        }
    };



    private boolean isExit = false;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (isExit) {
                ActivityManager.getActivity().finishAll();
            } else {
                isExit = true;
                PrintUtil.toastMakeText(mActivity, "再按一次,退出应用");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (homeFragment.isVisible()) {
            homeFragment.initData();
        }
        if (secondFragment.isVisible()) {
            secondFragment.initData();
        }
        if (thirdFragment.isVisible()) {
            thirdFragment.initData();
        }
        if (mineFragment.isVisible()) {
            mineFragment.initData();
        }

    }
}
