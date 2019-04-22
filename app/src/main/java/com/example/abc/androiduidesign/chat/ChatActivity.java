package com.example.abc.androiduidesign.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.abc.androiduidesign.R;

public class ChatActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        toolbar = findViewById(R.id.toolbara);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pavan Paraskar");
        toolbar.setSubtitle("online 01:23");
        toolbar.setLogo(R.drawable.iconp);


    }
}
