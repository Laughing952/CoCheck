package com.unistrong.business.ui.activity;

/**
 * 比对数据
 * <p>
 * 作者：cuihao
 * 邮箱：583576071@qq.com
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.commondata.ui.activity.TitleActivity;
import com.commondata.util.PickerViewUtil;
import com.unistrong.business.R;
import com.unistrong.business.databinding.APeoplePhotoComparisonDataBinding;
import com.unistrong.business.entity.MultiItemEntity;
import com.unistrong.business.ui.adapter.ExpandableItemAdapter;
import com.unistrong.business.ui.mvpview.IComparisonDataView;
import com.unistrong.business.ui.presenter.ComparisonDataPersenter;
import com.unistrong.business.utile.DateTransform;
import com.waterbase.http.HttpManager;
import com.waterbase.utile.DateUtil;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class A_People_Photo_Comparison_Data extends TitleActivity implements SwipeRefreshLayout.OnRefreshListener, IComparisonDataView {
    private Context mContext = this;
    private HashMap<String, Object> map = new HashMap<>();
    private APeoplePhotoComparisonDataBinding binding;
    ExpandableItemAdapter adapter;
    private ComparisonDataPersenter peoplePersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = setView(R.layout.a_people_photo_comparison_data);
        initTitle();
        HttpManager manager = new HttpManager(this, this);
        peoplePersenter = new ComparisonDataPersenter(manager, this);
        peoplePersenter.generateAllHistoryData();
        initListener();
    }

    public void initTitle() {
        setRightOneImageVisibity(true);
        setRightOneImagePic(R.mipmap.iv_date_choise);
        setTitleText("比对数据");//标题
    }

    /*
    * 时间选择点击按钮
    * */
    public void rightOneImageOnClick() {
        String date = binding.tvPeoplePhotoQueryComparisonDataId.getText().toString().trim();
        String[] tvDate = DateTransform.TextViewDateTransformUpload(date);
        try {
            Intent intent = new Intent(this,
                    Class.forName("com.statistics.ui.acitivty.A_Custom_Statistics"));
            intent.putExtra("code", "1");
            intent.putExtra("srartDate", tvDate[0]);
            intent.putExtra("endDate", tvDate[1]);
            startActivityForResult(intent, 0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showData(Object data) {
        ArrayList<MultiItemEntity> list = (ArrayList<MultiItemEntity>) data;
        adapter = new ExpandableItemAdapter(list);
        final GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == ExpandableItemAdapter.TYPE_PERSON ? 1 : manager.getSpanCount();
            }
        });

//        binding.recyclerView.addItemDecoration(new SpaceItemDecoration(px2dip(getApplicationContext(), 10)));

        binding.recyclerView.setAdapter(adapter);
        // important! setLayoutManager should be called after setAdapter
        binding.recyclerView.setLayoutManager(manager);
        adapter.expandAll();
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        adapter.setOnLoadMoreListener(() -> {
            String currentPage = String.valueOf(Integer.parseInt((String) map.get("currentPage")) + 1);
            map.put("currentPage", currentPage);
            map.put("pageSize","10");
            peoplePersenter.generateRefreshData(map);
        });
    }


    @Override
    public void showFailureMessage(String msg) {
        ToastUtil.showToast(getApplicationContext(), msg);
    }

    @Override
    public void showErrorMessage(String msg) {
        ToastUtil.showToast(getApplicationContext(), msg);
    }

    @Override
    public void showRefreshData(List data) {
        binding.swipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setNewData(data);
                adapter.expandAll();
                binding.swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void showLoadMoreData(List data) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addData(data);
                adapter.expandAll();
                adapter.loadMoreComplete();
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        map.put("currentPage", "1");
        map.put("pageSize","10");
        peoplePersenter.generateRefreshData(map);
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;
        private int position = 0;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //设置边距

            if (parent.getAdapter().getItemViewType(parent.getChildLayoutPosition(view)) == 2) {
                parent.setPadding(0, 0, space, 0);
                outRect.left = space;
                outRect.bottom = space;
//                //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为12dp
//                if ((parent.getChildLayoutPosition(view) - position) % 3 == 0) {
//                    Log.v("cuihao", "parent.getAdapter().getItemViewType(parent.getChildLayoutPosition(view))  " + parent.getAdapter().getItemViewType(parent.getChildLayoutPosition(view)));
//                    outRect.left = space + 2;
//                }
//                //把右边距设为12dp
//                if (((parent.getChildLayoutPosition(view) - position) % 2 == 0) && parent.getChildLayoutPosition(view) - position != 0) {
//                    outRect.right = space + 2;
//                }
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 0) {
            String startDate = DateTransform.uploadDateTransformShow(
                    data.getStringExtra("startDate"));
            String endDate = DateTransform.uploadDateTransformShow(
                    data.getStringExtra("endDate"));
            binding.tvPeoplePhotoQueryComparisonDataId.setText(startDate + " 至 " + endDate);
        map.put("compTime",data.getStringExtra("startDate"));
        map.put("compTimeEnd",data.getStringExtra("endDate"));
        map.put("currentPage","1");
        map.put("pageSize","10");
        peoplePersenter.generateData(map);
        }
    }


    private void initListener() {

        /**
         * 查询日期清空
         */
        binding.ivChoiseDataEmpty.setOnClickListener(v -> {
            binding.tvPeoplePhotoQueryComparisonDataId.setText("");
        });
    }

    public static int px2dip(Context context, int dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
