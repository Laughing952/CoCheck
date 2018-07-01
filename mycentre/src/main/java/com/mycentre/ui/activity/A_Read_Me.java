package com.mycentre.ui.activity;

import android.os.Bundle;

import com.commondata.ui.activity.TitleActivity;
import com.mycentre.R;
import com.mycentre.databinding.AReadMeBinding;

/**用户使用说明：使用App简介
 * 作者：Laughing on 2018/4/25 09:50
 * 邮箱：719240226@qq.com
 */

public class A_Read_Me extends TitleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText("使用说明");//标题
        AReadMeBinding binding = setView(R.layout.a_read_me);
    }

}
