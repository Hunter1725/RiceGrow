package com.example.ricegrow.Activity.Knowledge.PesticideFertilizer;

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
import com.example.ricegrow.Activity.Knowledge.Management.Crop.CropActivity;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Activity.FarmingActivity;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class UsingAdapter extends RecyclerView.Adapter<UsingAdapter.ViewHolder>{

    private ArrayList<Activities> activities = new ArrayList<>();

    private Context context;

    public UsingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.using, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
            holder.txtName.setText(activities.get(position).getNameEn());
        } else {
            holder.txtName.setText(activities.get(position).getNameVi());
        }
        Glide.with(context)
                .asBitmap()
                .load(activities.get(position).getActivityImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.image);
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView image;
        private TextView txtName;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            txtName = itemView.findViewById(R.id.txtName);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
