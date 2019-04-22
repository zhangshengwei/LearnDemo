package com.android.baseLib;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.android.baseLib.manager.MyActivityManager;
import com.android.baseLib.view.FindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

/**
 * @Description: 基础activity
 * @Author: xianggu
 * @CreateDate: 2019/1/15 11:38 AM
 */
public class BaseActivity extends AppCompatActivity {

    public BaseActivity myActivity;
    public LayoutInflater mInflater;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyActivityManager.getActivity().add(this);
        myActivity = this;
        mInflater = LayoutInflater.from(this);
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        FindView.init(myActivity);          //注解工具初始化
    }


    @Override
    protected void onDestroy() {
        MyActivityManager.getActivity().remove(myActivity);
        if (Util.isOnMainThread()) {
            Glide.with(getApplicationContext()).pauseRequests();
        }
        super.onDestroy();
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}
