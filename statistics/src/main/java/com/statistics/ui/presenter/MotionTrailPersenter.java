package com.statistics.ui.presenter;

import com.statistics.api.RetrofitHelper;
import com.statistics.response.InvolvedInfoRep;
import com.statistics.response.MotionTrailRep;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.viewmodel.PersonnelDetailsViewModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;

import java.util.List;

/**
 * 疆外活动轨迹
 * Created by Water on 2018/4/17.
 */

public class MotionTrailPersenter {

    private FamilyMembersView familyMembersView;
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;

    private int currentPage = 1;
    private int pageSize = 10;

    public MotionTrailPersenter(FamilyMembersView familyMembersView, BaseActivity activity, LifecycleProvider lifecycleProvider) {
        this.familyMembersView = familyMembersView;
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
    }

    public void initData(String idCardNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage = 1;
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getMotionTrailList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<MotionTrailRep>>() {
                    @Override
                    public void onSuccess(List<MotionTrailRep> involvedInfoRep) {
                        familyMembersView.resultData(involvedInfoRep);
                    }
                });
    }

    public void addData(String idCardNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage++;
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getMotionTrailList(currentPage, pageSize, idCardNum)
                , new DefaultObserver<List<MotionTrailRep>>() {
                    @Override
                    public void onSuccess(List<MotionTrailRep> involvedInfoRep) {
                        familyMembersView.addData(involvedInfoRep);
                    }
                });
    }
}
