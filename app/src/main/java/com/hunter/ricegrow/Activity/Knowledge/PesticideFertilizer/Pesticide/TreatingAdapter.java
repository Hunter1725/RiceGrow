package com.hunter.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide;

import static com.hunter.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities.DeftoxActivity.DEFTOX_KEY;
import static com.hunter.ricegrow.Activity.Knowledge.Management.Pest.PestActivity.PEST_KEY;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hunter.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities.DeftoxActivity;
import com.hunter.ricegrow.Activity.Knowledge.Management.Disease.DiseaseActivity;
import com.hunter.ricegrow.Activity.Knowledge.Management.Pest.PestActivity;
import com.hunter.ricegrow.Activity.Knowledge.Management.Weed.WeedActivity;
import com.hunter.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.hunter.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.hunter.ricegrow.DatabaseFiles.Model.Diseases;
import com.hunter.ricegrow.DatabaseFiles.Model.Pests;
import com.hunter.ricegrow.DatabaseFiles.Model.Weeds;
import com.hunter.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class TreatingAdapter extends RecyclerView.Adapter<TreatingAdapter.ViewHolder>{

    private ArrayList<Pests> pests = new ArrayList<>();
    private ArrayList<Diseases> diseases = new ArrayList<>();
    private ArrayList<Weeds> weeds = new ArrayList<>();
    private ArrayList<DeficienciesToxicities> deficienciesToxicities = new ArrayList<>();

    private Context context;

    public TreatingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.treating, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(pests.size()!=0){
            if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
                holder.txtName.setText(pests.get(position).getNameEn());
            } else {
                holder.txtName.setText(pests.get(position).getNameVi());
            }
            Glide.with(context)
                    .asBitmap()
                    .load(pests.get(position).getPestImage())
                    .placeholder(R.drawable.baseline_restart_alt_24)
                    .error(R.drawable.baseline_error_outline_24)
                    .into(holder.image);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PestActivity.class);
                    intent.putExtra(PEST_KEY, pests.get(position));
                    context.startActivity(intent);
                }
            });
        } else if (diseases.size()!=0) {
            if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
                holder.txtName.setText(diseases.get(position).getNameEn());
            } else {
                holder.txtName.setText(diseases.get(position).getNameVi());

            }
            Glide.with(context)
                    .asBitmap()
                    .load(diseases.get(position).getDiseaseImage())
                    .placeholder(R.drawable.baseline_restart_alt_24)
                    .error(R.drawable.baseline_error_outline_24)
                    .into(holder.image);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DiseaseActivity.class);
                    intent.putExtra(DiseaseActivity.DISEASE_KEY, diseases.get(position));
                    context.startActivity(intent);
                }
            });
        } else if (weeds.size()!=0) {
            if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
                holder.txtName.setText(weeds.get(position).getNameEn());
            } else {
                holder.txtName.setText(weeds.get(position).getNameVi());
            }
            Glide.with(context)
                    .asBitmap()
                    .load(weeds.get(position).getWeed_image())
                    .placeholder(R.drawable.baseline_restart_alt_24)
                    .error(R.drawable.baseline_error_outline_24)
                    .into(holder.image);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, WeedActivity.class);
                    intent.putExtra(WeedActivity.WEED_KEY, weeds.get(position));
                    context.startActivity(intent);
                }
            });
        } else if (deficienciesToxicities.size()!=0) {
            if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
                holder.txtName.setText(deficienciesToxicities.get(position).getNameEn());
            } else {
                holder.txtName.setText(deficienciesToxicities.get(position).getNameVi());
            }
            Glide.with(context)
                    .asBitmap()
                    .load(deficienciesToxicities.get(position).getDeftoxImage())
                    .placeholder(R.drawable.baseline_restart_alt_24)
                    .error(R.drawable.baseline_error_outline_24)
                    .into(holder.image);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DeftoxActivity.class);
                    intent.putExtra(DEFTOX_KEY, deficienciesToxicities.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(pests.size()!=0){
            return pests.size();
        } else if (diseases.size()!=0) {
            return diseases.size();
        } else if (weeds.size()!=0) {
            return weeds.size();
        } else if (deficienciesToxicities.size()!=0) {
            return deficienciesToxicities.size();
        }
        return 0;
    }

    public void setPests(ArrayList<Pests> pests) {
        this.pests = pests;
        notifyDataSetChanged();
    }

    public void setDiseases(ArrayList<Diseases> diseases) {
        this.diseases = diseases;
        notifyDataSetChanged();
    }

    public void setWeeds(ArrayList<Weeds> weeds) {
        this.weeds = weeds;
        notifyDataSetChanged();
    }

    public void setDeficienciesToxicities(ArrayList<DeficienciesToxicities> deficienciesToxicities) {
        this.deficienciesToxicities = deficienciesToxicities;
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
