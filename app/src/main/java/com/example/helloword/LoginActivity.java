package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloword.util.MessageEvent;
import com.example.helloword.util.UserEvent;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.loginUserName);
        password = findViewById(R.id.loginUserPassword);

        initLoginButton();
    }

    private void initLoginButton(){
        // 登录按钮点击，实现弹出框以及页面跳转；
        mLoginBtn = findViewById(R.id.loginButton);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"登录成功！！",Toast.LENGTH_SHORT).show();
                // EventBus事件处理；
                EventBus.getDefault().post(new UserEvent(userName.getText().toString(),password.getText().toString()));
                // 页面销毁；
                finish();

            }
        });
    }

    // 销毁EventBus;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

}
