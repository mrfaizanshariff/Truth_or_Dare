package com.aelinstudios.truthordare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private Random random=new Random();
    private int lastdirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);

    }
    public void spin(View view){
        int firstdirection = random.nextInt(3600)+360;
        float pivotX = imageView.getWidth()/2;
        float pivotY=imageView.getHeight()/2;
        Animation rotate = new RotateAnimation(lastdirection,firstdirection,pivotX,pivotY);
        rotate.setDuration(2000);

//        firstdirection=lastdirection;
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
                button.setBackground(getDrawable(R.drawable.disabled_button));// calling the disable_button xml
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
                button.setBackground(getDrawable(R.drawable.custom_button));// resetting the original button after the animation ends
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastdirection=firstdirection;
        imageView.startAnimation(rotate);

    }
}