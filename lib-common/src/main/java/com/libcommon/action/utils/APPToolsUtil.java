package com.libcommon.action.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/**
 * 主要调取手机内部数据
 * 工具类
 *
 * @author pujiang
 * @date 2017-9-4 14:40
 * @mail 515210530@qq.com
 * @Description:
 */
public class APPToolsUtil {
    /**
     * 获取IP
     *
     * @return
     */
    public static String getHostIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            LogAPPUtil.e("getHostIp->" + e.getStackTrace());
        }
        return "";
    }

    /**
     * 获取设备ID
     *
     * @param context
     * @return
     */
    @RequiresPermission(android.Manifest.permission.READ_PHONE_STATE)
    public static String getDeviceId(Context context) {
        try {
            String result = "";
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager == null) {
                return "";
            }
            result = telephonyManager.getDeviceId();
            if (TextUtils.isEmpty(result)) {
                return "";
            } else {
                return result;
            }
        } catch (Exception e) {
            LogAPPUtil.e("getDeviceId->" + e.getStackTrace());
            return "";
        }
    }

    /**
     * 返回当前程序code
     *
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context) {
        int versionName = 1;
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionCode;
        } catch (Exception e) {
            LogAPPUtil.e("VersionInfo->" + e.getStackTrace());
        }
        return versionName;
    }

    /**
     * 返回当前程序版本
     *
     * @param context
     * @return
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            LogAPPUtil.e("VersionInfo->" + e.getStackTrace());
        }
        return versionName;
    }

    /**
     * 获取包名
     *
     * @param context
     * @return
     */
    public static String getAppPackageName(Context context) {
        try {
            int pid = android.os.Process.myPid();//当前应用pid
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);//任务管理类
            List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo info : infos) {
                if (info.pid == pid)//得到当前应用
                    return info.processName;//返回包名
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "";
    }
}
