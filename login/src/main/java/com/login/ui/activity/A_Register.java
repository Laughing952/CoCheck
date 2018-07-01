package com.login.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;

import com.login.R;
import com.login.bean.LoginInfo;
import com.login.databinding.ARegisterBinding;
import com.login.ui.mvpview.RegisterView;
import com.login.ui.presenter.RegisterPresenter;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.utile.ToastUtil;

/**
 * 注册页面
 * Created by edz on 2018/3/26.
 */

public class A_Register extends BaseTitleActivity implements RegisterView {


    private ARegisterBinding binding;
    private RegisterPresenter presenter;
    private LoginInfo loginInfo;

    // 获取验证码倒计时相关
    private int time = 60;
    boolean isGet = true;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if (time >= 0) {
                binding.tvGetCode.setText(String.valueOf(time) + "(s)");
                mHandler.postDelayed(mRunnable, 1000);
            } else {
                isGet = true;
                binding.tvGetCode.setText("获取验证码");
            }
        }
    };

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Register.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("用户注册");
        binding = setView(R.layout.a_register);
        presenter = new RegisterPresenter(this);
        loginInfo = new LoginInfo();
        binding.setLoginInfo(loginInfo);
        initListener();
    }

    private void initListener() {
        binding.etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.checkPhoneNum(loginInfo.getStrTel());
            }
        });
        binding.etPassword1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.checkPassword1(loginInfo.getPassword());
            }
        });
        binding.etPassword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.checkPassword2(loginInfo.getPassword());
            }
        });
        binding.setClick(v -> {
            if (v.getId() == R.id.tv_getCode) {
                // 获取验证码
                if (isGet) {
                    presenter.getCode(loginInfo.getStrTel());
                }
            } else if (v.getId() == R.id.tv_register) {
                // 注册
//                presenter.register(loginInfo.getstrTel(), loginInfo.getPassword()
//                        , loginInfo.getConfirmPassword(), loginInfo.getCode());
            }
        });
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
    public void getCodeSucceed() {

    }

    @Override
    public void registerSucceed(String data) {

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
    public void checkPhoneNumSucceed() {
        binding.tilPhone.setErrorEnabled(false);
    }

    @Override
    public void checkPhoneNumFailure(String msg) {
        binding.tilPhone.setErrorEnabled(true);
        binding.tilPhone.setError(msg);
    }

    @Override
    public void checkPsw1Succeed() {
        binding.tilPassword1.setErrorEnabled(false);
    }

    @Override
    public void checkPsw1Failure(String msg) {
        binding.tilPassword1.setErrorEnabled(true);
        binding.tilPassword1.setError(msg);
    }

    @Override
    public void checkPsw2Succeed() {
        binding.tilPassword2.setErrorEnabled(false);
    }

    @Override
    public void checkPsw2Failure(String msg) {
        binding.tilPassword2.setErrorEnabled(true);
        binding.tilPassword2.setError(msg);
    }

    @Override
    public void countdown() {
        time = 60;
        mHandler.post(mRunnable);
        isGet = false;
    }
}
