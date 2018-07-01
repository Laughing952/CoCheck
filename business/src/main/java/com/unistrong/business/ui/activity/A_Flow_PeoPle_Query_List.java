package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.commondata.listener.ItemClickListener;
import com.commondata.ui.activity.TitleActivity;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.bean.RequestMap;
import com.unistrong.business.databinding.AFlowPeopleQueryListBinding;
import com.unistrong.business.ui.adapter.FlowPeopleQueryListAdapter;
import com.unistrong.business.ui.mvpview.IFlowPeopleQueryListView;
import com.unistrong.business.ui.presenter.FlowPeopleQueryListPersenter;
import com.waterbase.http.HttpManager;
import com.waterbase.widget.recycleview.OnLoadMoreListener;
import com.waterbase.widget.recycleview.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 作者：Laughing on 2018/4/16 08:41
 * 邮箱：719240226@qq.com
 */

public class A_Flow_PeoPle_Query_List extends TitleActivity implements SwipeRefreshLayout.OnRefreshListener,IFlowPeopleQueryListView{
    private Context mContext = this;
    private LinearLayout mDetail;
    private AFlowPeopleQueryListBinding binding;
    private FlowPeopleQueryListAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private FlowPeopleQueryListPersenter persenter;
    private Map<String, Object> requestMap;

    public static void startActivity(Context context,Map<String,Object> map) {
        Intent intent = new Intent(context, A_Flow_PeoPle_Query_List.class);
        RequestMap requestMap = new RequestMap();
        requestMap.setMap(map);
        Bundle bundle = new Bundle();
        bundle.putSerializable("requestMap",requestMap);
        intent.putExtra("requestBundle",bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        binding = setView(R.layout.a_flow_people_query_list);
        initTitle();
        HttpManager manager = new HttpManager(this, this);
        persenter = new FlowPeopleQueryListPersenter(manager, this);
        initView();
        getTransmitData();
        initListener();
    }
    public void initTitle(){
        setRightOneImageVisibity(true);
        setRightOneImagePic(R.mipmap.iv_flow_people_query_button);
        setTitleText("查询列表");//标题
    }

    /*
    * 查询点击按钮
    * */
    public void rightOneImageOnClick(){
        A_Flow_People_Query.startActivity(this);
    }
    public void getTransmitData(){
        RequestMap map=(RequestMap)getIntent().getBundleExtra("requestBundle")
                .getSerializable("requestMap");
        requestMap = map.getMap();
        persenter.initData(requestMap);
    }

    private void initListener() {
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
               persenter.requestMoreData(requestMap);
            }
        });
        mAdapter.setItemClickListener(new ItemClickListener<FlowPeopleQueryItemRep>() {
            @Override
            public void click(View v, FlowPeopleQueryItemRep itemRep, int position) {
                A_Move_People_Management_Details.startActivity(
                        A_Flow_PeoPle_Query_List.this,itemRep);
            }
        });
    }
    public void initView(){
        layoutManager = new LinearLayoutManager(this);
        binding.swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary);//设置刷新时进度条颜色，最多四种
        mAdapter = new FlowPeopleQueryListAdapter();
        binding.recyclerView.setAdapter(mAdapter);
        mAdapter.openAutoLoadMore(true);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.addItemDecoration(
                new RecycleViewDivider(this,LinearLayoutManager.VERTICAL));
    }

    /**
     * 展示首次查询数据
     */
    @Override
    public void showData(List data) {
        mAdapter.setData(data);
    }

    /**
     * 展示下拉刷新数据
     */
    @Override
    public void showRefreshData(List data) {
        binding.swipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setData(data);
                binding.swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    /**
     * 展示上拉加载数据
     */
    @Override
    public void showLoadMoreData(List data) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.addData(data);
                mAdapter.loadCompleted();
            }
        }, 2000);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        persenter.requestRefreshData(requestMap);
    }

}
