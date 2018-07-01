package com.statistics.api;


import com.statistics.response.AssistantStatisticsRep;
import com.statistics.response.ColumnInfoRep;
import com.statistics.response.FamilyMembersRep;
import com.statistics.response.InvolvedInfoRep;
import com.statistics.response.MotionTrailRep;
import com.statistics.response.PersonneRep;
import com.statistics.response.PersonnelDetailsRep;
import com.statistics.response.TodayStatisticsRep;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dell on 2017/4/1.
 */

public interface IdeaApiService {

    /**
     * 数据分析
     *
     * @return
     */
    @GET("dataStatisticsAnalysis/queryAllPersonData")
    Observable<TodayStatisticsRep> queryAllPersonData();

    /**
     * 获取当前用户的协查统计数据
     *
     * @param date 指定日期，统计某一天的，不传入则统计累计数（格式：yyyyMMdd）
     * @return
     */
    @GET("dataStatisticsAnalysis/myCheckStatisticsData")
    Observable<List<AssistantStatisticsRep>> getAssistantStatisticsList(@Query("date") String date
            ,@Query("dateEnd") String dateEnd);

    /**
     * 获取当前用户的流口统计数据
     *
     * @param date 指定日期，统计某一天的，不传入则统计累计数（格式：yyyyMMdd）
     * @return
     */
    @GET("dataStatisticsAnalysis/myFlowStatisticsData")
    Observable<List<AssistantStatisticsRep>> getFloatingPersonnelStatisticsList(@Query("date") String date
            ,@Query("dateEnd") String dateEnd);

    /**
     * 根据查询参数查询流动列表
     *
     * @param personAttr
     * @return
     */
    @GET("flow/queryFlowInfoList")
    Observable<List<PersonneRep>> queryFlowInfoList(@Query("currentPage") int currentPage
            , @Query("pageSize") int pageSize , @Query("personAttr") int personAttr);

    /**
     * 组合查询协查列表
     *
     * @param personAttr
     * @return
     */
    @GET("check/getCheckList")
    Observable<List<PersonneRep>> getCheckList(@Query("currentPage") int currentPage
            , @Query("pageSize") int pageSize , @Query("personAttr") int personAttr);

    /**
     * 根据身份证号查询人员，可返回不同级别的信息
     *
     * @param idCardNum 身份证号
     * @return
     */
    @GET("person/getPersonByIdNum")
    Observable<PersonnelDetailsRep> getPersonnelDetails(@Query("idNum") String idCardNum);

    /**
     * 获取人员涉案犯罪信息列表
     *
     * @param currentPage 当前页，从1开始
     * @param pageSize    每页显示的总条数
     * @param idCardNum   身份证号
     * @return
     */
    @GET("person/getPersonCrimeInfoList")
    Observable<List<InvolvedInfoRep>> getCrimeInfoList(@Query("currentPage") int currentPage
            , @Query("pageSize") int pageSize, @Query("idNum") String idCardNum);

    /**
     * 获取人员列管监禁列表
     *
     * @param currentPage 当前页，从1开始
     * @param pageSize    每页显示的总条数
     * @param idCardNum   身份证号
     * @return
     */
    @GET("person/getPersonJailedInfoList")
    Observable<List<ColumnInfoRep>> getColumnInfoList(@Query("currentPage") int currentPage
            , @Query("pageSize") int pageSize, @Query("idNum") String idCardNum);


    /**
     * 根据身份证号获取人员流动信息列表
     *
     * @param currentPage 当前页，从1开始
     * @param pageSize    每页显示的总条数
     * @param idCardNum   身份证号
     * @return
     */
    @GET("person/getPersonFlowInfoList")
    Observable<List<MotionTrailRep>> getMotionTrailList(@Query("currentPage") int currentPage
            , @Query("pageSize") int pageSize, @Query("idNum") String idCardNum);

    /**
     * 根据身份证号获取人员家庭成员列表
     *
     * @param currentPage 当前页，从1开始
     * @param pageSize    每页显示的总条数
     * @param idCardNum   身份证号
     * @return
     */
    @GET("person/getPersonFamilyList")
    Observable<List<FamilyMembersRep>> getFamilyMembersList(@Query("currentPage") int currentPage
            , @Query("pageSize") int pageSize, @Query("idNum") String idCardNum);
}
