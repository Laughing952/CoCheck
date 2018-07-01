package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.commondata.ui.activity.TitleActivity;
import com.commondata.util.PickerViewUtil;
import com.commondata.util.RequestTransformUtil;
import com.commondata.util.TransformUtil;
import com.commondata.viewmodel.MyCenterSexViewModel;
import com.commondata.viewmodel.ProvinceViewModel;
import com.commondata.viewmodel.TempStayAddressViewModel;
import com.commondata.viewmodel.TempStayReasonViewModel;
import com.commondata.viewmodel.TempStayTimeViewModel;
import com.commondata.viewmodel.TempWorkViewModel;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleEditReq;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.databinding.AFlowPeopleEditBinding;
import com.unistrong.business.ui.presenter.FlowPeopleEditPresenter;
import com.waterbase.http.HttpManager;
import com.waterbase.utile.ToastUtil;

import java.util.List;

/**
 * 流动人口编辑页面
 * <p>
 * 作者：Laughing on 2018/4/11 16:00
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Edit extends TitleActivity {
    private Context mContext = this;
    private List<MyCenterSexViewModel> mSexList;
    private List<TempStayTimeViewModel> mTempStayTimeList;
    private List<ProvinceViewModel> mProvinceList;
    private FlowPeopleQueryItemRep mFlowPeopleQueryItemRep;
    private AFlowPeopleEditBinding binding;
    private List<TempStayReasonViewModel> mTempStayReasonViewModelList;
    private List<TempWorkViewModel> mTempWorkViewModels;
    private List<TempStayAddressViewModel> mTempStayAddressViewModels;
    private String mPersonFlowId;
    private FlowPeopleEditPresenter mFlowPeopleEditPresenter;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Edit.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        binding = setView(R.layout.a_flow_people_edit);
        setTitleText("编辑");//标题
        initView();
        initData();
        initListener();
    }

    private void initData() {
        mFlowPeopleEditPresenter = new FlowPeopleEditPresenter(new HttpManager(this, this));
        initSexData();
        initTempStayTimeData();
        initProvinceData();
        initStayReasonData();
        initJobData();
        initTempStayHomeData();

        mFlowPeopleQueryItemRep = (FlowPeopleQueryItemRep) getIntent().getSerializableExtra("PersonBeanFromQueryEdit");
        binding.tvFlowPeopleEditId.setText(mFlowPeopleQueryItemRep.getIdNum());//身份证号
        binding.tvFlowPeopleEditName.setText(mFlowPeopleQueryItemRep.getName());//姓名
//        /**
//         * 判断数据库返回的字符代码，1：表示 男
//         */
        binding.tvFlowPeopleEditSex.setText(TransformUtil.sexTransformString(mFlowPeopleQueryItemRep.getSex()));//性别


        binding.tvFlowPeopleEditIncomeDate.setText(mFlowPeopleQueryItemRep.getFlowInTime());//流入日期 (格式：yyyyMMdd)
        binding.tvFlowPeopleEditHowLong.setText(TransformUtil.stayTempTransformNum2String(mFlowPeopleQueryItemRep.getPlanLiveTime()));//拟居住时间 (格式：yyyyMMdd)
        binding.tvFlowPeopleEditTempHomeProvince.setText(mFlowPeopleQueryItemRep.getTempLivePlace());//暂居住处所
        binding.tvFlowPeopleEditWhyComeHere.setText(TransformUtil.stayReasonTransformNum2String(mFlowPeopleQueryItemRep.getTempLiveReason()));//暂居事由
        binding.tvFlowPeopleEditWork.setText(mFlowPeopleQueryItemRep.getCareers());//从事职业
        binding.tvFlowPeopleEditTempHomeProvince.setText(mFlowPeopleQueryItemRep.getTempLiveArea());//暂居地（省市县区）code
        binding.tvFlowPeopleEditTempHomeCityDetail.setText(mFlowPeopleQueryItemRep.getTempLivePlace());//暂居地（省市县区）详细地址

        binding.tvFlowPeopleEditPhoneNumber.setText(mFlowPeopleQueryItemRep.getTel());//登记人联系电话
        binding.tvFlowPeopleEditRegisterDate.setText(mFlowPeopleQueryItemRep.getRegisterDate());//登记日期
        mPersonFlowId = mFlowPeopleQueryItemRep.getPersonFlowId();
    }

    private void initTempStayHomeData() {
        mTempStayAddressViewModels = RequestTransformUtil.initTempStayAddressData();
    }

    private void initJobData() {
        mTempWorkViewModels = RequestTransformUtil.initTempWorkData();
    }

    //居住事由数据初始化
    private void initStayReasonData() {
        mTempStayReasonViewModelList = RequestTransformUtil.initTempStayReasonData();
    }

    private void initProvinceData() {
        mProvinceList = RequestTransformUtil.initProvinceData();
    }

    //拟居住时间
    private void initTempStayTimeData() {
        mTempStayTimeList = RequestTransformUtil.initTempStayTimeData();
    }

    private void initSexData() {
        mSexList = RequestTransformUtil.initSexData();
    }


    private void initListener() {
        binding.tvFlowPeopleEditIncomeDate.setOnClickListener(v -> getDate(binding.tvFlowPeopleEditIncomeDate, "流入日期"));

        binding.tvFlowPeopleEditHowLong.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择暂时居住时间", new PickerViewUtil.SelectResultListener<TempStayTimeViewModel>() {
            @Override
            public void result(TempStayTimeViewModel model) {
                binding.tvFlowPeopleEditHowLong.setText(model.getDays());
            }
        }, mTempStayTimeList));
        binding.tvFlowPeopleEditRegisterDate.setOnClickListener(v -> getDate(binding.tvFlowPeopleEditRegisterDate, "登记日期"));
        binding.tvFlowPeopleEditSave.setOnClickListener(v -> {
            ToastUtil.showToast(mContext, "正在保存请稍后...");
            doHttpRequest();
        });

        binding.tvFlowPeopleEditWhyComeHere.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "暂（居）住事由", new PickerViewUtil.SelectResultListener<TempStayReasonViewModel>() {
            @Override
            public void result(TempStayReasonViewModel model) {
                binding.tvFlowPeopleEditWhyComeHere.setText(model.getStayReason());
                ToastUtil.showToast(mContext, model.getStayReason());
            }
        }, mTempStayReasonViewModelList));
        binding.tvFlowPeopleEditWork.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "从事职业", new PickerViewUtil.SelectResultListener<TempWorkViewModel>() {
            @Override
            public void result(TempWorkViewModel model) {
                binding.tvFlowPeopleEditWork.setText(model.getWork());
                ToastUtil.showToast(mContext, model.getWork());
            }
        }, mTempWorkViewModels));
        binding.tvFlowPeopleEditTempHome.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "暂（居）处所", new PickerViewUtil.SelectResultListener<TempStayAddressViewModel>() {
            @Override
            public void result(TempStayAddressViewModel model) {
                binding.tvFlowPeopleEditTempHome.setText(model.getAddress());
                ToastUtil.showToast(mContext, model.getAddress());
            }
        }, mTempStayAddressViewModels));

    }

    /**
     * 发起网络请求保存修改数据
     */
    private void doHttpRequest() {
        // TODO: 2018/4/22 发起网络请求 进行数据保存
        mFlowPeopleEditPresenter.flowPeopleEditData(getRequestParams());
    }

    //    {
