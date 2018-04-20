package com.example.jcarolus.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;
        webView.setWebChromeClient(new WebChromeClient() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            public void onPermissionRequest(final PermissionRequest request) {
                Log.d(LOG_TAG, "onPermissionRequest: " + Arrays.toString(request.getResources()));
                request.grant(request.getResources());
            }
        });

        webView.loadUrl("file:///android_asset/index.html"); // https:// will work
    }
}
