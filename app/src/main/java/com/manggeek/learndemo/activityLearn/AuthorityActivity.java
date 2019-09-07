package com.manggeek.learndemo.activityLearn;

import android.Manifest;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Dialog.MessageDialog;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.Util.AuthorityUtil;
import com.manggeek.learndemo.control.BaseActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshengwei
 * Time: 2018/11/22 13:49
 * describe: 权限通知
 */
public class AuthorityActivity extends BaseActivity {

    private @FindViewById(id = R.id.notification) TextView notificationTv;          //通知栏权限开启
    private @FindViewById(id = R.id.auto_open_authority) TextView autoOpenAuthorityTv;    //自动开启权限通知
    private MessageDialog messageDialog;
    private boolean isNotification = false;

    private static final String[] permissions = { Manifest.permission.ACCESS_NOTIFICATION_POLICY
            , Manifest.permission.ACCESS_COARSE_LOCATION
            , Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE
            , Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_WIFI_STATE};

    private List<String> permissionList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority);
        initView();

    }

    private void initView() {
//        isNotification = AuthorityUtil.isNotificationEnabled(mActivity);           //判断通知栏权限是否开启
        messageDialog = new MessageDialog(mActivity);
        notificationTv.setOnClickListener(click);
        autoOpenAuthorityTv.setOnClickListener(click);

        for (String permission : permissions) {
            int checkSelfPermission = ContextCompat.checkSelfPermission(mActivity, permission);
            if (PackageManager.PERMISSION_GRANTED == checkSelfPermission) {
                continue;
            }
            permissionList.add(permission);
        }

    }


    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == notificationTv){
                OpenNotification();
            }else if (view == autoOpenAuthorityTv){
                if (!permissionList.isEmpty()) {
                    ActivityCompat.requestPermissions(mActivity, permissionList.toArray(new String[permissionList.size()]), 1);
                }
            }
        }
    };


    //开启通知栏权限
    private void OpenNotification() {
        if (isNotification){
            messageDialog.setMessageStr("通知栏权限已经开启");
            messageDialog.setConfirmListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    messageDialog.dismiss();
                }
            });
        }else {
            messageDialog.setMessageStr("前往开启通知栏权限");
            messageDialog.setConfirmListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent localIntent = new Intent();
                    localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    if (Build.VERSION.SDK_INT >= 9) {
                        localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        localIntent.setData(Uri.fromParts("package", getPackageName(), null));
                    } else if (Build.VERSION.SDK_INT <= 8) {
                        localIntent.setAction(Intent.ACTION_VIEW);
                        localIntent.setClassName("com.android.settings",
                                "com.android.settings.InstalledAppDetails");

                        localIntent.putExtra("com.android.settings.ApplicationPkgName",
                                mActivity.getPackageName());
                    }
                    startActivity(localIntent);
                }
            });
        }
        messageDialog.show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0;i<grantResults.length;i++){
            }
        }else{
        }
    }

}

