package com.login.ui.presenter;

import android.util.Log;

import com.login.help.CheckHelp;
import com.login.ui.mvpview.ForgetPswView;
import com.login.ui.mvpview.RegisterView;
import com.waterbase.utile.StrUtil;

/**
 * 忘记密码
 * Created by edz on 2018/3/27.
 */

public class ForgetPswPresenter {

    private static final String TAG = "ForgetPswPresenter";
    // View接口
    private ForgetPswView mView;

    public ForgetPswPresenter(ForgetPswView view) {
        this.mView = view;
    }

    public void setupdataPassword(String phoneNum, String password, String confirmPassword, String code){
        Log.d(TAG, "phoneNum:" + phoneNum + "  password:" + password);
        CheckHelp.CheckResult result = null;
        result = CheckHelp.checkPhoneNum(phoneNum);
        if (!result.isSucceed){
            mView.showFailureMessage(result.msg);
            return;
        }
        result = CheckHelp.checkPassword(password);
        if (!result.isSucceed){
            mView.showFailureMessage(result.msg);
            return;
        }
        result = CheckHelp.checkPassword(confirmPassword);
        if (!result.isSucceed){
            mView.showFailureMessage(result.msg);
            return;
        }
        if (!password.equals(confirmPassword)) {
            mView.checkPhoneNumFailure("您输入的密码不一致");
            return;
        }
        if (StrUtil.isEmpty(code)) {
            mView.showFailureMessage("验证码不能为空");
            return;
        }
        mView.showLoading();
        // todo 忘记密码
    }

    public void getCode(String phoneNum) {
        Log.d(TAG, "phoneNum:" + phoneNum);
        CheckHelp.CheckResult result = CheckHelp.checkPhoneNum(phoneNum);
        if (!result.isSucceed)
            mView.showFailureMessage(result.msg);
        else {
            mView.countdown();
            mView.showLoading();
            // todo 获取验证码

        }
    }

    /**
     * 手机号码校验
     *
     * @param phoneNum 电话号码
     */
    public void checkPhoneNum(String phoneNum) {
        CheckHelp.CheckResult result = CheckHelp.checkPhoneNum(phoneNum);
        if (result.isSucceed)
            mView.checkPhoneNumSucceed();
        else
            mView.checkPhoneNumFailure(result.msg);
    }

    /**
     * 密码格式校验
     *
     * @param psw 密码
     */
    public void checkPassword1(String psw) {
        CheckHelp.CheckResult result = CheckHelp.checkPassword(psw);
        if (result.isSucceed)
            mView.checkPsw1Succeed();
        else
            mView.checkPsw1Failure(result.msg);
    }

    /**
     * 密码格式校验
     *
     * @param psw 密码
     */
    public void checkPassword2(String psw) {
        CheckHelp.CheckResult result = CheckHelp.checkPassword(psw);
        if (result.isSucceed)
            mView.checkPsw2Succeed();
        else
            mView.checkPsw2Failure(result.msg);
    }

}
