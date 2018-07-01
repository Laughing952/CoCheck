package com.unistrong.home.ui.adapter;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.commondata.listener.ItemClickListener;
import com.unistrong.home.R;
import com.unistrong.home.bean.HomeItemIcon;
import com.unistrong.home.databinding.ItemRecyclerViewHomeBinding;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

import java.util.List;

/**
 * 作者：Laughing on 2018/4/4 15:54
 * 邮箱：719240226@qq.com
 */

public class Adapter_Home extends BaseAdapter<HomeItemIcon> {

    private ItemClickListener mItemClickListener;

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_recycler_view_home;
    }

    @Override

    public void convert(BaseViewHolder holder, HomeItemIcon itemIcon, int index) {
        ItemRecyclerViewHomeBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setContent(itemIcon);
        holder.itemView.setOnClickListener(v -> {
            if (mItemClickListener != null) {
                mItemClickListener.click(holder.itemView, itemIcon, index);
            }
        });
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
