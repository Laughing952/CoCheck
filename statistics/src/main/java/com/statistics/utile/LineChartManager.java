package com.statistics.utile;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.statistics.R;
import com.waterbase.utile.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Water on 2018/4/11.
 */

public class LineChartManager {

    private LineChart lineChart;
    private YAxis leftAxis;
    private YAxis rightAxis;
    private XAxis xAxis;

    private Context context;

    public LineChartManager(Context context, LineChart lineChart) {
        this.context = context;
        this.lineChart = lineChart;
        leftAxis = lineChart.getAxisLeft();
        rightAxis = lineChart.getAxisRight();
        xAxis = lineChart.getXAxis();
    }

    /**
     * 初始化Chart
     */
    private void initChart() {
        //不显示描述内容
        lineChart.getDescription().setEnabled(false);

        lineChart.setTouchEnabled(false);
        lineChart.setScaleEnabled(false); //设置图表是否可缩放
        lineChart.setClipValuesToContent(false);
        lineChart.setFocusable(false);
        lineChart.setFocusableInTouchMode(false);

        lineChart.setBackgroundColor(Color.WHITE);

        lineChart.setDrawGridBackground(false);
        //设置网格底下的那条线的颜色
        lineChart.setDrawGridBackground(true);
        lineChart.setGridBackgroundColor(Color.WHITE);
        //显示边界
//        lineChart.setDrawBorders(true);
        lineChart.setBorderColor(Color.RED);

        xAxis.setAxisLineWidth(2f);
        //图例说明
        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(false);

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        //Y轴设置
        // y标签的集合数量将会被强制
        rightAxis.setLabelCount(5, true);
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setEnabled(false);
//        rightAxis.setAxisMaxValue(1000f);

        // y标签的集合数量将会被强制
        leftAxis.setLabelCount(5, true);
        leftAxis.setDrawGridLines(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisLineWidth(2f);
        lineChart.animateX(1000); // 立即执行的动画,x轴


    }

    /**
     * 设置X轴坐标值
     *
     * @param xAxisValues x轴坐标集合
     */
    public void setXAxis(final List<String> xAxisValues) {

        //设置X轴在底部
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);

        xAxis.setLabelCount(xAxisValues.size() - 1, false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xAxisValues.get((int) value % xAxisValues.size());
            }
        });
        lineChart.invalidate();


    }

    /**
     * 得到折线图(一条)
     *
     * @param lineChartY 折线Y轴值
     * @param lineName   折线图名字
     * @param lineColor  折线颜色
     * @return
     */
    private LineData getLineData(List<Float> lineChartY, String lineName, int lineColor) {
        LineData lineData = new LineData();

        ArrayList<Entry> yValue = new ArrayList<>();
        for (int i = 0; i < lineChartY.size(); i++) {
            LogUtil.d("-----", "lineChartY:" + lineChartY.get(i));
            yValue.add(new Entry(i, lineChartY.get(i)));
        }

        LineDataSet dataSet = new LineDataSet(yValue, lineName);

        dataSet.setDrawFilled(true);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.shape);
        dataSet.setFillDrawable(drawable);
        //设置有圆点
        dataSet.setDrawCircles(true);
        dataSet.setLineWidth(2f);    //设置线的宽度
        dataSet.setCircleSize(2f);   //设置小圆的大小
        // 圆环颜色
        dataSet.setCircleColor(lineColor);
        // 圆心颜色
        dataSet.setCircleColorHole(Color.RED);
        dataSet.setColor(lineColor);
        dataSet.setValueTextColor(lineColor);

        //显示值
        dataSet.setDrawValues(true);
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.format("%.2f", value);
            }
        });
        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.format("%.2f", value);
            }
        });
        dataSet.setValueTextSize(10f);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineData.addDataSet(dataSet);
        dataSet.setFillFormatter(new DefaultFillFormatter());
        return lineData;
    }

    /**
     * 得到折线图(多条)
     *
     * @param lineChartYs 折线Y轴值
     * @param lineNames   折线图名字
     * @param lineColors  折线颜色
     * @return
     */
    private LineData getLineData(List<List<Float>> lineChartYs, List<String> lineNames, List<Integer> lineColors) {
        LineData lineData = new LineData();

        for (int i = 0; i < lineChartYs.size(); i++) {
            ArrayList<Entry> yValues = new ArrayList<>();
            for (int j = 0; j < lineChartYs.get(i).size(); j++) {
                yValues.add(new Entry(j, lineChartYs.get(i).get(j)));
            }
            LineDataSet dataSet = new LineDataSet(yValues, lineNames.get(i));
            dataSet.setColor(context.getResources().getColor(lineColors.get(i)));
//            dataSet.setCircleColor(lineColors.get(i));
//            dataSet.setValueTextColor(lineColors.get(i));

            dataSet.setFillColor(context.getResources().getColor(lineColors.get(i)));
            dataSet.setDrawFilled(true);

            dataSet.setCircleSize(1);
            dataSet.setDrawValues(false);
            dataSet.setValueTextSize(10f);
            dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineData.addDataSet(dataSet);
        }
        return lineData;
    }

    /**
     * 显示多折线
     *
     * @param xAxisValues
     * @param lineChartYs
     * @param lineNames
     * @param lineColors
     */
    public void showCombinedChart(List<String> xAxisValues, List<List<Float>> lineChartYs
            , List<String> lineNames, List<Integer> lineColors) {
        initChart();
        setXAxis(xAxisValues);
        LineData lineData = getLineData(lineChartYs, lineNames, lineColors);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

}
