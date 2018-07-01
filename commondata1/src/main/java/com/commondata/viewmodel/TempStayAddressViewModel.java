package com.commondata.viewmodel;

import com.waterbase.widget.pickerview.model.IPickerViewData;

/**
 * Created by edz on 2018/4/23.
 */

public class TempStayAddressViewModel implements IPickerViewData {
    //暂居住处所
    public String address;
    public String addressReq;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressReq(String addressReq) {
        this.addressReq = addressReq;
    }

    public String getAddress() {

        return address;
    }

    public String getAddressReq() {
        return addressReq;
    }

    public TempStayAddressViewModel(String address, String addressReq) {
        this.address = address;
        this.addressReq = addressReq;

    }

    @Override
    public String getPickerViewText() {
        return address;
    }
}
