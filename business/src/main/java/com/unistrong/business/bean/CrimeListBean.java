package com.unistrong.business.bean;

/**
 * 犯罪记录实体类
 * Created by kb.zhang on 2018/4/14.
 */

public class CrimeListBean {

    /**
     * briefCase : string
     * caseName : string
     * crimeDate : string
     * crimePlace : string
     */

    private String briefCase;//简介案例
    private String caseName;//案例名称
    private String crimeDate;//犯罪日期
    private String crimePlace;//犯罪地点

    public String getBriefCase() {
        return briefCase;
    }

    public void setBriefCase(String briefCase) {
        this.briefCase = briefCase;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(String crimeDate) {
        this.crimeDate = crimeDate;
    }

    public String getCrimePlace() {
        return crimePlace;
    }

    public void setCrimePlace(String crimePlace) {
        this.crimePlace = crimePlace;
    }
}
