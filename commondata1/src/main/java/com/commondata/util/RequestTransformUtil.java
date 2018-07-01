package com.commondata.util;

import com.commondata.viewmodel.AgeViewModel;
import com.commondata.viewmodel.EthnicViewModel;
import com.commondata.viewmodel.IsEffectiveViewModel;
import com.commondata.viewmodel.MyCenterSexViewModel;
import com.commondata.viewmodel.PersonAttributesViewModel;
import com.commondata.viewmodel.PersonStateViewModel;
import com.commondata.viewmodel.ProvinceViewModel;
import com.commondata.viewmodel.TempStayAddressViewModel;
import com.commondata.viewmodel.TempStayReasonViewModel;
import com.commondata.viewmodel.TempStayTimeViewModel;
import com.commondata.viewmodel.TempWorkViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edz on 2018/4/18.
 */

public class RequestTransformUtil {

    public static ArrayList<PersonStateViewModel> initPersonStateData() {
        ArrayList<PersonStateViewModel> mPersonStateViewModelList = new ArrayList<>();
        mPersonStateViewModelList.add(new PersonStateViewModel("状态1", "1"));
        mPersonStateViewModelList.add(new PersonStateViewModel("状态2", "2"));
        mPersonStateViewModelList.add(new PersonStateViewModel("状态3", "3"));
        return mPersonStateViewModelList;
    }

    public static ArrayList<MyCenterSexViewModel> initSexData() {
        ArrayList<MyCenterSexViewModel> mSexList = new ArrayList<MyCenterSexViewModel>();
        mSexList.add(new MyCenterSexViewModel("男", "1"));
        mSexList.add(new MyCenterSexViewModel("女", "2"));
        return mSexList;
    }

    public static ArrayList<EthnicViewModel> initEthnicData() {
        ArrayList<EthnicViewModel> mEthnicList = new ArrayList<EthnicViewModel>();
        mEthnicList.add(new EthnicViewModel("维吾尔族", ""));
        mEthnicList.add(new EthnicViewModel("汉族", "01"));
        mEthnicList.add(new EthnicViewModel("蒙古族", "02"));
        mEthnicList.add(new EthnicViewModel("回族", "03"));
        mEthnicList.add(new EthnicViewModel("藏族", ""));
        mEthnicList.add(new EthnicViewModel("维族", "05"));
        mEthnicList.add(new EthnicViewModel("哈族", "17"));
        mEthnicList.add(new EthnicViewModel("苗族", ""));
        mEthnicList.add(new EthnicViewModel("彝族", ""));
        mEthnicList.add(new EthnicViewModel("壮族", ""));
        mEthnicList.add(new EthnicViewModel("哈萨克族", ""));
        mEthnicList.add(new EthnicViewModel("布依族", ""));
        mEthnicList.add(new EthnicViewModel("朝鲜族", ""));
        mEthnicList.add(new EthnicViewModel("满族", ""));
        mEthnicList.add(new EthnicViewModel("侗族", ""));
        mEthnicList.add(new EthnicViewModel("瑶族", ""));
        mEthnicList.add(new EthnicViewModel("白族", ""));
        mEthnicList.add(new EthnicViewModel("土家族", ""));
        mEthnicList.add(new EthnicViewModel("哈尼族", ""));
        mEthnicList.add(new EthnicViewModel("傣族", ""));
        mEthnicList.add(new EthnicViewModel("黎族", ""));
        mEthnicList.add(new EthnicViewModel("僳僳族", ""));
        mEthnicList.add(new EthnicViewModel("佤族", ""));
        mEthnicList.add(new EthnicViewModel("畲族", ""));
        mEthnicList.add(new EthnicViewModel("高山族", ""));
        mEthnicList.add(new EthnicViewModel("拉祜族", ""));
        mEthnicList.add(new EthnicViewModel("水族", ""));
        mEthnicList.add(new EthnicViewModel("东乡族", ""));
        mEthnicList.add(new EthnicViewModel("纳西族", ""));
        mEthnicList.add(new EthnicViewModel("景颇族", ""));
        mEthnicList.add(new EthnicViewModel("柯尔克孜族", ""));
        mEthnicList.add(new EthnicViewModel("土族", ""));
        mEthnicList.add(new EthnicViewModel("达斡尔族", ""));
        mEthnicList.add(new EthnicViewModel("仫佬族", ""));
        mEthnicList.add(new EthnicViewModel("羌族", ""));
        mEthnicList.add(new EthnicViewModel("布朗族", ""));
        mEthnicList.add(new EthnicViewModel("撒拉族", ""));
        mEthnicList.add(new EthnicViewModel("毛南族", ""));
        mEthnicList.add(new EthnicViewModel("仡佬族", ""));
        mEthnicList.add(new EthnicViewModel("锡伯族", ""));
        mEthnicList.add(new EthnicViewModel("阿昌族", ""));
        mEthnicList.add(new EthnicViewModel("普米族", ""));
        mEthnicList.add(new EthnicViewModel("塔吉克族", ""));
        mEthnicList.add(new EthnicViewModel("怒族", ""));
        mEthnicList.add(new EthnicViewModel("乌孜别克族", ""));
        mEthnicList.add(new EthnicViewModel("俄罗斯族", ""));
        mEthnicList.add(new EthnicViewModel("鄂温克族", ""));
        mEthnicList.add(new EthnicViewModel("德昂族", ""));
        mEthnicList.add(new EthnicViewModel("保安族", ""));
        mEthnicList.add(new EthnicViewModel("裕固族", ""));
        mEthnicList.add(new EthnicViewModel("京族", ""));
        mEthnicList.add(new EthnicViewModel("塔塔尔族", ""));
        mEthnicList.add(new EthnicViewModel("独龙族", ""));
        mEthnicList.add(new EthnicViewModel("鄂伦春族", ""));
        mEthnicList.add(new EthnicViewModel("赫哲族", ""));
        mEthnicList.add(new EthnicViewModel("门巴族", ""));
        mEthnicList.add(new EthnicViewModel("珞巴族", ""));
        mEthnicList.add(new EthnicViewModel("基诺族", ""));
        return mEthnicList;
    }

