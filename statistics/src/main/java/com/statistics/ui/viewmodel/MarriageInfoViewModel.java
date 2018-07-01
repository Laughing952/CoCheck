package com.statistics.ui.viewmodel;

import com.statistics.response.MarriageInfoRep;

/**
 * 婚姻信息
 * Created by Water on 2018/4/17.
 */

public class MarriageInfoViewModel {

    private MarriageInfoRep marriageInfoRep;

    private String name; // 姓名
    private String idCardNum; // 身份证号码
    private String birthday; // 生日
    private String nation; // 民族
    private String profession; // 职业
    private String registeredAddress; // 登记地址
    private String registeredDate; // 登记日期

    public MarriageInfoViewModel(MarriageInfoRep marriageInfoRep) {
        this.marriageInfoRep = marriageInfoRep;
    }

    public String getName() {
        return marriageInfoRep.getName() + " (" + marriageInfoRep.getHouseholdRelationName() + ")";
    }

    public String getIdCardNum() {
        return marriageInfoRep.getIdNum();
    }

    public String getBirthday() {
        return marriageInfoRep.getBirthday();
    }

    public String getNation() {
        return marriageInfoRep.getNationName();
    }

    public String getProfession() {
        return marriageInfoRep.getCareersName();
    }

    public String getRegisteredAddress() {
        return marriageInfoRep.getRegisterOrganize();
    }

    public String getRegisteredDate() {
        return marriageInfoRep.getRegisterDate();
    }
}
