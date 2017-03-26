package me.yezhou.animation;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

/**
 * Created by yezhou on 2017/3/25.
 */

/**
 * Touch Feedback（触摸反馈）
 *          例子：水波纹效果（5.0+自带）
 * Reveal Effect（揭露效果）
 *          例子：Activity的揭露出现的效果
 * Activity Transition（Activity转场动画效果）
 *
 * Curved Motion（曲线运动）
 *          设计：View的平移旋转等效果结合Path、Interpolator插值器
 * View State Change（视图的状态改变）
 *          例子：按下一个控件会有Z轴的阴影加深效果
 */

public class MaterialDesignAnimationActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_animation);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //圆形水波纹揭露效果
                /*
				ViewAnimationUtils.createCircularReveal(
						view, //作用在哪个View上面
						centerX, centerY, //扩散的中心点
						startRadius, //开始扩散初始半径
						endRadius); //扩散结束半径
                */
                //从中心点开始揭露
                Animator animator = ViewAnimationUtils.createCircularReveal(button1, button1.getWidth()/2, button1.getHeight()/2, 0, button1.getHeight());
                animator.setDuration(1000);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.start();
                //Math.hypot(x, y)  //勾股定理
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从左上角开始揭露
                Animator animator = ViewAnimationUtils.createCircularReveal(button2, 0, 0, 0, (float) Math.hypot(button2.getWidth(), button2.getHeight()));
                animator.setDuration(1000);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.start();
            }
        });
    }
}
