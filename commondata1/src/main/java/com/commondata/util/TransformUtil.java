package com.commondata.util;

import com.commondata.R;
import com.waterbase.utile.StrUtil;
import com.waterbase.utile.Utils;

/**
 * 字符转换
 * Created by kb.zhang on 2018/4/15.
 */

public class TransformUtil {
    /**
     * 人员属性类别（1：一般人员，2：白名单，3：红名单）
     *
     * @param personAttr
     * @return
     */
    public static String personAttrformString(String personAttr) {
        if (StrUtil.isEmpty(personAttr))
            return "未说明的";
        switch (personAttr) {
            case "1":
                return "一般人员";
            case "2":
                return "白名单";
            case "3":
                return "红名单";
            default:
                return "未说明的";
        }
    }

    /**
     * 人员属性类别（1：一般人员，2：白名单，3：红名单）
     *
     * @param personAttr
     * @return
     */
    public static int personAttrformColor(String personAttr) {
        if (personAttr == null)
            return Utils.getContext().getResources().getColor(R.color.red);
        switch (personAttr) {
            case "1":
                return Utils.getContext().getResources().getColor(R.color.blue_deep);
            case "2":
                return Utils.getContext().getResources().getColor(R.color.greenButton);
            case "3":
                return Utils.getContext().getResources().getColor(R.color.red);
            default:
                return Utils.getContext().getResources().getColor(R.color.red);
        }
    }


    /**
     * 性别转成字符串
     *
     * @param nSex 1:常住人口; 2: 流动人口; 3:境外常住人口; 4:流动人口; 5:未落常住人口; 6:寄住人口; 7:临时住宿人口; 9:其他
     * @return
     */
    public static String sexTransformString(int nSex) {
        switch (nSex) {
            case 0:
                return "未知的性别";
            case 1:
                return "男";
            case 2:
                return "女";
            case 3:
                return "女性改（变）为男性";
            case 4:
                return "男性改（变）为女性";
            default:
                return "未说明的性别";
        }
    }

    /**
     * 人员类别转换
     *
     * @param nType 1:常住人口; 2: 流动人口; 3:境外常住人口; 4:流动人口; 5:未落常住人口; 6:寄住人口; 7:临时住宿人口; 9:其他
     * @return
     */
    public static String personTypeTransformString(int nType) {
        switch (nType) {
            case 1:
                return "常住人口";
            case 2:
                return "流动人口";
            case 3:
                return "境外常住人口";
            case 4:
                return "流动人口";
            case 5:
                return "未落常住人口";
            case 6:
                return "寄住人口";
            case 7:
                return "临时住宿人口";
            default:
                return "其他";
        }
    }

    /**
     * 人员属性转换
     *
     * @param nAttr 99:其他,21:涉恐人员, 22:涉稳人员, 23:涉毒人员, 24:在逃人员, 25:违法犯罪人员, 26:重点上访人员, 27:重症精神病人, 28:重点人口
     * @return
     */
    public static String personAttrTransformString(int nAttr) {
        switch (nAttr) {
            case 21:
                return "涉恐人员";
            case 22:
                return "涉恐人员";
            case 23:
                return "涉毒人员";
            case 24:
                return "在逃人员";
            case 25:
                return "违法犯罪人员";
            case 26:
                return "重点上访人员";
            case 27:
                return "重症精神病人";
            case 28:
                return "重点人口";
            case 99:
                return "其他";
            default:
                return "其他";
        }
    }

    /**
     * 人员属性转换
     *
     * @param nAttr 99:其他,21:涉恐人员, 22:涉稳人员, 23:涉毒人员, 24:在逃人员, 25:违法犯罪人员, 26:重点上访人员, 27:重症精神病人, 28:重点人口
     * @return
     */
    public static String personAttrTransformString(String nAttr) {
        StringBuffer buffer = new StringBuffer();
        String[] split = nAttr.split(",");
        for (int i=0;i<split.length;i++){
            String attr = personAttrTransformString(Integer.parseInt(split[i]));
            buffer.append(attr+" ");
        }
        return buffer.toString();
    }

    /**
     * 多个人员属性转换
     *
     * @param strAttrs
     * @return
     */
    public static String personAttrsTransform(String strAttrs) {
        String[] str = strAttrs.split(",");
        StringBuilder strPersonAttrs = new StringBuilder();
        for (String strAttr :
                str) {
            strPersonAttrs.append(personAttrTransformString(Integer.parseInt(strAttr))).append(",");
        }
        return strPersonAttrs.toString().substring(0, strPersonAttrs.toString().length() - 1);
    }

