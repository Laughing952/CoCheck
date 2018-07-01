package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.commondata.event.RefreshEvent;
import com.commondata.listener.ItemClickListener;
import com.statistics.R;
import com.statistics.databinding.AAssistantStatisticsBinding;
import com.statistics.response.AssistantStatisticsRep;
import com.statistics.response.PersonneRep;
import com.statistics.ui.adapter.Adapter_Personnel_List;
import com.statistics.ui.adapter.ExpandableItemAdapter;
import com.statistics.ui.mvpview.PersonnelListView;
import com.statistics.ui.presenter.PersonnelListPresenter;
import com.statistics.ui.viewmodel.Level2Item;
import com.waterbase.utile.LogUtil;
import com.waterbase.widget.recycleview.OnLoadMoreListener;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 人员列表
 * Created by Water on 2018/4/12.
 */

public class A_Personnel_List extends TitleActivity implements PersonnelListView<List<PersonneRep>> {

    public static final int FLOATING_PERSONNEL = 37;// 流动人员统计
    public static final int ASSISTANT = 38;// 协查统计
    private PersonnelListPresenter presenter;
    private AAssistantStatisticsBinding binding;
    private int from;
    private Level2Item item;
    private Adapter_Personnel_List adapter;

    public static void startActivity(Context context, Level2Item item, int from) {
        Intent intent = new Intent(context, A_Personnel_List.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        intent.putExtras(bundle);
        intent.putExtra("from", from);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        from = getIntent().getIntExtra("from", -1);
        item = (Level2Item) getIntent().getExtras().getSerializable("item");
        setTitleText(item.getTypeName());
        binding = setView(R.layout.a_assistant_statistics);
        initView();
        initData();
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        presenter.initData(from, item);
    }

    private void initView() {
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.initData(from, item);
        });
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_Personnel_List();
        adapter.openAutoLoadMore(true);
        adapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                presenter.loadMore(from, item);
            }
        });
        adapter.setItemClickListener(new ItemClickListener<PersonneRep>() {
            @Override
            public void click(View v, PersonneRep item, int possion) {
                // 去下一个页面
                A_Personnel_Details.startActivity(A_Personnel_List.this, item.getIdNum());

            }
        });
        binding.recyclerView.setAdapter(adapter);
    }

    private void initData() {
        presenter = new PersonnelListPresenter(this, this, this);
        presenter.initData(from, item);
    }

    @Override
    public void initDataResult(List<PersonneRep> repList) {
        binding.swipeRefreshLayout.setRefreshing(false);
        adapter.setData(repList);
    }

    @Override
    public void refreshReult(List<PersonneRep> repList) {
        adapter.setData(repList);
        binding.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMoreReult(List<PersonneRep> repList) {
        if (repList == null || repList.size() == 0)
            adapter.loadCompleted();
        else
            adapter.addData(repList);
    }
}
