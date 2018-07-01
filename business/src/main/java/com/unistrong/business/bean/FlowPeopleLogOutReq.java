package com.unistrong.business.bean;

import java.util.ArrayList;

/**
 * 流动人口注销（需要传递的参数实体类）
 * 作者：Laughing on 2018/4/21 16:36
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleLogOutReq {
    private ArrayList<String> personFlowId;//流动人员IDs
    private String logoutTag;//注销标签

    public FlowPeopleLogOutReq(ArrayList<String> personFlowId, String logoutTag) {
        this.personFlowId = personFlowId;
        this.logoutTag = logoutTag;
    }

    public String getLogoutTag() {
        return logoutTag;
    }

    public void setLogoutTag(String logoutTag) {
        this.logoutTag = logoutTag;
    }

    public ArrayList<String> getPersonFlowId() {
        return personFlowId;
    }

    public void setPersonFlowId(ArrayList<String> personFlowId) {
        this.personFlowId = personFlowId;
    }
}
