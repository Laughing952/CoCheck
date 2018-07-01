package com.unistrong.business.ui.adapter;

import com.commondata.listener.ItemClickListener;
import com.commondata.util.TransformUtil;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.bean.PeoplePhotoQueryRep;
import com.unistrong.business.utile.LoadImageUtile;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * Created by cuihao on 2018/04/18.Recycler的适配器
 */
public class PeoplePhotoQueryResultAdapter extends BaseAdapter<PeoplePhotoQueryRep> {
    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_photo_query_result;
    }

    @Override
    public void convert(BaseViewHolder holder, PeoplePhotoQueryRep data, int index) {
        holder.setText(R.id.tv_people_name, data.getResultName());//姓名
        holder.setText(R.id.tv_people_idNum, data.getResultIdNum());//身份证
        holder.setText(R.id.tv_people_age, data.getResultAge());//年龄
        holder.setText(R.id.tv_people_similarity, data.getSimi());//相似度
        LoadImageUtile.base64ToBitmap(data.getImage());//图像
        holder.itemView.setOnClickListener(v -> {
               if(itemClickListener!=null)
                   itemClickListener.click(holder.itemView,data,index);
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
