package com.login.ui.presenter;

import com.login.api.RetrofitHelper;
import com.login.bean.UserBean;
import com.login.help.CheckHelp;
import com.login.ui.mvpview.LoginView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseApplication;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.PreferencesManager;


/**
 * Created by edz on 2018/3/23.
 */

public class LoginPresenter {
    private static final String TAG = "LoginPresenter";
    // View接口
    private LoginView mView;
    private HttpManager manager;

    public LoginPresenter(HttpManager manager, LoginView view) {
        this.mView = view;
        this.manager = manager;
    }

    /**
     * 登录
     * @param strUser 用户名
     * @param strPwd 密码
     */
    public void login(String strUser, String strPwd) {
        // todo 登录
        LogUtil.d(TAG, "user:" + strUser + "  password:" + strPwd);
        CheckHelp.CheckResult result;
        result = CheckHelp.checkUser(strUser);
        if (!result.isSucceed) {
            mView.showFailureMessage(result.msg);
            return;
        }
        result = CheckHelp.checkPassword(strPwd);
        if (!result.isSucceed) {
            mView.showFailureMessage(result.msg);
            return;
        }
//        mView.loginSuccess();
        manager.doHttpDeal(RetrofitHelper.getApiService().login(strUser, strPwd)
                , new DefaultObserver<UserBean>() {
                    @Override
                    public void onSuccess(UserBean response) {
                        PreferencesManager.getInstance(BaseApplication.getAppContext()).put("token",response.getToken());
                        mView.loginSuccess();
                    }
                });
    }

    /**
     * 验证版本
     */
    public void checkVersion () {

        mView.downAppDialog("http://dl.360safe.com/mzm/360clockweather.apk");

//        manager.doHttpDeal(MyApplication.getAppContext().getString(R.string.dialog_check_version), RetrofitHelper.getApiService().getVersion(),
//                new DefaultObserver<VersionInfo>() {
//                    @Override
//                    public void onSuccess(VersionInfo response) {
//                        PackageManager packageManager = MyApplication.getAppContext().getPackageManager();
//                        PackageInfo info;
//                        try {
//                            /*获取本地版本号*/
//                            info = packageManager.getPackageInfo(MyApplication.getAppContext().getPackageName(), 0);
//                            int versionCode = info.versionCode;
//                            if (versionCode < response.getnCode()) {//本地版本低于服务器版本，则更新APK
//                                mView.downAppDialog(response.getStrDownUrl());
//                            }
//                        } catch (PackageManager.NameNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
    }

}
