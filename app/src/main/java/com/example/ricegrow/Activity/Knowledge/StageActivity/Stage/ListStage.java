package com.example.ricegrow.Activity.Knowledge.StageActivity.Stage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerAdapter;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class ListStage extends AppCompatActivity {

    private NestedScrollView nestedScrollView;
    private FloatingActionButton fabScrollToTop;
    private TextView txtEmpty, txtEmpty2;
    private TextInputLayout riceDropdown;
    private AutoCompleteTextView riceAutoCompleteTextView;
    private RecyclerView stageRecView, resultRecView;
    private SearchBar search_bar;
    private SearchView search_view;
    private StageAdapter stageAdapter, stageAdapter2;
    private RiceGrowDatabase db;
    private ArrayList<Stages> stages = new ArrayList<>();
    private ArrayList<Stages> stages2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_list_stage);

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
        stageAdapter = new StageAdapter(this);
        stageRecView.setAdapter(stageAdapter);
        stageRecView.setLayoutManager(new LinearLayoutManager(this));
        stages = (ArrayList<Stages>) db.stageDao().getAllStagesByCropId(db.cropDao().getIdByName("OM18"));
        if(stages.size() > 0){
            stageRecView.setVisibility(View.VISIBLE);
            txtEmpty2.setVisibility(View.GONE);
            stageAdapter.setStages(stages);
        } else {
            stageRecView.setVisibility(View.GONE);
            txtEmpty2.setVisibility(View.VISIBLE);
        }

        //Search view
        stageAdapter2 = new StageAdapter(this);
        resultRecView.setAdapter(stageAdapter2);
        resultRecView.setLayoutManager(new LinearLayoutManager(this));

        search_view.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String name = "%" + String.valueOf(search_view.getText()) + "%";
                stages2 = (ArrayList<Stages>) db.stageDao().getStagesByName(name);
                if(stages2.size()!=0){
                    resultRecView.setVisibility(View.VISIBLE);
                    stageAdapter2.setStages(stages2);
                    txtEmpty.setVisibility(View.GONE);
                }
                else {
                    resultRecView.setVisibility(View.GONE);
                    txtEmpty.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        //Drop down menu
        // Create an ArrayAdapter with the menu items
        List<String> riceVarieties = db.cropDao().getAllCropNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.pesticide_dropdown_menu, riceVarieties);

        // Set the adapter to the AutoCompleteTextView
        riceAutoCompleteTextView.setAdapter(adapter);
        riceAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected category
                String selectedCategory = (String) parent.getItemAtPosition(position);
                // Handle the selected category
                if (selectedCategory.equals("OM18")) {
                    stages = (ArrayList<Stages>) db.stageDao().getAllStagesByCropId(db.cropDao().getIdByName("OM18"));
                    if(stages.size() > 0){
                        stageRecView.setVisibility(View.VISIBLE);
                        txtEmpty2.setVisibility(View.GONE);
                        stageAdapter.setStages(stages);
                    } else {
                        stageRecView.setVisibility(View.GONE);
                        txtEmpty2.setVisibility(View.VISIBLE);
                    }
                } else if (selectedCategory.equals("DT08")) {
                    stages = (ArrayList<Stages>) db.stageDao().getAllStagesByCropId(db.cropDao().getIdByName(selectedCategory));
                    if(stages.size() > 0){
                        stageRecView.setVisibility(View.VISIBLE);
                        txtEmpty2.setVisibility(View.GONE);
                        stageAdapter.setStages(stages);
                    } else {
                        stageRecView.setVisibility(View.GONE);
                        txtEmpty2.setVisibility(View.VISIBLE);
                    }
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

    private void initView() {
        riceDropdown = findViewById(R.id.riceDropdown);
        riceAutoCompleteTextView = findViewById(R.id.riceAutoCompleteTextView);
        stageRecView = findViewById(R.id.stageRecView);
        resultRecView = findViewById(R.id.resultRecView);
        search_bar = findViewById(R.id.search_bar);
        search_view = findViewById(R.id.search_view);
        txtEmpty = findViewById(R.id.txtEmpty);
        txtEmpty2 = findViewById(R.id.txtEmpty2);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        db = RiceGrowDatabase.getInstance(this);
    }
}