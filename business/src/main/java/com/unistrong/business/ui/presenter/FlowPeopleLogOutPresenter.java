package com.unistrong.business.ui.presenter;

import com.unistrong.business.R;
import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleLogOutReq;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.utile.Utils;

/**
 * 根据身份证号查询人员信息，拿到人员ID（为了进行注销）
 * 作者：Laughing on 2018/4/21 10:29
 * 邮箱：719240226@qq.com
 */

public class FlowPeopleLogOutPresenter {
    private HttpManager manager;

    public FlowPeopleLogOutPresenter(HttpManager manager) {
        this.manager = manager;
    }

    /**
     * 请求服务器进行注销
     *
     * @param flowPeopleLogOutReq 传入参数的实体类
     */
    public void logOutData(FlowPeopleLogOutReq flowPeopleLogOutReq) {
        manager.doHttpDeal(Utils.getContext().getString(R.string.dialog_select_loging),
                RetrofitHelper.getApiService().flowPeopleLogOut(flowPeopleLogOutReq),
                new DefaultObserver<Object>() {
                    @Override
                    public void onSuccess(Object obj) {

                    }
                });

    }
}
