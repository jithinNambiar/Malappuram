package com.myworks.jithin.malappuram;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myworks.jithin.malappuram.main_category.MainCategoryActivity;
import com.myworks.jithin.malappuram.networkconnection.NoInternetActivity;
import com.myworks.jithin.malappuram.news.NewsActivity;
import com.myworks.jithin.malappuram.notification.NotificationActivity;
import com.myworks.jithin.malappuram.profile.ProfileActivity;
import com.myworks.jithin.malappuram.register.RegisterActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    private ImageButton home,category,news,notification;
    private TextView login,register,tittle;
    private View navHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        home = (ImageButton) findViewById(R.id.iv_home);
        category = (ImageButton) findViewById(R.id.iv_categories_home);
        news = (ImageButton) findViewById(R.id.iv_news);
        notification = (ImageButton) findViewById(R.id.iv_notification);
        tittle = (TextView) findViewById(R.id.tv_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        tittle.setText("Malappuram App");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_browse_categories);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);
        login = (TextView) navHeader.findViewById(R.id.tv_login_name);
        register = (TextView) navHeader.findViewById(R.id.tv_sign_in_label);
        navigationView.setNavigationItemSelectedListener(this);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkAvailable()) {
                    Intent intent = new Intent(getApplicationContext(), MainCategoryActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), NoInternetActivity.class);
                    startActivity(intent);
                }
            }
        });

            home.setOnClickListener(this);
            category.setOnClickListener(this);
            news.setOnClickListener(this);
            notification.setOnClickListener(this);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    finish();
                    startActivity(intent);

                }
            });
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    finish();
                    startActivity(intent);

                }
            });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent intent ;
        switch(view.getId()){
            case R.id.iv_categories_home : intent = new Intent(getApplication(),MainCategoryActivity.class);
                                            startActivity(intent);
                break;
            case R.id.iv_news            : intent = new Intent(getApplication(),NewsActivity.class);
                                            startActivity(intent);
                break;
            case R.id.iv_notification    : intent = new Intent(getApplication(),NotificationActivity.class);
                                            startActivity(intent);
                break;


            default: intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
