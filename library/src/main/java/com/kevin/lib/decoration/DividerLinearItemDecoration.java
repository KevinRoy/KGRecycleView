package com.kevin.lib.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.kevin.lib.R;

/**
 * recycleView的Linear的ItemDecoration
 * Created by kevin on 15/9/18.
 */
public class DividerLinearItemDecoration extends BaseDividerItemDecoration {

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Context mContext;

    private int mOrientation;

    public DividerLinearItemDecoration(Context context) {
        setOrientation(VERTICAL_LIST);
        mContext = context;
    }

    public DividerLinearItemDecoration(Context context, int orientation) {
        setOrientation(orientation);
        mContext = context;
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft() + mLeftMargin < 0 ? 0 : parent.getPaddingLeft() + mLeftMargin;
        int right = parent.getWidth() - parent.getPaddingRight() - mRightMargin;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDividerSize;

            if (mDividerSize > 0 && mDividerColor != 0) {
                mPaint.setColor(mDividerColor);
                c.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop() + mTopMargin;
        int bottom = parent.getHeight() - parent.getPaddingBottom() - mButtomMargin;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int right = left + mDividerSize;

            if (mDividerSize > 0 && mDividerColor != 0) {
                mPaint.setColor(mDividerColor);
                c.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int postion = parent.getChildAdapterPosition(view);
        int size = state.getItemCount();

        if (mOrientation == VERTICAL_LIST) {
            if (postion == size - 1) {
                outRect.set(0, 0, 0, 0);
            } else {
                outRect.set(0, 0, 0, 0 + mDividerSize);
            }
        } else {
            if (postion == size - 1) {
                outRect.set(0, 0, 0, 0);
            } else {
                outRect.set(0, 0, 0 + mDividerSize, 0);
            }
        }
    }
}
