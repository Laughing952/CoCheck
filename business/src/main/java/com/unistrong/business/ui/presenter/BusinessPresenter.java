package com.unistrong.business.ui.presenter;

import com.unistrong.business.R;
import com.unistrong.business.bean.Action;
import com.unistrong.business.ui.activity.A_Move_People_Management;
import com.unistrong.business.ui.mvpview.BusinessView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Water on 2018/4/10.
 */

public class BusinessPresenter {

    private static final int MIGRATION = 0; // 流动人口
    private static final int PEOPLE_COMPARED = 1; // 人相对比
    private static final int COORDINATED_MANAGEMENT = 2; // 协同管理
    private static final int STATISTIC_ANALYSIS = 3; // 统计分析

    public static final int[] ACTION_ID = new int[]{MIGRATION, PEOPLE_COMPARED, COORDINATED_MANAGEMENT, STATISTIC_ANALYSIS};
    public static final int[] ACTION_RES = new int[]{R.mipmap.business_flow_people_management, R.mipmap.business_flow_people_photo_comparison
            , R.mipmap.business_flow_people_together_management, R.mipmap.business_flow_people_statistics};
    public static final String[] ACTION_NAME = new String[]{"流动人口管理", "人像对比", "登记历史", "统计分析"};

    private BusinessView businessView;

    public BusinessPresenter(BusinessView businessView) {
        this.businessView = businessView;
    }

    public void intData() {
        List<Action> actionList = new ArrayList<>();
        for (int i = 0; i < ACTION_ID.length; i++) {
            actionList.add(new Action(ACTION_ID[i], ACTION_NAME[i], ACTION_RES[i]));
        }
        businessView.resultData(actionList);
    }

    public void click(Action action) {
        switch (action.getActionID()) {
            case MIGRATION:
                // TODO: 2018/4/10 流动人口管理
                businessView.startActivity("com.unistrong.business.ui.activity.A_Move_People_Management");
                break;
            case PEOPLE_COMPARED:
                // TODO: 2018/4/10 人像对比
                businessView.startActivity("com.unistrong.business.ui.activity.A_People_Photo_Comparison");
                break;
            case COORDINATED_MANAGEMENT:
                // TODO: 2018/4/10 登记历史
                businessView.startActivity("com.unistrong.business.ui.activity.A_Flow_People_Add_History");
                break;
            case STATISTIC_ANALYSIS:
                // TODO: 2018/4/10 统计分析
                businessView.startActivity("com.statistics.ui.acitivty.A_Statistics");
                break;
        }
    }
}
