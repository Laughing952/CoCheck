package com.statistics.ui.adapter;

import android.databinding.DataBindingUtil;

import com.statistics.R;
import com.statistics.databinding.ItemInvolvedInfoBinding;
import com.statistics.databinding.ItemMarriageInfoBinding;
import com.statistics.response.MarriageInfoRep;
import com.statistics.ui.viewmodel.InvolvedInfoViewModel;
import com.statistics.ui.viewmodel.MarriageInfoViewModel;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * Created by Water on 2018/4/17.
 */

public class Adapter_Marriage_Info extends BaseAdapter<MarriageInfoRep> {
    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_marriage_info;
    }

    @Override
    public void convert(BaseViewHolder holder, MarriageInfoRep infoRep, int index) {
        ItemMarriageInfoBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new MarriageInfoViewModel(infoRep));
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}
