package com.unistrong.business.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.commondata.ui.activity.TitleActivity;
import com.commondata.util.TransformUtil;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleLogOutReq;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.databinding.AFlowPeopleLogOutBinding;
import com.unistrong.business.ui.presenter.FlowPeopleLogOutPresenter;
import com.waterbase.http.HttpManager;
import com.waterbase.utile.LogUtil;

import java.util.ArrayList;

/**
 * 流动人口注销
 * <p>
 * 作者：laughing on 2018/4/25 15:00
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Log_Out extends TitleActivity {

    private Context mContext = this;
    private FlowPeopleQueryItemRep mPerson;
    private FlowPeopleLogOutPresenter mFlowPeopleLogOutPresenter;
    private AFlowPeopleLogOutBinding binding;
    private ArrayList<String> mPersonFlowIdList;

    public static void startActivity(Context context, FlowPeopleQueryItemRep itemRep) {
        Intent intent = new Intent(context, A_Flow_People_Log_Out.class);
        intent.putExtra("PersonLogOut", itemRep);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("注销");
        binding = setView(R.layout.a_flow_people_log_out);
        initData();
        initListener();
    }

    private void initData() {
        mPersonFlowIdList = new ArrayList<>();

        mFlowPeopleLogOutPresenter = new FlowPeopleLogOutPresenter(new HttpManager(this, this));
        mPerson = (FlowPeopleQueryItemRep) getIntent().getSerializableExtra("PersonLogOut");
//            binding.ivFlowPeopleManagementDetailsImg.setImageBitmap(
//                    BitmapFactory.decodeFile(mPerson.getPhotoUrl()));  //人员图像
        showFlowPeopleInfo();
        mPersonFlowIdList.add(mPerson.getPersonFlowId());
        LogUtil.e("TAG", "laughing----------mPerson.getPersonFlowId()------------>   " + mPerson.getPersonFlowId());
    }

    /**
     * 流动信息添加到页面上
     */
    private void showFlowPeopleInfo() {
        binding.tvFlowPeopleLogOutName.setText(mPerson.getName());//姓名

        binding.tvFlowPeopleLogOutIncomeDate.setText(mPerson.getFlowInTime());//流入日期 (格式：yyyyMMdd)
        binding.tvFlowPeopleLogOutStayTime.setText(TransformUtil.stayTempTransformNum2String(mPerson.getPlanLiveTime())); //拟居住时间
        binding.tvFlowPeopleLogOutTempHouse.setText(mPerson.getTempLivePlace());//暂居住处所
        binding.tvFlowPeopleLogOutStayReason.setText(TransformUtil.stayReasonTransformNum2String(mPerson.getTempLiveReason()));//暂居事由
        binding.tvFlowPeopleLogOutJob.setText(mPerson.getCareers());//从事职业
        binding.tvFlowPeopleLogOutDetailAddressArea.setText(mPerson.getTempLiveArea());//暂居地（省市县区）code
        binding.tvFlowPeopleLogOutDetailAddress.setText(mPerson.getTempLivePlace());//暂居地（省市县区）详细地址
    }

    private void initListener() {
        binding.btFlowPeopleLogOutLogOut.setOnClickListener(v -> {
            showNoticeDialog(mFlowPeopleLogOutPresenter);//显示对话框 点击确定 进行注销
        });
    }


    /**
     * 显示是否注销对话框
     *
     * @param flowPeopleLogOutPresenter 控制类
     */
    public void showNoticeDialog(FlowPeopleLogOutPresenter flowPeopleLogOutPresenter) {
        // 构造对话框

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("注销");
        builder.setMessage("确定要注销吗？");
        // 更新
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                flowPeopleLogOutPresenter.logOutData(new FlowPeopleLogOutReq(mPersonFlowIdList, mPerson.getLogoutTag()));
                dialog.dismiss();
            }
        });
        // 稍后更新
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }

}
