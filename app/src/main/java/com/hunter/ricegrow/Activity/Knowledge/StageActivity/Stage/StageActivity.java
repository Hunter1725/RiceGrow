package com.hunter.ricegrow.Activity.Knowledge.StageActivity.Stage;

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
import com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.TreatingAdapter;
import com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.UsingAdapter;
import com.hunter.ricegrow.Activity.Main.MainActivity;
import com.hunter.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.hunter.ricegrow.DatabaseFiles.Model.Activities;
import com.hunter.ricegrow.DatabaseFiles.Model.CropStage;
import com.hunter.ricegrow.DatabaseFiles.Model.Crops;
import com.hunter.ricegrow.DatabaseFiles.Model.Diseases;
import com.hunter.ricegrow.DatabaseFiles.Model.Pests;
import com.hunter.ricegrow.DatabaseFiles.Model.Stages;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.hunter.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class StageActivity extends AppCompatActivity {

    public static final String STAGE_KEY = "incoming_stage";
    private MaterialToolbar toolbarStage;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imageStage;
    private TextView txtNameStage, txtDescription, txtStartDate, txtDuration, txtEndDate,txtEmpty, txtEmpty2, txtEmpty3;
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
                if(GetCurrentLanguage.getCurrentLanguage(StageActivity.this).equals("en")) {
                    txtNameStage.setText(incomingStage.getNameEn());
                    toolbarStage.setTitle(incomingStage.getNameEn());
                    txtDescription.setText(incomingStage.getDescriptionEn());
                } else {
                    txtNameStage.setText(incomingStage.getNameVi());
                    toolbarStage.setTitle(incomingStage.getNameVi());
                    txtDescription.setText(incomingStage.getDescriptionVi());
                }
                ArrayList<CropStage> cropStages = (ArrayList<CropStage>) db.cropStageDao().getCropStageByStageId(incomingStage.getId());
                int cropStageCount = cropStages.size();
                //Duration
                List<String> listDuration = new ArrayList<>();
                for (int i = 0; i < cropStageCount; i++) {
                    CropStage cropStage = cropStages.get(i);
                    Crops crop = db.cropDao().getCropById(cropStage.getCropId());
                    String cropStageString = getString(R.string.rice_variety_list) + crop.getName() + ": " + cropStage.getDuration() + getString(R.string.days);

                    // Check if it's the last item in the list
                    if (i == cropStageCount - 1) {
                        listDuration.add(cropStageString);
                    } else {
                        listDuration.add(cropStageString + "\n\n");
                    }
                }
                // Concatenate all strings in the list
                StringBuilder stringBuilder = new StringBuilder();
                for (String cropStageString : listDuration) {
                    stringBuilder.append(cropStageString);
                }
                // Set the concatenated string as the text of the TextView
                txtDuration.setText(stringBuilder.toString());

                //Start date
                List<String> listStartDate = new ArrayList<>();
                for (int i = 0; i < cropStageCount; i++) {
                    CropStage cropStage = cropStages.get(i);
                    Crops crop = db.cropDao().getCropById(cropStage.getCropId());
                    String cropStageString = "";
                    if(GetCurrentLanguage.getCurrentLanguage(StageActivity.this).equals("en")) {
                        cropStageString = getString(R.string.rice_variety_list) + crop.getName() + ": " + cropStage.getStartDate() + getString(R.string.day);
                    } else {
                        cropStageString = getString(R.string.rice_variety_list) + crop.getName() + ": Ngày thứ " + cropStage.getStartDate();
                    }
                    // Check if it's the last item in the list
                    if (i == cropStageCount - 1) {
                        listStartDate.add(cropStageString);
                    } else {
                        listStartDate.add(cropStageString + "\n\n");
                    }
                }
                // Concatenate all strings in the list
                StringBuilder stringBuilder2 = new StringBuilder();
                for (String cropStageString : listStartDate) {
                    stringBuilder2.append(cropStageString);
                }
                // Set the concatenated string as the text of the TextView
                txtStartDate.setText(stringBuilder2.toString());

                //End date
                List<String> listEndDate = new ArrayList<>();
                for (int i = 0; i < cropStageCount; i++) {
                    CropStage cropStage = cropStages.get(i);
                    Crops crop = db.cropDao().getCropById(cropStage.getCropId());
                    String cropStageString = "";
                    if(GetCurrentLanguage.getCurrentLanguage(StageActivity.this).equals("en")) {
                        cropStageString = getString(R.string.rice_variety_list) + crop.getName() + ": " + cropStage.getEndDate() + getString(R.string.day);
                    } else {
                        cropStageString = getString(R.string.rice_variety_list) + crop.getName() + ": Ngày thứ " + cropStage.getEndDate();
                    }
                    // Check if it's the last item in the list
                    if (i == cropStageCount - 1) {
                        listEndDate.add(cropStageString);
                    } else {
                        listEndDate.add(cropStageString + "\n\n");
                    }
                }
                // Concatenate all strings in the list
                StringBuilder stringBuilder3 = new StringBuilder();
                for (String cropStageString : listEndDate) {
                    stringBuilder3.append(cropStageString);
                }
                // Set the concatenated string as the text of the TextView
                txtEndDate.setText(stringBuilder3.toString());

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
        txtStartDate = findViewById(R.id.txtStartDate);
        txtDuration = findViewById(R.id.txtDuration);
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