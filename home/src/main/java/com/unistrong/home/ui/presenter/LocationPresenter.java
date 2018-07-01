package com.unistrong.home.ui.presenter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.unistrong.home.ui.viewmodel.SetDeviceInfoView;
import com.waterbase.ui.BaseApplication;
import com.waterbase.ui.BaseFragment;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ToastUtil;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Water on 2018/4/3.
 */

public class LocationPresenter {

    private static final String TAG = "AddDeviceWifiPresenter";
    private BaseFragment mFragment;
    private SetDeviceInfoView infoView;
    private boolean mHasPermission;
    //两个危险权限需要动态申请
    private static final String[] NEEDED_PERMISSIONS = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
    };
    //权限请求码
    private static final int PERMISSION_REQUEST_CODE = 0;

    public LocationPresenter(BaseFragment mFragment, SetDeviceInfoView infoView) {
        this.mFragment = mFragment;
        this.infoView = infoView;
    }

    public void getLocationInfo() {
        mHasPermission = checkPermission();
        if (!mHasPermission) {  //未获取权限，申请权限
            requestPermission();
        } else {  //已经获取权限
            locationResult();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == PERMISSION_REQUEST_CODE) {
            boolean hasAllPermission = true;
            for (int i : grantResults) {
                if (i != PackageManager.PERMISSION_GRANTED) {
                    hasAllPermission = false;   //判断用户是否同意获取权限
                    break;
                }
            }
            //如果同意权限
            if (hasAllPermission) {
                mHasPermission = true;
                locationResult();
            } else {  //用户不同意权限
                mHasPermission = false;
                ToastUtil.showToast(mFragment.getContext(), "获取权限失败");
            }
        }

    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == activity.RESULT_OK && requestCode == OpenZxingUtils.QR_CODE) {
//            //http://192.168.0.251:8181/eapple/mobi/allorder/getDetailByNo?purchaseNo=882446315987009536
//            String result = data.getStringExtra("result");
//            String orderId = result.substring(result.indexOf("=") + 1, result.length());
//            LogUtil.d(TAG, "orderId:" + orderId);
//            // 自动连接识别到的wifi
//            boolean is = WifiSupport.addNetWork(WifiSupport.createWifiConfig("Note5"
//                    , "1234567890", WifiSupport.WifiCipherType.WIFICIPHER_WPA), activity);
//            if (is) {
//                // TODO: 2018/4/4 发送WiFi发密码
//                // 这样：WIFI;E6Yun;123456
//            }
//        }
//    }


    /**
     * 检查是否已经授予权限
     *
     * @return
     */
    private boolean checkPermission() {
        for (String permission : NEEDED_PERMISSIONS) {
            if (ActivityCompat.checkSelfPermission(mFragment.getContext(), permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 申请权限
     */
    private void requestPermission() {
        mFragment.requestPermissions(
                NEEDED_PERMISSIONS, PERMISSION_REQUEST_CODE);
//        ActivityCompat.requestPermissions(activity,
//                NEEDED_PERMISSIONS, PERMISSION_REQUEST_CODE);
    }

    @SuppressLint("MissingPermission")
    private void locationResult() {
        LocationManager locationManager = (LocationManager) mFragment.getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        new AsyncTask<Void,Void, Location>() {

            @Override
            protected Location doInBackground(Void... voids) {
                Location location = null;
                while (location == null) {
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }
                Log.d(TAG, "onCreate: ------------------");

                return location;
            }

            @Override
            protected void onPostExecute(Location location) {
                if (location != null) {
                    Log.d(TAG, "onCreate: location");
                    //不为空,显示地理位置经纬度
                    showLocation(location);
                }
            }
        }.execute();
//        new Thread(() -> {
//            Location location = null;
//            while (location == null) {
//                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            }
//            Log.d(TAG, "onCreate: ------------------");
//            if (location != null) {
//                Log.d(TAG, "onCreate: location");
//                //不为空,显示地理位置经纬度
//                showLocation(location);
//            }
//        }).start();
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

    }

    /**
     * 显示地理位置经度和纬度信息
     *
     * @param location
     */
    private void showLocation(final Location location) {
        Log.d(TAG, "定位成功------->" + "location------>经度为：" + location.getLatitude()
                + "\n纬度为" + location.getLongitude());
        Geocoder gc = new Geocoder(BaseApplication.getAppContext(), Locale.getDefault());
        if (gc.isPresent()) {
            LogUtil.d(TAG, "包含地理位置服务");
        } else {
            LogUtil.d(TAG, "不包含地理位置服务");
        }
        try {
            // 取得地址相关的一些信息\经度、纬度
            List<Address> addresses = gc.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            StringBuilder sb = new StringBuilder();
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                sb.append(address.getAdminArea());
                sb.append(address.getSubAdminArea());
                sb.append(address.getLocality());
                sb.append(address.getThoroughfare());
                infoView.locationResult(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Address[addressLines=[0:"陕西省西安市雁塔区长盛科技产业园(锦业一路南)"],feature=雁塔区长盛科技产业园(锦业一路南)
        // ,admin=陕西省,sub-admin=西安市,locality=雁塔区,thoroughfare=锦业一路,postalCode=null,countryCode=null,countryName=中国,hasLatitude=true,latitude=34.190006,hasLongitude=true,longitude=108.861547,phone=null,url=null,extras=null]
    }

    /**
     * LocationListern监听器
     * 参数：地理位置提供器、监听位置变化的时间间隔、位置变化的距离间隔、LocationListener监听器
     */

    LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle arg2) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {
            //如果位置发生变化,重新显示
            showLocation(location);

        }
    };

}
