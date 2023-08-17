package com.example.ricegrow.Activity.Knowledge.PesticideFertilizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Fertilizer.ListFertilizer;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.Pesticide.ListPesticide;
import com.example.ricegrow.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainPestFer extends Fragment {

    private MaterialCardView cardPesticides, cardFertilizers;
    private MaterialButton btnCardPesticides, btnCardFertilizers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_pest_fer, container, false);

        initView(view);

        initListener();


        return view;
    }



    private void initListener() {
        cardPesticides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListPesticide.class));
            }
        });
        btnCardPesticides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListPesticide.class));
            }
        });

        cardFertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListFertilizer.class));
            }
        });
        btnCardFertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListFertilizer.class));
            }
        });
    }


    private void initView(View view) {
        cardPesticides = view.findViewById(R.id.cardPesticides);
        cardFertilizers = view.findViewById(R.id.cardFertilizers);
        btnCardPesticides = view.findViewById(R.id.btnCardPesticides);
        btnCardFertilizers = view.findViewById(R.id.btnCardFertilizers);
    }
}
