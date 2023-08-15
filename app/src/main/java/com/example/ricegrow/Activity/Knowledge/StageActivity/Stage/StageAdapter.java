package com.example.ricegrow.Activity.Knowledge.StageActivity.Stage;

import static com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerActivity.FERTILIZER_KEY;
import static com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity.STAGE_KEY;

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
import com.example.ricegrow.DatabaseFiles.Model.CropStage;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class StageAdapter extends RecyclerView.Adapter<StageAdapter.ViewHolder>{

    private ArrayList<Stages> stages = new ArrayList<>();
    private Context context;
    private RiceGrowDatabase db;

    public StageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stage, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CropStage cropStage = db.cropStageDao().getFirstCropStageByStageId(stages.get(position).getId());
        holder.txtNameStage.setText(stages.get(position).getName());
        String duration = String.valueOf(cropStage.getDuration()) + context.getString(R.string.days);
        holder.txtDurationStage.setText(duration);
        String startDate = String.valueOf(cropStage.getStartDate()) + context.getString(R.string.day);
        holder.txtStartDate.setText(startDate);
        Glide.with(context)
                .asBitmap()
                .load(stages.get(position).getStageImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageStage);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StageActivity.class);
                intent.putExtra(STAGE_KEY, stages.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stages.size();
    }

    public void setStages(ArrayList<Stages> stages) {
        this.stages = stages;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView imageStage;
        private TextView txtNameStage, txtDurationStage, txtStartDate;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageStage = itemView.findViewById(R.id.imageStage);
            txtNameStage = itemView.findViewById(R.id.txtNameStage);
            txtDurationStage = itemView.findViewById(R.id.txtDurationStage);
            txtStartDate = itemView.findViewById(R.id.txtStartDate);
            parent = itemView.findViewById(R.id.parent);
            db = RiceGrowDatabase.getInstance(context);
        }
    }
}
