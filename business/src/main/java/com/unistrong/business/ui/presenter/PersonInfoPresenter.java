package com.unistrong.business.ui.presenter;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.PersonListBean;
import com.unistrong.business.ui.mvpview.IPersonInfoView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;

/**
 * Created by kb.zhang on 2018/4/14.
 */

public class PersonInfoPresenter {
    private HttpManager manager;
    private IPersonInfoView view;

    public PersonInfoPresenter(HttpManager manager, IPersonInfoView view) {
        this.manager = manager;
        this.view = view;
    }

    /**
     * 获取详细信息
     * @param strNum
     */
    public void getPersonDetailsData (String strNum) {
        manager.doHttpDeal(RetrofitHelper.getApiService().getPersonData(strNum, 2),
                new DefaultObserver<PersonListBean>() {
                    @Override
                    public void onSuccess(PersonListBean response) {

                    }
                });
    }
}
