package com.unistrong.business.ui.mvpview;



import com.unistrong.business.bean.CoupleListBean;
import com.unistrong.business.bean.CrimeListBean;
import com.unistrong.business.bean.FamilyListBean;
import com.unistrong.business.bean.FlowListBean;
import com.unistrong.business.bean.JailedListBean;

import java.util.List;

/**
 * Created by kb.zhang on 2018/4/14.
 */

public interface IPersonInfoView {
    /**
     * 显示夫妻成员
     * @param list
     */
    void showCoupleList (List<CoupleListBean> list);

    /**
     * 显示犯罪记录
     * @param list
     */
    void showCrimeList (List<CrimeListBean> list);

    /**
     * 显示家庭成员
     * @param list
     */
    void showFamilyList (List<FamilyListBean> list);

    /**
     * 显示流动轨迹
     * @param list
     */
    void showFlowList (List<FlowListBean> list);

    /**
     * 显示列管
     * @param list
     */
    void showJailedList (List<JailedListBean> list);
}
