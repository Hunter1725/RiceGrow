package com.example.ricegrow.Activity.Calculating.PesticideCalculating;

import static com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.PesticideActivity.PESTICIDE_KEY;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate;
import com.example.ricegrow.Activity.Calculating.FertilizerCalculating.ViewFerCalculate;
import com.example.ricegrow.Activity.Knowledge.Management.SupAdapter;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.PesticideActivity;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.TreatingAdapter;
import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.example.ricegrow.DatabaseFiles.Model.Diseases;
import com.example.ricegrow.DatabaseFiles.Model.FertilizerCalculating;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.Model.Weeds;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class PesticideCalculate extends AppCompatActivity {
    public static final String PESTICIDE_CALCULATE_KEY = "incoming_pesticide_calculate";
    private MaterialToolbar toolbarCalculate;
    private TextInputLayout  fieldAreaInputLayout;
    private TextInputEditText fieldAreaEditText;
    private Button btnDecrease, btnIncrease, btnCalculating;
    private RadioGroup radioGroup, capacityGroup;
    private RadioButton btnMeter, btnHectare, btn16, btn18, btn20, btn25;
    private ShapeableImageView imageEmpty, imagePesticide;
    private CircularProgressIndicator progressCalculate;
    private RelativeLayout resultLayout;
    private TextView txtCapacity, txtAmountPest, txtTotalAmount, txtTotalWater, txtTotalBottle, namePesticide, moreDetail, txtEmpty;
    private RecyclerView treatingRecView;
    private RiceGrowDatabase db;
    private Pesticides incomingPesticide;
    private TreatingAdapter treatingAdapter;
    private int capacity = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_pesticide_calculate);

        initView();

        if(fieldAreaEditText.getText().toString().equals("")){
            btnCalculating.setEnabled(false);
            btnCalculating.setBackgroundColor(Color.parseColor("#8C8C8C"));
        }

        Intent intent = getIntent();
        if (intent != null) {
            incomingPesticide = intent.getParcelableExtra(PESTICIDE_CALCULATE_KEY);
            if (incomingPesticide != null) {
                Glide.with(this)
                        .asBitmap()
                        .load(incomingPesticide.getPesticideImage())
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
                                    int defaultColor = ContextCompat.getColor(PesticideCalculate.this, R.color.white);
                                    int dominantColor = palette.getDominantColor(defaultColor);
                                    imagePesticide.setBackgroundColor(dominantColor);
                                });
                                return false;
                            }
                        })
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imagePesticide);
                namePesticide.setText(incomingPesticide.getName());
                toolbarCalculate.setTitle(incomingPesticide.getName());
                moreDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PesticideCalculate.this, PesticideActivity.class);
                        intent.putExtra(PESTICIDE_KEY, incomingPesticide);
                        startActivity(intent);
                    }
                });
            }
        }

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
                    startActivity(new Intent(PesticideCalculate.this, MainActivity.class));
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
                    startActivity(new Intent(PesticideCalculate.this, MainActivity.class));
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
                        calculating();
                    }
                } else if (checkedId == R.id.btnHectare) {
                    fieldAreaInputLayout.setSuffixText("ha");
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        String area = String.valueOf(Double.parseDouble(fieldAreaEditText.getText().toString())/10000.0);
                        fieldAreaEditText.setText(area);
                        calculating();
                    }
                }
            }
        });

        capacityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.btn16){
                    capacity = 16;
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        calculating();
                    }
                } else if (checkedId == R.id.btn18) {
                    capacity = 18;
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        calculating();
                    }
                } else if (checkedId == R.id.btn20) {
                    capacity = 20;
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        calculating();
                    }
                } else if (checkedId == R.id.btn25) {
                    capacity = 25;
                    if(!fieldAreaEditText.getText().toString().equals("")) {
                        calculating();
                    }
                }
            }
        });


        //Treating recycler view
        treatingAdapter = new TreatingAdapter(this);
        treatingRecView.setAdapter(treatingAdapter);
        treatingRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        if(incomingPesticide.getCategory().equals("Insecticide")){
            ArrayList<Pests> pests = (ArrayList<Pests>) db.pestDao().getPestByPesticideId(incomingPesticide.getId());
            if(pests != null){
                if(pests.size() > 0){
                    treatingRecView.setVisibility(View.VISIBLE);
                    txtEmpty.setVisibility(View.GONE);
                    treatingAdapter.setPests(pests);
                } else {
                    treatingRecView.setVisibility(View.GONE);
                    txtEmpty.setVisibility(View.VISIBLE);
                }
            }
        } else if (incomingPesticide.getCategory().equals("Fungicide")) {
            ArrayList<Diseases> diseases = (ArrayList<Diseases>) db.diseaseDao().getDiseaseByPesticideId(incomingPesticide.getId());
            if(diseases != null){
                if(diseases.size() > 0){
                    treatingRecView.setVisibility(View.VISIBLE);
                    txtEmpty.setVisibility(View.GONE);
                    treatingAdapter.setDiseases(diseases);
                } else {
                    treatingRecView.setVisibility(View.GONE);
                    txtEmpty.setVisibility(View.VISIBLE);
                }
            }
        } else if (incomingPesticide.getCategory().equals("Herbicide")) {
            ArrayList<Weeds> weeds = (ArrayList<Weeds>) db.weedDao().getWeedByPesticideId(incomingPesticide.getId());
            if(weeds != null){
                if(weeds.size() > 0){
                    treatingRecView.setVisibility(View.VISIBLE);
                    txtEmpty.setVisibility(View.GONE);
                    treatingAdapter.setWeeds(weeds);
                } else {
                    treatingRecView.setVisibility(View.GONE);
                    txtEmpty.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void calculating() {
        imageEmpty.setVisibility(View.GONE);
        progressCalculate.setVisibility(View.VISIBLE);

        //Calculating
        double area = Double.parseDouble(fieldAreaEditText.getText().toString());
        if (fieldAreaInputLayout.getSuffixText().equals("m²")){
            area = area/10000;
        }
        double waterPerHectare = incomingPesticide.getWaterPerHectare();
        double totalWater = waterPerHectare * area;

        double pesticidePerBottle = incomingPesticide.getPesticidePerBottle() * capacity / 16;
        double totalBottle = Math.round(totalWater / capacity);
        double totalPesticide = totalBottle * pesticidePerBottle;

        //Data assignment
        progressCalculate.setVisibility(View.GONE);
        resultLayout.setVisibility(View.VISIBLE);

        String stringCapacity = capacity + " liters";
        txtCapacity.setText(stringCapacity);

        String stringAmountPest = String.format("%.1f ml (or grams)", pesticidePerBottle);
        txtAmountPest.setText(stringAmountPest);

        String stringTotalPest = String.format("%.2f liters (or kg)", totalPesticide / 1000);
        txtTotalAmount.setText(stringTotalPest);

        String stringTotalWater = String.format("%.2f liters", totalWater);
        txtTotalWater.setText(stringTotalWater);

        String stringTotalBottle = String.format("%.0f spray bottles", totalBottle);
        txtTotalBottle.setText(stringTotalBottle);
    }

    private void initView() {
        toolbarCalculate = findViewById(R.id.toolbarCalculate);
        fieldAreaInputLayout = findViewById(R.id.fieldAreaInputLayout);
        fieldAreaEditText = findViewById(R.id.fieldAreaEditText);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnCalculating = findViewById(R.id.btnCalculating);
        radioGroup = findViewById(R.id.radioGroup);
        capacityGroup = findViewById(R.id.capacityGroup);
        btnMeter = findViewById(R.id.btnMeter);
        btnHectare = findViewById(R.id.btnHectare);
        btn16 = findViewById(R.id.btn16);
        btn18 = findViewById(R.id.btn18);
        btn20 = findViewById(R.id.btn20);
        btn25 = findViewById(R.id.btn25);
        imageEmpty = findViewById(R.id.imageEmpty);
        imagePesticide = findViewById(R.id.imagePesticide);
        progressCalculate = findViewById(R.id.progressCalculate);
        resultLayout = findViewById(R.id.resultLayout);
        txtCapacity = findViewById(R.id.txtCapacity);
        txtAmountPest = findViewById(R.id.txtAmountPest);
        txtTotalAmount = findViewById(R.id.txtTotalAmount);
        txtTotalWater = findViewById(R.id.txtTotalWater);
        txtTotalBottle = findViewById(R.id.txtTotalBottle);
        namePesticide = findViewById(R.id.namePesticide);
        moreDetail = findViewById(R.id.moreDetail);
        txtEmpty = findViewById(R.id.txtEmpty);
        treatingRecView = findViewById(R.id.treatingRecView);
        db = RiceGrowDatabase.getInstance(this);
        fieldAreaInputLayout.setSuffixText("ha");
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