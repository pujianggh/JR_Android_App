package com.android.kotlinapp.action.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.app.APPApplication;
import com.android.kotlinapp.action.utils.ToastUtil;
import com.libcommon.action.base.CommonBaseSwipeBackActivity;

import cn.bingoogolapple.titlebar.BGATitleBar;

/**
 * Activity基类：
 *
 * @author pujiang
 * @date 2018-1-18 10:02
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class BaseActivity extends CommonBaseSwipeBackActivity {
    protected APPApplication mApp;
    protected BGATitleBar mTitleBar;
    private LinearLayout mTitleBarLayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = APPApplication.getInstance();

        initView(savedInstanceState);
    }

    /**
     * 设置Title
     *
     * @param title
     * @param isUse
     */
    protected void setTitleBarLayout(CharSequence title, boolean isUse) {
        initTitleBarLayout(title, null, null, isUse);
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

    /**
     * 初始化-设置Title
     *
     * @param title
     * @param left
     * @param right
     * @param isUse
     */
    private void initTitleBarLayout(CharSequence title, CharSequence left, CharSequence right, boolean isUse) {
        mTitleBarLayer = (LinearLayout) findViewById(R.id.layout_titleBar);
        mTitleBar = (BGATitleBar) findViewById(R.id.titleBar);
        if (null == mTitleBarLayer || null == mTitleBar) return;
        if (!isUse) mTitleBarLayer.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(title)) {
            mTitleBar.setTitleText(title);
        }
        if (!TextUtils.isEmpty(left)) {
            mTitleBar.setLeftText(left);
        }
        if (!TextUtils.isEmpty(right)) {
            mTitleBar.setRightText(right);
        }
        mTitleBar.setDelegate(new BGATitleBar.Delegate() {
            @Override
            public void onClickLeftCtv() {
                finish();
            }

            @Override
            public void onClickTitleCtv() {

            }

            @Override
            public void onClickRightCtv() {

            }

            @Override
            public void onClickRightSecondaryCtv() {

            }
        });
    }
}
