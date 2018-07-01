package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * 提供选择的民族->查询页面
 * 作者：Laughing on 2018/4/15 12:47
 * 邮箱：719240226@qq.com
 */

public class PersonStateViewModel implements IPickerViewData {
    @Override
    public String getPickerViewText() {
        return state;
    }

    private String state;//人员状态
    private String stateReq;//人员状态


    public PersonStateViewModel(String state) {

        this.state = state;
    }

    public PersonStateViewModel(String state, String stateReq) {

        this.state = state;
        this.stateReq = stateReq;
    }

    public String getState() {

        return state;
    }

    public String getStateReq() {
        return stateReq;
    }
}
