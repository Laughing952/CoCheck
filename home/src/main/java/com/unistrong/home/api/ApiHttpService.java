package com.unistrong.home.api;

import com.unistrong.home.bean.PersonListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kb.zhang on 2018/4/14.
 */

public interface ApiHttpService {

    /**
     * 获取人员信息
     * @param strNum 身份证号
     * @param personInfoLevel 信息级别（1：基本信息，2：详细信息，3：特殊信息）
     * @return
     */
    @GET("person/getPersonByIdNum")
    Observable<PersonListBean> getPersonData(@Query("idNum") String strNum, @Query("personInfoLevel") int personInfoLevel);
}
