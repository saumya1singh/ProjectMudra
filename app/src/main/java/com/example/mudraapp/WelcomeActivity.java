package com.example.mudraapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        int SPLASH_LENGHT= 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i= new Intent(getBaseContext() , MainActivity.class);
                startActivity(i);
                finish();
            }
        } , SPLASH_LENGHT );
    }
}
