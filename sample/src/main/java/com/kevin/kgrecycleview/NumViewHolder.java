package com.kevin.kgrecycleview;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.lib.BaseViewHolder;

import butterknife.Bind;

/**
 * Created by kevin on 16/1/7.
 */
public class NumViewHolder extends BaseViewHolder<String> {

    @Bind(R.id.num)
    TextView num;

    public NumViewHolder(ViewGroup parent, @NonNull LayoutInflater inflater) {
        super(inflater.inflate(R.layout.list_item_num, parent, false));
    }

    @Override
    public void setItem(String item) {
        num.setText(TextUtils.isEmpty(item) ? "" : item);
    }
}
