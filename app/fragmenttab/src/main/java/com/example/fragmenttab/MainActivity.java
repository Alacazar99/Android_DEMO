package com.example.fragmenttab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        tabHost = (FragmentTabHost)findViewById(R.id.tab_Host);


        //获取tab的标题
        String[] titles =  new String[]{"首页","通讯录","发现","我的"};
        //背景图
        int[] icons = new int[]{
                R.drawable.shouyebule,
                R.drawable.zhaopian,
                R.drawable.setting2,
                R.drawable.mybule
        };

        //这4个fragment为我们第二步中新建的四个fragment
        Class[] classes = new Class[]{VideoFragment.class,AudioFragment.class,NetVideoFragment.class,NetAudioFragment.class};

        //1绑定显示Fragment的容器
        tabHost.setup(this,getSupportFragmentManager(),R.id.content);
        for (int i=0;i<4;i++){
            // 2生成不同的标签，tag相当于标签的名称
            TabHost.TabSpec tmp =  tabHost.newTabSpec(""+i);
            tmp.setIndicator(getEveryView(this,titles,icons,i));
            tabHost.addTab(tmp,classes[i],null);
        }


    }



    /**
     * 这个自定义方法会用到item_title布局，作用时返回底部导航栏中的每一个view
     * 该方法在上面setIndicator中被调用
     */

    public View getEveryView(Context context, String[] titles, int[] icons, int index){
        LayoutInflater inflater = LayoutInflater.from(context);
        View title_view = inflater.inflate(R.layout.item_tab,null);
        TextView title = (TextView) title_view.findViewById(R.id.title);
        ImageView icon = (ImageView)title_view.findViewById(R.id.icon);
        //设置标签的内容
        title.setText(titles[index]);
        icon.setImageResource(icons[index]);
        return  title_view;
    }

}


