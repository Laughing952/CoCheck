package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.WindowManager;

import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.bean.PeoplePhotoQueryRep;
import com.unistrong.business.databinding.AFlowPeopleQueryListBinding;
import com.unistrong.business.databinding.APeoplePhotoQueryResultBinding;
import com.unistrong.business.ui.adapter.FlowPeopleQueryListAdapter;
import com.unistrong.business.ui.adapter.PeoplePhotoQueryResultAdapter;
import com.unistrong.business.ui.presenter.FlowPeopleQueryListPersenter;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.widget.recycleview.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * 人像比对结果列表
 * 作者：Laughing on 2018/4/16 16:13
 * 邮箱：719240226@qq.com
 */

public class A_People_Photo_Query_Result extends BaseTitleActivity {
    public static void startActivity(Context context,ArrayList<PeoplePhotoQueryRep> response) {
        Intent intent = new Intent(context, A_People_Photo_Query_Result.class);
        intent.putExtra("peoplePhotoQueryResultRep",response);
        context.startActivity(intent);
    }
    private Context mContext = this;
    private APeoplePhotoQueryResultBinding binding;
    private PeoplePhotoQueryResultAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private List<PeoplePhotoQueryRep> queryListRep;
    private FlowPeopleQueryListPersenter persenter;

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("人像比对列表");//标题
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
        binding=setView(R.layout.a_people_photo_query_result);
        initTitle();
        initView();
        initData();
//        initListener();

    }
    public void initView(){
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new PeoplePhotoQueryResultAdapter();
        binding.recyclerView.setAdapter(mAdapter);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.addItemDecoration(
                new RecycleViewDivider(this,LinearLayoutManager.VERTICAL));
    }
    public void initData(){
        ArrayList<PeoplePhotoQueryRep> peoplePhotoQueryResultRep =
                (ArrayList<PeoplePhotoQueryRep>)getIntent().getExtras().
                        get("peoplePhotoQueryResultRep");
        mAdapter.setData(peoplePhotoQueryResultRep);
    }
}
