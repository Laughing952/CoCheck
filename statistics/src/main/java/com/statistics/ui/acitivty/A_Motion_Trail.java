package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.commondata.event.RefreshEvent;
import com.statistics.R;
import com.statistics.databinding.ARecyclerViewBinding;
import com.statistics.response.MotionTrailRep;
import com.statistics.ui.adapter.Adapter_Family_Members;
import com.statistics.ui.adapter.Adapter_Motion_Trail;
import com.statistics.ui.mvpview.FamilyMembersView;
import com.statistics.ui.presenter.FamilyMembersPersenter;
import com.statistics.ui.presenter.MotionTrailPersenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 疆外活动轨迹
 * Created by Water on 2018/4/17.
 */

public class A_Motion_Trail extends TitleActivity implements FamilyMembersView<List<MotionTrailRep>> {


    private ARecyclerViewBinding binding;
    private Adapter_Motion_Trail adapter;
    private MotionTrailPersenter persenter;
    private String idCardNum;

    public static void startActivity(Context context, String idCardNum) {
        Intent intent = new Intent(context, A_Motion_Trail.class);
        intent.putExtra("idCardNum", idCardNum);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("疆外活动轨迹");
        idCardNum = getIntent().getStringExtra("idCardNum");
        binding = setView(R.layout.a_recycler_view);
        initView();
        persenter = new MotionTrailPersenter(this, this, this);
        persenter.initData(idCardNum);
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        persenter.initData(idCardNum);
    }

    private void initView() {
        binding.swiperefreshlayout.setOnRefreshListener(() -> persenter.initData(idCardNum));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_Motion_Trail();
        adapter.openAutoLoadMore(true);
        adapter.setOnLoadMoreListener(()->persenter.addData(idCardNum));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void resultData(List<MotionTrailRep> trailRepList) {
        binding.swiperefreshlayout.setRefreshing(false);
        adapter.setData(trailRepList);
    }

    @Override
    public void addData(List<MotionTrailRep> trailRepList) {
        if (trailRepList == null || trailRepList.size() == 0)
            adapter.loadCompleted();
        else
            adapter.addData(trailRepList);
    }
}
