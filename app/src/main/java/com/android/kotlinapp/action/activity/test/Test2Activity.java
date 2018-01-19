package com.android.kotlinapp.action.activity.test;

import android.os.Bundle;
import android.widget.ImageView;

import com.android.kotlinapp.action.R;
import com.android.kotlinapp.action.base.BaseActivity;
import com.bumptech.glide.Glide;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class Test2Activity extends BaseActivity {
    private ImageView imageView;
    private String imagURL = "http://imgsrc.baidu.com/imgad/pic/item/c2fdfc039245d688599ab081aec27d1ed21b247e.jpg";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test3);
        imageView = (ImageView) findViewById(R.id.imageView);

        Glide.with(this)
                .load(imagURL)
                .placeholder(R.drawable.holder)
                .error(R.drawable.holder)
                .dontAnimate()
                .thumbnail(0.1f)
                .into(imageView);
    }
}
