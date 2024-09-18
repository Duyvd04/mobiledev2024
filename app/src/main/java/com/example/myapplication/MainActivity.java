package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use ViewPager2 instead of ViewPager
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // List of fragments for different cities
        List<WeatherAndForecastFragment> fragmentList = new ArrayList<>();
        fragmentList.add(WeatherAndForecastFragment.newInstance("Hanoi", "Data for Hanoi"));
        fragmentList.add(WeatherAndForecastFragment.newInstance("Ho Chi Minh", "Data for Ho Chi Minh"));
        fragmentList.add(WeatherAndForecastFragment.newInstance("Paris", "Data for Paris"));

        // Adapter for ViewPager2
        WeatherPagerAdapter adapter = new WeatherPagerAdapter(this, fragmentList);
        viewPager.setAdapter(adapter);

        // Set up TabLayout with ViewPager2
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // Attach TabLayout with ViewPager2 using TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Hanoi");
                        break;
                    case 1:
                        tab.setText("Ho Chi Minh");
                        break;
                    case 2:
                        tab.setText("Paris");
                        break;
                }
            }
        }).attach();

        // Register page change callback
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.i("Weather", "Page selected: " + position);
            }
        });

        Log.i(TAG, "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called");
    }
}
