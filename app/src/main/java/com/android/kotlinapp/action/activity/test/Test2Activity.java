package com.android.kotlinapp.action.activity.test;

import android.os.Bundle;
import android.widget.TextView;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.base.BaseActivity;
import com.android.kotlinapp.action.config.StrRes;
import com.libcommon.action.utils.LogAPPUtil;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */

public class Test2Activity extends BaseActivity {
    TextView textView;

    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.textMsg);
        String action = getIntent().getExtras().getString("" + StrRes.INSTANCE.getAction());
        LogAPPUtil.i(mTag, "----->" + StrRes.INSTANCE.getAction() + " " + action);
        textView.setText("测试数据Test2Activity   "+action);
    }
}
