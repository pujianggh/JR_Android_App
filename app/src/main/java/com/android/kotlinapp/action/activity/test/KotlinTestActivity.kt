package com.android.kotlinapp.action.activity.test

import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder
import cn.bingoogolapple.refreshlayout.BGARefreshLayout
import com.android.kotlinapp.action.R
import com.android.kotlinapp.action.base.BaseActivity
import kotlinx.android.synthetic.main.activity_kotlin_test.*

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
class KotlinTestActivity : BaseActivity() {

    override fun initView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_kotlin_test)
        refreshLayout.setDelegate(object : BGARefreshLayout.BGARefreshLayoutDelegate {
            override fun onBGARefreshLayoutBeginRefreshing(refreshLayout: BGARefreshLayout) {
                wv_webview_content.reload()
            }

            override fun onBGARefreshLayoutBeginLoadingMore(refreshLayout: BGARefreshLayout): Boolean {
                return false
            }
        })

        wv_webview_content.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                showLoadingDialog()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                dismissLoadingDialog()
                refreshLayout.endRefreshing()
            }
        }

        val moocStyleRefreshViewHolder = BGAMoocStyleRefreshViewHolder(mAPPApplication, false)
        moocStyleRefreshViewHolder.setOriginalImage(R.drawable.bga_refresh_moooc)
        moocStyleRefreshViewHolder.setUltimateColor(R.color.imoocstyle)
        refreshLayout.setRefreshViewHolder(moocStyleRefreshViewHolder)

        wv_webview_content.settings.javaScriptEnabled = true
        wv_webview_content.loadUrl("https://github.com/bingoogolapple")
    }
}
