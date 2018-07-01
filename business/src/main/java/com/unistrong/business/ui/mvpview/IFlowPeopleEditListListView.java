package com.unistrong.business.ui.mvpview;

/**
 * 流动人口编辑列表
 * 作者：Laughing on 2018/4/14 13:52
 * 邮箱：719240226@qq.com
 */

public interface IFlowPeopleEditListListView<T> {

    void initDataResult(T t);

    void refreshResult(T t);

    void loadMoreResult(T t);
}
