package com.statistics.ui.presenter;

import com.statistics.api.RetrofitHelper;
import com.statistics.response.ColumnInfoRep;
import com.statistics.response.InvolvedInfoRep;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.viewmodel.PersonnelDetailsViewModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;

import java.util.List;

/**
 * 列管信息
 * Created by Water on 2018/4/17.
 */

public class ColumnInfoPersenter {
    private FamilyMembersView familyMembersView;
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;

    private int currentPage = 1;
    private int pageSize = 10;

    public ColumnInfoPersenter(FamilyMembersView familyMembersView, BaseActivity activity, LifecycleProvider lifecycleProvider) {
        this.familyMembersView = familyMembersView;
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
    }

    public void initData(String idCardNum) {
        currentPage = 1;
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getColumnInfoList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<ColumnInfoRep>>() {
                    @Override
                    public void onSuccess(List<ColumnInfoRep> involvedInfoRep) {
                        familyMembersView.resultData(involvedInfoRep);
                    }
                });
    }

    public void addData(String idCardNum) {
        currentPage++;
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getColumnInfoList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<ColumnInfoRep>>() {
                    @Override
                    public void onSuccess(List<ColumnInfoRep> involvedInfoRep) {
                        familyMembersView.addData(involvedInfoRep);
                    }
                });
    }
}
