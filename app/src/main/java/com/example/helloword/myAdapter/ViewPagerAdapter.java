package com.example.helloword.myAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.helloword.R;

import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {
    // 轮播图广告 图片资源；
    private int[] imgRes;
    private List<View> images;

    public ViewPagerAdapter(int[] imgRes,List images){
        this.imgRes = imgRes;
        this.images = images;
    }
    @Override
    public int getCount() {
//            return images.size();
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView(images.get(position));
        super.destroyItem(container, position, object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

}
