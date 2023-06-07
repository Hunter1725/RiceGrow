package com.example.ricegrow.Activity.Main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ricegrow.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainFragment extends Fragment {
    private MaterialCardView cardStages, cardPestFer, cardManagement;
    private MaterialButton btnCardStages, btnCardPestFer, btnCardManagement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_knowledge, container, false);

        initView(view);


        return view;
    }



    private void initView(View view) {
        cardStages = view.findViewById(R.id.cardStages);
        cardPestFer = view.findViewById(R.id.cardPestFer);
        cardManagement = view.findViewById(R.id.cardManagement);
        btnCardStages = view.findViewById(R.id.btnCardStages);
    }
}
