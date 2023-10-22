package com.hunter.ricegrow.Activity.Start;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.hunter.ricegrow.Activity.Main.MainActivity;
import com.hunter.ricegrow.Activity.Setting.WebsiteActivity;
import com.hunter.ricegrow.DatabaseFiles.Model.Setting;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

public class StartActivity extends AppCompatActivity {

    private ShapeableImageView imageViewLogo;
    private TextView hello, select, haveReadPrivacyAndTerms;
    private MaterialCardView cardView, cardView2;
    private Button btnAccept;
    private RiceGrowDatabase db;
    private String langCode = "en";
    private Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_start);
        initView();
        if (db.settingDao().getAll() != null) {
            startActivity(new Intent(StartActivity.this, MainActivity.class));
            finish();
        }
        initListener();
    }

    private void initListener() {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setChecked(true);
                cardView2.setChecked(false);
                hello.setText("Hello!");
                select.setText("Select your farming language");
                btnAccept.setText("Accept");
                termAndPrivacyEn("I read and accept the terms of use and the privacy policy");
                langCode = "en";
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setChecked(false);
                cardView2.setChecked(true);
                hello.setText("Xin chào!");
                select.setText("Chọn ngôn ngữ trồng trọt của bạn");
                btnAccept.setText("Chấp nhận");
                termAndPrivacyVi("Tôi đọc và chấp nhận các điều khoản sử dụng và chính sách quyền riêng tư");
                langCode = "vi";
            }
        });
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.settingDao().insert(new Setting(true, true, true, langCode));
                startActivity(new Intent(StartActivity.this, IntroActivity.class));
            }
        });
        termAndPrivacyEn("I read and accept the terms of use and the privacy policy");
    }

    private void termAndPrivacyEn(String mainText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(mainText);

        // Apply different text styles to specific parts of the text
        StyleSpan boldStyle = new StyleSpan(Typeface.BOLD);
        StyleSpan boldStyle2 = new StyleSpan(Typeface.BOLD);

        ClickableSpan termsClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(StartActivity.this, WebsiteActivity.class);
                String message = "https://www.freeprivacypolicy.com/live/0fa5afbc-8836-4aec-8c85-d6f10530d399";
                intent.putExtra("TERMS_KEY", message);
                startActivity(intent);
            }
        };

        ClickableSpan privacyPolicyClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(StartActivity.this, WebsiteActivity.class);
                String message = "https://www.freeprivacypolicy.com/live/e5a4b424-1b2a-4fee-ab8a-5b5db5ab7d96";
                intent.putExtra("PRIVACY_KEY", message);
                startActivity(intent);
            }
        };

        // Set the color span for the "terms of use" part
        spannableStringBuilder.setSpan(boldStyle, mainText.indexOf("terms of use"), mainText.indexOf("terms of use") + "terms of use".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the clickable span for the "terms of use" part
        spannableStringBuilder.setSpan(termsClickableSpan, mainText.indexOf("terms of use"), mainText.indexOf("terms of use") + "terms of use".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the color span for the "privacy policy" part
        spannableStringBuilder.setSpan(boldStyle2, mainText.indexOf("privacy policy"), mainText.indexOf("privacy policy") + "privacy policy".length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the clickable span for the "privacy policy" part
        spannableStringBuilder.setSpan(privacyPolicyClickableSpan, mainText.indexOf("privacy policy"), mainText.indexOf("privacy policy") + "privacy policy".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        haveReadPrivacyAndTerms.setText(spannableStringBuilder);
        haveReadPrivacyAndTerms.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void termAndPrivacyVi(String mainText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(mainText);

        // Apply different text styles to specific parts of the text
        StyleSpan boldStyle = new StyleSpan(Typeface.BOLD);
        StyleSpan boldStyle2 = new StyleSpan(Typeface.BOLD);

        ClickableSpan termsClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(StartActivity.this, WebsiteActivity.class);
                String message = "https://www.freeprivacypolicy.com/live/0fa5afbc-8836-4aec-8c85-d6f10530d399";
                intent.putExtra("TERMS_KEY", message);
                startActivity(intent);
            }
        };

        ClickableSpan privacyPolicyClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(StartActivity.this, WebsiteActivity.class);
                String message = "https://www.freeprivacypolicy.com/live/e5a4b424-1b2a-4fee-ab8a-5b5db5ab7d96";
                intent.putExtra("PRIVACY_KEY", message);
                startActivity(intent);
            }
        };

        // Set the color span for the "terms of use" part
        spannableStringBuilder.setSpan(boldStyle, mainText.indexOf("các điều khoản sử dụng"), mainText.indexOf("các điều khoản sử dụng") + "các điều khoản sử dụng".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the clickable span for the "terms of use" part
        spannableStringBuilder.setSpan(termsClickableSpan, mainText.indexOf("các điều khoản sử dụng"), mainText.indexOf("các điều khoản sử dụng") + "các điều khoản sử dụng".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the color span for the "privacy policy" part
        spannableStringBuilder.setSpan(boldStyle2, mainText.indexOf("chính sách quyền riêng tư"), mainText.indexOf("chính sách quyền riêng tư") + "chính sách quyền riêng tư".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the clickable span for the "privacy policy" part
        spannableStringBuilder.setSpan(privacyPolicyClickableSpan, mainText.indexOf("chính sách quyền riêng tư"), mainText.indexOf("chính sách quyền riêng tư") + "chính sách quyền riêng tư".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        haveReadPrivacyAndTerms.setText(spannableStringBuilder);
        haveReadPrivacyAndTerms.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView() {
        imageViewLogo = findViewById(R.id.imageViewLogo);
        hello = findViewById(R.id.hello);
        select = findViewById(R.id.select);
        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        btnAccept = findViewById(R.id.btnAccept);
        haveReadPrivacyAndTerms = findViewById(R.id.haveReadPrivacyAndTerms);
        db = RiceGrowDatabase.getInstance(this);
    }
}