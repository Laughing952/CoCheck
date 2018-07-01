package com.statistics.response;

/**
 * 涉案信息
 * Created by Water on 2018/4/18.
 */

public class InvolvedInfoRep {

    private String briefCase; // 简要案情
    private String caseName; // 案件名称
    private String crimeDate; // 发按时间
    private String crimePlace; // 发按地址

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