    public static ArrayList<IsEffectiveViewModel> initEffectiveData() {
        ArrayList<IsEffectiveViewModel> mEffectiveList = new ArrayList<IsEffectiveViewModel>();
        mEffectiveList.add(new IsEffectiveViewModel("注销", "1"));
        mEffectiveList.add(new IsEffectiveViewModel("未注销", "2"));
        return mEffectiveList;
    }

    public static ArrayList<PersonAttributesViewModel> initPersonAttributesData() {
        ArrayList<PersonAttributesViewModel> mPersonAttributesList = new ArrayList<PersonAttributesViewModel>();
        mPersonAttributesList.add(new PersonAttributesViewModel("一般人员", "1"));
        mPersonAttributesList.add(new PersonAttributesViewModel(" 人员属性2", "2"));
        mPersonAttributesList.add(new PersonAttributesViewModel("人员属性3", "3"));
        return mPersonAttributesList;
    }

    //暂时居住天数
    public static List<TempStayTimeViewModel> initTempStayTimeData() {
        List<TempStayTimeViewModel> mTempStayTimeList = new ArrayList<TempStayTimeViewModel>();
        mTempStayTimeList.add(new TempStayTimeViewModel("一个月以下", "1"));
        mTempStayTimeList.add(new TempStayTimeViewModel("一个月至一年", "2"));
        mTempStayTimeList.add(new TempStayTimeViewModel("一年以上", "3"));
        return mTempStayTimeList;
    }

    //从事职业
    public static List<TempWorkViewModel> initTempWorkData() {
        List<TempWorkViewModel> mTempWorkList = new ArrayList<TempWorkViewModel>();
        mTempWorkList.add(new TempWorkViewModel("计算机(IT)业", "01"));
        mTempWorkList.add(new TempWorkViewModel("销售业", "02"));
        mTempWorkList.add(new TempWorkViewModel("市场营销/公关部", "03"));
        mTempWorkList.add(new TempWorkViewModel("客户服务类", "04"));
        mTempWorkList.add(new TempWorkViewModel("经营/管理类", "05"));
        mTempWorkList.add(new TempWorkViewModel("财务/审计类", "06"));
        mTempWorkList.add(new TempWorkViewModel("公司文职类", "07"));
        mTempWorkList.add(new TempWorkViewModel("行政/人事类", "08"));
        mTempWorkList.add(new TempWorkViewModel("工业/工厂类", "09"));
        mTempWorkList.add(new TempWorkViewModel("电子通讯/电气(器)类", "10"));
        mTempWorkList.add(new TempWorkViewModel("机械(电)/仪表类", "11"));
        mTempWorkList.add(new TempWorkViewModel("金融/保险/证券类", "12"));
        mTempWorkList.add(new TempWorkViewModel("房地产建筑/施工类", "13"));
        mTempWorkList.add(new TempWorkViewModel("广告(装潢,包装)设计类", "14"));
        mTempWorkList.add(new TempWorkViewModel("文体/教育/培训类", "15"));
        mTempWorkList.add(new TempWorkViewModel("卫生医疗/美容保健类", "16"));
        mTempWorkList.add(new TempWorkViewModel("化工/制药类", "17"));
        mTempWorkList.add(new TempWorkViewModel("能源动力类", "18"));
        mTempWorkList.add(new TempWorkViewModel("宾馆饭店/餐饮旅游类", "19"));
        mTempWorkList.add(new TempWorkViewModel("商店零售服务类", "20"));
        mTempWorkList.add(new TempWorkViewModel("技工/普工类", "21"));
        mTempWorkList.add(new TempWorkViewModel("轻工类", "22"));
        mTempWorkList.add(new TempWorkViewModel("后勤保障类", "23"));
        mTempWorkList.add(new TempWorkViewModel("翻译类", "24"));
        mTempWorkList.add(new TempWorkViewModel("物流/贸易类", "25"));
        mTempWorkList.add(new TempWorkViewModel("咨询/顾问类", "26"));
        mTempWorkList.add(new TempWorkViewModel("法律专业人员类", "27"));
        mTempWorkList.add(new TempWorkViewModel("影视/摄影专业类", "28"));
        mTempWorkList.add(new TempWorkViewModel("编辑/发行类", "29"));
        mTempWorkList.add(new TempWorkViewModel("其他类", "30"));
        return mTempWorkList;
    }

