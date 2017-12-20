package com.bwie.newxiangmu.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.newxiangmu.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout mNameTil;
    private TextInputLayout mPwdTil;
    private Button mLoginBtn;
    private TextView mPwdTv;
    private TextView mZhuceTv;
    private RelativeLayout mLoginRl;

    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        getSP();
    }
    private void getSP() {
        sp = getSharedPreferences("QQ.db", MODE_PRIVATE);
        edit = sp.edit();
        boolean flag = sp.getBoolean("temp", false);
        if (flag){
            Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.enter,R.anim.exit);
            return;
        }else {
            initData();
        }
    }

    private void initData() {
        welcome();
        register();
        login();
        pwd();
    }

    private void login() {

    }

    private void pwd() {

    }

    private void register() {
        mZhuceTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                return;
            }
        });
    }

    private void welcome() {
        Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.login_anim);
        animation.setFillAfter(true);
        mLoginRl.startAnimation(animation);
    }

    private void initView() {
        mNameTil = (TextInputLayout) findViewById(R.id.til_name);
        mPwdTil = (TextInputLayout) findViewById(R.id.til_pwd);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mPwdTv = (TextView) findViewById(R.id.tv_pwd);
        mZhuceTv = (TextView) findViewById(R.id.tv_zhuce);
        mLoginRl = (RelativeLayout) findViewById(R.id.rl_login);
    }
}
