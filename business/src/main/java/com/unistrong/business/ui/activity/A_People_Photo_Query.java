package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.commondata.takephoto.activity.MyPhotoActivity;
import com.commondata.util.PickerViewUtil;
import com.commondata.util.RequestTransformUtil;
import com.commondata.utils.DateUtils;
import com.commondata.viewmodel.AgeViewModel;
import com.commondata.viewmodel.MyCenterSexViewModel;
import com.unistrong.business.R;
import com.unistrong.business.databinding.APeoplePhotoQueryBinding;
import com.unistrong.business.ui.presenter.PeoplePhotoQueryPersenter;
import com.unistrong.business.utile.LoadImageUtile;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.PreferencesManager;
import com.waterbase.utile.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 人像比对页面
 * <p>
 * 作者：Laughing on 2018/4/11 17:58
 * 邮箱：719240226@qq.com
 */

public class A_People_Photo_Query extends BaseTitleActivity {
    private Context mContext = this;

    private TextView mTvquery;
    private RadioGroup mRgbookorder;
    private RadioButton mRb2;//新疆常驻人口照片库
    private RadioButton mRb1;//新疆二代证人口照片库
    private TextView mTv;
    private TextView mEtpeoplephotoqueryageend;
    private TextView mEtpeoplephotoqueryagestart;
    private TextView mEtpeoplephotoquerysex;
    private TextView tvusername;
    private ImageView mHeadImg;
    private Uri mUri;
    private PreferencesManager mPreferencesManager;
    private PeoplePhotoQueryPersenter persenter;
    private String path;
    private List<MyCenterSexViewModel> mSexList;
    private List<AgeViewModel> mAgeList;
    private Map<String, RequestBody> map = new HashMap<>();
    private APeoplePhotoQueryBinding binding;
    private boolean is2ndGeneration;
    private boolean isPermanentResidence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        binding = setView(R.layout.a_people_photo_query);
        initTitle();
        initView();
        initListener();
        HttpManager manager = new HttpManager(this, this);
        persenter = new PeoplePhotoQueryPersenter(manager,this);
//        setTitleBackgroundColor(R.color.base_title_bg);//标题栏背景色
//        setStatusBarBackgroundColor(R.color.base_title_bg);//状态栏背景色
    }


    public Map<String, RequestBody> generateData() {
        String dbType = "";
        if (is2ndGeneration && !isPermanentResidence){
            dbType = "1";
        }else if (isPermanentResidence && !is2ndGeneration){
            dbType = "6";
        }else if (is2ndGeneration && isPermanentResidence){
            dbType="1,6";
        }
        map.put("dbType", LoadImageUtile.convertToRequestBody(dbType));//比对库类型,（格式:1 新疆二代证人员照片库 6 新疆常住人口照片库,支持多选,传入1,6即可）
        return map;
    }
    public MultipartBody.Part generateImgData() {
        return LoadImageUtile.fileToMultipartBodyParts(new File(path));//对比照片
    }

    private void initListener() {

        binding.iv2ndGenerationButton.setOnClickListener(v -> {
            if (binding.iv2ndGenerationButton.isSelected()){
                binding.iv2ndGenerationButton.setSelected(false);
            }else{
                binding.iv2ndGenerationButton.setSelected(true);
            }
        });
        binding.ivPermanentResidenceButton.setOnClickListener(v -> {
            if (binding.ivPermanentResidenceButton.isSelected()){
                binding.ivPermanentResidenceButton.setSelected(false);
            }else{
                binding.ivPermanentResidenceButton.setSelected(true);
            }
        });
        mHeadImg.setOnClickListener(v -> startActivityForResult(new Intent(mContext, MyPhotoActivity.class), 0x04));

        mEtpeoplephotoquerysex.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择性别", new PickerViewUtil.SelectResultListener<MyCenterSexViewModel>() {
            @Override
            public void result(MyCenterSexViewModel model) {
                mEtpeoplephotoquerysex.setText(model.getSex());
                map.put("sex",LoadImageUtile.convertToRequestBody(model.getSexReq()));//性别
            }
        }, RequestTransformUtil.initSexData()));

        mEtpeoplephotoqueryagestart.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择年龄起", new PickerViewUtil.SelectResultListener<AgeViewModel>() {
            @Override
            public void result(AgeViewModel model) {
                mEtpeoplephotoqueryagestart.setText(model.getAge());
                map.put("ageStart", LoadImageUtile.convertToRequestBody(model.getAge()));//年龄起

            }
        }, RequestTransformUtil.initAgeData()));

        mEtpeoplephotoqueryageend.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择年龄止", new PickerViewUtil.SelectResultListener<AgeViewModel>() {
            @Override
            public void result(AgeViewModel model) {
                mEtpeoplephotoqueryageend.setText(model.getAge());
                map.put("ageEnd", LoadImageUtile.convertToRequestBody(model.getAge()));//年龄止
            }
        }, RequestTransformUtil.initAgeData()));

        mTvquery.setOnClickListener(v -> {

//            if (mUri != null && TextUtils.isEmpty(mEtpeoplephotoquerysex.getText().toString().trim())) {
            if (mUri != null) {
                is2ndGeneration = binding.iv2ndGenerationButton.isSelected();
                isPermanentResidence = binding.ivPermanentResidenceButton.isSelected();
                if (is2ndGeneration || isPermanentResidence) {
                    persenter.uploadImage(generateData(),generateImgData());
                } else {

                    Toast.makeText(mContext, "请选择比对库", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(mContext, "请添加比对照片", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initView() {
        mTvquery = (TextView) findViewById(R.id.tv_query);//立即比对按钮
        mTv = (TextView) findViewById(R.id.tv_re_input);
        mEtpeoplephotoqueryageend = (TextView) findViewById(R.id.et_people_photo_query_age_end);
        mEtpeoplephotoqueryagestart = (TextView) findViewById(R.id.et_people_photo_query_age_start);
        mEtpeoplephotoquerysex = (TextView) findViewById(R.id.et_people_photo_query_sex);
        tvusername = (TextView) findViewById(R.id.tv_user_name);
        mHeadImg = (ImageView) findViewById(R.id.iv_head_img);
        binding.iv2ndGenerationButton.setSelected(true);//默认选中新疆二代人口照片库进行数据查询
    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("人像查询");//标题
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }

    /**
     * 拍完照片后返回的数据
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0x04:
                if (resultCode == MyPhotoActivity.FINSH_RESULT && data != null) {
                    path = data.getStringExtra("image");
                    mUri = data.getData();
                    LogUtil.e("TAG", "laughing---uri------------------->   " + mUri.toString());
                    showUserHeadPhoto(path);
                }
                break;
        }

    }

    /**
     * 用来展示用户头像图片（从本地缓存中加载）
     *
     * @param path 图片上一次在本地存的位置
     */
    private void showUserHeadPhoto(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        mHeadImg.setImageBitmap(toRoundBitmap(bitmap));
    }

    /**
     * 将bitmap 图片剪裁为圆形（配合commondata中的takephoto包使用）
     *
     * @param bitmap
     * @return
     */
    public Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }
        Bitmap output = Bitmap.createBitmap(width,
                height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }


}
