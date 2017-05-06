
package com.myworks.jithin.malappuram.webservice.webmodels.main_category.list_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("package_id")
    @Expose
    private String packageId;
    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("district_id")
    @Expose
    private String districtId;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("list_name")
    @Expose
    private String listName;
    @SerializedName("list_slug")
    @Expose
    private String listSlug;
    @SerializedName("list_description")
    @Expose
    private String listDescription;
    @SerializedName("list_cover")
    @Expose
    private String listCover;
    @SerializedName("lat_long")
    @Expose
    private String latLong;
    @SerializedName("list_category")
    @Expose
    private String listCategory;
    @SerializedName("list_subcategory")
    @Expose
    private String listSubcategory;
    @SerializedName("list_subsub")
    @Expose
    private String listSubsub;
    @SerializedName("list_contact")
    @Expose
    private String listContact;
    @SerializedName("list_email")
    @Expose
    private String listEmail;
    @SerializedName("list_address")
    @Expose
    private String listAddress;
    @SerializedName("list_website")
    @Expose
    private String listWebsite;
    @SerializedName("list_fax")
    @Expose
    private String listFax;
    @SerializedName("list_order")
    @Expose
    private String listOrder;
    @SerializedName("extras")
    @Expose
    private String extras;
    @SerializedName("photo_limit")
    @Expose
    private String photoLimit;
    @SerializedName("offer_limit")
    @Expose
    private Object offerLimit;
    @SerializedName("offer_posted")
    @Expose
    private Object offerPosted;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;
    @SerializedName("is_active")
    @Expose
    private String isActive;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cover")
    @Expose
    private Object cover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListSlug() {
        return listSlug;
    }

    public void setListSlug(String listSlug) {
        this.listSlug = listSlug;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }

    public String getListCover() {
        return listCover;
    }

    public void setListCover(String listCover) {
        this.listCover = listCover;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public String getListCategory() {
        return listCategory;
    }

    public void setListCategory(String listCategory) {
        this.listCategory = listCategory;
    }

    public String getListSubcategory() {
        return listSubcategory;
    }

    public void setListSubcategory(String listSubcategory) {
        this.listSubcategory = listSubcategory;
    }

    public String getListSubsub() {
        return listSubsub;
    }

    public void setListSubsub(String listSubsub) {
        this.listSubsub = listSubsub;
    }

    public String getListContact() {
        return listContact;
    }

    public void setListContact(String listContact) {
        this.listContact = listContact;
    }

    public String getListEmail() {
        return listEmail;
    }

    public void setListEmail(String listEmail) {
        this.listEmail = listEmail;
    }

    public String getListAddress() {
        return listAddress;
    }

    public void setListAddress(String listAddress) {
        this.listAddress = listAddress;
    }

    public String getListWebsite() {
        return listWebsite;
    }

    public void setListWebsite(String listWebsite) {
        this.listWebsite = listWebsite;
    }

    public String getListFax() {
        return listFax;
    }

    public void setListFax(String listFax) {
        this.listFax = listFax;
    }

    public String getListOrder() {
        return listOrder;
    }

    public void setListOrder(String listOrder) {
        this.listOrder = listOrder;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getPhotoLimit() {
        return photoLimit;
    }

    public void setPhotoLimit(String photoLimit) {
        this.photoLimit = photoLimit;
    }

    public Object getOfferLimit() {
        return offerLimit;
    }

    public void setOfferLimit(Object offerLimit) {
        this.offerLimit = offerLimit;
    }

    public Object getOfferPosted() {
        return offerPosted;
    }

    public void setOfferPosted(Object offerPosted) {
        this.offerPosted = offerPosted;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getCover() {
        return cover;
    }

    public void setCover(Object cover) {
        this.cover = cover;
    }

}
