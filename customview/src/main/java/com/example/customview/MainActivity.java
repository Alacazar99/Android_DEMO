package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("设置Title");
//        toolbar.setSubtitle("设置二级标题");
//        toolbar.setLogo(R.mipmap.ic_launcher);
//
//        //设置导航图标要在setSupportActionBar方法之后
//        //  setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
    }

}
