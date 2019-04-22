package com.android.baseLib.dialog;

import android.os.Handler;

import com.android.baseLib.BaseActivity;
import com.android.baseLib.BaseDialog;

import testdemo.com.baselib.R;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/15 2:47 PM
 */
public class WaitDialog extends BaseDialog {

    public WaitDialog(BaseActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_wait);
    }


    /**
     * 显示弹框
     */
    public static WaitDialog show(BaseActivity activity) {
        WaitDialog dialog = new WaitDialog(activity);
        dialog.show();
        return dialog;
    }


    public void show(long time) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, time);
        show();
    }
}