    /**
     * 婚姻状态转换
     *
     * @param nMarriage 90：未说明的婚姻状况; 10: 未婚; 20:已婚; 21:初婚; 22:再婚; 23: 复婚; 30:丧偶; 40:离婚
     * @return
     */
    public static String marriageTransformString(int nMarriage) {
        switch (nMarriage) {
            case 10:
                return "未婚";
            case 20:
                return "已婚";
            case 21:
                return "初婚";
            case 22:
                return "再婚";
            case 23:
                return "复婚";
            case 30:
                return "丧偶";
            case 40:
                return "离婚";
            default:
                return "未说明的婚姻状况";
        }
    }

    /**
     * 血型转换字符串
     *
     * @param nBlood
     * @return
     */
    public static String bloodTransform(int nBlood) {
        switch (nBlood) {
            case 0:
                return "未知";
            case 1:
                return "A型";
            case 2:
                return "B型";
            case 3:
                return "O型";
            case 4:
                return "AB型";
            default:
                return "其他";
        }
    }
    public static String bloodHolidayform(int holidayStatus) {
        switch (holidayStatus) {
            case 1:
                return "已申请";
            case 2:
                return "已请假";
            case 3:
                return "已销假";
            case 4:
                return "超时限未销假";
            case 5:
                return "退回";
            case 6:
                return "假期结束未审批";
            case 7:
                return "终止请销假";
            default:
                return "未知";
        }
    }

