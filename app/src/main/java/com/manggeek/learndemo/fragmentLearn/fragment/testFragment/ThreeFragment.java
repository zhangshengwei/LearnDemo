package com.manggeek.learndemo.fragmentLearn.fragment.testFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manggeek.android.geek.GeekFragment;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;

/**
 * Created by zhangshengwei
 * Time: 2018/11/22 15:20
 * describe:
 */
public class ThreeFragment extends GeekFragment {

    private @FindViewById(id = R.id.content)
    TextView contentTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_number_content, container, false);
//        initData();
        contentTv.setText("这是第 3 个Fragment");
        return view;
    }
}
