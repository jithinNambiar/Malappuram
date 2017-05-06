package com.myworks.jithin.malappuram.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.main_category.MainCategoryActivity;
import com.myworks.jithin.malappuram.notification.NotificationActivity;

public class NewsActivity extends AppCompatActivity  implements View.OnClickListener{
    private ImageButton home,category,news,notification;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        home = (ImageButton) findViewById(R.id.iv_home);
        category = (ImageButton) findViewById(R.id.iv_categories_home);
        news = (ImageButton) findViewById(R.id.iv_news);
        notification = (ImageButton) findViewById(R.id.iv_notification);
        toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        loadToolbar();
        home.setOnClickListener(this);
        category.setOnClickListener(this);
        news.setOnClickListener(this);
        notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_home:
                intent = new Intent(getApplication(), MainActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.iv_categories_home:
                intent = new Intent(getApplication(), MainCategoryActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.iv_notification:
                intent = new Intent(getApplication(), NotificationActivity.class);
                finish();
                startActivity(intent);
                break;
            default:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
        }
    }
     private void loadToolbar(){
         setSupportActionBar(toolbar);
         getSupportActionBar().setHomeButtonEnabled(true);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setDisplayShowHomeEnabled(true);
         getSupportActionBar().setTitle("News Activity");
     }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
