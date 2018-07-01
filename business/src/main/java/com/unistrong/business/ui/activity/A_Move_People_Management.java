package com.unistrong.business.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.commondata.ui.activity.TitleActivity;
import com.unistrong.business.R;
import com.unistrong.business.databinding.ActivityMovePeopleManagementBinding;
import com.unistrong.business.ui.presenter.FlowPeopleQueryPersenter;
import com.waterbase.http.HttpManager;

public class A_Move_People_Management extends TitleActivity implements View.OnClickListener{

    private ActivityMovePeopleManagementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = setView(R.layout.activity_move_people_management);
        binding.setClick(this);
        setTitleText("流动人口管理");
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.rl_move_people_registration) {
            // 流动人口登记
            A_Flow_People_Query_Add.startActivity(this);
        } else if (id == R.id.rl_move_people_query) {
            // 流动人口查询
            startQuery();
        } else if (id == R.id.rl_move_people_log_out) {
            // 流动人口注销
            A_Flow_People_Query_Log_Out.startActivity(this);
        }else if (id == R.id.rl_move_people_edit) {
            //流动人口编辑
            A_Flow_People_Query_Edit.startActivity(this);
        }
    }
    public void startQuery(){
        HttpManager manager = new HttpManager(this, this);
        FlowPeopleQueryPersenter persenter =
                new FlowPeopleQueryPersenter(this, manager);
        persenter.uploadHistoryData();
    }
}
