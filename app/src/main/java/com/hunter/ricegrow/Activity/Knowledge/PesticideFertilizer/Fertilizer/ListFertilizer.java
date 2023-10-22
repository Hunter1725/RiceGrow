package com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hunter.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.hunter.ricegrow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;

import java.util.ArrayList;

public class ListFertilizer extends AppCompatActivity {

    private NestedScrollView nestedScrollView;
    private FloatingActionButton fabScrollToTop;
    private TextView txtEmpty;
    private RecyclerView fertilizerRecView, resultRecView;
    private SearchBar search_bar;
    private SearchView search_view;
    private FertilizerAdapter fertilizerAdapter, fertilizerAdapter2;
    private RiceGrowDatabase db;
    private ArrayList<Fertilizers> fertilizers = new ArrayList<>();
    private ArrayList<Fertilizers> fertilizers2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_list_fertilizer);

        initView();

        //Search bar
        search_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
//                finish();
            }
        });
        search_bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.search){
                    search_view.show();
                }
                return false;
            }
        });


        //Initialize adapter
        fertilizerAdapter = new FertilizerAdapter(this);
        fertilizerRecView.setAdapter(fertilizerAdapter);
        fertilizerRecView.setLayoutManager(new LinearLayoutManager(this));
        fertilizers = (ArrayList<Fertilizers>) db.fertilizerDao().getAllFertilizers();
        fertilizerAdapter.setFertilizers(fertilizers);

        //Search view
        fertilizerAdapter2 = new FertilizerAdapter(this);
        resultRecView.setAdapter(fertilizerAdapter2);
        resultRecView.setLayoutManager(new LinearLayoutManager(this));

        search_view.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String name = "%" + String.valueOf(search_view.getText()) + "%";
                fertilizers2 = (ArrayList<Fertilizers>) db.fertilizerDao().getFertilizersByName(name);
                if(fertilizers2.size()!=0){
                    resultRecView.setVisibility(View.VISIBLE);
                    fertilizerAdapter2.setFertilizers(fertilizers2);
                    txtEmpty.setVisibility(View.GONE);
                }
                else {
                    resultRecView.setVisibility(View.GONE);
                    txtEmpty.setVisibility(View.VISIBLE);
                }
                return false;
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
        fertilizerRecView = findViewById(R.id.fertilizerRecView);
        resultRecView = findViewById(R.id.resultRecView);
        search_bar = findViewById(R.id.search_bar);
        search_view = findViewById(R.id.search_view);
        txtEmpty = findViewById(R.id.txtEmpty);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        db = RiceGrowDatabase.getInstance(this);
    }
}