package com.myworks.jithin.malappuram.sub_category;

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

import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.childcategory.ChildCategoryActivity;
import com.myworks.jithin.malappuram.main_category.HomeRecyclerAdapter;
import com.myworks.jithin.malappuram.main_category.MainCategoryActivity;
import com.myworks.jithin.malappuram.model.MainCategoryItems;
import com.myworks.jithin.malappuram.model.SubCateogryItems;
import com.myworks.jithin.malappuram.webservice.ApiService;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.MainCategory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.Mcategory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.subcategory.SCategory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.subcategory.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubCategoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    SubCateogryItems subCateogryItems ;
    List<SubCateogryItems> items= new ArrayList<>();
    private SubCategoryAdapter adapter;
    private Toolbar toolbar;
    final Random mRandom = new Random(System.currentTimeMillis());
    private ProgressDialog mProgress;

    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_sub);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mProgress = new ProgressDialog(this);
        Bundle bundle = getIntent().getExtras();
         id = bundle.getString("id").toString();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_sub);
        recyclerView.setHasFixedSize(true);
        adapter = new SubCategoryAdapter(getApplicationContext(),items);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        prepareData();
//        SubCategoryAdapter.SubCategoryAdapterListener subCategoryAdapterListener = new SubCategoryAdapter.SubCategoryAdapterListener() {
//            @Override
//            public void subCatAdapterListener() {
//                Intent intent = new Intent(getApplicationContext(), ChildCategoryActivity.class);
//                startActivity(intent);
//            }
//        };
        SubCategoryAdapter.SubCategoryAdapterListener subCategoryAdapterListener = new SubCategoryAdapter.SubCategoryAdapterListener() {
            @Override
            public void subCatAdapterListener(String id) {
                Intent intent = new Intent(getApplicationContext(), ChildCategoryActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        };
        adapter.subCategoryAdapterListener = subCategoryAdapterListener;
    }
    public void prepareData() {
        mProgress.setTitle("Loading");
        mProgress.show();
        Log.d("success", "entered prepared data");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://spotmyservice.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("success1", "retrofit builded");
        ApiService service = retrofit.create(ApiService.class);
        Log.d("success2", "service created");
       Call<SCategory> categoryCall = service.getSubCategory(id);
        categoryCall.enqueue(new Callback<SCategory>() {
            @Override
            public void onResponse(Call<SCategory> call, Response<SCategory> response) {
                try{
                    List<SubCategory> categories = response.body().getSubs();
                    for(int i =0; i<categories.size();i++){
                        final int randomColor = generateRandomPastelColor();
                        subCateogryItems = new SubCateogryItems(categories.get(i).getName(),categories.get(i).getPic(),randomColor ,categories.get(i).getId().toString());
                        items.add(subCateogryItems);
                    }
                    adapter.notifyDataSetChanged();
                    mProgress.dismiss();
                }
                catch (Exception e){

                }

            }

            @Override
            public void onFailure(Call<SCategory> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
               // Intent intent = new Intent(this, MainActivity.class);
                Intent intent = new Intent(getApplicationContext(), MainCategoryActivity.class);
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
}
