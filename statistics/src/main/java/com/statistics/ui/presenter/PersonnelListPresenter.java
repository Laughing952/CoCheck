package com.statistics.ui.presenter;

import com.statistics.api.RetrofitHelper;
import com.statistics.response.AssistantStatisticsRep;
import com.statistics.response.PersonneRep;
import com.statistics.ui.acitivty.A_Personnel_List;
import com.statistics.ui.mvpview.PersonnelListView;
import com.statistics.ui.viewmodel.Level2Item;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Water on 2018/4/12.
 */

public class PersonnelListPresenter {

    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;
    private PersonnelListView personnelListView;
    private int pageSize = 10;
    private int currentPage = 1;

    public PersonnelListPresenter(BaseActivity activity, LifecycleProvider lifecycleProvider
            , PersonnelListView personnelListView) {
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
        this.personnelListView = personnelListView;
    }

    public void initData(int from, Level2Item item) {
        currentPage = 1;
        if (from == A_Personnel_List.FLOATING_PERSONNEL) {
            // 获取流动人口列表
            initFloatingPersonnelData(item.getType());
        } else if (from == A_Personnel_List.ASSISTANT) {
            // 获取协查人口列表
            initAssistantData(item.getType());
        }
    }

    /**
     * 获取流动人口列表
     */
    private void initFloatingPersonnelData(int type) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().queryFlowInfoList(currentPage, pageSize, type)
                , new DefaultObserver<List<PersonneRep>>() {
                    @Override
                    public void onSuccess(List<PersonneRep> repList) {
                        if (currentPage == 1)
                            personnelListView.initDataResult(repList);
                        else
                            personnelListView.loadMoreReult(repList);
                    }
                });
    }

    /**
     * 获取协查人口列表
     */
    private void initAssistantData(int type) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getCheckList(currentPage, pageSize, type)
                , new DefaultObserver<List<PersonneRep>>() {
                    @Override
                    public void onSuccess(List<PersonneRep> repList) {
                        if (currentPage == 1)
                            personnelListView.initDataResult(repList);
                        else
                            personnelListView.loadMoreReult(repList);
                    }
                });
    }

    /**
     * 刷新
     */
    public void refresh() {

    }

    public void loadMore(int from, Level2Item item) {
        currentPage++;
        if (from == A_Personnel_List.FLOATING_PERSONNEL) {
            // 获取流动人口列表
            initFloatingPersonnelData(item.getType());
        } else if (from == A_Personnel_List.ASSISTANT) {
            // 获取协查人口列表
            initAssistantData(item.getType());
        }
    }
}
