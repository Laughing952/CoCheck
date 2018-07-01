package com.unistrong.business.ui.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.ui.mvpview.IFlowPeopleEditListListView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流动人口编辑列表Presenter
 * 作者：Laughing on 2018/4/24 13:53
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleEditListPresenter {
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;
    private IFlowPeopleEditListListView mFlowPeopleEditListListView;
    private Map<String, Object> map;
    private int currentPage = 1;
    private int pageSize = 10;

    public FlowPeopleEditListPresenter(BaseActivity activity, LifecycleProvider lifecycleProvider, IFlowPeopleEditListListView flowPeopleEditListListView) {
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
        this.mFlowPeopleEditListListView = flowPeopleEditListListView;
        map = new HashMap<>();
    }

    /**
     * 刷新
     */
    public void refresh() {

    }


    /**
     * 初始化数据
     */
    public void initData(String idNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage = 1;
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        map.put("idNum", idNum);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(map)
                , new DefaultObserver<List<FlowPeopleQueryItemRep>>() {
                    @Override
                    public void onSuccess(List<FlowPeopleQueryItemRep> involvedInfoRep) {
                        mFlowPeopleEditListListView.initDataResult(involvedInfoRep);
                    }
                });
    }

    public void loadMoreData(String idNum) {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        currentPage++;
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        map.put("idNum", idNum);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(map)
                , new DefaultObserver<List<FlowPeopleQueryItemRep>>() {
                    @Override
                    public void onSuccess(List<FlowPeopleQueryItemRep> involvedInfoRep) {
                        mFlowPeopleEditListListView.loadMoreResult(involvedInfoRep);
                    }
                });
    }
}
