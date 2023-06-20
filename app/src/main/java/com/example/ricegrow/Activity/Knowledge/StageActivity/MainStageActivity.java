package com.example.ricegrow.Activity.Knowledge.StageActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.ListFertilizer;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.ListPesticide;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Activity.ListActivity;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.ListStage;
import com.example.ricegrow.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainStageActivity extends Fragment {
    private MaterialCardView cardStages, cardActivities;
    private MaterialButton btnCardStages, btnCardActivities;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_stage_activity, container, false);

        initView(view);

        initListener();


        return view;
    }

    private void initListener() {
        btnCardStages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListStage.class));
            }
        });

        btnCardActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListActivity.class));
            }
        });
    }

    private void initView(View view) {
        cardStages = view.findViewById(R.id.cardStages);
        cardActivities = view.findViewById(R.id.cardActivities);
        btnCardStages = view.findViewById(R.id.btnCardStages);
        btnCardActivities = view.findViewById(R.id.btnCardActivities);
    }
}
