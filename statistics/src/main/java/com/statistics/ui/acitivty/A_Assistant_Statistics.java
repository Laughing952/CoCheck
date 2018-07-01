package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.commondata.event.RefreshEvent;
import com.commondata.listener.ItemClickListener;
import com.statistics.R;
import com.statistics.databinding.AAssistantStatisticsBinding;
import com.statistics.ui.adapter.ExpandableItemAdapter;
import com.statistics.ui.mvpview.AssistantStatisticsView;
import com.statistics.ui.presenter.AssistantStatisticsPresenter;
import com.statistics.ui.viewmodel.Level0Item;
import com.statistics.ui.viewmodel.Level1Item;
import com.statistics.ui.viewmodel.Level2Item;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.PopupWindowUtile;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Random;

/**
 * 协查统计
 * Created by Water on 2018/4/11.
 */

public class A_Assistant_Statistics extends TitleActivity implements AssistantStatisticsView<ArrayList<MultiItemEntity>> {

    private AAssistantStatisticsBinding binding;
    private AssistantStatisticsPresenter presenter;
    private ExpandableItemAdapter adapter;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Assistant_Statistics.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("协查统计");
        setRightOneImageVisibity(true);
        binding = setView(R.layout.a_assistant_statistics);
        initView();
        presenter = new AssistantStatisticsPresenter(this, this, this);
        presenter.initData();
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
        presenter.initData();
    }

    private void initView() {
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.initData();
        });
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExpandableItemAdapter(new ArrayList<MultiItemEntity>());
        adapter.setItemClickListener(new ItemClickListener<Level2Item>() {
            @Override
            public void click(View v, Level2Item item, int possion) {
                //  去下一个页面
                A_Personnel_List.startActivity(A_Assistant_Statistics.this, item, A_Personnel_List.FLOATING_PERSONNEL);
            }
        });
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void callback(ArrayList<MultiItemEntity> entityArrayList) {
        binding.swipeRefreshLayout.setRefreshing(false);
        adapter.setNewData(entityArrayList);
        adapter.expandAll();
    }

    @Override
    protected void rightOneImageOnClick() {
        presenter.rightOneImageOnClick(title,binding.linearlayout);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUESTCODE) {
            String srartDate = data.getStringExtra("startDate");
            String endDate = data.getStringExtra("endDate");
            LogUtil.d(TAG, "srartDate: " + srartDate + " ;endDate: " + endDate);
            presenter.initData(srartDate,endDate);
        }
    }



    private static final int REQUESTCODE = 990;

    @Override
    public void startAcitvityForResult(String srartDate,String endDate) {
        A_Custom_Statistics.startActivityForResult(this, srartDate, endDate, REQUESTCODE);
    }
}
