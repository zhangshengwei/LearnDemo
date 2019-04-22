package com.manggeek.learndemo.activityLearn.manager;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/16 11:03 AM
 */
public class RotateLayoutManager extends RecyclerView.LayoutManager {

    private RecyclerView mRecyclerView;
    private ItemTouchHelper mItemTouchHelper;


    public RotateLayoutManager(RecyclerView mRecyclerView, ItemTouchHelper mItemTouchHelper) {
        this.mRecyclerView = mRecyclerView;
        this.mItemTouchHelper = mItemTouchHelper;
    }

    private <T> T checkIsNumm(T t){
        if (t == null){
            throw new NullPointerException();
        }
        return t;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }


    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        if (itemCount>3){       //3为默认显示数量
            for (int position = 3;position>=0;position--){
                final View view = recycler.getViewForPosition(position);
                addView(view);
                measureChildWithMargins(view,0,0);
                int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
                int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);
                layoutDecoratedWithMargins(view, widthSpace / 2, heightSpace / 5,
                        widthSpace / 2 + getDecoratedMeasuredWidth(view),
                        heightSpace / 5 + getDecoratedMeasuredHeight(view));

                if (position == 3) {
                    view.setScaleX(1 - (position - 1) * 0.1f);
                    view.setScaleY(1 - (position - 1) * 0.1f);
                    view.setTranslationY((position - 1) * view.getMeasuredHeight() / 14);
                } else if (position > 0) {
                    view.setScaleX(1 - position * 0.1f);
                    view.setScaleY(1 - position * 0.1f);
                    view.setTranslationY(position * view.getMeasuredHeight() / 14);
                } else {
                    view.setOnTouchListener(mOnTouchListener);
                }
            }
        }else{
            for (int position = itemCount - 1; position >= 0; position--) {
                final View view = recycler.getViewForPosition(position);
                addView(view);
                measureChildWithMargins(view, 0, 0);
                int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
                int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);
                layoutDecoratedWithMargins(view, widthSpace / 2, heightSpace / 5,
                        widthSpace / 2 + getDecoratedMeasuredWidth(view),
                        heightSpace / 5 + getDecoratedMeasuredHeight(view));

                if (position > 0) {
                    view.setScaleX(1 - position * 0.1f);
                    view.setScaleY(1 - position * 0.1f);
                    view.setTranslationY(position * view.getMeasuredHeight() / 14);
                } else {
                    view.setOnTouchListener(mOnTouchListener);
                }
            }

        }


    }





    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            RecyclerView.ViewHolder childViewHolder = mRecyclerView.getChildViewHolder(v);
            if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                mItemTouchHelper.startSwipe(childViewHolder);
            }
            return false;
        }
    };



}
