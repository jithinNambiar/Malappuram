package com.myworks.jithin.malappuram.webservice;

import com.myworks.jithin.malappuram.webservice.tourist_spots.MTSList;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.Mcategory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.childcategory.CCateogory;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.list_items.MListData;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.subcategory.SCategory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jithin on 24/3/17.
 */

public interface ApiService {

    @GET("get_categories")
    Call<Mcategory> getCategory();

    @GET("get_subcategories")
    Call<SCategory> getSubCategory(@Query("category") String id);

    @GET("get_childcategories")
    Call<CCateogory> getChildCategory(@Query("sub") String id);

    @GET("get_listings")
    Call<MListData> getListData();
    @GET("get_tourist_spots")
    Call<MTSList> getTouistSpots();
}
