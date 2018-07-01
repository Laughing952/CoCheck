package com.statistics.ui.acitivty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.commondata.event.RefreshEvent;
import com.commondata.util.PickerViewUtil;
import com.statistics.R;
import com.statistics.databinding.ACustomStatisticsBinding;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.DateUtil;
import com.waterbase.utile.StrUtil;
import com.waterbase.utile.ToastUtil;

import org.greenrobot.eventbus.Subscribe;

/**
 * 自定义统计
 * Created by Water on 2018/4/25.
 * 
 */

public class A_Custom_Statistics extends TitleActivity implements View.OnClickListener {

    private ACustomStatisticsBinding binding;

    public static void startActivityForResult(BaseActivity activity, String srartDate
            , String endDate, int requestcode) {
        Intent intent = new Intent(activity, A_Custom_Statistics.class);
        intent.putExtra("srartDate", srartDate);
        intent.putExtra("endDate", endDate);
        activity.startActivityForResult(intent, requestcode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitle();
        binding = setView(R.layout.a_custom_statistics);
        binding.setClick(this);
        startDate = getIntent().getStringExtra("srartDate");
        endDate = getIntent().getStringExtra("endDate");
        binding.tvStartDate.setText(startDate);
        binding.tvEndDate.setText(endDate);
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {
    }

    private String startDate;
    private String endDate;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_startDate) {
            PickerViewUtil.showSelectDatePickerViewBefore(this, "起始时间", startDate, dateStr -> {
                startDate = dateStr;
                binding.tvStartDate.setText(dateStr);
                if (!StrUtil.isEmpty(endDate)) {
                    if (!DateUtil.TimeCompare(startDate, endDate)) {
                        endDate = null;
                        binding.tvEndDate.setText(endDate);
                    }
                }
            });
        } else if (v.getId() == R.id.tv_endDate) {
            if (StrUtil.isEmpty(startDate)) {
                ToastUtil.showToast(this, "请先选择起始时间");
                return;
            }
            PickerViewUtil.showSelectDatePickerViewBefore(this, "截止时间", startDate, startDate
                    , dateStr -> {
                        endDate = dateStr;
                        binding.tvEndDate.setText(endDate);
                    });
        } else if (v.getId() == R.id.tv_seach) {
            if (StrUtil.isEmpty(startDate)) {
                ToastUtil.showToast(this, "请先选择起始时间");
                return;
            }
            if (StrUtil.isEmpty(endDate)) {
                ToastUtil.showToast(this, "请选择截止时间");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("startDate", startDate);
            intent.putExtra("endDate", endDate);
            setResult(RESULT_OK, intent);
            finish();
        } else if (v.getId() == R.id.tv_reset) {
            endDate = null;
            startDate = null;
            binding.tvStartDate.setText(null);
            binding.tvEndDate.setText(null);
        }
    }
    private void initTitle() {
        if (getIntent().getStringExtra("code").equals("1")){
            setTitleText("比对数据");
        }else{
            setTitleText("自定义统计");
        }
    }
}
