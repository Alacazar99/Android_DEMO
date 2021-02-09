package com.example.helloword;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.helloword.util.ToastUtil;

public class MainTestActivity extends AppCompatActivity {

    private Button mBtnUi,mSharedPre,banner,mCategories;
    private Intent intent;
    private LinearLayout mAinmation;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);


        // 初始化按钮；
        initButton();
        // 动态设置
        initAinmation();
        // 初始化ToolBar;
        initToolBar();
    }

    private void initButton(){
        // 定位布局中的按钮;
        mBtnUi = findViewById(R.id.btn_ui);
        mSharedPre = findViewById(R.id.btn_SharedPre);
        banner = findViewById(R.id.btn_banner);
        mCategories = findViewById(R.id.btn_categories);
        OnClick onClick = new OnClick();
        mBtnUi.setOnClickListener(onClick);
        mSharedPre.setOnClickListener(onClick);
        banner.setOnClickListener(onClick);
        mCategories.setOnClickListener(onClick);
    }

    private void initToolBar(){
        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("首页");
        toolbar.setSubtitle("二级标题");
        // 导航图标
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        // 少了这句，点击事件会消失；
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainTestActivity.this,"king......",Toast.LENGTH_SHORT).show();
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
                        ToastUtil.showMsg(MainTestActivity.this, "action_search");
                        break;
                    case R.id.action_settings1:
                        ToastUtil.showMsg(MainTestActivity.this,"action_settings1");
                        break;
                    case R.id.action_settings2:
                        ToastUtil.showMsg(MainTestActivity.this,"action_settings2");
                        break;
                    case R.id.action_settings3:
                        ToastUtil.showMsg(MainTestActivity.this,"action_settings3");
                        break;
                }
                return true;
            }
        });
    }

    private void initAinmation(){
        // 属性动画设置；
        mAinmation = findViewById(R.id.llTestAnimation);
        mAinmation.animate().alpha(01).setDuration(5000).start();
        mAinmation.animate().translationYBy(100).setDuration(3000).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_ui:
                    // 事件
                    ToastUtil.showMsg(getApplicationContext(),"UI布局界面");
                    intent = new Intent(MainTestActivity.this, UIActivity.class);
                    break;
                case R.id.btn_SharedPre:
                    // 事件
                    ToastUtil.showMsg(getApplicationContext(),"轻量数据存储");
                    intent = new Intent(MainTestActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_banner:
                    ToastUtil.showMsg(getApplicationContext(),"广告条banner");
                    intent = new Intent(MainTestActivity.this,BannerActivity.class);
                    break;
                case R.id.btn_categories:
                    ToastUtil.showMsg(getApplicationContext(),"商品分类");
                    intent = new Intent(MainTestActivity.this,CategoriesActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
