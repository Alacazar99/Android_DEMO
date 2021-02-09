package com.example.helloword.RecyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.helloword.R;
import com.example.helloword.util.ToastUtil;

public class StaggeredRecyclerViewActivity extends AppCompatActivity {


    private androidx.recyclerview.widget.RecyclerView myRecyclerStaggered;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_recycler_view);
        initData();
        initView();

    }

    private void initData(){
        // 初始化数据；
        mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new StaggeredRecyclerAdapter(StaggeredRecyclerViewActivity.this, new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                ToastUtil.showMsg(StaggeredRecyclerViewActivity.this,"click");
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    private void initView(){
        myRecyclerStaggered = findViewById(R.id.rv_staggered);
        // 设置布局管理器；
        myRecyclerStaggered.setLayoutManager(mLayoutManager);
        // 设置adapater;
        myRecyclerStaggered.setAdapter(mAdapter);
        // 设置内边距
        myRecyclerStaggered.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int pad = getResources().getDimensionPixelSize(R.dimen.dividerHightLague);
            outRect.set(pad,pad,pad,pad);
        }
    }
}
