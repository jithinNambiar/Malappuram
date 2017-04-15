package com.myworks.jithin.malappuram.model;

/**
 * Created by jithin on 26/3/17.
 */

public class ChildCateogryItems {
    private String item_name;
    private String image_url;
    private int mColor;
    public ChildCateogryItems(String item_name, String image_url ,int mColor) {
        this.item_name = item_name;
        this.image_url = image_url;
        this.mColor = mColor;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }
}
