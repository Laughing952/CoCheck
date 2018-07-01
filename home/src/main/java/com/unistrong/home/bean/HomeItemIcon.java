package com.unistrong.home.bean;

/**
 * 此类为：首页登记，查询，编辑，注销，人像对比，协查申请的图标实体类
 * 作者：Laughing on 2018/4/9 12:52
 * 邮箱：719240226@qq.com
 */

public class HomeItemIcon {
    private int iconId;             //图片序号
    private String iconName;        //图片下的文字
    private int iconResourceId;     //图片在mipmap下的id

    public HomeItemIcon(int iconId, String iconName, int iconResourceId) {
        this.iconId = iconId;
        this.iconName = iconName;
        this.iconResourceId = iconResourceId;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }
}
