package com.statistics.ui.viewmodel;

import com.commondata.util.TransformUtil;
import com.statistics.response.ColumnInfoRep;

/**
 * 列管信息
 * Created by Water on 2018/4/17.
 */

public class ColumnInfoViewModel {

    private ColumnInfoRep columnInfoRep;

    private String idCardNum; // 身份证号码
    private String personAttr; // 人员属性
    private String tubulationPerson; // 列管人
    private String tubulationDate; // 列管日期
    private String vacationState; // 请销假状态

    public ColumnInfoViewModel(ColumnInfoRep columnInfoRep) {
        this.columnInfoRep = columnInfoRep;
    }

    public String getIdCardNum() {
        return "1231234189789123";
    }

    public String getPersonAttr() {
        return TransformUtil.personAttrsTransform(columnInfoRep.getPersoType());
    }

    public String getTubulationPerson() {
        return columnInfoRep.getJailedPerson();
    }

    public String getTubulationDate() {
        return columnInfoRep.getJailedDate();
    }

    public String getVacationState() {
        int status = 0;
        try {
            Integer.parseInt(columnInfoRep.getHolidayStatus());
        } catch (NumberFormatException e) {

        }
        return TransformUtil.bloodHolidayform(status);
    }
}
