package com.example.sarah.javapart2.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sarah.javapart2.model.backend.Backend;
import com.example.sarah.javapart2.model.backend.BackendFactory;


/**
 * splash activity, in between activity,
 * waits for all the trips to be loaded
 * and then passes the user to the main activity
 */

public class SplashActivity extends AppCompatActivity {

    Backend instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        instance = BackendFactory.getInstance(getApplicationContext());


        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    //while rides are still being read from fire base
                    while(!instance.isComplete()) {
                        sleep(500);
                    }
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

}