    //暂时居住处所
    public static List<TempStayAddressViewModel> initTempStayAddressData() {
        List<TempStayAddressViewModel> mTempStayAddressList = new ArrayList<TempStayAddressViewModel>();
        mTempStayAddressList.add(new TempStayAddressViewModel("行业场所", "10"));
        mTempStayAddressList.add(new TempStayAddressViewModel("宾馆旅店", "11"));
        mTempStayAddressList.add(new TempStayAddressViewModel("家庭旅店", "12"));
        mTempStayAddressList.add(new TempStayAddressViewModel("留宿洗浴场所", "13"));
        mTempStayAddressList.add(new TempStayAddressViewModel("酒店式公寓", "14"));
        mTempStayAddressList.add(new TempStayAddressViewModel("普通住宅", "20"));
        mTempStayAddressList.add(new TempStayAddressViewModel("自有住宅", "21"));
        mTempStayAddressList.add(new TempStayAddressViewModel("公有住宅", "22"));
        mTempStayAddressList.add(new TempStayAddressViewModel("居民家中", "23"));
        mTempStayAddressList.add(new TempStayAddressViewModel("租赁房屋", "30"));
        mTempStayAddressList.add(new TempStayAddressViewModel("单位内部", "40"));
        mTempStayAddressList.add(new TempStayAddressViewModel("机关团体", "41"));
        mTempStayAddressList.add(new TempStayAddressViewModel("企事业单位", "42"));
        mTempStayAddressList.add(new TempStayAddressViewModel("学校", "43"));
        mTempStayAddressList.add(new TempStayAddressViewModel("部队单位", "44"));
        mTempStayAddressList.add(new TempStayAddressViewModel("宗教场所", "50"));
        mTempStayAddressList.add(new TempStayAddressViewModel("治疗养老场所", "60"));
        mTempStayAddressList.add(new TempStayAddressViewModel("医院", "61"));
        mTempStayAddressList.add(new TempStayAddressViewModel("疗养院", "62"));
        mTempStayAddressList.add(new TempStayAddressViewModel("康复中心", "63"));
        mTempStayAddressList.add(new TempStayAddressViewModel("养老院", "64"));
        mTempStayAddressList.add(new TempStayAddressViewModel("流动（临时）性住所", "70"));
        mTempStayAddressList.add(new TempStayAddressViewModel("工地、工棚", "71"));
        mTempStayAddressList.add(new TempStayAddressViewModel("水上船舶", "72"));
        mTempStayAddressList.add(new TempStayAddressViewModel("商铺摊点", "73"));
        mTempStayAddressList.add(new TempStayAddressViewModel("救助场所", "80"));
        mTempStayAddressList.add(new TempStayAddressViewModel("其他居住场所", "90"));
        return mTempStayAddressList;
    }

