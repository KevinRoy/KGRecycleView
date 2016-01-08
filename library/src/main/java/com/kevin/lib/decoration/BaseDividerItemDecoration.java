package com.kevin.lib.decoration;

import android.content.Context;
import android.content.res.TypedArray;
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

    protected Drawable mDivider;

    protected void initDivider(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
    }
}
