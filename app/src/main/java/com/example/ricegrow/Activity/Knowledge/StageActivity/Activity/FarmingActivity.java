package com.example.ricegrow.Activity.Knowledge.StageActivity.Activity;

import static com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity.STAGE_KEY;

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
import com.example.ricegrow.Activity.Knowledge.Management.SupAdapter;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity;
import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.CropStage;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FarmingActivity extends AppCompatActivity {

    public static final String ACTIVITY_KEY = "incoming_activity";
    private MaterialToolbar toolbarActivity;
    private MaterialCardView stage;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imageActivity, imageStage;
    private TextView txtNameActivity, txtDescription, txtDuration, txtEmpty, txtNameStage, txtDurationStage, txtStartDate;
    private RecyclerView recommendRecView;
    private SupAdapter recommendedAdapter;
    private RiceGrowDatabase db;
    private Activities incomingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_farming);

        initView();

        toolbarActivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarActivity.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(FarmingActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        //Using recycler view
        Intent intent = getIntent();
        if(intent != null){
            incomingActivity = intent.getParcelableExtra(ACTIVITY_KEY);
            if (incomingActivity != null){
                Glide.with(this)
                        .asBitmap()
                        .load(incomingActivity.getActivityImage())
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
                                    int defaultColor = ContextCompat.getColor(FarmingActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imageActivity.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageActivity);
                if(GetCurrentLanguage.getCurrentLanguage(FarmingActivity.this).equals("en")) {
                    txtNameActivity.setText(incomingActivity.getNameEn());
                    toolbarActivity.setTitle(incomingActivity.getNameEn());
                    txtDescription.setText(incomingActivity.getDescriptionEn());
                } else {
                    txtNameActivity.setText(incomingActivity.getNameVi());
                    toolbarActivity.setTitle(incomingActivity.getNameVi());
                    txtDescription.setText(incomingActivity.getDescriptionVi());
                }
                String duration = String.valueOf(incomingActivity.getDuration()) + getString(R.string.days);
                txtDuration.setText(duration);

                //Card stage
                Stages stages = db.stageDao().getStageById(incomingActivity.getStageId());
                CropStage cropStage = db.cropStageDao().getFirstCropStageByStageId(incomingActivity.getStageId());
                Glide.with(FarmingActivity.this)
                        .asBitmap()
                        .load(stages.getStageImage())
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageStage);
                if(GetCurrentLanguage.getCurrentLanguage(FarmingActivity.this).equals("en")) {
                    txtNameStage.setText(stages.getNameEn());
                    String startDate = String.valueOf(cropStage.getStartDate()) + getString(R.string.day);
                    txtStartDate.setText(startDate);
                } else {
                    txtNameStage.setText(stages.getNameVi());
                    String startDate = String.valueOf("Ngày thứ " + cropStage.getStartDate());
                    txtStartDate.setText(startDate);
                }
                String durationStage = String.valueOf(cropStage.getDuration()) + getString(R.string.days);
                txtDurationStage.setText(durationStage);


                recommendedAdapter = new SupAdapter(this);
                recommendRecView.setAdapter(recommendedAdapter);
                recommendRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

                ArrayList<Pesticides> pesticides = (ArrayList<Pesticides>) db.pesticideDao().getPesticideByActivityId(incomingActivity.getId());
                ArrayList<Fertilizers> fertilizers = (ArrayList<Fertilizers>) db.fertilizerDao().getFertilizerByActivityId(incomingActivity.getId());
                if(pesticides.size() > 0){
                    recommendRecView.setVisibility(View.VISIBLE);
                    txtEmpty.setVisibility(View.GONE);
                    recommendedAdapter.setPesticides(pesticides);
                } else if (fertilizers.size() > 0) {
                    recommendRecView.setVisibility(View.VISIBLE);
                    txtEmpty.setVisibility(View.GONE);
                    recommendedAdapter.setFertilizers(fertilizers);
                } else {
                    recommendRecView.setVisibility(View.GONE);
                    txtEmpty.setVisibility(View.VISIBLE);
                }
            }
        }
        
        stage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stages stages = db.stageDao().getStageById(incomingActivity.getStageId());
                Intent intent = new Intent(FarmingActivity.this, StageActivity.class);
                intent.putExtra(STAGE_KEY, stages);
                startActivity(intent);
            }
        });

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
        toolbarActivity = findViewById(R.id.toolbarActivity);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        stage = findViewById(R.id.stage);
        imageActivity = findViewById(R.id.imageActivity);
        imageStage = findViewById(R.id.imageStage);
        txtNameActivity = findViewById(R.id.txtNameActivity);
        txtDescription = findViewById(R.id.txtDescription);
        txtDuration = findViewById(R.id.txtDuration);
        txtNameStage = findViewById(R.id.txtNameStage);
        txtDurationStage = findViewById(R.id.txtDurationStage);
        txtStartDate = findViewById(R.id.txtStartDate);
        txtEmpty = findViewById(R.id.txtEmpty);
        recommendRecView = findViewById(R.id.recommendRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}