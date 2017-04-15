package com.myworks.jithin.malappuram.webservice.webmodels.main_category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jithin on 24/3/17.
 */

public class Mcategory {
    @SerializedName("categories")
    @Expose
    private List<MainCategory> categories = null;

    public List<MainCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<MainCategory> categories) {
        this.categories = categories;
    }



}