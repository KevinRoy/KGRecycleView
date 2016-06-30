package com.kevin.lib.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

/**
 * divide
 * Created by kevin on 15/9/21.
 */
public class BaseDividerItemDecoration extends RecyclerView.ItemDecoration {

    protected static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    protected ColorDrawable mDivider;
    protected Drawable mDrawable;
    protected int mDividerSize;
    protected int mRightMargin = 0;
    protected int mLeftMargin = 0;
    protected int mTopMargin = 0;
    protected int mButtomMargin = 0;

    /**
     * init Divider
     *
     * @param context
     */
    protected void initDivider(Context context) {
//        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
//        mDrawable = typedArray.getDrawable(0);
//        typedArray.recycle();

        mDivider = new ColorDrawable(0xffffffff);
    }

    /**
     * set divider size
     *vvvvvvvv
     * @param size
     */
    public void setDividerSize(int size) {
        mDividerSize = size;
    }

    public void setDrawbale(Drawable drawable) {
        mDivider = (ColorDrawable) drawable;
    }

    public void setDividerColor(int color) {
        mDivider.setColor(color);
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
