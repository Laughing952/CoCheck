package com.unistrong.business.bean;

/**
 * 根据查询参数组合查询流动列表
 * 作者：Laughing on 2018/4/22 18:58
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleHistoryReq {
    private String currentPage;//当前页
    private String pageSize;//每页显示的总条数
    private String idNum;//身份证号
    private String name;//姓名
    private String sex;//性别
    private String nation;//民族
    private String logoutTag;//注销标签是否注销code( 1:注销，2:未注销，3:还原)
    private String registerDateStart;//始登记日期起,(格式 yyyyMMdd)
    private String registerDateEnd;//登记日期止,(格式 yyyyMMdd)
    private String personAttr;//人员属性code，参考Person.personAttr

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
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

    public String getLogoutTag() {
        return logoutTag;
    }

    public void setLogoutTag(String logoutTag) {
        this.logoutTag = logoutTag;
    }

    public String getRegisterDateStart() {
        return registerDateStart;
    }

    public void setRegisterDateStart(String registerDateStart) {
        this.registerDateStart = registerDateStart;
    }

    public String getRegisterDateEnd() {
        return registerDateEnd;
    }

    public void setRegisterDateEnd(String registerDateEnd) {
        this.registerDateEnd = registerDateEnd;
    }

    public String getPersonAttr() {
        return personAttr;
    }

    public void setPersonAttr(String personAttr) {
        this.personAttr = personAttr;
    }
}
