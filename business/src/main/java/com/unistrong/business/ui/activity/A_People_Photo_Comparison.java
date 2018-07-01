package com.unistrong.business.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.commondata.ui.activity.TitleActivity;
import com.unistrong.business.R;
import com.unistrong.business.databinding.APeoplePhotoComparisonBinding;

/**
 * 人像比对（包含人像比对，数据比对两条）
 * <p>
 * 作者：Laughing on 2018/4/11 15:16
 * 邮箱：719240226@qq.com
 */

public class A_People_Photo_Comparison extends TitleActivity implements View.OnClickListener {

    private APeoplePhotoComparisonBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = setView(R.layout.a_people_photo_comparison);
        setTitleText("人像对比");
//        setContentView(R.layout.a_people_photo_comparison);
        RelativeLayout rlcomparisondata = (RelativeLayout) findViewById(R.id.rl_comparison_data);
        TextView comparisondata = (TextView) findViewById(R.id.comparison_data);
        ImageView ivcomparisondata = (ImageView) findViewById(R.id.iv_comparison_data);
        RelativeLayout rlpeoplephotocomparison = (RelativeLayout) findViewById(R.id.rl_people_photo_comparison);
        TextView peoplephotocomparison = (TextView) findViewById(R.id.people_photo_comparison);
        ImageView ivpeoplephotocomparison = (ImageView) findViewById(R.id.iv_people_photo_comparison);

        mBinding.setClick(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_people_photo_comparison) {
            startActivity(new Intent(this, A_People_Photo_Query.class));
        } else if (v.getId() == R.id.rl_comparison_data) {
            startActivity(new Intent(this, A_People_Photo_Comparison_Data.class));
        }
    }

}
