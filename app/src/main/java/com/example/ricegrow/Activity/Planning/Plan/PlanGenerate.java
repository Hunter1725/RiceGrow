package com.example.ricegrow.Activity.Planning.Plan;

import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.Activity.Setting.ContextWrapper;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.CropStage;
import com.example.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.checkbox.MaterialCheckBox;
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
import java.util.List;
import java.util.Locale;

public class PlanGenerate extends AppCompatActivity {

    public static final String SHOW_FRAGMENT = "showFragment";
    private MaterialToolbar toolbarPlanning;
    private Button btnDecrease, btnIncrease, btnGenerate, btnColorPicker;
    private AutoCompleteTextView categoryAutoCompleteTextView;
    private RadioGroup radioGroup;
    private RadioButton btnMeter, btnHectare;
    private TextInputEditText editTextDate, fieldAreaEditText, edtName;
    private TextInputLayout textInputLayoutDate, fieldAreaInputLayout, categoryDropdown, textInputLayoutName;
    private CircularProgressIndicator progressCalculate;
    private MaterialDatePicker<Long> datePicker;
    private RiceGrowDatabase db;
    private String riceVariety = "";
    private LocalDate startingDate;
    private MaterialCheckBox checkBoxHideShowStages, checkBoxSelectAll;
    private RecyclerView recyclerViewStages;
    private StageCheckboxAdapter stageCheckboxAdapter;
    private TextView txtWarningStage;
    private View colorLayout;
    private int selectedColor = Color.TRANSPARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_plan_generate);

        initView();

        if (fieldAreaEditText.getText().toString().isEmpty()) {
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

        initSelectStage();

        checkBoxHideShowStages.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Toggle the visibility of the RecyclerView based on the checkbox state
            recyclerViewStages.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            checkBoxSelectAll.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        // Set up the "Select All" checkbox listener
        checkBoxSelectAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update the selection state of all stages in the RecyclerView
            stageCheckboxAdapter.selectAllStages(isChecked);
        });

        btnColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the color picker dialog
                showColorPickerDialog();
            }
        });

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
                            fieldAreaInputLayout.setError(getString(R.string.must_be_greater_than_0));
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
                            fieldAreaInputLayout.setError(getString(R.string.must_be_greater_than_0));
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
                if (checkedId == R.id.btnMeter) {
                    fieldAreaInputLayout.setSuffixText("m²");
                    if (!fieldAreaEditText.getText().toString().equals("")) {
                        String area = String.valueOf(Double.parseDouble(fieldAreaEditText.getText().toString()) * 10000.0);
                        fieldAreaEditText.setText(area);
                    }
                } else if (checkedId == R.id.btnHectare) {
                    fieldAreaInputLayout.setSuffixText("ha");
                    if (!fieldAreaEditText.getText().toString().equals("")) {
                        String area = String.valueOf(Double.parseDouble(fieldAreaEditText.getText().toString()) / 10000.0);
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

    private void showColorPickerDialog() {
        ColorPickerDialog.show(this, color -> {
            // Save the selected color and update UI if needed
            selectedColor = color;
            colorLayout.setBackgroundColor(selectedColor);
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        RiceGrowDatabase db = RiceGrowDatabase.getInstance(this);
        String lng = db.settingDao().getAll().getLanguage();
        Locale locale;
        locale = new Locale(lng);
        Locale.setDefault(locale);

        Context context = ContextWrapper.wrap(newBase, locale);
        super.attachBaseContext(context);
    }

    private void initSelectStage() {
        stageCheckboxAdapter = new StageCheckboxAdapter(PlanGenerate.this);
        recyclerViewStages.setAdapter(stageCheckboxAdapter);
        recyclerViewStages.setLayoutManager(new LinearLayoutManager(PlanGenerate.this));
        List<Stages> stagesList = db.stageDao().getAllStagesWithOrder();
        stageCheckboxAdapter.setStages(stagesList);
    }

    private void initDropDownMenu() {
        // Create an ArrayAdapter with the menu items
        ArrayList<Crops> crops = (ArrayList<Crops>) db.cropDao().getAllCrops();
        ArrayList<String> customArray = new ArrayList<>();
        for (Crops crop : crops) {
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
        if (edtName.getText().toString().isEmpty()){
            textInputLayoutName.setError(getString(R.string.please_enter_the_plan_name));
            Toast.makeText(this, getString(R.string.please_enter_the_plan_name), Toast.LENGTH_SHORT).show();
        }
        else if (editTextDate.getText().toString().isEmpty()) {
            textInputLayoutDate.setError(getString(R.string.please_select_the_sowing_date));
            Toast.makeText(this, getString(R.string.please_select_the_sowing_date), Toast.LENGTH_SHORT).show();
        } else if (stageCheckboxAdapter.getSelectedStageIds().isEmpty()) {
            txtWarningStage.setVisibility(View.VISIBLE);
            Toast.makeText(this, getString(R.string.please_select_at_least_one_stage), Toast.LENGTH_SHORT).show();
        } else if (riceVariety.isEmpty()) {
            categoryDropdown.setError(getString(R.string.please_select_the_rice_variety));
            Toast.makeText(this, getString(R.string.please_select_the_rice_variety), Toast.LENGTH_SHORT).show();
        }  else {
            txtWarningStage.setVisibility(View.GONE);
            progressCalculate.setVisibility(View.VISIBLE);
            double area = Double.parseDouble(fieldAreaEditText.getText().toString());
            if (fieldAreaInputLayout.getSuffixText().equals("m²")) {
                area = area / 10000;
            }
            String dateString = editTextDate.getText().toString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.getDefault());
            try {
                startingDate = LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }

            Crops crop = db.cropDao().getCropById(db.cropDao().getIdByName(riceVariety));

            //Amount of sowing
            double sowingAmount = 120.0 * area;
            LocalDate expectedHarvestDate = startingDate.plusDays(crop.getGrowthPeriod() + 26);
            int firstStage = stageCheckboxAdapter.getSelectedStageIds().get(0);
            while (firstStage > 1){
                int minusDay = db.cropStageDao().getCropStageByStageIdAndCropId(firstStage-1, crop.getId()).getDuration();
                expectedHarvestDate = expectedHarvestDate.minusDays(minusDay);
                firstStage--;
            }
            int idUserCrop = (int) db.userCropDao().insert(new UserCrops(crop.getId(), edtName.getText().toString(), selectedColor, sowingAmount, startingDate, area, expectedHarvestDate, crop.getGrowthPeriod(), stageCheckboxAdapter.getSelectedStageIds()));
            UserCrops incomingUserCrops = db.userCropDao().getUserCropsById(idUserCrop);
            //Create plan stages
            if (db.planStageDao().getAllPlanStageByUserCropId(incomingUserCrops.getId()).isEmpty()) {
                createPlan(incomingUserCrops);
            }
            progressCalculate.setVisibility(View.GONE);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(SHOW_FRAGMENT, "planFragment"); // Pass a unique identifier for the fragment
            startActivity(intent);
        }
    }
    private void createPlanActivities(PlanStages planStages, int stageId, LocalDate startDate, LocalDate endDate) {
        Stages stages = db.stageDao().getStageById(stageId);
        List<Activities> activities = db.activityDao().getActivitiesByStageId(stages.getId());
        LocalDate endDatePlanStage = null;

        for (Activities activity : activities) {
            if (endDatePlanStage == null) {
                endDatePlanStage = startDate.plusDays(activity.getDuration());
                db.planActivityDao().insert(new PlanActivities(planStages.getId(), activity.getId(), startDate, endDatePlanStage));
            } else {
                db.planActivityDao().insert(new PlanActivities(planStages.getId(), activity.getId(), endDatePlanStage, endDatePlanStage.plusDays(activity.getDuration())));
                endDatePlanStage = endDatePlanStage.plusDays(activity.getDuration());
            }
        }
    }

    private void createPlanStages(UserCrops incomingUserCrops, int stageId, LocalDate startDate, LocalDate endDate) {
        int idPlanStage = (int) db.planStageDao().insert(new PlanStages(incomingUserCrops.getId(), stageId, startDate, endDate));
        PlanStages planStage = db.planStageDao().getPlanStagesById(idPlanStage);
        if (db.planActivityDao().getAllPlanActivitiesByPlanStageId(planStage.getId()).isEmpty()) {
            createPlanActivities(planStage, stageId, startDate, endDate);
        }
    }

    private void createPlan(UserCrops incomingUserCrops) {
        List<Integer> idStage = stageCheckboxAdapter.getSelectedStageIds();
        LocalDate endDate = null;

        for (int index = 0; index < idStage.size(); index++) {
            Integer i = idStage.get(index);
            CropStage cropStage = db.cropStageDao().getCropStageByStageIdAndCropId(i, incomingUserCrops.getCropId());

            if (endDate == null) {
                endDate = incomingUserCrops.getStartingDate().plusDays(cropStage.getDuration());
                createPlanStages(incomingUserCrops, i, incomingUserCrops.getStartingDate(), endDate);
            } else {
                // Check the gap between stages
                if (i - idStage.get(index - 1) > 1) {
                    int space = i - idStage.get(index - 1);
                    int s = idStage.get(index - 1);
                    while (space > 1) {
                        s++;
                        CropStage cropStageSpace = db.cropStageDao().getCropStageByStageIdAndCropId(s, incomingUserCrops.getCropId());
                        endDate = endDate.plusDays(cropStageSpace.getDuration());
                        space--;
                    }
                }
                createPlanStages(incomingUserCrops, i, endDate, endDate.plusDays(cropStage.getDuration()));
                endDate = endDate.plusDays(cropStage.getDuration());
            }
        }
    }

    private void initializeDatePicker() {
        // Initialize the date picker
        datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText(getString(R.string.select_date))
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
                    datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
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
        txtWarningStage = findViewById(R.id.txtWarningStage);
        fieldAreaEditText = findViewById(R.id.fieldAreaEditText);
        fieldAreaInputLayout = findViewById(R.id.fieldAreaInputLayout);
        categoryDropdown = findViewById(R.id.categoryDropdown);
        progressCalculate = findViewById(R.id.progressCalculate);
        recyclerViewStages = findViewById(R.id.recyclerViewStages);
        checkBoxHideShowStages = findViewById(R.id.checkBoxHideShowStages);
        checkBoxSelectAll = findViewById(R.id.checkBoxSelectAll);
        colorLayout = findViewById(R.id.colorLayout);
        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        edtName = findViewById(R.id.edtName);
        btnColorPicker = findViewById(R.id.btnColorPicker);
        fieldAreaInputLayout.setSuffixText("ha");
        db = RiceGrowDatabase.getInstance(this);
    }
}