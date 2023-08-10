package com.example.ricegrow.Activity.Planning.Plan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.R;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StageCheckboxAdapter extends RecyclerView.Adapter<StageCheckboxAdapter.StageViewHolder>{

    private List<Stages> stages;
    private final Context context;
    private List<Integer> selectedStageIds = new ArrayList<>();

    public StageCheckboxAdapter(Context context) {
        this.context = context;
    }

    public void setStages(List<Stages> stages) {
        this.stages = stages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stage_checkbox, parent, false);
        return new StageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StageViewHolder holder, int position) {
        Stages stage = stages.get(position);
        holder.checkBoxStage.setText(stage.getName());
        Glide.with(context)
                .asBitmap()
                .load(stages.get(position).getStageImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageStage);
        holder.checkBoxStage.setChecked(stage.isSelected());

        holder.checkBoxStage.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked && !selectedStageIds.contains(stage.getId())) {
                selectedStageIds.add(stage.getId());
            } else if(!isChecked && selectedStageIds.contains(stage.getId())){
                selectedStageIds.remove((Integer) stage.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return stages != null ? stages.size() : 0;
    }

    public List<Integer> getSelectedStageIds() {
        // Sort the list in ascending order
        Collections.sort(selectedStageIds);

        // Return the sorted list
        return selectedStageIds;
    }

    public void selectAllStages(boolean selectAll) {
        for (Stages stage : stages) {
            stage.setSelected(selectAll);
            int stageId = stage.getId();
            if (selectAll && !selectedStageIds.contains(stageId)) {
                selectedStageIds.add(stageId);
            } else if (!selectAll && selectedStageIds.contains(stageId)) {
                selectedStageIds.remove((Integer) stageId);
            }
        }
        notifyDataSetChanged();
    }

    public static class StageViewHolder extends RecyclerView.ViewHolder {
        MaterialCheckBox checkBoxStage;
        ImageView imageStage;

        StageViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxStage = itemView.findViewById(R.id.checkBoxStage);
            imageStage = itemView.findViewById(R.id.imageStage);
        }
    }
}
