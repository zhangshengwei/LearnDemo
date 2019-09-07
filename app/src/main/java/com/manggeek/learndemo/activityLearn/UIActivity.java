package com.manggeek.learndemo.activityLearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.activityLearn.UI.EchelonActivity;
import com.manggeek.learndemo.activityLearn.UI.MoveViewActivity;
import com.manggeek.learndemo.activityLearn.UI.RotateActivity;
import com.manggeek.learndemo.activityLearn.UI.SlidRemoveActivity;
import com.manggeek.learndemo.activityLearn.UI.SmartRefreshActivity;
import com.manggeek.learndemo.control.BaseActivity;


/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/1 10:29 AM
 */
public class UIActivity extends BaseActivity {

    private @FindViewById(id = R.id.refresh_loadmore) TextView refreshLoadMoreTv;
    private @FindViewById(id = R.id.echelon) TextView echelonTv;                //梯形队列卡片滑动
    private @FindViewById(id = R.id.card_Rotate) TextView cardRotateTv;         //卡片旋转移出
    private @FindViewById(id = R.id.card_slid_remove) TextView cardSlidRemoveTv;//卡片侧滑移出
    private @FindViewById(id = R.id.luck_turntable) TextView luckTurnTableTv;   //幸运大转盘
    private @FindViewById(id = R.id.move_view) TextView moveViewTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        initView();
    }

    private void initView() {
        refreshLoadMoreTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity,SmartRefreshActivity.class));
        });
        echelonTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity,EchelonActivity.class));
        });

        cardRotateTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity,RotateActivity.class));
        });

        cardSlidRemoveTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity,SlidRemoveActivity.class));
        });

        luckTurnTableTv.setOnClickListener(v -> {
            PrintUtil.toastMakeText("暂时没有画");
        });

        moveViewTv.setOnClickListener(v -> {
            startActivity(new Intent(mActivity, MoveViewActivity.class));
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
