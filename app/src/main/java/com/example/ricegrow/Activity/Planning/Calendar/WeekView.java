package com.example.ricegrow.Activity.Planning.Calendar;

import static com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity.STAGE_KEY;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.daysInWeekArray;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.monthYearFromDate;
import static com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils.selectDate;
import static com.example.ricegrow.Activity.Planning.Plan.ViewPlan.USERCROP_KEY;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricegrow.Activity.Knowledge.StageActivity.Stage.StageActivity;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.CropStage;
import com.example.ricegrow.DatabaseFiles.Model.Notes;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class WeekView extends Fragment implements CalendarAdapter.OnItemListener{

    private TextView monthYearText, txtEmpty, txtEmpty2, txtNameStage, txtDurationStage, txtStartDate, txtContentNote, txtEmpty3;
    private Button  btnDaily, btnPrevious, btnNext, btnAddNote, btnDeleteNote;
    private MaterialCardView cardStage;
    private ShapeableImageView imageStage;
    private RecyclerView calendarRecyclerView, activityListView;
    private UserCrops incomingUserCrops;
    private RiceGrowDatabase db;
    private Stages stages;
    private PlanStages currentPlanStages;
    private Notes notes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.week_view, container, false);
        Bundle args = getArguments();
        if (args != null) {
            incomingUserCrops = args.getParcelable(USERCROP_KEY);
        }
        initView(view);
        setWeekView();
        initListener();


        return view;
    }

    private void initListener() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.plusWeeks(1);
                setWeekView();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.minusWeeks(1);
                setWeekView();
            }
        });

        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyView dailyView = new DailyView();
                Bundle args = new Bundle();
                args.putParcelable(USERCROP_KEY, incomingUserCrops);
                dailyView.setArguments(args);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerPlan, dailyView);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cardStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StageActivity.class);
                intent.putExtra(STAGE_KEY, stages);
                startActivity(intent);
            }
        });

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoteDialog();
            }
        });

        txtContentNote.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDeleteNote();
                return true;
            }
        });
        btnDeleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteNote();
            }
        });
    }

    private void showDeleteNote() {
        Notes deleteNotes = notes;
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext(), R.style.ThemeOverlay_App_MaterialAlertDialog);
        builder.setTitle(getString(R.string.delete_note));
        builder.setMessage(getString(R.string.are_you_sure_you_want_to_delete_this_note));
        builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Perform guest login action
                db.noteDao().delete(notes);
                Snackbar.make(getView(),getString(R.string.the_notes_was_removed), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.undo), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                db.noteDao().insert(deleteNotes);
                                setWeekView();
                            }
                        }).setActionTextColor(Color.parseColor("#4CAF50"))
                        .show();
                setWeekView();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showNoteDialog() {
        // Inflate the dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.note_layout, null);

        // Access the TextView in the dialog layout
        TextInputLayout textInputLayoutNote = dialogView.findViewById(R.id.textInputLayoutNote);
        TextInputEditText edtNote = dialogView.findViewById(R.id.edtNote);

        // Create a MaterialAlertDialogBuilder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_App_MaterialAlertDialog2);
        builder.setView(dialogView)
                .setTitle(getString(R.string.add_new_note))
                .setPositiveButton(getString(R.string.add), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String contentNote = edtNote.getText().toString();

                        if(contentNote.isEmpty()){
                            textInputLayoutNote.setError(getString(R.string.please_enter_something));
                        }
                        else {
                            db.noteDao().insert(new Notes(currentPlanStages.getId(), selectDate, contentNote));
                            setWeekView();
                        }
                    }
                })
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setWeekView() {
        monthYearText.setText(monthYearFromDate(selectDate));
        ArrayList<LocalDate> days = daysInWeekArray(selectDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this, incomingUserCrops,getActivity());
        calendarRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        calendarRecyclerView.setAdapter(calendarAdapter);
        assignData();
    }

    private void assignData() {
        ArrayList<PlanStages> planStages = (ArrayList<PlanStages>) db.planStageDao().getAllPlanStageByUserCropId(incomingUserCrops.getId());
        for (PlanStages planStage : planStages){
            if (planStage.getStartDate().isBefore(selectDate.plusDays(1)) && planStage.getEndDate().isAfter(selectDate)) {
                //Stage
                cardStage.setVisibility(View.VISIBLE);
                txtEmpty.setVisibility(View.GONE);
                stages = db.stageDao().getStageById(planStage.getStageId());
                if(GetCurrentLanguage.getCurrentLanguage(getActivity()).equals("en")) {
                    txtNameStage.setText(stages.getNameEn());
                } else {
                    txtNameStage.setText(stages.getNameVi());
                }
                CropStage cropStage = db.cropStageDao().getCropStageByStageIdAndCropId(stages.getId(), incomingUserCrops.getCropId());
                Glide.with(getActivity())
                        .asBitmap()
                        .load(stages.getStageImage())
                        .placeholder(R.drawable.baseline_restart_alt_24)
                        .error(R.drawable.baseline_error_outline_24)
                        .into(imageStage);
                String durationStage = cropStage.getDuration() + getString(R.string.days);
                txtDurationStage.setText(durationStage);
                if(GetCurrentLanguage.getCurrentLanguage(getActivity()).equals("en")) {
                    String startDate = cropStage.getStartDate() + getString(R.string.day);
                    txtStartDate.setText(startDate);
                } else {
                    String startDate = String.valueOf("Ngày thứ " + cropStage.getStartDate());
                    txtStartDate.setText(startDate);
                }

                //Activities
                ArrayList<PlanActivities> planActivities = (ArrayList<PlanActivities>) db.planActivityDao().getAllPlanActivitiesByPlanStageId(planStage.getId());
                if(!planActivities.isEmpty()){
                    ActivityPlanAdapter activityPlanAdapter = new ActivityPlanAdapter(getActivity());
                    activityListView.setAdapter(activityPlanAdapter);
                    activityListView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ArrayList<Activities> setList = new ArrayList<>();
                    for(PlanActivities planActivity : planActivities){
                        if(planActivity.getStartDate().isBefore(selectDate.plusDays(1)) && planActivity.getEndDate().isAfter(selectDate)){
                            activityListView.setVisibility(View.VISIBLE);
                            txtEmpty2.setVisibility(View.GONE);
                            setList.add(db.activityDao().getActivityById(planActivity.getActivityId()));
                        } else {
                            activityListView.setVisibility(View.GONE);
                            txtEmpty2.setVisibility(View.VISIBLE);
                        }
                    }
                    if(setList.isEmpty()){
                        activityListView.setVisibility(View.GONE);
                        txtEmpty2.setVisibility(View.VISIBLE);
                    } else {
                        activityListView.setVisibility(View.VISIBLE);
                        txtEmpty2.setVisibility(View.GONE);
                        activityPlanAdapter.setActivities(setList);
                    }
                }

                //Notes
                currentPlanStages = planStage;
                notes = db.noteDao().getNotesByPlanActivityId(currentPlanStages.getId(), selectDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
                if( notes != null && notes.getDate().isEqual(selectDate)){
                    txtEmpty3.setVisibility(View.GONE);
                    btnAddNote.setVisibility(View.GONE);
                    btnDeleteNote.setVisibility(View.VISIBLE);
                    txtContentNote.setVisibility(View.VISIBLE);
                    txtContentNote.setText(notes.getContent());
                } else {
                    txtEmpty3.setVisibility(View.VISIBLE);
                    btnAddNote.setVisibility(View.VISIBLE);
                    btnDeleteNote.setVisibility(View.GONE);
                    txtContentNote.setVisibility(View.GONE);
                }

                break;
            }
            cardStage.setVisibility(View.GONE);
            activityListView.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
            txtEmpty2.setVisibility(View.VISIBLE);
            txtEmpty3.setVisibility(View.VISIBLE);
            btnAddNote.setVisibility(View.GONE);
            btnDeleteNote.setVisibility(View.GONE);
            txtContentNote.setVisibility(View.GONE);
        }
    }

    private void initView(View view) {
        monthYearText = view.findViewById(R.id.monthYearTV);
        btnDaily = view.findViewById(R.id.btnDaily);
        btnPrevious = view.findViewById(R.id.btnPrevious);
        btnNext = view.findViewById(R.id.btnNext);
        btnAddNote = view.findViewById(R.id.btnAddNote);
        btnDeleteNote = view.findViewById(R.id.btnDeleteNote);
        calendarRecyclerView = view.findViewById(R.id.calendarRecyclerView);
        txtEmpty = view.findViewById(R.id.txtEmpty);
        txtEmpty2 = view.findViewById(R.id.txtEmpty2);
        txtNameStage = view.findViewById(R.id.txtNameStage);
        txtDurationStage = view.findViewById(R.id.txtDurationStage);
        txtStartDate = view.findViewById(R.id.txtStartDate);
        txtContentNote = view.findViewById(R.id.txtContentNote);
        txtEmpty3 = view.findViewById(R.id.txtEmpty3);
        cardStage = view.findViewById(R.id.stage);
        imageStage = view.findViewById(R.id.imageStage);
        activityListView = view.findViewById(R.id.activityListView);
        db = RiceGrowDatabase.getInstance(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date != null) {
            selectDate = date;
            setWeekView();
//            startActivity(new Intent(MainActivity.this, DailyCalendarActivity.class));
        }
    }
}