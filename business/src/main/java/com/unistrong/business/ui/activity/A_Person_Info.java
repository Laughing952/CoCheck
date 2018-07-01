package com.unistrong.business.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.commondata.bean.PersonBean;
import com.commondata.ui.activity.TitleActivity;
import com.unistrong.business.R;
import com.unistrong.business.bean.CoupleListBean;
import com.unistrong.business.bean.CrimeListBean;
import com.unistrong.business.bean.FamilyListBean;
import com.unistrong.business.bean.FlowListBean;
import com.unistrong.business.bean.JailedListBean;
import com.unistrong.business.databinding.APersonInfoDetailBinding;
import com.unistrong.business.ui.mvpview.IPersonInfoView;
import com.waterbase.utile.ToastUtil;

import java.util.List;

/**
 * 人员信息
 * Created by kb.zhang on 2018/4/14.
 */

public class A_Person_Info extends TitleActivity implements IPersonInfoView {
    private APersonInfoDetailBinding detailBinding;
    private PersonBean personBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = setView(R.layout.a_person_info_detail);
        detailBinding.setIsShow(false);

        personBean = (PersonBean) getIntent().getExtras().getSerializable("data");
        detailBinding.llPersonInfo.setPerson(personBean);

        initTitle();
        listener();
    }

    /**
     * 事件
     */
    private void listener () {
        detailBinding.setOnclick(v -> detailBinding.setIsShow(true));

        detailBinding.llBtn.setOnclick(v -> {
            int i = v.getId();
            if (i == R.id.btnAssist) {//协查
                ToastUtil.showToast(getApplicationContext(), "暂无该功能");
            } else if (i == R.id.btnFlowAdd) {//登记
                Intent intent = new Intent(this, A_Flow_People_Add.class);
                intent.putExtra("data", personBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showCoupleList(List<CoupleListBean> list) {

    }

    @Override
    public void showCrimeList(List<CrimeListBean> list) {

    }

    @Override
    public void showFamilyList(List<FamilyListBean> list) {

    }

    @Override
    public void showFlowList(List<FlowListBean> list) {

    }

    @Override
    public void showJailedList(List<JailedListBean> list) {

    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText(R.string.title_person_data);//标题
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }

}
