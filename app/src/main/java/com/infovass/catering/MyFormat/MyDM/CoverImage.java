package com.infovass.catering.MyFormat.MyDM;

public class CoverImage {
    private String id;
    private String catererId;
    private String image;
    private String createdAt;
    private String updatedAt;
    private String coverImagePath;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCatererId() {
        return catererId;
    }
    public void setCatererId(String catererId) {
        this.catererId = catererId;
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
    public String getCoverImagePath() {
        return coverImagePath;
    }
    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }
}
