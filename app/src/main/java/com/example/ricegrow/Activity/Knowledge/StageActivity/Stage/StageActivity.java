package com.example.ricegrow.Activity.Knowledge.StageActivity.Stage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.widget.NestedScrollView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.ricegrow.Activity.Knowledge.Management.Crop.CropActivity;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.TreatingAdapter;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.UsingAdapter;
import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.DatabaseFiles.Model.Diseases;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.Weeds;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class StageActivity extends AppCompatActivity {

    public static final String STAGE_KEY = "incoming_stage";
    private MaterialToolbar toolbarStage;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imageStage;
    private TextView txtNameStage, txtDescription, txtDuration, txtStartDate, txtEndDate, txtEmpty, txtEmpty2, txtEmpty3;
    private RecyclerView pestsRecView, diseasesRecView, activityRecView;
    private TreatingAdapter pestAdapter, diseaseAdapter;
    private UsingAdapter activityAdapter;
    private RiceGrowDatabase db;
    private Stages incomingStage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_stage);

        initView();

        toolbarStage.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarStage.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(StageActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        Intent intent = getIntent();
        if(intent != null){
            incomingStage = intent.getParcelableExtra(STAGE_KEY);
            if (incomingStage != null){
                Glide.with(this)
                        .asBitmap()
                        .load(incomingStage.getStageImage())
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
                                    int defaultColor = ContextCompat.getColor(StageActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imageStage.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageStage);
                txtNameStage.setText(incomingStage.getName());
                toolbarStage.setTitle(incomingStage.getName());
                txtDescription.setText(incomingStage.getDescription());
                String duration = "About " + String.valueOf(incomingStage.getDuration()) + " days";
                txtDuration.setText(duration);
                String start = String.valueOf(incomingStage.getStartDate()) + " day";
                txtStartDate.setText(start);
                String end = String.valueOf(incomingStage.getEndDate()) + " day";
                txtEndDate.setText(end);

                pestAdapter = new TreatingAdapter(this);
                pestsRecView.setAdapter(pestAdapter);
                pestsRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Pests> pests = (ArrayList<Pests>) db.pestDao().getPestByStageId(incomingStage.getId());
                if(pests != null){
                    if(pests.size() > 0){
                        pestsRecView.setVisibility(View.VISIBLE);
                        txtEmpty.setVisibility(View.GONE);
                        pestAdapter.setPests(pests);
                    } else {
                        pestsRecView.setVisibility(View.GONE);
                        txtEmpty.setVisibility(View.VISIBLE);
                    }
                }

                diseaseAdapter = new TreatingAdapter(this);
                diseasesRecView.setAdapter(diseaseAdapter);
                diseasesRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Diseases> diseases = (ArrayList<Diseases>) db.diseaseDao().getDiseaseByStageId(incomingStage.getId());
                if(diseases != null){
                    if(diseases.size() > 0){
                        diseasesRecView.setVisibility(View.VISIBLE);
                        txtEmpty2.setVisibility(View.GONE);
                        diseaseAdapter.setDiseases(diseases);
                    } else {
                        diseasesRecView.setVisibility(View.GONE);
                        txtEmpty2.setVisibility(View.VISIBLE);
                    }
                }

                activityAdapter = new UsingAdapter(this);
                activityRecView.setAdapter(activityAdapter);
                activityRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Activities> activities = (ArrayList<Activities>) db.activityDao().getActivitiesByStageId(incomingStage.getId());
                if(activities != null){
                    if(activities.size() > 0){
                        activityRecView.setVisibility(View.VISIBLE);
                        txtEmpty3.setVisibility(View.GONE);
                        activityAdapter.setActivities(activities);
                    } else {
                        activityRecView.setVisibility(View.GONE);
                        txtEmpty3.setVisibility(View.VISIBLE);
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
        toolbarStage = findViewById(R.id.toolbarStage);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        imageStage = findViewById(R.id.imageStage);
        txtNameStage = findViewById(R.id.txtNameStage);
        txtDescription = findViewById(R.id.txtDescription);
        txtDuration = findViewById(R.id.txtDuration);
        txtStartDate = findViewById(R.id.txtStartDate);
        txtEndDate = findViewById(R.id.txtEndDate);
        txtEmpty = findViewById(R.id.txtEmpty);
        txtEmpty2 = findViewById(R.id.txtEmpty2);
        txtEmpty3 = findViewById(R.id.txtEmpty3);
        pestsRecView = findViewById(R.id.pestsRecView);
        diseasesRecView = findViewById(R.id.diseasesRecView);
        activityRecView = findViewById(R.id.activityRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}