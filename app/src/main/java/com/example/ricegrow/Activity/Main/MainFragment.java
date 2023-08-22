package com.example.ricegrow.Activity.Main;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate;
import com.example.ricegrow.Activity.Planning.Calendar.CalendarUtils;
import com.example.ricegrow.Activity.Planning.Plan.PlanGenerate;
import com.example.ricegrow.Activity.Planning.Plan.PlanListAdapter;
import com.example.ricegrow.Activity.Main.Weather.WeatherActivity;
import com.example.ricegrow.Activity.Setting.ContextWrapper;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.Model.Weather;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Locale;

public class MainFragment extends Fragment implements NetworkUtils.OnConnectivityChangeListener {
    private MaterialCardView fertilizerCard, planCard, weatherCard;
    private RecyclerView plansListView;
    private TextView txtEmpty, txtDate, txtTemp, txtWind, txtHumidity, txtWeatherRecommend, txtWeatherDes, updateWeather;
    private ViewPager2 viewPager;
    private LinearLayout indicatorLayout, weatherLayout, lostLayout;
    private ArrayList<SwipeModel> swipeModels;
    private Handler sliderHandler = new Handler();
    private RiceGrowDatabase db;
    private ImageView imageWeather;

    private NetworkUtils networkUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        initView(view);
        // Create an instance of NetworkConnectivityMonitor and register the listener
        networkUtils = new NetworkUtils(getActivity());
        networkUtils.setListener(this);
        networkUtils.register();

        initSwipeCard();
        createIndicators(swipeModels.size());
        initListener();
        initRecyclerView();
        initWeatherForecast();

