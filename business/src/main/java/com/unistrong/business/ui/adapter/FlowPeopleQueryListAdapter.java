package com.unistrong.business.ui.adapter;

import com.commondata.listener.ItemClickListener;
import com.commondata.util.TransformUtil;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * Created by cuihao on 2018/04/18.Recycler的适配器
 */
public class FlowPeopleQueryListAdapter extends BaseAdapter<FlowPeopleQueryItemRep> {

    private ItemClickListener itemClickListener;

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_query_list;
    }

    @Override
    public void convert(BaseViewHolder holder, FlowPeopleQueryItemRep data, int index) {
        holder.setText(R.id.tv_query_list_name, data.getName());//阿里木 买买提
        holder.setText(R.id.tv_query_list_id, data.getIdNum());//610112198707064567
        if(data.getPersonAttr()!=null){
            String attr = TransformUtil.personAttrTransformString(data.getPersonAttr());
            holder.setText(R.id.tv_query_list_tag, attr);//一般人员
        }
        String nation = TransformUtil.nationTransform(data.getNation());
        holder.setText(R.id.tv_query_list_ethnic, nation);//维吾尔族
        String logoutTag = TransformUtil.logoutTagTransform(data.getLogoutTag());
        holder.setText(R.id.tv_query_list_state, logoutTag);//未注销
        if (data.getSex() == "1") {
            holder.setImage(R.id.iv_image_sex, R.mipmap.ic_man);//男
        } else if (data.getSex() == "2") {
            holder.setImage(R.id.iv_image_sex, R.mipmap.ic_woman);//女
        }
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.click(holder.itemView,data,index);
            }
        });
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
}
