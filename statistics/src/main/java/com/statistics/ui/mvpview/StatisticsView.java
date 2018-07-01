package com.statistics.ui.mvpview;

import com.statistics.ui.viewmodel.TodayStatisticsViewModel;

/**
 * Created by Water on 2018/4/8.
 */

public interface StatisticsView {

    /**
     * 服务器的数据反馈
     * @param viewModel
     */
    void result(TodayStatisticsViewModel viewModel);


}
