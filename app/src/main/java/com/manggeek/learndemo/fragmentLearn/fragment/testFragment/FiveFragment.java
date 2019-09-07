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
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-06 17:40
 */
public class FiveFragment extends GeekFragment {

    private @FindViewById(id = R.id.content)
    TextView contentTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_number_content, container, false);
        contentTv.setText("是第二页  2  的Fragment");
        return view;
    }
}