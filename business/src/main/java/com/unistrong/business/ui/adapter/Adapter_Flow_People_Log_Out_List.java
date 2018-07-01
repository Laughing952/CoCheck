package com.unistrong.business.ui.adapter;

import android.databinding.DataBindingUtil;

import com.commondata.listener.ItemClickListener;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.databinding.ItemFlowPeopleLogOutListBinding;
import com.unistrong.business.ui.viewmodel.FlowPeopleLogOutListViewModel;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * 注销列表Adapter
 * 作者：Laughing on 2018/4/24 11:27
 * 邮箱：719240226@qq.com
 */

public class Adapter_Flow_People_Log_Out_List extends BaseAdapter<FlowPeopleQueryItemRep> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_flow_people_log_out_list;
    }

    @Override
    public void convert(BaseViewHolder holder, FlowPeopleQueryItemRep data, int index) {
        ItemFlowPeopleLogOutListBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(new FlowPeopleLogOutListViewModel(data));
        holder.itemView.setOnClickListener(v -> {
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
