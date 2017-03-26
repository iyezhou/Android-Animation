package me.yezhou.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by yezhou on 2017/3/25.
 */

public class BetweenAnimationActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_between_animation);

        button = (Button) this.findViewById(R.id.button);

    }

    public void startAnimation(View view) {
        Toast.makeText(getApplicationContext(), "点我干啥？", Toast.LENGTH_SHORT).show();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
		//animation.start();
        button.startAnimation(animation);
    }
}
