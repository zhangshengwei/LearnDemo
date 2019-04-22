package com.manggeek.android.geek.dialog;


import android.os.Handler;
import android.view.KeyEvent;

import com.manggeek.android.geek.GeekActivity;
import com.manggeek.android.geek.GeekDialog;
import com.manggeek.android.geek.R;
import com.manggeek.android.geek.utils.PrintUtil;


/**
 * 等待弹框
 *
 * @author wanglei 2014年12月14日 下午6:55:31
 */
public class WaitDialog extends GeekDialog {


    public WaitDialog(GeekActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_wait);
    }


    /**
     * 显示弹框
     */
    public static WaitDialog show(GeekActivity activity) {
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
