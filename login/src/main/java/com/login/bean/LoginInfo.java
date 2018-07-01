package com.login.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 登录的信息 VM
 * Created by kb.zhang on 2018/4/8.
 */
public class LoginInfo extends BaseObservable implements Serializable {
    /**
     * 用户名
     */
    @SerializedName("username")
    private String user;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户ID
     */
    @SerializedName("userId")
    private String id;
    /**
     * 姓名
     */
    private String strName;
    /**
     * 性别
     */
    private String strSex;
    /**
     * 电话
     */
    @SerializedName("tel")
    private String strTel;
    /**
     * 单位区划
     */
    @SerializedName("officeCode")
    private int nOfficeCode;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
//        notifyPropertyChanged(com.login.BR.password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrSex() {
        return strSex;
    }

    public void setStrSex(String strSex) {
        this.strSex = strSex;
    }

    public String getStrTel() {
        return strTel;
    }

    public void setStrTel(String strTel) {
        this.strTel = strTel;
    }

    public int getnOfficeCode() {
        return nOfficeCode;
    }

    public void setnOfficeCode(int nOfficeCode) {
        this.nOfficeCode = nOfficeCode;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
