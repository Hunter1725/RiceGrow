package com.example.ricegrow.Activity.Knowledge.Management;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ricegrow.Activity.Knowledge.Management.Crop.ListCrop;
import com.example.ricegrow.Activity.Knowledge.Management.Disease.ListDisease;
import com.example.ricegrow.Activity.Knowledge.Management.Pest.ListPest;
import com.example.ricegrow.Activity.Knowledge.Management.Weed.ListWeed;
import com.example.ricegrow.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainManagement extends Fragment {

    private MaterialCardView cardCrop,cardPest, cardDisease, cardWeed;
    private MaterialButton btnCardCrop, btnCardPests, btnCardDisease, btnCardWeed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_management, container, false);

        initView(view);

        initListener();

        return view;
    }

    private void initListener() {

        btnCardCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListCrop.class));
            }
        });

        btnCardPests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListPest.class));
            }
        });

        btnCardDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListDisease.class));
            }
        });

        btnCardWeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListWeed.class));
            }
        });
    }

    private void initView(View view) {
        cardCrop = view.findViewById(R.id.cardCrop);
        cardPest = view.findViewById(R.id.cardPest);
        cardDisease = view.findViewById(R.id.cardDisease);
        cardWeed = view.findViewById(R.id.cardWeed);
        btnCardCrop = view.findViewById(R.id.btnCardCrop);
        btnCardPests = view.findViewById(R.id.btnCardPests);
        btnCardDisease = view.findViewById(R.id.btnCardDisease);
        btnCardWeed = view.findViewById(R.id.btnCardWeed);
    }
}
