package com.unistrong.home.bean;

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

    private String briefCase;
    private String caseName;
    private String crimeDate;
    private String crimePlace;

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
