package com.statistics.ui.adapter;

import android.databinding.DataBindingUtil;

import com.statistics.R;
import com.statistics.databinding.ItemInvolvedInfoBinding;
import com.statistics.databinding.ItemMotionTrailBinding;
import com.statistics.response.InvolvedInfoRep;
import com.statistics.ui.viewmodel.InvolvedInfoViewModel;
import com.statistics.ui.viewmodel.MotionTrailViewModel;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * 涉案信息
 * Created by Water on 2018/4/17.
 */

public class Adapter_Involved_Info extends BaseAdapter<InvolvedInfoRep> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_involved_info;
    }

    @Override
    public void convert(BaseViewHolder holder, InvolvedInfoRep infoRep, int index) {
        ItemInvolvedInfoBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new InvolvedInfoViewModel(infoRep));
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}
