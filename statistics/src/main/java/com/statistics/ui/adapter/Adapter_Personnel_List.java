package com.statistics.ui.adapter;

import android.databinding.DataBindingUtil;

import com.commondata.listener.ItemClickListener;
import com.statistics.R;
import com.statistics.databinding.ItemPersonnelListBinding;
import com.statistics.response.AssistantStatisticsRep;
import com.statistics.response.PersonneRep;
import com.statistics.ui.viewmodel.PersonneViewModel;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * Created by Water on 2018/4/12.
 */

public class Adapter_Personnel_List extends BaseAdapter<PersonneRep> {
    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_personnel_list;
    }

    @Override
    public void convert(BaseViewHolder holder, PersonneRep data, int index) {
        ItemPersonnelListBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new PersonneViewModel(data));
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null)
                itemClickListener.click(holder.itemView, data, index);
        });
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
