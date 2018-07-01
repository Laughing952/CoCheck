package com.unistrong.business.bean;

import java.io.Serializable;

/**
 * Created by edz on 2018/4/16.
 */

public class PeoplePhotoQueryRep implements Serializable{

    /**
     * image : string
     * resultAge : string
     * resultIdNum : string
     * resultName : string
     * simi : string
     */

    private String image;//图片
    private String resultAge;//结果年龄
    private String resultIdNum;//结果ID号码
    private String resultName;//结果名称
    private String simi;//

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getResultAge() {
        return resultAge;
    }

    public void setResultAge(String resultAge) {
        this.resultAge = resultAge;
    }

    public String getResultIdNum() {
        return resultIdNum;
    }

    public void setResultIdNum(String resultIdNum) {
        this.resultIdNum = resultIdNum;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getSimi() {
        return simi;
    }

    public void setSimi(String simi) {
        this.simi = simi;
    }
}
