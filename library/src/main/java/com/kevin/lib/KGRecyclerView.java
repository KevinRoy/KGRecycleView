package com.kevin.lib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;

import com.kevin.lib.decoration.DividerGridItemDecoration;
import com.kevin.lib.decoration.DividerLinearItemDecoration;
import com.kevin.lib.util.KGRecyclerViewUtil;

/**
 * Created by kevin on 15/9/18.
 */
public class KGRecyclerView extends RecyclerView {
    public static final String TAG = "KGRecyclerView";

    public static final int HORIZONTAL_LINEAR = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LINEAR = LinearLayoutManager.VERTICAL;

    public static final int HORIZONTAL_STAGGERED = StaggeredGridLayoutManager.HORIZONTAL;
    public static final int VERTICAL_STAGGERED = StaggeredGridLayoutManager.VERTICAL;

    public static final int TYPE_STAGGERED = 0;
    public static final int TYPE_GRID = 1;
    public static final int TYPE_LINEAR = 2;

    private Context mContext;
    private LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private int mType = TYPE_LINEAR; //判断LinearLayoutManager StaggeredGridLayoutManager或者GridLayoutManager
    private int mOrientation = -1;  //排列方式
    private int mPosition = 0;  //显示的position
    private int mRightMargin = 0;
    private int mLeftMargin = 0;
    private int mTopMargin = 0;
    private int mButtomMargin = 0;
    private int mDivideSize = 0;
    private Drawable mDrawable;

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
     *
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
     *
     * @return
     */
    public KGRecyclerView addLinearlayout() {
        mType = TYPE_LINEAR;
        mLayoutManager = new LinearLayoutManager(mContext);
        return this;
    }

    /**
     * 加入GridLayoutManager
     *
     * @param spanCount 行个数
     * @return
     */
    public KGRecyclerView addGridlayout(int spanCount) {
        mType = TYPE_GRID;
        mLayoutManager = new GridLayoutManager(mContext, spanCount);
        return this;
    }

    /**
     * 加入StaggeredGridLayoutManager，如果orientation添加了就用orientation，否则默认VERTICAL
     *
     * @param spanCount 行个数
     * @return
     */
    public KGRecyclerView addStaggeredGridlayout(int spanCount) {
        mType = TYPE_STAGGERED;
        mLayoutManager = new StaggeredGridLayoutManager(spanCount, VERTICAL_STAGGERED);
        return this;
    }

    public KGRecyclerView addAdapter(RecyclerView.Adapter adapter) {
        mAdapter = adapter;
        return this;
    }

    public KGRecyclerView addScrollToPosition(int position) {
        mPosition = position;
        return this;
    }

    public KGRecyclerView addRightMargin(int margin) {
        mRightMargin = KGRecyclerViewUtil.getDip(mContext, margin);
        return this;
    }

    public KGRecyclerView addTopMargin(int margin) {
        mTopMargin = KGRecyclerViewUtil.getDip(mContext, margin);
        return this;
    }

    public KGRecyclerView addButtomMargin(int margin) {
        mButtomMargin = KGRecyclerViewUtil.getDip(mContext, margin);
        return this;
    }

    public KGRecyclerView addleftMargin(int margin) {
        mLeftMargin = KGRecyclerViewUtil.getDip(mContext, margin);
        return this;
    }

    public KGRecyclerView addDrawable(Drawable drawable) {
        mDrawable = drawable;
        return this;
    }

    public KGRecyclerView addSize(int size) {
        mDivideSize = KGRecyclerViewUtil.getDip(mContext, size);
        return this;
    }

    public KGRecyclerView build() {
        initViewManager();

        if (getLayoutManager() != null) {
            LayoutManager layoutManager = getLayoutManager();
            layoutManager.scrollToPosition(mPosition);
        }

        setLayoutManager(mLayoutManager);

        if (mAdapter != null) {
            setAdapter(mAdapter);
        }

        return this;
    }

    private void initViewManager() {
        if (mLayoutManager instanceof LinearLayoutManager) {
            Log.d(TAG, "LinearLayoutManager");
            initViewLinearLayoutManager();
        } else if (mLayoutManager instanceof StaggeredGridLayoutManager) {
            Log.d(TAG, "StaggeredGridLayoutManager");
            initViewStaggeredGridLayoutManager();
        } else {
            Log.d(TAG, "GridLayoutManager");
            initViewStaggeredGridLayoutManager();
        }
    }

    private void initViewLinearLayoutManager() {
        DividerLinearItemDecoration dividerLinearItemDecoration;
        dividerLinearItemDecoration = new DividerLinearItemDecoration(mContext);

        if (mDrawable != null) {
            dividerLinearItemDecoration.setDrawbale(mDrawable);
        }

        if (mOrientation == -1) {
            dividerLinearItemDecoration.setOrientation(DividerLinearItemDecoration.VERTICAL_LIST);
            ((LinearLayoutManager) mLayoutManager).setOrientation(VERTICAL_LINEAR);
        } else {
            dividerLinearItemDecoration.setOrientation(mOrientation);
            ((LinearLayoutManager) mLayoutManager).setOrientation(mOrientation);
        }

        if (mOrientation == DividerLinearItemDecoration.VERTICAL_LIST) {
            dividerLinearItemDecoration.setRightMargin(mRightMargin);
            dividerLinearItemDecoration.setLeftMargin(mLeftMargin);
        } else {
            dividerLinearItemDecoration.setButtomMargin(mButtomMargin);
            dividerLinearItemDecoration.setTopMargin(mTopMargin);
        }

        dividerLinearItemDecoration.setDividerSize(mDivideSize);

        addItemDecoration(dividerLinearItemDecoration);
    }

    private void initViewStaggeredGridLayoutManager() {
        DividerGridItemDecoration dividerGridItemDecoration;
        dividerGridItemDecoration = new DividerGridItemDecoration(mContext);

        if (mType == TYPE_STAGGERED) {
            if (mOrientation == -1) {
                ((StaggeredGridLayoutManager) mLayoutManager).setOrientation(VERTICAL_STAGGERED);
            } else {
                ((StaggeredGridLayoutManager) mLayoutManager).setOrientation(mOrientation);
            }
        }

        dividerGridItemDecoration.setRightMargin(mRightMargin);
        dividerGridItemDecoration.setLeftMargin(mLeftMargin);
        dividerGridItemDecoration.setButtomMargin(mButtomMargin);
        dividerGridItemDecoration.setTopMargin(mTopMargin);

        addItemDecoration(dividerGridItemDecoration);
    }
}
