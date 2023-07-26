package com.example.ricegrow.Activity.Planning.Calendar;

import static com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity.STAGE_KEY;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.daysInWeekArray;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.monthYearFromDate;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.selectDate;
import static com.example.ricegrow.Activity.Planning.Plan.ViewPlan.USERCROP_KEY;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.CropStage;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeekView extends Fragment implements CalendarAdapter.OnItemListener{

    private TextView monthYearText, txtEmpty, txtEmpty2, txtNameStage, txtDurationStage, txtStartDate;
    private Button  btnDaily, btnPrevious, btnNext;
    private MaterialCardView cardStage;
    private ShapeableImageView imageStage;
    private RecyclerView calendarRecyclerView, activityListView;
    private UserCrops incomingUserCrops;
    private RiceGrowDatabase db;
    private Stages stages;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.week_view, container, false);
        Bundle args = getArguments();
        if (args != null) {
            incomingUserCrops = args.getParcelable(USERCROP_KEY);
        }
        initView(view);
        setWeekView();
        initListener();


        return view;
    }

    private void initListener() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.plusWeeks(1);
                setWeekView();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.minusWeeks(1);
                setWeekView();
            }
        });

        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyView dailyView = new DailyView();
                Bundle args = new Bundle();
                args.putParcelable(USERCROP_KEY, incomingUserCrops);
                dailyView.setArguments(args);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerPlan, dailyView);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cardStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StageActivity.class);
                intent.putExtra(STAGE_KEY, stages);
                startActivity(intent);
            }
        });
    }

    private void setWeekView() {
        monthYearText.setText(monthYearFromDate(selectDate));
        ArrayList<LocalDate> days = daysInWeekArray(selectDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this, incomingUserCrops,getActivity());
        calendarRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        calendarRecyclerView.setAdapter(calendarAdapter);
        assignData();
    }

    private void assignData() {
        ArrayList<PlanStages> planStages = (ArrayList<PlanStages>) db.planStageDao().getAllPlanStageByUserCropId(incomingUserCrops.getId());
        for (PlanStages planStage : planStages){
            if (planStage.getStartDate().isBefore(selectDate.plusDays(1)) && planStage.getEndDate().isAfter(selectDate)) {
                //Stage
                cardStage.setVisibility(View.VISIBLE);
                txtEmpty.setVisibility(View.GONE);
                stages = db.stageDao().getStageById(planStage.getStageId());
                txtNameStage.setText(stages.getName());
                CropStage cropStage = db.cropStageDao().getCropStageByStageIdAndCropId(stages.getId(), incomingUserCrops.getCropId());
                Glide.with(getActivity())
                        .asBitmap()
                        .load(stages.getStageImage())
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageStage);
                txtNameStage.setText(stages.getName());
                String durationStage = cropStage.getDuration() + " days";
                txtDurationStage.setText(durationStage);
                String startDate = cropStage.getStartDate() + " day";
                txtStartDate.setText(startDate);

                //Activities
                ArrayList<PlanActivities> planActivities = (ArrayList<PlanActivities>) db.planActivityDao().getAllPlanActivitiesByPlanStageId(planStage.getId());
                if(!planActivities.isEmpty()){
                    activityListView.setVisibility(View.VISIBLE);
                    txtEmpty2.setVisibility(View.GONE);
                    ActivityPlanAdapter activityPlanAdapter = new ActivityPlanAdapter(getActivity());
                    activityListView.setAdapter(activityPlanAdapter);
                    activityListView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ArrayList<Activities> setList = new ArrayList<>();
                    for(PlanActivities planActivity : planActivities){
                        if(planActivity.getStartDate().isBefore(selectDate.plusDays(1)) && planActivity.getEndDate().isAfter(selectDate)){
                            setList.add(db.activityDao().getActivityById(planActivity.getActivityId()));
                        }
                    }
                    activityPlanAdapter.setActivities(setList);
                }

                break;
            }
            cardStage.setVisibility(View.GONE);
            activityListView.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
            txtEmpty2.setVisibility(View.VISIBLE);
        }
    }

    private void initView(View view) {
        monthYearText = view.findViewById(R.id.monthYearTV);
        btnDaily = view.findViewById(R.id.btnDaily);
        btnPrevious = view.findViewById(R.id.btnPrevious);
        btnNext = view.findViewById(R.id.btnNext);
        calendarRecyclerView = view.findViewById(R.id.calendarRecyclerView);
        txtEmpty = view.findViewById(R.id.txtEmpty);
        txtEmpty2 = view.findViewById(R.id.txtEmpty2);
        txtNameStage = view.findViewById(R.id.txtNameStage);
        txtDurationStage = view.findViewById(R.id.txtDurationStage);
        txtStartDate = view.findViewById(R.id.txtStartDate);
        cardStage = view.findViewById(R.id.stage);
        imageStage = view.findViewById(R.id.imageStage);
        activityListView = view.findViewById(R.id.activityListView);
        db = RiceGrowDatabase.getInstance(getActivity());
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date != null) {
            selectDate = date;
            setWeekView();
//            startActivity(new Intent(MainActivity.this, DailyCalendarActivity.class));
        }
    }
}