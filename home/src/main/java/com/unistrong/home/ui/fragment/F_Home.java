package com.unistrong.home.ui.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.commondata.listener.ItemClickListener;
import com.unistrong.home.R;
import com.unistrong.home.bean.HomeItemIcon;
import com.commondata.bean.PersonBean;
import com.unistrong.home.databinding.FHomeBinding;
import com.unistrong.home.databinding.PopRecyclerviewBinding;
import com.unistrong.home.ui.adapter.Adapter_Home;
import com.unistrong.home.ui.adapter.Adapter_Pop;
import com.unistrong.home.ui.presenter.HomePresenter;
import com.unistrong.home.ui.presenter.LocationPresenter;
import com.unistrong.home.ui.viewmodel.SetDeviceInfoView;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseActivity;
import com.waterbase.ui.BaseFragment;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.PopupWindowUtile;
import com.waterbase.utile.PreferencesManager;
import com.waterbase.utile.ToastUtil;
import com.waterbase.utile.UiUtil;
import com.waterbase.utile.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页fragment页面
 * 作者：Laughing on 2018/4/3 17:19
 * 邮箱：719240226@qq.com
 */

public class F_Home extends BaseFragment implements SetDeviceInfoView {

    private static F_Home instance;
    private LocationPresenter mLocationPresenter;
    private FHomeBinding mBinding;
    private Adapter_Home adapterHome;
    private HomePresenter homePresenter;
    private List<String> dataList;


    public synchronized static Fragment newInstance() {
        if (instance == null) {
            synchronized (F_Home.class) {
                if (instance == null)
                    instance = new F_Home();
            }
        }
        return instance;

    }

    @Override
    protected int getLayoutId() {
        return R.layout.f_home;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mBinding = getBind();
        mBinding.tvStater.setHeight(UiUtil.getStatusBarHeight(getContext()));
        mBinding.rvAction.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapterHome = new Adapter_Home();
        mBinding.rvAction.setAdapter(adapterHome);
        preferencesManager = PreferencesManager.getInstance(getContext());
        keyboardListener();
        adapterHome.setItemClickListener((v, homeItemIcon, position) -> homePresenter.click((HomeItemIcon) homeItemIcon));
        mBinding.ivSeach.setOnClickListener(v -> {
            homePresenter.selectData(mBinding.edtHomeSearch.getText().toString());
            searchString = mBinding.edtHomeSearch.getText().toString();
        });
        mBinding.rvSeach.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPop = new Adapter_Pop();
        adapterPop.setItemClickListener(new ItemClickListener<String>() {
            @Override
            public void click(View v, String str, int position) {
                homePresenter.selectData(str);
            }
        });
        mBinding.rvSeach.setAdapter(adapterPop);
        dataList = preferencesManager.getDataList("searchHistory");
//        if (dataList == null || dataList.size() == 0)
//            dataList.add("近期搜索身份证号");
        adapterPop.setData(dataList);
//        mBinding.edtHomeSearch.setOnClickListener(v -> {
//            showPop();
//        });
//        mBinding.edtHomeSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    showPop();
//                }
//            }
//        });
//        mBinding.edtHomeSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                for (String data : dataList) {
//                    if (data.indexOf(s.toString()) == -1) {
//                        adapterPop.removeData(data);
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//        mBinding.edtHomeSearch.setOnKeyListener((v, keyCode, event) -> {
//            switch (keyCode) {
//                case KeyEvent.KEYCODE_ENTER:
//                    switch (event.getAction()) {
//                        case KeyEvent.ACTION_UP:
//                            homePresenter.selectData(mBinding.edtHomeSearch.getText().toString());
//                            break;
//                    }
//                    break;
//            }
//            return false;
//        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mLocationPresenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void initData() {
        super.initData();
        mLocationPresenter = new LocationPresenter(this, this);
        mLocationPresenter.getLocationInfo();
        HttpManager manager = new HttpManager((BaseActivity) getActivity(), this);
        homePresenter = new HomePresenter(manager, this);
        homePresenter.initData();
    }

    @Override
    public void locationResult(String s) {
        mBinding.tvHomeLocation.setText(s);
        LogUtil.e("TAG", "位置---------------------->   " + s);
    }

    @Override
    public void resultData(List<HomeItemIcon> itemIcons) {
        adapterHome.setData(itemIcons);
    }

    @Override
    public void startActivity(String className) {
        try {
            startActivity(new Intent(getContext(), Class.forName(className)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startActivity(String className, String idCardNum) {
        try {
            Intent intent = new Intent(getContext(), Class.forName(className));
            intent.putExtra("idCardNum", idCardNum);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchPerson(PersonBean bean) {
        try {
            recordHistory();
            Intent intent = new Intent(getContext(), Class.forName("com.unistrong.business.ui.activity.A_Person_Info"));
            intent.putExtra("data", bean);
            startActivity(intent);
            mBinding.edtHomeSearch.setText("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toastError(int nError) {
        ToastUtil.showToast(Utils.getContext(), nError);
    }

    private Adapter_Pop adapterPop;


    private ArrayList<String> searchHistoryArrayList;
    private PreferencesManager preferencesManager;
    private String searchString;

    /**
     * 记录搜索历史
     */
    public void recordHistory() {
        adapterPop.addData(searchString);
        searchHistoryArrayList = new ArrayList<>();
        searchHistoryArrayList.add(searchString);
        preferencesManager.setDataList(getContext(), "searchHistory", searchHistoryArrayList);
    }

    private void keyboardListener() {
        //键盘动作的监听(搜索)
        mBinding.edtHomeSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //进行搜索
                    homePresenter.selectData(mBinding.edtHomeSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

}
