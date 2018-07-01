package com.unistrong.business.entity;

import com.unistrong.business.ui.adapter.ExpandableItemAdapter;

/**
 * Created by cuihao
 */

public class Person implements MultiItemEntity {
    public String imageDate;
    public String imageUri;

    public Person(String imageDate, String imageUri) {
        this.imageUri = imageUri;
        this.imageDate = imageDate;
    }



    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_PERSON;
    }
}