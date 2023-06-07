package com.example.ricegrow.Activity.Knowledge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ricegrow.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainKnowledge extends Fragment {

    private MaterialCardView cardStages, cardPestFer, cardManagement;
    private MaterialButton btnCardStages, btnCardPestFer, btnCardManagement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_knowledge, container, false);

        initView(view);

        initListener();

        return view;
    }

    private void initListener() {
        btnCardStages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Stages selected!", Toast.LENGTH_SHORT).show();
            }
        });

        btnCardPestFer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pesticide - Fertilizer selected!", Toast.LENGTH_SHORT).show();
            }
        });

        btnCardManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Management selected!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initView(View view) {
        cardStages = view.findViewById(R.id.cardStages);
        cardPestFer = view.findViewById(R.id.cardPestFer);
        cardManagement = view.findViewById(R.id.cardManagement);
        btnCardStages = view.findViewById(R.id.btnCardStages);
        btnCardPestFer = view.findViewById(R.id.btnCardPestFer);
        btnCardManagement = view.findViewById(R.id.btnCardManagement);
    }
}
