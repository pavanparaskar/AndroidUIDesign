package com.example.abc.androiduidesign.image_slider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abc.androiduidesign.R;

public class ImageSliderActivity extends AppCompatActivity {
    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_image_slider);
        viewPager = findViewById(R.id.viewPager);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
    }
}
