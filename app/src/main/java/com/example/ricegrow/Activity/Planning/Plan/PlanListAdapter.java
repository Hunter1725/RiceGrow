package com.example.ricegrow.Activity.Planning.Plan;

import static com.example.ricegrow.Activity.Planning.Plan.ViewPlan.USERCROP_KEY;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class PlanListAdapter extends RecyclerView.Adapter<PlanListAdapter.ViewHolder>{

    private final ArrayList<UserCrops> userCrops;

    private final Context context;

    private RiceGrowDatabase db;

    public PlanListAdapter(ArrayList<UserCrops> userCrops, Context context) {
        this.userCrops = userCrops;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        db = RiceGrowDatabase.getInstance(context);
        holder.txtRiceVariety.setText(db.cropDao().getCropById(userCrops.get(position).getCropId()).getName());
        String areaString = userCrops.get(position).getSowedArea() + " ha";
        holder.txtArea.setText(areaString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.getDefault());
        String dateString = userCrops.get(position).getSowingDate().format(formatter);
        holder.txtSowingDate.setText(dateString);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewPlan.class);
                intent.putExtra(USERCROP_KEY, userCrops.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userCrops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout parent;
        private TextView txtRiceVariety, txtSowingDate, txtArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRiceVariety = itemView.findViewById(R.id.txtRiceVariety);
            txtSowingDate = itemView.findViewById(R.id.txtSowingDate);
            txtArea = itemView.findViewById(R.id.txtArea);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
