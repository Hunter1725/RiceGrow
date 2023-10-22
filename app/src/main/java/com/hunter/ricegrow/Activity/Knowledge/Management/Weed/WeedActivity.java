package com.hunter.ricegrow.Activity.Knowledge.Management.Weed;

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
import com.hunter.ricegrow.DatabaseFiles.Model.Weeds;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.hunter.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class WeedActivity extends AppCompatActivity {

    public static final String WEED_KEY = "incoming_weed";
    private MaterialToolbar toolbarWeed;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private ShapeableImageView imageWeed;
    private TextView txtNameWeed, txtGeographicalDistribution, txtMorphology, txtEcology, txtImpact, txtControlMethod, txtEmpty;
    private RecyclerView pesticideRecView;
    private SupAdapter pesticideAdapter;
    private RiceGrowDatabase db;
    private Weeds incomingWeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_weed);

        initView();

        toolbarWeed.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarWeed.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(WeedActivity.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        Intent intent = getIntent();
        if(intent != null) {
            incomingWeed = intent.getParcelableExtra(WEED_KEY);
            if (incomingWeed != null) {
                Glide.with(this)
                        .asBitmap()
                        .load(incomingWeed.getWeed_image())
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
                                    int defaultColor = ContextCompat.getColor(WeedActivity.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imageWeed.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageWeed);
                if(GetCurrentLanguage.getCurrentLanguage(WeedActivity.this).equals("en")) {
                    txtNameWeed.setText(incomingWeed.getNameEn());
                    toolbarWeed.setTitle(incomingWeed.getNameEn());
                    txtGeographicalDistribution.setText(incomingWeed.getGeographicalDistributionEn());
                    txtMorphology.setText(incomingWeed.getMorphologyEn());
                    txtEcology.setText(incomingWeed.getEcologyEn());
                    txtImpact.setText(incomingWeed.getImpactEn());
                    txtControlMethod.setText(incomingWeed.getControlMethodsEn());
                } else {
                    txtNameWeed.setText(incomingWeed.getNameVi());
                    toolbarWeed.setTitle(incomingWeed.getNameVi());
                    txtGeographicalDistribution.setText(incomingWeed.getGeographicalDistributionVi());
                    txtMorphology.setText(incomingWeed.getMorphologyVi());
                    txtEcology.setText(incomingWeed.getEcologyVi());
                    txtImpact.setText(incomingWeed.getImpactVi());
                    txtControlMethod.setText(incomingWeed.getControlMethodsVi());
                }

                pesticideAdapter = new SupAdapter(this);
                pesticideRecView.setAdapter(pesticideAdapter);
                pesticideRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ArrayList<Pesticides> pesticides = (ArrayList<Pesticides>) db.pesticideDao().getPesticideByWeedId(incomingWeed.getId());
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
        toolbarWeed = findViewById(R.id.toolbarWeed);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        imageWeed = findViewById(R.id.imageWeed);
        txtNameWeed = findViewById(R.id.txtNameWeed);
        txtGeographicalDistribution = findViewById(R.id.txtGeographicalDistribution);
        txtMorphology = findViewById(R.id.txtMorphology);
        txtEcology = findViewById(R.id.txtEcology);
        txtImpact = findViewById(R.id.txtImpact);
        txtControlMethod = findViewById(R.id.txtControlMethod);
        txtEmpty = findViewById(R.id.txtEmpty);
        pesticideRecView = findViewById(R.id.pesticideRecView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        db = RiceGrowDatabase.getInstance(this);
    }
}