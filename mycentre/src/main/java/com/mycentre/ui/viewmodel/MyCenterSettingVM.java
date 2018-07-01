package com.mycentre.ui.viewmodel;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.mycentre.R;
import com.mycentre.api.RetrofitHelper;
import com.mycentre.bean.VersionInfo;
import com.mycentre.ui.view.ISettingView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseApplication;
import com.waterbase.utile.Utils;

/**
 * 个人设置VM
 * Created by kb.zhang on 2018/4/13.
 */

public class MyCenterSettingVM {
    private HttpManager manager;
    private ISettingView view;

    public MyCenterSettingVM(HttpManager manager, ISettingView view) {
        this.manager = manager;
        this.view = view;
    }

    /**
     * 验证版本
     */

    public void checkVersion () {
        manager.doHttpDeal(BaseApplication.getAppContext().getString(R.string.dialog_check_version), RetrofitHelper.getApiService().getVersion(),

                new DefaultObserver<VersionInfo>() {
                    @Override
                    public void onSuccess(VersionInfo response) {
                        PackageManager packageManager = BaseApplication.getAppContext().getPackageManager();
                        PackageInfo info;
                        try {
                            /*获取本地版本号*/
                            info = packageManager.getPackageInfo(Utils.getContext().getPackageName(), 0);
                            int versionCode = info.versionCode;
                            if (versionCode < response.getnCode()) {//本地版本低于服务器版本，则更新APK
                                view.showDownLoadAPKDialog(response.getStrDownUrl());
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
