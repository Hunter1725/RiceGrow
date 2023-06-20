package com.example.ricegrow.Activity.Knowledge.Management.Pest;

import static com.example.ricegrow.Activity.Knowledge.Management.Disease.DiseaseActivity.DISEASE_KEY;
import static com.example.ricegrow.Activity.Knowledge.Management.Pest.PestActivity.PEST_KEY;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricegrow.Activity.Knowledge.Management.Crop.CropAdapter;
import com.example.ricegrow.Activity.Knowledge.Management.Disease.DiseaseActivity;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PestAdapter extends RecyclerView.Adapter<PestAdapter.ViewHolder> {

    private ArrayList<Pests> pests = new ArrayList<>();
    private Context context;

    public PestAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pest, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNamePest.setText(pests.get(position).getName());
        holder.txtValueLifecycle.setText(pests.get(position).getLifecycle());
        holder.txtValueDes.setText(pests.get(position).getDescription());
        Glide.with(context)
                .asBitmap()
                .load(pests.get(position).getPestImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imagePest);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PestActivity.class);
                intent.putExtra(PEST_KEY, pests.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pests.size();
    }

    public void setPests(ArrayList<Pests> pests) {
        this.pests = pests;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ShapeableImageView imagePest;
        private TextView txtNamePest, txtValueLifecycle, txtValueDes;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePest = itemView.findViewById(R.id.imagePest);
            txtNamePest = itemView.findViewById(R.id.txtNamePest);
            txtValueLifecycle = itemView.findViewById(R.id.txtValueLifecycle);
            txtValueDes = itemView.findViewById(R.id.txtValueDes);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
