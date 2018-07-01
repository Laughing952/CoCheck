package com.unistrong.business.ui.presenter;

import com.unistrong.business.R;
import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.ui.mvpview.ILogOutQueryInfoView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.utile.Utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 根据身份证号查询人员信息，拿到人员ID（为了进行注销）
 * 作者：Laughing on 2018/4/21 10:29
 * 邮箱：719240226@qq.com
 */

public class LogOutQueryPresenter {
    private HttpManager manager;
    private ILogOutQueryInfoView infoView;

    public LogOutQueryPresenter(HttpManager manager, ILogOutQueryInfoView infoView) {
        this.manager = manager;
        this.infoView = infoView;
    }

    /**
     * 根据身份证号查询人员信息，拿到人员ID进行注销操作
     *
     * @param flowPeopleList 身份证号
     */
    public void selectData(HashMap<String, Object> flowPeopleList) {
        manager.doHttpDeal(Utils.getContext().getString(R.string.dialog_select_wait),
                RetrofitHelper.getApiService().uploadFlowPeopleData(flowPeopleList),
                new DefaultObserver<ArrayList<FlowPeopleQueryItemRep>>() {
                    @Override
                    public void onSuccess(ArrayList<FlowPeopleQueryItemRep> queryRep) {
                        infoView.getFlowListBean(queryRep);
//                        ToastUtil.showToast(Utils.getContext(), "请稍后...... ");
                    }
                });

    }


}
