package com.statistics.ui.adapter;

import android.databinding.DataBindingUtil;

import com.statistics.R;
import com.statistics.databinding.ItemColumnInfoBinding;
import com.statistics.databinding.ItemMotionTrailBinding;
import com.statistics.response.ColumnInfoRep;
import com.statistics.ui.viewmodel.ColumnInfoViewModel;
import com.statistics.ui.viewmodel.MotionTrailViewModel;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * 列管信息
 * Created by Water on 2018/4/17.
 */

public class Adapter_Column_Info extends BaseAdapter<ColumnInfoRep> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_column_info;
    }

    @Override
    public void convert(BaseViewHolder holder, ColumnInfoRep columnInfoRep, int index) {
        ItemColumnInfoBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new ColumnInfoViewModel(columnInfoRep));
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}
