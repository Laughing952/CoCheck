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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.commondata.bean.FlowPeopleAddInfoReq;
import com.commondata.takephoto.activity.MyPhotoActivity;
import com.commondata.util.PickerViewUtil;
import com.commondata.util.RequestTransformUtil;
import com.commondata.util.TransformUtil;
import com.commondata.viewmodel.TempStayAddressViewModel;
import com.commondata.viewmodel.TempStayReasonViewModel;
import com.commondata.viewmodel.TempStayTimeViewModel;
import com.commondata.viewmodel.TempWorkViewModel;
import com.unistrong.business.R;
import com.unistrong.business.bean.FlowPeopleAddReq;
import com.unistrong.business.databinding.AFlowPeopleAddBinding;
import com.unistrong.business.ui.mvpview.IFlowPeopleAddView;
import com.unistrong.business.ui.presenter.FlowPeopleAddPresenter;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ToastUtil;

import org.w3c.dom.Text;

import java.util.List;

/**
 * 流动人口登记
 * 作者：Laughing on 2018/4/11 14:13
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Add extends BaseTitleActivity implements IFlowPeopleAddView {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Add.class));
    }

    private Context mContext = this;
    private AFlowPeopleAddBinding binding;
    private FlowPeopleAddPresenter presenter;
    private FlowPeopleAddReq flowPeopleAddReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        binding = setView(R.layout.a_flow_people_add);
        flowPeopleAddReq = new FlowPeopleAddReq();
        HttpManager manager = new HttpManager(this, this);
        presenter = new FlowPeopleAddPresenter(manager, this);
        initTitle();
        initData(getIntent());
        initListener();
    }

    private void initData(Intent intent) {

        FlowPeopleAddInfoReq infoReq = (FlowPeopleAddInfoReq) intent.getExtras().get("infoReq");
        if (flowPeopleAddReq != null) {
//            flowPeopleAddReq.setIdNum(isNull(infoReq.getIdNum()));
//            flowPeopleAddReq.setName(isNull(infoReq.getName()));
//            flowPeopleAddReq.setSex(isNull(infoReq.getSex()));
//            flowPeopleAddReq.setBirthday(isNull(infoReq.getBirthday()));
//            flowPeopleAddReq.setPersonAttr(isNull(infoReq.getPersonAttr()));
//            flowPeopleAddReq.setRegionalism(isNull(infoReq.getRegionalism()));
//            flowPeopleAddReq.setNation(isNull(infoReq.getNation()));
//            flowPeopleAddReq.setEduLevel(isNull(infoReq.getEduLevel()));

//            String sex = TransformUtil.sexTransformString(Integer.parseInt(isNull(infoReq.getSex())));
            String sex="男";
            binding.tvFlowPeopleEditId.setText(isNull(infoReq.getIdNum()));
            binding.tvFlowPeopleEditName.setText(isNull(infoReq.getName()));
            binding.tvFlowPeopleEditSex.setText(sex);
        }


        String idCardNum="654223198704280917";
        flowPeopleAddReq.setIdNum(idCardNum);
    }

    private void initListener() {
        binding.ivHead.setOnClickListener(v ->
                startActivityForResult(new Intent(mContext, MyPhotoActivity.class), 0x04)

        );
        binding.tvFlowPeopleEditSave.setOnClickListener(v ->
                getInputDataAndUpload()
        );
        binding.tvFlowPeopleEditRegisterDate.setOnClickListener(  v ->
                showDateDialog("登记日期", binding.tvFlowPeopleEditRegisterDate)
        );
        binding.tvFlowPeopleEditIncomeDate.setOnClickListener(v ->
                showDateDialog("流入日期", binding.tvFlowPeopleEditIncomeDate)
        );
        binding.tvFlowPeopleEditHowLong.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择拟（居）住时间", new PickerViewUtil.SelectResultListener<TempStayTimeViewModel>() {
            @Override
            public void result(TempStayTimeViewModel model) {
                binding.tvFlowPeopleEditHowLong.setText(model.getDays());
                flowPeopleAddReq.setPlanLiveTime(model.getDaysReq());
            }
        }, RequestTransformUtil.initTempStayTimeData()));

        binding.tvFlowPeopleEditWhyComeHere.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择暂时居住事由", new PickerViewUtil.SelectResultListener<TempStayReasonViewModel>() {
            @Override
            public void result(TempStayReasonViewModel model) {
                binding.tvFlowPeopleEditWhyComeHere.setText(model.getStayReason());
                flowPeopleAddReq.setTempLiveReason(model.getStayReasonReq());
            }
        }, RequestTransformUtil.initTempStayReasonData()));

        binding.tvFlowPeopleEditTempHome.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择暂时居住处所", new PickerViewUtil.SelectResultListener<TempStayAddressViewModel>() {
            @Override
            public void result(TempStayAddressViewModel model) {
                binding.tvFlowPeopleEditTempHome.setText(model.getAddress());
                flowPeopleAddReq.setTempLivePlace(model.getAddressReq());
            }
        }, RequestTransformUtil.initTempStayAddressData()));

        binding.tvFlowPeopleEditWork.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择职业", new PickerViewUtil.SelectResultListener<TempWorkViewModel>() {
            @Override
            public void result(TempWorkViewModel model) {
                binding.tvFlowPeopleEditWork.setText(model.getWork());
                flowPeopleAddReq.setWork(model.getWorkReq());
            }
        }, RequestTransformUtil.initTempWorkData()));

    }

    private void getInputDataAndUpload() {
        flowPeopleAddReq.setFlowInTime(
                binding.tvFlowPeopleEditIncomeDate.getText().toString().trim());//流入日期
        flowPeopleAddReq.setRegisterMobile(
                binding.tvFlowPeopleEditPhoneNumber.getText().toString().trim());//登记人联系方式
//        flowPeopleAddReq.setTempLiveArea(
//                binding.tvFlowPeopleEditTempHomeProvince.getText().toString().trim());//暂（居）住省市县区
//        flowPeopleAddReq.setTempLiveAddress(
//                binding.tvFlowPeopleEditTempHomeCityDetail.getText().toString().trim());//暂（居）住详细地址
        flowPeopleAddReq.setTempLiveArea("110101");//暂（居）住省市县区
        flowPeopleAddReq.setTempLiveAddress("锦业一路68号");//暂（居）住详细地址
        presenter.uploadAddPersonDetailsData(flowPeopleAddReq);
    }

    private void showDateDialog(String date, TextView view) {
        PickerViewUtil.showSelectDatePickerViewBefore(mContext, date, dateStr -> view.setText(dateStr));
    }

    private String isNull(String data) {
        String rData;
        if (data != null) {
            rData = data;
        } else {
            rData = "";
        }
        return rData;
    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("登记");//标题
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
                    String path = data.getStringExtra("image");
                    Uri uri = data.getData();
                    LogUtil.e("TAG", "laughing---123------------------->   " + uri.toString());
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
        binding.ivHead.setImageBitmap(toRoundBitmap(bitmap));
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

    @Override
    public void showResult() {
        ToastUtil.showToast(this, "登记成功");
    }
}
