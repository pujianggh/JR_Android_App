package com.android.kotlinapp.action.activity.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.base.BaseActivity;

import cn.bingoogolapple.sweetaction.SweetAlertDialog;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class Test6Activity extends BaseActivity {
    private SweetAlertDialog mLoadingDialog;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test6);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadingDialog();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this)
                        .setTitleText("信息展示使用")
                        .show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this)
                        .setTitleText("标题展示")
                        .setContentText("信息展示使用")
                        .show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("标题展示")
                        .setContentText("信息展示使用")
                        .show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("标题展示")
                        .setContentText("信息展示使用")
                        .setConfirmText("确定")
                        .show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("标题展示")
                        .setContentText("OK")
                        .show();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("标题展示")
                        .setContentText("Image展示")
                        .setCustomImage(R.mipmap.ic_launcher)
                        .show();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("标题展示")
                        .setContentText("信息展示使用")
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(Test6Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("标题展示")
                        .setContentText("信息展示使用")
                        .setCancelText("取消")
                        .setConfirmText("确定")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog
                                        .setTitleText("Deleted!")
                                        .setContentText("Your imaginary file has been deleted!")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        })
                        .show();
            }
        });
        setTitle();
    }

    public void showLoadingDialog() {
        SweetAlertDialog mLoadingDialog = new SweetAlertDialog(Test6Activity.this, SweetAlertDialog.PROGRESS_TYPE);
        mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.setTitleText("数据加载中...");
        mLoadingDialog.show();
    }

    private void setTitle() {
        setTitleBarLayout("进度加载测试", true);
        mTitleBar.setLeftDrawable(R.drawable.selector_title_back);
        mTitleBar.setLeftText("返回");
    }
}
