package com.statistics.utile;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.statistics.R;
import com.waterbase.utile.GlideUtile;


/**
 * Created by Water on 2017/6/20.
 */

public class ImageLoadUtile {

    @BindingAdapter({"viewbg"})
    public static void LocalImageLoad(View view, int res) {
        view.setBackgroundResource(res);
    }

    @BindingAdapter({"statisticsRes"})
    public static void LocalImageLoad(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }

    @BindingAdapter({"circleUrl"})
    public static void loadCircleImage(ImageView imageView, String url) {
        GlideUtile.loadCircleImage(imageView, url, R.mipmap.ic_head_normal, R.mipmap.ic_head_normal);
    }


}