    //暂居住事由
    public static List<TempStayReasonViewModel> initTempStayReasonData() {
        List<TempStayReasonViewModel> mTempStayReasonList = new ArrayList<TempStayReasonViewModel>();
        mTempStayReasonList.add(new TempStayReasonViewModel("投靠亲友", "131"));
        mTempStayReasonList.add(new TempStayReasonViewModel("投资", "201"));
        mTempStayReasonList.add(new TempStayReasonViewModel("购房", "202"));
        mTempStayReasonList.add(new TempStayReasonViewModel("外国人加入中国籍", "203"));
        mTempStayReasonList.add(new TempStayReasonViewModel("务工", "204"));
        mTempStayReasonList.add(new TempStayReasonViewModel("务农", "205"));
        mTempStayReasonList.add(new TempStayReasonViewModel("经商", "206"));
        mTempStayReasonList.add(new TempStayReasonViewModel("求学", "207"));
        mTempStayReasonList.add(new TempStayReasonViewModel("从事服务行业", "208"));
        mTempStayReasonList.add(new TempStayReasonViewModel("保姆", "209"));
        mTempStayReasonList.add(new TempStayReasonViewModel("因公出差", "210"));
        mTempStayReasonList.add(new TempStayReasonViewModel("派出工作", "211"));
        mTempStayReasonList.add(new TempStayReasonViewModel("借读培训", "212"));
        mTempStayReasonList.add(new TempStayReasonViewModel("治病疗养", "213"));
        mTempStayReasonList.add(new TempStayReasonViewModel("探亲访友", "214"));
        mTempStayReasonList.add(new TempStayReasonViewModel("回原籍", "215"));
        mTempStayReasonList.add(new TempStayReasonViewModel("旅游度假", "216"));
        mTempStayReasonList.add(new TempStayReasonViewModel("上访", "217"));
        mTempStayReasonList.add(new TempStayReasonViewModel("流浪乞讨", "218"));
        mTempStayReasonList.add(new TempStayReasonViewModel("其他", "999"));
//
        return mTempStayReasonList;
    }

    public static List initAgeData() {
        List mAgeList = new ArrayList<>();
        mAgeList.add(new AgeViewModel("10"));
        mAgeList.add(new AgeViewModel("11"));
        mAgeList.add(new AgeViewModel("12"));
        mAgeList.add(new AgeViewModel("13"));
        mAgeList.add(new AgeViewModel("14"));
        mAgeList.add(new AgeViewModel("15"));
        mAgeList.add(new AgeViewModel("16"));
        mAgeList.add(new AgeViewModel("17"));
        mAgeList.add(new AgeViewModel("18"));
        mAgeList.add(new AgeViewModel("19"));
        mAgeList.add(new AgeViewModel("20"));
        mAgeList.add(new AgeViewModel("21"));
        mAgeList.add(new AgeViewModel("22"));
        mAgeList.add(new AgeViewModel("23"));
        mAgeList.add(new AgeViewModel("24"));
        mAgeList.add(new AgeViewModel("25"));
        mAgeList.add(new AgeViewModel("26"));
        mAgeList.add(new AgeViewModel("27"));
        mAgeList.add(new AgeViewModel("28"));
        mAgeList.add(new AgeViewModel("29"));
        mAgeList.add(new AgeViewModel("30"));
        mAgeList.add(new AgeViewModel("31"));
        mAgeList.add(new AgeViewModel("32"));
        mAgeList.add(new AgeViewModel("33"));
        mAgeList.add(new AgeViewModel("34"));
        mAgeList.add(new AgeViewModel("35"));
        mAgeList.add(new AgeViewModel("36"));
        mAgeList.add(new AgeViewModel("37"));
        mAgeList.add(new AgeViewModel("38"));
        mAgeList.add(new AgeViewModel("39"));
        mAgeList.add(new AgeViewModel("40"));
        mAgeList.add(new AgeViewModel("41"));
        mAgeList.add(new AgeViewModel("42"));
        mAgeList.add(new AgeViewModel("43"));
        mAgeList.add(new AgeViewModel("44"));
        mAgeList.add(new AgeViewModel("45"));
        mAgeList.add(new AgeViewModel("46"));
        mAgeList.add(new AgeViewModel("47"));
        mAgeList.add(new AgeViewModel("48"));
        mAgeList.add(new AgeViewModel("49"));
        mAgeList.add(new AgeViewModel("50"));
        mAgeList.add(new AgeViewModel("51"));
        mAgeList.add(new AgeViewModel("52"));
        mAgeList.add(new AgeViewModel("53"));
        mAgeList.add(new AgeViewModel("54"));
        mAgeList.add(new AgeViewModel("55"));
        mAgeList.add(new AgeViewModel("56"));
        mAgeList.add(new AgeViewModel("57"));
        mAgeList.add(new AgeViewModel("58"));
        mAgeList.add(new AgeViewModel("59"));
        mAgeList.add(new AgeViewModel("60"));
        mAgeList.add(new AgeViewModel("61"));
        mAgeList.add(new AgeViewModel("62"));
        mAgeList.add(new AgeViewModel("63"));
        mAgeList.add(new AgeViewModel("64"));
        mAgeList.add(new AgeViewModel("65"));
        mAgeList.add(new AgeViewModel("66"));
        mAgeList.add(new AgeViewModel("67"));
        mAgeList.add(new AgeViewModel("68"));
        mAgeList.add(new AgeViewModel("69"));
        mAgeList.add(new AgeViewModel("70"));
        mAgeList.add(new AgeViewModel("71"));
        mAgeList.add(new AgeViewModel("72"));
        mAgeList.add(new AgeViewModel("73"));
        mAgeList.add(new AgeViewModel("74"));
        mAgeList.add(new AgeViewModel("75"));
        mAgeList.add(new AgeViewModel("76"));
        mAgeList.add(new AgeViewModel("77"));
        mAgeList.add(new AgeViewModel("78"));
        mAgeList.add(new AgeViewModel("79"));
        mAgeList.add(new AgeViewModel("80"));
        mAgeList.add(new AgeViewModel("81"));
        mAgeList.add(new AgeViewModel("82"));
        mAgeList.add(new AgeViewModel("83"));
        mAgeList.add(new AgeViewModel("84"));
        mAgeList.add(new AgeViewModel("85"));
        mAgeList.add(new AgeViewModel("86"));
        mAgeList.add(new AgeViewModel("87"));
        mAgeList.add(new AgeViewModel("88"));
        mAgeList.add(new AgeViewModel("89"));
        mAgeList.add(new AgeViewModel("90"));
        mAgeList.add(new AgeViewModel("91"));
        mAgeList.add(new AgeViewModel("92"));
        mAgeList.add(new AgeViewModel("93"));
        mAgeList.add(new AgeViewModel("94"));
        mAgeList.add(new AgeViewModel("95"));
        mAgeList.add(new AgeViewModel("96"));
        mAgeList.add(new AgeViewModel("97"));
        mAgeList.add(new AgeViewModel("98"));
        mAgeList.add(new AgeViewModel("99"));
        return mAgeList;
    }

