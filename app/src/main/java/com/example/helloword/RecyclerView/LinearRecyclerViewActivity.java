package com.example.helloword.RecyclerView;

//import androidx.appcompat.app.AlertController;
//import androidx.appcompat.app.AlertController;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.helloword.R;

//import static androidx.appcompat.app.AlertController.*;


public class LinearRecyclerViewActivity extends AppCompatActivity {

    private androidx.recyclerview.widget.RecyclerView mRvMain;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        initData();
        initView();
}
    private void initData(){
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mAdapter = new LinearAdapter(LinearRecyclerViewActivity.this);
    }


    private void initView(){
        mRvMain = findViewById(R.id.rv_main2);
        // 设置布局管理器;
        mRvMain.setLayoutManager(mLayoutManager);
        // 设置adapater;
        mRvMain.setAdapter((RecyclerView.Adapter) mAdapter);
        //设置分隔线；
        mRvMain.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHight));
        }
    }
}
