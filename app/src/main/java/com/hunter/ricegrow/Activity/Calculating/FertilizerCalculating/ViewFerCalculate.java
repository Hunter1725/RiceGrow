package com.hunter.ricegrow.Activity.Calculating.FertilizerCalculating;

import static com.hunter.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate.FER_CALCULATE_KEY;
import static com.hunter.ricegrow.Activity.Knowledge.StageActivity.Activity.FarmingActivity.ACTIVITY_KEY;
import static com.hunter.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity.STAGE_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.hunter.ricegrow.Activity.Knowledge.StageActivity.Activity.FarmingActivity;
import com.hunter.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity;
import com.hunter.ricegrow.DatabaseFiles.Model.Activities;
import com.hunter.ricegrow.DatabaseFiles.Model.FertilizerCalculating;
import com.hunter.ricegrow.DatabaseFiles.Model.Stages;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.hunter.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ViewFerCalculate extends AppCompatActivity {
    private MaterialToolbar toolbarCalculate;
    private TextView primaryFertilizer, tilleringStage, txtUrea1, secondFertilizer, secondStage, txtUrea2, txtDAP2, txtMOP2,
            thirdFertilizer, thirdStage, txtUrea3, txtMOP3;
    private FertilizerCalculating incomingFertilizerCalculating;
    private RiceGrowDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_view_fer_calculate);

        initView();

        toolbarCalculate.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        primaryFertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activities activities = db.activityDao().getActivityByName("Primary fertilizing");
                Intent intent = new Intent(ViewFerCalculate.this, FarmingActivity.class);
                intent.putExtra(ACTIVITY_KEY, activities);
                startActivity(intent);
            }
        });

        secondFertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activities activities = db.activityDao().getActivityByName("Secondary fertilizing");
                Intent intent = new Intent(ViewFerCalculate.this, FarmingActivity.class);
                intent.putExtra(ACTIVITY_KEY, activities);
                startActivity(intent);
            }
        });

        thirdFertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activities activities = db.activityDao().getActivityByName("Thirdly fertilizing");
                Intent intent = new Intent(ViewFerCalculate.this, FarmingActivity.class);
                intent.putExtra(ACTIVITY_KEY, activities);
                startActivity(intent);
            }
        });

        tilleringStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stages stages = db.stageDao().getStageByName("Tillering");
                Intent intent = new Intent(ViewFerCalculate.this, StageActivity.class);
                intent.putExtra(STAGE_KEY, stages);
                startActivity(intent);
            }
        });

        secondStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stages stages = db.stageDao().getStageByName("Tillering");
                Intent intent = new Intent(ViewFerCalculate.this, StageActivity.class);
                intent.putExtra(STAGE_KEY, stages);
                startActivity(intent);
            }
        });

        thirdStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stages stages = db.stageDao().getStageByName("Panicle initiation");
                Intent intent = new Intent(ViewFerCalculate.this, StageActivity.class);
                intent.putExtra(STAGE_KEY, stages);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if(intent != null) {
            incomingFertilizerCalculating = intent.getParcelableExtra(FER_CALCULATE_KEY);
            if (incomingFertilizerCalculating != null) {
                //Get amount of fertilizers
                int ureaAmount = incomingFertilizerCalculating.getUreaAmount();
                int dapAmount = incomingFertilizerCalculating.getDapAmount();
                int mopAmount = incomingFertilizerCalculating.getMopAmount();

                //Urea
                if(ureaAmount == 0){
                    txtUrea1.setText("-");
                    txtUrea2.setText("-");
                    txtUrea3.setText("-");
                } else {
                    int urea1 = (int) Math.round(ureaAmount*(4.0/9.0));
                    String urea1String = urea1 + " kg";
                    txtUrea1.setText(urea1String);
                    double remainUrea = ureaAmount - (ureaAmount*(4.0/9.0));
                    int urea2 = (int) Math.round(remainUrea/2.0);
                    String urea2String = urea2 + " kg";
                    int urea3 = (int) Math.round(remainUrea/2.0);
                    String urea3String = urea3 + " kg";
                    txtUrea2.setText(urea2String);
                    txtUrea3.setText(urea3String);
                }

                //DAP
                if (dapAmount == 0){
                    txtDAP2.setText("-");
                } else {
                    String dapString = dapAmount + " kg";
                    txtDAP2.setText(dapString);
                }

                //MOP
                if (mopAmount == 0){
                    txtMOP2.setText("-");
                    txtMOP3.setText("-");
                } else {
                    int mop2 = (int) Math.round(mopAmount*(2.0/3.0));
                    String mop2String = mop2 + " kg";
                    txtMOP2.setText(mop2String);
                    double remainAmount = mopAmount - (mopAmount*(2.0/3.0));
                    int mop3 = (int) Math.round(remainAmount);
                    String mop3String = mop3 + " kg";
                    txtMOP3.setText(mop3String);
                }
            }
        }
    }

    private void initView() {
        toolbarCalculate = findViewById(R.id.toolbarCalculate);
        primaryFertilizer = findViewById(R.id.primaryFertilizer);
        tilleringStage = findViewById(R.id.tilleringStage);
        txtUrea1 = findViewById(R.id.txtUrea1);
        secondFertilizer = findViewById(R.id.secondFertilizer);
        secondStage = findViewById(R.id.secondStage);
        txtUrea2 = findViewById(R.id.txtUrea2);
        txtDAP2 = findViewById(R.id.txtDAP2);
        txtMOP2 = findViewById(R.id.txtMOP2);
        thirdFertilizer = findViewById(R.id.thirdFertilizer);
        thirdStage = findViewById(R.id.thirdStage);
        txtUrea3 = findViewById(R.id.txtUrea3);
        txtMOP3 = findViewById(R.id.txtMOP3);
        db = RiceGrowDatabase.getInstance(this);
    }
}