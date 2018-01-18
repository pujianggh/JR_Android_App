package com.android.kotlinapp.action.utils;

import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

import com.android.kotlinapp.action.app.APPApplication;

/**
 * 自定义提示
 *
 * @author pujiang
 * @date 2017-9-4 19:50
 * @mail 515210530@qq.com
 * @Description:
 */
public class ToastUtil {

    /**
     * 提示处理
     *
     * @param text
     */
    public static void show(CharSequence text) {
        if (TextUtils.isEmpty(text)) return;
        if (text.length() < 10) {
            Toast.makeText(APPApplication.getInstance(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(APPApplication.getInstance(), text, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 提示处理
     *
     * @param resId
     */
    public static void show(@StringRes int resId) {
        show(APPApplication.getInstance().getString(resId));
    }

}