package com.example.ricegrow.Activity.Planning.Plan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PlanGenerate extends AppCompatActivity {

    private MaterialToolbar toolbarPlanning;
    private Button btnDecrease, btnIncrease,btnGenerate;
    private AutoCompleteTextView categoryAutoCompleteTextView;
    private RadioGroup radioGroup;
    private RadioButton btnMeter, btnHectare;
    private TextInputEditText editTextDate, fieldAreaEditText;
    private TextInputLayout textInputLayoutDate, fieldAreaInputLayout, categoryDropdown;
    private CircularProgressIndicator progressCalculate;
    private MaterialDatePicker<Long> datePicker;
    private RiceGrowDatabase db;
    private String riceVariety = "";
    private LocalDate sowingDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_plan_generate);

        initView();

        if(fieldAreaEditText.getText().toString().isEmpty()){
            btnGenerate.setEnabled(false);
            btnGenerate.setBackgroundColor(Color.parseColor("#8C8C8C"));
        }


        toolbarPlanning.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarPlanning.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(PlanGenerate.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        initializeDatePicker();


        fieldAreaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = fieldAreaEditText.getText().toString();
                boolean isInputValid = !input.isEmpty() && !input.matches("0*(\\.0*)?");

                btnGenerate.setEnabled(isInputValid);
                btnGenerate.setBackgroundColor(isInputValid ? Color.parseColor("#4CAF50") : Color.parseColor("#8C8C8C"));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double area = 0.0;
                if (fieldAreaInputLayout.getSuffixText().equals("ha")) {
                    if (fieldAreaEditText.getText().toString().equals("")) {
                        area = 0.5;
                        fieldAreaEditText.setText(String.valueOf(area));
                    } else {
                        area = Double.valueOf(String.valueOf(fieldAreaEditText.getText()));
                        if ((area - 0.5) <= 0) {
                            fieldAreaInputLayout.setError("Must be greater than 0");
                        } else {
                            area -= 0.5;
                            fieldAreaEditText.setText(String.valueOf(area));
                        }
                    }
                } else if (fieldAreaInputLayout.getSuffixText().equals("m²")) {
                    if (fieldAreaEditText.getText().toString().equals("")) {
                        area = 500.0;
                        fieldAreaEditText.setText(String.valueOf(area));
                    } else {
                        area = Double.valueOf(String.valueOf(fieldAreaEditText.getText()));
                        if ((area - 500.0) <= 0) {
                            fieldAreaInputLayout.setError("Must be greater than 0");
                        } else {
                            area -= 500;
                            fieldAreaEditText.setText(String.valueOf(area));
                        }
                    }
                }
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double area = 0.0;
                if (fieldAreaInputLayout.getSuffixText().equals("ha")) {
                    if (fieldAreaEditText.getText().toString().equals("")) {
                        area = 0.5;
                        fieldAreaEditText.setText(String.valueOf(area));
                    } else {
                        fieldAreaInputLayout.setError(null);
                        area = Double.valueOf(String.valueOf(fieldAreaEditText.getText()));
                        area += 0.5;
                        fieldAreaEditText.setText(String.valueOf(area));
                    }
                } else if (fieldAreaInputLayout.getSuffixText().equals("m²")) {
                    if (fieldAreaEditText.getText().toString().equals("")) {
                        area = 500.0;
                        fieldAreaEditText.setText(String.valueOf(area));
                    } else {
                        fieldAreaInputLayout.setError(null);
                        area = Double.valueOf(String.valueOf(fieldAreaEditText.getText()));
                        area += 500.0;
                        fieldAreaEditText.setText(String.valueOf(area));
                    }
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.btnMeter){
                    fieldAreaInputLayout.setSuffixText("m²");
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        String area = String.valueOf(Double.parseDouble(fieldAreaEditText.getText().toString())*10000.0);
                        fieldAreaEditText.setText(area);
                    }
                } else if (checkedId == R.id.btnHectare) {
                    fieldAreaInputLayout.setSuffixText("ha");
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        String area = String.valueOf(Double.parseDouble(fieldAreaEditText.getText().toString())/10000.0);
                        fieldAreaEditText.setText(area);
                    }
                }
            }
        });

        //Drop down menu
        initDropDownMenu();

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generating();
            }
        });
    }

    private void initDropDownMenu() {
        // Create an ArrayAdapter with the menu items
        ArrayList<Crops> crops = (ArrayList<Crops>) db.cropDao().getAllCrops();
        ArrayList<String> customArray = new ArrayList<>();
        for(Crops crop : crops){
            customArray.add(crop.getName());
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
                riceVariety = (String) parent.getItemAtPosition(position);
            }
        });
    }

    private void generating() {
        if(editTextDate.getText().toString().isEmpty()){
            textInputLayoutDate.setError("Please select the sowing date!");
        } else if (riceVariety.isEmpty()) {
            categoryDropdown.setError("Please select the rice variety!");
        } else {
            progressCalculate.setVisibility(View.VISIBLE);
            double area = Double.parseDouble(fieldAreaEditText.getText().toString());
            if (fieldAreaInputLayout.getSuffixText().equals("m²")){
                area = area/10000;
            }
            String dateString = editTextDate.getText().toString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.getDefault());
            try {
                sowingDate = LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }

            Crops crop = db.cropDao().getCropById(db.cropDao().getIdByName(riceVariety));

            //Amount of sowing
            double sowingAmount = 120.0 * area;
            LocalDate expectedHarvestDate = sowingDate.plusDays(crop.getGrowthPeriod() + 26);
            db.userCropDao().insert(new UserCrops(crop.getId(), sowingAmount, sowingDate, area, expectedHarvestDate, crop.getGrowthPeriod()));



            progressCalculate.setVisibility(View.GONE);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("showFragment", "planFragment"); // Pass a unique identifier for the fragment
            startActivity(intent);
        }
    }

    private void initializeDatePicker() {
        // Initialize the date picker
        datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setTheme(R.style.ThemeOverlay_App_DatePicker)
                .build();

        // Set the click listener for the date picker icon
        textInputLayoutDate.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the date picker dialog
                datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        editTextDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editTextDate.setHint("mm/dd/yyyy");
                } else {
                    editTextDate.setHint(null);
                }
            }
        });

        // Set the date selection listener
        datePicker.addOnPositiveButtonClickListener(selection -> {
            // Convert the selected date to a formatted string
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
            String selectedDate = dateFormat.format(new Date(selection));

            // Set the selected date in the TextInputEditText
            editTextDate.setText(selectedDate);
        });
    }

    private void initView() {
        editTextDate = findViewById(R.id.editTextDate);
        textInputLayoutDate = findViewById(R.id.textInputLayoutDate);
        toolbarPlanning = findViewById(R.id.toolbarPlanning);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnGenerate = findViewById(R.id.btnGenerate);
        categoryAutoCompleteTextView = findViewById(R.id.categoryAutoCompleteTextView);
        radioGroup = findViewById(R.id.radioGroup);
        btnMeter = findViewById(R.id.btnMeter);
        btnHectare = findViewById(R.id.btnHectare);
        fieldAreaEditText = findViewById(R.id.fieldAreaEditText);
        fieldAreaInputLayout = findViewById(R.id.fieldAreaInputLayout);
        categoryDropdown = findViewById(R.id.categoryDropdown);
        progressCalculate = findViewById(R.id.progressCalculate);
        fieldAreaInputLayout.setSuffixText("ha");
        db = RiceGrowDatabase.getInstance(this);
    }
}