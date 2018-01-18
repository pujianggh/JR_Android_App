package com.android.kotlinapp.action.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.android.kotlinapp.action.R
import com.android.kotlinapp.action.app.APPApplication
import com.android.kotlinapp.action.base.BaseActivity
import com.android.kotlinapp.action.config.AppConfig
import com.libcommon.action.utils.APPToolsUtil
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * 启动界面
 *
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
class SplashActivity : BaseActivity() {

    override fun isSupportSwipeBack(): Boolean {
        return false
    }

    override fun initView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
        tv_version.setText("v" + APPToolsUtil.getAppVersionName(APPApplication.getInstance()))
        setStatusBarColor(resources.getColor(R.color.colorPrimaryDark))
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, AppConfig.SPLASH_TIME)
    }
}
