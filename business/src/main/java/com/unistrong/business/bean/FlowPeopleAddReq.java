package com.unistrong.business.bean;

/**
 * Created by edz on 2018/4/19.
 */

public class FlowPeopleAddReq {

    /**
     * flowInTime : string
     * idNum : string
     * planLiveTime : string
     * registerMobile : string
     * tempLiveAddress : string
     * tempLiveArea : string
     * tempLivePlace : string
     * tempLiveReason : string
     * work : string
     */

    private String flowInTime;//流入日期
    private String idNum;//人员身份证号
    private String planLiveTime;//拟居住时间
    private String registerMobile;//登记人联系方式
    private String tempLiveAddress;//暂居住址的详细地址
    private String tempLiveArea;//暂居地省市县区
    private String tempLivePlace;//暂居住处所
    private String tempLiveReason;//居住事由
    private String work;//从事职业

    public String getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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
}
