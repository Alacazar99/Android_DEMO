package com.example.helloword.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloword.GridViewActivity;
import com.example.helloword.R;

public class GridRecyclerViewActivity extends AppCompatActivity {


    private androidx.recyclerview.widget.RecyclerView mGridRecycler;
    private androidx.recyclerview.widget.RecyclerView mGridRecycler2;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.Adapter mAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mLayoutManager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        initData();
        initView();

    }
    private void initData(){
        mLayoutManager = new GridLayoutManager(this,1);
        mLayoutManager2 = new GridLayoutManager(this, 2);
        mAdapter = new GridOneRecyclerViewAdapter(GridRecyclerViewActivity.this);
        mAdapter2 = new GridTwoRecyclerViewAdapter(GridRecyclerViewActivity.this);
    }

    private void initView(){
        mGridRecycler = findViewById(R.id.rv_grid1);
        mGridRecycler2 = findViewById(R.id.rv_grid2);
        // 设置布局管理器;
        mGridRecycler.setLayoutManager(mLayoutManager);
        mGridRecycler2.setLayoutManager(mLayoutManager2);
        // 设置adapater;
        mGridRecycler.setAdapter((RecyclerView.Adapter) mAdapter);
        mGridRecycler2.setAdapter((RecyclerView.Adapter) mAdapter2);

    }

}
