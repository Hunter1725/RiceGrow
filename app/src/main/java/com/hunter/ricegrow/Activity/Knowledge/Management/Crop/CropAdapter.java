package com.hunter.ricegrow.Activity.Knowledge.Management.Crop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hunter.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class CropAdapter extends RecyclerView.Adapter<CropAdapter.ViewHolder>{

    private ArrayList<Crops> crops = new ArrayList<>();
    private Context context;

    public CropAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameCrop.setText(crops.get(position).getName());
        String growth = context.getString(R.string.about) + String.valueOf(crops.get(position).getGrowthPeriod()) + context.getString(R.string.days);
        holder.txtValueGrowth.setText(growth);
        String price = crops.get(position).getSellingPrice() + " VND/kg";
        holder.txtValuePrice.setText(price);
        Glide.with(context)
                .asBitmap()
                .load(crops.get(position).getCropImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageCrop);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CropActivity.class);
                intent.putExtra(CropActivity.CROP_KEY, crops.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return crops.size();
    }

    public void setCrops(ArrayList<Crops> crops) {
        this.crops = crops;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ShapeableImageView imageCrop;
        private TextView txtNameCrop, txtValueGrowth, txtValuePrice;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCrop = itemView.findViewById(R.id.imageCrop);
            txtNameCrop = itemView.findViewById(R.id.txtNameCrop);
            txtValueGrowth = itemView.findViewById(R.id.txtValueGrowth);
            txtValuePrice = itemView.findViewById(R.id.txtValuePrice);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
