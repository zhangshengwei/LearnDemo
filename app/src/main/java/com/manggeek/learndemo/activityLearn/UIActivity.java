package com.manggeek.learndemo.activityLearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.activityLearn.UI.EchelonActivity;
import com.manggeek.learndemo.activityLearn.UI.LuckTurnTableActivity;
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
    private @FindViewById(id = R.id.recycler) TextView recyclerViewTv;
    private @FindViewById(id = R.id.echelon) TextView echelonTv;                //梯形队列卡片滑动
    private @FindViewById(id = R.id.card_Rotate) TextView cardRotateTv;         //卡片旋转移出
    private @FindViewById(id = R.id.card_slid_remove) TextView cardSlidRemoveTv;//卡片侧滑移出
    private @FindViewById(id = R.id.luck_turntable) TextView luckTurnTableTv;   //幸运大转盘


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        initView();

    }

    private void initView() {
        int a = 1;
        if (a == 1){
            a = 2;
            PrintUtil.log(">>>>>a:"+a);
        }else{
            PrintUtil.log(">>>>>b:");
        }
        refreshLoadMoreTv.setOnClickListener(click);
        recyclerViewTv.setOnClickListener(click);
        echelonTv.setOnClickListener(click);
        cardRotateTv.setOnClickListener(click);
        cardSlidRemoveTv.setOnClickListener(click);
        luckTurnTableTv.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == refreshLoadMoreTv){
                startActivity(new Intent(mActivity,SmartRefreshActivity.class));
            }else if (view == recyclerViewTv){
                startActivity(new Intent(mActivity,SmartRefreshActivity.class));
            }else if (view == echelonTv){
                startActivity(new Intent(mActivity,EchelonActivity.class));
            }else if (view == cardRotateTv){
                startActivity(new Intent(mActivity,RotateActivity.class));
            }else if (view == cardSlidRemoveTv){
                startActivity(new Intent(mActivity,SlidRemoveActivity.class));
            }else if (view == luckTurnTableTv){
                startActivity(new Intent(mActivity,LuckTurnTableActivity.class));
            }
        }
    };

}
