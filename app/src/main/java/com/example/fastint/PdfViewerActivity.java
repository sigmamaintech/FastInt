package com.example.fastint;

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
            case "segbase":
                webView.loadUrl("https://drive.google.com/file/d/1cI2jrErJWRrbSNIv8lXCU6yMRJAuCw0L/view?usp=sharing");
                break;
            case "segmaxsum":
                webView.loadUrl("https://drive.google.com/file/d/1zSGwp03KIbO5NUPGK8rqzHyCzTGDGrq-/view?usp=sharing");
                break;
            case "segked":
                webView.loadUrl("https://drive.google.com/file/d/1JUThhfT6WG0BzfBz7cKhVlsb2ARdzy5W/view?usp=sharing");
                break;
            case "segmasprib":
                webView.loadUrl("https://drive.google.com/file/d/1qNGecRsAB921UYneic6f4oPqNyDBrv_Q/view?usp=sharing");
                break;
            case "segmasmin":
                webView.loadUrl("https://drive.google.com/file/d/1S0GoR9-vvU4M7da9cjtPkouwycXyjaxi/view?usp=sharing");
                break;
            case "segmaspush":
                webView.loadUrl("https://drive.google.com/file/d/1im74L3VZja7tbiYeT_M8k0SYT1p_E9Fd/view?usp=sharing");
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