package com.kevin.kgrecycleview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kevin.lib.BaseRecyclerAdapter;

/**
 * Created by kevin on 16/1/7.
 */
public class NumRecyclerAdapter extends BaseRecyclerAdapter<String, NumViewHolder> {

    public NumRecyclerAdapter(LayoutInflater mInflater) {
        super(mInflater);
    }

    @Override
    protected void onBindViewHolder(NumViewHolder holder, int position, String item) {
        holder.setItem(item);
    }

    @Override
    protected NumViewHolder onCreateViewHolder(ViewGroup parent, int viewType, LayoutInflater inflater) {
        return new NumViewHolder(parent, inflater);
    }
}
