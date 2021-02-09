package com.example.helloword.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloword.R;

import java.util.List;

public class StaggeredRecyclerAdapter extends RecyclerView.Adapter<StaggeredRecyclerAdapter.LinearViewHolder> {

    private Context mContext;
    private List list;
    private RecyclerView.OnItemTouchListener listener;

    public StaggeredRecyclerAdapter(Context context, RecyclerView.OnItemTouchListener listener){
        this.mContext = context;
        this.listener = listener;
    }
    @NonNull
    @Override
    public StaggeredRecyclerAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearViewHolder linearViewHolder;
        linearViewHolder = new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.staggered_item_view,null));
        return linearViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredRecyclerAdapter.LinearViewHolder holder, final int position) {
        if(position % 2 == 0){
            holder.imageView.setImageResource(R.drawable.my_image);
        }else{
            holder.imageView.setImageResource(R.drawable.pic);
        }


        // 添加点击事件；
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了：  "+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // 返回长度；
        return 20;
//        return list == null ? 0 : list.size();
    }

    public class LinearViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public  LinearViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.staggeredImage1);
        }
    }
}
