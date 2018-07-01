package com.unistrong.business.ui.viewmodel;

import com.commondata.util.TransformUtil;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.waterbase.utile.Utils;

/**
 * 流动人口编辑列表ViewModel
 * 作者：Laughing on 2018/4/24 13:21
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleEditListViewModel {
    private FlowPeopleQueryItemRep mFlowPeopleQueryItemRep;
    private String name;//姓名
    private String sex; //性别
    private String idNum; // 身份证号码
    private String personAttrType; // 人员属性类别（1：一般人员，2：白名单，3：红名单）
    private String nation; // 民族
    private String logoutTag; // 注销标记 1:表示注销 2:表示未注销 3:表示还原
    private String registerDate; // 登记日期

    private int logoutTagColor;
    private int attrTypeColor;

    public int getAttrTypeColor() {
        return TransformUtil.personAttrformColor(personAttrType);
    }

    public int getLogoutTagColor() {
        if ("1".equals(mFlowPeopleQueryItemRep.getLogoutTag())) {
            return Utils.getContext().getResources().getColor(R.color.red);
        } else {
            return Utils.getContext().getResources().getColor(R.color.black);
        }
    }

    public FlowPeopleEditListViewModel(FlowPeopleQueryItemRep flowPeopleHistoryRep) {
        this.mFlowPeopleQueryItemRep = flowPeopleHistoryRep;
    }

    public String getName() {
        return mFlowPeopleQueryItemRep.getName();
    }

    public int getSex() {
        switch (mFlowPeopleQueryItemRep.getSex()) {
            case "1":
                return R.mipmap.ic_man;
            case "2":
                return R.mipmap.ic_woman;
        }
        return 0;
    }

    public String getIdNum() {
        return mFlowPeopleQueryItemRep.getIdNum();
    }

    public String getPersonAttrType() {
        return TransformUtil.personAttrformString(mFlowPeopleQueryItemRep.getPersonAttr());
    }

    public String getNation() {
        return mFlowPeopleQueryItemRep.getNationName();
    }

    public String getLogoutTag() {
        return TransformUtil.logoutTagTransform(mFlowPeopleQueryItemRep.getLogoutTag());
    }

    public String getRegisterDate() {
        return registerDate;
    }
}
