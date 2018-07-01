package com.statistics.ui.viewmodel;

import com.statistics.response.InvolvedInfoRep;

/**
 * 涉案信息
 * Created by Water on 2018/4/17.
 */

public class InvolvedInfoViewModel {

    private InvolvedInfoRep involvedInfoRep;

    private String idCardNum; // 身份证号
    private String caseName; // 涉案名称
    private String caseInfo; // 案情简要
    private String caseDate; // 发案时间
    private String caseAddress; // 发案地点


    public InvolvedInfoViewModel(InvolvedInfoRep involvedInfoRep) {
        this.involvedInfoRep = involvedInfoRep;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public String getCaseName() {
        return involvedInfoRep.getCaseName();
    }

    public String getCaseInfo() {
        return involvedInfoRep.getBriefCase();
    }

    public String getCaseDate() {
        return involvedInfoRep.getCrimeDate();
    }

    public String getCaseAddress() {
        return involvedInfoRep.getCrimePlace();
    }
}
