package com.example.abc.androiduidesign;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_nav_activity);
        Toast.makeText(getApplicationContext(), "OnCreate()", Toast.LENGTH_SHORT).show();
        textView = findViewById(R.id.textviewaa);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /* *
           * *
           * * *
           * * * *
           */
      /*  for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print("*");
            }
            System.out.println("\n");
        }*/


      /*
      ****
      *  *
      *  *
      ****
*/
        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= 4; j++) {
                if (i == 1 || i == 4 || j == 1 || j == 4) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }


            }
            System.out.println("");

        }


       /*
        1234
        2341
        3412
        4123
        */

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= 4; j++) {

                int k = i + j - 1;
                if (k > 4) {
                    System.out.print(k - 4);

                } else {
                    System.out.print(k);
                }


            }
            System.out.println("");

        }
/*


        1
        01
        101
        0101
        10101
*/
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {


                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");

                } else {
                    System.out.print("0 ");
                }


            }
            System.out.println("");

        }

/*
        1
        22
        333
        4444
        55555*/
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(i + " ");

            }
            System.out.println("");

        }


        // fabonassi series....

        int k,a,b;
        k=0;
        a=1;
        b=1;
        System.out.print(k+", 1, 1 ,");

        while(k<=50){

            k=a+b;
            System.out.print(k +" ");
            a=b;
            b=k;
        }

       /* ProgressBar progressBar = (ProgressBar) findViewById(R.id.spin_kit);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "OnStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "OnResume()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "OnPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "OnStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "OnDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "ONRestart()", Toast.LENGTH_SHORT).show();
    }
}
