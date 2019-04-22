package com.example.abc.androiduidesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BannerActivity extends AppCompatActivity {
    TextView tvBaneer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        tvBaneer = findViewById(R.id.tvBanner);
        tvBaneer.setSelected(true);
    }
}
