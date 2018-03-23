package com.android.kotlinapp.action.activity.test;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.base.BaseActivity;
import com.fengniao.okhttputils.action.response.DownloadResponseHandler;
import com.libcommon.action.config.AppConfig;
import com.libcommon.action.utils.APPToolsUtil;
import com.libcommon.action.utils.FileUtil;
import com.libcommon.action.utils.UpdateInstallUtil;

import java.io.File;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class Test7Activity extends BaseActivity {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private String mApkUrl = "https://siji-test.oss-cn-shanghai.aliyuncs.com/test-apk/JRTZ_v1.1_xiaomi_20180323.apk";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test7);
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
                requestPermissionInfo(11, new String[]{Manifest.permission.CALL_PHONE});
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissionInfo(12, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE});
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateInstallUtil.deleteOldApk(AppConfig.FILE_APK_PATH + "/" + AppConfig.FILE_APK_NAME);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        setTitle();
    }

    @Override
    public void permissionSuccess(int requestCode) {
        if (requestCode == 11) {
            APPToolsUtil.callPhone(Test7Activity.this, "15000878804");
        } else if (requestCode == 12) {
            FileUtil.makeRootDirectory(AppConfig.FILE_APK_PATH);//创建文件目录

            mAPPApplication.getOkHttpCall().download().url(mApkUrl)
                    .filePath(AppConfig.FILE_APK_PATH + "/" + AppConfig.FILE_APK_NAME)
                    .tag(this).enqueue(new DownloadResponseHandler() {
                @Override
                public void onFinish(File downloadFile) {
                    if (downloadFile != null) {
                        UpdateInstallUtil.installApk(mAPPApplication, downloadFile);
                    }
                }

                @Override
                public void onProgress(long currentBytes, long totalBytes) {
                }

                @Override
                public void onFailure(String error_msg) {
                }
            });
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        if (requestCode == 11) {
            showToast("拨打电话权限获取失败！");
        } else if (requestCode == 12) {
            showToast("反问存储设备权限失败！");
        }
    }

    private void setTitle() {
        setTitleBarLayout("功能测试", true);
        mTitleBar.setLeftDrawable(R.drawable.selector_title_back);
    }
}
