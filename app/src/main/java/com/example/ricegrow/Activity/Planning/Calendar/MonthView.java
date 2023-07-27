package com.example.ricegrow.Activity.Planning.Calendar;

import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.daysInMonthArray;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.monthYearFromDate;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.selectDate;
import static com.example.ricegrow.Activity.Planning.Plan.ViewPlan.USERCROP_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonthView extends Fragment implements CalendarAdapter.OnItemListener{
    private TextView monthYearText;
    private Button btnWeekly, btnPrevious, btnNext;
    private RecyclerView calendarRecyclerView;
    private UserCrops incomingUserCrops;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.month_view, container, false);
        // Retrieve data from arguments Bundle
        Bundle args = getArguments();
        if (args != null) {
            incomingUserCrops = args.getParcelable(USERCROP_KEY);
        }
        initView(view);
        setMonthView();
        initListener();


        return view;
    }

    private void setMonthView() {
        monthYearText.setText(monthYearFromDate(selectDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray();

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this, incomingUserCrops, getActivity());
        calendarRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    private void initListener() {

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.minusMonths(1);
                setMonthView();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.plusMonths(1);
                setMonthView();
            }
        });

        btnWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeekView weekView = new WeekView();
                Bundle args = new Bundle();
                args.putParcelable(USERCROP_KEY, incomingUserCrops);
                weekView.setArguments(args);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerPlan, weekView);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void initView(View view) {
        monthYearText = view.findViewById(R.id.monthYearTV);
        btnWeekly = view.findViewById(R.id.btnWeekly);
        btnPrevious = view.findViewById(R.id.btnPrevious);
        btnNext = view.findViewById(R.id.btnNext);
        calendarRecyclerView = view.findViewById(R.id.calendarRecyclerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        setMonthView();
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date != null) {
            selectDate = date;
            setMonthView();
            DailyView dailyView = new DailyView();
            Bundle args = new Bundle();
            args.putParcelable(USERCROP_KEY, incomingUserCrops);
            dailyView.setArguments(args);
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerPlan, dailyView);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();        }
    }
}
