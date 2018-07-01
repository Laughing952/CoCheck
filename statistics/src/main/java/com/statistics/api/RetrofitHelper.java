package com.statistics.api;


import com.waterbase.http.common.IdeaApi;
import com.waterbase.http.common.RxRetrofitApp;
import com.waterbase.utile.LogUtil;

public class RetrofitHelper {
    private static IdeaApiService mIdeaApiService;

    public static IdeaApiService getApiService() {
        LogUtil.d("RetrofitHelper", "BaseUrl:  " + RxRetrofitApp.getApiServerUrl());
        return mIdeaApiService;
    }

    static {
        mIdeaApiService = IdeaApi.getApiService(IdeaApiService.class, RxRetrofitApp.getApiServerUrl());
    }
}
