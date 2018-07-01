package com.statistics.ui.presenter;

import com.statistics.api.RetrofitHelper;
import com.statistics.response.InvolvedInfoRep;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.viewmodel.InvolvedInfoViewModel;
import com.statistics.ui.viewmodel.PersonnelDetailsViewModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.LogUtil;

import java.util.List;

/**
 * 涉案信息
 * Created by Water on 2018/4/17.
 */

public class InvolvedInfoPersenter {
    private FamilyMembersView familyMembersView;
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;

    private int currentPage = 1;
    private int pageSize = 10;

    public InvolvedInfoPersenter(FamilyMembersView familyMembersView, BaseActivity activity, LifecycleProvider lifecycleProvider) {
        this.familyMembersView = familyMembersView;
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
    }

    public void initData(String idCardNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage = 1;
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getCrimeInfoList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<InvolvedInfoRep>>() {
                    @Override
                    public void onSuccess(List<InvolvedInfoRep> involvedInfoRep) {
                        familyMembersView.resultData(involvedInfoRep);
                    }
                });
    }

    public void addData(String idCardNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage++;
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getCrimeInfoList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<InvolvedInfoRep>>() {
                    @Override
                    public void onSuccess(List<InvolvedInfoRep> involvedInfoRep) {
                        familyMembersView.addData(involvedInfoRep);
                    }
                });
    }
}
