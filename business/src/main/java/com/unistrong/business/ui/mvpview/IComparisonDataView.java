package com.unistrong.business.ui.mvpview;

import java.util.List;

/**
 * Created by edz on 2018/4/14.
 */

public interface IComparisonDataView<T> {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(T data);
    /**
     * 当数据请求失败后，调用此接口提示
     * @param msg 失败原因
     */
    void showFailureMessage(String msg);
    /**
     * 当数据请求异常，调用此接口提示
     */
    void showErrorMessage(String msg);

    /**
     * 当刷新数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showRefreshData(List<T> data);

    /**
     * 当加载更多数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showLoadMoreData(List<T> data);
}
