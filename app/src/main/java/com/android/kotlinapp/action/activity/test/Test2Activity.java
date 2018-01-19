package com.android.kotlinapp.action.activity.test;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.base.BaseActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class Test2Activity extends BaseActivity implements BGABanner.Adapter<ImageView, String> {
    private ImageView imageView;
    private BGABanner mDefaultBanner;
    private BGABanner mCubeBanner;
    private BGABanner mAccordionBanner;
    private BGABanner mFlipBanner;
    private BGABanner mRotateBanner;
    private BGABanner mAlphaBanner;
    private BGABanner mZoomFadeBanner;
    private BGABanner mFadeBanner;
    private BGABanner mZoomCenterBanner;
    private BGABanner mZoomBanner;
    private BGABanner mStackBanner;
    private BGABanner mZoomStackBanner;
    private BGABanner mDepthBanner;
    private List<String> imags = new ArrayList<>();
    private List<String> tips = new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test3);

        setTitle();
        mDefaultBanner = (BGABanner) findViewById(R.id.banner_main_default);
        mCubeBanner = (BGABanner) findViewById(R.id.banner_main_cube);
        mAccordionBanner = (BGABanner) findViewById(R.id.banner_main_accordion);
        mFlipBanner = (BGABanner) findViewById(R.id.banner_main_flip);
        mRotateBanner = (BGABanner) findViewById(R.id.banner_main_rotate);
        mAlphaBanner = (BGABanner) findViewById(R.id.banner_main_alpha);
        mZoomFadeBanner = (BGABanner) findViewById(R.id.banner_main_zoomFade);
        mFadeBanner = (BGABanner) findViewById(R.id.banner_main_fade);
        mZoomCenterBanner = (BGABanner) findViewById(R.id.banner_main_zoomCenter);
        mZoomBanner = (BGABanner) findViewById(R.id.banner_main_zoom);
        mStackBanner = (BGABanner) findViewById(R.id.banner_main_stack);
        mZoomStackBanner = (BGABanner) findViewById(R.id.banner_main_zoomStack);
        mDepthBanner = (BGABanner) findViewById(R.id.banner_main_depth);
        initImageDatas();
        loadData();
    }

    private void setTitle() {
        setTitleBarLayout("测试Banner", true);
        mTitleBar.setLeftDrawable(R.drawable.selector_title_back);
        mTitleBar.setLeftText("返回");
    }

    private void loadData() {
        mDefaultBanner.setData(imags, tips);
        mDefaultBanner.setAdapter(this);
        mDefaultBanner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                showToast("点击了第" + (position + 1) + "页");
            }
        });

        mCubeBanner.setData(imags, tips);
        mCubeBanner.setAdapter(this);
        mCubeBanner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                showToast("点击了第" + (position + 1) + "页");
            }
        });

        mAccordionBanner.setData(imags, tips);
        mAccordionBanner.setAdapter(this);

        mFlipBanner.setData(imags, tips);
        mFlipBanner.setAdapter(this);

        mRotateBanner.setData(imags, tips);
        mRotateBanner.setAdapter(this);

        mAlphaBanner.setData(imags, tips);
        mAlphaBanner.setAdapter(this);

        mZoomFadeBanner.setData(imags, tips);
        mZoomFadeBanner.setAdapter(this);

        mFadeBanner.setData(imags, tips);
        mFadeBanner.setAdapter(this);

        mZoomCenterBanner.setData(imags, tips);
        mZoomCenterBanner.setAdapter(this);

        mZoomBanner.setData(imags, tips);
        mZoomBanner.setAdapter(this);

        mStackBanner.setData(imags, tips);
        mStackBanner.setAdapter(this);

        mZoomStackBanner.setData(imags, tips);
        mZoomStackBanner.setAdapter(this);

        mDepthBanner.setData(imags, tips);
        mDepthBanner.setAdapter(this);
    }

    private void initImageDatas() {
        imageView = (ImageView) findViewById(R.id.imageView);
        imags.clear();
        imags.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/12.png");
        imags.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/13.png");
        imags.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/14.png");
        imags.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/15.png");
        imags.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/5.png");
        tips.clear();
        tips.add("1");
        tips.add("2");
        tips.add("3");
        tips.add("4");
        tips.add("5");
        Glide.with(this)
                .load(imags.get(0))
                .placeholder(R.drawable.holder)
                .error(R.drawable.holder)
                .dontAnimate()
                .thumbnail(0.1f)
                .into(imageView);
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
        Glide.with(itemView.getContext())
                .load(model)
                .placeholder(R.drawable.holder)
                .error(R.drawable.holder)
                .dontAnimate()
                .centerCrop()
                .into(itemView);
    }
}
