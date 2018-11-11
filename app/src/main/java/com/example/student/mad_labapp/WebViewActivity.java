package com.example.student.mad_labapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        page = findViewById(R.id.webView);
        page.setWebViewClient(new WebViewClient());
        Intent i = getIntent();
        String url = i.getStringExtra("load");
        if (url.equals("defaultpage")) {
            page.loadUrl("https://www.google.com");
        } else {
            page.loadUrl(url);
        }
    }
}
