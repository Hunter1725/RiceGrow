package com.hunter.ricegrow.Activity.Knowledge.Management;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hunter.ricegrow.Activity.Knowledge.Management.Crop.ListCrop;
import com.hunter.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities.ListDeftox;
import com.hunter.ricegrow.Activity.Knowledge.Management.Disease.ListDisease;
import com.hunter.ricegrow.Activity.Knowledge.Management.Pest.ListPest;
import com.hunter.ricegrow.Activity.Knowledge.Management.Weed.ListWeed;
import com.example.ricegrow.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainManagement extends Fragment {

    private MaterialCardView cardCrop,cardPest, cardDisease, cardWeed, cardDeftox;
    private MaterialButton btnCardCrop, btnCardPests, btnCardDisease, btnCardWeed, btnCardDeftox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_management, container, false);

        initView(view);

        initListener();

        return view;
    }

    private void initListener() {
        cardCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListCrop.class));
            }
        });
        btnCardCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListCrop.class));
            }
        });

        cardPest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListPest.class));
            }
        });
        btnCardPests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListPest.class));
            }
        });
        cardDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListDisease.class));
            }
        });

        btnCardDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListDisease.class));
            }
        });

        cardWeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListWeed.class));
            }
        });

        btnCardWeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListWeed.class));
            }
        });

        cardDeftox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListDeftox.class));
            }
        });
        btnCardDeftox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListDeftox.class));
            }
        });
    }

    private void initView(View view) {
        cardCrop = view.findViewById(R.id.cardCrop);
        cardPest = view.findViewById(R.id.cardPest);
        cardDisease = view.findViewById(R.id.cardDisease);
        cardWeed = view.findViewById(R.id.cardWeed);
        cardDeftox = view.findViewById(R.id.cardDeftox);
        btnCardCrop = view.findViewById(R.id.btnCardCrop);
        btnCardPests = view.findViewById(R.id.btnCardPests);
        btnCardDisease = view.findViewById(R.id.btnCardDisease);
        btnCardWeed = view.findViewById(R.id.btnCardWeed);
        btnCardDeftox = view.findViewById(R.id.btnCardDeftox);
    }
}
