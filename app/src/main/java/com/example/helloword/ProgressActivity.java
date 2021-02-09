package com.example.helloword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.helloword.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mproBar3,mproBar4;
    private Button mBtnstart,mProgressDialog1,mProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        // 定位按钮；
        mproBar3 = findViewById(R.id.proBar3);
        mproBar4 = findViewById(R.id.proBar4);
        mBtnstart = findViewById(R.id.BtnStart);

        mProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        mProgressDialog2 = findViewById(R.id.btn_progress_dialog2);

        // 点击按钮，加载进度条；
        mBtnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        // 点击 mProgressDialog1 按钮，触发事件；
        mProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setMessage("正在加载中...请稍等");
                // 取消事件；
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(getApplicationContext(),"已取消加载...");
                    }
                });
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });

        // 点击 mProgressDialog2 按钮，触发事件；
        mProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                 progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMessage("正在下载中...请稍等");

                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "赞赞", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 弹出对话框；
                        ToastUtil.showMsg(getApplicationContext(),"黄世祥巨帅...爱心");
                    }
                });
                progressDialog.show();
                progressDialog.setProgress(60);
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mproBar3.getProgress() < 100 || mproBar4.getProgress() < 100) {
                // mproBar3.setProgress(mproBar3.getProgress() + 5);
                handler.postDelayed(runnable,100);
            } else {
                ToastUtil.showMsg(ProgressActivity.this, "mproBar3 加载完成！");
                ToastUtil.showMsg(ProgressActivity.this,"proBar4 加载完成！");
            }
//            if (mproBar4.getProgress() < 100){
//                //handler.postDelayed(runnable,100);
//            }else{
//                ToastUtil.showMsg(ProgressActivity.this,"proBar4 加载完成！");
//            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mproBar3.setProgress(mproBar3.getProgress() + 1);

            mproBar4.setProgress(mproBar4.getProgress() + 1);
            handler.sendEmptyMessage(0);
        }
    };
}
