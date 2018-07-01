package com.login.ui.mvpview;

import com.login.bean.VersionInfo;
import com.waterbase.ui.BaseView;

/**
 * 登录页面的功能
 * Created by edz on 2018/3/23.
 */

public interface LoginView<T> extends BaseView<T>{

    /**
     * 登录成功
     */
    void loginSuccess ();

    /**
     * 更新APP对话框
     * @param strDownUrl 下载地址
     */
    void downAppDialog (String strDownUrl);

//    /**
//     * 校验手机号码成功
//     */
//    void checkPhoneNumSucceed();
//
//    /**
//     * 校验手机号码失败
//     * @param msg 失败原因
//     */
//    void checkPhoneNumFailure(String msg);
//
//    /**
//     * 校验密码成功
//     */
//    void checkPasswordSucceed();
//
//    /**
//     * 校验密码失败
//     * @param msg 失败原因
//     */
//    void checkPasswordFailure(String msg);

}
