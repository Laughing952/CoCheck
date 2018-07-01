package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * Created by edz on 2018/4/23.
 */


public class TempStayReasonViewModel implements IPickerViewData{


    //居住事由
    public String stayReason;
    public String stayReasonReq;

    public TempStayReasonViewModel(String stayReason, String stayReasonReq) {
        this.stayReason = stayReason;
        this.stayReasonReq = stayReasonReq;
    }

    public String getStayReason() {
        return stayReason;
    }

    public String getStayReasonReq() {
        return stayReasonReq;
    }

    public void setStayReasonReq(String stayReasonReq) {

        this.stayReasonReq = stayReasonReq;
    }

    public void setStayReason(String stayReason) {

        this.stayReason = stayReason;
    }

    @Override
    public String getPickerViewText() {
        return stayReason;
    }
}
