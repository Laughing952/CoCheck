package com.unistrong.business.bean;

/**
 * Created by Water on 2018/4/10.
 */

public class Action {

    private int actionID;
    private String actionName;
    private int res;

    public Action(int actionID, String actionName, int res) {
        this.actionID = actionID;
        this.actionName = actionName;
        this.res = res;
    }

    public int getActionID() {
        return actionID;
    }

    public void setActionID(int actionID) {
        this.actionID = actionID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