        return view;
    }
    private void initWeatherForecast() {
        if (networkUtils.isConnected()) {
            weatherLayout.setVisibility(View.VISIBLE);
            lostLayout.setVisibility(View.GONE);
            Weather weather = db.weatherDao().getAll();
            if (weather != null && weather.getHumidity() > 0) {
                updateWeather.setVisibility(View.GONE);
                txtDate.setText(CalendarUtils.formattedDayOfWeek(weather.getDate()));
                int valueTemp = (int) weather.getTemp();
                if (weather.getUnit().equals("°F")) {
                    valueTemp = (valueTemp * 9 / 5) + 32;
                }
                String temp = valueTemp + weather.getUnit();
                txtTemp.setText(temp);
                txtWind.setText(weather.getSpeed() + " m/s");
                txtHumidity.setText(weather.getHumidity() + "%");
                txtWeatherDes.setText(WeatherActivity.capitalizeFirstLetter(weather.getDescription()));
                switch (weather.getMain()) {
                    case "Clear":
                        imageWeather.setImageResource(R.drawable.sun);
                        break;
                    case "Clouds":
                        if(GetCurrentLanguage.getCurrentLanguage(getActivity()).equals("en")) {
                            switch (weather.getDescription()) {
                                case "few clouds":
                                    imageWeather.setImageResource(R.drawable.cloudy_sunny);
                                    break;
                                case "scattered clouds":
                                    imageWeather.setImageResource(R.drawable.cloudy);
                                    break;
                                case "broken clouds":
                                case "overcast clouds":
                                    imageWeather.setImageResource(R.drawable.cloudy_3);
                                    break;
                            }
                        } else {
                            switch (weather.getDescription()) {
                                case "mây thưa":
                                    imageWeather.setImageResource(R.drawable.cloudy_sunny);
                                    break;
                                case "mây rải rác":
                                    imageWeather.setImageResource(R.drawable.cloudy);
                                    break;
                                case "mây cụm":
                                case "mây đen u ám":
                                    imageWeather.setImageResource(R.drawable.cloudy_3);
                                    break;
                            }
                        }
                        break;
                    case "Rain":
                        imageWeather.setImageResource(R.drawable.rainy);
                        break;
                    case "Thunderstorm":
                        imageWeather.setImageResource(R.drawable.storm);
                        break;
                    case "Snow":
                        imageWeather.setImageResource(R.drawable.snowy);
                        break;
                }
                String weatherRecommend = "";
                if (weather.getMain().equals("Rain") || weather.getMain().equals("Thunderstorm")) {
                    if (weather.getHumidity() > 80 || weather.getSpeed() > 15) {
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
            else {
                updateWeather.setVisibility(View.VISIBLE);
            }
        }
        else {
            weatherLayout.setVisibility(View.GONE);
            lostLayout.setVisibility(View.VISIBLE);
            weatherCard.setClickable(false);
        }
    }

    @Override
    public void onConnectivityChanged(boolean isConnected) {
        if(isConnected){
            requireActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    initWeatherForecast();
                    weatherCard.setClickable(true);
                }
            });
        } else {
            requireActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    weatherLayout.setVisibility(View.GONE);
                    lostLayout.setVisibility(View.VISIBLE);
                    weatherCard.setClickable(false);
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        networkUtils.unregister();
    }

    private void initRecyclerView() {
        ArrayList<UserCrops> userCrops = (ArrayList<UserCrops>) db.userCropDao().getRecentUserCrops();
        if(userCrops.size() > 0) {
            plansListView.setVisibility(View.VISIBLE);
            txtEmpty.setVisibility(View.GONE);
            PlanListAdapter planListAdapter = new PlanListAdapter(userCrops, getActivity());
            plansListView.setAdapter(planListAdapter);
            plansListView.setLayoutManager(new LinearLayoutManager(getActivity()));

            //Divider
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
            plansListView.addItemDecoration(dividerItemDecoration);
        } else {
            plansListView.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
        }
    }

    private void initListener() {
        fertilizerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FertilizerCalculate.class));
            }
        });
        planCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PlanGenerate.class));
            }
        });

        weatherCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WeatherActivity.class));
            }
        });
    }

    private void initSwipeCard() {
        SwipeViewAdapter swipeViewAdapter = new SwipeViewAdapter(swipeModels, getContext());
        InfiniteLoopViewPager2Adapter infiniteAdapter = new InfiniteLoopViewPager2Adapter(swipeViewAdapter);
        viewPager.setAdapter(infiniteAdapter);
        viewPager.setPadding(16, 0, 16, 0);
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(3);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPager.setPageTransformer(new ZoomOutPageTransformer());
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateIndicators(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 5000);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    };


    private void initView(View view) {
        fertilizerCard = view.findViewById(R.id.fertilizerCard);
        planCard = view.findViewById(R.id.planCard);
        plansListView = view.findViewById(R.id.plansListView);
        txtEmpty = view.findViewById(R.id.txtEmpty);
        viewPager = view.findViewById(R.id.viewPager);
        indicatorLayout = view.findViewById(R.id.indicatorLayout);
        weatherLayout = view.findViewById(R.id.weatherLayout);
        lostLayout = view.findViewById(R.id.lostLayout);
        txtDate = view.findViewById(R.id.txtDate);
        txtTemp = view.findViewById(R.id.txtTemp);
        txtWind = view.findViewById(R.id.txtWind);
        txtHumidity = view.findViewById(R.id.txtHumidity);
        txtWeatherRecommend = view.findViewById(R.id.txtWeatherRecommend);
        txtWeatherDes = view.findViewById(R.id.txtWeatherDes);
        updateWeather = view.findViewById(R.id.updateWeather);
        weatherCard = view.findViewById(R.id.weatherCard);
        imageWeather = view.findViewById(R.id.imageWeather);
        db = RiceGrowDatabase.getInstance(getActivity());
        swipeModels = new ArrayList<>();
        swipeModels.add(new SwipeModel(getString(R.string.rice_varieties), R.drawable.rice));
        swipeModels.add(new SwipeModel(getString(R.string.pests), R.drawable.pests_management));
        swipeModels.add(new SwipeModel(getString(R.string.diseases), R.drawable.disease_management));
        swipeModels.add(new SwipeModel(getString(R.string.weeds), R.drawable.weed_management));
        swipeModels.add(new SwipeModel(getString(R.string.deficiencies_and_toxicities), R.drawable.deficienciesandtoxicities));
        swipeModels.add(new SwipeModel(getString(R.string.pesticides), R.drawable.pesticides_management));
        swipeModels.add(new SwipeModel(getString(R.string.fertilizers), R.drawable.fertilizers_application));
    }

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 5000);
        initWeatherForecast();
    }



    public static class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(@NonNull View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1 || position > 1) {
                view.setAlpha(0f);
            } else {
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;

                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
                view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
            }
        }
    }

    private void createIndicators(int size) {
        // Get the actual number of items in the adapter
        int actualItemCount = getActualItemCount();

        for (int i = 0; i < actualItemCount; i++) {
            ImageView indicator = (ImageView) LayoutInflater.from(getContext())
                    .inflate(R.layout.item_indicator, indicatorLayout, false);
            indicatorLayout.addView(indicator);
        }
    }

    private void updateIndicators(int position) {
        // Get the actual number of items in the adapter
        int actualItemCount = getActualItemCount();

        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            ImageView indicator = (ImageView) indicatorLayout.getChildAt(i);
            // Calculate the correct position of the indicators based on the current page position modulo the actual item count
            int realPosition = position % actualItemCount;
            if (i == realPosition) {
                indicator.setImageResource(R.drawable.indicator_selected);
            } else {
                indicator.setImageResource(R.drawable.indicator_unselected);
            }
        }
    }

    private int getActualItemCount() {
        // Get the actual number of items in the original adapter (before wrapping in the InfiniteLoopViewPager2Adapter)
        return swipeModels.size();
    }

    public class InfiniteLoopViewPager2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private RecyclerView.Adapter originalAdapter;

        public InfiniteLoopViewPager2Adapter(RecyclerView.Adapter adapter) {
            this.originalAdapter = adapter;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return originalAdapter.onCreateViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            int realPosition = position % originalAdapter.getItemCount();
            originalAdapter.onBindViewHolder(holder, realPosition);
        }

        @Override
        public int getItemCount() {
            // Return a large value to enable infinite loop swiping
            return Integer.MAX_VALUE;
        }

        @Override
        public int getItemViewType(int position) {
            int realPosition = position % originalAdapter.getItemCount();
            return originalAdapter.getItemViewType(realPosition);
        }
    }


}