    /**
     * int型日期转成yyyy-MM-dd
     *
     * @param timestampString
     * @return
     */
    public static String TimeStampDate(String timestampString) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(timestamp));
        return date;
    }

    /**
     * 民族转换字符串
     *
     * @param nation 01:汉族 05:维族 03:回族 17:哈族 02:蒙古族
     * @return
     */
    public static String nationTransform(String nation) {
        if (nation != null) {
            switch (nation) {
                case "01":
                    return "汉族";
                case "05":
                    return "维族";
                case "03":
                    return "回族";
                case "17":
                    return "哈族";
                case "02":
                    return "蒙古族";
                default:
                    return "其他";
            }
        } else {
            return "其他";
        }
    }

    /**
     * 注销标记
     *
     * @param logoutTag 1:表示注销 2:表示未注销 3:表示还原
     * @return
     */
    public static String logoutTagTransform(String logoutTag) {
        if (logoutTag != null) {
            switch (logoutTag) {
                case "1":
                    return "注销";
                case "2":
                    return "未注销";
                case "3":
                    return "还原";
                default:
                    return "其他";
            }
        } else {
            return "其他";
        }
    }

    /**
     * 性别转成字符串
     *
     * @param nSex 1:常住人口; 2: 流动人口; 3:境外常住人口; 4:流动人口; 5:未落常住人口; 6:寄住人口; 7:临时住宿人口; 9:其他
     * @return
     */
    public static String sexTransformString(String nSex) {
        switch (nSex) {
            case "0":
                return "未知的性别";
            case "1":
                return "男";
            case "2":
                return "女";
            case "3":
                return "女性改（变）为男性";
            case "4":
                return "男性改（变）为女性";
            default:
                return "未说明的性别";
        }
    }

    /**
     * 上传数据到服务器时：字符串转成性别Num
     *
     * @param nSex 1:常住人口; 2: 流动人口; 3:境外常住人口; 4:流动人口; 5:未落常住人口; 6:寄住人口; 7:临时住宿人口; 9:其他
     * @return
     */
    public static String sexStrTransformNumStr(String nSex) {
        switch (nSex) {
            case "男":
                return "1";
            case "女":
                return "2";

            default:
                return "0";
        }
    }

    /**
     * 居住处所
     *
     * @param str 居住处所Num
     * @return 居住处所String
     */
    public static String stayPlaceTransformNum2String(String str) {
        if (str != null) {
            switch (str) {
                case "10":
                    return "行业场所";
                case "11":
                    return "宾馆旅店";
                case "12":
                    return "家庭旅店";
                case "13":
                    return "留宿洗浴场所";
                case "14":
                    return "酒店式公寓";


                case "20":
                    return "普通住宅";
                case "21":
                    return "自有住宅";
                case "22":
                    return "公有住宅";
                case "23":
                    return "居民家中";

                case "30":
                    return "租赁房屋";

                case "40":
                    return "单位内部";
                case "41":
                    return "机关团体";
                case "42":
                    return "企事业单位";
                case "43":
                    return "学校";
                case "44":
                    return "部队单位";

                case "50":
                    return "宗教场所";

                case "60":
                    return "治疗养老场所";
                case "61":
                    return "医院";
                case "62":
                    return "疗养院";
                case "63":
                    return "康复中心";
                case "64":
                    return "养老院";

                case "70":
                    return "流动（临时）性住所";
                case "71":
                    return "工地、工棚";
                case "72":
                    return "水上船舶";
                case "73":
                    return "商铺摊点";

                case "80":
                    return "救助场所";

                case "90":
                    return "其他居住场所";


                default:
                    return "其他";
            }
        } else {
            return "其他";
        }
    }


    /**
     * 居住处所
     *
     * @param str 居住处所 String
     * @return 居住处所 Num
     */
    public static String stayPlaceTransformString2Num(String str) {
        if (str != null) {
            switch (str) {
                case "行业场所":
                    return "10";
                case "宾馆旅店":
                    return "11";
                case "家庭旅店":
                    return "12";
                case "留宿洗浴场所":
                    return "13";
                case "酒店式公寓":
                    return "14";


                case "普通住宅":
                    return "20";
                case "自有住宅":
                    return "21";
                case "公有住宅":
                    return "22";
                case "居民家中":
                    return "23";

                case "租赁房屋":
                    return "30";

                case "单位内部":
                    return "40";
                case "机关团体":
                    return "41";
                case "企事业单位":
                    return "42";
                case "学校":
                    return "43";
                case "部队单位":
                    return "44";

                case "宗教场所":
                    return "50";

                case "治疗养老场所":
                    return "60";
                case "医院":
                    return "61";
                case "疗养院":
                    return "62";
                case "康复中心":
                    return "63";
                case "养老院":
                    return "64";

                case "流动（临时）性住所":
                    return "70";
                case "工地、工棚":
                    return "71";
                case "水上船舶":
                    return "72";
                case "商铺摊点":
                    return "73";

                case "救助场所":
                    return "80";

                case "其他居住场所":
                    return "90";


                default:
                    return "";
            }
        } else {
            return "";
        }
    }


    /**
     * 居住事由
     *
     * @param stayReason 居住事由Num
     * @return 居住事由String
     */
    public static String stayReasonTransformNum2String(String stayReason) {
        if (stayReason != null) {
            switch (stayReason) {
                case "131":
                    return "投靠亲友";

                case "201":
                    return "投资";
                case "202":
                    return "购房";
                case "203":
                    return "外国人加入中国籍";
                case "204":
                    return "务工";
                case "205":
                    return "务农";

                case "206":
                    return "经商";
                case "207":
                    return "求学";
                case "208":
                    return "从事服务行业";
                case "209":
                    return "保姆";
                case "210":
                    return "因公出差";

                case "211":
                    return "派出工作";
                case "212":
                    return "借读培训";
                case "213":
                    return "治病疗养";
                case "214":
                    return "探亲访友";
                case "215":
                    return "回原籍";

                case "216":
                    return "旅游度假";
                case "217":
                    return "上访";
                case "218":
                    return "流浪乞讨";
                case "999":
                    return "其他";

                default:
                    return "其他";
            }
        } else {
            return "其他";
        }
    }


    /**
     * 居住事由
     *
     * @param stayReason 居住事由String
     * @return 居住事由Num
     */
    public static String stayReasonTransformString2Num(String stayReason) {
        if (stayReason != null) {
            switch (stayReason) {
                case "投靠亲友":
                    return "131";

                case "投资":
                    return "201";
                case "购房":
                    return "202";
                case "外国人加入中国籍":
                    return "203";
                case "务工":
                    return "204";
                case "务农":
                    return "205";

                case "经商":
                    return "206";
                case "求学":
                    return "207";
                case "从事服务行业":
                    return "208";
                case "保姆":
                    return "209";
                case "因公出差":
                    return "210";

                case "派出工作":
                    return "211";
                case "借读培训":
                    return "212";
                case "治病疗养":
                    return "213";
                case "探亲访友":
                    return "214";
                case "回原籍":
                    return "215";

                case "旅游度假":
                    return "216";
                case "上访":
                    return "217";
                case "流浪乞讨":
                    return "218";
                case "其他":
                    return "999";

                default:
                    return "999";
            }
        } else {
            return "其他";
        }
    }

    /**
     * 拟居住时间
     *
     * @param stayTime Num
     * @return String
     */
    public static String stayTempTransformNum2String(String stayTime) {
        if (stayTime != null) {
            switch (stayTime) {
                case "1":
                    return "一个月以上";
                case "2":
                    return "一个月至一年";
                case "3":
                    return "一年以上";
                default:
                    return "";
            }
        } else {
            return "";
        }
    }

    /**
     * 拟居住时间
     *
     * @param stayTime Num
     * @return String
     */
    public static String stayTempTransformString2Num(String stayTime) {
        if (stayTime != null) {
            switch (stayTime) {
                case "一个月以上":
                    return "1";
                case "一个月至一年":
                    return "2";
                case "一年以上":
                    return "3";
                default:
                    return "";
            }
        } else {
            return "";
        }
    }

    /**
     * 从事职业
     *
     * @param stayTime String
     * @return Num
     */
    public static String jobTransformString2Num(String stayTime) {
        if (stayTime != null) {
            switch (stayTime) {
                case "计算机(IT)业":
                    return "01";
                case "销售业":
                    return "02";
                case "市场营销/公关部":
                    return "03";
                case "客户服务类":
                    return "04";
                case "经营/管理类":
                    return "05";

                case "财务/审计类":
                    return "06";
                case "公司文职类":
                    return "07";
                case "行政/人事类":
                    return "08";
                case "工业/工厂类":
                    return "09";
                case "电子通讯/电气(器)类":
                    return "10";

                case "机械(电)/仪表类":
                    return "11";
                case "金融/保险/证券类":
                    return "12";
                case "房地产建筑/施工类":
                    return "13";
                case "广告(装潢,包装)设计类":
                    return "14";
                case "文体/教育/培训类":
                    return "15";

                case "卫生医疗/美容保健类":
                    return "16";
                case "化工/制药类":
                    return "17";
                case "能源动力类":
                    return "18";
                case "宾馆饭店/餐饮旅游类":
                    return "19";
                case "商店零售服务类":
                    return "20";

                case "技工/普工类":
                    return "21";
                case "轻工类":
                    return "22";
                case "后勤保障类":
                    return "23";
                case "翻译类":
                    return "24";
                case "物流/贸易类":
                    return "25";

                case "咨询/顾问类":
                    return "26";
                case "法律专业人员类":
                    return "27";
                case "影视/摄影专业类":
                    return "28";
                case "编辑/发行类":
                    return "29";
                case "其他类":
                    return "30";
                default:
                    return "";
            }
        } else {
            return "";
        }
    }


    /**
     * 从事职业
     *
     * @param stayTime Num
     * @return String
     */
    public static String jobTransformNum2String(String stayTime) {
        if (stayTime != null) {
            switch (stayTime) {
                case "01":
                    return "计算机(IT)业";
                case "02":
                    return "销售业";
                case "03":
                    return "市场营销/公关部";
                case "04":
                    return "客户服务类";
                case "05":
                    return "经营/管理类";
                case "06":
                    return "财务/审计类";
                case "07":
                    return "公司文职类";
                case "08":
                    return "行政/人事类";
                case "09":
                    return "工业/工厂类";
                case "10":
                    return "电子通讯/电气(器)类";

                case "11":
                    return "机械(电)/仪表类";
                case "12":
                    return "金融/保险/证券类";
                case "13":
                    return "房地产建筑/施工类";
                case "14":
                    return "广告(装潢,包装)设计类";
                case "15":
                    return "文体/教育/培训类";

                case "16":
                    return "卫生医疗/美容保健类";
                case "17":
                    return "化工/制药类";
                case "18":
                    return "能源动力类";
                case "19":
                    return "宾馆饭店/餐饮旅游类";
                case "20":
                    return "商店零售服务类";

                case "21":
                    return "技工/普工类";
                case "22":
                    return "轻工类";
                case "23":
                    return "后勤保障类";
                case "24":
                    return "翻译类";
                case "25":
                    return "物流/贸易类";

                case "26":
                    return "咨询/顾问类";
                case "27":
                    return "法律专业人员类";
                case "28":
                    return "影视/摄影专业类";
                case "29":
                    return "编辑/发行类";
                case "30":
                    return "其他类";
                default:
                    return "其他类";
            }
        } else {
            return "其他类";
        }
    }


}
