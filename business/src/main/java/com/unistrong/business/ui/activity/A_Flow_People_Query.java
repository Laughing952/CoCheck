package com.unistrong.business.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.commondata.util.PickerViewUtil;
import com.commondata.util.RequestTransformUtil;
import com.commondata.viewmodel.EthnicViewModel;
import com.commondata.viewmodel.IsEffectiveViewModel;
import com.commondata.viewmodel.MyCenterSexViewModel;
import com.commondata.viewmodel.PersonAttributesViewModel;
import com.commondata.viewmodel.PersonStateViewModel;
import com.unistrong.business.R;
import com.unistrong.business.ui.presenter.FlowPeopleQueryPersenter;
import com.waterbase.http.HttpManager;
import com.waterbase.ui.BaseTitleActivity;
import com.waterbase.utile.StrUtil;
import com.waterbase.utile.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流动人口查询
 * 作者：Laughing on 2018/4/11 15:55
 * 邮箱：719240226@qq.com
 */

public class A_Flow_People_Query extends BaseTitleActivity implements View.OnClickListener {

    private Context mContext = this;
    private Button mTv;
    private Button mTvquery;
    private TextView mEtregisterdateend;
    private TextView mEtregisterdatestart;
    private TextView mEtiseffective;
    private TextView mEtstate;
    private TextView mEtattributes;
    private TextView mEtethnic;
    private TextView mEtsex;
    private EditText mEtname;
    private EditText mEtid;
    private FlowPeopleQueryPersenter persenter;
    private List<MyCenterSexViewModel> mSexList;
    private List<EthnicViewModel> mEthnicList;
    private List<IsEffectiveViewModel> mEffectiveList;
    private List<PersonStateViewModel> mPersonStateViewModelList;
    private List<PersonAttributesViewModel> mPersonAttributesList;
    private Map<String, Object> map = new HashMap<>();

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, A_Flow_People_Query.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//软键盘弹出后，让屏幕整体上移
        setView(R.layout.a_flow_people_query);
        HttpManager manager = new HttpManager(this, this);
        persenter = new FlowPeopleQueryPersenter(this, manager);
        persenter = new FlowPeopleQueryPersenter(this, manager);
        initTitle();
        initView();
        initListener();

    }


    private void initListener() {
        mEtregisterdatestart.setOnClickListener(v -> showDateDialog("登记日期起", mEtregisterdatestart));
        mEtregisterdateend.setOnClickListener(v -> showDateDialog("登记日期止", mEtregisterdateend));

        mEtsex.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择性别", new PickerViewUtil.SelectResultListener<MyCenterSexViewModel>() {
            @Override
            public void result(MyCenterSexViewModel model) {
                mEtsex.setText(model.getSex());
                map.put("sex", model.getSexReq());//性别
            }
        }, RequestTransformUtil.initSexData()));
        mEtethnic.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择民族", new PickerViewUtil.SelectResultListener<EthnicViewModel>() {
            @Override
            public void result(EthnicViewModel model) {
                mEtethnic.setText(model.getEthnic());
                map.put("nation", model.getEthnicReq());//民族
            }
        }, RequestTransformUtil.initEthnicData()));
        mEtiseffective.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "是否有效", new PickerViewUtil.SelectResultListener<IsEffectiveViewModel>() {
            @Override
            public void result(IsEffectiveViewModel model) {
                mEtiseffective.setText(model.geteffective());
                map.put("logoutTag", model.getEffectiveReq());//是否有效
            }
        }, RequestTransformUtil.initEffectiveData()));
        mEtstate.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext
                , "选择人员状态", new PickerViewUtil.SelectResultListener<PersonStateViewModel>() {
            @Override
            public void result(PersonStateViewModel model) {
                mEtstate.setText(model.getState());
//                map.put("state", model.getStateRes());//人员状态
            }
        }, RequestTransformUtil.initPersonStateData()));
        mEtattributes.setOnClickListener(v -> PickerViewUtil.showOptionsPickerView(mContext, "选择人员属性", new PickerViewUtil.SelectResultListener<PersonAttributesViewModel>() {
            @Override
            public void result(PersonAttributesViewModel model) {
                mEtattributes.setText(model.getAttributes());
//                map.put("attributes", model.getAttributesReq());//人员属性
            }
        }, RequestTransformUtil.initPersonAttributesData()));
        /**
         * 重置
         */
        mTv.setOnClickListener(v -> {
            mEtregisterdateend.setText("");
            mEtregisterdatestart.setText("");
            mEtiseffective.setText("");
            mEtstate.setText("");
            mEtattributes.setText("");
            mEtethnic.setText("");
            mEtsex.setText("");
            mEtname.setText("");
            mEtid.setText("");
        });
        //查询
        mTvquery.setOnClickListener((View v) -> {
            String id = mEtid.getText().toString().trim();
            String name = mEtname.getText().toString().trim();
            if (StrUtil.isEmpty(id) && StrUtil.isEmpty(name)) {
                ToastUtil.showToast(mContext, "请填写身份证号或姓名");
            } else {
                //1.如果身份证号不为空
                if (!StrUtil.isEmpty(id)) {
                    //1.身份证号无误，直接跳转页面
                    if (StrUtil.isIDCardNum(id)) {
                        persenter.uploadData(generateData());
                    } else {
                        ToastUtil.showToast(mContext, "身份证号有误");

                    }
                }
                //2.如果身份证号为空
                if (StrUtil.isEmpty(id)) {
                    if (!StrUtil.isEmpty(name)) {
                        persenter.uploadData(generateData());
                    }

                }

            }

        });


        /**
         * 点击手机软键盘enter键进行查询
         */
        mEtid.setOnKeyListener((v, keyCode, event) -> {
            switch (keyCode) {
                case KeyEvent.KEYCODE_ENTER:
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:
                            //1.效验身份证号
                            verificationID();
                            break;
                    }
                    break;
            }
            return false;
        });
        mEtname.setOnKeyListener((v, keyCode, event) -> {
            switch (keyCode) {
                case KeyEvent.KEYCODE_ENTER:
                    mEtname.setMaxLines(1);
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:
                            //1.效验身份证号
                            verificationID();
                            break;
                    }
                    break;
            }
            return false;
        });

    }

    //1.效验身份证号
    private void verificationID() {
        String id = mEtid.getText().toString().trim();
        String name = mEtname.getText().toString().trim();
        if (StrUtil.isEmpty(id) && StrUtil.isEmpty(name)) {

            ToastUtil.showToast(mContext, "请填写身份证号或姓名");
        } else {
            //1.如果身份证号不为空
            if (!StrUtil.isEmpty(id)) {
                //1.身份证号无误，直接跳转页面
                if (StrUtil.isIDCardNum(id)) {
                    persenter.uploadData(generateData());
                } else {
                    ToastUtil.showToast(mContext, "身份证号有误");

                }
            }
            //2.如果身份证号为空
            if (StrUtil.isEmpty(id)) {
                if (!StrUtil.isEmpty(name)) {
                    persenter.uploadData(generateData());
                }

            }
        }
    }

    private void showDateDialog(String date, TextView view) {
        PickerViewUtil.showSelectDatePickerViewBefore(mContext, date, dateStr -> view.setText(dateStr));
    }

    private void initView() {
        mTv = (Button) findViewById(R.id.tv_re_input);
        mTvquery = (Button) findViewById(R.id.tv_flow_people_query_query);
        mEtregisterdateend = (TextView) findViewById(R.id.et_register_date_end);
        mEtregisterdatestart = (TextView) findViewById(R.id.et_register_date_start);
        mEtiseffective = (TextView) findViewById(R.id.et_is_effective);
        mEtstate = (TextView) findViewById(R.id.et_state);
        mEtattributes = (TextView) findViewById(R.id.et_attributes);
        mEtethnic = (TextView) findViewById(R.id.et_ethnic);
        mEtsex = (TextView) findViewById(R.id.et_sex);
        mEtname = (EditText) findViewById(R.id.et_name);
        mEtid = (EditText) findViewById(R.id.et_id);
        mEtname.setMaxLines(1);
    }

    /**
     * 标题栏处理
     */
    private void initTitle() {
        setTitleText("查询");//标题
        setLeftTwoImageVisibity(false);//隐藏左二按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightOneImageVisibity(false);//隐藏右一按钮
        setRightTwoImageVisibity(false);//隐藏右二按钮
        setRightTextViewVisibity(false);//隐藏右侧TextView
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_query) {
            //上传数据后跳转到查询列表页面
            persenter.uploadData(generateData());
        }
    }

    public Map<String, Object> generateData() {
        map.put("idNum", mEtid.getText().toString().trim());//身份证号
        map.put("name", mEtname.getText().toString().trim());//姓名
        map.put("registerDateStart", mEtregisterdatestart.getText().toString().trim());//登记日期起 格式 yyMMdd (20180401)
        map.put("registerDateEnd", mEtregisterdateend.getText().toString().trim());//登记日期止 格式 yyMMdd (20180401)
        map.put("pageSize", "10");//
        map.put("currentPage", "1");
        return map;
    }

}
