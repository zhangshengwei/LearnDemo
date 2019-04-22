package com.manggeek.android.geek.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.manggeek.android.geek.R;
import com.manggeek.android.geek.manager.ActivityManager;
import com.manggeek.android.geek.utils.PrintUtil;


/**
 * back
 *
 * @author
 */
public class BackView extends LinearLayout {


    public BackView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    public BackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BackView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_back, this, true);
        findViewById(R.id.back).setOnClickListener(clickListener);
    }

    private OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isFastClick()) {
                // 进行点击事件后的逻辑操作
                ActivityManager.getActivity().finish();
            }else{
//                PrintUtil.toastMakeText("请勿重复连续点击");
            }
        }
    };

    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 500;
    private static long lastClickTime;
    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }

}
