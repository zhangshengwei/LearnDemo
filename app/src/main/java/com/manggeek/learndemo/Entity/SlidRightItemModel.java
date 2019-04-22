package com.manggeek.learndemo.Entity;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/16 3:25 PM
 */
public class SlidRightItemModel {

    private float mScaleXY;
    private float mLayoutPercent;
    private float mPositionOffset;
    private int mTop;
    private boolean mIsBottom;

    public SlidRightItemModel(int top, float scaleXY, float positonOffset, float percent) {
        this.mTop = top;
        this.mScaleXY = scaleXY;
        this.mPositionOffset = positonOffset;
        this.mLayoutPercent = percent;
    }

    public SlidRightItemModel setIsBottom() {
        mIsBottom = true;
        return this;
    }

    public float getScaleXY() {
        return mScaleXY;
    }

    public void setScaleXY(float mScaleXY) {
        this.mScaleXY = mScaleXY;
    }

    public float getLayoutPercent() {
        return mLayoutPercent;
    }

    public void setLayoutPercent(float mLayoutPercent) {
        this.mLayoutPercent = mLayoutPercent;
    }

    public float getPositionOffset() {
        return mPositionOffset;
    }

    public void setPositionOffset(float mPositionOffset) {
        this.mPositionOffset = mPositionOffset;
    }

    public int getTop() {
        return mTop;
    }

    public void setTop(int mTop) {
        this.mTop = mTop;
    }

}
