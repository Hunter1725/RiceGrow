package com.example.ricegrow.Activity.Main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities.ListDeftox;
import com.example.ricegrow.Activity.Knowledge.Management.Disease.ListDisease;
import com.example.ricegrow.Activity.Knowledge.Management.Pest.ListPest;
import com.example.ricegrow.Activity.Knowledge.Management.Pest.PestActivity;
import com.example.ricegrow.Activity.Knowledge.Management.Weed.ListWeed;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.ListFertilizer;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.ListPesticide;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class SwipeViewAdapter extends RecyclerView.Adapter<SwipeViewAdapter.ViewHolder>{
    private final ArrayList<SwipeModel> swipeModels;
    private final Context context;

    public SwipeViewAdapter(ArrayList<SwipeModel> swipeModels, Context context) {
        this.swipeModels = swipeModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_swipeview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageCard.setImageResource(swipeModels.get(position).getImage());
        holder.titleCard.setText(swipeModels.get(position).getTitle());
        holder.cardPestFer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (swipeModels.get(position).getTitle()) {
                    case "Pests":
                        context.startActivity(new Intent(context, ListPest.class));
                        break;
                    case "Diseases":
                        context.startActivity(new Intent(context, ListDisease.class));
                        break;
                    case "Weeds":
                        context.startActivity(new Intent(context, ListWeed.class));
                        break;
                    case "Deficiencies and toxicities":
                        context.startActivity(new Intent(context, ListDeftox.class));
                        break;
                    case "Pesticides":
                        context.startActivity(new Intent(context, ListPesticide.class));
                        break;
                    case "Fertilizers":
                        context.startActivity(new Intent(context, ListFertilizer.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return swipeModels.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView imageCard;
        private TextView titleCard;

        private MaterialCardView cardPestFer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCard = itemView.findViewById(R.id.imageCard);
            titleCard = itemView.findViewById(R.id.titleCard);
            cardPestFer = itemView.findViewById(R.id.cardPestFer);
        }
    }

}
