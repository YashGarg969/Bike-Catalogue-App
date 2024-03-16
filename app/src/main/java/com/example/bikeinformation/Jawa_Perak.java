package com.example.bikeinformation;

import androidx.appcompat.app.AppCompatActivity;

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

public class Jawa_Perak extends AppCompatActivity {

    WebView webview;

    ImageButton btPrevious,btNext;
    ImageSwitcher imageSwitcher;
    int imageList[]= {R.drawable.perak11,R.drawable.perak2,R.drawable.perak3,R.drawable.perak4,R.drawable.perak5};
    int count= imageList.length;
    int currentIndex=0;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jawa_perak);

        web= findViewById(R.id.webview);
        WebSettings webSettings= web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // webSettings.setLoadWithOverviewMode(true);
        web.setWebViewClient(new Callback());
        web.loadUrl("file:///android_asset/jawaperak.html");
        // web.setVisibility(View.VISIBLE);
        webSettings.setUseWideViewPort(true);
        btPrevious=findViewById(R.id.bt_previous);
        btNext=findViewById(R.id.bt_next);
        imageSwitcher=findViewById(R.id.image_switcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView= new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //  imageView.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageList[0]);
        btPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // imageSwitcher.setInAnimation(MainActivity.this,R.anim.from_right);
                // imageSwitcher.setOutAnimation(MainActivity.this,R.anim.to_left);
                --currentIndex;
                if(currentIndex<0)
                    currentIndex=imageList.length-1;
                imageSwitcher.setImageResource(imageList[currentIndex]);


            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //imageSwitcher.setInAnimation(MainActivity.this,R.anim.from_left);
                //  imageSwitcher.setOutAnimation(MainActivity.this,R.anim.to_right);
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