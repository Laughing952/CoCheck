package com.unistrong.business.ui.presenter;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.FlowPeopleEditReq;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;

/**
 * 编辑流动人口信息
 * 作者：Laughing on 2018/4/22 15:22
 * 邮箱：719240226@qq.com
 */
//暂时未使用
public class FlowPeopleEditPresenter {
    private HttpManager manager;

    public FlowPeopleEditPresenter(HttpManager manager) {
        this.manager = manager;
    }

    /**
     * 上传流动人口编辑后的信息
     *
     * @Body addReq
     */
    public void flowPeopleEditData(FlowPeopleEditReq editReq) {
        manager.doHttpDeal(RetrofitHelper.getApiService().flowPeopleEdit(editReq),
                new DefaultObserver<Object>() {
                    @Override
                    public void onSuccess(Object obj) {

                    }
                });
    }
}
