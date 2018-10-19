package com.linger.flybird;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;

import com.linger.flybird.R;

public class MainActivity extends AppCompatActivity {

    private int screenWidth;//屏幕的宽度
    private ImageView bird;//大雁
    private AnimationDrawable birdDrawable;//控制逐帧动画
    private AnimatorSet birdAnimatorSet;//属性动画
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindowWidth();//获取屏幕宽度
        bird= (ImageView) findViewById(R.id.bird);
        bird.setTranslationX(-screenWidth);//设置控件初始化位置，在屏幕外面
        birdDrawable= (AnimationDrawable) bird.getDrawable();
//属性动画
        birdAnimatorSet=new AnimatorSet();
        ObjectAnimator birdObjextAnimatorR=ObjectAnimator.ofFloat(bird,"translationX",screenWidth);
        birdObjextAnimatorR.setDuration(5000);
        birdObjextAnimatorR.setRepeatMode(ValueAnimator.RESTART);
        birdObjextAnimatorR.setRepeatCount(ValueAnimator.INFINITE);
        birdAnimatorSet.play(birdObjextAnimatorR);
        birdObjextAnimatorR.start();
        birdDrawable.start();

    }

    private void getWindowWidth() {
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth=dm.widthPixels;
    }


}
