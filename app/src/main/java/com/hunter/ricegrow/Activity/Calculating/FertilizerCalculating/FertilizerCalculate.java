package com.hunter.ricegrow.Activity.Calculating.FertilizerCalculating;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hunter.ricegrow.Activity.Knowledge.Management.SupAdapter;
import com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.TreatingAdapter;
import com.hunter.ricegrow.Activity.Main.MainActivity;
import com.hunter.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.hunter.ricegrow.DatabaseFiles.Model.FertilizerCalculating;
import com.hunter.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.hunter.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class FertilizerCalculate extends AppCompatActivity {

    public static final String FER_CALCULATE_KEY = "incoming_fer_calculate";
    private MaterialToolbar toolbarCalculate;
    private TextInputLayout nutrientNInputLayout, nutrientPInputLayout, nutrientKInputLayout, fieldAreaInputLayout;
    private TextInputEditText nutrientNEditText, nutrientPEditText, nutrientKEditText, fieldAreaEditText;
    private Button btnReset, btnDecrease, btnIncrease, btnCalculating, btnViewDetail;
    private RadioGroup radioGroup;
    private RadioButton btnMeter, btnHectare;
    private ShapeableImageView imageEmpty;
    private CircularProgressIndicator progressCalculate;
    private RelativeLayout resultLayout;
    private TextView txtUrea, txtDAP, txtMOP, textUrea, textDAP, textMOP;
    private RecyclerView fertilizerRecView, lackingRecView;
    private RiceGrowDatabase db;
    private FertilizerCalculating fertilizerCalculating;
    private SupAdapter fertilizerAdapter;
    private TreatingAdapter treatingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_fertilizer_calculate);

        initView();

        dataAssignment();

        toolbarCalculate.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarCalculate.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(FertilizerCalculate.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
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

                btnCalculating.setEnabled(isInputValid);
                btnCalculating.setBackgroundColor(isInputValid ? Color.parseColor("#4CAF50") : Color.parseColor("#8C8C8C"));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnCalculating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculating();
            }
        });

        fieldAreaEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(fieldAreaInputLayout, fieldAreaEditText);
                } else {
                    fieldAreaInputLayout.setError(null);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nutrientE = "80";
                nutrientNEditText.setText(nutrientE);
                String nutrientP = "30";
                nutrientPEditText.setText(nutrientP);
                String nutrientK = "40";
                nutrientKEditText.setText(nutrientK);
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
                if(checkedId == R.id.btnMeter){
                    fieldAreaInputLayout.setSuffixText("m²");
                    fertilizerCalculating.setUnit("m2");
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        String area = String.valueOf(Double.parseDouble(fieldAreaEditText.getText().toString())*10000.0);
                        fieldAreaEditText.setText(area);
                        calculating();
                    }
                } else if (checkedId == R.id.btnHectare) {
                    fieldAreaInputLayout.setSuffixText("ha");
                    fertilizerCalculating.setUnit("ha");
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        String area = String.valueOf(Double.parseDouble(fieldAreaEditText.getText().toString())/10000.0);
                        fieldAreaEditText.setText(area);
                        calculating();
                    }
                }
            }
        });

        btnViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FertilizerCalculate.this, ViewFerCalculate.class);
                intent.putExtra(FER_CALCULATE_KEY, fertilizerCalculating);
                startActivity(intent);
            }
        });

        fertilizerAdapter = new SupAdapter(this);
        fertilizerRecView.setAdapter(fertilizerAdapter);
        fertilizerRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        ArrayList<Fertilizers> fertilizers = (ArrayList<Fertilizers>) db.fertilizerDao().getAllFertilizers();
        fertilizerAdapter.setFertilizers(fertilizers);

        //Treating recycler view
        treatingAdapter = new TreatingAdapter(this);
        lackingRecView.setAdapter(treatingAdapter);
        lackingRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        ArrayList<DeficienciesToxicities> deficienciesToxicities = (ArrayList<DeficienciesToxicities>) db.deficienciesToxicitiesDao().getAllDeftoxs();
        treatingAdapter.setDeficienciesToxicities(deficienciesToxicities);
    }

    private void calculating() {
        double area = Double.parseDouble(fieldAreaEditText.getText().toString());
        if(fieldAreaInputLayout.getSuffixText().equals("ha") && area > 1000){
            fieldAreaInputLayout.setError(getString(R.string.must_be_equal_or_lower_than_1000_ha));

        } else if (fieldAreaInputLayout.getSuffixText().equals("m²") && area > 10000000) {
            fieldAreaInputLayout.setError(getString(R.string.must_be_equal_or_lower_than_10000000_m));
        } else {
            imageEmpty.setVisibility(View.GONE);
            progressCalculate.setVisibility(View.VISIBLE);
            fieldAreaInputLayout.setError(null);

            String nText = nutrientNEditText.getText().toString();
            String pText = nutrientPEditText.getText().toString();
            String kText = nutrientKEditText.getText().toString();


            int dapAmount = calculateAmount(pText, area, 0.46);
            int ureaAmount = calculateUreaAmount(nText, dapAmount, area, 0.18, 0.463);
            int mopAmount = calculateAmount(kText, area, 0.6);

            fertilizerCalculating.setId(db.fertilizerCalculatingDao().getAll().getId());
            fertilizerCalculating.setNRatio(!nText.isEmpty() ? Integer.parseInt(nText) : 0);
            fertilizerCalculating.setPRatio(!pText.isEmpty() ? Integer.parseInt(pText) : 0);
            fertilizerCalculating.setKRatio(!kText.isEmpty() ? Integer.parseInt(kText) : 0);
            fertilizerCalculating.setArea(area);
            fertilizerCalculating.setUreaAmount(ureaAmount);
            fertilizerCalculating.setDapAmount(dapAmount);
            fertilizerCalculating.setMopAmount(mopAmount);
            db.fertilizerCalculatingDao().updateFertilizerCalculating(fertilizerCalculating);

            progressCalculate.setVisibility(View.GONE);
            resultLayout.setVisibility(View.VISIBLE);
            dataAssignment();
        }
    }

    // Method to calculate amount based on the nutrient text, area, and conversion factor
    private int calculateAmount(String nutrientText, double area, double conversionFactor) {
        int amount = 0;
        if (!nutrientText.isEmpty() && !nutrientText.equals("0")) {
            int nutrientRatio = Integer.parseInt(nutrientText);
            double ratioArea = area;
            if (fertilizerCalculating.getUnit().equals("m2")) {
                ratioArea /= 10000;
            }
            amount = (int) Math.round((nutrientRatio / conversionFactor) * ratioArea);
        }
        return amount;
    }

    // Method to calculate the amount of urea based on nutrient N, dapAmount, area, conversion factor, and subtraction factor
    private int calculateUreaAmount(String nText, int dapAmount, double area, double subtractionFactor, double conversionFactor) {
        int ureaAmount = 0;
        if (!nText.isEmpty() && !nText.equals("0")) {
            int nRatio = Integer.parseInt(nText);
            double ratioArea = area;
            if (fertilizerCalculating.getUnit().equals("m2")) {
                ratioArea /= 10000;
            }
            double remainNRatio = (nRatio * ratioArea) - (dapAmount * subtractionFactor);
            ureaAmount = (int) Math.round(remainNRatio / conversionFactor);
        }
        return ureaAmount;
    }


    private void dataAssignment() {
        fertilizerCalculating = db.fertilizerCalculatingDao().getAll();

        if (fertilizerCalculating != null){
            if (fertilizerCalculating.getUnit() != null) {
                imageEmpty.setVisibility(View.GONE);
                resultLayout.setVisibility(View.VISIBLE);
                nutrientNEditText.setText(String.valueOf(fertilizerCalculating.getNRatio()));
                nutrientPEditText.setText(String.valueOf(fertilizerCalculating.getPRatio()));
                nutrientKEditText.setText(String.valueOf(fertilizerCalculating.getKRatio()));
                fieldAreaEditText.setText(String.valueOf(fertilizerCalculating.getArea()));
                if (fertilizerCalculating.getUnit().equals("m2")) {
                    btnMeter.setChecked(true);
                    fieldAreaInputLayout.setSuffixText("m²");
                } else if (fertilizerCalculating.getUnit().equals("ha")) {
                    btnHectare.setChecked(true);
                    fieldAreaInputLayout.setSuffixText("ha");
                }
                if(fertilizerCalculating.getUreaAmount() != 0) {
                    String urea = fertilizerCalculating.getUreaAmount() + " Kg";
                    txtUrea.setText(urea);
                } else {
                    txtUrea.setText("-");
                }
                if(fertilizerCalculating.getDapAmount() != 0) {
                    String dap = fertilizerCalculating.getDapAmount() + " Kg";
                    txtDAP.setText(dap);
                } else {
                    txtDAP.setText("-");
                }
                if(fertilizerCalculating.getMopAmount() != 0) {
                    String mop = fertilizerCalculating.getMopAmount() + " Kg";
                    txtMOP.setText(mop);
                } else {
                    txtMOP.setText("-");
                }
            }
        } else {
            fertilizerCalculating = new FertilizerCalculating();
            fertilizerCalculating.setUnit("ha");
            db.fertilizerCalculatingDao().insert(fertilizerCalculating);
            imageEmpty.setVisibility(View.VISIBLE);
            resultLayout.setVisibility(View.GONE);
        }

        if(fieldAreaEditText.getText().toString().equals("")){
            btnCalculating.setEnabled(false);
            btnCalculating.setBackgroundColor(Color.parseColor("#8C8C8C"));
        }
    }

    private void initView() {
        toolbarCalculate = findViewById(R.id.toolbarCalculate);
        nutrientNInputLayout = findViewById(R.id.nutrientNInputLayout);
        nutrientPInputLayout = findViewById(R.id.nutrientPInputLayout);
        nutrientKInputLayout = findViewById(R.id.nutrientKInputLayout);
        fieldAreaInputLayout = findViewById(R.id.fieldAreaInputLayout);
        nutrientNEditText = findViewById(R.id.nutrientNEditText);
        nutrientPEditText = findViewById(R.id.nutrientPEditText);
        nutrientKEditText = findViewById(R.id.nutrientKEditText);
        fieldAreaEditText = findViewById(R.id.fieldAreaEditText);
        btnReset = findViewById(R.id.btnReset);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnCalculating = findViewById(R.id.btnCalculating);
        btnViewDetail = findViewById(R.id.btnViewDetail);
        radioGroup = findViewById(R.id.radioGroup);
        btnMeter = findViewById(R.id.btnMeter);
        btnHectare = findViewById(R.id.btnHectare);
        imageEmpty = findViewById(R.id.imageEmpty);
        progressCalculate = findViewById(R.id.progressCalculate);
        resultLayout = findViewById(R.id.resultLayout);
        txtUrea = findViewById(R.id.txtUrea);
        txtDAP = findViewById(R.id.txtDAP);
        txtMOP = findViewById(R.id.txtMOP);
        textDAP = findViewById(R.id.textDAP);
        textMOP = findViewById(R.id.textMOP);
        textUrea = findViewById(R.id.textUrea);
        fertilizerRecView = findViewById(R.id.fertilizerRecView);
        lackingRecView = findViewById(R.id.lackingRecView);
        db = RiceGrowDatabase.getInstance(this);
    }

    private void validateInput(TextInputLayout textInputLayout, TextInputEditText editText) {
        String input = editText.getText().toString().trim();

        if (TextUtils.isEmpty(input)) {
            textInputLayout.setError(getString(R.string.input_cannot_be_empty));
        } else {
            textInputLayout.setError(null);
        }
    }
}