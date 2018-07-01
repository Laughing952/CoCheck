package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.commondata.event.RefreshEvent;
import com.statistics.R;
import com.statistics.databinding.ATodayStatisticsBinding;
import com.statistics.ui.mvpview.StatisticsView;
import com.statistics.ui.presenter.TodayStatisticsPresenter;
import com.statistics.ui.viewmodel.TodayStatisticsViewModel;
import com.statistics.utile.BarChartManager;
import com.statistics.utile.LineChartManager;

import org.greenrobot.eventbus.Subscribe;

/**
 * 今日数据统计
 * Created by Water on 2018/4/8.
 */

public class A_Today_Statistics extends TitleActivity implements StatisticsView {

    private ATodayStatisticsBinding binding;
    private TodayStatisticsPresenter presenter;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Today_Statistics.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("数据统计");
        binding = setView(R.layout.a_today_statistics);
        initView();
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        presenter.getData();
    }

    private void initView() {
        presenter = new TodayStatisticsPresenter(this, this, this);
        presenter.getData();
    }

    @Override
    public void result(TodayStatisticsViewModel viewModel) {
        binding.setViewModel(viewModel);
        BarChartManager barChartManager1 = new BarChartManager(this, binding.barChart1);
        barChartManager1.showCombinedChart11(null, viewModel.getRegisterYList()
                , null, getResources().getColor(viewModel.getRegisterColor()));
        BarChartManager barChartManager2 = new BarChartManager(this, binding.barChart2);
        barChartManager2.showCombinedChart11(null, viewModel.getLogoutYList()
                , null, getResources().getColor(viewModel.getLogoutColor()));
        BarChartManager barChartManager3 = new BarChartManager(this, binding.barChart3);
        barChartManager3.showCombinedChart11(null, viewModel.getAssistantYList()
                , null, getResources().getColor(viewModel.getAssistantColor()));
        BarChartManager barChartManager4 = new BarChartManager(this, binding.barChart4);
        barChartManager4.showCombinedChart11(null, viewModel.getFeedbackYList()
                , null, getResources().getColor(viewModel.getFeedbackColor()));
        LineChartManager lineChartManager = new LineChartManager(this, binding.lineChart);
        lineChartManager.showCombinedChart(viewModel.getLineXList(), viewModel.getLineYList()
                , viewModel.getLineNameList(), viewModel.getLineColorList());
    }
}
