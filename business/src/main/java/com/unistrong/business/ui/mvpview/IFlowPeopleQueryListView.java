package com.unistrong.business.ui.mvpview;

import com.waterbase.ui.BaseView;

import java.util.List;

/**
 * Created by edz on 2018/4/17.
 */

public interface IFlowPeopleQueryListView<T> {
    /**
     * 当数据获取成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(List<T> data);
    /**
     * 当上拉刷新时，调用此接口显示数据
     * @param data 数据源
     */
    void showRefreshData(List<T> data);
    /**
     * 当下拉加载时，调用此接口显示数据
     * @param data 数据源
     */
    void showLoadMoreData(List<T> data);
}
