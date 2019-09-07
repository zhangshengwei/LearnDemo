package com.manggeek.learndemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.TextView;

import com.manggeek.android.geek.manager.ActivityManager;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.View.TestView;
import com.manggeek.learndemo.activityLearn.AuthorityActivity;
import com.manggeek.learndemo.activityLearn.AutoLoginActivity;
import com.manggeek.learndemo.activityLearn.DataUtilActivity;
import com.manggeek.learndemo.activityLearn.HttpTestActivity;
import com.manggeek.learndemo.activityLearn.MainActivity;
import com.manggeek.learndemo.activityLearn.ScanPicActivity;
import com.manggeek.learndemo.activityLearn.UIActivity;
import com.manggeek.learndemo.control.BaseActivity;
import com.manggeek.learndemo.fragmentLearn.FragmentActivity;
import com.manggeek.learndemo.otherLearn.UtilsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshengwei
 * Time: 2018/11/20 14:10
 */
public class SelectActivity extends BaseActivity {

    private @FindViewById(id = R.id.testTv) TextView testTv;
    private @FindViewById(id = R.id.goto_activity) TextView gotoActivityTv;
    private @FindViewById(id = R.id.goto_fragment) TextView gotoFragmentTv;
    private @FindViewById(id = R.id.goto_util) TextView gotoUtilTv;       //字符串解析
    private @FindViewById(id = R.id.data_util) TextView dataUtilTv;       //数据解析
    private @FindViewById(id = R.id.authority) TextView authorityTv;      //权限通知测试
    private @FindViewById(id = R.id.scan_pic) TextView scanPicTv;         //二维码生成识别
    private @FindViewById(id = R.id.login_auto) TextView autoLoginTv;     //一键登录
    private @FindViewById(id = R.id.python_http) TextView pythonHttpTv;   //Python接口请求
    private @FindViewById(id = R.id.refresh_rl) TextView refreshTv;       //UI控件模块测试

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        initView();
    }

    private void initView() {

        gotoActivityTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity,MainActivity.class));
        });
        gotoFragmentTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity,FragmentActivity.class));
        });

        gotoUtilTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, UtilsActivity.class));
        });
        dataUtilTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, DataUtilActivity.class));
        });
        authorityTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, AuthorityActivity.class));
        });
        scanPicTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, ScanPicActivity.class));
        });
        autoLoginTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, AutoLoginActivity.class));
        });
        pythonHttpTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, HttpTestActivity.class));
        });
        refreshTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, UIActivity.class));
        });

        testTv.setOnClickListener(v -> {
//            testMethod2();
//            testMethod3();
            testMethod4();
        });
    }

    /**
     * viewGroup
     */
    private void testMethod4() {
    }

    private void testMethod3() {
        TestView testView = new TestView(testTv);
        PrintUtil.log("---->>" + testTv.toString());
    }

    private void testMethod2() {
        List<String> testList = new ArrayList<>();
        testList.add("测试1");
        testList.add("测试2");
        testList.add("测试3");
        testList.add("测试4");
        testList.add("测试5");
        testList.remove(3);
        PrintUtil.log("--->>","size:"+testList.size());
        for (int i = 0; i < testList.size(); i++) {
            PrintUtil.log("--->>","content:"+testList.get(i));
        }
    }



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


}
