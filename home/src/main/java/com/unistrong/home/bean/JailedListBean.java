package com.unistrong.home.bean;

/**
 * 列管实体类
 * Created by kb.zhang on 2018/4/14.
 */

public class JailedListBean {
    /**
     * jailedPerson : 阿地力江・阿布力孜
     * jailedDate : 20140826125207
     * holidayStatus : 3
     * persoType : 红名单
     */

    private String jailedPerson;
    private String jailedDate;
    private String holidayStatus;
    private String persoType;

    public String getJailedPerson() {
        return jailedPerson;
    }

    public void setJailedPerson(String jailedPerson) {
        this.jailedPerson = jailedPerson;
    }

    public String getJailedDate() {
        return jailedDate;
    }

    public void setJailedDate(String jailedDate) {
        this.jailedDate = jailedDate;
    }

    public String getHolidayStatus() {
        return holidayStatus;
    }

    public void setHolidayStatus(String holidayStatus) {
        this.holidayStatus = holidayStatus;
    }

    public String getPersoType() {
        return persoType;
    }

    public void setPersoType(String persoType) {
        this.persoType = persoType;
    }
}
