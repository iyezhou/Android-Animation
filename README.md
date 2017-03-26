# Android-Animation
Android 动画总结

## 补间动画BetweenAnimation

- AnimationUtils.loadAnimation

## 逐帧动画FrameAnimation

- AnimationDrawable

## 属性动画PropertyAnimation

- ObjectAnimator
- ValueAnimator
- ObjectAnimator.ofPropertyValuesHolder(View, PropertyValuesHolder...)
- AnimatorSet.play(ObjectAnimator)
- AnimatorSet.playTogether(AnimatorSet...)
- AnimatorSet.playSequentially(AnimatorSet...)
- 插值器：AccelerateInterpolator、AccelerateDecelerateInterpolator、AnticipateInterpolator、OvershootInterpolator、CycleInterpolator、BounceInterpolator

## Material Design动画

- Touch Feedback(触摸反馈)(水波纹效果5.0+自带)
- Reveal Effect(揭露效果)

## 转场动画

- overridePendingTransition
- ActivityOptions、ActivityOptionsCompat
- 共享元素转换android:transitionName
- 普通转换动画(5.0+)：滑动效果Slide、展开效果Explode、渐变效果Fade

![image](https://github.com/iyezhou/Android-Animation/blob/master/Android-Animation.jpg)
