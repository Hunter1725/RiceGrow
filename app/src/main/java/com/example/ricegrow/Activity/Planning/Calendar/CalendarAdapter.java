package com.example.ricegrow.Activity.Planning.Calendar;

import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.selectDate;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder>{

    private final ArrayList<LocalDate> days;
    private final OnItemListener onItemListener;
    private UserCrops incomingUserCrops;
    private RiceGrowDatabase db;
    private final Context context;

    public CalendarAdapter(ArrayList<LocalDate> days, OnItemListener onItemListener, Context context) {
        this.days = days;
        this.onItemListener = onItemListener;
        this.context = context;
    }

    public CalendarAdapter(ArrayList<LocalDate> days, OnItemListener onItemListener, UserCrops incomingUserCrops, Context context) {
        this.days = days;
        this.onItemListener = onItemListener;
        this.incomingUserCrops = incomingUserCrops;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        //Month view
        if (days.size() > 16) {
            layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        }
        //Week view
        else {
            layoutParams.height = (int) parent.getHeight();
        }
        return new ViewHolder(view, onItemListener, days);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LocalDate date = days.get(position);
        if(incomingUserCrops != null){
            db = RiceGrowDatabase.getInstance(context);
            ArrayList<PlanStages> planStages = (ArrayList<PlanStages>) db.planStageDao().getAllPlanStageByUserCropId(incomingUserCrops.getId());
            for (PlanStages planStage : planStages) {
                if (planStage.getStartDate().isBefore(date.plusDays(1)) && planStage.getEndDate().isAfter(date)) {
                    Stages stages = db.stageDao().getStageById(planStage.getStageId());
                    holder.stageName.setVisibility(View.VISIBLE);
                    holder.stageName.setText(stages.getName());
                    ArrayList<PlanActivities> planActivities = (ArrayList<PlanActivities>) db.planActivityDao().getAllPlanActivitiesByPlanStageId(planStage.getId());
                    if(!planActivities.isEmpty()){
                        for(PlanActivities planActivity : planActivities){
                            if(planActivity.getStartDate().isBefore(selectDate.plusDays(1)) && planActivity.getEndDate().isAfter(selectDate)){
                                holder.activityName.setVisibility(View.VISIBLE);
                                Activities activities = db.activityDao().getActivityById(planActivity.getActivityId());
                                holder.activityName.setText(activities.getName());
                            }
                        }
                    }
                }
            }
        }

        holder.dayOfMonth.setText(String.valueOf(date.getDayOfMonth()));

        if(date.equals(selectDate)){
            holder.dayOfMonth.setBackgroundResource(R.drawable.circle_outline_green_background);
        }

        if (date.getMonth().equals(selectDate.getMonth())){
            if(date.equals(LocalDate.now())){
                holder.dayOfMonth.setBackgroundResource(R.drawable.circle_green_background);
            }else {
                holder.dayOfMonth.setTextColor(Color.BLACK);
            }
        } else {
            holder.dayOfMonth.setTextColor(Color.LTGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final ArrayList<LocalDate> days;
        public final View parentView;
        public final TextView dayOfMonth, stageName, activityName;
        private final CalendarAdapter.OnItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListener, ArrayList<LocalDate> days) {
            super(itemView);
            parentView = itemView.findViewById(R.id.parentViewPlan);
            dayOfMonth = itemView.findViewById(R.id.cellDayPlan);
            stageName = itemView.findViewById(R.id.stageName);
            activityName = itemView.findViewById(R.id.activityName);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
            this.days = days;
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition(), days.get(getAdapterPosition()));
        }
    }

    public interface OnItemListener{
        void onItemClick (int position, LocalDate date);
    }
}
