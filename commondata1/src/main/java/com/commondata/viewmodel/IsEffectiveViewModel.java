package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * 用来提供查询页面中是否有效的值->查询页面
 * 作者：Laughing on 2018/4/15 12:47
 * 邮箱：719240226@qq.com
 */

public class IsEffectiveViewModel implements IPickerViewData {
    @Override
    public String getPickerViewText() {
        return effective;
    }

    private String effective;//有效
    private String effectiveReq;//有效

    public IsEffectiveViewModel(String effective) {
        this.effective = effective;
    }

    public IsEffectiveViewModel(String effective, String effectiveReq) {
        this.effective = effective;
        this.effectiveReq = effectiveReq;
    }

    public String geteffective() {
        return effective;
    }

    public String getEffectiveReq() {
        return effectiveReq;
    }
}
