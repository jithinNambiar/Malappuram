package com.myworks.jithin.malappuram.webservice.webmodels.main_category.subcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jithin on 26/3/17.
 */

public class SCategory {
    @SerializedName("subs")
    @Expose
    private List<SubCategory> subs = null;

    public List<SubCategory> getSubs() {
        return subs;
    }

    public void setSubs(List<SubCategory> subs) {
        this.subs = subs;
    }

}
