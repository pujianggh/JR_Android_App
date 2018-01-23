package com.android.kotlinapp.action.activity.test;

import android.os.Bundle;
import android.widget.TextView;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.base.BaseActivity;
import com.android.kotlinapp.action.utils.ThreadUtil;
import com.libcommon.action.utils.LogAPPUtil;

import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGAStickinessRefreshViewHolder;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class Test1Activity extends BaseActivity {
    private TextView textView;
    private BGARefreshLayout mRefreshLayout;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.textMsg);
        setTitle();
        mRefreshLayout = (BGARefreshLayout) findViewById(R.id.refreshLayout);

        //style1();
        //style2();
        style3();
//        style4();
    }

    private void setTitle() {
        setTitleBarLayout("测试刷新", true);
        mTitleBar.setLeftDrawable(R.drawable.selector_title_back);
    }

    private void style4() {
        BGAMeiTuanRefreshViewHolder meiTuanRefreshViewHolder = new BGAMeiTuanRefreshViewHolder(mAPPApplication, true);
        meiTuanRefreshViewHolder.setPullDownImageResource(R.drawable.bga_refresh_mt_pull_down);
        meiTuanRefreshViewHolder.setChangeToReleaseRefreshAnimResId(R.drawable.bga_refresh_mt_change_to_release_refresh);
        meiTuanRefreshViewHolder.setRefreshingAnimResId(R.drawable.bga_refresh_mt_refreshing);
        mRefreshLayout.setRefreshViewHolder(meiTuanRefreshViewHolder);

        mRefreshLayout.setRefreshScaleDelegate(new BGARefreshLayout.BGARefreshScaleDelegate() {
            @Override
            public void onRefreshScaleChanged(float scale, int moveYDistance) {
                LogAPPUtil.i("setRefreshScaleDelegate----->scale:" + scale + " moveYDistance:" + moveYDistance);
            }
        });
        mRefreshLayout.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                showToast("加载最新");
                ThreadUtil.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.endRefreshing();
                    }
                }, 2000);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return false;
            }
        });
    }

    private void style2() {
        BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(mAPPApplication, true);
        moocStyleRefreshViewHolder.setOriginalImage(R.drawable.bga_refresh_moooc);
        moocStyleRefreshViewHolder.setUltimateColor(R.color.imoocstyle);
        mRefreshLayout.setRefreshViewHolder(moocStyleRefreshViewHolder);

        mRefreshLayout.setRefreshScaleDelegate(new BGARefreshLayout.BGARefreshScaleDelegate() {
            @Override
            public void onRefreshScaleChanged(float scale, int moveYDistance) {
                LogAPPUtil.i("setRefreshScaleDelegate----->scale:" + scale + " moveYDistance:" + moveYDistance);
            }
        });
        mRefreshLayout.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                showToast("加载最新");
                ThreadUtil.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.endRefreshing();
                    }
                }, 2000);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return false;
            }
        });
    }

    private void style3() {
        BGAStickinessRefreshViewHolder stickinessRefreshViewHolder = new BGAStickinessRefreshViewHolder(mAPPApplication, true);
        stickinessRefreshViewHolder.setStickinessColor(R.color.imoocstyle);
        stickinessRefreshViewHolder.setRotateImage(R.drawable.bga_refresh_stickiness);
        mRefreshLayout.setRefreshViewHolder(stickinessRefreshViewHolder);

        mRefreshLayout.setRefreshScaleDelegate(new BGARefreshLayout.BGARefreshScaleDelegate() {
            @Override
            public void onRefreshScaleChanged(float scale, int moveYDistance) {
                LogAPPUtil.i("setRefreshScaleDelegate----->scale:" + scale + " moveYDistance:" + moveYDistance);
            }
        });
        mRefreshLayout.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                showToast("加载最新");
                showLoadingDialog();
                ThreadUtil.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        dismissLoadingDialog();
                        mRefreshLayout.endRefreshing();
                    }
                }, 2000);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return false;
            }
        });
    }

    private void style1() {
        mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        mRefreshLayout.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                showToast("加载最新");
                ThreadUtil.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.endRefreshing();
                    }
                }, 2000);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return false;
            }
        });
    }


}
