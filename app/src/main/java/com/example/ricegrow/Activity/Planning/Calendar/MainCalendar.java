package com.example.ricegrow.Activity.Planning.Calendar;

import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.selectDate;
import static com.example.ricegrow.Activity.Planning.Plan.ViewPlan.USERCROP_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.Activity.Planning.Plan.ViewPlan;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainCalendar extends AppCompatActivity {

    private MaterialToolbar toolbarPlanning;
    private UserCrops incomingUserCrops;
    private RiceGrowDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main_calendar);
        selectDate = LocalDate.now();
        db = RiceGrowDatabase.getInstance(this);
        Intent intent = getIntent();
        if(intent != null) {
            incomingUserCrops = intent.getParcelableExtra(USERCROP_KEY);
        }
        createActivityPlan();

        initView();


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
                    startActivity(new Intent(MainCalendar.this, MainActivity.class));
                    return true;
                } else if (itemId == R.id.current) {
                    selectDate = LocalDate.now();
                    if(getCurrentFragment() instanceof MonthView){
                        MonthView monthView = new MonthView();
                        Bundle args = new Bundle();
                        args.putParcelable(USERCROP_KEY, incomingUserCrops);
                        monthView.setArguments(args);
                        replaceFragment(monthView);
                    } else if (getCurrentFragment() instanceof WeekView) {
                        WeekView weekView = new WeekView();
                        Bundle args = new Bundle();
                        args.putParcelable(USERCROP_KEY, incomingUserCrops);
                        weekView.setArguments(args);
                        replaceFragment(weekView);
                    } else if (getCurrentFragment() instanceof DailyView) {
                        DailyView dailyView = new DailyView();
                        Bundle args = new Bundle();
                        args.putParcelable(USERCROP_KEY, incomingUserCrops);
                        dailyView.setArguments(args);
                        replaceFragment(dailyView);
                    }
                    return true;
                } else if (itemId == R.id.monthly) {
                    MonthView monthView = new MonthView();
                    Bundle args = new Bundle();
                    args.putParcelable(USERCROP_KEY, incomingUserCrops);
                    monthView.setArguments(args);
                    replaceFragment(monthView);
                    return true;
                } else if (itemId == R.id.weekly) {
                    WeekView weekView = new WeekView();
                    Bundle args = new Bundle();
                    args.putParcelable(USERCROP_KEY, incomingUserCrops);
                    weekView.setArguments(args);
                    replaceFragment(weekView);
                    return true;
                } else if (itemId == R.id.daily){
                    DailyView dailyView = new DailyView();
                    Bundle args = new Bundle();
                    args.putParcelable(USERCROP_KEY, incomingUserCrops);
                    dailyView.setArguments(args);
                    replaceFragment(dailyView);
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void createActivityPlan() {
        ArrayList<PlanStages> planStages = (ArrayList<PlanStages>) db.planStageDao().getAllPlanStageByUserCropId(incomingUserCrops.getId());
        for(PlanStages planStage : planStages){
            if(db.planActivityDao().getAllPlanActivitiesByPlanStageId(planStage.getId()).isEmpty()){
                Stages stages = db.stageDao().getStageById(planStage.getStageId());
                ArrayList<Activities> activities = (ArrayList<Activities>) db.activityDao().getActivitiesByStageId(stages.getId());
                LocalDate endDate = null;
                for(Activities activity : activities){
                    if(endDate == null) {
                        endDate = planStage.getStartDate().plusDays(activity.getDuration());
                        db.planActivityDao().insert(new PlanActivities(planStage.getId(), activity.getId(), planStage.getStartDate(), endDate));
                    } else {
                        db.planActivityDao().insert(new PlanActivities(planStage.getId(), activity.getId(), endDate, endDate.plusDays(activity.getDuration())));
                        endDate = endDate.plusDays(activity.getDuration());
                    }
                }
            }
        }
    }

    private void initView() {
        toolbarPlanning = findViewById(R.id.toolbarPlanning);

        WeekView weekView = new WeekView();
        Bundle args = new Bundle();
        args.putParcelable(USERCROP_KEY, incomingUserCrops);
        weekView.setArguments(args);
        replaceFragment(weekView);
    }

    public Fragment getCurrentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int containerId = R.id.containerPlan;
        return fragmentManager.findFragmentById(containerId);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerPlan, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}