package com.example.ricegrow.Activity.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.Setting;
import com.example.ricegrow.DatabaseFiles.Model.Weather;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Locale;

public class SettingActivity extends AppCompatActivity {
    private MaterialToolbar toolbarSetting;
    private TextInputLayout languageDropdown;
    private AutoCompleteTextView languageAutoCompleteTextView;
    private MaterialSwitch switchDaily, switchStart;
    private TextView txtUnitWeather;
    private LinearLayout layoutWeather;
    private RiceGrowDatabase db;
    private Setting setting;
    private String unitTemp = "";
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_setting);

        initView();

        initListener();

        initDropDownMenu();

    }

    private void initDropDownMenu() {
        ArrayList<String> customArray = new ArrayList<>();
        customArray.add("Tiếng Việt");
        customArray.add("English");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.pesticide_dropdown_menu, customArray);
        languageAutoCompleteTextView.setAdapter(adapter);

        languageAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String language = (String) parent.getItemAtPosition(position);
                if (language.equals("English")) {
                    restart();
                    setting.setLanguage("en");
                    db.settingDao().updateSetting(setting);
                } else if (language.equals("Tiếng Việt")) {
                    restart();
                    setting.setLanguage("vi");
                    db.settingDao().updateSetting(setting);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SettingActivity.this, MainActivity.class));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        RiceGrowDatabase db = RiceGrowDatabase.getInstance(this);
        String lng = db.settingDao().getAll().getLanguage();
        Locale locale;

        locale = new Locale(lng);
        Locale.setDefault(locale);

        Context context = ContextWrapper.wrap(newBase, locale);
        super.attachBaseContext(context);
    }


    public void restart() {
        startActivity(new Intent(this, SettingActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    private void initListener() {
        toolbarSetting.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        switchDaily.setChecked(setting.isNotification());
        switchDaily.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setting.setNotification(isChecked);
                db.settingDao().updateSetting(setting);
            }
        });

        switchStart.setChecked(setting.isShowAgain());
        switchStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setting.setShowAgain(isChecked);
                db.settingDao().updateSetting(setting);
            }
        });

        if (weather.getUnit().equals("°C")) {
            String celsius = "Celsius (°C)";
            txtUnitWeather.setText(celsius);
        } else if (weather.getUnit().equals("°F")) {
            String fahrenheit = "Fahrenheit (°F)";
            txtUnitWeather.setText(fahrenheit);
        }
        layoutWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTemperatureUnitDialog();
            }
        });
    }


    private void showTemperatureUnitDialog() {
        // List of temperature unit options to display in the dialog
        final String[] temperatureUnits = {"Celsius (°C)", "Fahrenheit (°F)"};
        // Get the current selected unit (you can retrieve this from shared preferences if available)
        int selectedUnitIndex = 2; // Default to Celsius
        if (unitTemp.equals("°C")) {
            selectedUnitIndex = 0;
            String celsius = "Celsius (°C)";
            txtUnitWeather.setText(celsius);
        } else if (unitTemp.equals("°F")) {
            selectedUnitIndex = 1;
            String fahrenheit = "Fahrenheit (°F)";
            txtUnitWeather.setText(fahrenheit);
        }
        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog2);
        dialogBuilder.setTitle(getString(R.string.choose_temperature_unit))
                .setSingleChoiceItems(temperatureUnits, selectedUnitIndex, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle the user's selection
                        switch (which) {
                            case 0: // Celsius selected
                                unitTemp = "°C";
                                saveTemperatureUnit(unitTemp);
                                String celsius = "Celsius (°C)";
                                txtUnitWeather.setText(celsius);
                                break;
                            case 1: // Fahrenheit selected
                                unitTemp = "°F";
                                saveTemperatureUnit(unitTemp);
                                String fahrenheit = "Fahrenheit (°F)";
                                txtUnitWeather.setText(fahrenheit);
                                break;
                        }
                        // Dismiss the dialog after the user's selection
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("OK", null); // No action needed for OK button

        // Show the dialog
        dialogBuilder.show();
    }

    private void saveTemperatureUnit(String unit) {
        weather = db.weatherDao().getAll();
        weather.setUnit(unit);
        db.weatherDao().updateWeather(weather);
    }

    private void initView() {
        toolbarSetting = findViewById(R.id.toolbarSetting);
        languageDropdown = findViewById(R.id.languageDropdown);
        languageAutoCompleteTextView = findViewById(R.id.languageAutoCompleteTextView);
        switchDaily = findViewById(R.id.switchDaily);
        switchStart = findViewById(R.id.switchStart);
        txtUnitWeather = findViewById(R.id.txtUnitWeather);
        layoutWeather = findViewById(R.id.layoutWeather);
        db = RiceGrowDatabase.getInstance(this);
        setting = db.settingDao().getAll();
        weather = db.weatherDao().getAll();
        if (weather == null) {
            weather = new Weather();
            weather.setUnit("°C");
            db.weatherDao().insert(weather);
        }
        unitTemp = weather.getUnit();
    }
}