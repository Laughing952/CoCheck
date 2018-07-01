package com.unistrong.business.ui.adapter;

import android.databinding.DataBindingUtil;

import com.commondata.listener.ItemClickListener;
import com.unistrong.business.R;
import com.unistrong.business.bean.Action;
import com.unistrong.business.databinding.ItemBusinessImageBinding;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * Created by edz on 2018/4/8.
 */

public class RecycleCardViewAapter extends BaseAdapter<Action> {

    private ItemClickListener itemClickListener;

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_business_image;
    }

    @Override
    public void convert(BaseViewHolder holder, Action action, int index) {
        ItemBusinessImageBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setAction(action);
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null)
                itemClickListener.click(holder.itemView, action, index);
        });
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
