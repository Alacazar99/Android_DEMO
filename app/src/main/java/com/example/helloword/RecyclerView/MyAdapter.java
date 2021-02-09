package com.example.helloword.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.helloword.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList mData;

    public MyAdapter(ArrayList data){
        this.mData = data;
    }

    public void updateData(ArrayList data){
        this.mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 实例化 View；
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view,null);
        // 实例化 viewHolder
        ViewHolder viewHolder;
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        // 绑定数据；
//        holder.mTv.setText((Integer) mData.get(position));
//    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView listView_title;

        public ViewHolder(View itemView) {
            super(itemView);
            listView_title = (TextView) itemView.findViewById(R.id.listView_title);
        }
    }


}
