package com.unistrong.business.ui.presenter;

import android.content.Context;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.ui.activity.A_Flow_PeoPle_Query_List;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edz on 2018/4/15.
 */

public class FlowPeopleQueryPersenter {
    private HttpManager manager;
    private Context mContext;
    private String currentPage="1";
    private String pageSize="10";
    private Map<String, Object> map;

    public FlowPeopleQueryPersenter(Context mContext, HttpManager manager) {
        this.manager = manager;
        this.mContext = mContext;
    }
    public void uploadHistoryData(){
        map = new HashMap<>();
        currentPage="1";
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        A_Flow_PeoPle_Query_List.startActivity(mContext,map);

    }
    public void uploadData(Map<String, Object> map) {
         A_Flow_PeoPle_Query_List.startActivity(mContext, map);
    }
}
