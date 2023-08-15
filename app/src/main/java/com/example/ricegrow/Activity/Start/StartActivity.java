package com.example.ricegrow.Activity.Start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Dao.SettingDao;
import com.example.ricegrow.DatabaseFiles.Model.Setting;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

public class StartActivity extends AppCompatActivity {

    private ShapeableImageView imageViewLogo;
    private TextView hello, select;
    private MaterialCardView cardView, cardView2;
    private Button btnAccept;
    private RiceGrowDatabase db;
    private Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_start);
        initView();
        if (db.settingDao().getAll() != null){
            startActivity(new Intent(StartActivity.this, MainActivity.class));
            finish();
        } else {
            db.settingDao().insert(new Setting(true, true, true, "en"));
            setting = db.settingDao().getAll();
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
                setting.setLanguage("en");
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
                setting.setLanguage("vi");
            }
        });
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.settingDao().updateSetting(setting);
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void initView() {
        imageViewLogo = findViewById(R.id.imageViewLogo);
        hello = findViewById(R.id.hello);
        select = findViewById(R.id.select);
        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        btnAccept = findViewById(R.id.btnAccept);
        db = RiceGrowDatabase.getInstance(this);
    }
}