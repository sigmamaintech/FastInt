package com.example.fastint;

import android.app.Activity;
import android.content.Intent;
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
    public void onBackPressed(){
        Intent intent = new Intent(this, AlgSortFragment.class);
        startActivity(intent);
        finish();
    }
    void LoadUrl(WebView webView) { // Эта функция в зависимости от названия из адаптера подгружает нужную ссылку
        switch (AlgorithmAdapter.FileName) {
            case "bubble":
                webView.loadUrl("https://drive.google.com/file/d/11K_muj2VroLWPbrPIjhn8s9Ekb202MiM/view");
                break;
            case "insert":
                webView.loadUrl("https://drive.google.com/file/d/11SWP6cc8SnN_0HDwujse4IM0scJXuohX/view");
                break;
            case "qsort":
                webView.loadUrl("https://drive.google.com/file/d/1RdMD0oSsjDfSOaQjmdU3M-KLBcp43rjZ/view");
                break;
            case "selection":
                webView.loadUrl("https://drive.google.com/file/d/1_AnuCcw-7JpfXb7lGzN6ql1qxm8JCu98/view");
                break;
            case "memory":
                webView.loadUrl("https://drive.google.com/file/d/13F52Yng9INK7_bmyQ-YVWG9oAhqRXimO/view");
                break;
            case "dfs":
                webView.loadUrl("https://drive.google.com/file/d/1z2w4przQ0nxlv9kvMp88g0qqIsMMiGrT/view");
                break;
            case "bfs":
                webView.loadUrl("https://drive.google.com/file/d/1EAvSSb5IoEO8KnT3JA1iFxJxo-mRmn6e/view");
                break;
            case "topSort":
                webView.loadUrl("https://drive.google.com/file/d/1FZciqKJ46_iBiBwNiXQrmrc_r2dHK2as/view?usp=sharing");
                break;
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