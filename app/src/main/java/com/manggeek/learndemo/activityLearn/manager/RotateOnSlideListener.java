package com.manggeek.learndemo.activityLearn.manager;

import android.support.v7.widget.RecyclerView;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/16 11:50 AM
 */
public interface RotateOnSlideListener <T> {

    void onSliding(RecyclerView.ViewHolder viewHolder, float ratio, int direction);

    void onSlided(RecyclerView.ViewHolder viewHolder, T t, int direction);

    void onClear();

}