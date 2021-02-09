package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloword.util.ToastUtil;

import org.w3c.dom.Text;

public class ToastActivity extends AppCompatActivity {

    private Button mtoast1,mtoast2,mtoast3,mtoast4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mtoast1 = findViewById(R.id.btn_toast1);
        mtoast2 = findViewById(R.id.btn_toast2);
        mtoast3 = findViewById(R.id.btn_toast3);
        mtoast4 = findViewById(R.id.btn_toast4);
        OnClick onClick = new OnClick();
        mtoast1.setOnClickListener(onClick);
        mtoast2.setOnClickListener(onClick);
        mtoast3.setOnClickListener(onClick);
        mtoast4.setOnClickListener(onClick);

    }
    class OnClick implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btn_toast1:
                    Toast.makeText(getApplicationContext(),"默认Toast",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(),"居中...",Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);

                    View view = inflater.inflate(R.layout.layout_toast,null);

                    ImageView imageView = view.findViewById(R.id.iv_toast);

                    imageView.setImageResource(R.drawable.my_image);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    textView.setText("黄世祥巨帅!");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_SHORT);
                    toastCustom.setGravity(Gravity.CENTER,0,0);
                    // 设置居中；
                    // toastCustom.setGravity(Gravity.CENTER,50,50);
                    toastCustom.show();
                    break;
                case R.id.btn_toast4:
                    ToastUtil.showMsg(getApplicationContext(),"自封装ToastUtil");
                    break;
            }
        }
    }
}
