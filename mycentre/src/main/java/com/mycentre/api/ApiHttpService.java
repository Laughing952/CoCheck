package com.mycentre.api;


import android.database.Observable;

import com.mycentre.bean.VersionInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kb.zhang on 2018/4/14.
 */

public interface ApiHttpService {

    /**
     * 获取版本信息
     * @return
     */
    @GET("getVersion")
    io.reactivex.Observable<VersionInfo> getVersion();
}
