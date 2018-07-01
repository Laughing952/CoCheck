package com.unistrong.business.ui.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.commondata.listener.ItemClickListener;
import com.unistrong.business.R;
import com.unistrong.business.bean.Action;
import com.unistrong.business.ui.adapter.RecycleCardViewAapter;
import com.unistrong.business.ui.mvpview.BusinessView;
import com.unistrong.business.ui.presenter.BusinessPresenter;
import com.waterbase.ui.BaseTitleFragment;

import java.util.List;

/**
 * 业务fragment页面
 * 作者：Laughing on 2018/4/3 17:20
 * 邮箱：719240226@qq.com
 */

public class F_Business extends BaseTitleFragment implements BusinessView {
    private static F_Business instance;
    private RecyclerView recyclerView;
    private RecycleCardViewAapter aapter;
    private BusinessPresenter presenter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.f_business;
    }

    public synchronized static Fragment newInstance() {
        if (instance == null) {
            synchronized (F_Business.class) {
                if (instance == null)
                    instance = new F_Business();
            }
        }
        return instance;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        presenter = new BusinessPresenter(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        aapter = new RecycleCardViewAapter();
        recyclerView.setAdapter(aapter);
        aapter.setItemClickListener(new ItemClickListener<Action>() {
            @Override
            public void click(View v, Action action, int possion) {
                presenter.click(action);
            }
        });
        initTitle();
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.intData();
    }

    @Override
    public void resultData(List<Action> actionList) {
        aapter.setData(actionList);
    }

    @Override
    public void startActivity(String className) {
        Intent intent = null;
        try {
            intent = new Intent(getContext(), Class.forName(className));
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void initTitle() {
        setTitleText("业务模块");//标题
        setLeftOneImageVisibity(false);//隐藏左一按钮
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }
}
