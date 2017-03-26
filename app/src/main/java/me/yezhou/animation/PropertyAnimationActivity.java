package me.yezhou.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by yezhou on 2017/3/25.
 */

public class PropertyAnimationActivity extends AppCompatActivity {

	private static final String TAG = "yezhou";

	private Toolbar toolbar;

	private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

		toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

        button = (Button) this.findViewById(R.id.button);
        imageView = (ImageView) this.findViewById(R.id.picture);
    }

    private int position = 0;

    public void startAnimation(View view) {
        /**
         * 属性动画
         */
        /*
		position += 100;
        view.setTranslationX(position);
        view.setAlpha((float) Math.random());
        */

        /**
         * ObjectAnimator
         * float... values: A set of values that the animation will animate between over time.
         */
        /*
		ObjectAnimator oa = ObjectAnimator.ofFloat(view, "translationX", 0f, 300f);
		oa.setDuration(500);
		oa.start();
		ObjectAnimator oa = ObjectAnimator.ofFloat(view, "translationY", 0f, 300f);
		oa.setDuration(500);
		oa.start();
		ObjectAnimator oa = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
		oa.setDuration(500);
		oa.start();
		*/

        /**
         * 多个动画同时执行
         */
        /*
        //方法1：设置动画监听，开始第一个动画同时开启其他动画
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "haha", 0f, 100f); //没有这个属性的时候，就是ValueAnimator
		animator.setDuration(300);
		//设置动画监听
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				//动画在执行的过程当中，不断地调用此方法
                //animation.getAnimatedFraction()//百分比
				//得到duration时间内 values当中的某一个中间值: 0f~100f
				float value = (float) animation.getAnimatedValue();
                imageView.setScaleX(0.5f+value/200); //0.5~1
                imageView.setScaleY(0.5f+value/200); //0.5~1
			}
		});
		animator.start();

        animator.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {

			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}
		});
		*/

        /*
        //方法2：使用ValueAnimator
		ValueAnimator animator = ValueAnimator.ofFloat(0f, 200f);
		animator.setDuration(200);
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				//动画在执行的过程当中，不断地调用此方法
                //animation.getAnimatedFraction()//百分比
                //得到duration时间内 values当中的某一个中间值: 0f~100f
				float value = (float) animation.getAnimatedValue();
				imageView.setScaleX(0.5f+value/200); //0.5~1
                imageView.setScaleY(0.5f+value/200); //0.5~1
			}
		});
		animator.start();
		*/

		/*
        //方法3：属性集合
        //float... values: 代表关键帧的值
		PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0.7f, 1f);
		PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.7f, 1f);
		PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.7f, 1f);
        //PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("translationX", 0f, 300f);

		ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, holder1, holder2, holder3);
		animator.setDuration(1000);
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float animatedValue = (float) animation.getAnimatedValue();
				float animatedFraction = animation.getAnimatedFraction();
				long playTime = animation.getCurrentPlayTime();
				Log.i(TAG, "animatedValue: " + animatedValue + ",  playTime: " + playTime);
			}
		});
		animator.start();
		*/

        /*
		//方法4：动画集合
		ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0.7f, 1f);
		ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0.7f, 1f);
		ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 0.7f, 1f);

		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.setDuration(500);
		//animatorSet.play(anim); //执行单个动画
		//animatorSet.playTogether(animator1, animator2, animator3); //同时执行
		animatorSet.playSequentially(animator1, animator2, animator3); //依次执行动画
 		animatorSet.start();
 		*/

		/**
         * 案例：实现抛物线效果
		 * x: 匀速
		 * y: 加速度  y=1/2*g*t*t
		 * 使用估值器最好实现。
		 */
		ValueAnimator valueAnimator = new ValueAnimator();
		valueAnimator.setDuration(5000);
        //valueAnimator.setFloatValues(values)
		valueAnimator.setObjectValues(new PointF(0, 0));
		//估值器---定义计算规则
		valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
			@Override
			public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
				//拿到每一个时间点的坐标
				//x=v*t (s秒)
				PointF pointF = new PointF();
				pointF.x = 100f * (fraction * 4);  //初始速度*(执行的百分比*4)
                //pointF.y = 0.5f * 9.8f * (fraction*4) * (fraction*4);
				pointF.y = 0.5f * 150f * (fraction*4) * (fraction*4);
				return pointF;
			}
		});

		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				//得到此时间点的坐标
				PointF pointF = (PointF) animation.getAnimatedValue();
				imageView.setX(pointF.x);
                imageView.setY(pointF.y);
			}
		});
		valueAnimator.start();

		/**
		 * 动画插值器
		 */
		/*
		ObjectAnimator oa = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 1100f);
		oa.setDuration(500);
		//设置加速插值器
		oa.setInterpolator(new AccelerateInterpolator(5));
		//设置加速减速插值器
		oa.setInterpolator(new AccelerateDecelerateInterpolator());
		oa.setInterpolator(new AnticipateInterpolator(8));
		oa.setInterpolator(new OvershootInterpolator());
		//设置正弦周期变化插值器
		oa.setInterpolator(new CycleInterpolator(4));
		//设置弹跳插值器
		oa.setInterpolator(new BounceInterpolator());
		oa.start();
		*/
    }
}
