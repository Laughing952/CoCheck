package com.login.ui.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

import com.commondata.event.RefreshEvent;
import com.login.R;
import com.login.api.S_DownLoadApp;
import com.login.bean.LoginInfo;
import com.login.databinding.ALoginBinding;
import com.login.help.PermissionsChecker;
import com.login.ui.mvpview.LoginView;
import com.login.ui.presenter.LoginPresenter;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ToastUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * 登录
 * Created by kb.zhang on 2018/4/8.
 */

public class A_Login extends BaseActivity implements LoginView<String> {

    private ALoginBinding binding;
    private LoginPresenter presenter;
    private HttpManager manager;

    private static final int REQUEST_CODE = 0; // 请求码
    private PermissionsChecker mPermissionsChecker; // 权限检测器
    //需要检测的权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    //更新弹出框
    private AlertDialog.Builder builder;
    private boolean isShowDialog = false;

    private boolean isRefresh = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        binding = DataBindingUtil.setContentView(this, R.layout.a_login);
        LoginInfo info = new LoginInfo();
        binding.setLoginInfo(info);
        initListener();

        manager = new HttpManager(this, this);
        presenter = new LoginPresenter(manager, this);
        mPermissionsChecker = new PermissionsChecker(this);
    }

    private void initListener() {
        binding.setClick(v -> {
            int i = v.getId();
            if (i == R.id.tv_login) {
                presenter.login(binding.getLoginInfo().getUser(), binding.getLoginInfo().getPassword());
            }
//            else if (i == R.id.tv_forget_password) {
//                A_Forget_Password.startActivity(this);
//            } else if (i == R.id.tv_go_register) {
//                A_Register.startActivity(this);
//            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            A_Permissions.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
        } else {
//            presenter.checkVersion();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //拒绝直接退出
        if (requestCode == REQUEST_CODE && resultCode == A_Permissions.PERMISSIONS_DENIED) {
            finish();
        }
    }

    @Override
    public void showLoading() {
        proDia.show();
    }

    @Override
    public void hideLoading() {
        proDia.dismiss();
    }

    @Override
    public void showData(String data) {
    }

    @Override
    public void showFailureMessage(String msg) {
        ToastUtil.showToast(this, msg);
    }

    @Override
    public void showErrorMessage(String msg) {
        ToastUtil.showToast(this, msg);
    }

    @Override
    public void loginSuccess() {
        // TODO: 2018/4/23
        binding.etPassword.setText("");
        if (getIntent().getBooleanExtra("isRefresh", false)) {
            EventBus.getDefault().post(new RefreshEvent());
            finish();
        } else {
            try {
                Intent intent = new Intent(this, Class.forName("com.unistrong.cocheck.MainActivity"));
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void downAppDialog(String strDownUrl) {
        if (builder == null) {
            builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle(R.string.apk_refresh);
            builder.setMessage(R.string.new_apk_refresh);
            // 更新
            builder.setPositiveButton(R.string.refresh, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    isShowDialog = false;
                    dialog.dismiss();
                    // 显示下载对话框
                    Intent serviceIntent = new Intent(A_Login.this, S_DownLoadApp.class);
                    serviceIntent.putExtra("url", strDownUrl);
                    startService(serviceIntent);
                }
            });
            // 稍后更新
            builder.setNegativeButton(R.string.refresh_late, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    isShowDialog = false;
                }
            });
            builder.create();
            LogUtil.d(TAG, "create dialog");
        }
        if (!isShowDialog) {
            builder.show();
            isShowDialog = true;
        }
    }

//    @Override
//    public void checkPhoneNumSucceed() {
//        binding.tilPhone.setErrorEnabled(false);
//    }
//
//    @Override
//    public void checkPhoneNumFailure(String msg) {
//        binding.tilPhone.setError(msg);
//    }
//
//    @Override
//    public void checkPasswordSucceed() {
//        binding.tilPassword.setErrorEnabled(false);
//    }
//
//    @Override
//    public void checkPasswordFailure(String msg) {
//        binding.tilPassword.setError(msg);
//    }
}
