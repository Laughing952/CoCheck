package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * 提供选择的民族->查询页面
 * 作者：Laughing on 2018/4/15 12:47
 * 邮箱：719240226@qq.com
 */

public class EthnicViewModel implements IPickerViewData {
    @Override
    public String getPickerViewText() {
        return ethnic;
    }

    private String ethnic;//民族
    private String ethnicReq;//民族

    public EthnicViewModel(String ethnic) {

        this.ethnic = ethnic;
    }

    public EthnicViewModel(String ethnic, String ethnicReq) {

        this.ethnic = ethnic;
        this.ethnicReq = ethnicReq;
    }

    public String getEthnic() {
        return ethnic;
    }

    public String getEthnicReq() {
        return ethnicReq;
    }
}
