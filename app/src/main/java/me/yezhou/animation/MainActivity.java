package me.yezhou.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void betweenAnimation(View view) {
        Intent intent = new Intent(this, BetweenAnimationActivity.class);
        startActivity(intent);
    }

    public void frameAnimation(View view) {
        Intent intent = new Intent(this, FrameAnimationActivity.class);
        startActivity(intent);
    }

    public void attributeAnimation(View view) {
        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        startActivity(intent);
    }

    public void goodsAnimation(View view) {
        Intent intent = new Intent(this, GoodsAnimationActivity.class);
        startActivity(intent);
    }

    public void materialDesignAnimation(View view) {
        Intent intent = new Intent(this, MaterialDesignAnimationActivity.class);
        startActivity(intent);
    }

    public void transitionAnimation(View view) {
        Intent intent = new Intent(this, TransitionAnimationActivity.class);
        startActivity(intent);
    }
}
