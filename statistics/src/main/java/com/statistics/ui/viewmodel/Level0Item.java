package com.statistics.ui.viewmodel;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.statistics.ui.adapter.ExpandableItemAdapter;

/**
 * 统计中的头布局
 * Created by Water on 2018/4/11.
 */

public class Level0Item implements MultiItemEntity {

    private String statistics1;
    private String statistics2;
    private String todayNum;
    private String sumNum;
    private int index;

     public Level0Item(String statistics1, String statistics2, String todayNum, String sumNum,int index) {
        this.statistics1 = statistics1;
        this.statistics2 = statistics2;
        this.todayNum = todayNum;
        this.sumNum = sumNum;
        this.index = index;
    }


    public String getStatistics1() {
        return statistics1;
    }

    public void setStatistics1(String statistics1) {
        this.statistics1 = statistics1;
    }

    public String getStatistics2() {
        return statistics2;
    }

    public void setStatistics2(String statistics2) {
        this.statistics2 = statistics2;
    }

    public void setTodayNum(String todayNum) {
        this.todayNum = todayNum;
    }

    public void setSumNum(String sumNum) {
        this.sumNum = sumNum;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }

    public String getTodayNum() {
        return todayNum;
    }

    public String getSumNum() {
        return sumNum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
