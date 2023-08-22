package com.example.ricegrow.Activity.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.Locale;

public class WebsiteActivity extends AppCompatActivity {
    private WebView webView;
    private MaterialToolbar toolbarTerm;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_website);
        webView = findViewById(R.id.webView);
        toolbarTerm = findViewById(R.id.toolbarTerm);

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

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }




    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}