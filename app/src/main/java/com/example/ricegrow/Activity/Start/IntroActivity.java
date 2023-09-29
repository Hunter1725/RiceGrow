package com.example.ricegrow.Activity.Start;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.Activity.Setting.ContextWrapper;
import com.example.ricegrow.Activity.Start.Onboarding.Screens.FirstScreen;
import com.example.ricegrow.Activity.Start.Onboarding.Screens.OriginalFragment;
import com.example.ricegrow.Activity.Start.Onboarding.Screens.SecondScreen;
import com.example.ricegrow.Activity.Start.Onboarding.Screens.ThirdScreen;
import com.example.ricegrow.Activity.Start.Onboarding.ViewPagerAdapter;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;

import java.util.ArrayList;
import java.util.Locale;

public class IntroActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private Button btnNext, btnSkip;
    private LinearLayout indicatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        initView();

        initOnboarding();

        initListener();

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        RiceGrowDatabase db = RiceGrowDatabase.getInstance(this);
        String lng = db.settingDao().getAll().getLanguage();
        Locale locale;
        locale = new Locale(lng);
        Locale.setDefault(locale);

        Context context = ContextWrapper.wrap(newBase, locale);
        super.attachBaseContext(context);
    }

    private void initListener() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateIndicators(position);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager2.getCurrentItem() == 3){
                    startActivity(new Intent(IntroActivity.this, MainActivity.class));
                    finish();
                }
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void initView() {
        viewPager2 = findViewById(R.id.viewPager2);
        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);
        indicatorLayout = findViewById(R.id.indicatorLayout);
    }

    private void initOnboarding() {
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new OriginalFragment());
        fragmentList.add(new FirstScreen());
        fragmentList.add(new SecondScreen());
        fragmentList.add(new ThirdScreen());

        ViewPagerAdapter adapter = new ViewPagerAdapter(
                fragmentList,
                getSupportFragmentManager(),
                getLifecycle()
        );
        viewPager2.setAdapter(adapter);
        createIndicators(fragmentList.size());
    }

    private void createIndicators(int size) {
        // Get the actual number of items in the adapter
        for (int i = 0; i < size; i++) {
            ImageView indicator = (ImageView) LayoutInflater.from(IntroActivity.this)
                    .inflate(R.layout.item_indicator, indicatorLayout, false);
            indicatorLayout.addView(indicator);
        }
    }

    private void updateIndicators(int position) {
        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            ImageView indicator = (ImageView) indicatorLayout.getChildAt(i);
            // Calculate the correct position of the indicators based on the current page position modulo the actual item count
            int realPosition = position % 4;
            if (i == realPosition) {
                indicator.setImageResource(R.drawable.indicator_selected);
            } else {
                indicator.setImageResource(R.drawable.indicator_unselected);
            }
        }
    }
}