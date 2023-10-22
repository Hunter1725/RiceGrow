package com.hunter.ricegrow.Activity.Planning.Plan;

import static com.hunter.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate.FER_CALCULATE_KEY;
import static com.hunter.ricegrow.Activity.Planning.Plan.PlanGenerate.SHOW_FRAGMENT;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hunter.ricegrow.Activity.Calculating.FertilizerCalculating.ViewFerCalculate;
import com.hunter.ricegrow.Activity.Knowledge.Management.SupAdapter;
import com.hunter.ricegrow.Activity.Main.MainActivity;
import com.hunter.ricegrow.Activity.Planning.Calendar.MainCalendar;
import com.hunter.ricegrow.DatabaseFiles.Model.CropStage;
import com.hunter.ricegrow.DatabaseFiles.Model.Crops;
import com.hunter.ricegrow.DatabaseFiles.Model.FertilizerCalculating;
import com.hunter.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.hunter.ricegrow.DatabaseFiles.Model.Pesticides;
import com.hunter.ricegrow.DatabaseFiles.Model.PlanStages;
import com.hunter.ricegrow.DatabaseFiles.Model.UserCrops;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewPlan extends AppCompatActivity {

    public static final String USERCROP_KEY = "incoming_usercrop";

    private MaterialToolbar toolbarPlanning;
    private TextView textCropName, textSowingDate, textExpectedHarvestDate, textSowingAmount, textSowedArea, textGrowthPeriod,
                    txtUrea, txtDAP, txtMOP;
    private Button btnViewDetailPlanCalendar, btnViewDetailFertilizer;
    private RecyclerView fertilizerRecView, pesticideRecView;
    private RiceGrowDatabase db;
    private UserCrops incomingUserCrops;
    private FertilizerCalculating fertilizerCalculating;
    private ImageView btnEdit;

    private SupAdapter fertilizerAdapter, pesticideAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_view_plan);

        initView();

        //Get intent
        Intent intent = getIntent();
        if(intent != null) {
            incomingUserCrops = intent.getParcelableExtra(USERCROP_KEY);
            if (incomingUserCrops != null) {
                //Calculating the amount of fertilizers
                calculatingFertilizer();
                //Assign data to variables
                toolbarPlanning.setTitle(incomingUserCrops.getName());
                Crops crops = db.cropDao().getCropById(incomingUserCrops.getCropId());
                textCropName.setText(crops.getName());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.getDefault());
                textSowingDate.setText(incomingUserCrops.getStartingDate().format(formatter));
                textExpectedHarvestDate.setText(incomingUserCrops.getExpectedHarvestDate().format(formatter));
                String amountString = incomingUserCrops.getSowingAmount() + " kg";
                textSowingAmount.setText(amountString);
                String areaString = incomingUserCrops.getSowedArea() + " ha";
                textSowedArea.setText(areaString);
                String periodString = incomingUserCrops.getGrowthPeriod() + getString(R.string.days);
                textGrowthPeriod.setText(periodString);
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
        }

        //Recommended fertilizers
        fertilizerAdapter = new SupAdapter(this);
        fertilizerRecView.setAdapter(fertilizerAdapter);
        fertilizerRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        ArrayList<Fertilizers> fertilizers = (ArrayList<Fertilizers>) db.fertilizerDao().getFertilizerFromActivity();
        fertilizerAdapter.setFertilizers(fertilizers);

        //Recommended pesticides
        pesticideAdapter = new SupAdapter(this);
        pesticideRecView.setAdapter(pesticideAdapter);
        pesticideRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        ArrayList<Pesticides> pesticides = (ArrayList<Pesticides>) db.pesticideDao().getPesticideFromActivity();
        pesticideAdapter.setPesticides(pesticides);

        //Create plan calendar
        if(db.planStageDao().getAllPlanStageByUserCropId(incomingUserCrops.getId()).isEmpty()) {
            List<Integer> idStage = incomingUserCrops.getPlanStages();
            LocalDate endDate = null;
            for (int index = 0; index < idStage.size(); index++) {
                Integer i = idStage.get(index);
                CropStage cropStage = db.cropStageDao().getCropStageByStageIdAndCropId(i, incomingUserCrops.getCropId());
                if (endDate == null) {
                    endDate = incomingUserCrops.getStartingDate().plusDays(cropStage.getDuration());
                    db.planStageDao().insert(new PlanStages(incomingUserCrops.getId(), i, incomingUserCrops.getStartingDate(), endDate));
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
                    db.planStageDao().insert(new PlanStages(incomingUserCrops.getId(), i, endDate, endDate.plusDays(cropStage.getDuration())));
                    endDate = endDate.plusDays(cropStage.getDuration());
                }

            }
        }

        initListener();

    }

    private void initListener() {
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
                    startActivity(new Intent(ViewPlan.this, MainActivity.class));
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        btnViewDetailPlanCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPlan.this, MainCalendar.class);
                intent.putExtra(USERCROP_KEY, incomingUserCrops);
                startActivity(intent);
            }
        });

        btnViewDetailFertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPlan.this, ViewFerCalculate.class);
                intent.putExtra(FER_CALCULATE_KEY, fertilizerCalculating);
                startActivity(intent);
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPlan.this, EditPlan.class);
                intent.putExtra(USERCROP_KEY, incomingUserCrops);
                startActivity(intent);
            }
        });
    }

    private void calculatingFertilizer() {
        double area = incomingUserCrops.getSowedArea();

        int dapAmount = calculateAmount("30", area, 0.46);
        int ureaAmount = calculateUreaAmount("80", dapAmount, area, 0.18, 0.463);
        int mopAmount = calculateAmount("40", area, 0.6);

        fertilizerCalculating = new FertilizerCalculating(80, 30, 40, "ha", area, ureaAmount, mopAmount, dapAmount);
//        db.fertilizerCalculatingDao().updateFertilizerCalculating(fertilizerCalculating);
    }

    private int calculateAmount(String nutrientText, double area, double conversionFactor) {
        int amount = 0;
        if (!nutrientText.isEmpty() && !nutrientText.equals("0")) {
            int nutrientRatio = Integer.parseInt(nutrientText);
            amount = (int) Math.round((nutrientRatio / conversionFactor) * area);
        }
        return amount;
    }

    // Method to calculate the amount of urea based on nutrient N, dapAmount, area, conversion factor, and subtraction factor
    private int calculateUreaAmount(String nText, int dapAmount, double area, double subtractionFactor, double conversionFactor) {
        int ureaAmount = 0;
        if (!nText.isEmpty() && !nText.equals("0")) {
            int nRatio = Integer.parseInt(nText);
            double remainNRatio = (nRatio * area) - (dapAmount * subtractionFactor);
            ureaAmount = (int) Math.round(remainNRatio / conversionFactor);
        }
        return ureaAmount;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(SHOW_FRAGMENT, "planFragment"); // Pass a unique identifier for the fragment
        startActivity(intent);
    }

    private void initView() {
        toolbarPlanning = findViewById(R.id.toolbarPlanning);
        textCropName = findViewById(R.id.textCropName);
        textSowingDate = findViewById(R.id.textSowingDate);
        textExpectedHarvestDate = findViewById(R.id.textExpectedHarvestDate);
        textSowingAmount = findViewById(R.id.textSowingAmount);
        textSowedArea = findViewById(R.id.textSowedArea);
        textGrowthPeriod = findViewById(R.id.textGrowthPeriod);
        txtUrea = findViewById(R.id.txtUrea);
        txtDAP = findViewById(R.id.txtDAP);
        txtMOP = findViewById(R.id.txtMOP);
        btnViewDetailPlanCalendar = findViewById(R.id.btnViewDetailPlanCalendar);
        btnViewDetailFertilizer = findViewById(R.id.btnViewDetailFertilizer);
        fertilizerRecView = findViewById(R.id.fertilizerRecView);
        pesticideRecView = findViewById(R.id.pesticideRecView);
        btnEdit = findViewById(R.id.btnEdit);
        db = RiceGrowDatabase.getInstance(this);
    }
}