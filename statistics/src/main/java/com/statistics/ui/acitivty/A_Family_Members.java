package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.commondata.event.RefreshEvent;
import com.statistics.R;
import com.statistics.databinding.ARecyclerViewBinding;
import com.statistics.response.FamilyMembersRep;
import com.statistics.ui.adapter.Adapter_Family_Members;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.presenter.FamilyMembersPersenter;
import com.waterbase.widget.recycleview.OnLoadMoreListener;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 家庭成员
 * Created by Water on 2018/4/16.
 */

public class A_Family_Members extends TitleActivity implements FamilyMembersView<List<FamilyMembersRep>> {

    private ARecyclerViewBinding binding;
    private Adapter_Family_Members adapter;
    private FamilyMembersPersenter persenter;
    private String idCardNum;

    public static void startActivity(Context context, String idCardNum) {
        Intent intent = new Intent(context, A_Family_Members.class);
        intent.putExtra("idCardNum", idCardNum);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("家庭成员");
        idCardNum = getIntent().getStringExtra("idCardNum");
        binding = setView(R.layout.a_recycler_view);
        initView();
        persenter = new FamilyMembersPersenter(this, this, this);
        persenter.initData(idCardNum);
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        persenter.initData(idCardNum);
    }

    private void initView() {
        binding.swiperefreshlayout.setOnRefreshListener(() -> persenter.initData(idCardNum));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_Family_Members();
        adapter.openAutoLoadMore(true);
        adapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                persenter.addData(idCardNum);
            }
        });
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void resultData(List<FamilyMembersRep> familyMembersRepList) {
        binding.swiperefreshlayout.setRefreshing(false);
        adapter.setData(familyMembersRepList);
    }

    @Override
    public void addData(List<FamilyMembersRep> familyMembersRepList) {
        if (familyMembersRepList == null || familyMembersRepList.size() == 0)
            adapter.loadCompleted();
        else
            adapter.addData(familyMembersRepList);
    }
}
