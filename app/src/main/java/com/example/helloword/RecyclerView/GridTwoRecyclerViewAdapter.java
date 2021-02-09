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

public class GridTwoRecyclerViewAdapter extends RecyclerView.Adapter<GridTwoRecyclerViewAdapter.LinearViewHolder> {

    private Context mContext;
    private List list;

    public GridTwoRecyclerViewAdapter(Context context){
        this.mContext = context;
    }
    @NonNull
    @Override
    public GridTwoRecyclerViewAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearViewHolder linearViewHolder;
        linearViewHolder = new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.grid_item_view,null));
        return linearViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridTwoRecyclerViewAdapter.LinearViewHolder holder, final int position) {
        holder.imageView.setImageResource(R.drawable.my_image);

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
        private TextView listView_title,listView_time,listView_content;
        private ImageView imageView;

        public  LinearViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.grid_image_view1);
            listView_title = itemView.findViewById(R.id.gridView_title);
            listView_time = itemView.findViewById(R.id.gridView_time);
            listView_content = itemView.findViewById(R.id.gridView_content);
        }
    }
}
