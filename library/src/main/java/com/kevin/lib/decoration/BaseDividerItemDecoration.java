package com.kevin.lib.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

/**
 * divide
 * Created by kevin on 15/9/21.
 */
public class BaseDividerItemDecoration extends RecyclerView.ItemDecoration {

    protected int mDividerSize;
    protected int mDividerColor;
    protected int mRightMargin = 0;
    protected int mLeftMargin = 0;
    protected int mTopMargin = 0;
    protected int mButtomMargin = 0;
    protected Paint mPaint;

    /**
     * set divider size
     *
     * @param size
     */
    public void setDividerSize(int size) {
        mDividerSize = size;
    }

    public void setDividerColor(int color) {
        mDividerColor = color;

        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
        }
    }

    public void setRightMargin(int rightMargin) {
        mRightMargin = rightMargin;
    }

    public void setLeftMargin(int leftMargin) {
        mLeftMargin = leftMargin;
    }

    public void setTopMargin(int topMargin) {
        mTopMargin = topMargin;
    }

    public void setButtomMargin(int buttomMargin) {
        mButtomMargin = buttomMargin;
    }
}
