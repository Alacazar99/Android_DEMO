package com.example.helloword.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloword.R;

import static com.example.helloword.R.layout.*;

public class HorRecyclerViewActivity extends AppCompatActivity {

    private androidx.recyclerview.widget.RecyclerView myRecyclerHor;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_hor_recycler_view);
        initData();
        initView();

    }

    private void initData(){
        // 初始化数据；
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mAdapter = new HorRecyclerAdapter(HorRecyclerViewActivity.this);
    }

    private void initView(){
        myRecyclerHor = findViewById(R.id.rv_Hor);
        // 设置布局管理器；
        myRecyclerHor.setLayoutManager(mLayoutManager);
        // 设置adapater;
        myRecyclerHor.setAdapter(mAdapter);

    }
}
