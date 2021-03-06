package com.commondata.bean;

import java.io.Serializable;

/**
 * 人员基本信息实体类
 * Created by kb.zhang on 2018/4/14.
 */

public class PersonBean implements Serializable {

    /**
     * personId : 501R6501095611080100006
     * householdNum : 652122209004156
     * householdType : 2
     * specialHousehold : null
     * householdRelation : 02
     * householdRelationName : 户主
     * idNum : 652122192710053736
     * name : 买明·买提依明
     * sex : 1
     * nation : 05
     * nationName : 维吾尔
     * birthday : 19271005
     * height : 176
     * weight : null
     * bloodType : 3
     * eduLevel : 80
     * eduLevelName : 小学
     * marriageStatus : 20
     * politicalStatus : 13
     * politicalStatusName : 群众
     * workPlace : 吐峪沟乡泽日甫坎村四组
     * careers : null
     * careersName : null
     * national : 156
     * nationalName : 中国
     * tel : 18196058015
     * regionalism : 652122
     * householdAddress : 吐峪沟乡泽日甫坎儿孜村4组117号
     * householdArea : 652122690700
     * householdAreaName : 鄯善县公安局吐峪沟派出所泽日甫警务室
     * householdAreaTel : null
     * householdAreaPolice : null
     * communityCode : 6521229Q3708
     * communityName : 鄯善县吐峪沟乡泽日甫坎儿孜村
     * communityTel : null
     * communityStaff : null
     * personType : 2
     * personAttr : 22,99
     * registerOrganize : null
     * registerDate : null
     * householdPoliceStation : 650000400000
     * belongToPolice : null
     * belongToPoliceTel : null
     * belongToPoliceDepart : 新疆公安厅特警总队
     * policeStatioTel : null
     */

    private String personId;      //个人ID
    private String householdNum;      //家庭数量
    private String householdType;      //房屋类型
    private Object specialHousehold;      //特殊家庭
    private String householdRelation;      //家庭关系
    private String householdRelationName;      //房屋关系名称
    private String idNum;      //身份证号
    private String name;      //名称
    private String sex;      //性别
    private String nation;      //国家
    private String nationName;      //国家名称
    private String birthday;      //生日
    private String height;      //高度
    private Object weight;      //重量
    private String bloodType;      //血型
    private String eduLevel;      //教育水平
    private String eduLevelName;      //教育水平名称
    private String marriageStatus;      //婚姻状况
    private String politicalStatus;      //政治地位
    private String politicalStatusName;      //政治地位名称
    private String workPlace;      //工作地点
    private Object careers;      //职业生涯
    private Object careersName;      //职业名称
    private String national;      //国民
    private String nationalName;      //国家名称
    private String tel;      //联系电话
    private String regionalism;      //区域主义
    private String householdAddress;      //家庭地址
    private String householdArea;      //家庭用地
    private String householdAreaName;      //家庭区域名称
    private Object householdAreaTel;      //家庭区电话
    private Object householdAreaPolice;      //家庭区警察
    private String communityCode;      //社区代码
    private String communityName;      //社区名字
    private Object communityTel;      //社区电话
    private Object communityStaff;      //社区员工
    private String personType;      //人类型
    private String personAttr;      //人员属性
    private Object registerOrganize;      //注册机构
    private Object registerDate;      //注册日期
    private String householdPoliceStation;      //房子举行警察局
    private Object belongToPolice;      //属于警察
    private Object belongToPoliceTel;      //属于警察电话
    private String belongToPoliceDepart;      //属于警察出发
    private Object policeStatioTel;      //警察Statio电话

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getHouseholdNum() {
        return householdNum;
    }

    public void setHouseholdNum(String householdNum) {
        this.householdNum = householdNum;
    }

    public String getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    public Object getSpecialHousehold() {
        return specialHousehold;
    }

    public void setSpecialHousehold(Object specialHousehold) {
        this.specialHousehold = specialHousehold;
    }

    public String getHouseholdRelation() {
        return householdRelation;
    }

    public void setHouseholdRelation(String householdRelation) {
        this.householdRelation = householdRelation;
    }

    public String getHouseholdRelationName() {
        return householdRelationName;
    }

    public void setHouseholdRelationName(String householdRelationName) {
        this.householdRelationName = householdRelationName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getEduLevelName() {
        return eduLevelName;
    }

    public void setEduLevelName(String eduLevelName) {
        this.eduLevelName = eduLevelName;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalStatusName() {
        return politicalStatusName;
    }

    public void setPoliticalStatusName(String politicalStatusName) {
        this.politicalStatusName = politicalStatusName;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Object getCareers() {
        return careers;
    }

    public void setCareers(Object careers) {
        this.careers = careers;
    }

    public Object getCareersName() {
        return careersName;
    }

    public void setCareersName(Object careersName) {
        this.careersName = careersName;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRegionalism() {
        return regionalism;
    }

    public void setRegionalism(String regionalism) {
        this.regionalism = regionalism;
    }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress;
    }

    public String getHouseholdArea() {
        return householdArea;
    }

    public void setHouseholdArea(String householdArea) {
        this.householdArea = householdArea;
    }

    public String getHouseholdAreaName() {
        return householdAreaName;
    }

    public void setHouseholdAreaName(String householdAreaName) {
        this.householdAreaName = householdAreaName;
    }

    public Object getHouseholdAreaTel() {
        return householdAreaTel;
    }

    public void setHouseholdAreaTel(Object householdAreaTel) {
        this.householdAreaTel = householdAreaTel;
    }

    public Object getHouseholdAreaPolice() {
        return householdAreaPolice;
    }

    public void setHouseholdAreaPolice(Object householdAreaPolice) {
        this.householdAreaPolice = householdAreaPolice;
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Object getCommunityTel() {
        return communityTel;
    }

    public void setCommunityTel(Object communityTel) {
        this.communityTel = communityTel;
    }

    public Object getCommunityStaff() {
        return communityStaff;
    }

    public void setCommunityStaff(Object communityStaff) {
        this.communityStaff = communityStaff;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonAttr() {
        return personAttr;
    }

    public void setPersonAttr(String personAttr) {
        this.personAttr = personAttr;
    }

    public Object getRegisterOrganize() {
        return registerOrganize;
    }

    public void setRegisterOrganize(Object registerOrganize) {
        this.registerOrganize = registerOrganize;
    }

    public Object getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Object registerDate) {
        this.registerDate = registerDate;
    }

    public String getHouseholdPoliceStation() {
        return householdPoliceStation;
    }

    public void setHouseholdPoliceStation(String householdPoliceStation) {
        this.householdPoliceStation = householdPoliceStation;
    }

    public Object getBelongToPolice() {
        return belongToPolice;
    }

    public void setBelongToPolice(Object belongToPolice) {
        this.belongToPolice = belongToPolice;
    }

    public Object getBelongToPoliceTel() {
        return belongToPoliceTel;
    }

    public void setBelongToPoliceTel(Object belongToPoliceTel) {
        this.belongToPoliceTel = belongToPoliceTel;
    }

    public String getBelongToPoliceDepart() {
        return belongToPoliceDepart;
    }

    public void setBelongToPoliceDepart(String belongToPoliceDepart) {
        this.belongToPoliceDepart = belongToPoliceDepart;
    }

    public Object getPoliceStatioTel() {
        return policeStatioTel;
    }

    public void setPoliceStatioTel(Object policeStatioTel) {
        this.policeStatioTel = policeStatioTel;
    }
}
