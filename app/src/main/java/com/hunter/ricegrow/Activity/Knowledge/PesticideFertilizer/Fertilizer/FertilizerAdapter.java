package com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hunter.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.hunter.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.hunter.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FertilizerAdapter extends RecyclerView.Adapter<FertilizerAdapter.ViewHolder> {

    private ArrayList<Fertilizers> fertilizers = new ArrayList<>();
    private Context context;

    public FertilizerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fertilizer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameFertilizer.setText(fertilizers.get(position).getName());
        if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
            holder.txtNameManufacturer.setText(fertilizers.get(position).getManufacturerEn());
            holder.txtNameComposition.setText(fertilizers.get(position).getCompositionEn());
        } else {
            holder.txtNameManufacturer.setText(fertilizers.get(position).getManufacturerVi());
            holder.txtNameComposition.setText(fertilizers.get(position).getCompositionVi());
        }
        Glide.with(context)
                .asBitmap()
                .load(fertilizers.get(position).getFertImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageFertilizer);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FertilizerActivity.class);
                intent.putExtra(FertilizerActivity.FERTILIZER_KEY, fertilizers.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fertilizers.size();
    }

    public ArrayList<Fertilizers> getFertilizers() {
        return fertilizers;
    }

    public void setFertilizers(ArrayList<Fertilizers> fertilizers) {
        this.fertilizers = fertilizers;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView imageFertilizer;
        private TextView txtNameFertilizer, txtNameManufacturer, txtNameComposition;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFertilizer = itemView.findViewById(R.id.imageFertilizer);
            txtNameFertilizer = itemView.findViewById(R.id.txtNameFertilizer);
            txtNameManufacturer = itemView.findViewById(R.id.txtNameManufacturer);
            txtNameComposition = itemView.findViewById(R.id.txtNameComposition);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
