package com.example.helloword.myAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class lunBoViewPager extends PagerAdapter {

    private  List<View> mImage;

    public lunBoViewPager(List<View> mImage) {
        this.mImage = mImage;
    }

    @Override
    public int getCount() {
        // return mImage.length;
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImage.get(position));
        return mImage.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
