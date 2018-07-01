package com.unistrong.business.ui.presenter;

import android.support.v7.widget.RecyclerView;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.ui.activity.A_Flow_PeoPle_Query_List;
import com.unistrong.business.ui.mvpview.IFlowPeopleQueryListView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.utile.ToastUtil;
import com.waterbase.utile.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edz on 2018/4/17.
 */

public class FlowPeopleQueryListPersenter {

    private HttpManager manager;
    private IFlowPeopleQueryListView view;
    private String pageSize="10";

    public FlowPeopleQueryListPersenter(HttpManager manager, IFlowPeopleQueryListView view){
        this.manager=manager;
        this.view=view;
    }
    /**
     * 首次加载数据
     */
    public void initData(Map<String, Object> map){
        manager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(map)
                , new DefaultObserver<ArrayList<FlowPeopleQueryItemRep>>() {
                    @Override
                    public void onSuccess(ArrayList<FlowPeopleQueryItemRep> involvedInfoRep) {
                        view.showData(involvedInfoRep);
                    }
                });
    }

    /**
     * 刷新请求
     */
    public void requestRefreshData(Map<String,Object> map) {
        if (!map.isEmpty()) {
            manager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(map)
                    , new DefaultObserver<ArrayList<FlowPeopleQueryItemRep>>() {
                        @Override
                        public void onSuccess(ArrayList<FlowPeopleQueryItemRep> queryRep) {
                            view.showRefreshData(queryRep);
                            ToastUtil.showToast(Utils.getContext(), "刷新成功");
                        }
                    });
        }
    }

    /**
     * 加载更多请求
     */
    public void requestMoreData(Map<String,Object> map) {
        String currentPage = (String) map.get("currentPage");
        map.put("currentPage",String.valueOf(Integer.parseInt(currentPage)+1));
        if (!map.isEmpty()) {
            manager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(map)
                    , new DefaultObserver<List<FlowPeopleQueryItemRep>>() {
                        @Override
                        public void onSuccess(List<FlowPeopleQueryItemRep> queryRep) {
                            view.showLoadMoreData(queryRep);
                            ToastUtil.showToast(Utils.getContext(), "加载成功");
                        }
                    });
        }
    }
}
