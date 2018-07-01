package com.unistrong.business.ui.mvpview;

import com.unistrong.business.bean.Action;

import java.util.List;

/**
 * Created by Water on 2018/4/10.
 */

public interface BusinessView {

    /**
     * 需要展示的数据
     *
     * @param actionList
     */
    void resultData(List<Action> actionList);

    /**
     * 打开别的Activity
     *
     * @param className
     */
    void startActivity(String className);
}
