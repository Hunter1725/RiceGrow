package com.example.ricegrow.Activity.Setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;

import com.example.ricegrow.Activity.Main.NetworkUtils;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;

public class WebsiteActivity extends AppCompatActivity implements NetworkUtils.OnConnectivityChangeListener {
    private WebView webView;
    private MaterialToolbar toolbarTerm;
    private ConstraintLayout lostLayout;
    private String url;
    private NetworkUtils networkUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_website);
        initView();
        // Create an instance of NetworkConnectivityMonitor and register the listener
        networkUtils = new NetworkUtils(WebsiteActivity.this);
        networkUtils.setListener(this);
        networkUtils.register();
        Intent intent = getIntent();
        String privacyKey = intent.getStringExtra("PRIVACY_KEY");
        String termsKey = intent.getStringExtra("TERMS_KEY");

        if (privacyKey != null && !privacyKey.isEmpty()) {
            url = privacyKey;
            toolbarTerm.setTitle(R.string.privacy_policy);
        } else if (termsKey != null && !termsKey.isEmpty()) {
            url = termsKey;
            toolbarTerm.setTitle(R.string.terms_conditions);
        }

        toolbarTerm.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initWebsite();
    }

    private void initView() {
        webView = findViewById(R.id.webView);
        toolbarTerm = findViewById(R.id.toolbarTerm);
        lostLayout = findViewById(R.id.lostLayout);
    }

    private void initWebsite() {
        if (networkUtils.isConnected()) {
            webView.setVisibility(View.VISIBLE);
            lostLayout.setVisibility(View.GONE);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
        } else {
            webView.setVisibility(View.GONE);
            lostLayout.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        networkUtils.unregister();
    }

    @Override
    public void onConnectivityChanged(boolean isConnected) {
        if (isConnected) {
            runOnUiThread(() -> {
                webView.setVisibility(View.VISIBLE);
                lostLayout.setVisibility(View.GONE);
                initWebsite();
            });
        } else {
            runOnUiThread(() -> {
                webView.setVisibility(View.GONE);
                lostLayout.setVisibility(View.VISIBLE);
            });
        }
    }
}