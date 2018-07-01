package com.statistics.ui.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import com.commondata.util.TransformUtil;
import com.statistics.R;
import com.statistics.response.PersonnelDetailsRep;
import com.waterbase.ui.BaseApplication;

/**
 * 人员详情
 * Created by Water on 2018/4/16.
 */

public class PersonnelDetailsViewModel {

    private PersonnelDetailsRep.PersonnelDetails details;

    public PersonnelDetailsViewModel(PersonnelDetailsRep.PersonnelDetails details) {
        this.details = details;
    }

    public PersonnelDetailsRep.PersonnelDetails getDetails() {
        return details;
    }

    private String id; // 用户为标志
    private String headUrl; // 头像
    private String name; // 名字
    private String personAttr; // 人员属性
    private int attrBg; // 属性的背景颜色
    private int textClor;

    private String idCardNum; // 身份证号码
    private String nation; // 民族
    private String birthday; // 生日
    private String stature;// 身高
    private String bloodType; // 血型
    private String education; // 文化程度
    private String maritalStatus; // 婚姻状况
    private String politicsStatus; // 政治面貌
    private String serviceOffice; // 服务所处
    private String profession; // 职业
    private String permanentAddress; // 户籍地址
    private String permanentOffice; // 户籍责任区单位
    private String policePhoneNo; // 警务室民警联系电话
    private String permanentCommunity; // 户籍责任区社区
    private String cadrePhoneNo; // 社区干部联系电话

    public String getHeadUrl() {
        return details.getImage();
    }

    public String getName() {
        return details.getName();
    }

    public String getPersonAttr() {
        return TransformUtil.personAttrsTransform(details.getPersonAttr());
    }


    public int getAttrBg() {
        return R.drawable.attr_bg_blue;
//        if ("".equals(details.getPersonAttr()))
//            return R.drawable.attr_bg_blue;
//        else
//            return R.drawable.attr_bg_blue;
    }

    public int getTextClor() {
        return BaseApplication.getAppContext().getResources().getColor(R.color.lucency_red);
//        return R.color.lucency_red;
    }

    public String getIdCardNum() {
        return details.getIdNum();
    }

    public String getNation() {
        return details.getNationName();
    }

    public String getBirthday() {
        return details.getBirthday();
    }

    public String getStature() {
        return details.getHeight();
    }

    public String getBloodType() {
        int body = 0;
        try {
            body = Integer.parseInt(details.getBloodType());
        } catch (NumberFormatException e) {

        }
        return TransformUtil.bloodTransform(body);
    }

    public String getEducation() {
        return details.getEduLevelName();
    }

    public String getMaritalStatus() {
        return TransformUtil.marriageTransformString(Integer.parseInt(details.getMarriageStatus()));
    }

    public String getPoliticsStatus() {
        return details.getPoliticalStatusName();
    }

    public String getServiceOffice() {
        return details.getHouseholdPoliceStation();
    }

    public String getProfession() {
        return details.getCareersName();
    }

    public String getPermanentAddress() {
        return details.getHouseholdAddress();
    }

    public String getPermanentOffice() {
        return details.getBelongToPoliceDepart();
    }

    public String getPolicePhoneNo() {
        return details.getPoliceStatioTel();
    }

    public String getPermanentCommunity() {
        return details.getCommunityName();
    }

    public String getCadrePhoneNo() {
        return details.getCommunityTel();
    }

}
