package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.commondata.event.RefreshEvent;
import com.statistics.R;
import com.statistics.databinding.ARecyclerViewBinding;
import com.statistics.response.InvolvedInfoRep;
import com.statistics.ui.adapter.Adapter_Involved_Info;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.presenter.InvolvedInfoPersenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 涉案信息
 * Created by Water on 2018/4/17.
 */

public class A_Involved_Info extends TitleActivity implements FamilyMembersView<List<InvolvedInfoRep>> {

    private ARecyclerViewBinding binding;
    private Adapter_Involved_Info adapter;
    private InvolvedInfoPersenter persenter;
    private String idCardNum;

    public static void startActivity(Context context, String idCardNum) {
        Intent intent = new Intent(context, A_Involved_Info.class);
        intent.putExtra("idCardNum", idCardNum);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("涉案信息");
        idCardNum = getIntent().getStringExtra("idCardNum");
        binding = setView(R.layout.a_recycler_view);
        initView();
        persenter = new InvolvedInfoPersenter(this, this, this);
        persenter.initData(idCardNum);
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        persenter.initData(idCardNum);
    }

    private void initView() {
        binding.swiperefreshlayout.setOnRefreshListener(() -> persenter.initData(idCardNum));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_Involved_Info();
        adapter.openAutoLoadMore(true);
        adapter.setOnLoadMoreListener(()-> persenter.addData(idCardNum));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void resultData(List<InvolvedInfoRep> infoReps) {
        binding.swiperefreshlayout.setRefreshing(false);
        adapter.setData(infoReps);
    }

    @Override
    public void addData(List<InvolvedInfoRep> infoReps) {
        if (infoReps == null || infoReps.size() == 0)
            adapter.loadCompleted();
        else
            adapter.addData(infoReps);
    }
}
