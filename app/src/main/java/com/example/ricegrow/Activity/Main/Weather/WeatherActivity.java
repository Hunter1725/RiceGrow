package com.example.ricegrow.Activity.Main.Weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.WindowCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricegrow.Activity.Knowledge.Management.Crop.CropActivity;
import com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils;
import com.example.ricegrow.Activity.Main.Weather.Model.DailyWeatherData;
import com.example.ricegrow.Activity.Main.Weather.Model.DailyWeatherResponse;
import com.example.ricegrow.Activity.Setting.ContextWrapper;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.DatabaseFiles.Model.Weather;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {
    public static final String API_KEY = "3486c23c3e2271c65e299d28ee6eb4a8";
    private static final String TAG = "WeatherActivity";
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private static final int REQUEST_CHECK_SETTINGS = 2001;
    private FusedLocationProviderClient fusedLocationClient;
    private MaterialToolbar toolbarWeather;
    private TextView txtDate, txtTemp, txtWind, txtHumidity, txtMaxMin, txtWeatherDes, txtWeatherRecommend, txtDay1, txtDay2, txtDay3, txtDay4, txtTempDay1,
            txtTempDay2, txtTempDay3, txtTempDay4, txtRainForecast, txtDayTip, txtDayRecommend, txtEmpty;
    private ImageView imageWeather, imageDay1, imageDay2, imageDay3, imageDay4;
    private LinearLayout mainLayout, requestLayout, tinyTipLayout;
    private Button btnRequestGPS;
    private CircularProgressIndicator progressCalculate;
    private String unitTemp = "";
    private List<DailyWeatherData> dailyDataList;
    private Weather weather;
    private RiceGrowDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_weather);
        initView();
        initListener();
        requestLocationUpdates();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    private LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(@NonNull LocationResult locationResult) {
            Location location = locationResult.getLastLocation();
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                // Call the API with the latitude and longitude to get weather data
                getWeatherData(latitude, longitude);
            }
        }
    };

    private void getWeatherData(double latitude, double longitude) {
        String units = "metric"; // Use "metric" for Celsius or "imperial" for Fahrenheit
        int numberOfDays = 5; // Fetch forecast for the next 5 days

        WeatherApiService apiService = WeatherApiClient.getClient();
        Call<DailyWeatherResponse> call = null;
        if(GetCurrentLanguage.getCurrentLanguage(WeatherActivity.this).equals("en")) {
            call = apiService.getDailyWeatherData(latitude, longitude, API_KEY, units, numberOfDays);
        } else {
            call = apiService.getDailyWeatherDataVi(latitude, longitude, API_KEY, units, numberOfDays,"vi");
        }
        call.enqueue(new Callback<DailyWeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<DailyWeatherResponse> call, @NonNull Response<DailyWeatherResponse> response) {
                if (response.isSuccessful()) {
                    DailyWeatherResponse dailyResponse = response.body();
                    if (dailyResponse != null) {
                        dailyDataList = dailyResponse.getWeatherResponseList();
                        if (!dailyDataList.isEmpty()) {
                            updateUI(dailyDataList);
                            rainForecast(dailyDataList);
                            tinyTip(dailyDataList);
                        }
                    }
                } else {
                    Toast.makeText(WeatherActivity.this, getString(R.string.something_error_can_not_get_the_weather_data_please_try_again), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DailyWeatherResponse> call, Throwable t) {
                // Handle failure
                t.printStackTrace();
            }
        });
    }

    private void tinyTip(List<DailyWeatherData> dailyDataList) {
        String tipRecommend = "";
        for (int i = 1; i < dailyDataList.size(); i++) {
            DailyWeatherData d = dailyDataList.get(i);
            if (d.getWeather().get(0).getMain().equals("Rain") || d.getWeather().get(0).getMain().equals("Thunderstorm")) {
                tinyTipLayout.setVisibility(View.VISIBLE);
                txtEmpty.setVisibility(View.GONE);
                txtDayTip.setText(CalendarUtils.formattedFullWeek(getLocalDateTimeFromTimestamp((long) d.getDt())));
                if (d.getHumidity() > 80 || d.getSpeed() > 15) {
                    tipRecommend = getString(R.string.use_fertilizers);
                    txtDayRecommend.setText(tipRecommend);
                } else {
                    tipRecommend = getString(R.string.use_pesticides);
                    txtDayRecommend.setText(tipRecommend);
                }
                break;
            }
        }
        if (tipRecommend.isEmpty()){
            tinyTipLayout.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
            txtEmpty.setText(R.string.no_tip_for_next_4_days);
        }
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

    private void rainForecast(List<DailyWeatherData> dailyDataList) {
        StringBuilder rainForecast = null;
        for (int i = 1; i < dailyDataList.size(); i++) {
            DailyWeatherData d = dailyDataList.get(i);
            if (d.getWeather().get(0).getMain().equals("Rain")) {
                if (rainForecast == null) {
                    rainForecast = new StringBuilder(CalendarUtils.formattedFullWeek(getLocalDateTimeFromTimestamp((long) d.getDt())));
                } else {
                    rainForecast.append(", ").append(CalendarUtils.formattedFullWeek(getLocalDateTimeFromTimestamp((long) d.getDt())));
                }
            }
        }
        if (rainForecast == null){
            txtRainForecast.setText(getString(R.string.no_rain_forecast_in_4_next_days));
        } else {
            txtRainForecast.setText(getString(R.string.it_is_raining_this) + rainForecast.toString());
        }
    }

    private void updateUI(List<DailyWeatherData> dailyDataList) {
        updateWeatherSection(dailyDataList.get(0), txtDate, txtTemp, txtWind, txtHumidity, txtMaxMin, txtWeatherDes, imageWeather, false);

        // Next 4 days
        if (dailyDataList.size() > 1) {
            updateWeatherSection(dailyDataList.get(1), txtDay1, txtTempDay1, null, null, null, null, imageDay1, true);
            updateWeatherSection(dailyDataList.get(2), txtDay2, txtTempDay2, null, null, null, null, imageDay2, true);
            updateWeatherSection(dailyDataList.get(3), txtDay3, txtTempDay3, null, null, null, null, imageDay3, true);
            updateWeatherSection(dailyDataList.get(4), txtDay4, txtTempDay4, null, null, null, null, imageDay4, true);
        }

        mainLayout.setVisibility(View.VISIBLE);
        progressCalculate.setVisibility(View.GONE);
    }

    private void updateWeatherSection(DailyWeatherData weatherData, TextView dateView, TextView tempView, TextView windView,
                                      TextView humidityView, TextView maxMinView, TextView weatherDesView, ImageView weatherImageView, boolean week) {
        LocalDate localDate = getLocalDateTimeFromTimestamp(weatherData.getDt());
        LocalTime currentTime = LocalTime.now();
        if (week) {
            dateView.setText(CalendarUtils.formattedWeek(localDate));
        } else {
            weather = db.weatherDao().getAll();
            weather.setId(db.weatherDao().getAll().getId());
            weather.setDate(localDate);
            weather.setDescription(weatherData.getWeather().get(0).getDescription());
            weather.setMain(weatherData.getWeather().get(0).getMain());
            weather.setHumidity(weatherData.getHumidity());
            weather.setSpeed(weatherData.getSpeed());
            if (currentTime.isBefore(LocalTime.of(12, 0))) {
                // Morning (before 12:00 PM)
                weather.setTemp(weatherData.getTemperature().getDay());
            } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
                // Afternoon/Evening (12:00 PM - 6:00 PM)
                weather.setTemp(weatherData.getTemperature().getEve());
            } else {
                // Night (after 6:00 PM)
                weather.setTemp(weatherData.getTemperature().getNight());
            }
            db.weatherDao().updateWeather(weather);
            dateView.setText(CalendarUtils.formattedDayOfWeek(localDate));
            String weatherRecommend = "";
            if (weatherData.getWeather().get(0).getMain().equals("Rain") || weatherData.getWeather().get(0).getMain().equals("Thunderstorm")) {
                if(weatherData.getHumidity() > 80 || weatherData.getSpeed() > 15) {
                    weatherRecommend = getString(R.string.use_fertilizers);
                    txtWeatherRecommend.setText(weatherRecommend);
                } else {
                    weatherRecommend = getString(R.string.use_pesticides);
                    txtWeatherRecommend.setText(weatherRecommend);
                }
            } else {
                weatherRecommend = getString(R.string.nothing);
                txtWeatherRecommend.setText(weatherRecommend);
            }

        }
        int valueTemp;

        if (currentTime.isBefore(LocalTime.of(12, 0))) {
            // Morning (before 12:00 PM)
            valueTemp = (int) weatherData.getTemperature().getDay();
        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            // Afternoon/Evening (12:00 PM - 6:00 PM)
            valueTemp = (int) weatherData.getTemperature().getEve();
        } else {
            // Night (after 6:00 PM)
            valueTemp = (int) weatherData.getTemperature().getNight();
        }

        if (unitTemp.equals("°F")){
            valueTemp = (valueTemp * 9/5) + 32;
        }
        String temp = valueTemp + unitTemp;
        tempView.setText(temp);
        if (windView != null) {
            windView.setText(weatherData.getSpeed() + " m/s");
        }
        if (humidityView != null) {
            humidityView.setText(weatherData.getHumidity() + "%");
        }
        if (maxMinView != null) {
            int max = (int) weatherData.getTemperature().getMax();
            int min = (int) weatherData.getTemperature().getMin();
            if (unitTemp.equals("°F")){
                max = (max * 9/5) + 32;
                min = (min * 9/5) + 32;
            }
            maxMinView.setText(max + unitTemp + " / " + min + unitTemp);
        }
        if (weatherDesView != null) {
            String description = weatherData.getWeather().get(0).getDescription();
            String capitalizedDescription = capitalizeFirstLetter(description);
            weatherDesView.setText(capitalizedDescription);
        }

        if (weatherImageView != null) {
            String weather = weatherData.getWeather().get(0).getMain();
            setWeatherImage(weather, weatherData.getWeather().get(0).getDescription(), weatherImageView);
        }
    }

    private void setWeatherImage(String weather, String description, ImageView weatherImageView) {
        switch (weather) {
            case "Clear":
                weatherImageView.setImageResource(R.drawable.sun);
                break;
            case "Clouds":
                if(GetCurrentLanguage.getCurrentLanguage(WeatherActivity.this).equals("en")) {
                    switch (description) {
                        case "few clouds":
                            weatherImageView.setImageResource(R.drawable.cloudy_sunny);
                            break;
                        case "scattered clouds":
                            weatherImageView.setImageResource(R.drawable.cloudy);
                            break;
                        case "broken clouds":
                        case "overcast clouds":
                            weatherImageView.setImageResource(R.drawable.cloudy_3);
                            break;
                    }
                } else {
                    switch (description) {
                        case "mây thưa":
                            weatherImageView.setImageResource(R.drawable.cloudy_sunny);
                            break;
                        case "mây rải rác":
                            weatherImageView.setImageResource(R.drawable.cloudy);
                            break;
                        case "mây cụm":
                        case "mây đen u ám":
                            weatherImageView.setImageResource(R.drawable.cloudy_3);
                            break;
                    }
                }
                break;
            case "Rain":
                weatherImageView.setImageResource(R.drawable.rainy);
                break;
            case "Thunderstorm":
                weatherImageView.setImageResource(R.drawable.storm);
                break;
            case "Snow":
                weatherImageView.setImageResource(R.drawable.snowy);
                break;
        }
    }

    public static String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }


    public static LocalDate getLocalDateTimeFromTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalDate();
    }


    private void requestLocationUpdates() {
        LocationRequest locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000).build();

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        LocationSettingsRequest locationSettingsRequest = builder.build();

        // Check if the necessary location settings are satisfied
        settingsClient.checkLocationSettings(locationSettingsRequest)
                .addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        // All location settings are satisfied. Request location updates here.
                        requestLocationUpdatesWithPermission();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof ResolvableApiException) {
                            // Location settings are not satisfied, but the user can resolve it.
                            try {
                                // Show a dialog to ask the user to enable location settings.
                                ResolvableApiException resolvable = (ResolvableApiException) e;
                                resolvable.startResolutionForResult(WeatherActivity.this, REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException sendEx) {
                                // Ignore the error.
                            }
                        } else {
                            // Location settings are not satisfied, and cannot be resolved directly.
                            // Handle this case appropriately (e.g., show an error message).
                            Toast.makeText(WeatherActivity.this, getString(R.string.location_settings_are_not_satisfied), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (resultCode == RESULT_OK) {
                // User enabled location settings. Request location updates with permission.
                requestLocationUpdatesWithPermission();
            } else {
                // User canceled or didn't enable location settings. Handle this case appropriately.
                Toast.makeText(WeatherActivity.this, getString(R.string.location_settings_are_not_enabled), Toast.LENGTH_LONG).show();
                mainLayout.setVisibility(View.GONE);
                requestLayout.setVisibility(View.VISIBLE);
            }
        }
    }

    private void requestLocationUpdatesWithPermission() {
        // Check for location permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Permissions are already granted, proceed with requesting location updates
            LocationRequest locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000).build();
            progressCalculate.setVisibility(View.VISIBLE);
            requestLayout.setVisibility(View.GONE);
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);

        } else {
            mainLayout.setVisibility(View.GONE);
            requestLayout.setVisibility(View.VISIBLE);
            // Request permissions
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    && ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // User has previously denied the permission, show a rationale and request again if needed
                showSnackbar();
            } else {
                // Request the permissions directly
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                }, LOCATION_PERMISSION_REQUEST_CODE);
            }
        }
    }

    private void showSnackbar() {
        // Show a Snackbar to explain the need for permissions and prompt the user to grant them
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.location_permission_is_required_for_this_app_to_work), Snackbar.LENGTH_INDEFINITE)
                .setAction("Grant", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Request the permissions when the "Grant" button is clicked in the Snackbar
                        ActivityCompat.requestPermissions(WeatherActivity.this, new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                        }, LOCATION_PERMISSION_REQUEST_CODE);
                    }
                })
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            // Check if the permissions were granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // Permissions are granted, proceed with requesting location updates
                requestLocationUpdates();
            } else {
                // Permissions are denied, handle this case (e.g., show an error message)
                Toast.makeText(this, getString(R.string.location_permissions_are_required_for_this_app_to_work), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void showTemperatureUnitDialog() {
        // List of temperature unit options to display in the dialog
        final String[] temperatureUnits = {"Celsius (°C)", "Fahrenheit (°F)"};
        // Get the current selected unit (you can retrieve this from shared preferences if available)
        int selectedUnitIndex = 2; // Default to Celsius
        if(unitTemp.equals("°C")){
            selectedUnitIndex = 0;
        } else if (unitTemp.equals("°F")){
            selectedUnitIndex = 1;
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
                                updateUI(dailyDataList);
                                break;
                            case 1: // Fahrenheit selected
                                unitTemp = "°F";
                                saveTemperatureUnit(unitTemp);
                                updateUI(dailyDataList);
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


    private void initListener() {
        toolbarWeather.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarWeather.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.tempUnit) {
                    //Show dialog to choose temp unit
                    showTemperatureUnitDialog();
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        btnRequestGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLocationUpdates();
            }
        });
    }


    private void initView() {
        toolbarWeather = findViewById(R.id.toolbarWeather);
        txtDate = findViewById(R.id.txtDate);
        txtTemp = findViewById(R.id.txtTemp);
        txtWind = findViewById(R.id.txtWind);
        txtHumidity = findViewById(R.id.txtHumidity);
        txtMaxMin = findViewById(R.id.txtMaxMin);
        txtWeatherDes = findViewById(R.id.txtWeatherDes);
        txtWeatherRecommend = findViewById(R.id.txtWeatherRecommend);
        txtDay1 = findViewById(R.id.txtDay1);
        txtDay2 = findViewById(R.id.txtDay2);
        txtDay3 = findViewById(R.id.txtDay3);
        txtDay4 = findViewById(R.id.txtDay4);
        txtTempDay1 = findViewById(R.id.txtTempDay1);
        txtTempDay2 = findViewById(R.id.txtTempDay2);
        txtTempDay3 = findViewById(R.id.txtTempDay3);
        txtTempDay4 = findViewById(R.id.txtTempDay4);
        txtRainForecast = findViewById(R.id.txtRainForecast);
        txtDayTip = findViewById(R.id.txtDayTip);
        txtDayRecommend = findViewById(R.id.txtDayRecommend);
        txtEmpty = findViewById(R.id.txtEmpty);
        imageWeather = findViewById(R.id.imageWeather);
        imageDay1 = findViewById(R.id.imageDay1);
        imageDay2 = findViewById(R.id.imageDay2);
        imageDay3 = findViewById(R.id.imageDay3);
        imageDay4 = findViewById(R.id.imageDay4);
        mainLayout = findViewById(R.id.mainLayout);
        requestLayout = findViewById(R.id.requestLayout);
        tinyTipLayout = findViewById(R.id.tinyTipLayout);
        btnRequestGPS = findViewById(R.id.btnRequestGPS);
        progressCalculate = findViewById(R.id.progressCalculate);
        db = RiceGrowDatabase.getInstance(this);
        weather = db.weatherDao().getAll();
        if(weather == null){
            weather = new Weather();
            weather.setUnit("°C");
            db.weatherDao().insert(weather);
        }
        unitTemp = weather.getUnit();
    }
}