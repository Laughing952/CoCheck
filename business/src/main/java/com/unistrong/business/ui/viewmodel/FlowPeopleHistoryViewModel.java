package com.unistrong.business.ui.viewmodel;

import com.commondata.util.TransformUtil;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleHistoryRep;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.waterbase.utile.Utils;

/**
 * 流动人口登记历史
 * 作者：Laughing on 2018/4/22 20:05
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleHistoryViewModel {

    private FlowPeopleQueryItemRep mFlowPeopleHistoryRep;

    private String name;//姓名
    private String sex; //性别
    private String idNum; // 身份证号码
    private String personAttrType; // 人员属性类别（1：一般人员，2：白名单，3：红名单）
    private String nation; // 民族
    private String logoutTag; // 注销标记 1:表示注销 2:表示未注销 3:表示还原

    private int logoutTagColor;
    private int attrTypeColor;

    public int getAttrTypeColor() {
        return TransformUtil.personAttrformColor(personAttrType);
    }

    public int getLogoutTagColor() {
        if ("1".equals(mFlowPeopleHistoryRep.getLogoutTag())) {
            return Utils.getContext().getResources().getColor(R.color.red);
        } else {
            return Utils.getContext().getResources().getColor(R.color.black);
        }
    }


    public FlowPeopleHistoryViewModel(FlowPeopleQueryItemRep flowPeopleHistoryRep) {
        this.mFlowPeopleHistoryRep = flowPeopleHistoryRep;
    }

    public String getName() {
        return mFlowPeopleHistoryRep.getName();
    }

    public int getSex() {
        if (mFlowPeopleHistoryRep.getSex() == null)
            return 0;
        switch (mFlowPeopleHistoryRep.getSex()) {
            case "1":
                return R.mipmap.ic_man;
            case "2":
                return R.mipmap.ic_woman;
        }
        return 0;
    }

    public String getIdNum() {
        return mFlowPeopleHistoryRep.getIdNum();
    }

    public String getPersonAttrType() {
        return TransformUtil.personAttrformString(mFlowPeopleHistoryRep.getPersonAttr());
    }

    public String getNation() {
        return mFlowPeopleHistoryRep.getNationName();
    }

    public String getLogoutTag() {
        return TransformUtil.logoutTagTransform(mFlowPeopleHistoryRep.getLogoutTag());
    }
}
