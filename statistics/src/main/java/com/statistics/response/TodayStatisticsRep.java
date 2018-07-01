package com.statistics.response;

import java.util.List;

/**
 * Created by Water on 2018/4/21.
 */

public class TodayStatisticsRep {

    private RegistPerson todayRegistPersonTotal; // 人口登记数汇总
    private CheckPerson todayCheckPersonTotal; //  协查数统计
    private FeedBackPerson todayFeedBackPersonTotal; // 反馈数统计
    private LogoutPerson todayLogoutPersonTotal; // 注销数统计

    private CheckTotal checkTotal; // 统计分析-协查统计 15天内

    public RegistPerson getTodayRegistPersonTotal() {
        return todayRegistPersonTotal;
    }

    public void setTodayRegistPersonTotal(RegistPerson todayRegistPersonTotal) {
        this.todayRegistPersonTotal = todayRegistPersonTotal;
    }

    public CheckPerson getTodayCheckPersonTotal() {
        return todayCheckPersonTotal;
    }

    public void setTodayCheckPersonTotal(CheckPerson todayCheckPersonTotal) {
        this.todayCheckPersonTotal = todayCheckPersonTotal;
    }

    public FeedBackPerson getTodayFeedBackPersonTotal() {
        return todayFeedBackPersonTotal;
    }

    public void setTodayFeedBackPersonTotal(FeedBackPerson todayFeedBackPersonTotal) {
        this.todayFeedBackPersonTotal = todayFeedBackPersonTotal;
    }

    public LogoutPerson getTodayLogoutPersonTotal() {
        return todayLogoutPersonTotal;
    }

    public void setTodayLogoutPersonTotal(LogoutPerson todayLogoutPersonTotal) {
        this.todayLogoutPersonTotal = todayLogoutPersonTotal;
    }

    public CheckTotal getCheckTotal() {
        return checkTotal;
    }

    public void setCheckTotal(CheckTotal checkTotal) {
        this.checkTotal = checkTotal;
    }

    public class CheckTotal {

        private List<CheckListBean> registList;
        private List<CheckListBean> logoutList;
        private List<CheckListBean> checkList;
        private List<CheckListBean> feedbackList;

        public List<CheckListBean> getRegistList() {
            return registList;
        }

        public void setRegistList(List<CheckListBean> registList) {
            this.registList = registList;
        }

        public List<CheckListBean> getLogoutList() {
            return logoutList;
        }

        public void setLogoutList(List<CheckListBean> logoutList) {
            this.logoutList = logoutList;
        }

        public List<CheckListBean> getCheckList() {
            return checkList;
        }

        public void setCheckList(List<CheckListBean> checkList) {
            this.checkList = checkList;
        }

        public List<CheckListBean> getFeedbackList() {
            return feedbackList;
        }

        public void setFeedbackList(List<CheckListBean> feedbackList) {
            this.feedbackList = feedbackList;
        }


    }

    /**
     * 统计分析-反馈结果bean，横坐标是时间，纵坐标是数量
     */
    public class CheckListBean {

        private String someDay; // 某天
        private String type;
        private int total; // 反馈数

        public String getSomeDay() {
            return someDay;
        }

        public void setSomeDay(String someDay) {
            this.someDay = someDay;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    /**
     * 人口登记数汇总
     */
    public class RegistPerson {
        private int allRegistTotal; //累计登记总数
        private int todayRegistTotal; //今日登记数

        public int getAllRegistTotal() {
            return allRegistTotal;
        }

        public void setAllRegistTotal(int allRegistTotal) {
            this.allRegistTotal = allRegistTotal;
        }

        public int getTodayRegistTotal() {
            return todayRegistTotal;
        }

        public void setTodayRegistTotal(int todayRegistTotal) {
            this.todayRegistTotal = todayRegistTotal;
        }
    }

    /**
     * 反馈数统计
     */
    public class FeedBackPerson {
        private int allFeedbackTotal; //累计反馈总数
        private int todayFeedbackTotal; //今日反馈数

        public int getAllFeedbackTotal() {
            return allFeedbackTotal;
        }

        public void setAllFeedbackTotal(int allFeedbackTotal) {
            this.allFeedbackTotal = allFeedbackTotal;
        }

        public int getTodayFeedbackTotal() {
            return todayFeedbackTotal;
        }

        public void setTodayFeedbackTotal(int todayFeedbackTotal) {
            this.todayFeedbackTotal = todayFeedbackTotal;
        }
    }

    /**
     * 注销数统计
     */
    public class LogoutPerson {
        private int allLogoutTotal; //累计注销数
        private int todayLogoutTotal; //今日注销数

        public int getAllLogoutTotal() {
            return allLogoutTotal;
        }

        public void setAllLogoutTotal(int allLogoutTotal) {
            this.allLogoutTotal = allLogoutTotal;
        }

        public int getTodayLogoutTotal() {
            return todayLogoutTotal;
        }

        public void setTodayLogoutTotal(int todayLogoutTotal) {
            this.todayLogoutTotal = todayLogoutTotal;
        }
    }

    /**
     * 协查数统计
     */
    public class CheckPerson{
        private int allCheckTotal; //累计协查数
        private int todayCheckTotal; //今日协查数

        public int getAllCheckTotal() {
            return allCheckTotal;
        }

        public void setAllCheckTotal(int allCheckTotal) {
            this.allCheckTotal = allCheckTotal;
        }

        public int getTodayCheckTotal() {
            return todayCheckTotal;
        }

        public void setTodayCheckTotal(int todayCheckTotal) {
            this.todayCheckTotal = todayCheckTotal;
        }
    }
}