    /**
     * 省的数据集合
     *
     * @return
     */
    public static List initProvinceData() {
        List<ProvinceViewModel> mProvinceList = new ArrayList<ProvinceViewModel>();
        mProvinceList.add(new ProvinceViewModel("北京市"));
        mProvinceList.add(new ProvinceViewModel("天津市"));
        mProvinceList.add(new ProvinceViewModel("上海市"));
        mProvinceList.add(new ProvinceViewModel("重庆市"));
        mProvinceList.add(new ProvinceViewModel("河北省"));
        mProvinceList.add(new ProvinceViewModel("山西省"));
        mProvinceList.add(new ProvinceViewModel("山西省"));
        mProvinceList.add(new ProvinceViewModel("辽宁省"));
        mProvinceList.add(new ProvinceViewModel("吉林省"));
        mProvinceList.add(new ProvinceViewModel("黑龙江省"));
        mProvinceList.add(new ProvinceViewModel("江苏省"));
        mProvinceList.add(new ProvinceViewModel("浙江省"));
        mProvinceList.add(new ProvinceViewModel("安徽省"));
        mProvinceList.add(new ProvinceViewModel("福建省"));
        mProvinceList.add(new ProvinceViewModel("江西省"));
        mProvinceList.add(new ProvinceViewModel("山东省"));
        mProvinceList.add(new ProvinceViewModel("河南省"));
        mProvinceList.add(new ProvinceViewModel("湖北省"));
        mProvinceList.add(new ProvinceViewModel("湖南省"));
        mProvinceList.add(new ProvinceViewModel("广东省"));
        mProvinceList.add(new ProvinceViewModel("海南省"));
        mProvinceList.add(new ProvinceViewModel("四川省"));
        mProvinceList.add(new ProvinceViewModel("贵州省"));
        mProvinceList.add(new ProvinceViewModel("云南省"));
        mProvinceList.add(new ProvinceViewModel("陕西省"));
        mProvinceList.add(new ProvinceViewModel("甘肃省"));
        mProvinceList.add(new ProvinceViewModel("青海省"));
        mProvinceList.add(new ProvinceViewModel("台湾省"));
        mProvinceList.add(new ProvinceViewModel("内蒙古"));
        mProvinceList.add(new ProvinceViewModel("广西省"));
        mProvinceList.add(new ProvinceViewModel("西藏"));
        mProvinceList.add(new ProvinceViewModel("宁夏"));
        mProvinceList.add(new ProvinceViewModel("新疆"));
        mProvinceList.add(new ProvinceViewModel("香港"));
        mProvinceList.add(new ProvinceViewModel("澳门"));
        return mProvinceList;
    }


}