package com.example.helloword.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloword.R;
import com.example.helloword.WebView.WebViewActivity;
import com.example.helloword.util.ToastUtil;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button btnLinear,btnLor,btn_GridLayout,btn_StaggeredGrid,btn_WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        btnLinear = findViewById(R.id.btn_linear);
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(getApplicationContext(),"跳转到 列表布局");
                Intent intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btnLor = findViewById(R.id.btn_linear2);
        btnLor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(getApplicationContext(),"跳转到 水平布局");
                Intent intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btn_GridLayout = findViewById(R.id.btn_GridLayout);
        btn_GridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(getApplicationContext(),"跳转到 网格布局");
                Intent intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btn_StaggeredGrid = findViewById(R.id.btn_StaggeredGrid);
        btn_StaggeredGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(getApplicationContext(),"跳转到 瀑布流布局");
                Intent intent = new Intent(RecyclerViewActivity.this, StaggeredRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btn_WebView = findViewById(R.id.btn_WebView);
        btn_WebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(getApplicationContext(),"跳转到 WebView");
                Intent intent = new Intent(RecyclerViewActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
