package com.myworks.jithin.malappuram.networkconnection;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;

public class NoInternetActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button try_conncetion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        try_conncetion = (Button) findViewById(R.id.bt_try_connecting);
        try_conncetion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(isNetworkAvailable()){
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    finish();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Check Network Connection",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
