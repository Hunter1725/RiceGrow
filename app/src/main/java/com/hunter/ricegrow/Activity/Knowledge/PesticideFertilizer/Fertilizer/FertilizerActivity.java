package com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.widget.NestedScrollView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.hunter.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate;
import com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.UsingAdapter;
import com.hunter.ricegrow.Activity.Main.MainActivity;
import com.hunter.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.hunter.ricegrow.DatabaseFiles.Model.Activities;
import com.hunter.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FertilizerActivity extends AppCompatActivity {

    public static final String FERTILIZER_KEY = "incoming_fertilizer";
    private MaterialToolbar toolbar;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imageFertilizer;
    private TextView txtNameFertilizer, txtManufacturer, txtComposition, txtInstruction, txtRecommendedUsage, txtEmpty;
    private RecyclerView usingRecView;
    private UsingAdapter usingAdapter;
    private RiceGrowDatabase db;
    private Fertilizers incomingFertilizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_fertilizer);

        initView();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.calculating) {
                    // Handle search item click here
                    // Apply click effect or perform any desired action
                    startActivity(new Intent(FertilizerActivity.this, FertilizerCalculate.class));
                    return true; // Return true to indicate that the event has been handled
                } else if (itemId == R.id.home) {
                    startActivity(new Intent(FertilizerActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        //Using recycler view
        Intent intent = getIntent();
        if(intent != null){
            incomingFertilizer = intent.getParcelableExtra(FERTILIZER_KEY);
            if (incomingFertilizer != null){
                Glide.with(this)
                        .asBitmap()
                        .load(incomingFertilizer.getFertImage())
                        .addListener(new RequestListener<Bitmap>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                                // Handle failed image loading
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                                // Image loaded successfully
                                Palette.from(resource).generate(palette -> {
                                    int defaultColor = ContextCompat.getColor(FertilizerActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imageFertilizer.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageFertilizer);
                txtNameFertilizer.setText(incomingFertilizer.getName());
                toolbar.setTitle(incomingFertilizer.getName());
                if(GetCurrentLanguage.getCurrentLanguage(FertilizerActivity.this).equals("en")) {
                    txtManufacturer.setText(incomingFertilizer.getManufacturerEn());
                    txtComposition.setText(incomingFertilizer.getCompositionEn());
                    txtInstruction.setText(incomingFertilizer.getUsageInstructionsEn());
                } else {
                    txtManufacturer.setText(incomingFertilizer.getManufacturerVi());
                    txtComposition.setText(incomingFertilizer.getCompositionVi());
                    txtInstruction.setText(incomingFertilizer.getUsageInstructionsVi());
                }
                String recommendedUsage = String.valueOf(incomingFertilizer.getRecommendedUsage() + " kg/ha");
                txtRecommendedUsage.setText(recommendedUsage);

                usingAdapter = new UsingAdapter(this);
                usingRecView.setAdapter(usingAdapter);
                usingRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

                ArrayList<Activities> activities = (ArrayList<Activities>) db.activityDao().getActivitiesByFertilizerId(incomingFertilizer.getId());
                if(activities != null){
                    if(activities.size() > 0){
                        usingRecView.setVisibility(View.VISIBLE);
                        txtEmpty.setVisibility(View.GONE);
                        usingAdapter.setActivities(activities);
                    } else {
                        usingRecView.setVisibility(View.GONE);
                        txtEmpty.setVisibility(View.VISIBLE);
                    }
                }
            }
        }

        fabScrollToTop.hide();
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // Check the scroll position
                if (scrollY == 0) {
                    // Scroll is at the top, hide the FloatingActionButton
                    fabScrollToTop.hide();
                } else if (scrollY > oldScrollY) {
                    // Scrolling downwards, hide the FloatingActionButton
                    fabScrollToTop.hide();
                } else {
                    // Scrolling upwards, show the FloatingActionButton
                    fabScrollToTop.show();
                }
            }
        });

        //FAB scroll up
        // Set an OnClickListener for the FloatingActionButton
        fabScrollToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Scroll to the top of the NestedScrollView
                nestedScrollView.smoothScrollTo(0, 0);
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarFertilizer);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        imageFertilizer = findViewById(R.id.imageFertilizer);
        txtNameFertilizer = findViewById(R.id.txtNameFertilizer);
        txtManufacturer = findViewById(R.id.txtManufacturer);
        txtComposition = findViewById(R.id.txtComposition);
        txtInstruction = findViewById(R.id.txtInstruction);
        txtRecommendedUsage = findViewById(R.id.txtRecommendedUsage);
        txtEmpty = findViewById(R.id.txtEmpty);
        usingRecView = findViewById(R.id.usingRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}