package com.statistics.ui.viewmodel;

import com.statistics.response.FamilyMembersRep;

/**
 * Created by Water on 2018/4/16.
 */

public class FamilyMembersViewModel {

    private FamilyMembersRep membersRep;

    private String relation; // 关系
    private String name; // 名字
    private String birthday; // 生日
    private String nation; // 民族
    private String phoneNo; // 电话号码

    public FamilyMembersViewModel(FamilyMembersRep membersRep) {
        this.membersRep = membersRep;
    }

    public String getRelation() {
        return membersRep.getHouseholdRelationName();
    }

    public String getName() {
        return membersRep.getName();
    }

    public String getBirthday() {
        return membersRep.getBirthday();
    }

    public String getNation() {
        return membersRep.getNationName();
    }

    public String getPhoneNo() {
        return membersRep.getTel();
    }
}
