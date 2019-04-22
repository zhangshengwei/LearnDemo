package com.manggeek.learndemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.activityLearn.AuthorityActivity;
import com.manggeek.learndemo.activityLearn.AutoLoginActivity;
import com.manggeek.learndemo.activityLearn.DataUtilActivity;
import com.manggeek.learndemo.activityLearn.HttpTestActivity;
import com.manggeek.learndemo.activityLearn.MobileInfoActivity;
import com.manggeek.learndemo.activityLearn.ScanPicActivity;
import com.manggeek.learndemo.activityLearn.UIActivity;
import com.manggeek.learndemo.control.BaseActivity;
import com.manggeek.learndemo.fragmentLearn.FragmentActivity;
import com.manggeek.learndemo.otherLearn.UtilsActivity;

/**
 * Created by zhangshengwei
 * Time: 2018/11/20 14:10
 */
public class SelectActivity extends BaseActivity {

//    private @FindViewById(id = R.id.goto_activity) TextView gotoActivityTv;
    private @FindViewById(id = R.id.goto_fragment) TextView gotoFragmentTv;
    private @FindViewById(id = R.id.goto_service) TextView gotoServiceTv;
    private @FindViewById(id = R.id.goto_util) TextView gotoUtilTv;       //字符串解析
    private @FindViewById(id = R.id.data_util) TextView dataUtilTv;       //数据解析
    private @FindViewById(id = R.id.authority) TextView authorityTv;      //权限通知测试
    private @FindViewById(id = R.id.scan_pic) TextView scanPicTv;         //二维码生成识别
    private @FindViewById(id = R.id.login_auto) TextView autoLoginTv;     //一键登录
    private @FindViewById(id = R.id.python_http) TextView pythonHttpTv;   //Python接口请求
    private @FindViewById(id = R.id.refresh_rl) TextView refreshTv;       //UI控件模块测试
    private @FindViewById(id = R.id.mobile_info) TextView mobileInfoTv;   //设备相关信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        initView();
    }

    private void initView() {
        PrintUtil.log("copy demo git pull test");
//        gotoActivityTv.setOnClickListener(click);
        gotoFragmentTv.setOnClickListener(click);
        gotoServiceTv.setOnClickListener(click);
        gotoUtilTv.setOnClickListener(click);
        dataUtilTv.setOnClickListener(click);
        authorityTv.setOnClickListener(click);
        scanPicTv.setOnClickListener(click);
        autoLoginTv.setOnClickListener(click);
        pythonHttpTv.setOnClickListener(click);
        refreshTv.setOnClickListener(click);
        mobileInfoTv.setOnClickListener(click);
    }


    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            if (view == gotoActivityTv){
//                startActivity(new Intent(mActivity,MainActivity.class));
//            }else
            if (view == gotoFragmentTv){
                startActivity(new Intent(mActivity,FragmentActivity.class));
            }else if (view == gotoServiceTv){
                PrintUtil.toastMakeText("功能未开发");
            }else if (view == gotoUtilTv){
                startActivity(new Intent(mActivity, UtilsActivity.class));
            }else if (view == dataUtilTv){
                startActivity(new Intent(mActivity, DataUtilActivity.class));
            }else if (view == authorityTv) {
                startActivity(new Intent(mActivity, AuthorityActivity.class));
            }else if (view == scanPicTv){
                startActivity(new Intent(mActivity, ScanPicActivity.class));
            }else if (view == autoLoginTv){
                startActivity(new Intent(mActivity, AutoLoginActivity.class));
            }else if (view == pythonHttpTv){
                startActivity(new Intent(mActivity, HttpTestActivity.class));
            }else if (view == refreshTv){
                startActivity(new Intent(mActivity, UIActivity.class));
            }else if (view == mobileInfoTv){
                startActivity(new Intent(mActivity, MobileInfoActivity.class));
            }
        }
    };
}
