package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.commondata.ui.activity.TitleActivity;
import com.unistrong.business.R;
import com.unistrong.business.databinding.AFlowPeopleQueryEditBinding;
import com.waterbase.utile.StrUtil;
import com.waterbase.utile.ToastUtil;

/**
 * 作者：Laughing on 2018/4/14 15:22
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Query_Edit extends TitleActivity {
    private Context mContext = this;
    private EditText mEtflowpeoplequeryeditid;
    private Button mTvflowpeoplequeryeditquery;
    private Button mTvflowpeoplequeryeditreinput;
    private AFlowPeopleQueryEditBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        mBinding = setView(R.layout.a_flow_people_query_edit);
        setTitleText("编辑查询");//标题
        initView();
        initListener();
        initData();
    }


    private void initView() {
        mTvflowpeoplequeryeditreinput = (Button) findViewById(R.id.tv_flow_people_query_edit_re_input);
        mTvflowpeoplequeryeditquery = (Button) findViewById(R.id.tv_flow_people_query_edit_query);
        mEtflowpeoplequeryeditid = (EditText) findViewById(R.id.et_flow_people_query_edit_id);
    }

    private void initData() {

    }

    private void initListener() {
        mTvflowpeoplequeryeditreinput.setOnClickListener(v -> mEtflowpeoplequeryeditid.setText(""));
        mTvflowpeoplequeryeditquery.setOnClickListener(v -> {

            //1.效验身份证号
            verificationID();

        });

        /**
         * 点击手机软键盘enter键进行查询
         */
        mEtflowpeoplequeryeditid.setOnKeyListener((v, keyCode, event) -> {
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

    //1.效验身份证号
    private void verificationID() {
        String id = mEtflowpeoplequeryeditid.getText().toString().trim();
        if (!StrUtil.isEmpty(id)) {
            if (StrUtil.isIDCardNum(id)) {

                queryAndJump();// 携带身份证号进行跳转
            } else {
                ToastUtil.showToast(mContext, "身份证号有误");

            }
        } else {
            ToastUtil.showToast(mContext, "请填写身份证号");

        }

    }

    private void queryAndJump() {
        Intent intent = new Intent(mContext, A_Flow_People_Edit_List.class);//携带数据跳转到编辑列表页面
        intent.putExtra("PersonIdNumber", mBinding.etFlowPeopleQueryEditId.getText().toString().trim());
        startActivity(intent);
    }


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Query_Edit.class));
    }


}
