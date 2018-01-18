package com.android.kotlinapp.action.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.kotlinapp.action.app.APPApplication;
import com.android.kotlinapp.action.utils.ToastUtil;
import com.libcommon.action.base.BaseSwipeBackActivity;

/**
 * 基类：
 *
 * @author pujiang
 * @date 2018-1-18 10:02
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class BaseActivity extends BaseSwipeBackActivity {
    protected APPApplication mApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = APPApplication.getInstance();

        initView(savedInstanceState);
    }

    protected void showToast(String text) {
        ToastUtil.show(text);
    }

    protected void showToast(int text) {
        ToastUtil.show(text);
    }

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);
}
