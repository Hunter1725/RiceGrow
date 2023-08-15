package com.example.ricegrow.Activity.Calculating.PesticideCalculating;

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

import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.PesticideAdapter;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class SelectPesticide extends AppCompatActivity {

    private NestedScrollView nestedScrollView;
    private FloatingActionButton fabScrollToTop;
    private TextView txtEmpty;
    private TextInputLayout categoryDropdown;
    private AutoCompleteTextView categoryAutoCompleteTextView;
    private RecyclerView pesticideRecView, resultRecView;
    private SearchBar search_bar;
    private SearchView search_view;
    private PesticideCalculateAdapter pesticideAdapter, pesticideAdapter2;
    private RiceGrowDatabase db;
    private ArrayList<Pesticides> pesticides = new ArrayList<>();
    private ArrayList<Pesticides> pesticides2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_select_pesticide);

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
        pesticideAdapter = new PesticideCalculateAdapter(this);
        pesticideRecView.setAdapter(pesticideAdapter);
        pesticideRecView.setLayoutManager(new LinearLayoutManager(this));
        pesticides = (ArrayList<Pesticides>) db.pesticideDao().getAllPesticides();
        pesticideAdapter.setPesticides(pesticides);

        //Search view
        pesticideAdapter2 = new PesticideCalculateAdapter(this);
        resultRecView.setAdapter(pesticideAdapter2);
        resultRecView.setLayoutManager(new LinearLayoutManager(this));

        search_view.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String name = "%" + String.valueOf(search_view.getText()) + "%";
                pesticides2 = (ArrayList<Pesticides>) db.pesticideDao().getPesticidesByName(name);
                if(pesticides2.size()!=0){
                    resultRecView.setVisibility(View.VISIBLE);
                    pesticideAdapter2.setPesticides(pesticides2);
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
        ArrayList<String> customArray = new ArrayList<>();
        customArray.add(getString(R.string.all));

        for (Pesticides pesticide : pesticides) {
            String category = pesticide.getCategory();
            if (!customArray.contains(category)) {
                customArray.add(category);
            }
        }

        // Create the ArrayAdapter using the custom array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.pesticide_dropdown_menu, customArray);
        // Set the adapter to the AutoCompleteTextView
        categoryAutoCompleteTextView.setAdapter(adapter);
        categoryAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected category
                String selectedCategory = (String) parent.getItemAtPosition(position);
                // Handle the selected category
                if (selectedCategory.equals(getString(R.string.all))) {
                    pesticideAdapter.setPesticides(pesticides);
                } else {
                    pesticideAdapter.setPesticides((ArrayList<Pesticides>) db.pesticideDao().getPesticidesByCate(selectedCategory));
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
        categoryDropdown = findViewById(R.id.categoryDropdown);
        categoryAutoCompleteTextView = findViewById(R.id.categoryAutoCompleteTextView);
        pesticideRecView = findViewById(R.id.pesticideRecView);
        resultRecView = findViewById(R.id.resultRecView);
        search_bar = findViewById(R.id.search_bar);
        search_view = findViewById(R.id.search_view);
        txtEmpty = findViewById(R.id.txtEmpty);
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        db = RiceGrowDatabase.getInstance(this);
    }
}