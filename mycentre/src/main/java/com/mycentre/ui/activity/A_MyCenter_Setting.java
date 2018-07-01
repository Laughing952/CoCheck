package com.mycentre.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.mycentre.R;
import com.mycentre.databinding.AMycenterSettingBinding;
import com.mycentre.ui.view.ISettingView;
import com.mycentre.ui.viewmodel.MyCenterSettingVM;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.utile.AppManager;

/**
 * 作者：Laughing on 2018/4/12 22:47
 * 邮箱：719240226@qq.com
 */

public class A_MyCenter_Setting extends BaseTitleActivity implements ISettingView {
    private Context mContext=this;
    private AMycenterSettingBinding binding;
    private MyCenterSettingVM settingVM;

    private AlertDialog.Builder builderDownLoadAPK;
    private AlertDialog.Builder builderExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = setView(R.layout.a_mycenter_setting);
        HttpManager manager = new HttpManager(this, this);
        settingVM = new MyCenterSettingVM(manager, this);
        initTitle();
        initListener();
    }

    private void initListener() {
        binding.setClick(v -> {
            if (v.getId() == R.id.rl_my_center_setting_update_app) {
                settingVM.checkVersion();
            } else if (v.getId() == R.id.rl_my_center_setting_log_out) {
                showExitAPK();
            } else if (v.getId() == R.id.rl_my_center_setting_read_me) {
                startActivity(new Intent(mContext, A_Read_Me.class));
            }
        });
    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("设置");//标题
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }

    @Override
    public void showDownLoadAPKDialog(String strUrl) {
        if (builderDownLoadAPK == null) {
            builderDownLoadAPK = new AlertDialog.Builder(this);
            builderDownLoadAPK.setCancelable(false);
            builderDownLoadAPK.setTitle(R.string.apk_refresh);
            builderDownLoadAPK.setMessage(R.string.new_apk_refresh);
            // 更新
            builderDownLoadAPK.setPositiveButton(R.string.refresh, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    // 显示下载对话框
                    Intent serviceIntent = null;
                    try {
                        serviceIntent = new Intent(A_MyCenter_Setting.this, Class.forName("com.login.api.S_DownLoadApp"));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    serviceIntent.putExtra("url", strUrl);
                    startService(serviceIntent);
                }
            });
            // 稍后更新
            builderDownLoadAPK.setNegativeButton(R.string.refresh_late, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builderDownLoadAPK.create();
        }
        builderDownLoadAPK.show();
    }

    /**
     * 退出对话框
     */
    public void showExitAPK() {
        if (builderExit == null) {
            builderExit = new AlertDialog.Builder(this);
            builderExit.setCancelable(false);
            builderExit.setTitle(R.string.exit);
            builderExit.setMessage(R.string.exit_apk_msg);
            // 确定
            builderExit.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = null;
                    try {
                        intent = new Intent(A_MyCenter_Setting.this, Class.forName("com.login.ui.activity.A_Login"));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    startActivity(intent);
                    AppManager.getAppManager().finishAllActivity();
                }
            });
            // 取消
            builderExit.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builderExit.create();
        }
        builderExit.show();
    }
}
