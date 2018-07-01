package com.statistics.ui.presenter;

import com.statistics.api.RetrofitHelper;
import com.statistics.response.TodayStatisticsRep;
import com.statistics.ui.mvpview.StatisticsView;
import com.statistics.ui.viewmodel.TodayStatisticsViewModel;
import com.statistics.utile.BarChartManager;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.LogUtil;

/**
 * 数据统计
 * Created by Water on 2018/4/8.
 */

public class TodayStatisticsPresenter {

    private static final String TAG = "TodayStatisticsPresenter";
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;
    private StatisticsView statisticsView;

    public TodayStatisticsPresenter(BaseActivity activity, LifecycleProvider lifecycleProvider
            , StatisticsView statisticsView) {
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
        this.statisticsView = statisticsView;
    }

    public void getData() {
        // TODO: 2018/4/11 从服务器获取数据
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().queryAllPersonData()
                , new DefaultObserver<TodayStatisticsRep>() {
            @Override
            public void onSuccess(TodayStatisticsRep todayStatisticsRep) {
//                LogUtil.d(TAG, "str: " + str);
                statisticsView.result(new TodayStatisticsViewModel(todayStatisticsRep));
            }
        });


    }
}
