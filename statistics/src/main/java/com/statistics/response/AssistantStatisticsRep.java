package com.statistics.response;

/**
 * 统计
 * Created by Water on 2018/4/20.
 */
public class AssistantStatisticsRep {

    private String total; //  人口总数
    private String cityCode; //  行政区划code
    private String cityName; // 行政区划名称
    private String checkCount; //协查数
    private String todayCheckCount; //协查数
    private String cityWlmq; // 反馈单位：乌鲁木齐
    private String cityKs; // 反馈单位：喀什
    private String cityHt; // 反馈单位：和田
    private String cityAks; // 反馈单位：阿克苏
    private String cityBz; // 反馈单位：巴州
    private String cityHm; // 反馈单位：哈密
    private String cityOther; // 反馈单位：其他
    private String terrorist; // 人员属性：涉恐人员数
    private String stabilized; // 人员属性：涉稳人员数
    private String drugst; // 人员属性：涉毒人员数
    private String fugitive; // 人员属性：在逃人员数
    private String crimet; // 人员属性：违法犯罪人员数
    private String focusTarget; // 人员属性：重点上访数
    private String mentalPatients; // 人员属性：重症精神病人数
    private String priorityPopulation; // 人员属性：重点人口数
    private String otherAtrr; // 人员属性：其他关注群体数
    private String feedbackIn3Day; // 反馈-协查间隔3日内
    private String feedbackOut3Day; // 反馈-协查间隔3日外
    private String notFeedback; // 未反馈数
    private String male; // 男性
    private String female; // 女性

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCheckCount() {
        return checkCount;
    }

    public String getTodayCheckCount() {
        return todayCheckCount;
    }

    public void setTodayCheckCount(String todayCheckCount) {
        this.todayCheckCount = todayCheckCount;
    }

    public void setCheckCount(String checkCount) {
        this.checkCount = checkCount;
    }

    public String getCityWlmq() {
        return cityWlmq;
    }

    public void setCityWlmq(String cityWlmq) {
        this.cityWlmq = cityWlmq;
    }

    public String getCityKs() {
        return cityKs;
    }

    public void setCityKs(String cityKs) {
        this.cityKs = cityKs;
    }

    public String getCityHt() {
        return cityHt;
    }

    public void setCityHt(String cityHt) {
        this.cityHt = cityHt;
    }

    public String getCityAks() {
        return cityAks;
    }

    public void setCityAks(String cityAks) {
        this.cityAks = cityAks;
    }

    public String getCityBz() {
        return cityBz;
    }

    public void setCityBz(String cityBz) {
        this.cityBz = cityBz;
    }

    public String getCityHm() {
        return cityHm;
    }

    public void setCityHm(String cityHm) {
        this.cityHm = cityHm;
    }

    public String getCityOther() {
        return cityOther;
    }

    public void setCityOther(String cityOther) {
        this.cityOther = cityOther;
    }

    public String getTerrorist() {
        return terrorist;
    }

    public void setTerrorist(String terrorist) {
        this.terrorist = terrorist;
    }

    public String getStabilized() {
        return stabilized;
    }

    public void setStabilized(String stabilized) {
        this.stabilized = stabilized;
    }

    public String getDrugst() {
        return drugst;
    }

    public void setDrugst(String drugst) {
        this.drugst = drugst;
    }

    public String getFugitive() {
        return fugitive;
    }

    public void setFugitive(String fugitive) {
        this.fugitive = fugitive;
    }

    public String getCrimet() {
        return crimet;
    }

    public void setCrimet(String crimet) {
        this.crimet = crimet;
    }

    public String getFocusTarget() {
        return focusTarget;
    }

    public void setFocusTarget(String focusTarget) {
        this.focusTarget = focusTarget;
    }

    public String getMentalPatients() {
        return mentalPatients;
    }

    public void setMentalPatients(String mentalPatients) {
        this.mentalPatients = mentalPatients;
    }

    public String getPriorityPopulation() {
        return priorityPopulation;
    }

    public void setPriorityPopulation(String priorityPopulation) {
        this.priorityPopulation = priorityPopulation;
    }

    public String getOtherAtrr() {
        return otherAtrr;
    }

    public void setOtherAtrr(String otherAtrr) {
        this.otherAtrr = otherAtrr;
    }

    public String getFeedbackIn3Day() {
        return feedbackIn3Day;
    }

    public void setFeedbackIn3Day(String feedbackIn3Day) {
        this.feedbackIn3Day = feedbackIn3Day;
    }

    public String getFeedbackOut3Day() {
        return feedbackOut3Day;
    }

    public void setFeedbackOut3Day(String feedbackOut3Day) {
        this.feedbackOut3Day = feedbackOut3Day;
    }

    public String getNotFeedback() {
        return notFeedback;
    }

    public void setNotFeedback(String notFeedback) {
        this.notFeedback = notFeedback;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }
}
