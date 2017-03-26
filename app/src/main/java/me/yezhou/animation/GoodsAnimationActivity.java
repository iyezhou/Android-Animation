package me.yezhou.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by yezhou on 2017/3/25.
 */

public class GoodsAnimationActivity extends AppCompatActivity {

    private View firstView;
    private View secondView;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_animation);
        firstView = findViewById(R.id.first_view);
        secondView = findViewById(R.id.second_view);
        button = (Button)findViewById(R.id.button);
    }

    public void startFirstAnimation(View v) {
        /**
         * 1）firstView动画：1.翻转动画；2.透明度动画；3.缩放动画
         */
        //1.翻转
        ObjectAnimator firstRotationAnim = ObjectAnimator.ofFloat(firstView, "rotationX", 0f, 25f);
        firstRotationAnim.setDuration(300);
        //firstRotationAnim.start();
        //2.透明度
        ObjectAnimator firstAlphaAnim = ObjectAnimator.ofFloat(firstView, "alpha", 1f, 0.5f);
        firstAlphaAnim.setDuration(200);
        //3.缩放动画
        ObjectAnimator firstScaleXAnim = ObjectAnimator.ofFloat(firstView, "scaleX", 1f, 0.8f);
        firstScaleXAnim.setDuration(300);
        ObjectAnimator firstScaleYAnim = ObjectAnimator.ofFloat(firstView, "scaleY", 1f, 0.8f);
        firstScaleYAnim.setDuration(300);
        //改正向旋转设置监听，执行完毕后再执行反向旋转
        //firstRotationAnim.addUpdateListener(listener)
        ObjectAnimator firstResumeRotationAnim = ObjectAnimator.ofFloat(firstView, "rotationX", 25f, 0f);
        firstResumeRotationAnim.setDuration(200);
        firstResumeRotationAnim.setStartDelay(200); //延迟执行
        //由于缩放造成了离顶部有一段距离，需要平移上去
        ObjectAnimator firstTranslationAnim = ObjectAnimator.ofFloat(firstView, "translationY", 0f, -0.1f*firstView.getHeight());
        firstTranslationAnim.setDuration(200);
        //第二个View执行平移动画，往上平移
        ObjectAnimator secondeTranslationAnim = ObjectAnimator.ofFloat(secondView, "translationY", secondView.getHeight(), 0f);
        secondeTranslationAnim.setDuration(200);
        secondeTranslationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                secondView.setVisibility(View.VISIBLE);
                button.setClickable(false);
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.playTogether(firstRotationAnim, firstAlphaAnim, firstScaleXAnim, firstScaleYAnim, firstResumeRotationAnim, firstTranslationAnim, secondeTranslationAnim);
        set.start();
    }

    public void startSecondAnimation(View v) {
        /**
         * 2）first_View动画：1.翻转动画；2.透明度动画；3.缩放动画
         */
        //1.翻转
        ObjectAnimator firstRotationAnim = ObjectAnimator.ofFloat(firstView, "rotationX", 0f, 25f);
        firstRotationAnim.setDuration(300);
        //firstRotationAnim.start();
        //2.透明度
        ObjectAnimator firstAlphaAnim = ObjectAnimator.ofFloat(firstView, "alpha", 0.5f, 1f);
        firstAlphaAnim.setDuration(200);
        //3.缩放动画
        ObjectAnimator firstScaleXAnim = ObjectAnimator.ofFloat(firstView, "scaleX", 0.8f, 1f);
        firstScaleXAnim.setDuration(300);
        ObjectAnimator firstScaleYAnim = ObjectAnimator.ofFloat(firstView, "scaleY", 0.8f, 1f);
        firstScaleYAnim.setDuration(300);
        //改正向旋转设置监听，执行完毕后再执行反向旋转
        //firstRotationAnim.addUpdateListener(listener)
        ObjectAnimator firstResumeRotationAnim = ObjectAnimator.ofFloat(firstView, "rotationX", 25f, 0f);
        firstResumeRotationAnim.setDuration(200);
        firstResumeRotationAnim.setStartDelay(200); //延迟执行
        //由于缩放造成了离顶部有一段距离，需要平移上去
        ObjectAnimator firstTranslationAnim = ObjectAnimator.ofFloat(firstView, "translationY", -0.1f*firstView.getHeight(), 0f);
        firstTranslationAnim.setDuration(200);
        //第二个View执行平移动画，往上平移
        ObjectAnimator secondeTranslationAnim = ObjectAnimator.ofFloat(secondView, "translationY", 0f, secondView.getHeight());
        secondeTranslationAnim.setDuration(300);
        secondeTranslationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                secondView.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button.setClickable(true);
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.playTogether(firstRotationAnim, firstAlphaAnim, firstScaleXAnim, firstScaleYAnim, firstResumeRotationAnim, firstTranslationAnim, secondeTranslationAnim);
        set.start();
    }
}
