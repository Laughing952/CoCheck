package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * 用来提供人员属性->查询页面
 * 作者：Laughing on 2018/4/15 12:47
 * 邮箱：719240226@qq.com
 */

public class PersonAttributesViewModel implements IPickerViewData {
    @Override
    public String getPickerViewText() {
        return attributes;
    }

    private String attributes;//有效
    private String attributesReq;//有效

    public PersonAttributesViewModel(String attributes) {
        this.attributes = attributes;
    }

    public PersonAttributesViewModel(String attributes, String attributesReq) {
        this.attributes = attributes;
        this.attributesReq = attributesReq;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getAttributesReq() {
        return attributesReq;
    }
}
