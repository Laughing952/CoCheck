package com.unistrong.business.utile;

import com.waterbase.utile.DateUtil;

/**
 * Created by edz on 2018/4/26.
 */

public class DateTransform {

    public static String uploadFormat="yyyyMMdd";
    public static String showFormat="yyyy-MM-dd";
    /**
    * 日期转换 20180202转为2018-02-02
    * */
    public static String uploadDateTransformShow(String date){
        return DateUtil.getStringByFormat(date,uploadFormat,showFormat);
    }

    /**
     * 日期转换 2018-02-02 至 2018-02-02 拆分
     * */
    public static String[] TextViewDateTransformUpload (String date){
        String[] res = new String[2];
        if (date!=null && !date.isEmpty()){
            String[] split = date.split(" 至 ");
            res[0]=DateUtil.getStringByFormat(split[0],showFormat,uploadFormat);
            res[1]=DateUtil.getStringByFormat(split[1],showFormat,uploadFormat);
        }
        return res;
    }

    /**
     * 去掉月份前面的0
     */
    public static String mouthTrandformShow(String date,String oldFormat,String newMouthFormat){
        String mouth=DateUtil.getStringByFormat(date,oldFormat,newMouthFormat);
        if (mouth.substring(0,1).equals("0")){
            return mouth.substring(1,mouth.length());
        }else{
            return mouth;
        }
    }

}
