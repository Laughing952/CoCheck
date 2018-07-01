package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.commondata.event.RefreshEvent;
import com.statistics.R;
import com.statistics.databinding.ARecyclerViewBinding;
import com.statistics.response.ColumnInfoRep;
import com.statistics.ui.adapter.Adapter_Column_Info;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.presenter.ColumnInfoPersenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * 列管信息
 * Created by Water on 2018/4/17.
 */

public class A_Column_Info extends TitleActivity implements FamilyMembersView<List<ColumnInfoRep>> {

    private ARecyclerViewBinding binding;
    private Adapter_Column_Info adapter;
    private ColumnInfoPersenter persenter;
    private String idCardNum;

    public static void startActivity(Context context, String idCardNum) {
        Intent intent = new Intent(context, A_Column_Info.class);
        intent.putExtra("idCardNum", idCardNum);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("列管信息");
        idCardNum = getIntent().getStringExtra("idCardNum");
        binding = setView(R.layout.a_recycler_view);
        initView();
        persenter = new ColumnInfoPersenter(this, this, this);
        persenter.initData(idCardNum);
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        persenter.initData(idCardNum);
    }

    private void initView() {
        binding.swiperefreshlayout.setOnRefreshListener(() -> persenter.initData(idCardNum));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_Column_Info();
        adapter.openAutoLoadMore(true);
        adapter.setOnLoadMoreListener(()->persenter.addData(idCardNum));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void resultData(List<ColumnInfoRep> infoRepList) {
        binding.swiperefreshlayout.setRefreshing(false);
        adapter.setData(infoRepList);
    }

    @Override
    public void addData(List<ColumnInfoRep> infoRepList) {
        if (infoRepList == null || infoRepList.size() == 0)
            adapter.loadCompleted();
        else
            adapter.addData(infoRepList);
    }
}
