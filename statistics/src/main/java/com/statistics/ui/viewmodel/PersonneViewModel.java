package com.statistics.ui.viewmodel;

import com.statistics.response.AssistantStatisticsRep;
import com.statistics.response.PersonneRep;
import com.waterbase.utile.DateUtil;
import com.waterbase.utile.StrUtil;
import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * Created by Water on 2018/4/12.
 */

public class PersonneViewModel {

    private PersonneRep personneRep;

    private String headUrl; // 头像地址
    private String name;
    private String idCardNo; // 身份证号码
    private String age; // 年龄

    public PersonneViewModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public PersonneViewModel(PersonneRep personneRep) {
        this.personneRep = personneRep;
    }

    public String getHeadUrl() {
        return personneRep.getPhotoUrl();
    }

    public String getName() {
        return personneRep.getName();
    }

    public String getIdCardNo() {
        return personneRep.getIdNum();
    }

    public String getAge() {
        int age = DateUtil.getAgeByBirthday(DateUtil.getDateByFormat(personneRep.getBirthday(),"yyyyMMdd"));
        return String.valueOf(age);
    }


}
