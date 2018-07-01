package com.statistics.ui.presenter;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.statistics.R;
import com.statistics.api.RetrofitHelper;
import com.statistics.databinding.PopBinding;
import com.statistics.response.AssistantStatisticsRep;
import com.statistics.ui.acitivty.A_Custom_Statistics;
import com.statistics.ui.mvpview.AssistantStatisticsView;
import com.statistics.ui.viewmodel.Level0Item;
import com.statistics.ui.viewmodel.Level1Item;
import com.statistics.ui.viewmodel.Level2Item;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.DateUtil;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.PopupWindowUtile;
import com.waterbase.utile.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 协查统计
 * Created by Water on 2018/4/12.
 */

public class AssistantStatisticsPresenter {

    private static final String TAG = "AssistantStatisticsPresenter";

    private AssistantStatisticsView statisticsView;
    private BaseActivity activity;
    private LifecycleProvider lifecycleProvider;

    public AssistantStatisticsPresenter(AssistantStatisticsView statisticsView, BaseActivity activity
            , LifecycleProvider lifecycleProvider) {
        this.statisticsView = statisticsView;
        this.activity = activity;
        this.lifecycleProvider = lifecycleProvider;
    }

    public void initData(String srartDate, String endDate) {
        this.srartDate = srartDate;
        this.endDate = endDate;
        initData();
    }

    public void initData() {
        HttpManager httpManager = new HttpManager(activity, lifecycleProvider);
        httpManager.doHttpDeal(RetrofitHelper.getApiService().getAssistantStatisticsList(srartDate, endDate)
                , new DefaultObserver<List<AssistantStatisticsRep>>() {
                    @Override
                    public void onSuccess(List<AssistantStatisticsRep> repList) {
                        AssistantStatisticsRep rep;
                        if (repList != null && repList.size() != 0)
                            rep = repList.get(0);
                        else
                            rep = new AssistantStatisticsRep();
                        ArrayList<MultiItemEntity> res = new ArrayList<>();
                        if (index == 0) {
                            res.add(new Level0Item("今日协查统计总数", "累计协查总数"
                                    , rep.getTodayCheckCount(), "" + rep.getCheckCount(), index));
                        } else if (index == 1) {
                            res.add(new Level0Item("累计协查总数", null
                                    , rep.getCheckCount(), null, index));
                        } else if (index == 2) {
                            res.add(new Level0Item("今日协查统计总数"
                                    , null, rep.getTodayCheckCount(), null, index));
                        } else if (index == 3) {
                            res.add(new Level0Item("累计协查总数", "自定义时间段", rep.getCheckCount()
                                    , DateUtil.getStringByFormat(srartDate, "yyyyMMdd", "yyyy-MM-dd")
                                    + "至" + DateUtil.getStringByFormat(endDate, "yyyyMMdd", "yyyy-MM-dd"), index));
                        }
                        Level1Item level1 = new Level1Item("人员属性");
                        // //人员属性code(人员具有多属性): 99:其他,21:涉恐人员, 22:涉稳人员, 23:涉毒人员, 24:在逃人员, 25:违法犯罪人员, 26:重点上访人员, 27:重症精神病人, 28:重点人口
                        level1.addSubItem(new Level2Item("涉恐人员", rep.getTerrorist(), 21));
                        level1.addSubItem(new Level2Item("涉稳人员", rep.getStabilized(), 22));
                        level1.addSubItem(new Level2Item("涉毒人员", rep.getDrugst(), 23));
                        level1.addSubItem(new Level2Item("在逃人员", rep.getFugitive(), 24));
                        level1.addSubItem(new Level2Item("违法犯罪人员", rep.getCrimet(), 25));
                        level1.addSubItem(new Level2Item("重点上访人员", rep.getFocusTarget(), 26));
                        level1.addSubItem(new Level2Item("重症精神病人", rep.getMentalPatients(), 27));
                        level1.addSubItem(new Level2Item("重点人口", rep.getPriorityPopulation(), 28));
//                      level1.addSubItem(new Level2Item("一般人员", rep.getOtherAtrr()));
                        Level1Item level2 = new Level1Item("性别分布");
                        // 性别code： 0:未知的性别; 1:男; 2:女; 3:女性改（变）为男性; 4:男性改（变）为女性;9:未说明的性别
                        level2.addSubItem(new Level2Item("男性", rep.getMale(), 1));
                        level2.addSubItem(new Level2Item("女性", rep.getFemale(), 2));
                        res.add(level1);
                        res.add(level2);
                        statisticsView.callback(res);

                    }
                });
    }

    private int index = 0;
    private String srartDate;
    private String endDate;

    public void rightOneImageOnClick(View rightOneImage, View bg) {
        View view = PopupWindowUtile.showAdaptive3(activity, rightOneImage, bg, R.layout.pop
                , PopupWindowUtile.BOTTOM, false, true);
        PopBinding binding = DataBindingUtil.bind(view);
        binding.setClickNum(index);
        binding.setClick(v -> {
            if (v.getId() == R.id.tv_all) {
                index = 1;
                binding.setClickNum(index);
                srartDate = null;
                endDate = null;
                initData();
            } else if (v.getId() == R.id.tv_today) {
                index = 2;
                binding.setClickNum(index);
                srartDate = DateUtil.getCurrentDate("yyyyMMdd");
                endDate = null;
                initData();
            } else if (v.getId() == R.id.tv_custom) {
                if (index == 3)
                    statisticsView.startAcitvityForResult(srartDate, endDate);
                else {
                    srartDate = null;
                    endDate = null;
                    statisticsView.startAcitvityForResult(null, null);
                    index = 3;
                    binding.setClickNum(index);
                }
            }
            PopupWindowUtile.closePopupWindow();
        });

    }


}
