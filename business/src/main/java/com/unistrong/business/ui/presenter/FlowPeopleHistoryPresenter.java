package com.unistrong.business.ui.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleHistoryRep;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.ui.mvpview.FlowPeopleAddHistoryListView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流动人口登记历史
 * 作者：Laughing on 2018/4/22 20:42
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleHistoryPresenter {
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;
    private FlowPeopleAddHistoryListView mFlowPeopleAddHistoryListView;
    private final Map<String, Object> map;

    public FlowPeopleHistoryPresenter(BaseActivity activity, LifecycleProvider lifecycleProvider
            , FlowPeopleAddHistoryListView flowPeopleAddHistoryListView) {
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
        this.mFlowPeopleAddHistoryListView = flowPeopleAddHistoryListView;
        map = new HashMap<>();
    }

    /**
     * 刷新
     */
    public void refresh() {

    }

    private int currentPage = 1;
    private int pageSize = 10;

    /**
     * 初始化数据
     */
    public void initData() {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage = 1;
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(map)
                , new DefaultObserver<List<FlowPeopleQueryItemRep>>() {
                    @Override
                    public void onSuccess(List<FlowPeopleQueryItemRep> involvedInfoRep) {
                        mFlowPeopleAddHistoryListView.initDataResult(involvedInfoRep);
                    }
                });
    }

    public void loadMoreData() {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage++;
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(map)
                , new DefaultObserver<List<FlowPeopleQueryItemRep>>() {
                    @Override
                    public void onSuccess(List<FlowPeopleQueryItemRep> involvedInfoRep) {
                        mFlowPeopleAddHistoryListView.loadMoreResult(involvedInfoRep);
                    }
                });
    }
}
