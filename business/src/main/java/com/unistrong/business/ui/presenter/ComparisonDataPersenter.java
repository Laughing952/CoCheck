package com.unistrong.business.ui.presenter;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.ComparisonDataMonthRep;
import com.unistrong.business.entity.Level0Item;
import com.unistrong.business.entity.Level1Item;
import com.unistrong.business.entity.MultiItemEntity;
import com.unistrong.business.entity.Person;
import com.unistrong.business.ui.mvpview.IComparisonDataView;
import com.unistrong.business.utile.DateTransform;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.utile.DateUtil;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.PreferencesManager;
import com.waterbase.utile.ToastUtil;
import com.waterbase.utile.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edz on 2018/4/14.
 */

public class ComparisonDataPersenter {
    private HttpManager manager;
    private IComparisonDataView view;
    private String oldFormat="yyyyMMddHHmmss";
    private String newPersonDateFormat="MM-dd HH:mm:ss";
    private String newDateFormat="MM月dd日";
    private String newMouthFormat="MM月";

    public ComparisonDataPersenter(HttpManager manager, IComparisonDataView view) {
        this.manager = manager;
        this.view = view;
    }

    /**
     * 获取展示数据
     *
     * @return
     */
    public void generateAllHistoryData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("currentPage","1");
        map.put("pageSize","10");
        manager.doHttpDeal(RetrofitHelper.getApiService().getComparisonData(map),
                new DefaultObserver<List<ComparisonDataMonthRep>>() {
                    @Override
                    public void onSuccess(List<ComparisonDataMonthRep> response) {
                        ToastUtil.showToast(Utils.getContext(),"查询成功");
                        ArrayList<MultiItemEntity> httpData = getHttpData(response);
                        view.showData(httpData);
                    }
                });
    }

    /**
     * 获取展示数据
     *
     * @return
     */
    public void generateData(Map map) {
        manager.doHttpDeal(RetrofitHelper.getApiService().getComparisonData(map),
                new DefaultObserver<List<ComparisonDataMonthRep>>() {
                    @Override
                    public void onSuccess(List<ComparisonDataMonthRep> response) {
                        ToastUtil.showToast(Utils.getContext(),"查询成功");
                        ArrayList<MultiItemEntity> httpData = getHttpData(response);
                        view.showData(httpData);
                    }
                });
    }

    /**
     * 获取刷新数据
     *
     * @return
     */
    public void generateRefreshData(Map map) {
        manager.doHttpDeal(RetrofitHelper.getApiService().getComparisonData(map),
                new DefaultObserver<List<ComparisonDataMonthRep>>() {
                    @Override
                    public void onSuccess(List<ComparisonDataMonthRep> response) {
                        ToastUtil.showToast(Utils.getContext(),"刷新成功");
                        ArrayList<MultiItemEntity> httpData = getHttpData(response);
                        view.showRefreshData(httpData);
                    }
                });
    }

    /**
     * 获取加载更多数据
     *
     * @return
     */
    public void generateLoadMoreData(Map map) {
        manager.doHttpDeal(RetrofitHelper.getApiService().getComparisonData(map),
                new DefaultObserver<List<ComparisonDataMonthRep>>() {
                    @Override
                    public void onSuccess(List<ComparisonDataMonthRep> response) {
                        ArrayList<MultiItemEntity> httpData = getHttpData(response);
                        view.showLoadMoreData(httpData);
                    }
                });
    }

    public ArrayList<MultiItemEntity> getHttpData(List<ComparisonDataMonthRep> response){
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        ArrayList<String> item0 = new ArrayList<>();
        ArrayList<String> item1 = new ArrayList<>();
        HashMap<String, Level0Item> level0ItemHashMap = new HashMap<>();
        HashMap<String, Level1Item> level1ItemHashMap = new HashMap<>();
        for (int i = 0; i < response.size(); i++) {
            //20180421113812
            String mouth = DateTransform.mouthTrandformShow(response.get(i).getCompTime(),oldFormat,newMouthFormat);
            String date = DateTransform.mouthTrandformShow(response.get(i).getCompTime(),oldFormat,newDateFormat)+DateUtil.getWeekNumber(
                    response.get(i).getCompTime(),oldFormat);

            if (item0.contains(mouth)) {
                if (item1.contains(date)) {
                    Person person = new Person(DateUtil.getStringByFormat(response.get(i).getCompTime(),
                            oldFormat,newPersonDateFormat),response.get(i).getImageSrc());
                    level1ItemHashMap.get(date).addSubItem(person);
                } else {
                    Level1Item level1Item = new Level1Item(date);
                    Person person = new Person(DateUtil.getStringByFormat(response.get(i).getCompTime(),
                            oldFormat,newPersonDateFormat),response.get(i).getImageSrc());
                    level1Item.addSubItem(person);
                    level0ItemHashMap.get(mouth).addSubItem(level1Item);
                    item1.add(date);
                    level1ItemHashMap.put(date, level1Item);
                }
            } else {
                Level0Item level0Item = new Level0Item(mouth);
                Level1Item level1Item = new Level1Item(date);
                Person person = new Person(DateUtil.getStringByFormat(response.get(i).getCompTime(),
                        oldFormat,newPersonDateFormat),response.get(i).getImageSrc());
                level1Item.addSubItem(person);
                level0Item.addSubItem(level1Item);
                item1.add(date);
                item0.add(mouth);
                level1ItemHashMap.put(date, level1Item);
                level0ItemHashMap.put(mouth, level0Item);
            }
        }
        for (Level0Item v : level0ItemHashMap.values()) {
            res.add(v);
        }
        return res;

//        int lv0Count = 1;
//        int lv1Count = 1;
//        int personCount = 1;
//
//        ArrayList<MultiItemEntity> res = new ArrayList<>();
//        PreferencesManager preferencesManager = PreferencesManager.getInstance(Utils.getContext(), "people_photo_compare");
//        for (int i = 0; i < lv0Count; i++) {
////            Level0Item level0Item = new Level0Item(preferencesManager.get("photo_date", "").substring(0,7));
//            Level0Item level0Item = new Level0Item(preferencesManager.get("photo_date", ""));
//            for (int j = 0; j < lv1Count; j++) {
////                Level1Item level1Item = new Level1Item(preferencesManager.get("photo_date", "").substring(0,10));
//                Level1Item level1Item = new Level1Item(preferencesManager.get("photo_date", ""));
//                for (int k = 0; k < personCount; k++) {
////                    String photo_uri = preferencesManager.get("photo_uri", "").substring(7);
//                    String photo_uri = preferencesManager.get("photo_uri", "");
//                    String photo_date = preferencesManager.get("photo_date", "");
//                    LogUtil.e("cuihao", "photo_uri  " + photo_uri);
//                    Person person = new Person(photo_date, photo_uri);
//                    level1Item.addSubItem(person);
//                }
//                level0Item.addSubItem(level1Item);
//            }
//            res.add(level0Item);
//        }
////        view.showData(res);
//        return res;
    }
}



