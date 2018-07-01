package com.unistrong.business.bean;

import java.io.Serializable;

/**
 * 流动人员管理详情
 * Created by edz on 2018/4/17.
 */

public class FlowPeopleQueryItemRep implements Serializable {

    /**
     * personId :
     * householdNum :
     * householdType :
     * specialHousehold :
     * householdRelation :
     * householdRelationName :
     * idNum : 652122192710053736
     * name : 王五
     * sex : 1
     * nation : 05
     * nationName :
     * birthday : 19271005
     * height :
     * weight :
     * bloodType :
     * eduLevel : 80
     * eduLevelName :
     * marriageStatus :
     * politicalStatus :
     * politicalStatusName :
     * workPlace :
     * careers :
     * careersName :
     * national :
     * nationalName :
     * tel :
     * regionalism : 652122
     * householdAddress :
     * householdArea :
     * householdAreaName :
     * householdAreaTel :
     * householdAreaPolice :
     * communityCode :
     * communityName :
     * communityTel :
     * communityStaff :
     * personType :
     * personAttr : 28
     * registerOrganize :
     * registerDate : 20180414
     * householdPoliceStation :
     * belongToPolice :
     * belongToPoliceTel :
     * belongToPoliceDepart :
     * policeStatioTel :
     * image :
     * personFlowId : 501R6501095611080100006
     * userId :
     * tempLivePlace : 吐峪沟乡泽日甫坎村四组
     * tempLiveArea : 652122690700
     * tempLiveAddress : 吐峪沟乡泽日甫坎儿孜村4组117号
     * tempLiveReason : 201
     * planLiveTime : 20190114
     * flowInTime : 20180414175955
     * flowOutTime :
     * logoutTag :
     */
    private String tempLiveReasonDesc;
    private String registerUser;
    private String registerMobile;
    private String photoUrl;
    private String officeCode;
    private String personId;    //个人ID
    private String householdNum;//家庭数量
    private String householdType;//家用型
    private String specialHousehold;//特殊家庭
    private String householdRelation;//家庭关系
    private String householdRelationName;//家庭关系名称
    private String idNum;//身份证号
    private String name;//名称
    private String sex;//性别
    private String nation;//国家
    private String nationName;//国家名称
    private String birthday;//生日
    private String height;//高度
    private String weight;//重量
    private String bloodType;//血型
    private String eduLevel;//教育水平
    private String eduLevelName;//教育水平名称
    private String marriageStatus;//婚姻状况
    private String politicalStatus;//政治地位
    private String politicalStatusName;//政治地位名称
    private String workPlace;//工作地点
    private String careers;//职业生涯
    private String careersName;//职业名称
    private String national;//国民
    private String nationalName;//国名
    private String tel;//联系电话
    private String regionalism;//户籍责任区划
    private String regionalismName;//户籍责任区划名称
    private String householdAddress;//家庭地址
    private String householdArea;//家庭区域
    private String householdAreaName;//家庭区域名称
    private String householdAreaTel;//家庭区电话
    private String householdAreaPolice;//家庭区警察
    private String communityCode;//社区代码
    private String communityName;//社区名字
    private String communityTel;//社区电话
    private String communityStaff;//社区员工
    private String personType;//人类型
    private String personAttr;//人Attr
    private String registerOrganize;//注册组织
    private String registerDate;//登记日期（格式：yyyyMMdd
    private String householdPoliceStation;//家庭派出所
    private String belongToPoliceId;
    private String belongToPolice;//属于警察
    private String belongToPoliceTel;//属于警察电话
    private String belongToPoliceDepart;//属于警察出发
    private String policeStatioTel;//警察Statio电话
    private String personAttrType;//人员属性类型
    private String personFlowId;//流动信息主键Id
    private String userId;//用户名
    private String tempLivePlace;//临时住所
    private String tempLiveArea;//临时实时区域
    private String tempLiveAddress;//临时实时地址
    private String tempLiveReason;//临时生活理由
    private String planLiveTime;//拟居住时间 (格式：yyyyMMdd)//计划Live Time; //拟居住时间（格式：yyyyMMdd）
    private String flowInTime;//流入时间
    private String flowOutTime;//流出时间
    private String logoutTag;//注销标签

    public String getPersonId() {
        return personId;
    }

    public void setRegionalismName(String regionalismName) {
        this.regionalismName = regionalismName;
    }

