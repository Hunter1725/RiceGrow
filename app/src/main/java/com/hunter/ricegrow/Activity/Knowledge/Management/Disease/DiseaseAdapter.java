package com.hunter.ricegrow.Activity.Knowledge.Management.Disease;

import static com.hunter.ricegrow.Activity.Knowledge.Management.Disease.DiseaseActivity.DISEASE_KEY;

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
import com.hunter.ricegrow.DatabaseFiles.Model.Diseases;
import com.hunter.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.ViewHolder>{

    private ArrayList<Diseases> diseases = new ArrayList<>();
    private Context context;

    public DiseaseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.disease, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
            holder.txtNameDisease.setText(diseases.get(position).getNameEn());
            holder.txtValueSymptom.setText(diseases.get(position).getSymptomsEn());
            holder.txtValueDes.setText(diseases.get(position).getDescriptionEn());
        } else {
            holder.txtNameDisease.setText(diseases.get(position).getNameVi());
            holder.txtValueSymptom.setText(diseases.get(position).getSymptomsVi());
            holder.txtValueDes.setText(diseases.get(position).getDescriptionVi());
        }
        Glide.with(context)
                .asBitmap()
                .load(diseases.get(position).getDiseaseImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageDisease);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DiseaseActivity.class);
                intent.putExtra(DISEASE_KEY, diseases.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return diseases.size();
    }

    public void setDiseases(ArrayList<Diseases> diseases) {
        this.diseases = diseases;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView imageDisease;
        private TextView txtNameDisease, txtValueSymptom, txtValueDes;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDisease = itemView.findViewById(R.id.imageDisease);
            txtNameDisease = itemView.findViewById(R.id.txtNameDisease);
            txtValueSymptom = itemView.findViewById(R.id.txtValueSymptom);
            txtValueDes = itemView.findViewById(R.id.txtValueDes);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
