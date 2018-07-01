package com.unistrong.home.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.commondata.listener.ItemClickListener;
import com.unistrong.home.R;
import com.unistrong.home.databinding.ItemPopBinding;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Water on 2018/4/23.
 */

public class Adapter_Pop extends RecyclerView.Adapter<Adapter_Pop.MyViewHodle> {

    private List<String> stringList = new ArrayList<>();

    @Override
    public MyViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHodle baseViewHolder = new MyViewHodle(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pop, parent, false));
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHodle holder, int position) {
        holder.textView.setText(stringList.get(position));
        holder.itemView.setOnClickListener(v -> {
            itemClickListener.click(holder.itemView, stringList.get(position), position);
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public void setData(List<String> stringList) {
        this.stringList.clear();
        this.stringList.addAll(stringList);
        notifyDataSetChanged();
    }

    public void addData(String str) {
        this.stringList.add(str);
        notifyDataSetChanged();
    }

    public void removeData(String str) {
        int index = stringList.indexOf(str);
        stringList.remove(str);
        notifyItemRemoved(index);
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class MyViewHodle extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHodle(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
