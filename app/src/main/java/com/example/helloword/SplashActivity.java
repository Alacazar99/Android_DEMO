package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    Handler mHandler = new Handler();
    //private boolean isFirst = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp =  getPreferences(MODE_PRIVATE);
                boolean isFirst = sp.getBoolean("isFirst",true);

                Intent intent = new Intent();
                if(isFirst){
                    sp.edit().putBoolean("isFirst",false).commit();
                    // 第一次安装应用App，进入引导界面；
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                }else{
                    // 否则进入首页；
                    intent.setClass(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                 // Activity的切换动画；
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        },3000);
    }
}
