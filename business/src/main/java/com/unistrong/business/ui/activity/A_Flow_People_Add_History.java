package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.commondata.listener.ItemClickListener;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleHistoryRep;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.databinding.AFlowPeopleAddHistoryBinding;
import com.unistrong.business.ui.adapter.Adapter_Flow_People_History;
import com.unistrong.business.ui.mvpview.FlowPeopleAddHistoryListView;
import com.unistrong.business.ui.presenter.FlowPeopleHistoryPresenter;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.widget.recycleview.OnLoadMoreListener;

import java.util.List;

/**
 * 流动人口登记历史
 * 作者：Laughing on 2018/4/14 13:52
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Add_History extends BaseTitleActivity implements FlowPeopleAddHistoryListView<List<FlowPeopleQueryItemRep>> {
    private Context mContext = this;
    private RecyclerView mRecyclerView;
    private AFlowPeopleAddHistoryBinding binding;
    private FlowPeopleHistoryPresenter presenter;
    private Adapter_Flow_People_History mAdapter;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Add_History.class));
    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("登记历史");//标题
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        binding = setView(R.layout.a_flow_people_add_history);
        initTitle();
        initView();
        initData();
        initListener();

    }

    private void initData() {

        presenter = new FlowPeopleHistoryPresenter(this, this, this);
        presenter.initData();
    }

    private void initListener() {

    }

    private void initView() {
        binding.srlFlowPeopleAddHistory.setOnRefreshListener(() -> {
            presenter.initData();
        });
        binding.rvFlowPeopleAddHistory.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new Adapter_Flow_People_History();
        mAdapter.openAutoLoadMore(true);
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                presenter.loadMoreData();
            }
        });
        mAdapter.setItemClickListener(new ItemClickListener<FlowPeopleQueryItemRep>() {

            @Override
            public void click(View v, FlowPeopleQueryItemRep item, int position) {
                A_Move_People_Management_Details.startActivity(
                        A_Flow_People_Add_History.this,item);
            }
        });
        binding.rvFlowPeopleAddHistory.setAdapter(mAdapter);
    }


    @Override
    public void initDataResult(List<FlowPeopleQueryItemRep> flowPeopleHistoryReps) {
        binding.srlFlowPeopleAddHistory.setRefreshing(false);
        mAdapter.setData(flowPeopleHistoryReps);
    }

    @Override
    public void refreshResult(List<FlowPeopleQueryItemRep> flowPeopleHistoryReps) {

    }

    @Override
    public void loadMoreResult(List<FlowPeopleQueryItemRep> flowPeopleHistoryReps) {
        if (flowPeopleHistoryReps == null || flowPeopleHistoryReps.size() == 0)
            mAdapter.loadCompleted();
        else
            mAdapter.addData(flowPeopleHistoryReps);
    }
}
