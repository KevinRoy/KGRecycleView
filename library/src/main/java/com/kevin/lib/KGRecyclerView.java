package com.kevin.lib;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.kevin.lib.decoration.DividerGridItemDecoration;
import com.kevin.lib.decoration.DividerLinearItemDecoration;

/**
 * Created by kevin on 15/9/18.
 */
public class KGRecyclerView extends RecyclerView {
    public static final int HORIZONTAL_LINEAR = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LINEAR = LinearLayoutManager.VERTICAL;

    public static final int HORIZONTAL_STAGGERED = StaggeredGridLayoutManager.HORIZONTAL;
    public static final int VERTICAL_STAGGERED = StaggeredGridLayoutManager.VERTICAL;

    private Context mContext;
    private int mOrientation = -1;

    public KGRecyclerView(Context context) {
        super(context, null, 0);
    }

    public KGRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public KGRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initView() {
        setHasFixedSize(true);
        setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * 必须调用，传入context和一些初始化的操作
     * @param context
     * @return
     */
    public KGRecyclerView Builder(Context context) {
        mContext = context;
        initView();
        return this;
    }

    /**
     * 添加 orientation 但是必须在add***layout之前调用，否则无用
     *
     * @param orientation
     * @return
     */
    public KGRecyclerView addOrientation(int orientation) {
        mOrientation = orientation;
        return this;
    }

    /**
     * 加入LinearLayoutManager，如果orientation添加了就用orientation，否则默认VERTICAL
     * @return
     */
    public KGRecyclerView addLinearlayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);

        if (mOrientation == -1) {
            addItemDecoration(new DividerLinearItemDecoration(mContext));
            layoutManager.setOrientation(VERTICAL_LINEAR);
        } else {
            addItemDecoration(new DividerLinearItemDecoration(mContext, mOrientation));
            layoutManager.setOrientation(mOrientation);
        }

        scrollToPosition(0);
        setLayoutManager(layoutManager);

        return this;
    }

    /**
     * 加入GridLayoutManager
     * @param spanCount 每行个数
     * @return
     */
    public KGRecyclerView addGridlayout(int spanCount) {
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, spanCount);
        setLayoutManager(layoutManager);

        addItemDecoration(new DividerGridItemDecoration(mContext));
        return this;
    }

    /**
     * 加入StaggeredGridLayoutManager，如果orientation添加了就用orientation，否则默认VERTICAL
     * @param spanCount 每行个数
     * @return
     */
    public KGRecyclerView addStaggeredGridlayout(int spanCount) {
        StaggeredGridLayoutManager layoutManager;
        if (mOrientation == -1) {
            layoutManager = new StaggeredGridLayoutManager(spanCount, VERTICAL_STAGGERED);
        } else {
            layoutManager = new StaggeredGridLayoutManager(spanCount, mOrientation);
        }

        setLayoutManager(layoutManager);

        addItemDecoration(new DividerGridItemDecoration(mContext));
        return this;
    }

    public KGRecyclerView addAdapter(RecyclerView.Adapter adapter) {
        setAdapter(adapter);
        return this;
    }

    public KGRecyclerView addScrollToPosition(int position) {
        if (getLayoutManager() != null) {
            LayoutManager layoutManager = getLayoutManager();
            layoutManager.scrollToPosition(position);
        }
        return this;
    }

    public KGRecyclerView build() {
        return this;
    }
}
