package com.unistrong.home.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * 图片加载帮助类
 * Created by Water on 2018/4/9.
 */

public class LoadImageUtile {

    @BindingAdapter({"res"})
    public static void LocalImageLoad(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }
}
