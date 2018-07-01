package com.login.api;

import com.login.bean.UserBean;
import com.login.bean.VersionInfo;
import com.waterbase.http.common.BasicResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by dell on 2017/4/1.
 */

public interface IdeaApiService {

    /**
     * 登录
     * @param strUser 用户名
     * @param strPwd 密码
     * @return
     */
    @Headers("Cache-Control: public, max-age=3600")//设置缓存 缓存时间为3600s
    @POST("user/login")
    Observable<UserBean> login(@Query("username") String strUser, @Query("password") String strPwd);

    /**
     * 获取版本信息
     * @return
     */
    @GET("getVersion")
    Observable<VersionInfo> getVersion();

    /**
     * 下载APK
     * @param url 下载地址
     * @return
     */
    @Streaming
    @GET
    Observable<ResponseBody> downLoad(@Url String url);

    @Multipart
    @POST("upload/uploadFile.do")
    Observable<BasicResponse> uploadFiles(@Part List<MultipartBody.Part> partList);


    @POST("upload/uploadFile.do")
    Observable<BasicResponse> uploadFiles(@Part("filename") String description,
                                          @Part("pic\"; filename=\"image1.png") RequestBody imgs1,
                                          @Part("pic\"; filename=\"image2.png") RequestBody imgs2);


    @POST("upload/uploadFile.do")
    Observable<BasicResponse> uploadFiles(@Part("filename") String description, @PartMap() Map<String, RequestBody> maps);


}
