package com.kevin.lib.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * recycleView的Grid的ItemDecoration
 * Created by kevin on 15/9/21.
 */
public class DividerGridItemDecoration extends BaseDividerItemDecoration {

//    public DividerGridItemDecoration(Context context) {
//        initDivider(context);
//    }
//
//    private int getSpanCount(RecyclerView parent) {
//        int spanCount = -1;
//        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//
//        if (layoutManager instanceof GridLayoutManager) {
//            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
//        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
//            spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
//        }
//        return spanCount;
//    }
//
//    /**
//     * 竖线
//     *
//     * @param canvas
//     * @param parent
//     */
//    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
//        int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View child = parent.getChildAt(i);
//            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
//
//            int top = child.getTop() - params.topMargin + mTopMargin;
//            int buttom = child.getBottom() + params.bottomMargin - mButtomMargin;
//            int left = child.getRight() + params.rightMargin;
//            int right = left + mDivider.getIntrinsicWidth() + mDividerSize;
//
//            mDivider.setBounds(left, top, right, buttom);
//            mDivider.draw(canvas);
//        }
//    }
//
//    /**
//     * 横线
//     *
//     * @param canvas
//     * @param parent
//     */
//    private void drawVertical(Canvas canvas, RecyclerView parent) {
//        int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View child = parent.getChildAt(i);
//            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
//
//            int top = child.getBottom() + params.bottomMargin;
//            int buttom = top + mDivider.getIntrinsicHeight() + mDividerSize;
//            int left = child.getLeft() - params.leftMargin + mLeftMargin;
//            int right = child.getRight() + params.rightMargin + mDivider.getIntrinsicWidth() - mRightMargin;
//
//            mDivider.setBounds(left, top, right, buttom);
//            mDivider.draw(canvas);
//        }
//    }
//
//    @Override
//    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        drawHorizontal(c, parent);
//        drawVertical(c, parent);
//    }
//
//    /**
//     * 是否绘制右边
//     *
//     * @param parent
//     * @param pos
//     * @param spanCount
//     * @param childCount
//     * @return
//     */
//    private boolean isLastColum(RecyclerView parent, int pos, int spanCount,
//                                int childCount) {
//        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//        if (layoutManager instanceof GridLayoutManager) {
//            // 如果是最后一列，则不需要绘制右边
//            if ((pos + 1) % spanCount == 0) {
//                return true;
//            }
//        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
//            int orientation = ((StaggeredGridLayoutManager) layoutManager)
//                    .getOrientation();
//            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
//                // 如果是最后一列，则不需要绘制右边
//                if ((pos + 1) % spanCount == 0) {
//                    return true;
//                }
//            } else {
//                childCount = childCount - childCount % spanCount;
//                // 如果是最后一列，则不需要绘制右边
//                if (pos >= childCount)
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 是否绘制底部
//     *
//     * @param parent
//     * @param pos
//     * @param spanCount
//     * @param childCount
//     * @return
//     */
//    private boolean isLastRaw(RecyclerView parent, int pos, int spanCount,
//                              int childCount) {
//        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//        if (layoutManager instanceof GridLayoutManager) {
//            childCount = childCount - childCount % spanCount;
//            // 如果是最后一行，则不需要绘制底部
//            if (pos >= childCount)
//                return true;
//        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
//            int orientation = ((StaggeredGridLayoutManager) layoutManager)
//                    .getOrientation();
//            // StaggeredGridLayoutManager 且纵向滚动
//            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
//                childCount = childCount - childCount % spanCount;
//                // 如果是最后一行，则不需要绘制底部
//                if (pos >= childCount)
//                    return true;
//            } else {
//                // 如果是最后一行，则不需要绘制底部
//                if ((pos + 1) % spanCount == 0) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
//    }
//
//    @Override
//    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
//        int spanCount = getSpanCount(parent);
//        int childCount = parent.getAdapter().getItemCount();
//        // 如果是最后一行，则不需要绘制底部
//        if (isLastRaw(parent, itemPosition, spanCount, childCount)) {
//            outRect.set(0, 0, mDivider.getIntrinsicWidth() + mDividerSize, 0);
//            // 如果是最后一列，则不需要绘制右边
//        } else if (isLastColum(parent, itemPosition, spanCount, childCount)) {
//            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight() + mDividerSize);
//        } else {
//            outRect.set(0, 0, mDivider.getIntrinsicWidth() + mDividerSize,
//                    mDivider.getIntrinsicHeight() + mDividerSize);
//        }
//    }
}
