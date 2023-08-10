package com.example.ricegrow.Activity.Planning.Plan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.ricegrow.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ColorPickerDialog {
    private static Dialog dialog;
    public interface OnColorSelectedListener {
        void onColorSelected(int color);
    }

    public static void show(Context context, final OnColorSelectedListener listener) {
        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context, R.style.ThemeOverlay_App_MaterialAlertDialog2);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_color_picker, null);
        GridView colorGrid = dialogView.findViewById(R.id.colorGrid);

        final int[] colors = {
                Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA,
                Color.CYAN, Color.BLACK, Color.WHITE, Color.GRAY, Color.DKGRAY
        };

        ColorAdapter colorAdapter = new ColorAdapter(colors, listener);
        colorGrid.setAdapter(colorAdapter);

        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Pick a color");
        dialogBuilder.setNegativeButton("Cancel", null);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    private static class ColorAdapter extends BaseAdapter {
        private final int[] colors;
        private final OnColorSelectedListener listener;

        ColorAdapter(int[] colors, OnColorSelectedListener listener) {
            this.colors = colors;
            this.listener = listener;
        }

        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public Object getItem(int position) {
            return colors[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_color_square, parent, false);
            }

            final int color = colors[position];
            view.setBackgroundColor(color);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onColorSelected(color);
                        dialog.dismiss();
                    }
                }
            });

            return view;
        }
    }
}
