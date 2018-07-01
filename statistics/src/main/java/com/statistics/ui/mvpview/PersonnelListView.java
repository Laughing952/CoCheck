package com.statistics.ui.mvpview;

/**
 * Created by Water on 2018/4/12.
 */

public interface PersonnelListView<T> {

    void initDataResult(T t);

    void refreshReult(T t);

    void loadMoreReult(T t);
}
