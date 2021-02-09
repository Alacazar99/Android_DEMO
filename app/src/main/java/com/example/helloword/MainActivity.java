package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTabHost;
import androidx.viewpager.widget.ViewPager;

import com.example.helloword.util.ToastUtil;


public class MainActivity extends FragmentActivity {


    private Intent intent;
    private FragmentTabHost tabHost;
    private Toolbar toolbar;
    private ViewPager viewPager;

    private Class[] fragments = new Class[]{
            MainFragment.class,
            AroundFragment.class,
            BlankFragment.class,
            MineFragment.class
    };
    // 图标资源；
    int[] ivTabs = new int[]{
            R.drawable.home_nomal,
            R.drawable.around_nomal,
            R.drawable.blank_nomal,
            R.drawable.my_nomal
    };
    // 轮播图广告 图片资源；
    private int[] imgResId = new int[]{
            R.drawable.ad1,
            R.drawable.ad2,
            R.drawable.ad3,
            R.drawable.ad4
    };
    // 自动滚动；
    private Handler mHandler = new Handler();
    // 点击态;
    private int[] imgSelector = new int[]{
        R.drawable.ic_home_selector,
        R.drawable.ic_around_selector,
        R.drawable.ic_blank_selector,
        R.drawable.ic_my_selector
    };

    private String[] tvTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 初始化ToolBar;
//        initToolBar();

        // 初始化tabHost;
        initTabHost();

        // 初始化广告条；
        autoScroll();

    }


    private void initTabHost(){

        tvTabs = new String[]{"首页","周边","发现","我的"};
        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
//        for (int i = 0; i < tvTabs.length;i++){
//            TabHost.TabSpec tabspec = tabHost.newTabSpec(i+"").setIndicator(tvTabs[i]);
//            tabHost.addTab(tabspec,fragmentList.get(i),null);
//        }
        // 加入fragments；
//        tabHost.addTab(tabHost.newTabSpec("").setIndicator("首页"),MainFragment.class,null);
//        tabHost.addTab(tabHost.newTabSpec("").setIndicator("..."),BlankFragment.class,null);
//        tabHost.addTab(tabHost.newTabSpec("").setIndicator("周边"),AroundFragment.class,null);
//        tabHost.addTab(tabHost.newTabSpec("").setIndicator("我的"),MineFragment.class,null);

        for (int i = 0; i < fragments.length;i++){
            View inflate = getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView tab_img = inflate.findViewById(R.id.tab_img);
            TextView tab_text = inflate.findViewById(R.id.tab_text);
            tab_img.setImageResource(imgSelector[i]);
            tab_text.setText(tvTabs[i]);
            tabHost.addTab(tabHost.newTabSpec(i+"").setIndicator(inflate),fragments[i],null);
        }
    }
    private void initToolBar(){
        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("首页");
        toolbar.setSubtitle("二级标题");


        // 多了这句，点击事件会消失；
//         setSupportActionBar(toolbar);
        // 导航图标
        toolbar.setLogo(R.mipmap.ic_launcher);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"king......",Toast.LENGTH_SHORT).show();
            }
        });
        // 配置菜单；

        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // int menuItemId = item.getItemId();
                switch (item.getItemId()) {
                    case R.id.action_search:
                        // Log.d("action_search");
                        ToastUtil.showMsg(MainActivity.this, "action_search");
                        break;
                    case R.id.action_settings1:
                        ToastUtil.showMsg(MainActivity.this,"action_settings1");
                        break;
                    case R.id.action_settings2:
                        ToastUtil.showMsg(MainActivity.this,"action_settings2");
                        break;
                    case R.id.action_settings3:
                        ToastUtil.showMsg(MainActivity.this,"action_settings3");
                        break;
                }
                return true;
            }
        });
    }
    private void autoScroll(){
        viewPager = findViewById(R.id.main_ViewPager);
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
