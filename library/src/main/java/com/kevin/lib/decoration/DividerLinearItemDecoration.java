package com.kevin.lib.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * recycleView的Linear的ItemDecoration
 * Created by kevin on 15/9/18.
 */
public class DividerLinearItemDecoration extends BaseDividerItemDecoration {

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private int mOrientation;

    public DividerLinearItemDecoration(Context context) {
        initDivider(context);
        setOrientation(VERTICAL_LIST);
    }

    public DividerLinearItemDecoration(Context context, int orientation) {
        initDivider(context);
        setOrientation(orientation);
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
            int bottom = top + mDivider.getIntrinsicHeight() + mDividerSize;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
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
            int right = left + mDivider.getIntrinsicHeight() + mDividerSize;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int postion = parent.getChildAdapterPosition(view);
        int size = state.getItemCount();

        if (mOrientation == VERTICAL_LIST) {
            if (postion == size - 1) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight() + mDividerSize);
            }
        } else {
            if (postion == size - 1) {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            } else {
                outRect.set(0, 0, mDivider.getIntrinsicWidth() + mDividerSize, 0);
            }
        }
    }
}
