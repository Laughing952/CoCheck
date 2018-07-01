package com.unistrong.business.bean;

/**
 * 流动人口编辑实体类
 * 作者：Laughing on 2018/4/22 16:47
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleEditReq {

    private String idNum;//
    private String name;//
    private String sex;//

    private String flowInTime;//流入日期（格式：yyyyMMdd）
    private String personFlowId;//流动信息主键Id
    private String planLiveTime;//拟居住时间code（参考字典编码：2929）
    private String registerMobile;//登记人联系方式
    private String tempLiveAddress;//暂居住址的详细地址
    private String tempLiveArea;//暂居地省市县区code（参考字典城市列表）
    private String tempLivePlace;//暂居住处所code（参考字典编码：2940）
    private String tempLiveReason;//居住事由code（参考字典编码：222167）
    private String work;//工作

    public String getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }

    public String getPersonFlowId() {
        return personFlowId;
    }

    public void setPersonFlowId(String personFlowId) {
        this.personFlowId = personFlowId;
    }

    public String getPlanLiveTime() {
        return planLiveTime;
    }

    public void setPlanLiveTime(String planLiveTime) {
        this.planLiveTime = planLiveTime;
    }

    public String getRegisterMobile() {
        return registerMobile;
    }

    public void setRegisterMobile(String registerMobile) {
        this.registerMobile = registerMobile;
    }

    public String getTempLiveAddress() {
        return tempLiveAddress;
    }

    public void setTempLiveAddress(String tempLiveAddress) {
        this.tempLiveAddress = tempLiveAddress;
    }

    public String getTempLiveArea() {
        return tempLiveArea;
    }

    public void setTempLiveArea(String tempLiveArea) {
        this.tempLiveArea = tempLiveArea;
    }

    public String getTempLivePlace() {
        return tempLivePlace;
    }

    public void setTempLivePlace(String tempLivePlace) {
        this.tempLivePlace = tempLivePlace;
    }

    public String getTempLiveReason() {
        return tempLiveReason;
    }

    public void setTempLiveReason(String tempLiveReason) {
        this.tempLiveReason = tempLiveReason;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
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
}
