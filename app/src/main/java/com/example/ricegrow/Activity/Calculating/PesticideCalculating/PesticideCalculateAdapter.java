package com.example.ricegrow.Activity.Calculating.PesticideCalculating;

import static com.example.ricegrow.Activity.Calculating.PesticideCalculating.PesticideCalculate.PESTICIDE_CALCULATE_KEY;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PesticideCalculateAdapter extends RecyclerView.Adapter<PesticideCalculateAdapter.ViewHolder>{

    private ArrayList<Pesticides> pesticides = new ArrayList<>();
    private Context context;

    public PesticideCalculateAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pesticide, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNamePesticide.setText(pesticides.get(position).getName());
        holder.txtNameManufacturer.setText(pesticides.get(position).getManufacturer());
        if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
            holder.txtNameCategory.setText(pesticides.get(position).getCategoryEn());
        } else {
            holder.txtNameCategory.setText(pesticides.get(position).getCategoryVi());
        }
        Glide.with(context)
                .asBitmap()
                .load(pesticides.get(position).getPesticideImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imagePesticide);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PesticideCalculate.class);
                intent.putExtra(PESTICIDE_CALCULATE_KEY, pesticides.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pesticides.size();
    }

    public void setPesticides(ArrayList<Pesticides> pesticides) {
        this.pesticides = pesticides;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView imagePesticide;
        private TextView txtNamePesticide, txtNameManufacturer, txtNameCategory;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePesticide = itemView.findViewById(R.id.imagePesticide);
            txtNamePesticide = itemView.findViewById(R.id.txtNamePesticide);
            txtNameManufacturer = itemView.findViewById(R.id.txtNameManufacturer);
            txtNameCategory = itemView.findViewById(R.id.txtNameCategory);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
