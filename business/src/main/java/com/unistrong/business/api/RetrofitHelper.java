package com.unistrong.business.api;


import com.waterbase.http.common.IdeaApi;
import com.waterbase.http.common.RxRetrofitApp;

public class RetrofitHelper {
    private static ApiHttpService apiHttpService;

    public static ApiHttpService getApiService(){
        return apiHttpService;
    }

    static {
        apiHttpService= IdeaApi.getApiService(ApiHttpService.class, RxRetrofitApp.getApiServerUrl());
    }
}
