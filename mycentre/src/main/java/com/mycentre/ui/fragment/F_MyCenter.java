package com.mycentre.ui.fragment;

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
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.commondata.takephoto.activity.MyPhotoActivity;
import com.commondata.util.PickerViewUtil;
import com.commondata.viewmodel.MyCenterSexViewModel;
import com.mycentre.R;
import com.mycentre.ui.activity.A_MyCenter_Setting;
import com.waterbase.ui.BaseFragment;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.PreferencesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的fragment页面
 * 作者：Laughing on 2018/4/3 17:22
 * 邮箱：719240226@qq.com
 */

public class F_MyCenter extends BaseFragment {
    private Context mContext;
    private static F_MyCenter instance;
    private ImageView mCircleImageview;
    private PreferencesManager mPreferencesManager;
    private ImageView mSmettingPhoto;
    private TextView mSex;
    private List<MyCenterSexViewModel> mSexList;
    private EditText mName;
    private EditText mPhone;
    private EditText mWorkUnit;


    @Override
    protected int getLayoutId() {
        return R.layout.f_mycenter;
    }

    public synchronized static Fragment newInstance() {
        if (instance == null) {
            synchronized (F_MyCenter.class) {
                if (instance == null)
                    instance = new F_MyCenter();
            }
        }
        return instance;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        initViewInFragment();//初始化fragment中的View
        initDataInFragment();
        initListenerInFragment();//初始化fragment中的listener
        showCacheUserPhoto();
    }

    private void initDataInFragment() {
        mPreferencesManager = PreferencesManager.getInstance(F_MyCenter.this.getActivity().getApplicationContext(), "photo");
        mContext = this.getActivity().getApplicationContext();
        mSexList = new ArrayList<MyCenterSexViewModel>();
        mSexList.add(new MyCenterSexViewModel("男", "1"));
        mSexList.add(new MyCenterSexViewModel("女", "2"));

    }

    /**
     * 初始化fragment中的View
     */
    private void initListenerInFragment() {
        mCircleImageview.setOnClickListener(v -> startActivityForResult(new Intent(mContext, MyPhotoActivity.class), 0x04));
        mSmettingPhoto.setOnClickListener(v -> startActivity(new Intent(mContext, A_MyCenter_Setting.class)));
        mSex.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(getActivity(), "选择性别", new PickerViewUtil.SelectResultListener<MyCenterSexViewModel>() {
            @Override
            public void result(MyCenterSexViewModel model) {
                mSex.setText(model.getSex());
            }
        }, mSexList));
    }

    /**
     * 初始化fragment中的listener
     */
    private void initViewInFragment() {
        mCircleImageview = (ImageView) view.findViewById(R.id.iv_head_img);
        mSmettingPhoto = (ImageView) view.findViewById(R.id.iv_setting);
        mWorkUnit = (EditText) view.findViewById(R.id.edt_personal_info_edit_work_unit);
        mPhone = (EditText) view.findViewById(R.id.edt_personal_info_edit_phone);
        mSex = (TextView) view.findViewById(R.id.edt_personal_info_edit_sex);
        mName = (EditText) view.findViewById(R.id.edt_personal_info_edit_user_name);
    }

    /**
     * 打开个人中心，加载本地缓存的头像
     */
    private void showCacheUserPhoto() {

        String app_user_head_url = mPreferencesManager.get("app_user_head_url", "");

        if (app_user_head_url != "" && app_user_head_url != null) {
            showUserHeadPhoto(app_user_head_url);
        }
        mName.setText(mPreferencesManager.get("MyCenterName", ""));
        mSex.setText(mPreferencesManager.get("MyCenterSex", ""));
        mPhone.setText(mPreferencesManager.get("MyCenterPhone", ""));
        mWorkUnit.setText(mPreferencesManager.get("MyCenterWorkUnit", ""));
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
                    String path = data.getStringExtra("image");
                    Uri uri = data.getData();
                    LogUtil.e("TAG", "laughing---123------------------->   " + uri.toString());
                    showUserHeadPhoto(path);
                }
                break;
        }

    }


    /**
     * 对用户个人中心的数据进行保存
     */
    @Override
    public void onStop() {
        super.onStop();
        savePersonInfo();
    }


    private void savePersonInfo() {
        mPreferencesManager.put("MyCenterName", mName.getText().toString().trim());
        mPreferencesManager.put("MyCenterSex", mSex.getText().toString().trim());
        mPreferencesManager.put("MyCenterPhone", mPhone.getText().toString().trim());
        mPreferencesManager.put("MyCenterWorkUnit", mWorkUnit.getText().toString().trim());
    }

    /**
     * 用来展示用户头像图片（从本地缓存中加载）
     *
     * @param path 图片上一次在本地存的位置
     */
    private void showUserHeadPhoto(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        if (bitmap != null) {
            mPreferencesManager.put("app_user_head_url", path);
            LogUtil.e("cuihao", "path---------->  " + path);
            mCircleImageview.setImageBitmap(toRoundBitmap(bitmap));
        }
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
