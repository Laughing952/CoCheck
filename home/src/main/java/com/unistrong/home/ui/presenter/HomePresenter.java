package com.unistrong.home.ui.presenter;

import com.unistrong.home.R;
import com.unistrong.home.bean.HomeItemIcon;
import com.unistrong.home.ui.viewmodel.SetDeviceInfoView;
import com.waterbase.http.HttpManager;
import com.waterbase.utile.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Water on 2018/4/10.
 */

public class HomePresenter {
    private HttpManager manager;
    private SetDeviceInfoView infoView;

    public HomePresenter(HttpManager manager, SetDeviceInfoView infoView) {
        this.manager = manager;
        this.infoView = infoView;
    }

    public void initData() {
        List<HomeItemIcon> datas = new ArrayList<HomeItemIcon>();
        datas.add(new HomeItemIcon(0, "登记", R.mipmap.ic_home_login));
        datas.add(new HomeItemIcon(1, "查询", R.mipmap.ic_home_query));
        datas.add(new HomeItemIcon(2, "编辑", R.mipmap.ic_home_edit));
        datas.add(new HomeItemIcon(3, "注销", R.mipmap.ic_home_log_out));
        datas.add(new HomeItemIcon(4, "人像对比", R.mipmap.ic_home_people_photo_comparison));
        datas.add(new HomeItemIcon(5, "登记历史", R.mipmap.ic_home_co_check_request));
        infoView.resultData(datas);
    }

    public void click(HomeItemIcon itemIcon) {
        switch (itemIcon.getIconId()) {
            case 0:
                //  登记
                infoView.startActivity("com.unistrong.business.ui.activity.A_Flow_People_Query_Add");
                break;
            case 1:
                //  查询
                infoView.startActivity("com.unistrong.business.ui.activity.A_Flow_People_Query");
                break;
            case 2:
                //  编辑
                infoView.startActivity("com.unistrong.business.ui.activity.A_Flow_People_Query_Edit");
                break;
            case 3:
                //  注销
                infoView.startActivity("com.unistrong.business.ui.activity.A_Flow_People_Query_Log_Out");
                break;
            case 4:
                //  人像对比
                infoView.startActivity("com.unistrong.business.ui.activity.A_People_Photo_Comparison");
                break;
            case 5:
                //  协查申请
                infoView.startActivity("com.unistrong.business.ui.activity.A_Flow_People_Add_History");
                break;
        }
    }

    /**
     * 根据身份证号查询人员基本信息
     *
     * @param strNum 身份证号
     */
    public void selectData(String strNum) {
        if (StrUtil.isIDCardNum(strNum)) {

            infoView.startActivity("com.statistics.ui.acitivty.A_Personnel_Details",strNum);
//            manager.doHttpDeal(Utils.getContext().getString(R.string.dialog_select_wait),
//                    RetrofitHelper.getApiService().getPersonData(strNum, 1),
//                    new DefaultObserver<PersonListBean>() {
//                        @Override
//                        public void onSuccess(PersonListBean response) {
//                            infoView.searchPerson(response.getPerson());
//                        }
//                    });
        } else {
            infoView.toastError(R.string.toast_error_id_card);
        }

    }

}
