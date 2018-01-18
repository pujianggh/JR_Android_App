package com.android.kotlinapp.action.activity

import android.content.Intent
import android.os.Bundle
import com.android.kotlinapp.action.R
import com.android.kotlinapp.action.activity.test.Test1Activity
import com.android.kotlinapp.action.activity.test.Test2Activity
import com.android.kotlinapp.action.activity.test.TestActivity
import com.android.kotlinapp.action.base.BaseActivity
import com.android.kotlinapp.action.config.StrRes
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 主界面
 *
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
class MainActivity : BaseActivity() {

    override fun isSupportSwipeBack(): Boolean {
        return false
    }

    override fun initView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            val intent = Intent(this, Test1Activity::class.java)
            intent.putExtra(StrRes.action, "1")
            startActivityForResult(intent, 1)
        }
        button2.setOnClickListener {
            val intent = Intent(this, Test2Activity::class.java)
            intent.putExtra(StrRes.action, "2")
            startActivityForResult(intent, 1)
        }
        button3.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            intent.putExtra(StrRes.action, "0")
            startActivityForResult(intent, 1)
        }
    }
}
