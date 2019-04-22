package com.example.abc.androiduidesign.signin_signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.abc.androiduidesign.R;

/**
 * Created by ABC on 31-12-2018.
 */

public class SignIn_SignUP extends AppCompatActivity {
    Button btnSignIn, btnSignUP;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_signup_btn);

        btnSignIn = findViewById(R.id.button32);
        btnSignUP = findViewById(R.id.button3);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignIn.class));
            }
        });

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }
}
