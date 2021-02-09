package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

public class BannerActivity extends FragmentActivity {

    // 图片资源；
    private int[] imgResId = new int[]{R.drawable.king,R.drawable.gz,R.drawable.sz};
    // 自动滚动；
    private Handler mHandler = new Handler();

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        autoScroll();
    }

    private void autoScroll(){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 获取当前页面下标；
                int currentItem = viewPager.getCurrentItem();
                viewPager.setCurrentItem(currentItem+1);
                mHandler.postDelayed(this,3000);
            }
        },3000);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        // 返回视图
        @Override
        public Fragment getItem(int position) {
            // 取模；
            position %= imgResId.length;
            BannerFragment bannerFragment = new BannerFragment();
            bannerFragment.serImage(imgResId[position]);
            return bannerFragment;
        }

        @Override
        public int getCount() {
            // 返回长度；
            return Integer.MAX_VALUE;
        }
    }
}
