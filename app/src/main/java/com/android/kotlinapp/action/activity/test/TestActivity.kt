package com.android.kotlinapp.action.activity.test

import android.os.Bundle
import com.android.kotlinapp.action.R
import com.android.kotlinapp.action.base.BaseActivity
import com.android.kotlinapp.action.config.StrRes
import com.libcommon.action.utils.LogAPPUtil
import kotlinx.android.synthetic.main.activity_test.*

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
class TestActivity : BaseActivity() {

    override fun initView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_test)
        val action = intent.extras!!.getString("" + StrRes.action)
        LogAPPUtil.i(mTag, "----->" + StrRes.action + " " + action)
        textMsg.text = "测试数据TestActivity  " + action
    }
}
