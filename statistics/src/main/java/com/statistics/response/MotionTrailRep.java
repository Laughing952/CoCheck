package com.statistics.response;

/**
 * 疆外活动轨迹
 * Created by Water on 2018/4/18.
 */

public class MotionTrailRep {

    private String personId; // 人员编号，人员信息主键Id
    private String householdNum; // 户号code
    private String householdType; // 户口类别code
    private String specialHousehold; // 特殊户口code: 1:(蔬菜业); 2:(畜牧业); 3:(渔业); 4:(林业)
    private String householdRelation; // 与户主关系 code
    private String householdRelationName; // 与户主关系名称
    private String idNum; // 公民身份号码
    private String name; // 姓名
    private String sex; // 性别code： 0:未知的性别; 1:男; 2:女; 3:女性改（变）为男性; 4:男性改（变）为女性;9:未说明的性别
    private String nation; // 民族code
    private String nationName; // 民族名称
    private String birthday; // 出生日期 (格式：yyyyMMdd)
    private String height; // 身高
    private String weight; // 体重
    private String bloodType; // 血型code：0:未知; 1:A型; 2:B型; 3:O型; 4:AB型; 9:其他
    private String eduLevel; // 文化程度code
    private String eduLevelName; // 文化程度名称
    private String marriageStatus; // 婚姻状况code: 90：未说明的婚姻状况; 10: 未婚; 20:已婚; 21:初婚; 22:再婚; 23: 复婚; 30:丧偶; 40:离婚
    private String politicalStatus; // 政治面貌code
    private String politicalStatusName; // 政治面貌名称
    private String workPlace; // 服务处所
    private String careers; // 职业code
    private String careersName; // 职业名称
    private String national;
    private String nationalName; // 国籍名称
    private String tel; // 联系电话
    private String regionalism; // 行政区划code
    private String householdAddress; // (户籍)详址
    private String householdArea; // 户籍责任区code
    private String householdAreaName; // 户籍责任区名称
    private String householdAreaTel; // 户籍责任区电话
    private String householdAreaPolice; // 户籍责任区民警
    private String communityCode; // 社区单位code
    private String communityName; // 社区单位名称
    private String communityTel; // 社区单位电话
    private String communityStaff; // 社区单位工作人员
    private String personType; // 人员类别code：1:常住人口; 2: 流动人口; 3:境外常住人口; 4:流动人口; 5:未落常住人口; 6:寄住人口; 7:临时住宿人口; 9:其他
    private String personAttr; // 人员属性code(人员具有多属性): 99:其他,21:涉恐人员, 22:涉稳人员, 23:涉毒人员, 24:在逃人员, 25:违法犯罪人员, 26:重点上访人员, 27:重症精神病人, 28:重点人口
    private String registerOrganize; // 登记地址
    private String registerDate; // 登记日期 (格式：yyyyMMdd)
    private String householdPoliceStation; // 户籍地派出所code
    private String belongToPolice; // 人员归属警察(接收人)
    private String belongToPoliceTel; // 人员归属警察电话(接收人联系方式)
    private String belongToPoliceDepart; // 人员归属警察单位(接收人单位)
    private String policeStatioTel; // 警务室民警联系电话
    private String photoUrl; // 身份证照片地址，需要使用项目 Base URL + photoUrl 方可访问
    private String personAttrType; // 人员属性类别（1：一般人员，2：白名单，3：红名单）
    private String personFlowId; // 流动信息主键Id
    private String userId; // 操作人ID，关联用户主键
    private String tempLivePlace; // 暂居住处所
    private String tempLiveArea; // 暂居地（省市县区）code
    private String tempLiveAddress; // 暂居住址的详细地址|登记页面需要输入’
    private String tempLiveReason; // 居住事由code
    private String tempLiveReasonDesc; // 居住事由描述
    private String planLiveTime; // 拟居住时间 (格式：yyyyMMdd)
    private String flowInTime; // 流入时间 (格式：yyyyMMdd)
    private String flowOutTime; // 流出时间 (格式：yyyyMMdd)
    private String logoutTag; // 注销标记 1:表示注销 2:表示未注销 3:表示还原
    private String officeCode; // 单位代码
    private String username; // 用户名

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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPersonAttrType() {
        return personAttrType;
    }

    public void setPersonAttrType(String personAttrType) {
        this.personAttrType = personAttrType;
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

    public String getTempLiveReasonDesc() {
        return tempLiveReasonDesc;
    }

    public void setTempLiveReasonDesc(String tempLiveReasonDesc) {
        this.tempLiveReasonDesc = tempLiveReasonDesc;
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

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
