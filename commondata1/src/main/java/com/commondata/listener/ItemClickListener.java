package com.commondata.listener;

import android.view.View;

/**
 * Created by Water on 2018/4/2.
 */

public interface ItemClickListener<T> {
    void click(View v,T t,int position);
}
