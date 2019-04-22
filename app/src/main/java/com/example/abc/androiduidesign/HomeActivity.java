package com.example.abc.androiduidesign;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.abc.androiduidesign.Content_slidder.ContentSliderActivity;
import com.example.abc.androiduidesign.chat.ChatActivity;
import com.example.abc.androiduidesign.fingerprint_auth.FingerAuthActivity;
import com.example.abc.androiduidesign.image_slider.ImageSliderActivity;
import com.example.abc.androiduidesign.login_tab.LoginTabMAinActivity;
import com.example.abc.androiduidesign.signin_signup.SignIn_SignUP;
import com.example.abc.androiduidesign.sqlite.SqliteMainActivity;
import com.example.abc.androiduidesign.volley_json.JsonMainActivity;

public class HomeActivity extends AppCompatActivity {

    Button btnLoginTab, btnImageSliding, btn_sqlite, btn_json, btn_finger_print, btn_signin_signup;
    Button btnChat, btnContentSlider, btnCustomLogin, btnSketchApp,btnBaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(getApplicationContext(), "oncreate", Toast.LENGTH_LONG).show();
        btnLoginTab = findViewById(R.id.btn_login_tab);
        btnImageSliding = findViewById(R.id.btn_image_slider);
        btn_sqlite = findViewById(R.id.btn_sqlite);
        btn_json = findViewById(R.id.btn_json);
        btn_finger_print = findViewById(R.id.btn_finger_print);
        btn_signin_signup = findViewById(R.id.btn_signin_signup);
        btnChat = findViewById(R.id.btnChat);
        btnContentSlider = findViewById(R.id.btnContentSlider);
        btnCustomLogin = findViewById(R.id.btnCustomLogin);
        btnSketchApp = findViewById(R.id.btnSketchApp);
        btnBaner=findViewById(R.id.btnBaner);
        btn_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SqliteMainActivity.class));
            }
        });
        btnLoginTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginTabMAinActivity.class));
            }
        });
        btnImageSliding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ImageSliderActivity.class));
            }
        });

        btn_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), JsonMainActivity.class));
            }
        });
        btn_finger_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FingerAuthActivity.class));
            }
        });

        btn_signin_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignIn_SignUP.class));
            }
        });
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChatActivity.class));


            }
        });

        btnContentSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ContentSliderActivity.class));
            }
        });

        btnCustomLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CustomButtnActivity.class));
            }
        });

        btnSketchApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SketchActivity.class));
            }
        });

        btnBaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BannerActivity.class));
            }
        });
        Log.d("message", "The onCreate() event");

    }


    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message", "The onStart() event");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message", "The onResume() event");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message", "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message", "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("message", "The onDestroy() event");
    }
}
