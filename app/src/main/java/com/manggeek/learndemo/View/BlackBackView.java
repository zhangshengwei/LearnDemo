package com.manggeek.learndemo.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.manggeek.android.geek.manager.ActivityManager;

/**
 * Created by zhangshengwei
 * Time: 2018/11/20 14:22
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
        LayoutInflater.from(context).inflate(com.manggeek.learndemo.R.layout.view_black_back, this, true);
        findViewById(com.manggeek.learndemo.R.id.back).setOnClickListener(clickListener);
    }

    private OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            ActivityManager.getActivity().finish();
        }
    };

}

