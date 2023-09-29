package com.example.ricegrow.Activity.Calculating;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate;
import com.example.ricegrow.Activity.Calculating.PesticideCalculating.SelectPesticide;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;

public class MainCalculating extends Fragment {
    private MaterialCardView fertilizerCard, pesticideCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_calculating, container, false);

        initView(view);

        initListener();

        return view;
    }

    private void initListener() {
        fertilizerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getActivity(), FertilizerCalculate.class));
            }
        });

        pesticideCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SelectPesticide.class));
            }
        });
    }

    private void initView(View view) {
        fertilizerCard = view.findViewById(R.id.fertilizerCard);
        pesticideCard = view.findViewById(R.id.pesticideCard);
    }
}
