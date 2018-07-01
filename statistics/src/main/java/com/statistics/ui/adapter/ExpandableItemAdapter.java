package com.statistics.ui.adapter;

import android.databinding.DataBindingUtil;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.commondata.listener.ItemClickListener;
import com.statistics.R;
import com.statistics.databinding.ItemExpandableLv0Binding;
import com.statistics.databinding.ItemExpandableLv1Binding;
import com.statistics.databinding.ItemExpandableLv2Binding;
import com.statistics.ui.viewmodel.Level0Item;
import com.statistics.ui.viewmodel.Level1Item;
import com.statistics.ui.viewmodel.Level2Item;

import java.util.List;

/**
 * Created by Water on 2018/4/11.
 */

public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        addItemType(TYPE_LEVEL_2, R.layout.item_expandable_lv2);
    }

    @Override
    protected void convert(BaseViewHolder holder, MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                ItemExpandableLv0Binding binding0 = DataBindingUtil.bind(holder.itemView);
                binding0.setLevel0Item((Level0Item) item);
                break;
            case TYPE_LEVEL_1:
                ItemExpandableLv1Binding binding1 = DataBindingUtil.bind(holder.itemView);
                binding1.setLevel1Item((Level1Item) item);
                Level1Item lv1 = (Level1Item) item;
                holder.setImageResource(R.id.iv_id, lv1.isExpanded() ? R.mipmap.sic_arrow_down : R.mipmap.ic_arrow_right);
                holder.itemView.setOnClickListener(v -> {
                    int pos = holder.getAdapterPosition();
                    Log.d(TAG, "Level 0 item pos: " + pos);
                    if (lv1.isExpanded()) {
                        collapse(pos);
                    } else {
                        expand(pos);
                    }
                });
                break;
            case TYPE_LEVEL_2:
                ItemExpandableLv2Binding binding2 = DataBindingUtil.bind(holder.itemView);
                binding2.setLevel2Item((Level2Item) item);
                holder.itemView.setOnClickListener(v -> {
                    if (itemClickListener != null)
                        itemClickListener.click(holder.itemView, (Level2Item) item, holder.getAdapterPosition());
                });
                break;
        }
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
