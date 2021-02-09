package com.example.helloword.util;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloword.R;

public class MyGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridViewAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView gridView_title,gridView_time,gridView_content;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.grid_item_view,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.grid_image_view1);
            holder.gridView_title = convertView.findViewById(R.id.gridView_title);
            holder.gridView_time = convertView.findViewById(R.id.gridView_time);
            holder.gridView_content = convertView.findViewById(R.id.gridView_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

//        holder.imageView.setImageResource(R.drawable.my_image);
        holder.imageView.setImageResource(R.drawable.my_image);
        return convertView;
    }
}
