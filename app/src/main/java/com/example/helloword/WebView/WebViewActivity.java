package com.example.helloword.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.helloword.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview = findViewById(R.id.webView);

        // 辅助Webview 处理js的对话框，网站图标，title,加载速度 等等；
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });


        //处理各种通知 & 请求事件；
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings webSettings = webview.getSettings();
        // 加载js，进行设置；
        webSettings.setJavaScriptEnabled(true);

        //  优先使用缓存；
//         webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        //缩放操作
//        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        // 加载网页；默认会跳转至浏览器加载；
        webview.loadUrl("file:///android_asset/wjy/lv.html");
//        webview.loadUrl("http://www.hao123.com");
    }
    // 重写back键；


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()){
            webview.goBack();
            return true;
        }else {
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }
}
