package com.manggeek.learndemo.activityLearn;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.control.BaseActivity;

import testdemo.com.mobileauthlib.TestHelper;

/**
 * @Description: 自动登录
 * @Author: xianggu
 * @CreateDate: 2019/1/17 9:54 AM
 */
public class AutoLoginActivity extends BaseActivity {


    private @FindViewById(id = R.id.auto_login) TextView AutoLoginTv;

    //CMCC 一键登录 根据包名申请下来的appId和AppKey
    private String CMCC_APP_ID = "300011879422";
    private String CMCC_APP_KEY = "A95D1B4F30914586A2E6AFDF8BB02B19";
//    private TestHelper testHelper;
//    private AuthnHelper mAuthnHelper;                   //AuthnHelper是移动一键登录SDK的功能入口
//    private TokenListener mListener;                    //接收SDK返回的调用结果
    private static final int RESULT = 0x111;
    private static final int CMCC_SDK_REQUEST_LOGIN_AUTH_CODE = 3333;
    private static final int PERMISSIONS_REQUEST_READ_PHONE_STATE_DISPLAY_LOGIN = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_login);
        initView();
    }

    private void initView() {
        final TestHelper testHelper = TestHelper.getTestHelper();
        AutoLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},
                                PERMISSIONS_REQUEST_READ_PHONE_STATE_DISPLAY_LOGIN);
                    } else {

                        testHelper.init(mActivity,CMCC_APP_ID,CMCC_APP_KEY,CMCC_SDK_REQUEST_LOGIN_AUTH_CODE);
//                        mAuthnHelper.loginAuth(CMCC_APP_ID, CMCC_APP_KEY, mListener, CMCC_SDK_REQUEST_LOGIN_AUTH_CODE);
                    }
                } else {
                    testHelper.init(mActivity,CMCC_APP_ID,CMCC_APP_KEY,CMCC_SDK_REQUEST_LOGIN_AUTH_CODE);
//                    mAuthnHelper.loginAuth(CMCC_APP_ID, CMCC_APP_KEY, mListener, CMCC_SDK_REQUEST_LOGIN_AUTH_CODE);
                }
            }
        });
    }


}
