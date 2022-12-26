package com.infovass.catering.MyFormat.MyDM;

public class Image {
    private String id;
    private String catererItemId;
    private String image;
    private String createdAt;
    private String updatedAt;
    private String itemLogoPath;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCatererItemId() {
        return catererItemId;
    }
    public void setCatererItemId(String catererItemId) {
        this.catererItemId = catererItemId;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
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
    public String getItemLogoPath() {
        return itemLogoPath;
    }
    public void setItemLogoPath(String itemLogoPath) {
        this.itemLogoPath = itemLogoPath;
    }
}
