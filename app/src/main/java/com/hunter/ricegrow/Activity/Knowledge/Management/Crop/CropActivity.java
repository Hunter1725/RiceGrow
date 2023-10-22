package com.hunter.ricegrow.Activity.Knowledge.Management.Crop;

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
import com.hunter.ricegrow.Activity.Main.MainActivity;
import com.hunter.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.hunter.ricegrow.DatabaseFiles.Model.Crops;
import com.hunter.ricegrow.DatabaseFiles.Model.Diseases;
import com.hunter.ricegrow.DatabaseFiles.Model.Pests;
import com.hunter.ricegrow.DatabaseFiles.Model.Weeds;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class CropActivity extends AppCompatActivity {

    public static final String CROP_KEY = "incoming_crop";
    private MaterialToolbar toolbarCrop;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imageCrop;
    private TextView txtNameCrop, txtDescription, txtGrowthPeriod, txtRetailPrice, txtSaltTolerance, txtEmpty, txtEmpty2, txtEmpty3;
    private RecyclerView pestsRecView, diseasesRecView, weedsRecView;
    private TreatingAdapter pestAdapter, diseaseAdapter, weedAdapter;
    private RiceGrowDatabase db;
    private Crops incomingCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_crop);

        initView();

        toolbarCrop.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarCrop.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(CropActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        Intent intent = getIntent();
        if(intent != null){
            incomingCrop = intent.getParcelableExtra(CROP_KEY);
            if (incomingCrop != null){
                Glide.with(this)
                        .asBitmap()
                        .load(incomingCrop.getCropImage())
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
                                    int defaultColor = ContextCompat.getColor(CropActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imageCrop.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageCrop);
                txtNameCrop.setText(incomingCrop.getName());
                toolbarCrop.setTitle(incomingCrop.getName());
                if(GetCurrentLanguage.getCurrentLanguage(CropActivity.this).equals("en")) {
                    txtDescription.setText(incomingCrop.getDescriptionEn());
                } else {
                    txtDescription.setText(incomingCrop.getDescriptionVi());
                }
                String growth = getString(R.string.about) + String.valueOf(incomingCrop.getGrowthPeriod()) + getString(R.string.days);
                txtGrowthPeriod.setText(growth);
                String price = String.valueOf(incomingCrop.getSellingPrice()) + " VND/kg";
                txtRetailPrice.setText(price);
                String salt = getString(R.string.about) + String.valueOf(incomingCrop.getSaltTolerance() + "‰");
                txtSaltTolerance.setText(salt);

                pestAdapter = new TreatingAdapter(this);
                pestsRecView.setAdapter(pestAdapter);
                pestsRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Pests> pests = (ArrayList<Pests>) db.pestDao().getPestByCropId(incomingCrop.getId());
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
                ArrayList<Diseases> diseases = (ArrayList<Diseases>) db.diseaseDao().getDiseaseByCropId(incomingCrop.getId());
                if(pests != null){
                    if(pests.size() > 0){
                        diseasesRecView.setVisibility(View.VISIBLE);
                        txtEmpty2.setVisibility(View.GONE);
                        diseaseAdapter.setDiseases(diseases);
                    } else {
                        diseasesRecView.setVisibility(View.GONE);
                        txtEmpty2.setVisibility(View.VISIBLE);
                    }
                }

                weedAdapter = new TreatingAdapter(this);
                weedsRecView.setAdapter(weedAdapter);
                weedsRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Weeds> weeds = (ArrayList<Weeds>) db.weedDao().getWeedByCropId(incomingCrop.getId());
                if(pests != null){
                    if(pests.size() > 0){
                        weedsRecView.setVisibility(View.VISIBLE);
                        txtEmpty3.setVisibility(View.GONE);
                        weedAdapter.setWeeds(weeds);
                    } else {
                        weedsRecView.setVisibility(View.GONE);
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
        toolbarCrop = findViewById(R.id.toolbarCrop);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        imageCrop = findViewById(R.id.imageCrop);
        txtNameCrop = findViewById(R.id.txtNameCrop);
        txtDescription = findViewById(R.id.txtDescription);
        txtGrowthPeriod = findViewById(R.id.txtGrowthPeriod);
        txtRetailPrice = findViewById(R.id.txtRetailPrice);
        txtSaltTolerance = findViewById(R.id.txtSaltTolerance);
        txtEmpty = findViewById(R.id.txtEmpty);
        txtEmpty2 = findViewById(R.id.txtEmpty2);
        txtEmpty3 = findViewById(R.id.txtEmpty3);
        pestsRecView = findViewById(R.id.pestsRecView);
        diseasesRecView = findViewById(R.id.diseasesRecView);
        weedsRecView = findViewById(R.id.weedsRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}