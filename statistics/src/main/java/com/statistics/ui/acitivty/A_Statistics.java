package com.statistics.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.commondata.event.RefreshEvent;
import com.commondata.util.PickerViewUtil;
import com.statistics.R;
import com.statistics.databinding.AStatisticsBinding;
import com.statistics.ui.viewmodel.PersonneViewModel;
import com.waterbase.utile.LogUtil;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据统计页面1
 * Created by Water on 2018/4/8.
 */

public class A_Statistics extends TitleActivity implements View.OnClickListener {

    private AStatisticsBinding binding;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Statistics.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("数据统计");
        binding = setView(R.layout.a_statistics);
        binding.setClick(this);
    }

    @Subscribe
    public void onEventMainThread(RefreshEvent event) {

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.rl_today_statistics) {
            // 今日数据统计
            A_Today_Statistics.startActivity(this);
        } else if (id == R.id.rl_investigation_statistics) {
            // todo 新疆籍人员协查统计
            A_Assistant_Statistics.startActivity(this);
        } else if (id == R.id.rl_fluxion_statistics) {
            //  todo 新疆籍流动人员统计
            A_FloatingPersonnel_Statistics.startActivity(this);
        }
    }
}
