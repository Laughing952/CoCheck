package com.statistics.ui.viewmodel;

import com.statistics.R;
import com.statistics.response.TodayStatisticsRep;
import com.waterbase.utile.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据统计
 * Created by Water on 2018/4/11.
 */

public class TodayStatisticsViewModel {

    private String registerNum; // 登记数
    private String logoutNum; // 注销数
    private String assistantNum; // 协查数
    private String feedbackNum; // 反馈数

    private int registerRes; // 登记的走势图标
    private int logoutRes; // 注销的走势图标
    private int assistantRes; // 协查的走势图标
    private int feedbackRes; // 反馈的走势图标

    private List<Float> registerYList; // 登记统计的Y轴数据
    private List<Float> logoutYList; // 注销统计的Y轴数据
    private List<Float> assistantYList; // 协查统计的Y轴数据
    private List<Float> feedbackYList; // 反馈统计的Y轴数据

    private int registerColor;
    private int logoutColor;
    private int assistantColor;
    private int feedbackColor;

    private List<String> lineXList; // 折线图的X轴数据
    private List<List<Float>> lineYList; // 折线图的Y轴数据
    private List<String> lineNameList; // 折线图的名称数据
    private List<Integer> lineColorList; // 折线图的颜色数据

    private TodayStatisticsRep todayStatisticsRep;

    public TodayStatisticsViewModel(TodayStatisticsRep todayStatisticsRep) {
        this.todayStatisticsRep = todayStatisticsRep;
    }

    public String getRegisterNum() {
        return String.valueOf(todayStatisticsRep.getTodayRegistPersonTotal().getTodayRegistTotal());
    }

    public String getLogoutNum() {
        return String.valueOf(todayStatisticsRep.getTodayLogoutPersonTotal().getTodayLogoutTotal());
    }

    public String getAssistantNum() {
        return String.valueOf(todayStatisticsRep.getTodayCheckPersonTotal().getTodayCheckTotal());
    }

    public String getFeedbackNum() {
        return String.valueOf(todayStatisticsRep.getTodayFeedBackPersonTotal().getTodayFeedbackTotal());
    }

    public int getRegisterRes() {
        return R.mipmap.ic_statistics_up;
    }

    public int getLogoutRes() {
        return R.mipmap.ic_statistics_down;
    }

    public int getAssistantRes() {
        return R.mipmap.ic_statistics_up;
    }

    public int getFeedbackRes() {
        return R.mipmap.ic_statistics_down;
    }

    public List<Float> getRegisterYList() {
        registerYList = new ArrayList<>();
//        for (TodayStatisticsRep.CheckListBean checkListBean : todayStatisticsRep.getCheckTotal().getRegistList()) {
//            registerYList.add((float) checkListBean.getTotal());
//        }
        for (int j = 0; j < 10; j++) {
            float value = (float) (Math.random() * 100) + 3;
            registerYList.add(value);
        }
        return registerYList;
    }

    public List<Float> getLogoutYList() {
        logoutYList = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            float value = (float) (Math.random() * 100) + 3;
            logoutYList.add(value);
        }
        return logoutYList;
    }

    public List<Float> getAssistantYList() {
        assistantYList = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            float value = (float) (Math.random() * 100) + 3;
            assistantYList.add(value);
        }
        return assistantYList;
    }

    public List<Float> getFeedbackYList() {
        feedbackYList = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            float value = (float) (Math.random() * 100) + 3;
            feedbackYList.add(value);
        }
        return feedbackYList;
    }

    public int getRegisterColor() {
        return R.color.blue;
    }

    public int getLogoutColor() {
        return R.color.red;
    }

    public int getAssistantColor() {
        return R.color.greenButton;
    }

    public int getFeedbackColor() {
        return R.color.pink;
    }

    public List<String> getLineXList() {
        lineXList = new ArrayList<>();
        for (TodayStatisticsRep.CheckListBean checkListBean : todayStatisticsRep.getCheckTotal().getCheckList()) {
            lineXList.add(DateUtil.getStringByFormat(checkListBean.getSomeDay(), "yyyyMMdd", "MM-dd"));
        }
        return lineXList;
    }

    public List<List<Float>> getLineYList() {
        lineYList = new ArrayList<>();
        ArrayList<Float> yValues1 = new ArrayList<>();
        for (TodayStatisticsRep.CheckListBean checkListBean : todayStatisticsRep.getCheckTotal().getRegistList()) {
            yValues1.add((float) checkListBean.getTotal());
        }
        while (yValues1.size() < 7) {
            yValues1.add(0f);
        }
        lineYList.add(yValues1);
        ArrayList<Float> yValues2 = new ArrayList<>();
        for (TodayStatisticsRep.CheckListBean checkListBean : todayStatisticsRep.getCheckTotal().getLogoutList()) {
            yValues2.add((float) checkListBean.getTotal());
        }
        while (yValues2.size() < 7) {
            yValues2.add(0f);
        }
        lineYList.add(yValues2);
        ArrayList<Float> yValues3 = new ArrayList<>();
        for (TodayStatisticsRep.CheckListBean checkListBean : todayStatisticsRep.getCheckTotal().getCheckList()) {
            yValues3.add((float) checkListBean.getTotal());
        }
        while (yValues3.size() < 7) {
            yValues3.add(0f);
        }
        lineYList.add(yValues3);
        ArrayList<Float> yValues4 = new ArrayList<>();
        for (TodayStatisticsRep.CheckListBean checkListBean : todayStatisticsRep.getCheckTotal().getFeedbackList()) {
            yValues4.add((float) checkListBean.getTotal());
        }
        while (yValues4.size() < 7) {
            yValues4.add(0f);
        }
        lineYList.add(yValues4);
        return lineYList;
    }

    public List<String> getLineNameList() {
        lineNameList = new ArrayList<>();
        lineNameList.add("登记数");
        lineNameList.add("注销数");
        lineNameList.add("协查数");
        lineNameList.add("反馈数");
        return lineNameList;
    }

    public List<Integer> getLineColorList() {
        lineColorList = new ArrayList<>();
        lineColorList.add(R.color.blue);
        lineColorList.add(R.color.red);
        lineColorList.add(R.color.greenButton);
        lineColorList.add(R.color.pink);
        return lineColorList;
    }
}
