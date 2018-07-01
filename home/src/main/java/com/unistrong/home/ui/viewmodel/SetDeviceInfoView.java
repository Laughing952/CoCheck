package com.unistrong.home.ui.viewmodel;

import com.unistrong.home.bean.HomeItemIcon;
import com.commondata.bean.PersonBean;

import java.util.List;

/**
 * Created by Water on 2018/4/10.
 */

public interface SetDeviceInfoView {
    void locationResult(String s);

    void resultData(List<HomeItemIcon> itemIcons);

    void startActivity(String className);

    void startActivity(String className,String idCardNum);

    void searchPerson (PersonBean bean);

    void toastError (int nError);
}
