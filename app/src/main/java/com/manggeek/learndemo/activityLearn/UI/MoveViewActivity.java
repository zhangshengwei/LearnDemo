package com.manggeek.learndemo.activityLearn.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.control.BaseActivity;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/19 7:38 PM
 */
public class MoveViewActivity extends BaseActivity {

    private @FindViewById(id = R.id.move_item) View moveItem;
    private @FindViewById(id = R.id.topTv) TextView topTv;
    private @FindViewById(id = R.id.centerTv) TextView centerTv;
    private @FindViewById(id = R.id.bottomTv) TextView bottomTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_turn_table);

        topTv.setOnClickListener(v -> {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            moveItem.setLayoutParams(layoutParams);
        });

        centerTv.setOnClickListener(v -> {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            moveItem.setLayoutParams(layoutParams);
        });


        bottomTv.setOnClickListener(v -> {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            moveItem.setLayoutParams(layoutParams);
        });

    }
}
