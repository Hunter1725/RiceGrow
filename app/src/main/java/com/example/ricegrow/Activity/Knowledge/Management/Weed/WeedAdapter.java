package com.example.ricegrow.Activity.Knowledge.Management.Weed;

import static com.example.ricegrow.Activity.Knowledge.Management.Weed.WeedActivity.WEED_KEY;

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
import com.example.ricegrow.DatabaseFiles.Model.Weeds;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class WeedAdapter extends RecyclerView.Adapter<WeedAdapter.ViewHolder>{

    private ArrayList<Weeds> weeds = new ArrayList<>();

    private Context context;

    public WeedAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(GetCurrentLanguage.getCurrentLanguage(context).equals("en")) {
            holder.txtNameWeed.setText(weeds.get(position).getNameEn());
            holder.txtValueEcology.setText(weeds.get(position).getEcologyEn());
            holder.txtValueImpact.setText(weeds.get(position).getImpactEn());
        } else {
            holder.txtNameWeed.setText(weeds.get(position).getNameVi());
            holder.txtValueEcology.setText(weeds.get(position).getEcologyVi());
            holder.txtValueImpact.setText(weeds.get(position).getImpactVi());
        }
        Glide.with(context)
                .asBitmap()
                .load(weeds.get(position).getWeed_image())
                .placeholder(R.drawable.baseline_restart_alt_24)
                .error(R.drawable.baseline_error_outline_24)
                .into(holder.imageWeed);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WeedActivity.class);
                intent.putExtra(WEED_KEY, weeds.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return weeds.size();
    }

    public void setWeeds(ArrayList<Weeds> weeds) {
        this.weeds = weeds;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView imageWeed;
        private TextView txtNameWeed, txtValueEcology, txtValueImpact;
        private MaterialCardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageWeed = itemView.findViewById(R.id.imageWeed);
            txtNameWeed = itemView.findViewById(R.id.txtNameWeed);
            txtValueEcology = itemView.findViewById(R.id.txtValueEcology);
            txtValueImpact = itemView.findViewById(R.id.txtValueImpact);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
