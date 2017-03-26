package me.yezhou.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by yezhou on 2017/3/26.
 */

/**
 * 逐帧动画（Frame-by-frame Animations）从字面上理解就是一帧挨着一帧的播放图片
 */

public class FrameAnimationActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ImageView mIvLoading;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mIvLoading = (ImageView) this.findViewById(R.id.iv_loading);
        //mIvLoading.setBackgroundResource(R.drawable.loading_animation);
        //mAnimationDrawable = (AnimationDrawable) mIvLoading.getBackground();
        mIvLoading.setImageResource(R.drawable.loading_animation);
        mAnimationDrawable = (AnimationDrawable) mIvLoading.getDrawable();
    }

    public void loadAnimation(View view) {
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }else {
            mAnimationDrawable.start();
        }
    }
}
