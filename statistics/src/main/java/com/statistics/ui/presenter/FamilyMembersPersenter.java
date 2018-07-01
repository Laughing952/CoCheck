package com.statistics.ui.presenter;

import com.statistics.api.RetrofitHelper;
import com.statistics.response.FamilyMembersRep;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;

import java.util.List;

/**
 * 家庭成员
 * Created by Water on 2018/4/16.
 */

public class FamilyMembersPersenter {

    private FamilyMembersView familyMembersView;
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;

    private int currentPage = 1;
    private int pageSize = 10;


    public FamilyMembersPersenter(FamilyMembersView familyMembersView, BaseActivity activity, LifecycleProvider lifecycleProvider) {
        this.familyMembersView = familyMembersView;
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
    }

    public void initData(String idCardNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage = 1;
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getFamilyMembersList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<FamilyMembersRep>>() {
                    @Override
                    public void onSuccess(List<FamilyMembersRep> familyMembersRepList) {
                        familyMembersView.resultData(familyMembersRepList);
                    }
                });
    }

    public void addData(String idCardNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage++;
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getFamilyMembersList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<FamilyMembersRep>>() {
                    @Override
                    public void onSuccess(List<FamilyMembersRep> familyMembersRepList) {
                        familyMembersView.addData(familyMembersRepList);
                    }
                });
    }
}
