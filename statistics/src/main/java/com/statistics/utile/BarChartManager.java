package com.statistics.utile;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.statistics.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Water on 2017/8/24.
 */

public class BarChartManager {

    private Context context;
    private BarChart mBarChart;
    private YAxis leftAxis;
    private YAxis rightAxis;
    private XAxis xAxis;

    public BarChartManager(Context context, BarChart mBarChart) {
        this.context = context;
        this.mBarChart = mBarChart;
        leftAxis = mBarChart.getAxisLeft();
        rightAxis = mBarChart.getAxisRight();
        xAxis = mBarChart.getXAxis();
    }

    /**
     * 初始化Chart
     */
    private void initChart() {
        //不显示描述内容
        mBarChart.getDescription().setEnabled(false);
        // 设置x轴不显示
        xAxis.setEnabled(false);

        mBarChart.setClipValuesToContent(false);
        mBarChart.setFocusable(false);
        mBarChart.setFocusableInTouchMode(false);
        mBarChart.setTouchEnabled(false);
        mBarChart.setBackgroundColor(Color.WHITE);

        mBarChart.setDrawGridBackground(false);
        //设置网格底下的那条线的颜色

        mBarChart.setDrawBarShadow(true);
        mBarChart.setHighlightFullBarEnabled(false);
        //显示边界
        mBarChart.setDrawBorders(false);

        //图例说明
        Legend legend = mBarChart.getLegend();
        legend.setWordWrapEnabled(false);

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setEnabled(false);
        //Y轴设置
        // y标签的集合数量将会被强制
        rightAxis.setEnabled(false);
        rightAxis.setLabelCount(5, true);
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);
//        rightAxis.setAxisMaxValue(1000f);

        // y标签的集合数量将会被强制
        leftAxis.setEnabled(false);
        leftAxis.setLabelCount(5, true);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGridColor(context.getResources().getColor(R.color.main_color));
        leftAxis.setAxisMinimum(0f);

        mBarChart.animateX(2000); // 立即执行的动画,x轴
    }


    /**
     * 设置X轴坐标值
     *
     * @param xAxisValues x轴坐标集合
     */
    public void setXAxis(final List<String> xAxisValues) {

        //设置X轴在底部
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(xAxisValues.size() - 1, false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xAxisValues.get((int) value % xAxisValues.size());
            }
        });
        mBarChart.invalidate();
    }

    /**
     * 得到柱状图(多条)
     *
     * @param barChartYs Y轴值
     * @param barNames   柱状图名字
     * @param barColors  柱状图颜色
     * @return
     */
    private BarData getBarData(List<List<Float>> barChartYs, List<String> barNames, List<Integer> barColors) {
        List<IBarDataSet> lists = new ArrayList<>();
        for (int i = 0; i < barChartYs.size(); i++) {
            ArrayList<BarEntry> entries = new ArrayList<>();

            for (int j = 0; j < barChartYs.get(i).size(); j++) {
                entries.add(new BarEntry(j, barChartYs.get(i).get(j)));
            }
            BarDataSet barDataSet = new BarDataSet(entries, barNames.get(i));

            barDataSet.setColor(barColors.get(i));
            barDataSet.setValueTextColor(barColors.get(i));
            barDataSet.setValueTextSize(10f);
            if (i % 2 == 0)
                barDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
            else
                barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            // 柱状背景颜色
            barDataSet.setBarShadowColor(context.getResources().getColor(R.color.main_color));
            barDataSet.setDrawValues(false);
            lists.add(barDataSet);
        }
        BarData barData = new BarData(lists);

        int amount = barChartYs.size(); //需要显示柱状图的类别 数量
        float groupSpace = 0.12f; //柱状图组之间的间距
        float barSpace = (float) ((1 - 0.12) / amount / 10); // x4 DataSet
        float barWidth = (float) ((1 - 0.12) / amount / 10 * 9); // x4 DataSet

        // (0.2 + 0.02) * 4 + 0.12 = 1.00 即100% 按照百分百布局
        //柱状图宽度
        barData.setBarWidth(barWidth);
        //(起始点、柱状图组间距、柱状图之间间距)
        barData.groupBars(-barWidth - barSpace - groupSpace / 2, groupSpace, barSpace);
        return barData;
    }

    private BarData getBarData(List<Float> barChartYs, String barNames, int barColors) {
        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int j = 0; j < barChartYs.size(); j++) {
            entries.add(new BarEntry(j, barChartYs.get(j)));
        }
        BarDataSet barDataSet = new BarDataSet(entries, barNames);

        barDataSet.setColor(barColors);
//        barDataSet.setValueTextColor(barColors);
//        barDataSet.setValueTextSize(10f);

        // 柱状背景颜色
        barDataSet.setBarShadowColor(context.getResources().getColor(R.color.main_color));
        barDataSet.setDrawValues(false);
        BarData barData = new BarData(barDataSet);
        int amount = barChartYs.size(); //需要显示柱状图的类别 数量
        float groupSpace = 0.12f; //柱状图组之间的间距
        float barSpace = (float) ((1 - 0.12) / amount / 10); // x4 DataSet

        float barWidth = (float) ((1 - 0.12) / amount / 10 * 9); // x4 DataSet
        // (0.2 + 0.02) * 4 + 0.12 = 1.00 即100% 按照百分百布局
        //柱状图宽度
//        barData.setBarWidth(barWidth);
        //(起始点、柱状图组间距、柱状图之间间距)
//        barData.groupBars(-barWidth/ 2, groupSpace, barSpace);
        return barData;
    }

    /**
     * 显示多条柱状图(柱状图)
     *
     * @param xAxisValues X轴坐标
     * @param barChartYs  柱状图Y轴值
     * @param barNames    柱状图名字
     * @param barColors   柱状图颜色
     */
    public void showCombinedChart(List<String> xAxisValues, List<List<Float>> barChartYs,
                                  List<String> barNames, List<Integer> barColors) {
        initChart();
        setXAxis(xAxisValues);

        BarData barData = getBarData(barChartYs, barNames, barColors);

        mBarChart.setData(barData);
        mBarChart.invalidate();
    }

    /**
     * 显示多条柱状图(柱状图)
     *
     * @param xAxisValues X轴坐标
     * @param barChartYs  柱状图Y轴值
     * @param barName     柱状图名字
     * @param barColor    柱状图颜色
     */
    public void showCombinedChart11(List<String> xAxisValues, List<Float> barChartYs,
                                    String barName, int barColor) {
        initChart();
//        setXAxis(xAxisValues);
        BarData barData = getBarData(barChartYs, barName, barColor);
        mBarChart.setData(barData);
        mBarChart.invalidate();
    }
}
