package com.example.c0753560_mad3125_midterm;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity
{




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), FlightListAdaptor.class);
                    startActivity(intent);
                    finish();
                }
                catch
                (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
