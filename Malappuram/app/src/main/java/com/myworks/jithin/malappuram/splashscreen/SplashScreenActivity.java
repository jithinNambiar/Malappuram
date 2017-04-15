package com.myworks.jithin.malappuram.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent);

            }
        },SPLASH_TIME_OUT);
    }




}
