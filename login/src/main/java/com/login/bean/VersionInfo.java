package com.login.bean;

import java.io.Serializable;

/**
 * 版本信息
 * Created by kb.zhang on 2018/4/10.
 */

public class VersionInfo{
    /**
     * 版本编号
     */
    private int nCode;
    /**
     * 版本名称
     */
    private String strVersionName;
    /**
     * 下载路径
     */
    private String strDownUrl;

    public int getnCode() {
        return nCode;
    }

    public void setnCode(int nCode) {
        this.nCode = nCode;
    }

    public String getStrVersionName() {
        return strVersionName;
    }

    public void setStrVersionName(String strVersionName) {
        this.strVersionName = strVersionName;
    }

    public String getStrDownUrl() {
        return strDownUrl;
    }

    public void setStrDownUrl(String strDownUrl) {
        this.strDownUrl = strDownUrl;
    }
}
