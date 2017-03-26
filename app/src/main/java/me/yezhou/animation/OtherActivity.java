package me.yezhou.animation;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;

/**
 * Created by yezhou on 2017/3/26.
 */

public class OtherActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        Slide slide = new Slide();
		slide.setDuration(300);
		getWindow().setExitTransition(slide); //出去的动画
		getWindow().setEnterTransition(slide); //进来的动画
		*/

        /*
        Explode explode = new Explode();
		explode.setDuration(1000);
		getWindow().setExitTransition(explode); //出去的动画
		getWindow().setEnterTransition(explode); //进来的动画
		*/

        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setExitTransition(fade); //出去的动画
        getWindow().setEnterTransition(fade); //进来的动画
    }

    /**
     * 手动添加返回动画效果
     * @param view
     */
    public void back(View view){
        onBackPressed();
    }

    /*
    @Override
	public void onBackPressed() {
		super.onBackPressed();
	}
	*/

}
