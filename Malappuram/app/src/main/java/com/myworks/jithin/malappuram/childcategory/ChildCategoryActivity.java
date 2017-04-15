package com.myworks.jithin.malappuram.childcategory;

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
import com.myworks.jithin.malappuram.itemList.ItemListActivity;
import com.myworks.jithin.malappuram.main_category.HomeRecyclerAdapter;
import com.myworks.jithin.malappuram.model.ChildCateogryItems;
import com.myworks.jithin.malappuram.model.MainCategoryItems;
import com.myworks.jithin.malappuram.model.SubCateogryItems;
import com.myworks.jithin.malappuram.sub_category.SubCategoryActivity;
import com.myworks.jithin.malappuram.webservice.ApiService;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.childcategory.CCateogory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.childcategory.ChildCategory;
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

public class ChildCategoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ChildCateogryItems childCateogryItems ;
    List<ChildCateogryItems> items= new ArrayList<>();
    private ChildCategoryAdapter adapter;
    private Toolbar toolbar;
    final Random mRandom = new Random(System.currentTimeMillis());
    private ProgressDialog mProgress;
    public  String id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_child);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        id = getIntent().getStringExtra("id");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_child);
        recyclerView.setHasFixedSize(true);
        adapter = new ChildCategoryAdapter(getApplicationContext(),items);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        mProgress = new ProgressDialog(this);
        prepareData();
        ChildCategoryAdapter.ChildcategoryAdapterListener childcategoryAdapterListener = new ChildCategoryAdapter.ChildcategoryAdapterListener() {
            @Override
            public void childCategortyAdapterListener() {
                Intent intent = new Intent(getApplicationContext(),ItemListActivity.class);
                startActivity(intent);
            }
        };
        adapter.childcategoryAdapterListener = childcategoryAdapterListener;
    }
    public void prepareData() {
        mProgress.setTitle("Loading..");
        mProgress.show();
        Log.d("success", "entered prepared data");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://spotmyservice.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("success1", "retrofit builded");
        ApiService service = retrofit.create(ApiService.class);
        Log.d("success2", "service created");
        Call<CCateogory> cCateogoryCall = service.getChildCategory(id);
        cCateogoryCall.enqueue(new Callback<CCateogory>() {
            @Override
            public void onResponse(Call<CCateogory> call, Response<CCateogory> response) {
              try{
                  List<ChildCategory> childCategories = response.body().getChild();
                  for (int i = 0; i< childCategories.size();i++){
                      final int randomColor = generateRandomPastelColor();
                      childCateogryItems = new ChildCateogryItems(childCategories.get(i).getName(),childCategories.get(i).getPic() ,randomColor);
                      items.add(childCateogryItems);
                  }
                  adapter.notifyDataSetChanged();
                  mProgress.dismiss();
              }
              catch (Exception e){

              }
            }

            @Override
            public void onFailure(Call<CCateogory> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, SubCategoryActivity.class);
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
