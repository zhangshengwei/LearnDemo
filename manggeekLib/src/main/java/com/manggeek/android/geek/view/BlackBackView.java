package com.manggeek.android.geek.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.manggeek.android.geek.R;
import com.manggeek.android.geek.manager.ActivityManager;

/**
 * @Description: 返回按钮
 * @Author: xianggu
 * @CreateDate: 2019/2/12 4:14 PM
 */
public class BlackBackView extends LinearLayout {

    public BlackBackView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    public BlackBackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BlackBackView(Context context) {
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
            ActivityManager.getActivity().finish();

        }
    };

}
