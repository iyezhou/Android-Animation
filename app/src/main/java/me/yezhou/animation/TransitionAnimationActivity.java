package me.yezhou.animation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by yezhou on 2017/3/26.
 */

/**
 * ActivityOptions类，只支持API21以上的版本
 * 谷歌设计了一个兼容类：ActivityOptionsCompat（v4包中）。但是此类在低版本上面并没有转场动画效果，只是解决了我们手动去判断版本的问题而已。
 * 转场动画可以分为两大类：共享元素转换和普通的转换
 *
 * 使用转换动画前提：需要给两个Activity都设置如下，让其允许使用转场动画
 * //方法一：getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
 * //方法二：修改主题<item name="android:windowContentTransitions">true</item>
 */

/**
 * 1）共享元素转换
 * 概念：可以把两个Activity当中的相同的元素关联起来做连贯的变换动画。
 * 前提：（1）给两个Activity当中的共享元素view都设置同一个名字: android:transitionName
 * <ImageView
 *     android:id="@+id/picture"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"
 *     android:scaleType="centerCrop"
 *     android:transitionName="beautiful"
 *     android:src="@drawable/zhanghanyun"
 *     />
 *
 * 按返回键的时候自动实现了返回的共享元素转场动画，原因看源码：
 * public void onBackPressed() {
 *     finishAfterTransition();
 * }
 * public void finishAfterTransition() {
 *     if (!mActivityTransitionState.startExitBackTransition(this)) {
 *         finish();
 *     }
 * }
 *
 * 2）普通的转换动画
 * （只有API 21+才有下面自带效果）
 * 三种系统带的：滑动效果Slide、展开效果Explode、渐变显示隐藏效果Fade
 */

public class TransitionAnimationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置允许使用转场动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_transition_animation);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.picture);
        button = (Button) findViewById(R.id.button);
    }

    public void jump(View view) {
        /**
         * overridePendingTransition
         */
        /*
        startActivity(new Intent(this, OtherActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        */

        /**
         * ActivityOptions: 共享元素转换
         */
        /*
        //共享单个元素
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
				.makeSceneTransitionAnimation(
						activity, //当前的Activity
						sharedElement, //共享元素，即共享哪一个View
						sharedElementName); //共享元素的名称 android:transitionName="beautiful"
		*/
        /*
		ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "beautiful");
		Intent intent = new Intent(this, OtherActivity.class);
		startActivity(intent, optionsCompat.toBundle());
		*/

        /**
         * 处理多个共享元素
         */
        //new Pair<>(first, second)
        //共享多个元素
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, Pair.create((View) imageView, "beautiful"), Pair.create((View) button, "button"));
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void slide(View view) {
        Slide slide = new Slide();
		slide.setDuration(300);
		getWindow().setExitTransition(slide); //出去的动画
		getWindow().setEnterTransition(slide); //进来的动画

        //如果有共享元素，可以设置共享元素，那么它就会按照共享元素动画执行，其他的子View就会按照Slide动画执行
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void explode(View view) {
        Explode explode = new Explode();
		explode.setDuration(1000);
		getWindow().setExitTransition(explode); //出去的动画
		getWindow().setEnterTransition(explode); //进来的动画

        //如果有共享元素，可以设置共享元素，那么它就会按照共享元素动画执行，其他的子View就会按照Explode动画执行
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void fade(View view) {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setExitTransition(fade); //出去的动画
        getWindow().setEnterTransition(fade); //进来的动画

        //如果有共享元素，可以设置共享元素，那么它就会按照共享元素动画执行，其他的子View就会按照Fade动画执行
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }
}
