package com.unistrong.business.ui.presenter;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleAddRep;
import com.unistrong.business.bean.FlowPeopleAddReq;
import com.unistrong.business.bean.PersonListBean;
import com.unistrong.business.ui.mvpview.IFlowPeopleAddView;
import com.unistrong.business.ui.mvpview.IPersonInfoView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;

/**
 * Created by cuihao on 2018/4/19.
 */

public class FlowPeopleAddPresenter {
    private HttpManager manager;
    private IFlowPeopleAddView view;

    public FlowPeopleAddPresenter(HttpManager manager, IFlowPeopleAddView view) {
        this.manager = manager;
        this.view = view;
    }

    /**
     * 上传登记信息
     * @Body addReq
     */
    public void uploadAddPersonDetailsData (FlowPeopleAddReq addReq) {
        manager.doHttpDeal(RetrofitHelper.getApiService().uploadPeopleAddData(addReq),
                new DefaultObserver<Object>() {
                    @Override
                    public void onSuccess(Object response) {
                        view.showResult();
                    }
                });
    }
}
