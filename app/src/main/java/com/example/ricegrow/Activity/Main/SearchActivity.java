package com.example.ricegrow.Activity.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.WindowCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ricegrow.Activity.Knowledge.Management.Crop.CropAdapter;
import com.example.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities.DeftoxAdapter;
import com.example.ricegrow.Activity.Knowledge.Management.Disease.DiseaseAdapter;
import com.example.ricegrow.Activity.Knowledge.Management.Pest.PestAdapter;
import com.example.ricegrow.Activity.Knowledge.Management.Weed.WeedAdapter;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerAdapter;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.PesticideAdapter;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Activity.ActivityAdapter;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageAdapter;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.example.ricegrow.DatabaseFiles.Model.Diseases;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.Weeds;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private MaterialToolbar toolbarSearching;
    private SearchView searchView;
    private TextView txtEmpty;
    private RecyclerView resultRecView, resultRecView2, resultRecView3, resultRecView4, resultRecView5, resultRecView6, resultRecView7, resultRecView8, resultRecView9;
    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
    private RiceGrowDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_search);
        initView();
        searchView.requestFocus();
        setSupportActionBar(toolbarSearching);
        toolbarSearching.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
//                finish();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty()){
                    resultRecView.setVisibility(View.GONE);
                    resultRecView2.setVisibility(View.GONE);
                    resultRecView3.setVisibility(View.GONE);
                    resultRecView4.setVisibility(View.GONE);
                    resultRecView5.setVisibility(View.GONE);
                    resultRecView6.setVisibility(View.GONE);
                    resultRecView7.setVisibility(View.GONE);
                    resultRecView8.setVisibility(View.GONE);
                    resultRecView9.setVisibility(View.GONE);
                } else {
                    String name = "%" + newText + "%";

                    setRecyclerViewWithAdapter(db.stageDao().getStagesByName(name), resultRecView, new StageAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.activityDao().getActivitiesByName(name), resultRecView2, new ActivityAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.pesticideDao().getPesticidesByName(name), resultRecView3, new PesticideAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.fertilizerDao().getFertilizersByName(name), resultRecView4, new FertilizerAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.cropDao().getCropsByName(name), resultRecView5, new CropAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.diseaseDao().getDiseasesByName(name), resultRecView6, new DiseaseAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.pestDao().getPestsByName(name), resultRecView7, new PestAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.weedDao().getWeedsByName(name), resultRecView8, new WeedAdapter(SearchActivity.this));
                    setRecyclerViewWithAdapter(db.deficienciesToxicitiesDao().getDeftoxByName(name), resultRecView9, new DeftoxAdapter(SearchActivity.this));

                }
                return false;
            }
        });
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    toolbarSearching.setNavigationIcon(null);
                } else {
                    toolbarSearching.setNavigationIcon(R.drawable.back);
                    searchView.setIconifiedByDefault(true);
                }
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

    private <T> void setRecyclerViewWithAdapter(List<T> dataList, RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        if (!dataList.isEmpty()) {
            recyclerView.setVisibility(View.VISIBLE);
            txtEmpty.setVisibility(View.GONE);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
            if (adapter instanceof StageAdapter) {
                ((StageAdapter) adapter).setStages((ArrayList<Stages>) dataList);
            } else if (adapter instanceof ActivityAdapter) {
                ((ActivityAdapter) adapter).setActivities((ArrayList<Activities>) dataList);
            } else if (adapter instanceof PesticideAdapter) {
                ((PesticideAdapter) adapter).setPesticides((ArrayList<Pesticides>) dataList);
            } else if (adapter instanceof FertilizerAdapter) {
                ((FertilizerAdapter) adapter).setFertilizers((ArrayList<Fertilizers>) dataList);
            } else if (adapter instanceof CropAdapter) {
                ((CropAdapter) adapter).setCrops((ArrayList<Crops>) dataList);
            } else if (adapter instanceof DiseaseAdapter) {
                ((DiseaseAdapter) adapter).setDiseases((ArrayList<Diseases>) dataList);
            } else if (adapter instanceof PestAdapter) {
                ((PestAdapter) adapter).setPests((ArrayList<Pests>) dataList);
            } else if (adapter instanceof WeedAdapter) {
                ((WeedAdapter) adapter).setWeeds((ArrayList<Weeds>) dataList);
            } else if (adapter instanceof DeftoxAdapter) {
                ((DeftoxAdapter) adapter).setDeficienciesToxicities((ArrayList<DeficienciesToxicities>) dataList);
            }
        } else {
            recyclerView.setVisibility(View.GONE);
        }

        if (resultRecView.getVisibility() == View.VISIBLE ||
                resultRecView2.getVisibility() == View.VISIBLE ||
                resultRecView3.getVisibility() == View.VISIBLE ||
                resultRecView4.getVisibility() == View.VISIBLE ||
                resultRecView5.getVisibility() == View.VISIBLE ||
                resultRecView6.getVisibility() == View.VISIBLE ||
                resultRecView7.getVisibility() == View.VISIBLE ||
                resultRecView8.getVisibility() == View.VISIBLE ||
                resultRecView9.getVisibility() == View.VISIBLE) {
            txtEmpty.setVisibility(View.GONE);
        } else {
            txtEmpty.setVisibility(View.VISIBLE);
        }
    }

    private void initView() {
        toolbarSearching = findViewById(R.id.toolbarSearching);
        searchView = findViewById(R.id.searchView);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        txtEmpty = findViewById(R.id.txtEmpty);
        resultRecView = findViewById(R.id.resultRecView);
        resultRecView2 = findViewById(R.id.resultRecView2);
        resultRecView3 = findViewById(R.id.resultRecView3);
        resultRecView4 = findViewById(R.id.resultRecView4);
        resultRecView5 = findViewById(R.id.resultRecView5);
        resultRecView6 = findViewById(R.id.resultRecView6);
        resultRecView7 = findViewById(R.id.resultRecView7);
        resultRecView8 = findViewById(R.id.resultRecView8);
        resultRecView9 = findViewById(R.id.resultRecView9);
        db = RiceGrowDatabase.getInstance(this);
    }
}