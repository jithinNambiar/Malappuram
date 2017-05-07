package com.myworks.jithin.malappuram.main_category;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.helper.ConstantService;
import com.myworks.jithin.malappuram.model.MainCategoryItems;
import com.myworks.jithin.malappuram.news.NewsActivity;
import com.myworks.jithin.malappuram.notification.NotificationActivity;
import com.myworks.jithin.malappuram.profile.ProfileActivity;
import com.myworks.jithin.malappuram.register.RegisterActivity;
import com.myworks.jithin.malappuram.sub_category.SubCategoryActivity;
import com.myworks.jithin.malappuram.webservice.ApiService;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.MainCategory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.Mcategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainCategoryActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    MainCategoryItems mainCategoryItems ;
    List<MainCategoryItems> items= new ArrayList<>();
    private TextView register,profile,location,tittle;
    private HomeRecyclerAdapter adapter;
    private Toolbar toolbar;
    final Random mRandom = new Random(System.currentTimeMillis());
    private ProgressDialog progressDialog;
    private String id = "";
    private ImageButton home,category,news,notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_category_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);
        home = (ImageButton) findViewById(R.id.iv_home);
        category = (ImageButton) findViewById(R.id.iv_categories_home);
        news = (ImageButton) findViewById(R.id.iv_news);
        notification = (ImageButton) findViewById(R.id.iv_notification);
        register = (TextView) findViewById(R.id.tv_sign_in_label);
        location = (TextView) findViewById(R.id.tv_location);
        profile = (TextView) findViewById(R.id.tv_login_name);
        tittle = (TextView) findViewById(R.id.tv_toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_button);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(" ");
        tittle.setText("Main Category");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        recyclerView.setHasFixedSize(true);
        adapter = new HomeRecyclerAdapter(getApplicationContext(),items);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        progressDialog = new ProgressDialog(this);
        home.setOnClickListener(this);
        category.setOnClickListener(this);
        news.setOnClickListener(this);
        notification.setOnClickListener(this);
//        register.setOnClickListener(this);
  //      profile.setOnClickListener(this);
//        location.setOnClickListener(this);
        prepareData();

        HomeRecyclerAdapter.MainCategorySelectedListener mainCategorySelectedListener = new HomeRecyclerAdapter.MainCategorySelectedListener() {
            @Override
            public void itemSelectedListener(String id) {
                Intent intent = new Intent(getApplicationContext(), SubCategoryActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        };
//        HomeRecyclerAdapter.MainCategorySelectedListener mainCategorySelectedListener = new HomeRecyclerAdapter.MainCategorySelectedListener() {
//            @Override
//            public void itemSelectedListener() {
//                Intent intent = new Intent(getApplicationContext(), SubCategoryActivity.class);
//                startActivity(intent);
//            }
//        };
        adapter.mainCategorySelectedListener = mainCategorySelectedListener;

    }
    public void prepareData() {
        progressDialog.setTitle("Loading..");
        progressDialog.show();
        Log.d("success", "entered prepared data");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://spotmyservice.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("success1", "retrofit builded");
        ApiService service = retrofit.create(ApiService.class);
        Log.d("success2", "service created");

        Call<Mcategory> call = service.getCategory();
        call.enqueue(new Callback<Mcategory>() {
            @Override
            public void onResponse(Call<Mcategory> call, Response<Mcategory> response) {
                Log.d("success3", "Entered loop");
                try {

                    List<MainCategory> categories = response.body().getCategories();

                    for (int i = 0; i < categories.size(); i++) {
                        final int randomColor = generateRandomPastelColor();
                        mainCategoryItems = new MainCategoryItems(categories.get(i).getName(),categories.get(i).getPic(),randomColor ,categories.get(i).getId().toString());
                        items.add(mainCategoryItems);

                    }
                    adapter.notifyDataSetChanged();
                    progressDialog.dismiss();
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<Mcategory> call, Throwable t) {
                Log.d("failure", "Entered loop");

            }
        });
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
    public int generateRandomPastelColor() {
        final int baseColor = Color.RED;

        final int red = (Color.red(baseColor) + mRandom.nextInt(256)) / 2;
        final int green = (Color.green(baseColor) + mRandom.nextInt(256)) / 2;
        final int blue = (Color.blue(baseColor) + mRandom.nextInt(256)) / 2;

        return Color.rgb(red, green, blue);
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
            case R.id.iv_notification:
                intent = new Intent(getApplication(), NotificationActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.tv_sign_in_label : intent =new Intent(getApplication(), RegisterActivity.class);
                                            finish();
                                            startActivity(intent);
            case R.id.tv_login_name    : intent =new Intent(getApplicationContext(), ProfileActivity.class)   ;
                                        finish();
                                        startActivity(intent);
                break;
            default:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
        }
    }


}
