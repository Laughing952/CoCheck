package com.unistrong.business.ui.presenter;

import android.content.Context;

import com.unistrong.business.api.RetrofitHelper;
import com.unistrong.business.bean.PeoplePhotoQueryRep;
import com.unistrong.business.ui.activity.A_Flow_People_Query;
import com.unistrong.business.ui.activity.A_People_Photo_Query_Result;
import com.unistrong.business.ui.mvpview.IComparisonDataView;
import com.waterbase.http.HttpManager;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.utile.ToastUtil;
import com.waterbase.utile.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Part;

/**
 * Created by edz on 2018/4/14.
 */

public class PeoplePhotoQueryPersenter {

    private HttpManager manager;
    private Context context;

    public PeoplePhotoQueryPersenter(HttpManager manager,Context context) {
        this.manager = manager;
        this.context=context;
    }

    public void uploadImage(Map<String,RequestBody> map, MultipartBody.Part part) {
        if (!map.isEmpty()) {
            manager.doHttpDeal(RetrofitHelper.getApiService().uploadPeoplePhotoQuery(map,part),
                    new DefaultObserver<ArrayList<PeoplePhotoQueryRep>>() {
                        @Override
                        public void onSuccess(ArrayList<PeoplePhotoQueryRep> response) {
                            ToastUtil.showToast(Utils.getContext(), "上传成功");
                            A_People_Photo_Query_Result.startActivity(context,response);
                        }
                    });
        }
    }
}
