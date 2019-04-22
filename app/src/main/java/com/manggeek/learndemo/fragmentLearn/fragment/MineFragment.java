package com.manggeek.learndemo.fragmentLearn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manggeek.android.geek.GeekFragment;
import com.manggeek.learndemo.R;

/**
 * Created by zhangshengwei
 * Time: 2018/11/22 14:57
 * describe:
 */
public class MineFragment extends GeekFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_mine, container, false);
        initData();
        return view;
    }

    public void initData() {
    }
}
