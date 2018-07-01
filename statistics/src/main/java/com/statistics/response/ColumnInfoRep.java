package com.statistics.response;

/**
 * 列管信息
 * Created by Water on 2018/4/18.
 */

public class ColumnInfoRep {

    private String holidayStatus; // 请销假状态: 1:已申请; 2:已请假; 3:已销假; 4:超时限未销假; 5:退回; 6: 假期结束未审批; 7:终止请销假
    private String jailedDate; // 列管日期 (格式：yyyyMMdd)
    private String jailedPerson; // 列管人
    private String name; // 姓名
    private String persoType; // 人员类别

    public String getHolidayStatus() {
        return holidayStatus;
    }

    public void setHolidayStatus(String holidayStatus) {
        this.holidayStatus = holidayStatus;
    }

    public String getJailedDate() {
        return jailedDate;
    }

    public void setJailedDate(String jailedDate) {
        this.jailedDate = jailedDate;
    }

    public String getJailedPerson() {
        return jailedPerson;
    }

    public void setJailedPerson(String jailedPerson) {
        this.jailedPerson = jailedPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersoType() {
        return persoType;
    }

    public void setPersoType(String persoType) {
        this.persoType = persoType;
    }
}
