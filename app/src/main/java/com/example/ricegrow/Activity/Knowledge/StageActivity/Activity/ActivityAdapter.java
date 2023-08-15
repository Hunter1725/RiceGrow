package com.example.ricegrow.Activity.Knowledge.StageActivity.Activity;

import static com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerActivity.FERTILIZER_KEY;
import static com.example.ricegrow.Activity.Knowledge.StageActivity.Activity.FarmingActivity.ACTIVITY_KEY;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerActivity;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerAdapter;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder>{

    private ArrayList<Activities> activities = new ArrayList<>();
    private Context context;

    public ActivityAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameActivity.setText(activities.get(position).getName());
        holder.txtValueDescription.setText(activities.get(position).getDescription());
        String duration = String.valueOf(activities.get(position).getDuration()) + context.getString(R.string.days);
        holder.txtValueDuration.setText(duration);
        Glide.with(context)
                .asBitmap()
                .load(activities.get(position).getActivityImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageActivity);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FarmingActivity.class);
                intent.putExtra(ACTIVITY_KEY, activities.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public void setActivities(ArrayList<Activities> activities) {
        this.activities = activities;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ShapeableImageView imageActivity;
        private TextView txtNameActivity, txtValueDescription, txtValueDuration;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageActivity = itemView.findViewById(R.id.imageActivity);
            txtNameActivity = itemView.findViewById(R.id.txtNameActivity);
            txtValueDescription = itemView.findViewById(R.id.txtValueDescription);
            txtValueDuration = itemView.findViewById(R.id.txtValueDuration);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
