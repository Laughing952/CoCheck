package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.commondata.ui.activity.TitleActivity;
import com.unistrong.business.R;
import com.unistrong.business.databinding.AFlowPeopleQueryLogOutBinding;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.StrUtil;
import com.waterbase.utile.ToastUtil;

/**
 * 注销查询：查询之后进行注销
 * 作者：Laughing on 2018/4/14 15:31
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Query_Log_Out extends TitleActivity {
    private Context mContext = this;
    private AFlowPeopleQueryLogOutBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        mBinding = setView(R.layout.a_flow_people_query_log_out);
        setTitleText("注销查询");//标题
        initView();
        initData();
        initListener();

    }

    private void initData() {

    }

    private void initListener() {

        mBinding.tvFlowPeopleQueryLogOutReInput.setOnClickListener(v -> mBinding.etFlowPeopleQueryLogOutId.setText(""));
        mBinding.tvFlowPeopleQueryLogOutQuery.setOnClickListener(v -> {
            verificationID();
        });
        /**
         * 点击手机软键盘enter键进行查询
         */
        mBinding.etFlowPeopleQueryLogOutId.setOnKeyListener((v, keyCode, event) -> {
            switch (keyCode) {
                case KeyEvent.KEYCODE_ENTER:
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:
                            //1.效验身份证号
                            verificationID();
                            break;
                    }
                    break;
            }
            return false;
        });

    }


    //效验身份证号
    private void verificationID() {
        String id = mBinding.etFlowPeopleQueryLogOutId.getText().toString().trim();
        LogUtil.e("TAG", "laughing---------------------->   " + id);
        if (!StrUtil.isEmpty(id)) {
            if (StrUtil.isIDCardNum(id)) {
                queryAndJump();//携带身份证号跳转
            } else {
                ToastUtil.showToast(mContext, "身份证号有误");

            }
        } else {
            ToastUtil.showToast(mContext, "请填写身份证号");

        }
    }

    private void queryAndJump() {
        Intent intent = new Intent(mContext, A_Flow_People_Log_Out_List.class);
        intent.putExtra("PersonIdLogOut", mBinding.etFlowPeopleQueryLogOutId.getText().toString().trim());
        startActivity(intent);

    }

    private void initView() {

    }

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Query_Log_Out.class));
    }

}
