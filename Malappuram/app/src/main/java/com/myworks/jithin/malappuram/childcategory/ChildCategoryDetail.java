package com.myworks.jithin.malappuram.childcategory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.itemList.ItemListActivity;
import com.squareup.picasso.Picasso;

public class ChildCategoryDetail extends AppCompatActivity {
    private ImageView iv_child_details;
    private Toolbar toolbar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_category_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        iv_child_details = (ImageView) findViewById(R.id.iv_child_detail);
        progressDialog = new ProgressDialog(this);
        loadImage();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, ItemListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void loadImage(){
        progressDialog.setTitle("Loading..");
        progressDialog.show();
        Glide.with(getApplicationContext()).load("http://164.100.83.8/wp-content/uploads/2014/09/sectors-textile-icon.png").into(iv_child_details);
        progressDialog.dismiss();
    }
    }
