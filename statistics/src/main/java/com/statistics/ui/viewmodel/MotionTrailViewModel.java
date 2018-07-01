package com.statistics.ui.viewmodel;

import com.commondata.util.TransformUtil;
import com.statistics.response.MotionTrailRep;

/**
 * 疆外活动轨迹
 * Created by Water on 2018/4/17.
 */

public class MotionTrailViewModel {

    private MotionTrailRep motionTrailRep;

    private String tabernacle; // 临时住所
    private String temporaryReason; // 暂住原因
    private String inletTime; // 流入时间
    private String planDate; // 腻居住时间
    private String profession; // 从事职业
    private String tabernacleAddress; // 临时住所详细地址

    public MotionTrailViewModel(MotionTrailRep motionTrailRep) {
        this.motionTrailRep = motionTrailRep;
    }

    public String getTabernacle() {
        return TransformUtil.stayPlaceTransformNum2String(motionTrailRep.getTempLivePlace());
    }

    public String getTemporaryReason() {
        return motionTrailRep.getTempLiveReasonDesc();
    }

    public String getInletTime() {
        return motionTrailRep.getFlowInTime();
    }

    public String getPlanDate() {
        return TransformUtil.stayTempTransformNum2String(motionTrailRep.getPlanLiveTime());
    }

    public String getProfession() {
        return motionTrailRep.getCareersName();
    }

    public String getTabernacleAddress() {
        return motionTrailRep.getTempLiveAddress();
    }
}
