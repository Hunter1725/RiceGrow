package com.example.ricegrow.Activity.Knowledge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ricegrow.Activity.Knowledge.Management.MainManagement;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.MainPestFer;
import com.example.ricegrow.Activity.Knowledge.StageActivity.MainStageActivity;
import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainKnowledge extends Fragment {

    private MaterialCardView cardStageActivity, cardPestFer, cardManagement;
    private MaterialButton btnCardStageActivity, btnCardPestFer, btnCardManagement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_knowledge, container, false);

        initView(view);

        initListener();

        return view;
    }

    private void initListener() {
        btnCardStageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).replaceFragment(new MainStageActivity());
            }
        });

        btnCardPestFer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).replaceFragment(new MainPestFer());
            }
        });

        btnCardManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).replaceFragment(new MainManagement());
            }
        });

    }


    private void initView(View view) {
        cardStageActivity = view.findViewById(R.id.cardStageActivity);
        cardPestFer = view.findViewById(R.id.cardPestFer);
        cardManagement = view.findViewById(R.id.cardManagement);
        btnCardStageActivity = view.findViewById(R.id.btnCardStageActivity);
        btnCardPestFer = view.findViewById(R.id.btnCardPestFer);
        btnCardManagement = view.findViewById(R.id.btnCardManagement);
    }
}
