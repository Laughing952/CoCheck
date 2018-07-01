package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.WindowManager;

import com.commondata.listener.ItemClickListener;
import com.commondata.ui.activity.TitleActivity;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.databinding.AFlowPeopleLogOutListBinding;
import com.unistrong.business.ui.adapter.Adapter_Flow_People_Log_Out_List;
import com.unistrong.business.ui.mvpview.IFlowPeopleLogOutListListView;
import com.unistrong.business.ui.presenter.FlowPeopleLogOutListPresenter;
import com.waterbase.utile.LogUtil;
import com.waterbase.widget.recycleview.OnLoadMoreListener;

import java.util.List;

/**
 * 流动人口注销列表页面
 * <p>
 * 作者：Laughing on 2018/4/24 10:00
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Log_Out_List extends TitleActivity implements IFlowPeopleLogOutListListView<List<FlowPeopleQueryItemRep>> {
    private Context mContext = this;
    private String mIdNum;
    private AFlowPeopleLogOutListBinding mBinding;
    private Adapter_Flow_People_Log_Out_List mAdapter;
    private FlowPeopleLogOutListPresenter presenter;


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Log_Out.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        setTitleText("注销列表");//标题
        mBinding = setView(R.layout.a_flow_people_log_out_list);
        initView();
        initData();
        initListener();
    }


    private void initView() {
        presenter = new FlowPeopleLogOutListPresenter(this, this, this);
        mIdNum = getIntent().getStringExtra("PersonIdLogOut");
        LogUtil.e("TAG", "laughing------------编辑列表----mIdNum------>   " + mIdNum);
        mBinding.srlFlowPeopleLogOutList.setOnRefreshListener(() -> {
            presenter.initData(mIdNum);
        });
        mBinding.rvFlowPeopleLogOutList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new Adapter_Flow_People_Log_Out_List();
        mAdapter.openAutoLoadMore(true);
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                presenter.loadMoreData(mIdNum);
            }
        });
        mAdapter.setItemClickListener(new ItemClickListener<FlowPeopleQueryItemRep>() {

            @Override
            public void click(View view, FlowPeopleQueryItemRep flowPeopleQueryItemRep, int position) {
                A_Flow_People_Log_Out.startActivity(mContext, flowPeopleQueryItemRep);//携带数据跳转到编辑列表页面

            }
        });
        mBinding.rvFlowPeopleLogOutList.setAdapter(mAdapter);
    }

    private void initData() {
        presenter.initData(mIdNum);


    }

    private void initListener() {

    }


    @Override
    public void initDataResult(List<FlowPeopleQueryItemRep> flowPeopleQueryItemReps) {
        mBinding.srlFlowPeopleLogOutList.setRefreshing(false);
        mAdapter.setData(flowPeopleQueryItemReps);
    }

    @Override
    public void refreshResult(List<FlowPeopleQueryItemRep> flowPeopleQueryItemReps) {

    }

    @Override
    public void loadMoreResult(List<FlowPeopleQueryItemRep> flowPeopleQueryItemReps) {
        if (flowPeopleQueryItemReps == null || flowPeopleQueryItemReps.size() == 0) {
            mAdapter.loadCompleted();
        } else {
            mAdapter.addData(flowPeopleQueryItemReps);
        }
    }
}


