package com.statistics.ui.presenter;

import android.view.View;

import com.statistics.R;
import com.statistics.api.RetrofitHelper;
import com.statistics.response.MarriageInfoRep;
import com.statistics.response.PersonnelDetailsRep;
import com.statistics.ui.mvpview.AssistantStatisticsView;
import com.statistics.ui.mvpview.PersonnelDetailsView;
import com.statistics.ui.viewmodel.PersonnelDetailsViewModel;
import com.statistics.ui.viewmodel.TodayStatisticsViewModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.LogUtil;

import java.util.ArrayList;

/**
 * 人员详情
 * Created by Water on 2018/4/16.
 */

public class PersonnelDetailsPresenter {

    private static final String TAG = "PersonnelDetailsPresenter";
    private PersonnelDetailsView detailsView;
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;

    public PersonnelDetailsPresenter(PersonnelDetailsView detailsView, BaseActivity activity, LifecycleProvider lifecycleProvider) {
        this.detailsView = detailsView;
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
    }

    private PersonnelDetailsRep detailsRep;
    private ArrayList<MarriageInfoRep> marriageInfoReps;

    public void initData(String id) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getPersonnelDetails(id), new DefaultObserver<PersonnelDetailsRep>() {
            @Override
            public void onSuccess(PersonnelDetailsRep detailsRep) {
                PersonnelDetailsPresenter.this.detailsRep = detailsRep;
                LogUtil.d(TAG, "getPerson：  " + detailsRep.getPerson().toString());
                detailsView.resultData(new PersonnelDetailsViewModel(detailsRep.getPerson()));
            }
        });
    }

    public PersonnelDetailsRep getDetailsRep() {
        return detailsRep;
    }

    public void setDetailsRep(PersonnelDetailsRep detailsRep) {
        this.detailsRep = detailsRep;
    }

    public ArrayList<MarriageInfoRep> getMarriageInfoReps() {
        return marriageInfoReps;
    }

    public void setMarriageInfoReps(ArrayList<MarriageInfoRep> marriageInfoReps) {
        this.marriageInfoReps = marriageInfoReps;
    }
}
