package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * 流动人口暂时居住时间->查询页面
 * 作者：Laughing on 2018/4/15 12:47
 * 邮箱：719240226@qq.com
 */

public class TempStayTimeViewModel implements IPickerViewData {
    @Override
    public String getPickerViewText() {
        return days;
    }

    private String days;//暂时居住天数
    private String daysReq;

    public String getDaysReq() {
        return daysReq;
    }

    public void setDaysReq(String daysReq) {
        this.daysReq = daysReq;
    }

    public TempStayTimeViewModel(String days,String daysReq) {
        this.daysReq=daysReq;
        this.days = days;
    }

    public String getDays() {
        return days;
    }
}
