package com.kevin.lib.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by kevin on 16/1/14.
 */
public class KGRecyclerViewUtil {

    /**
     * 转化为dip
     *
     * @param context
     * @param value
     * @return
     */
    public static int getDip(Context context, int value) {
        int dipValue = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources()
                .getDisplayMetrics());

        return dipValue;
    }
}
