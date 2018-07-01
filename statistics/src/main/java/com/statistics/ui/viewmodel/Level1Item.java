package com.statistics.ui.viewmodel;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.statistics.ui.adapter.ExpandableItemAdapter;

/**
 * 统计中的头布局
 * Created by Water on 2018/4/11.
 */

public class Level1Item extends AbstractExpandableItem<Level2Item> implements MultiItemEntity {

    private String typeLevel1;

    public Level1Item(String typeLevel1) {
        this.typeLevel1 = typeLevel1;
    }

    public String getTypeLevel1() {
        return typeLevel1;
    }

    public void setTypeLevel1(String typeLevel1) {
        this.typeLevel1 = typeLevel1;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
