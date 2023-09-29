package com.example.ricegrow.Activity.Knowledge.Management;

import static com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.FertilizerActivity.FERTILIZER_KEY;
import static com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.PesticideActivity.PESTICIDE_KEY;
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
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.PesticideActivity;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class SupAdapter extends RecyclerView.Adapter<SupAdapter.ViewHolder> {

    private ArrayList<Pesticides> pesticides = new ArrayList<>();
    private ArrayList<Fertilizers> fertilizers = new ArrayList<>();
    private ArrayList<Stages> stages = new ArrayList<>();

    private Context context;

    public SupAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sup_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(pesticides.size() != 0) {
            holder.txtName.setText(pesticides.get(position).getName());
            Glide.with(context)
                    .asBitmap()
                    .load(pesticides.get(position).getPesticideImage())
                    .placeholder(R.drawable.baseline_restart_alt_24)
                    .error(R.drawable.baseline_error_outline_24)
                    .into(holder.image);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PesticideActivity.class);
                    intent.putExtra(PESTICIDE_KEY, pesticides.get(position));
                    context.startActivity(intent);
                }
            });
        }   else if (fertilizers.size() != 0) {
            holder.txtName.setText(fertilizers.get(position).getName());
            Glide.with(context)
                    .asBitmap()
                    .load(fertilizers.get(position).getFertImage())
                    .placeholder(R.drawable.baseline_restart_alt_24)
                    .error(R.drawable.baseline_error_outline_24)
                    .into(holder.image);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FertilizerActivity.class);
                    intent.putExtra(FERTILIZER_KEY, fertilizers.get(position));
                    context.startActivity(intent);
                }
            });
        } else if (stages.size() != 0) {
            if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
                holder.txtName.setText(stages.get(position).getNameEn());
            } else {
                holder.txtName.setText(stages.get(position).getNameVi());
            }
            Glide.with(context)
                    .asBitmap()
                    .load(stages.get(position).getStageImage())
                    .placeholder(R.drawable.baseline_restart_alt_24)
                    .error(R.drawable.baseline_error_outline_24)
                    .into(holder.image);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, StageActivity.class);
                    intent.putExtra(STAGE_KEY, stages.get(position));
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if(pesticides.size()!=0){
            return pesticides.size();
        } else if (stages.size()!=0) {
            return stages.size();
        } else if (fertilizers.size()!=0) {
            return fertilizers.size();
        }
        return 0;
    }

    public void setPesticides(ArrayList<Pesticides> pesticides) {
        this.pesticides = pesticides;
        notifyDataSetChanged();
    }

    public void setStages(ArrayList<Stages> stages) {
        this.stages = stages;
        notifyDataSetChanged();
    }

    public void setFertilizers(ArrayList<Fertilizers> fertilizers) {
        this.fertilizers = fertilizers;
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
