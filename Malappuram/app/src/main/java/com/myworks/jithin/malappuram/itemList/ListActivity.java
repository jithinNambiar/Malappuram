package com.myworks.jithin.malappuram.itemList;

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

import com.myworks.jithin.malappuram.MainActivity;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.childcategory.ChildCategoryAdapter;
import com.myworks.jithin.malappuram.model.ChildCateogryItems;
import com.myworks.jithin.malappuram.model.ListItems;
import com.myworks.jithin.malappuram.news.NewsActivity;
import com.myworks.jithin.malappuram.notification.NotificationActivity;
import com.myworks.jithin.malappuram.sub_category.SubCategoryActivity;
import com.myworks.jithin.malappuram.webservice.ApiService;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.childcategory.CCateogory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.childcategory.ChildCategory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.list_items.ListData;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.list_items.MListData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    public String id;
    ListItems listItems;
    List<ListItems> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListViewAdapter adapter;
    private Toolbar toolbar;
    private ProgressDialog mProgress;
    private ImageButton home, category, news, notification;
    private ImageButton favourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_list);
        home = (ImageButton) findViewById(R.id.iv_home);
        category = (ImageButton) findViewById(R.id.iv_categories_home);
        news = (ImageButton) findViewById(R.id.iv_news);
        notification = (ImageButton) findViewById(R.id.iv_notification);
        toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        favourite = (ImageButton) findViewById(R.id.favourite);
        setSupportActionBar(toolbar);
        id = getIntent().getStringExtra("id");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_list);
        recyclerView.setHasFixedSize(true);
        adapter = new ListViewAdapter(getApplicationContext(), items);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        mProgress = new ProgressDialog(this);
        prepareData();
//        ChildCategoryAdapter.ChildcategoryAdapterListener childcategoryAdapterListener = new ChildCategoryAdapter.ChildcategoryAdapterListener() {
//            @Override
//            public void childCategortyAdapterListener() {
//                Intent intent = new Intent(getApplicationContext(),ItemListActivity.class);
//                startActivity(intent);
//            }
//        };
//        adapter.childcategoryAdapterListener = childcategoryAdapterListener;
        home.setOnClickListener(this);
        category.setOnClickListener(this);
        news.setOnClickListener(this);
        notification.setOnClickListener(this);

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
        Call<MListData> mListDataCall = service.getListData();
        mListDataCall.enqueue(new Callback<MListData>() {
            @Override
            public void onResponse(Call<MListData> call, Response<MListData> response) {
                try {
                    List<ListData> listItemses = response.body().getData();
                    for (int i = 0;i<5;i++) {
                        Log.d("imageURl", listItemses.get(i).getListCover());
                        listItems = new ListItems(listItemses.get(i).getListName(),listItemses.get(i).getListAddress(),listItemses.get(i).getDistrictId(),listItemses.get(i).getListCover(),5);
                        items.add(listItems);
                    }
                    adapter.notifyDataSetChanged();
                    mProgress.dismiss();
                } catch (Exception e) {
                    Log.d("Error_gelList", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<MListData> call, Throwable t) {
                Log.d("Failure", "not getting data");
            }
        });
//        cCateogoryCall.enqueue(new Callback<CCateogory>() {
//            @Override
//            public void onResponse(Call<CCateogory> call, Response<CCateogory> response) {
//                try{
//                    List<ChildCategory> childCategories = response.body().getChild();
//                    for (int i = 0; i< childCategories.size();i++){
//                       // childCateogryItems = new ChildCateogryItems(childCategories.get(i).getName(),childCategories.get(i).getPic() ,randomColor);
//                        items.add(childCateogryItems);
//                    }
//                    adapter.notifyDataSetChanged();
//                    mProgress.dismiss();
//                }
//                catch (Exception e){
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CCateogory> call, Throwable t) {
//
//            }
//        });
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
            default:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
        }
    }
}
