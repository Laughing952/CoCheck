package com.unistrong.home.utils;

import android.content.Context;
import android.location.LocationManager;

/**
 * Created by Water on 2018/4/3.
 */

public class LocationUtils {

    /**
     * 判断GPS模块是否开启
     *
     * @param context
     * @return
     */
    public static boolean isOpenGPS(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return true;
        }
        return false;
    }

    /**
     * 获取ＧＰＳ当前状态
     * @param context
     * @return
     */
    public static boolean getGPSState(Context context){
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean on = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return on;
    }
}
