package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DataStorageActivity extends AppCompatActivity {

    private WebView webViewDataShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        initWebView();

    }
    private void initWebView(){
        webViewDataShare = findViewById(R.id.webViewDataShare);

        // 辅助Webview 处理js的对话框，网站图标，title,加载速度 等等；
        webViewDataShare.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });


        //处理各种通知 & 请求事件；
        webViewDataShare.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings webSettings = webViewDataShare.getSettings();
        // 加载js，进行设置；
        webSettings.setJavaScriptEnabled(true);

        // 加载网页；默认会跳转至浏览器加载；
        webViewDataShare.loadUrl("file:///android_asset/myEcharts/index.html");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webViewDataShare.canGoBack()){
            webViewDataShare.goBack();
            return true;
        }else {
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }
}
