package com.statistics.ui.viewmodel;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.statistics.ui.adapter.ExpandableItemAdapter;

import java.io.Serializable;

/**
 * 统计中的头布局
 * Created by Water on 2018/4/11.
 */

public class Level2Item implements MultiItemEntity, Serializable {

    private int type;
    private String typeName;
    private String number;

    public Level2Item(String typeName, String number, int type) {
        this.type = type;
        this.typeName = typeName;
        this.number = number;
    }

    public int getType() {
        return type;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_2;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getNumber() {
        return number;
    }
}
