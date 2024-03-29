package com.hunter.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities;

import static com.hunter.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities.DeftoxActivity.DEFTOX_KEY;

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
import com.hunter.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.hunter.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class DeftoxAdapter extends RecyclerView.Adapter<DeftoxAdapter.ViewHolder>{
    private ArrayList<DeficienciesToxicities> deficienciesToxicities = new ArrayList<>();
    private Context context;

    public DeftoxAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deficiencies_toxicities, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
            holder.txtNameDeftox.setText(deficienciesToxicities.get(position).getNameEn());
            holder.txtValueSymptom.setText(deficienciesToxicities.get(position).getSymptomsEn());
            holder.txtValueDes.setText(deficienciesToxicities.get(position).getDescriptionEn());
        } else {
            holder.txtNameDeftox.setText(deficienciesToxicities.get(position).getNameVi());
            holder.txtValueSymptom.setText(deficienciesToxicities.get(position).getSymptomsVi());
            holder.txtValueDes.setText(deficienciesToxicities.get(position).getDescriptionVi());
        }
        Glide.with(context)
                .asBitmap()
                .load(deficienciesToxicities.get(position).getDeftoxImage())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageDeftox);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeftoxActivity.class);
                intent.putExtra(DEFTOX_KEY, deficienciesToxicities.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return deficienciesToxicities.size();
    }

    public void setDeficienciesToxicities(ArrayList<DeficienciesToxicities> deficienciesToxicities) {
        this.deficienciesToxicities = deficienciesToxicities;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ShapeableImageView imageDeftox;
        private TextView txtNameDeftox, txtValueSymptom, txtValueDes;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDeftox = itemView.findViewById(R.id.imageDeftox);
            txtNameDeftox = itemView.findViewById(R.id.txtNameDeftox);
            txtValueSymptom = itemView.findViewById(R.id.txtValueSymptom);
            txtValueDes = itemView.findViewById(R.id.txtValueDes);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
