package com.statistics.ui.presenter;

import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.mvpview.MarriageInfoView;
import com.statistics.ui.viewmodel.PersonnelDetailsViewModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseActivity;

/**
 * Created by Water on 2018/4/16.
 */

public class MarriageInfoPersenter {

    private MarriageInfoView marriageInfoView;
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;

    public MarriageInfoPersenter(MarriageInfoView marriageInfoView, BaseActivity activity, LifecycleProvider lifecycleProvider) {
        this.marriageInfoView = marriageInfoView;
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
    }

    public void initData(String idCardNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
//        httpManager.doHttpDeal(RetrofitHelper.getApiService().queryAllPersonData(), new DefaultObserver<String>() {
//            @Override
//            public void onSuccess(String str) {
//                LogUtil.d(TAG, "str: " + str);
//            }
//        });
//        marriageInfoView.resultData(new PersonnelDetailsViewModel());
    }
}