    public String getRegionalismName() {

        return regionalismName;
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

    public String getSpecialHousehold() {
        return specialHousehold;
    }

    public void setSpecialHousehold(String specialHousehold) {
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
    public void setTempLiveReasonDesc(String tempLiveReasonDesc) {
        this.tempLiveReasonDesc = tempLiveReasonDesc;
    }

    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    public void setRegisterMobile(String registerMobile) {
        this.registerMobile = registerMobile;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public void setBelongToPoliceId(String belongToPoliceId) {
        this.belongToPoliceId = belongToPoliceId;
    }

    public String getTempLiveReasonDesc() {

        return tempLiveReasonDesc;
    }

    public String getRegisterUser() {
        return registerUser;
    }

    public String getRegisterMobile() {
        return registerMobile;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public String getBelongToPoliceId() {
        return belongToPoliceId;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    public String getCareers() {
        return careers;
    }

    public void setCareers(String careers) {
        this.careers = careers;
    }

    public String getCareersName() {
        return careersName;
    }

    public void setCareersName(String careersName) {
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

    public String getHouseholdAreaTel() {
        return householdAreaTel;
    }

    public void setHouseholdAreaTel(String householdAreaTel) {
        this.householdAreaTel = householdAreaTel;
    }

    public String getHouseholdAreaPolice() {
        return householdAreaPolice;
    }

    public void setHouseholdAreaPolice(String householdAreaPolice) {
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

    public String getCommunityTel() {
        return communityTel;
    }

    public void setCommunityTel(String communityTel) {
        this.communityTel = communityTel;
    }

    public String getCommunityStaff() {
        return communityStaff;
    }

    public void setCommunityStaff(String communityStaff) {
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

    public String getRegisterOrganize() {
        return registerOrganize;
    }

    public void setRegisterOrganize(String registerOrganize) {
        this.registerOrganize = registerOrganize;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getHouseholdPoliceStation() {
        return householdPoliceStation;
    }

    public void setHouseholdPoliceStation(String householdPoliceStation) {
        this.householdPoliceStation = householdPoliceStation;
    }

    public String getBelongToPolice() {
        return belongToPolice;
    }

    public void setBelongToPolice(String belongToPolice) {
        this.belongToPolice = belongToPolice;
    }

    public String getBelongToPoliceTel() {
        return belongToPoliceTel;
    }

    public void setBelongToPoliceTel(String belongToPoliceTel) {
        this.belongToPoliceTel = belongToPoliceTel;
    }

    public String getBelongToPoliceDepart() {
        return belongToPoliceDepart;
    }

    public void setBelongToPoliceDepart(String belongToPoliceDepart) {
        this.belongToPoliceDepart = belongToPoliceDepart;
    }

    public String getPoliceStatioTel() {
        return policeStatioTel;
    }

    public void setPoliceStatioTel(String policeStatioTel) {
        this.policeStatioTel = policeStatioTel;
    }

    public String getPersonFlowId() {
        return personFlowId;
    }

    public void setPersonFlowId(String personFlowId) {
        this.personFlowId = personFlowId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTempLivePlace() {
        return tempLivePlace;
    }

    public void setTempLivePlace(String tempLivePlace) {
        this.tempLivePlace = tempLivePlace;
    }

    public String getTempLiveArea() {
        return tempLiveArea;
    }

    public void setTempLiveArea(String tempLiveArea) {
        this.tempLiveArea = tempLiveArea;
    }

    public String getTempLiveAddress() {
        return tempLiveAddress;
    }

    public void setTempLiveAddress(String tempLiveAddress) {
        this.tempLiveAddress = tempLiveAddress;
    }

    public String getTempLiveReason() {
        return tempLiveReason;
    }

    public void setTempLiveReason(String tempLiveReason) {
        this.tempLiveReason = tempLiveReason;
    }

    public String getPlanLiveTime() {
        return planLiveTime;
    }

    public void setPlanLiveTime(String planLiveTime) {
        this.planLiveTime = planLiveTime;
    }

    public String getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }

    public String getFlowOutTime() {
        return flowOutTime;
    }

    public void setFlowOutTime(String flowOutTime) {
        this.flowOutTime = flowOutTime;
    }

    public String getLogoutTag() {
        return logoutTag;
    }

    public void setLogoutTag(String logoutTag) {
        this.logoutTag = logoutTag;
    }

    public String getPersonAttrType() {
        return personAttrType;
    }

    public void setPersonAttrType(String personAttrType) {
        this.personAttrType = personAttrType;
    }
}
