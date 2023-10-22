package com.hunter.ricegrow.Activity.Planning;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hunter.ricegrow.Activity.Planning.Plan.PlanGenerate;
import com.hunter.ricegrow.Activity.Planning.Plan.PlanListAdapter;
import com.hunter.ricegrow.DatabaseFiles.Model.UserCrops;
import com.hunter.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainPlanning extends Fragment {
    private TextView txtEmpty;
    private ShapeableImageView imageEmpty;
    private RecyclerView plansListView;
    private ExtendedFloatingActionButton btnNewPlan;
    private RiceGrowDatabase db;
    private ArrayList<UserCrops> userCrops;
    private PlanListAdapter planListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_planning, container, false);

        initView(view);

        initListener();

        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {
        userCrops = (ArrayList<UserCrops>) db.userCropDao().getAllUserCrops();
        if(userCrops.size() > 0) {
            plansListView.setVisibility(View.VISIBLE);
            txtEmpty.setVisibility(View.GONE);
            imageEmpty.setVisibility(View.GONE);
            planListAdapter = new PlanListAdapter(userCrops, getActivity());
            plansListView.setAdapter(planListAdapter);
            plansListView.setLayoutManager(new LinearLayoutManager(getActivity()));

            //Divider
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
            plansListView.addItemDecoration(dividerItemDecoration);

            //ItemTouch (Swipe)
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
            itemTouchHelper.attachToRecyclerView(plansListView);
        } else {
            plansListView.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
            imageEmpty.setVisibility(View.VISIBLE);
        }
    }

    //ItemTouch (Swipe)
    UserCrops deletedPlan = null;
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();

            if (direction == ItemTouchHelper.LEFT) {
                deletedPlan = userCrops.get(position);
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext(), R.style.ThemeOverlay_App_MaterialAlertDialog);
                builder.setTitle(getString(R.string.delete_plan));
                builder.setMessage(getString(R.string.are_you_sure_you_want_to_delete_the_plan) + deletedPlan.getName() + "?" + getString(R.string.nwarning_you_can_undo_this_but_all_created_notes_will_be_deleted_forever));
                builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform guest login action
                        db.userCropDao().delete(deletedPlan); // Delete from the database first
                        userCrops.remove(position); // Then remove from the list
                        planListAdapter.notifyItemRemoved(position);
                        Snackbar.make(plansListView, getString(R.string.the_plan) + deletedPlan.getName() + getString(R.string.was_removed), Snackbar.LENGTH_LONG)
                                .setAction(getString(R.string.undo), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        db.userCropDao().insert(deletedPlan); // Insert back to the database
                                        userCrops.add(position, deletedPlan); // Add back to the list
                                        planListAdapter.notifyItemInserted(position);
                                        initRecyclerView();
                                    }
                                }).setActionTextColor(Color.parseColor("#4CAF50"))
                                .show();
                        initRecyclerView();
                    }
                });
                builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        initRecyclerView();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE && isCurrentlyActive) {
                View itemView = viewHolder.itemView;
                Paint paint = new Paint();
                Drawable icon = ContextCompat.getDrawable(getActivity(), R.drawable.bin);
                int iconMargin = (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;

                // Draw the red background
                paint.setColor(Color.parseColor("#F84949"));
                c.drawRect(itemView.getRight() + dX, itemView.getTop(), itemView.getRight(), itemView.getBottom(), paint);

                // Draw the icon on the background
                int iconLeft = itemView.getRight() - iconMargin - icon.getIntrinsicWidth();
                int iconRight = itemView.getRight() - iconMargin;
                int iconTop = itemView.getTop() + iconMargin;
                int iconBottom = itemView.getBottom() - iconMargin;
                icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                icon.draw(c);
            }
        }
    };

    private void initListener() {
        btnNewPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PlanGenerate.class));
            }
        });

    }

    private void initView(View view) {
        txtEmpty = view.findViewById(R.id.txtEmpty);
        imageEmpty = view.findViewById(R.id.imageEmpty);
        plansListView = view.findViewById(R.id.plansListView);
        btnNewPlan = view.findViewById(R.id.btnNewPlan);
        db = RiceGrowDatabase.getInstance(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
    }
}
