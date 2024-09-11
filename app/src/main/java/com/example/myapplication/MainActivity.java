package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up ViewPager
        ViewPager viewPager = findViewById(R.id.viewPager);
        List<WeatherAndForecastFragment> fragmentList = new ArrayList<>();

        // Add three instances of WeatherAndForecastFragment to the ViewPager
        fragmentList.add(WeatherAndForecastFragment.newInstance("Location1", "Data1"));
        fragmentList.add(WeatherAndForecastFragment.newInstance("Location2", "Data2"));
        fragmentList.add(WeatherAndForecastFragment.newInstance("Location3", "Data3"));

        // Set up the adapter
        WeatherPagerAdapter adapter = new WeatherPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);

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
