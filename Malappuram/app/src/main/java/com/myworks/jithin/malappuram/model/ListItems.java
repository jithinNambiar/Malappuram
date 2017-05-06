package com.myworks.jithin.malappuram.model;

/**
 * Created by jithin on 29/4/17.
 */

public class ListItems {
    private String itemName,itemPlace,itemAddress,imageUrl;
    private int lastPageNumber;

    public ListItems(String itemName, String itemPlace, String itemAddress, String imageUrl, int lastPageNumber) {
        this.itemName = itemName;
        this.itemPlace = itemPlace;
        this.itemAddress = itemAddress;
        this.imageUrl = imageUrl;
        this.lastPageNumber = lastPageNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPlace() {
        return itemPlace;
    }

    public void setItemPlace(String itemPlace) {
        this.itemPlace = itemPlace;
    }

    public String getItemAddress() {
        return itemAddress;
    }

    public void setItemAddress(String itemAddress) {
        this.itemAddress = itemAddress;
    }

    public int getLastPageNumber() {
        return lastPageNumber;
    }

    public void setLastPageNumber(int lastPageNumber) {
        this.lastPageNumber = lastPageNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
