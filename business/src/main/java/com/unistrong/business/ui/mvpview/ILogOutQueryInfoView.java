package com.unistrong.business.ui.mvpview;

import java.util.List;

/**
 * 注销与编辑之前进行的单条查询
 * 作者：Laughing on 2018/4/21 10:57
 * 邮箱：719240226@qq.com
 */

public interface ILogOutQueryInfoView<T> {
    /**
     * 用身份证号查找到要编辑或注销的人
     *
     * @param data 流动人口集合
     */
    void getFlowListBean(List<T> data);

}