//            "flowInTime":
//            "personFlowId":
//            "planLiveTime":
//            "registerMobile":
//            "tempLiveAddress":
//            "tempLiveArea":
//            "tempLivePlace":
//            "tempLiveReason":
//            "work":
//    }
    private FlowPeopleEditReq getRequestParams() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("flowInTime", );
//        map.put("personFlowId", );
//        map.put("planLiveTime", );
//        map.put("registerMobile", );
//        map.put("tempLiveAddress", );
//        map.put("tempLiveArea", );
//        map.put("tempLivePlace", );
//        map.put("tempLiveReason", );
//        map.put("work", );


        FlowPeopleEditReq flowPeopleEditReq = new FlowPeopleEditReq();
        flowPeopleEditReq.setPersonFlowId(mPersonFlowId);
//        flowPeopleEditReq.setIdNum(binding.tvFlowPeopleEditId.getText().toString().trim());//身份证号
//        flowPeopleEditReq.setName(binding.tvFlowPeopleEditName.getText().toString().trim());//姓名
//        flowPeopleEditReq.setSex(binding.tvFlowPeopleEditSex.getText().toString().trim());//性别

        flowPeopleEditReq.setFlowInTime(binding.tvFlowPeopleEditIncomeDate.getText().toString().trim());//流入时间
        flowPeopleEditReq.setPlanLiveTime(TransformUtil.stayTempTransformString2Num(binding.tvFlowPeopleEditHowLong.getText().toString().trim()));//拟居住时间
        flowPeopleEditReq.setTempLivePlace(TransformUtil.stayPlaceTransformString2Num(binding.tvFlowPeopleEditTempHomeProvince.getText().toString().trim()));//暂居处所
        flowPeopleEditReq.setTempLiveReason(TransformUtil.stayReasonTransformString2Num(binding.tvFlowPeopleEditWhyComeHere.getText().toString().trim()));//暂居事由
        flowPeopleEditReq.setWork(TransformUtil.jobTransformString2Num(binding.tvFlowPeopleEditWork.getText().toString().trim()));//职业
        flowPeopleEditReq.setTempLivePlace(binding.tvFlowPeopleEditTempHomeProvince.getText().toString().trim());//暂居地省市县区
        flowPeopleEditReq.setTempLiveAddress(binding.tvFlowPeopleEditTempHomeCityDetail.getText().toString().trim());//暂居暂居住址的详细地址

        flowPeopleEditReq.setRegisterMobile(binding.tvFlowPeopleEditPhoneNumber.getText().toString().trim());//登记人联系电话
//        flowPeopleEditReq.setFlowInTime(binding.tvFlowPeopleEditIncomeDate.getText().toString().trim());//登记日期 (格式：yyyyMMdd)


        return flowPeopleEditReq;
    }

    /**
     * @param textView
     * @param title
     */
    private void getDate(TextView textView, String title) {
        PickerViewUtil.showSelectDatePickerViewBefore(mContext, title, dateStr -> textView.setText(dateStr));
    }

    private void initView() {

    }

}
