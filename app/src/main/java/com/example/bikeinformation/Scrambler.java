package com.example.bikeinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Scrambler extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrambler);

        webview = findViewById(R.id.webview);
        //Magnifier mg = new Magnifier(webview);
        WebSettings webSettings = webview.getSettings();
        webview.loadUrl("file:///android_asset/scrambler.html");
    }
}