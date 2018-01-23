package com.android.kotlinapp.action.activity.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.base.BaseActivity;

import cn.bingoogolapple.alert.BGAAlertAction;
import cn.bingoogolapple.alert.BGAAlertController;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class Test5Activity extends BaseActivity {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test5);
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
                showAlertController1(BGAAlertController.AlertControllerStyle.Alert, true, true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController1(BGAAlertController.AlertControllerStyle.Alert, false, false);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController1(BGAAlertController.AlertControllerStyle.ActionSheet, true, true);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController2(BGAAlertController.AlertControllerStyle.Alert, true, true);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController2(BGAAlertController.AlertControllerStyle.ActionSheet, false, true);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController3(BGAAlertController.AlertControllerStyle.Alert, true, true);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController3(BGAAlertController.AlertControllerStyle.ActionSheet, true, true);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController3(BGAAlertController.AlertControllerStyle.ActionSheet, true, false);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertController4(BGAAlertController.AlertControllerStyle.ActionSheet, true, true);
            }
        });
        setTitle();
    }

    private void showAlertController4(BGAAlertController.AlertControllerStyle preferredStyle, boolean cancelable, boolean canceledOnTouchOutside) {
        BGAAlertController alertController = new BGAAlertController(this, 0, R.string.app_name, preferredStyle);
        // 不管添加顺序怎样，AlertActionStyle.Cancel始终是在最底部的,AlertActionStyle.Default和AlertActionStyle.Destructive按添加的先后顺序显示
        alertController.addAction(new BGAAlertAction("4测试1", BGAAlertAction.AlertActionStyle.Destructive, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("1");
            }
        }));
        alertController.addAction(new BGAAlertAction("4测试2", BGAAlertAction.AlertActionStyle.Destructive, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("2");
            }
        }));
        alertController.addAction(new BGAAlertAction("4测试3", BGAAlertAction.AlertActionStyle.Destructive, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("3");
            }
        }));
        alertController.addAction(new BGAAlertAction("4测试4", BGAAlertAction.AlertActionStyle.Destructive, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("4");
            }
        }));
        alertController.setCancelable(cancelable);
        alertController.setCanceledOnTouchOutside(canceledOnTouchOutside);
        alertController.show();
    }


    private void showAlertController3(BGAAlertController.AlertControllerStyle preferredStyle, boolean cancelable, boolean canceledOnTouchOutside) {
        BGAAlertController alertController = new BGAAlertController(this, 0, R.string.app_name, preferredStyle);
        // 不管添加顺序怎样，AlertActionStyle.Cancel始终是在最底部的,AlertActionStyle.Default和AlertActionStyle.Destructive按添加的先后顺序显示
        alertController.addAction(new BGAAlertAction("取消", BGAAlertAction.AlertActionStyle.Cancel, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了取消");
            }
        }));
        alertController.addAction(new BGAAlertAction("确定", BGAAlertAction.AlertActionStyle.Destructive, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了确定");
            }
        }));
        alertController.setCancelable(cancelable);
        alertController.setCanceledOnTouchOutside(canceledOnTouchOutside);
        alertController.show();
    }


    private void showAlertController2(BGAAlertController.AlertControllerStyle preferredStyle, boolean cancelable, boolean canceledOnTouchOutside) {
        BGAAlertController alertController = new BGAAlertController(this, 0, 0, preferredStyle);
        alertController.addAction(new BGAAlertAction("其他1", BGAAlertAction.AlertActionStyle.Default, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了其他1");
            }
        }));
        // 不管添加顺序怎样，AlertActionStyle.Cancel始终是在最底部的,AlertActionStyle.Default和AlertActionStyle.Destructive按添加的先后顺序显示
        alertController.addAction(new BGAAlertAction("取消", BGAAlertAction.AlertActionStyle.Cancel, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了取消");
            }
        }));
        alertController.addAction(new BGAAlertAction("其他2", BGAAlertAction.AlertActionStyle.Default, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了其他2");
            }
        }));
        alertController.addAction(new BGAAlertAction("确定", BGAAlertAction.AlertActionStyle.Destructive, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了确定");
            }
        }));
        alertController.setCancelable(cancelable);
        alertController.setCanceledOnTouchOutside(canceledOnTouchOutside);
        alertController.show();
    }


    private void showAlertController1(BGAAlertController.AlertControllerStyle preferredStyle, boolean cancelable, boolean canceledOnTouchOutside) {
        BGAAlertController alertController = new BGAAlertController(this, "我是标题", "我是内容内容内容内容内容内容内容内容", preferredStyle);
        // 不管添加顺序怎样，AlertActionStyle.Cancel始终是在最底部的,AlertActionStyle.Default和AlertActionStyle.Destructive按添加的先后顺序显示
        alertController.addAction(new BGAAlertAction("取消", BGAAlertAction.AlertActionStyle.Cancel, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了取消");
            }
        }));
        alertController.addAction(new BGAAlertAction("确定", BGAAlertAction.AlertActionStyle.Destructive, new BGAAlertAction.Delegate() {
            @Override
            public void onClick() {
                showToast("点击了确定");
            }
        }));
        alertController.setCancelable(cancelable);
        alertController.setCanceledOnTouchOutside(canceledOnTouchOutside);
        alertController.show();
    }

    private void setTitle() {
        setTitleBarLayout("Alert测试", true);
        mTitleBar.setLeftDrawable(R.drawable.selector_title_back);
        mTitleBar.setLeftText("返回");
    }
}
