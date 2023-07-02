package com.example.ricegrow.Activity.Calculating.FertilizerCalculating;

import static com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerActivity.FERTILIZER_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.ricegrow.Activity.Knowledge.Management.Crop.CropActivity;
import com.example.ricegrow.Activity.Knowledge.Management.SupAdapter;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerActivity;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.TreatingAdapter;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Activity.FarmingActivity;
import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.example.ricegrow.DatabaseFiles.Model.FertilizerCalculating;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
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
                if (fieldAreaEditText.getText().toString().equals("")){
                    btnCalculating.setEnabled(false);
                    btnCalculating.setBackgroundColor(Color.parseColor("#8C8C8C"));
                } else {
                    btnCalculating.setEnabled(true);
                    btnCalculating.setBackgroundColor(Color.parseColor("#4CAF50"));
                }
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

        //Toolbar
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

        fieldAreaEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(fieldAreaInputLayout, fieldAreaEditText);
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
        imageEmpty.setVisibility(View.GONE);
        progressCalculate.setVisibility(View.VISIBLE);

        String nText = nutrientNEditText.getText().toString();
        String pText = nutrientPEditText.getText().toString();
        String kText = nutrientKEditText.getText().toString();

        double area = Double.parseDouble(fieldAreaEditText.getText().toString());
        int ureaAmount = 0;
        int dapAmount = 0;
        int mopAmount = 0;

        if (!nText.isEmpty() && !pText.isEmpty() && !kText.isEmpty() && !nText.equals("0") && !pText.equals("0") && !kText.equals("0")) {
            // All three nutrients provided
            int nRatio = Integer.parseInt(nText);
            int pRatio = Integer.parseInt(pText);
            int kRatio = Integer.parseInt(kText);

            if (fertilizerCalculating.getUnit().equals("ha")) {
                dapAmount = (int) Math.round((pRatio / 0.46) * area);
                double remainNRatio = nRatio * area - dapAmount * 0.18;
                ureaAmount = (int) Math.round((remainNRatio / 0.463));
                mopAmount = (int) Math.round((kRatio / 0.6) * area);
            } else if (fertilizerCalculating.getUnit().equals("m2")) {
                dapAmount = (int) Math.round(((pRatio / 0.46) * (area/10000)));
                double remainNRatio = (nRatio * (area/10000)) - dapAmount * 0.18;
                ureaAmount = (int) Math.round(((remainNRatio / 0.463)));
                mopAmount = (int) Math.round(((kRatio / 0.6) * (area/10000)));
            }
        } else if (!nText.isEmpty() && !pText.isEmpty() && !nText.equals("0") && !pText.equals("0")) {
            // N and P provided, K is null
            int nRatio = Integer.parseInt(nText);
            int pRatio = Integer.parseInt(pText);

            if (fertilizerCalculating.getUnit().equals("ha")) {
                dapAmount = (int) Math.round((pRatio / 0.46) * area);
                ureaAmount = (int) Math.round((nRatio * area - dapAmount * 0.18) / 0.463);
            } else if (fertilizerCalculating.getUnit().equals("m2")) {
                dapAmount = (int) Math.round(((pRatio / 0.46) * area) / 10000);
                ureaAmount = (int) Math.round(((nRatio * area - dapAmount * 0.18) / 0.463) / 10000);
            }
        } else if (!nText.isEmpty() && !kText.isEmpty() && !nText.equals("0") && !kText.equals("0")) {
            // N and K provided, P is null
            int nRatio = Integer.parseInt(nText);
            int kRatio = Integer.parseInt(kText);

            if (fertilizerCalculating.getUnit().equals("ha")) {
                ureaAmount = (int) Math.round((nRatio / 0.463)* area);
                mopAmount = (int) Math.round((kRatio / 0.6) * area);
            } else if (fertilizerCalculating.getUnit().equals("m2")) {
                ureaAmount = (int) Math.round(((nRatio / 0.463) * area) / 10000);
                mopAmount = (int) Math.round(((kRatio / 0.6) * area) / 10000);
            }
        } else if (!pText.isEmpty() && !kText.isEmpty() && !pText.equals("0") && !kText.equals("0")) {
            // P and K provided, N is null
            int pRatio = Integer.parseInt(pText);
            int kRatio = Integer.parseInt(kText);

            if (fertilizerCalculating.getUnit().equals("ha")) {
                dapAmount = (int) Math.round((pRatio / 0.46) * area);
                mopAmount = (int) Math.round((kRatio / 0.6) * area);
            } else if (fertilizerCalculating.getUnit().equals("m2")) {
                dapAmount = (int) Math.round(((pRatio / 0.46) * area) / 10000);
                mopAmount = (int) Math.round(((kRatio / 0.6) * area) / 10000);
            }
        } else if (!nText.isEmpty() && !nText.equals("0")) {
            // N provided, P and K are null
            int nRatio = Integer.parseInt(nText);
            if (fertilizerCalculating.getUnit().equals("ha")) {
                ureaAmount = (int) Math.round((nRatio / 0.463) * area);
            } else if (fertilizerCalculating.getUnit().equals("m2")) {
                ureaAmount = (int) Math.round(((nRatio / 0.463) * area) / 10000);
            }
        } else if (!pText.isEmpty() && !pText.equals("0")) {
            // P provided, N and K are null
            int pRatio = Integer.parseInt(pText);
            if (fertilizerCalculating.getUnit().equals("ha")) {
                dapAmount = (int) Math.round((pRatio / 0.46) * area);
            } else if (fertilizerCalculating.getUnit().equals("m2")) {
                dapAmount = (int) Math.round(((pRatio / 0.46) * area) / 10000);
            }
        } else if (!kText.isEmpty() && !kText.equals("0")) {
            // K provided, N and P are null
            int kRatio = Integer.parseInt(kText);
            if (fertilizerCalculating.getUnit().equals("ha")) {
                mopAmount = (int) Math.round((kRatio / 0.6) * area);
            } else if (fertilizerCalculating.getUnit().equals("m2")) {
                mopAmount = (int) Math.round(((kRatio / 0.6) * area) / 10000);
            }
        }

        fertilizerCalculating.setId(db.fertilizerCalculatingDao().getAll().getId());
        fertilizerCalculating.setNRatio(!nText.isEmpty() ? Integer.parseInt(nText) : 0);
        fertilizerCalculating.setPRatio(!pText.isEmpty() ? Integer.parseInt(pText) : 0);
        fertilizerCalculating.setKRatio(!kText.isEmpty() ? Integer.parseInt(kText) : 0);
        fertilizerCalculating.setArea(area);
        if(ureaAmount != 0){
            fertilizerCalculating.setUreaAmount(ureaAmount);
        } else {
            fertilizerCalculating.setUreaAmount(0);
        }
        if(dapAmount != 0){
            fertilizerCalculating.setDapAmount(dapAmount);
        } else {
            fertilizerCalculating.setDapAmount(0);
        }
        if(mopAmount != 0){
            fertilizerCalculating.setMopAmount(mopAmount);
        } else {
            fertilizerCalculating.setMopAmount(0);
        }
        db.fertilizerCalculatingDao().updateFertilizerCalculating(fertilizerCalculating);

        progressCalculate.setVisibility(View.GONE);
        resultLayout.setVisibility(View.VISIBLE);
        dataAssignment();
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
            textInputLayout.setError("Input cannot be empty");
        } else {
            textInputLayout.setError(null);
        }
    }
}