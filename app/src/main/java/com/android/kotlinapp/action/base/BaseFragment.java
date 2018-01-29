package com.android.kotlinapp.action.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kotlinapp.action.app.APPApplication;
import com.android.kotlinapp.action.utils.ToastUtil;
import com.libcommon.action.base.CommonBaseFragment;

/**
 * Fragment基类：
 *
 * @author pujiang
 * @date 2018-1-18 10:02
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class BaseFragment extends CommonBaseFragment {
    protected String mTag;//用于日志打印或者类名查看
    protected APPApplication mAPPApplication;
    protected View mContentView;
    protected BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mTag = this.getClass().getSimpleName();
        mAPPApplication = APPApplication.getInstance();
        mActivity = (BaseActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            initView(savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        return mContentView;
    }

    protected void setContentView(@LayoutRes int layoutResID) {
        mContentView = LayoutInflater.from(mActivity).inflate(layoutResID, null);
    }

    protected void showToast(String text) {
        ToastUtil.INSTANCE.show(text);
    }

    /**
     * 初始化View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 显示-进度对话框
     */
    protected void showLoadingDialog() {
        mActivity.showLoadingDialog();
    }

    /**
     * 隐藏对话框
     */
    protected void dismissLoadingDialog() {
        if (isVisible()) {
            mActivity.dismissLoadingDialog();
        }
    }
}
