package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloword.RecyclerView.RecyclerViewActivity;
import com.example.helloword.util.MessageEvent;
import com.example.helloword.util.ToastUtil;
import com.example.helloword.util.UserEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class UIActivity extends AppCompatActivity {

    private Button mTextView;
    private  Button mButton;
    private  Button mEditText;
    private Button mLogin;
    private Button mImageView;
    private Button mListView;
    private Button mGridView;
    private  Button mRecyclerView;
    private  Button mAlertDialog;
    private Button mToast;
    private Button mProgress;
    private Button mPopUpWindow;

    private TextView textUserName,textUserPassword;
    private Toolbar uiToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        initButton();
        // EventBus注册；
        EventBus.getDefault().register(this);

        textUserName = findViewById(R.id.textUserName);
        textUserPassword = findViewById(R.id.textUserPassword);
        uiToolBar = findViewById(R.id.uiToolBar);

        textUserName.setText("用户昵称");
        textUserPassword.setText("用户密码");
    }

    private void initButton(){
        // 重写点击按钮跳转；
        mEditText = findViewById(R.id.btn_editText);
        mButton = findViewById(R.id.btn_Button);
        mLogin = findViewById(R.id.btn_Login);
        mImageView = findViewById(R.id.btn_ImageView);
        mListView = findViewById(R.id.btn_ListView);
        mGridView = findViewById(R.id.btn_GridView);
        mRecyclerView = findViewById(R.id.btn_RecyclerView);
        mAlertDialog = findViewById(R.id.btn_AlertDialog);
        mToast = findViewById(R.id.btn_toast);
        mProgress = findViewById(R.id.btn_Progress);
        mPopUpWindow = findViewById(R.id.btn_PopUpWindow);

        //页面弹框；
        OnClick onclick = new OnClick();
        mEditText.setOnClickListener(onclick);
        mButton.setOnClickListener(onclick);
        mLogin.setOnClickListener(onclick);
        mImageView.setOnClickListener(onclick);
        mListView.setOnClickListener(onclick);
        mGridView.setOnClickListener(onclick);
        mRecyclerView.setOnClickListener(onclick);
        mAlertDialog.setOnClickListener(onclick);
        mToast.setOnClickListener(onclick);
        mProgress.setOnClickListener(onclick);
        mPopUpWindow.setOnClickListener(onclick);
    }
    class OnClick implements View.OnClickListener{
        private Intent intent;

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case  R.id.btn_editText:
                    ToastUtil.showMsg(getApplicationContext(),"btn_editText按钮被点击了...");
                     intent =new Intent(UIActivity.this,editTextActivity.class);
                    break;
                case R.id.btn_Button:
                    Toast.makeText(UIActivity.this, "Button被点击了", Toast.LENGTH_SHORT).show();
                    //跳转到ButtonActivity 页面；
                     intent = new Intent(UIActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_Login:
                    //跳转到LoginActivity 界面；
                     intent = new Intent(UIActivity.this,LoginActivity.class);
                    break;
                case R.id.btn_ImageView:
                     intent = new Intent(UIActivity.this,ImageViewActivity.class);
                    break;
                case R.id.btn_ListView:
                    // 提示按钮点击
                    Toast.makeText(UIActivity.this,"ListView按钮跳转",Toast.LENGTH_SHORT).show();
                     intent = new Intent(UIActivity.this,ListViewActivity.class);
                    break;
                case R.id.btn_GridView:
                    // 提示弹框
                    Toast.makeText(UIActivity.this,"gridView按钮被点击，页面跳转",Toast.LENGTH_SHORT).show();
                    // 页面跳转
                     intent = new Intent(UIActivity.this,GridViewActivity.class);
                    break;
                case R.id.btn_RecyclerView:
                    //提示弹框；
                    Toast.makeText(UIActivity.this, "RecyclerView按钮被点击！", Toast.LENGTH_SHORT).show();
                    // 页面被跳转；
                     intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_AlertDialog:
                    //提示弹框；
                    Toast.makeText(UIActivity.this, "AlertDialog按钮被点击！", Toast.LENGTH_SHORT).show();
                    // 页面被跳转；
                     intent = new Intent(UIActivity.this,AlertDialogActivity.class);
                    break;
                case R.id.btn_toast:
                    // 提示弹框；
                    Toast.makeText(getApplicationContext(),"Toast页面跳转",Toast.LENGTH_SHORT).show();
                    // 页面跳转；
                     intent = new Intent(UIActivity.this,ToastActivity.class);
                    break;
                case R.id.btn_Progress:
                    // 提示框‘
                    ToastUtil.showMsg(getApplicationContext(),"mPregress 页面跳转");
                    // 页面跳转;
                     intent = new Intent(UIActivity.this,ProgressActivity.class);
                    break;
                case R.id.btn_PopUpWindow:
                    // 提示框‘
                    ToastUtil.showMsg(getApplicationContext(),"mPopUpWindow 页面跳转");
                    // 页面跳转;
                     intent = new Intent(UIActivity.this,PopUpWindowActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    // 接受订阅事件；
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void testEventBus(UserEvent userEvent){
        textUserName.setText("用户昵称："+userEvent.getUsername());
        uiToolBar.setTitle(userEvent.getUsername());
        textUserPassword.setText("用户密码："+userEvent.getPassword());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }
}
