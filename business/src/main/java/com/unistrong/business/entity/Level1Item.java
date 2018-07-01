package com.unistrong.business.entity;

import com.unistrong.business.ui.adapter.ExpandableItemAdapter;

public class Level1Item extends AbstractExpandableItem<Person> implements MultiItemEntity {
    public String title;

    public Level1Item(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}