package com.statistics.ui.adapter;


import android.databinding.DataBindingUtil;

import com.statistics.R;
import com.statistics.databinding.ItemFamilyMembersBinding;
import com.statistics.response.FamilyMembersRep;
import com.statistics.ui.viewmodel.FamilyMembersViewModel;
import com.waterbase.utile.DateUtil;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * Created by Water on 2018/4/16.
 */

public class Adapter_Family_Members extends BaseAdapter<FamilyMembersRep> {
    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_family_members;
    }

    @Override
    public void convert(BaseViewHolder holder, FamilyMembersRep familyMembersRep, int index) {
        ItemFamilyMembersBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new FamilyMembersViewModel(familyMembersRep));
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}
