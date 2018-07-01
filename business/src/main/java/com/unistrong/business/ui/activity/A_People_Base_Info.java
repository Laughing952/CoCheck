package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

import com.unistrong.business.R;
import com.waterbase.ui.BaseTitleActivity;

/**
 * 作者：Laughing on 2018/4/17 16:09
 * 邮箱：719240226@qq.com
 */

public class A_People_Base_Info extends BaseTitleActivity {
    private Context mContext = this;
    private Button mBtpeoplebaseinfosend;
    private Button mBtpeoplebaseinforegister;
    private ScrollView mSvpeoplebaseinfocontent;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_People_Base_Info.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        setView(R.layout.a_people_base_info);
        initTitle();
        initView();
        initData();
        initListener();
    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("人员信息");//标题
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }

    private void initView() {
        mBtpeoplebaseinfosend = (Button) findViewById(R.id.bt_people_base_info_send);
        mBtpeoplebaseinforegister = (Button) findViewById(R.id.bt_people_base_info_register);
        mSvpeoplebaseinfocontent = (ScrollView) findViewById(R.id.sv_people_base_info_content);
    }


    private void initData() {

    }

    private void initListener() {
        mBtpeoplebaseinforegister.setOnClickListener(v -> A_Flow_People_Add.startActivity(mContext));
    }

}
