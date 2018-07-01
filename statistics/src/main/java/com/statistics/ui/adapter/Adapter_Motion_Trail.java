package com.statistics.ui.adapter;

import android.databinding.DataBindingUtil;

import com.statistics.R;
import com.statistics.databinding.ItemFamilyMembersBinding;
import com.statistics.databinding.ItemMotionTrailBinding;
import com.statistics.response.MotionTrailRep;
import com.statistics.ui.viewmodel.FamilyMembersViewModel;
import com.statistics.ui.viewmodel.MotionTrailViewModel;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * 疆外活动轨迹
 * Created by Water on 2018/4/17.
 */

public class Adapter_Motion_Trail extends BaseAdapter<MotionTrailRep> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_motion_trail;
    }

    @Override
    public void convert(BaseViewHolder holder, MotionTrailRep trailRep, int index) {
        ItemMotionTrailBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new MotionTrailViewModel(trailRep));
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}
