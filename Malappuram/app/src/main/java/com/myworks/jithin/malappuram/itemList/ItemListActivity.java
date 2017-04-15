package com.myworks.jithin.malappuram.itemList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.childcategory.ChildCategoryActivity;
import com.myworks.jithin.malappuram.childcategory.ChildCategoryDetail;

public class ItemListActivity extends AppCompatActivity {
    private CardView cv1,cv2,cv3,cv4;
    private ImageButton iv1,iv2,iv3,iv4;
    private Toolbar toolbar;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        iv1 = (ImageButton) findViewById(R.id.iv_item1);
        iv2 = (ImageButton) findViewById(R.id.iv_item2);
        iv3 = (ImageButton) findViewById(R.id.iv_item3);
        iv4 = (ImageButton) findViewById(R.id.iv_item4);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mProgress = new ProgressDialog(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mProgress.show();
        loadImages();
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChildCategoryDetail.class);
                startActivity(intent);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChildCategoryDetail.class);
                startActivity(intent);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChildCategoryDetail.class);
                startActivity(intent);
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChildCategoryDetail.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, ChildCategoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void loadImages (){
        Glide.with(getApplicationContext()).load("https://ethnickart.files.wordpress.com/2015/03/maheshwari-sarees-post.png").into(iv1);
        Glide.with(getApplicationContext()).load("http://www.maebag.com/images/big-0909-6007.jpg").into(iv2);
        Glide.with(getApplicationContext()).load("http://imshopping.rediff.com/imgshop/800-1280/shopping/pixs/16995/1/1003_55069799b653e._vandv-summer-cool-cotton-embroidery-yellow-churidar-dress-material.jpg").into(iv3);
        Glide.with(getApplicationContext()).load("http://orig04.deviantart.net/8f17/f/2013/247/6/e/indian_saree_model_png_file_by_theartist100-d6l0thi.png").into(iv4);
            mProgress.cancel();
    }
}
