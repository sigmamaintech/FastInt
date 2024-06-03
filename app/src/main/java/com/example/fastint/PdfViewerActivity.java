package com.example.fastint;

import static android.app.PendingIntent.getActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PdfViewerActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pdf_viewer);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient());
        // Включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        // Загружаем LoadUrl
        LoadUrl(webView);
    }
    void LoadUrl(WebView webView) { // Эта функция в зависимости от названия из адаптера подгружает нужную ссылку
        if(AlgorithmAdapter.FileName.equals("bubble")) {
            webView.loadUrl("https://drive.google.com/file/d/11K_muj2VroLWPbrPIjhn8s9Ekb202MiM/view");
        } else if(AlgorithmAdapter.FileName.equals("insert")) {
            webView.loadUrl("https://drive.google.com/file/d/11SWP6cc8SnN_0HDwujse4IM0scJXuohX/view");
        } else if(AlgorithmAdapter.FileName.equals("qsort")) {
            webView.loadUrl("https://drive.google.com/file/d/1RdMD0oSsjDfSOaQjmdU3M-KLBcp43rjZ/view");
        } else if(AlgorithmAdapter.FileName.equals("selection")) {
            webView.loadUrl("https://drive.google.com/file/d/1_AnuCcw-7JpfXb7lGzN6ql1qxm8JCu98/view");
        }
    }
    private static class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        // Для старых устройств
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}