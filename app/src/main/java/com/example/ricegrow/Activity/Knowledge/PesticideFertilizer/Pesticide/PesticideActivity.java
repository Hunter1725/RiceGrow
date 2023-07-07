package com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide;

import static com.example.ricegrow.Activity.Calculating.PesticideCalculating.PesticideCalculate.PESTICIDE_CALCULATE_KEY;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.widget.NestedScrollView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.ricegrow.Activity.Calculating.PesticideCalculating.PesticideCalculate;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerActivity;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.UsingAdapter;
import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.Diseases;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.Model.Weeds;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PesticideActivity extends AppCompatActivity {

    public static final String PESTICIDE_KEY = "incoming_pesticide";
    private MaterialToolbar toolbar;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imagePesticide;
    private TextView txtNamePesticide, txtCategory, txtManufacturer, txtComposition, txtInstruction, txtPesticidePerBottle, txtWaterPerHectare, txtEmpty, txtEmpty2;
    private RecyclerView treatingRecView, usingRecView;
    private TreatingAdapter treatingAdapter;
    private UsingAdapter usingAdapter;
    private RiceGrowDatabase db;
    private Pesticides incomingPesticide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_pesticide);

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
                    Intent intent = new Intent(PesticideActivity.this, PesticideCalculate.class);
                    intent.putExtra(PESTICIDE_CALCULATE_KEY, incomingPesticide);
                    startActivity(intent);
                    return true; // Return true to indicate that the event has been handled
                } else if (itemId == R.id.home) {
                    startActivity(new Intent(PesticideActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        //Treating recycler view
        Intent intent = getIntent();
        if(intent != null){
            incomingPesticide = intent.getParcelableExtra(PESTICIDE_KEY);
            if (incomingPesticide != null){
                Glide.with(this)
                        .asBitmap()
                        .load(incomingPesticide.getPesticideImage())
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
                                    int defaultColor = ContextCompat.getColor(PesticideActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imagePesticide.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imagePesticide);
                txtNamePesticide.setText(incomingPesticide.getName());
                toolbar.setTitle(incomingPesticide.getName());
                txtCategory.setText(incomingPesticide.getCategory());
                txtManufacturer.setText(incomingPesticide.getManufacturer());
                txtComposition.setText(incomingPesticide.getComposition());
                txtInstruction.setText(incomingPesticide.getUsageInstructions());
                String pesticidePer = String.valueOf(incomingPesticide.getPesticidePerBottle()) + "ml/bottle";
                txtPesticidePerBottle.setText(pesticidePer);
                String waterPerHa = String.valueOf(incomingPesticide.getWaterPerHectare() + "l/ha");
                txtWaterPerHectare.setText(waterPerHa);

                //Treating recycler view
                treatingAdapter = new TreatingAdapter(this);
                treatingRecView.setAdapter(treatingAdapter);
                treatingRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

                if(incomingPesticide.getCategory().equals("Insecticide")){
                    ArrayList<Pests> pests = (ArrayList<Pests>) db.pestDao().getPestByPesticideId(incomingPesticide.getId());
                    if(pests != null){
                        if(pests.size() > 0){
                            treatingRecView.setVisibility(View.VISIBLE);
                            txtEmpty.setVisibility(View.GONE);
                            treatingAdapter.setPests(pests);
                        } else {
                            treatingRecView.setVisibility(View.GONE);
                            txtEmpty.setVisibility(View.VISIBLE);
                        }
                    }
                } else if (incomingPesticide.getCategory().equals("Fungicide")) {
                    ArrayList<Diseases> diseases = (ArrayList<Diseases>) db.diseaseDao().getDiseaseByPesticideId(incomingPesticide.getId());
                    if(diseases != null){
                        if(diseases.size() > 0){
                            treatingRecView.setVisibility(View.VISIBLE);
                            txtEmpty.setVisibility(View.GONE);
                            treatingAdapter.setDiseases(diseases);
                        } else {
                            treatingRecView.setVisibility(View.GONE);
                            txtEmpty.setVisibility(View.VISIBLE);
                        }
                    }
                } else if (incomingPesticide.getCategory().equals("Herbicide")) {
                    ArrayList<Weeds> weeds = (ArrayList<Weeds>) db.weedDao().getWeedByPesticideId(incomingPesticide.getId());
                    if(weeds != null){
                        if(weeds.size() > 0){
                            treatingRecView.setVisibility(View.VISIBLE);
                            txtEmpty.setVisibility(View.GONE);
                            treatingAdapter.setWeeds(weeds);
                        } else {
                            treatingRecView.setVisibility(View.GONE);
                            txtEmpty.setVisibility(View.VISIBLE);
                        }
                    }
                }

                //Using recycler view
                usingAdapter = new UsingAdapter(this);
                usingRecView.setAdapter(usingAdapter);
                usingRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

                ArrayList<Activities> activities = (ArrayList<Activities>) db.activityDao().getActivitiesByPesticideId(incomingPesticide.getId());
                if(activities != null){
                    if(activities.size() > 0){
                        usingRecView.setVisibility(View.VISIBLE);
                        txtEmpty2.setVisibility(View.GONE);
                        usingAdapter.setActivities(activities);
                    }
                    else {
                        usingRecView.setVisibility(View.GONE);
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
        toolbar = findViewById(R.id.toolbarPesticide);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        imagePesticide = findViewById(R.id.imagePesticide);
        txtNamePesticide = findViewById(R.id.txtNamePesticide);
        txtCategory = findViewById(R.id.txtCategory);
        txtManufacturer = findViewById(R.id.txtManufacturer);
        txtComposition = findViewById(R.id.txtComposition);
        txtInstruction = findViewById(R.id.txtInstruction);
        txtPesticidePerBottle = findViewById(R.id.txtPesticidePerBottle);
        txtWaterPerHectare = findViewById(R.id.txtWaterPerHectare);
        txtEmpty = findViewById(R.id.txtEmpty);
        txtEmpty2 = findViewById(R.id.txtEmpty2);
        treatingRecView = findViewById(R.id.treatingRecView);
        usingRecView = findViewById(R.id.usingRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}