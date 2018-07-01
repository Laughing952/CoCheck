package com.commondata.bean;

import java.io.Serializable;

/**
 * Created by edz on 2018/4/20.
 */

public class FlowPeopleAddInfoReq implements Serializable {
    private String personAttr;//人员属性
    private String nation;//民族
    private String regionalism;//户籍区划
    private String sex;//性别
    private String eduLevel;//文化程度
    //新增
    private String idNum;//身份证号
    private String birthday;//生日
    private String name;//姓名


    public FlowPeopleAddInfoReq(String personAttr, String nation, String regionalism, String sex,
                                String eduLevel, String idNum, String birthday, String name) {
        this.personAttr = personAttr;
        this.nation = nation;
        this.regionalism = regionalism;
        this.sex = sex;
        this.eduLevel = eduLevel;
        this.idNum = idNum;
        this.birthday = birthday;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNum() {

        return idNum;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setPersonAttr(String personAttr) {
        this.personAttr = personAttr;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setRegionalism(String regionalism) {
        this.regionalism = regionalism;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getPersonAttr() {

        return personAttr;
    }

    public String getNation() {
        return nation;
    }

    public String getRegionalism() {
        return regionalism;
    }

    public String getSex() {
        return sex;
    }

    public String getEduLevel() {
        return eduLevel;
    }
}
