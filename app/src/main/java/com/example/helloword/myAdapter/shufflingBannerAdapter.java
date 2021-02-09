package com.example.helloword.myAdapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class shufflingBannerAdapter extends PagerAdapter {

    private List<Integer> mList;
    @Override
    public int getCount() {
        if(mList!=null){
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int realPosition = position % mList.size();
        Log.d(TAG,"instantiateItem "+ position);
        ImageView imageView = new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(mList.get(realPosition));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d(TAG,"destroyItem "+ position);
        container.removeView((View) object);
    }

    public void setData(List<Integer> list) {
        mList = new ArrayList<>();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public int getDataRealSize(){
        if(mList!=null){
            return mList.size();
        }
        return 0;
    }
}
