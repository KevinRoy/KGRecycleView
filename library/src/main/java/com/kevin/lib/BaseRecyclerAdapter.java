package com.kevin.lib;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 15/9/17.
 */
public abstract class BaseRecyclerAdapter<T, ViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolder> {

    private List<T> mItems = new ArrayList<T>();
    private LayoutInflater mInflater;

    public BaseRecyclerAdapter(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    /**
     * 增加单个item
     *
     * @param item
     */
    public void append(T item) {
        if (item != null) {
            int position = getItemCount();
            mItems.add(item);
            notifyItemInserted(position);
        }
    }

    /**
     * 增加list
     *
     * @param items
     */
    public void append(List<? extends T> items) {
        if (items != null && items.size() > 0) {
            int position = getItemCount();
            mItems.addAll(items);
            notifyItemRangeInserted(position, items.size());
        }
    }

    /**
     * 替换list
     *
     * @param items
     */
    public void swapData(List<? extends T> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * 删除某个值
     *
     * @param item
     */
    public void delete(T item) {
        if (mItems != null && mItems.size() > 0) {
            if (mItems.contains(item)) {
                int position = mItems.indexOf(item);
                notifyItemRemoved(position);
            }
        }
    }

    /**
     * 清零
     */
    public void clear() {
        if (mItems == null)
            return;

        mItems.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewHolder(parent, viewType, mInflater);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        onBindViewHolder(holder, position, getItem(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public T getItem(int position) {
        return mItems.get(position);
    }

    protected abstract void onBindViewHolder(ViewHolder holder, int position, T item);

    protected abstract ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, LayoutInflater inflater);
}
