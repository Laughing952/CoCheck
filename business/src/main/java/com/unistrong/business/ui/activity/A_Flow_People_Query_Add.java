package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.unistrong.business.R;
import com.unistrong.business.ui.presenter.FlowPeopleQueryAddPresenter;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.utile.StrUtil;
import com.waterbase.utile.ToastUtil;

import java.util.HashMap;

/**
 * 作者：Laughing on 2018/4/14 15:22
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Query_Add extends BaseTitleActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Query_Add.class));
    }

    private Context mContext = this;
    private Button mTvflowpeoplequeryaddreinput;
    private Button mTvflowpeoplequeryaddquery;
    private EditText mEtflowpeoplequeryaddid;
    private HttpManager manager;
    private FlowPeopleQueryAddPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        setView(R.layout.a_flow_people_query_add);
        manager = new HttpManager(this, this);
        presenter = new FlowPeopleQueryAddPresenter(manager, this);
        initTitle();
        initView();
        initListener();

    }


    private void initView() {
        mTvflowpeoplequeryaddreinput = (Button) findViewById(R.id.tv_flow_people_query_add_re_input);
        mTvflowpeoplequeryaddquery = (Button) findViewById(R.id.tv_flow_people_query_add_query);
        mEtflowpeoplequeryaddid = (EditText) findViewById(R.id.et_flow_people_query_add_id);

    }

    private void initListener() {
        mTvflowpeoplequeryaddreinput.setOnClickListener(v -> mEtflowpeoplequeryaddid.setText(""));
        mTvflowpeoplequeryaddquery.setOnClickListener(v -> {

            //1.效验身份证号
            verificationID();


        });

        /**
         * 点击手机软键盘enter键进行查询
         */
        mEtflowpeoplequeryaddid.setOnKeyListener((v, keyCode, event) -> {
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
        String id = mEtflowpeoplequeryaddid.getText().toString().trim();
        if (!StrUtil.isEmpty(id)) {
            if (StrUtil.isIDCardNum(id)) {
                queryAndJump(id);//网络请求
            } else {
                ToastUtil.showToast(mContext, "身份证号有误");

            }
        } else {
            ToastUtil.showToast(mContext, "请填写身份证号");

        }
    }

    private void queryAndJump(String idCardNum) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("idNum", idCardNum);
        map.put("currentPage", 1);
        map.put("pageSize", 10);
        presenter.queryAddPersonDetailsData(map);
//
//        doHTTPRequestBeforeJump();
//        A_People_Base_Info.startActivity(mContext);
    }

    private void doHTTPRequestBeforeJump() {
        // TODO: 2018/4/16 处理网络请求
    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("登记查询");//标题
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }


}
