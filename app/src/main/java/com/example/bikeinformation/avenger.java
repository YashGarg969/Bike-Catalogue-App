package com.example.bikeinformation;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class avenger extends Activity {

    WebView webview;
    ImageButton btPrevious,btNext;
    ImageSwitcher imageSwitcher;
    int imageList[]= {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5};
    int count= imageList.length;
    int currentIndex=0;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avenger);

        web= findViewById(R.id.webview);
        WebSettings webSettings= web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new Callback());
        web.loadUrl("file:///android_asset/avenger.html");
        webSettings.setUseWideViewPort(true);
        btPrevious=findViewById(R.id.bt_previous);
        btNext=findViewById(R.id.bt_next);
        imageSwitcher=findViewById(R.id.image_switcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView= new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageList[0]);
        btPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --currentIndex;
                if(currentIndex<0)
                    currentIndex=imageList.length-1;
                imageSwitcher.setImageResource(imageList[currentIndex]);


            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if(currentIndex==count)
                    currentIndex=0;
                imageSwitcher.setImageResource(imageList[currentIndex]);
            }
        });
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return super.shouldOverrideKeyEvent(view, event);
        }
    }
}