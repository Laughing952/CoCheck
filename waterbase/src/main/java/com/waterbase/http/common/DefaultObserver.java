package com.waterbase.http.common;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.waterbase.R;
import com.waterbase.http.exception.ServerResponseException;
import com.waterbase.ui.BaseApplication;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ToastUtil;
import com.waterbase.utile.Utils;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by zhpan on 2017/4/18.
 */

public abstract class DefaultObserver<T> implements Observer<T> {

    private Context context;

//    public DefaultObserver(Context context) {
//        this.context = context;
//    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T response) {
        onSuccess(response);
    }

    @Override
    public void onError(Throwable e) {
        if (e!=null){
            LogUtil.e("Retrofit", e.getMessage() + "");
            if (e instanceof HttpException) {     //   HTTP错误
                onException(ExceptionReason.BAD_NETWORK);
            } else if (e instanceof ConnectException
                    || e instanceof UnknownHostException) {   //   连接错误
                onException(ExceptionReason.CONNECT_ERROR);
            } else if (e instanceof InterruptedIOException) {   //  连接超时
                onException(ExceptionReason.CONNECT_TIMEOUT);
            } else if (e instanceof JsonParseException
                    || e instanceof JSONException
                    || e instanceof ParseException) {   //  解析错误
                onException(ExceptionReason.PARSE_ERROR);
            } else if (e instanceof ServerResponseException) {
                onFail(Integer.parseInt(e.getCause().getMessage()), e.getMessage());
            } else {
                onException(ExceptionReason.UNKNOWN_ERROR);
            }
        }

    }

    @Override
    public void onComplete() {
    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    abstract public void onSuccess(T response);

    /**
     * 服务器返回数据，但响应码不为200
     *
     */
    /**
     * 服务器返回数据，但响应码不为1000
     */
    public void onFail(int errorCode, String cause) {
        LogUtil.d("---------", "---------------" + cause);
        if (errorCode == ErrorCode.TOKEN_PAST) {
            try {
                Intent intent = new Intent(context, Class.forName("com.login.ui.activity.A_Login"));
                intent.putExtra("isRefresh", true);
                context.startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ToastUtil.showToast(Utils.getContext(), cause);
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtil.showToast(Utils.getContext(), R.string.connect_error);
                break;

            case CONNECT_TIMEOUT:
                ToastUtil.showToast(Utils.getContext(), R.string.connect_timeout);
                break;

            case BAD_NETWORK:
                ToastUtil.showToast(Utils.getContext(), R.string.bad_network);
                break;

            case PARSE_ERROR:
                ToastUtil.showToast(Utils.getContext(), R.string.parse_error);
                break;

            case UNKNOWN_ERROR:
            default:
                ToastUtil.showToast(Utils.getContext(), R.string.unknown_error);
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }
}
