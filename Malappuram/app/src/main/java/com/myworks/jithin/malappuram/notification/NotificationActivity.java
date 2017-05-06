package com.myworks.jithin.malappuram.notification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.main_category.MainCategoryActivity;
import com.myworks.jithin.malappuram.news.NewsActivity;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.MainCategory;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home,category,news,notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        home = (ImageButton) findViewById(R.id.iv_home);
        category = (ImageButton) findViewById(R.id.iv_categories_home);
        news = (ImageButton) findViewById(R.id.iv_news);
        notification = (ImageButton) findViewById(R.id.iv_notification);
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
            case R.id.iv_news:
                intent = new Intent(getApplication(), NewsActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.iv_categories_home:
                intent = new Intent(getApplication(), MainCategoryActivity.class);
                finish();
                startActivity(intent);
                break;
            default:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
        }
    }
}
