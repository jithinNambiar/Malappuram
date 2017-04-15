package com.myworks.jithin.malappuram.webservice.webmodels.main_category.childcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jithin on 26/3/17.
 */

public class CCateogory {
    @SerializedName("child")
    @Expose
    private List<ChildCategory> child = null;

    public List<ChildCategory> getChild() {
        return child;
    }

    public void setChild(List<ChildCategory> child) {
        this.child = child;
    }
}
