package com.example.samsung.raspwebview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView raspWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        raspWebView = (WebView) findViewById(R.id.webView);
        raspWebView.getSettings().setJavaScriptEnabled(true); //자바 스크립트 사용 허용
        raspWebView.getSettings().setBuiltInZoomControls(true); //줌 상태 지정
        raspWebView.getSettings().setSupportZoom(true); //확대, 축소 기능 사용하기

        raspWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); //자바스크립트에서 윈도우 새로 열 수 있는지 지정
        raspWebView.getSettings().setSaveFormData(true); //폼 데이터 저장 여부 설정

        raspWebView.setWebViewClient(new MyWebViewClient()); //웹 페이지 로딩
        raspWebView.loadUrl( "https://hrpzz.github.io/"); //file://abc/abc.html 가능 //"http://m.naver.com"
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //기기의 back 버튼 인식
        if((keyCode == KeyEvent.KEYCODE_BACK) && raspWebView.canGoBack()){
            raspWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }

}
