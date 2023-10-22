package com.hunter.ricegrow.Activity.Knowledge.Management.Pest;

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
import com.hunter.ricegrow.DatabaseFiles.Model.Pesticides;
import com.hunter.ricegrow.DatabaseFiles.Model.Pests;
import com.hunter.ricegrow.DatabaseFiles.Model.Stages;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.hunter.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PestActivity extends AppCompatActivity {

    public static final String PEST_KEY = "incoming_pest";
    private MaterialToolbar toolbarPest;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imagePest;
    private TextView txtNamePest, txtScienceName, txtLifecycle, txtSymptom, txtDescription, txtControlMethod, txtEmpty, txtEmpty2;
    private RecyclerView pesticideRecView, stagesRecView;
    private SupAdapter pesticideAdapter, stagesAdapter;
    private RiceGrowDatabase db;
    private Pests incomingPest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_pest);

        initView();

        toolbarPest.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarPest.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(PestActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        Intent intent = getIntent();
        if(intent != null) {
            incomingPest = intent.getParcelableExtra(PEST_KEY);
            if (incomingPest != null) {
                Glide.with(this)
                        .asBitmap()
                        .load(incomingPest.getPestImage())
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
                                    int defaultColor = ContextCompat.getColor(PestActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imagePest.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imagePest);
                if(GetCurrentLanguage.getCurrentLanguage(PestActivity.this).equals("en")) {
                    txtNamePest.setText(incomingPest.getNameEn());
                    txtScienceName.setText(incomingPest.getScienceNameEn());
                    toolbarPest.setTitle(incomingPest.getNameEn());
                    txtLifecycle.setText(incomingPest.getLifecycleEn());
                    txtDescription.setText(incomingPest.getDescriptionEn());
                    txtSymptom.setText(incomingPest.getSymptomsEn());
                    txtControlMethod.setText(incomingPest.getControlMethodsEn());
                } else {
                    txtNamePest.setText(incomingPest.getNameVi());
                    txtScienceName.setText(incomingPest.getScienceNameVi());
                    toolbarPest.setTitle(incomingPest.getNameVi());
                    txtLifecycle.setText(incomingPest.getLifecycleVi());
                    txtDescription.setText(incomingPest.getDescriptionVi());
                    txtSymptom.setText(incomingPest.getSymptomsVi());
                    txtControlMethod.setText(incomingPest.getControlMethodsVi());
                }


                pesticideAdapter = new SupAdapter(this);
                pesticideRecView.setAdapter(pesticideAdapter);
                pesticideRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Pesticides> pesticides = (ArrayList<Pesticides>) db.pesticideDao().getPesticideByPestId(incomingPest.getId());
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
                ArrayList<Stages> stages = (ArrayList<Stages>) db.stageDao().getStagesByPestId(incomingPest.getId());
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
        toolbarPest = findViewById(R.id.toolbarPest);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        imagePest = findViewById(R.id.imagePest);
        txtNamePest = findViewById(R.id.txtNamePest);
        txtScienceName = findViewById(R.id.txtScienceName);
        txtLifecycle = findViewById(R.id.txtLifecycle);
        txtSymptom = findViewById(R.id.txtSymptom);
        txtDescription = findViewById(R.id.txtDescription);
        txtControlMethod = findViewById(R.id.txtControlMethod);
        txtEmpty = findViewById(R.id.txtEmpty);
        txtEmpty2 = findViewById(R.id.txtEmpty2);
        pesticideRecView = findViewById(R.id.pesticideRecView);
        stagesRecView = findViewById(R.id.stagesRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}