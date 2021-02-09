package com.example.helloword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.helloword.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
//  获取图片资源；
    int[] imgRes = new int[]{
            R.drawable.guide1,
            R.drawable.guide2,
            R.drawable.guide3,
            R.drawable.guide4,
            R.drawable.guide5
    };
    private List mViewList = new ArrayList();
    private Button mbtnStart;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        viewPager = findViewById(R.id.vP);
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setOnPageChangeListener(new MyListener());
        mbtnStart = findViewById(R.id.btn_start);

        mbtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(getApplicationContext(),"过渡到首页");
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                // 点击按钮，页面跳转后，引导页面销毁；
                finish();
            }
        });

    }

    private void initData(){
        for (int i = 0;i < imgRes.length;i++){
            View inflate = getLayoutInflater().inflate(R.layout.guide_item,null);
            ImageView ivGuide = inflate.findViewById(R.id.iv_guide);
            ivGuide.setBackgroundResource(imgRes[i]);
            mViewList.add(inflate);
        }

    }

    /*
    *
    *引导界面ViewPager 适配器；
    * */
    class MyPagerAdapter extends PagerAdapter{

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = (View) mViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;   // 官方写法；
//            return false;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            // super.destroyItem(container, position, object);
            container.removeView((View) mViewList.get(position));
        }
    }

    class MyListener implements  ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //  滚动到第几张；
        @Override
        public void onPageSelected(int position) {
//            viewPager 滚动到最后一张；
            if (position == imgRes.length - 1){
                mbtnStart.setVisibility(View.VISIBLE);
                // 按钮设置动画；
                Animation animation = AnimationUtils.loadAnimation(GuideActivity.this,R.anim.anim_guide_btn_start);
                mbtnStart.startAnimation(animation);
            }else{
                mbtnStart.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
