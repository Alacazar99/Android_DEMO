package com.example.helloword.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloword.R;
import com.example.helloword.ToastActivity;

// 自定义Toast;
public class ToastUtil {
    public static Toast mToast;

    public static void showMsg(Context context,String msg){
        if(mToast == null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else{
//            LayoutInflater inflater;
//            inflater = LayoutInflater.from();
//            View view = inflater.inflate(R.layout.layout_toast,null);
//            ImageView imageView = view.findViewById(R.id.iv_toast);
//            imageView.setImageResource(R.drawable.ic_launcher_foreground);
//            TextView textView = view.findViewById(R.id.tv_toast);
//            textView.setText(msg);
//            mToast.setView(view);
//            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.setText(msg);
        }
        mToast.show();
    }
}
