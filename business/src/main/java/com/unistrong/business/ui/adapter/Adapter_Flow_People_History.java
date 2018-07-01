package com.unistrong.business.ui.adapter;

import android.databinding.DataBindingUtil;

import com.commondata.listener.ItemClickListener;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleHistoryRep;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.databinding.ItemFlowPeopleHistoryListBinding;
import com.unistrong.business.ui.viewmodel.FlowPeopleHistoryViewModel;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * 作者：Laughing on 2018/4/22 19:30
 * 邮箱：719240226@qq.com
 */

public class Adapter_Flow_People_History extends BaseAdapter<FlowPeopleQueryItemRep> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_flow_people_history_list;
    }

    @Override
    public void convert(BaseViewHolder holder, FlowPeopleQueryItemRep data, int index) {
        ItemFlowPeopleHistoryListBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new FlowPeopleHistoryViewModel(data));
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
