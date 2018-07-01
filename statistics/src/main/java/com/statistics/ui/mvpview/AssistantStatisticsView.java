package com.statistics.ui.mvpview;

import android.view.View;

/**
 * Created by Water on 2018/4/12.
 */

public interface AssistantStatisticsView<T> {

    /**
     * 返回的数据
     * @param t
     */
    void callback(T t);

    void startAcitvityForResult(String srartDate,String endDate);



}
