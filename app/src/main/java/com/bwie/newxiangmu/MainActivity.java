package com.bwie.newxiangmu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bwie.newxiangmu.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView mWelcomeIv;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getSP();
    }

    private void getSP() {
        sp = getSharedPreferences("QQ.db", MODE_PRIVATE);
        edit = sp.edit();
        boolean flag = sp.getBoolean("flag", false);
        if (flag){
            Intent intent=new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }else {
            initData();
        }
    }

    private void initData() {
        AlphaAnimation alpha=new AlphaAnimation(0.2f,1f);
        alpha.setDuration(3000);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                edit.putBoolean("flag",true);
                edit.commit();
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mWelcomeIv.setAnimation(alpha);
    }

    private void initView() {
        mWelcomeIv = (ImageView) findViewById(R.id.iv_welcome);
    }
}
