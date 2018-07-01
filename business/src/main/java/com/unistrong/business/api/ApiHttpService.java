package com.unistrong.business.api;

import com.unistrong.business.bean.ComparisonDataMonthRep;
import com.unistrong.business.bean.FlowPeopleAddReq;
import com.unistrong.business.bean.FlowPeopleEditReq;
import com.unistrong.business.bean.FlowPeopleQueryItemRep;
import com.unistrong.business.bean.FlowPeopleLogOutReq;
import com.unistrong.business.bean.PeoplePhotoQueryRep;
import com.unistrong.business.bean.PersonListBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by edz on 2018/4/14.
 */

public interface ApiHttpService {
    /**
     * 获取人员信息
     *
     * @param strNum          身份证号
     * @param personInfoLevel 信息级别（1：基本信息，2：详细信息，3：特殊信息）
     * @return
     */
    @GET("person/getPersonByIdNum")
    Observable<PersonListBean> getPersonData(@Query("idNum") String strNum, @Query("personInfoLevel") int personInfoLevel);

    /**
     * 获取比对数据
     */
    @GET("comphistory/getCompHistoryPage")
    Observable<List<ComparisonDataMonthRep>> getComparisonData(@QueryMap Map<String, Object> map);

    /**
     * 人像比对查询
     */
    @Multipart
    @POST("comphistory/executePicComp")
    Observable<ArrayList<PeoplePhotoQueryRep>> uploadPeoplePhotoQuery(@PartMap Map<String, RequestBody> bodyMap, @Part MultipartBody.Part part);

    /**
     * 流动人口查询
     */
    @GET("flow/queryFlowInfoList")
    Observable<ArrayList<FlowPeopleQueryItemRep>> uploadFlowPeopleData(@QueryMap() Map<String, Object> map);

    /**
     * 流动人口登记
     */
    @POST("flow/registerFlowInfo")
    Observable<Object> uploadPeopleAddData(@Body FlowPeopleAddReq addReq);

    /**
     * 注销流动信息
     *
     * @param addReq
     * @return
     */
    @POST("flow/logoutFlowInfo")
    Observable<Object> flowPeopleLogOut(@Body FlowPeopleLogOutReq addReq);

    /**
     * 编辑流动人员信息
     *
     * @param editReq
     * @return
     */
    @POST("flow/updateFlowInfo")
    Observable<Object> flowPeopleEdit(@Body FlowPeopleEditReq editReq);

    //
//    @GET("dic/getDictionaryList")
//    Observable<PeoplePhotoQueryRep> uploadPeopleAddData(@Body FlowPeopleAddReq addReq);
}
