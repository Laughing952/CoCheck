package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.commondata.event.RefreshEvent;
import com.statistics.R;
import com.statistics.databinding.ARecyclerViewBinding;
import com.statistics.response.MarriageInfoRep;
import com.statistics.ui.adapter.Adapter_Marriage_Info;
import com.statistics.ui.mvpview.MarriageInfoView;
import com.statistics.ui.presenter.MarriageInfoPersenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 婚姻信息
 * Created by Water on 2018/4/17.
 */

public class A_Marriage_Info extends TitleActivity implements MarriageInfoView {

    private String idCardNum;
    private Adapter_Marriage_Info adapter;
    //    private MarriageInfoPersenter infoPersenter;
    private ARecyclerViewBinding binding;

    public static void startActivity(Context context, String idCardNum, ArrayList<MarriageInfoRep> marriageInfoList) {
        Intent intent = new Intent(context, A_Marriage_Info.class);
        intent.putExtra("idCardNum", idCardNum);
        intent.putExtra("marriageInfoList", marriageInfoList);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("婚姻信息");
        idCardNum = getIntent().getStringExtra("id");
        binding = setView(R.layout.a_recycler_view);
        initView();
        initData();
//        infoPersenter = new MarriageInfoPersenter(this, this, this);
//        infoPersenter.initData(idCardNum);
    }

    private void initView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_Marriage_Info();
        binding.recyclerView.setAdapter(adapter);
        binding.swiperefreshlayout.setOnRefreshListener(() -> binding.swiperefreshlayout.setRefreshing(false));
    }

    private void initData() {
        ArrayList<MarriageInfoRep> infoReps = (ArrayList<MarriageInfoRep>) getIntent().getSerializableExtra("marriageInfoList");
        adapter.setData(infoReps);
    }
    @Subscribe
    public void onEventMainThread(RefreshEvent event){
    }
    @Override
    public void resultData(Object o) {
//        List<String> stringList = new ArrayList<>();
//        stringList.add(null);
//        stringList.add(null);
//        stringList.add(null);
//        stringList.add(null);
//        adapter.setData(stringList);
    }
}
