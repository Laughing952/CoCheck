package com.unistrong.business.ui.presenter;

import android.content.Context;
import android.content.Intent;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleAddRep;
import com.unistrong.business.bean.FlowPeopleAddReq;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.ui.mvpview.IFlowPeopleAddView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.utile.ToastUtil;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by cuihao on 2018/4/22.
 */

public class FlowPeopleQueryAddPresenter {
    private HttpManager manager;
    private Context context;

    public FlowPeopleQueryAddPresenter(HttpManager manager, Context context) {
        this.manager = manager;
        this.context = context;
    }

    /**
     * 上传登记信息
     * @Body addReq
     */
    public void queryAddPersonDetailsData (Map mapReq) {
        manager.doHttpDeal(RetrofitHelper.getApiService().uploadFlowPeopleData(mapReq),
                new DefaultObserver<ArrayList<FlowPeopleQueryItemRep>>() {
                    @Override
                    public void onSuccess(ArrayList<FlowPeopleQueryItemRep> response) {
                        try {
                            if (response.size()>0) {
                                Intent intent = null;
                                intent = new Intent(context, Class.forName("com.statistics.ui.acitivty.A_Personnel_Details"));
                                intent.putExtra("idCardNum", (String) mapReq.get("idNum"));
                                intent.putExtra("from", 678);
                                context.startActivity(intent);
                            }else{
                                ToastUtil.showToast(context,"身份证信息不存在");
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
