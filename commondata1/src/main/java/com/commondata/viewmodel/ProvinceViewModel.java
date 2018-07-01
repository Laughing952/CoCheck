package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * 提供选择的省或直辖市->查询页面
 * 作者：Laughing on 2018/4/15 12:47
 * 邮箱：719240226@qq.com
 */

public class ProvinceViewModel implements IPickerViewData {
    @Override
    public String getPickerViewText() {
        return province;
    }

    private String province;//省或直辖市

    public ProvinceViewModel(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }
}
