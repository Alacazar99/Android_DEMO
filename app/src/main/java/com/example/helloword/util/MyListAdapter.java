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

import org.w3c.dom.Text;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;


    public MyListAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    };
    // 长度；
    @Override
    public int getCount() {
        return 10;
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
        public TextView listView_title,listView_time,listView_content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.list_item_view,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.list_image_view1);
            holder.listView_title = convertView.findViewById(R.id.listView_title);
            holder.listView_time = convertView.findViewById(R.id.listView_time);
            holder.listView_content = convertView.findViewById(R.id.listView_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        // 给控件赋值；
        holder.listView_title.setText("重新复制");
        // 图片；
//        Glide.with(mContext).load("").into(holder.imageView);
        holder.imageView.setImageResource(R.drawable.my_image);
        return convertView;
    }
}
