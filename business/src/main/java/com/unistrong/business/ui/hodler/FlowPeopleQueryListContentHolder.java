package com.unistrong.business.ui.hodler;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by edz on 2018/4/17.
 */

public class FlowPeopleQueryListContentHolder extends RecyclerView.ViewHolder{

    private final SparseArray<View> views;
    public View convertView;

    public FlowPeopleQueryListContentHolder(View view) {
        super(view);
        this.views = new SparseArray<>();
        convertView=view;
    }
    public FlowPeopleQueryListContentHolder setText(@IdRes int viewId, CharSequence value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    public FlowPeopleQueryListContentHolder setText(@IdRes int viewId, @StringRes int strId) {
        TextView view = getView(viewId);
        view.setText(strId);
        return this;
    }
    public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
    public FlowPeopleQueryListContentHolder setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

}
