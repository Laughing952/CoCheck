package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.commondata.ui.activity.TitleActivity;
import com.commondata.util.TransformUtil;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.databinding.ActivityMovePeopleManagementDetailsBinding;
import com.unistrong.business.ui.presenter.FlowPeopleLogOutPresenter;
import com.unistrong.business.utile.LoadImageUtile;

/**
 * 流动人口管理详情
 * <p>
 * 作者：cuihao on 2018/4/11 15:16
 * 邮箱：583576071@qq.com
 */

public class A_Move_People_Management_Details extends TitleActivity {

    private Context mContext = this;
    private FlowPeopleQueryItemRep mPerson;
    private FlowPeopleLogOutPresenter mFlowPeopleLogOutPresenter;
    private ActivityMovePeopleManagementDetailsBinding binding;

    public static void startActivity(Context context, FlowPeopleQueryItemRep itemRep) {
        Intent intent = new Intent(context, A_Move_People_Management_Details.class);
        intent.putExtra("detailsData", itemRep);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("人员信息");
        binding = setView(R.layout.activity_move_people_management_details);
        initData();
        initListener();
    }


    private void initData() {
        mPerson = (FlowPeopleQueryItemRep) getIntent().getSerializableExtra("detailsData");
        if (mPerson != null) {
            LoadImageUtile.loadCircleImage(binding.ivFlowPeopleManagementDetailsImg,mPerson.getPhotoUrl());  //人员图像
            binding.tvFlowPeopleManagementDetailsName.setText(mPerson.getName());//姓名
            binding.tvFlowPeopleManagementDetailsPeopleClassify.setText(
                    TransformUtil.personAttrformString(mPerson.getPersonAttrType()));//人员属性
            binding.tvFlowPeopleManagementDetailsId.setText(mPerson.getIdNum()); //身份证号
            binding.tvFlowPeopleManagementDetailsSex.setText(TransformUtil.sexTransformString(mPerson.getSex()));   //性别
            binding.tvFlowPeopleManagementDetailsNation.setText(TransformUtil.nationTransform(mPerson.getNation()));//民族                        //生日
            binding.tvFlowPeopleManagementDetailsBirthData.setText(mPerson.getBirthday());//生日
            binding.tvFlowPeopleManagementDetailsStature.setText(mPerson.getHeight());//身高
            if (mPerson.getBloodType()!=null) {
                binding.tvFlowPeopleManagementDetailsBloodType.setText(
                        TransformUtil.bloodTransform(Integer.parseInt(mPerson.getBloodType())));//血型
            }
            binding.tvFlowPeopleManagementDetailsEduLevel.setText(mPerson.getEduLevelName());//教育程度
            if (mPerson.getMarriageStatus()!=null) {
                binding.tvFlowPeopleManagementDetailsBmaritalStatus.setText(
                        TransformUtil.marriageTransformString(Integer.parseInt(mPerson.getMarriageStatus())));//婚姻状况
            }
            binding.tvFlowPeopleManagementDetailsPoliticsStatus.setText(mPerson.getPoliticalStatusName());//政治面貌
            binding.tvFlowPeopleManagementDetailsWork.setText(mPerson.getCareersName());//职业
            binding.tvFlowPeopleManagementDetailsPermanentServiceSpace.setText(mPerson.getWorkPlace());//服务处所
            binding.tvFlowPeopleManagementDetailsPermanentAddress.setText(mPerson.getHouseholdAddress());//户籍地址
            binding.tvFlowPeopleManagementDetailsRegistrationtHouseholdUnit.setText(mPerson.getBelongToPoliceDepart());//户籍责任区单位
            binding.tvFlowPeopleManagementDetailsPoliceRoomPhone.setText(mPerson.getPoliceStatioTel());//警务室民警联系电话
            binding.tvFlowPeopleManagementDetailsCommunityPhone.setText(mPerson.getCommunityTel());//社区干部联系电话
            binding.tvFlowPeopleManagementDetailsRegistrationtHouseholdCommunity.setText(mPerson.getHouseholdAreaName());//户籍责任区社区
        }
    }

    private void initListener() {
        binding.tvViewMore.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(A_Move_People_Management_Details.this,
                        Class.forName("com.statistics.ui.acitivty.A_Personnel_Details"));
                intent.putExtra("idCardNum", mPerson.getIdNum());
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

}
