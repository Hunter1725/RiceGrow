package com.hunter.ricegrow.Activity.Knowledge.Management.Disease;

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
import com.hunter.ricegrow.Activity.Knowledge.Management.SupAdapter;
import com.hunter.ricegrow.Activity.Main.MainActivity;
import com.hunter.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.hunter.ricegrow.DatabaseFiles.Model.Diseases;
import com.hunter.ricegrow.DatabaseFiles.Model.Pesticides;
import com.hunter.ricegrow.DatabaseFiles.Model.Stages;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class DiseaseActivity extends AppCompatActivity {

    public static final String DISEASE_KEY = "incoming_disease";
    private MaterialToolbar toolbarDisease;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imageDisease;
    private TextView txtNameDisease, txtSymptom, txtDescription, txtPreventionMethod, txtEmpty, txtEmpty2;
    private RecyclerView pesticideRecView, stagesRecView;
    private SupAdapter pesticideAdapter, stagesAdapter;
    private RiceGrowDatabase db;
    private Diseases incomingDisease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_disease);

        initView();

        toolbarDisease.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarDisease.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(DiseaseActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        Intent intent = getIntent();
        if(intent != null) {
            incomingDisease = intent.getParcelableExtra(DISEASE_KEY);
            if (incomingDisease != null) {
                Glide.with(this)
                        .asBitmap()
                        .load(incomingDisease.getDiseaseImage())
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
                                    int defaultColor = ContextCompat.getColor(DiseaseActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imageDisease.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageDisease);
                if(GetCurrentLanguage.getCurrentLanguage(DiseaseActivity.this).equals("en")) {
                    txtNameDisease.setText(incomingDisease.getNameEn());
                    toolbarDisease.setTitle(incomingDisease.getNameEn());
                    txtDescription.setText(incomingDisease.getDescriptionEn());
                    txtSymptom.setText(incomingDisease.getSymptomsEn());
                    txtPreventionMethod.setText(incomingDisease.getPreventionMethodsEn());
                } else {
                    txtNameDisease.setText(incomingDisease.getNameVi());
                    toolbarDisease.setTitle(incomingDisease.getNameVi());
                    txtDescription.setText(incomingDisease.getDescriptionVi());
                    txtSymptom.setText(incomingDisease.getSymptomsVi());
                    txtPreventionMethod.setText(incomingDisease.getPreventionMethodsVi());
                }

                pesticideAdapter = new SupAdapter(this);
                pesticideRecView.setAdapter(pesticideAdapter);
                pesticideRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Pesticides> pesticides = (ArrayList<Pesticides>) db.pesticideDao().getPesticideByDiseaseId(incomingDisease.getId());
                if (pesticides != null) {
                    if (pesticides.size() > 0) {
                        pesticideRecView.setVisibility(View.VISIBLE);
                        txtEmpty.setVisibility(View.GONE);
                        pesticideAdapter.setPesticides(pesticides);
                    } else {
                        pesticideRecView.setVisibility(View.GONE);
                        txtEmpty.setVisibility(View.VISIBLE);
                    }
                }

                stagesAdapter = new SupAdapter(this);
                stagesRecView.setAdapter(stagesAdapter);
                stagesRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Stages> stages = (ArrayList<Stages>) db.stageDao().getStagesByDiseaseId(incomingDisease.getId());
                if (stages != null) {
                    if (stages.size() > 0) {
                        stagesRecView.setVisibility(View.VISIBLE);
                        txtEmpty2.setVisibility(View.GONE);
                        stagesAdapter.setStages(stages);
                    } else {
                        stagesRecView.setVisibility(View.GONE);
                        txtEmpty2.setVisibility(View.VISIBLE);
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
        toolbarDisease = findViewById(R.id.toolbarDisease);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        imageDisease = findViewById(R.id.imageDisease);
        txtNameDisease = findViewById(R.id.txtNameDisease);
        txtSymptom = findViewById(R.id.txtSymptom);
        txtDescription = findViewById(R.id.txtDescription);
        txtPreventionMethod = findViewById(R.id.txtPreventionMethod);
        txtEmpty = findViewById(R.id.txtEmpty);
        txtEmpty2 = findViewById(R.id.txtEmpty2);
        pesticideRecView = findViewById(R.id.pesticideRecView);
        stagesRecView = findViewById(R.id.stagesRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}