package com.unistrong.home.bean;

import com.commondata.bean.PersonBean;

import java.util.List;

/**
 * Created by kb.zhang on 2018/4/14.
 */

public class PersonListBean {

    /**
     * person : {"personId":"501R6501095611080100006","householdNum":"652122209004156","householdType":"2","specialHousehold":null,"householdRelation":"户主","idNum":"652122192710053736","name":"买明·买提依明","sex":"1","nation":"维吾尔","birthday":"19271005","height":"176","weight":null,"bloodType":"3","eduLevel":"小学","marriageStatus":"已婚","politicalStatus":"群众","workPlace":"吐峪沟乡泽日甫坎村四组","careers":null,"national":"中国","tel":"18196058015","regionalism":"652122","householdAddress":"吐峪沟乡泽日甫坎儿孜村4组117号","householdArea":"鄯善县公安局吐峪沟派出所泽日甫警务室","householdAreaTel":null,"householdAreaPolice":null,"communityCode":"鄯善县吐峪沟乡泽日甫坎儿孜村","communityTel":null,"communityStaff":null,"personType":"2","personAttr":"22,99","registerOrganize":null,"registerDate":null,"householdPoliceStation":"650000400000","belongToPolice":null,"belongToPoliceTel":null,"belongToPoliceDepart":"新疆公安厅特警总队"}
     * familyList : [{"personId":"501R6501095611080100006","householdNum":"652122209004156","householdType":"2","specialHousehold":null,"householdRelation":"户主","idNum":"652122192710053736","name":"买明·买提依明","sex":"1","nation":"维吾尔","birthday":"19271005","height":"176","weight":null,"bloodType":"3","eduLevel":"小学","marriageStatus":"已婚","politicalStatus":"群众","workPlace":"吐峪沟乡泽日甫坎村四组","careers":null,"national":"中国","tel":"18196058015","regionalism":"652122","householdAddress":"吐峪沟乡泽日甫坎儿孜村4组117号","householdArea":"鄯善县公安局吐峪沟派出所泽日甫警务室","householdAreaTel":null,"householdAreaPolice":null,"communityCode":"鄯善县吐峪沟乡泽日甫坎儿孜村","communityTel":null,"communityStaff":null,"personType":"2","personAttr":"100000000000000000000000000000000000000000000000000000000000","registerOrganize":null,"registerDate":null,"householdPoliceStation":"650000400000","belongToPolice":null,"belongToPoliceTel":null,"belongToPoliceDepart":"新疆公安厅特警总队"}]
     * coupleList : []
     * flowList : [{"personFlowId":null,"userId":null,"person":null,"idNum":"652122192710053736","tempLivePlace":null,"registerDate":"2345","tempLiveArea":null,"tempLiveAddress":"天山是","tempLiveReason":"1","planLiveTime":"1","work":"程序员","flowInTime":"","flowOutTime":null,"logoutTag":null,"personImg":null,"registerDateStart":null,"registerDateEnd":null,"sex":"1","nation":"维吾尔","birthday":"19271005","regionalism":"652122","personAttr":"100000000000000000000000000000000000000000000000000000000000","eduLevel":"小学"}]
     * jailedList : [{"jailedPerson":"阿地力江・阿布力孜","jailedDate":"20140826125207","holidayStatus":"3","persoType":"红名单"}]
     * crimeList : []
     */

    private PersonBean person;
    private List<FamilyListBean> familyList;
    private List<CoupleListBean> coupleList;
    private List<FlowListBean> flowList;
    private List<JailedListBean> jailedList;
    private List<?> crimeList;

    public PersonBean getPerson() {
        return person;
    }

    public void setPerson(PersonBean person) {
        this.person = person;
    }

    public List<FamilyListBean> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<FamilyListBean> familyList) {
        this.familyList = familyList;
    }

    public List<?> getCoupleList() {
        return coupleList;
    }

    public void setCoupleList(List<CoupleListBean> coupleListBean) {
        this.coupleList = coupleListBean;
    }

    public List<FlowListBean> getFlowList() {
        return flowList;
    }

    public void setFlowList(List<FlowListBean> flowList) {
        this.flowList = flowList;
    }

    public List<JailedListBean> getJailedList() {
        return jailedList;
    }

    public void setJailedList(List<JailedListBean> jailedList) {
        this.jailedList = jailedList;
    }

    public List<?> getCrimeList() {
        return crimeList;
    }

    public void setCrimeList(List<?> crimeList) {
        this.crimeList = crimeList;
    }

}
