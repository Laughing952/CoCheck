package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.commondata.bean.FlowPeopleAddInfoReq;
import com.commondata.event.RefreshEvent;
import com.statistics.R;
import com.statistics.databinding.APersonnelDetailsBinding;
import com.statistics.response.PersonnelDetailsRep;
import com.statistics.ui.mvpview.PersonnelDetailsView;
import com.statistics.ui.presenter.PersonnelDetailsPresenter;
import com.statistics.ui.viewmodel.PersonnelDetailsViewModel;

import org.greenrobot.eventbus.Subscribe;

/**
 * 人员详情
 * Created by Water on 2018/4/16.
 */

public class A_Personnel_Details extends TitleActivity implements PersonnelDetailsView<PersonnelDetailsViewModel> {

    public static final int REGISTER = 678; // 登记查询
    public static final int ASSISTANT_INVESTIGATION = 679; // 协查

    private APersonnelDetailsBinding binding;
    private PersonnelDetailsPresenter presenter;
    private String idCardNum;

    public static void startActivity(Context context, String idCardNum, int from) {
        Intent intent = new Intent(context, A_Personnel_Details.class);
        intent.putExtra("idCardNum", idCardNum);
        intent.putExtra("from", idCardNum);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, String idCardNum) {
        startActivity(context, idCardNum, -1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("人员详情");
//        idCardNum = getIntent().getStringExtra("idCardNum");
        idCardNum = "654223198704280917";
        binding = setView(R.layout.a_personnel_details);
        binding.setFrom(getIntent().getIntExtra("from", -1));

        presenter = new PersonnelDetailsPresenter(this, this, this);
        presenter.initData(idCardNum);
        initListener();
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        presenter.initData(idCardNum);
    }

    private void initListener() {
        binding.setClick(v -> {
            int i = v.getId();
            if (i == R.id.rl_family_members) {
                // 家庭成员
                A_Family_Members.startActivity(this, idCardNum);
            } else if (i == R.id.rl_marriage_information) {
                // 婚姻信息
                ;
                A_Marriage_Info.startActivity(this, idCardNum, presenter.getDetailsRep().getCoupleList());
            } else if (i == R.id.rl_motion_trail) {
                // 疆外活动轨迹
                A_Motion_Trail.startActivity(this, idCardNum);
            } else if (i == R.id.rl_column_information) {
                // 列管信息
                A_Column_Info.startActivity(this, idCardNum);
            } else if (i == R.id.rl_involved_information) {
                // 涉案信息
                A_Involved_Info.startActivity(this, idCardNum);
            } else if (i == R.id.tv_register) {
                // 登记
                try {
                    Intent intent = new Intent(this, Class.forName("com.unistrong.business.ui.activity.A_Flow_People_Add"));
                    intent.putExtra("infoReq",new FlowPeopleAddInfoReq("","","","","","","",""));
//                    intent.putExtra("headUrl", viewModel.getHeadUrl());
//                    intent.putExtra("name", viewModel.getName());
//                    intent.putExtra("idCardNum", viewModel.getIdCardNum());
//                    intent.putExtra("sex", viewModel.getDetails().getSex());
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (i == R.id.tv_assistant_investigation) {
                // 协查
                try {
                    Intent intent = new Intent(this, Class.forName(""));
                    PersonnelDetailsRep.PersonnelDetails details = viewModel.getDetails();
                    FlowPeopleAddInfoReq infoReq = new FlowPeopleAddInfoReq(details.getPersonAttr()
                            , details.getNation(), details.getRegionalism(), details.getSex(), details.getEduLevel()
                            , details.getIdNum(), details.getBirthday(),details.getName());
                    intent.putExtra("infoReq", infoReq);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    PersonnelDetailsViewModel viewModel;

    @Override
    public void resultData(PersonnelDetailsViewModel viewModel) {
        this.viewModel = viewModel;
        binding.setViewModel(viewModel);
    }
}
