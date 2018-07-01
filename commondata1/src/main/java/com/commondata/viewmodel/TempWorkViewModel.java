package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * Created by edz on 2018/4/23.
 */

public class TempWorkViewModel implements IPickerViewData {
    //从事职业
    public String work;
    public String workReq;

    public void setWork(String work) {
        this.work = work;
    }

    public void setWorkReq(String workReq) {
        this.workReq = workReq;
    }

    public String getWork() {

        return work;
    }

    public String getWorkReq() {
        return workReq;
    }

    public TempWorkViewModel(String work, String workReq) {

        this.work = work;
        this.workReq = workReq;
    }

    @Override
    public String getPickerViewText() {
        return work;
    }
}
